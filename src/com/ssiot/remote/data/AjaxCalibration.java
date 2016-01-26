package com.ssiot.remote.data;

import android.text.TextUtils;
import android.util.Log;

import com.ssiot.remote.data.business.Node;
import com.ssiot.remote.data.business.Sensor;
import com.ssiot.remote.data.business.SensorModifyData;
import com.ssiot.remote.data.business.SettingInfo1;
import com.ssiot.remote.data.model.NodeModel;
import com.ssiot.remote.data.model.SensorModel;
import com.ssiot.remote.data.model.SensorModifyDataModel;
import com.ssiot.remote.data.model.SettingModel;
import com.ssiot.remote.data.model.view.SensorViewModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AjaxCalibration{
    private Sensor sensorBll = new Sensor();
    private SensorModifyData sensorModifyDataBll = new SensorModifyData();
    private Node nodeBll = new Node();
    private com.ssiot.remote.data.business.Setting settingbll = new com.ssiot.remote.data.business.Setting();
    
  //根据节点编号加载要素和通道
    public HashMap<String,ArrayList<Integer>> GetSensorInfoByNodeNo(String nodeNo){//jingbo 做了修改，只返回一个列表！ 例如（PH值，1001  0123）
        HashMap<String,ArrayList<Integer>> hashList = new HashMap<String,ArrayList<Integer>>();
        try {
            List<SensorViewModel> sensorView_list2 = new ArrayList<SensorViewModel>();
            if (!TextUtils.isEmpty(nodeNo)){
                sensorView_list2 = DataAPI.GetSensorListByNodeNoString(nodeNo);
                if (null != sensorView_list2 && sensorView_list2.size() > 0){
                    for (SensorViewModel m : sensorView_list2){
//                        strList.add(m._shortname + m._channel);
                        if (!hashList.containsKey(m._shortname + "," + m._sensorno)){
                            ArrayList<Integer> channels = new ArrayList<Integer>();
                            channels.add(m._channel);
                            hashList.put(m._shortname + "," + m._sensorno, channels);
                        } else {
                            hashList.get(m._shortname + "," + m._sensorno).add(m._channel);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashList;
    }
    
  //根据要素值（shortName）加载修正类型  
    private String GetModifyTypeBySensorName(String sensorName){//jingbo: 原先是返回两个字符串
        if (!TextUtils.isEmpty(sensorName)){
            SensorModel sensorModel = DataAPI.GetSensorModelBySensorName(sensorName);
            if (null != sensorModel){
                List<SensorModifyDataModel> sensorModifyData_list = sensorModifyDataBll.GetModelList("SensorNo=" + sensorModel._sensorno);
                boolean isBiaoDing = false;//标定
                boolean isJiaoZhun = false;//校准
                String respStr = "";
                for (SensorModifyDataModel modifyData :sensorModifyData_list){
                    switch (modifyData._type) {
                        case 1:
                            isBiaoDing = true;
                            break;
                        case 3:
                            isJiaoZhun = true;
                            break;
                        default:
                            break;
                    }
                    if (isBiaoDing && isJiaoZhun){
                        break;
                    }
                }
                if (isBiaoDing && isJiaoZhun){
                    respStr = "1,3";
                } else if (isBiaoDing){
                    respStr = "1";
                } else if (isJiaoZhun){
                    respStr = "3";
                }
                return respStr;
            }
        }
        return "";
    }
    
    public SettingModel GetJiaoZhunBySensorNameAndType(int nodeno, int type, int sensorNo, int channel){
        int sendState = 2;
        try {
            Log.v("AjaxCalibration", "--------"+nodeno + " " + sensorNo + channel);
            NodeModel nodeModel = DataAPI.GetNodeListByNodenolist(""+nodeno).get(0);
            String uniqueId = nodeModel._uniqueid;
            if (!TextUtils.isEmpty(uniqueId) && sensorNo > 0 && type > 0) {
                SettingModel settingModel = settingbll.GetSettigModel("UniqueID='" + uniqueId + "' and Type=" + type + 
                        " and SettingMark=" + sensorNo + " and Chanel=" + channel + " and SendState=" + sendState + " order by ID desc");
                return settingModel;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<SensorModifyDataModel> GetSensorModifyDataList(){
        return sensorModifyDataBll.GetModelList(" Type=3");
    }
    
    //现只用于标定 所以type=3
    public List<SensorModifyDataModel> GetSensorModifyDataListBySensorNameAndType(String name, String type){
        List<SensorModifyDataModel> sensorModifyDataList = new ArrayList<SensorModifyDataModel>();
        try {
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(type)){
                return sensorModifyDataList;
            } else {
                SensorModel sensorModel = DataAPI.GetSensorModelBySensorName(name);
                if (sensorModel._sensorno != 0) {
                    sensorModifyDataList = sensorModifyDataBll.GetModelList("SensorNo=" + sensorModel._sensorno + " and Type=" + type);
                }
                return sensorModifyDataList;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return sensorModifyDataList;
        }
    }
    
    
    //根据要素与类型加载修正值
    //nodeno节点编号(校准用)
    //channel通道（校准用）
    public ArrayList<String> GetModifyDataBySensorAndType(String sensorName, int modifyType, int nodeno, int channel){
        if (TextUtils.isEmpty(sensorName) || modifyType < 0){
            return null;
        } else {
            if (modifyType == 3){
                List<SensorModifyDataModel> sensorModifyData_list = MobileAPI.GetSensorModifyDataListBySensorNameAndType(sensorName,modifyType);
//                return sensorModifyData_list;
                ArrayList<String> ret = new ArrayList<String>();
                if (sensorModifyData_list != null){
                    for (SensorModifyDataModel m : sensorModifyData_list){
                        ret.add(m._id + ":" + m._remark);//jingbo 例如 5：标准液4
                    }
                }
                return ret;
            } else if (modifyType == 1){//校准
                if (nodeno >= 0 &&  channel >= 0){
                    //根据传感器名称获取传感器相关信息
                    SensorModel sensorModel = DataAPI.GetSensorModelBySensorName(sensorName);
                    //根据节点编号获取节点信息
                    NodeModel nodeModel = DataAPI.GetNodeListByNodenolist(""+nodeno).get(0);
                    //获取上次发送成功的校准信息
                    SettingModel settingModel = MobileAPI.GetJiaoZhunBySensorNameAndType(nodeModel._uniqueid, modifyType, sensorModel._sensorno, channel);
//                    return settingModel._value;
                    ArrayList<String> ret = new ArrayList<String>();
                    ret.add(""+settingModel._value);
                    return ret;
                }
            }
            return null;
        }
    }
    
    //发送保存校准数据
    public boolean SendModify(boolean isBiaoDing, int channel,int nodeNo2,float value, String sensorShortName){//jzValue 就是value 校准值
        try {
            NodeModel nodeModel = nodeBll.GetModelByNodeNo(""+nodeNo2);//获取节点信息
            SensorModel sensorObj = DataAPI.GetSensorModelBySensorName(sensorShortName);
            if (false == isBiaoDing){//校准
                
              //根据传感器名称获取传感器对象
                if (settingbll.Exists(nodeModel._uniqueid, 1, sensorObj._sensorno, channel)){//更新
                    SettingModel settingModel_New = settingbll.GetSettigModel("UniqueID='" + nodeModel._uniqueid + 
                            "' AND Type=1 and SettingMark=" + sensorObj._sensorno + " and Chanel=" + channel + " ORDER BY ID DESC");
                    settingModel_New._other = 0;
                    settingModel_New._value = value;
                    Timestamp dt = new Timestamp(System.currentTimeMillis());
                    settingModel_New._timespan = (int) dt.getTime()/1000;//TODO
                    settingModel_New._sendtime = dt;
                    settingModel_New._sendstate = 0; 
                    settingModel_New._resendcount = 0;
                    return settingbll.Update(settingModel_New);
                } else {//新增
                    SettingModel  settingModel_Add = new SettingModel();
                    settingModel_Add._uniqueid = nodeModel._uniqueid;
                    settingModel_Add._type = 1;
                    settingModel_Add._settingmark = sensorObj._sensorno;
                    settingModel_Add._chanel = channel;
                    settingModel_Add._other = 0; 
                    settingModel_Add._value = value;
                    Timestamp dt = new Timestamp(System.currentTimeMillis());
                    settingModel_Add._timespan = (int) dt.getTime()/1000;
                    settingModel_Add._sendtime = dt;
                    int count = settingbll.Add(settingModel_Add);
                    return count > 0;
                }
            } else {//标定 sensorModifyData表里的ID值
//                SensorModifyDataModel sensorModifyDataModel = sensorModifyDataBll.GetModel(modifyId);
                SettingModel settingModel = new SettingModel();
                settingModel._settingmark = sensorObj._sensorno;
                settingModel._chanel = channel;
                settingModel._other = 0;
                settingModel._type = 3;
                settingModel._uniqueid = nodeModel._uniqueid;
                settingModel._value = value;
                Timestamp dt = new Timestamp(System.currentTimeMillis());
                settingModel._timespan = (int) dt.getTime()/1000;
                settingModel._sendtime = dt;
                int count = settingbll.Add(settingModel);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //验证是否发送成功( 这种写法存在一定的风险：当多个人同时对这个点修改时可能出现反馈不准)
    public int ModifyIsOK(int type_yz, int channel_yz, int nodeno_yz, String shortName_yz){
        try {
            if (!TextUtils.isEmpty(shortName_yz) && type_yz >= 0 && channel_yz >= 0 && nodeno_yz >= 0){
                SensorModel sensorModel = DataAPI.GetSensorModelBySensorName(shortName_yz);
                NodeModel nodeModel = DataAPI.GetNodeListByNodenolist(""+nodeno_yz).get(0);
              //获取上次发送成功的校准信息
                SettingModel settingModel = settingbll.GetSettigModel("UniqueID='" + nodeModel._uniqueid 
                        + "' and Type=" + type_yz + " and SettingMark=" + sensorModel._sensorno + " and Chanel=" + channel_yz + " order by ID desc");
                return settingModel._sendstate;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 3;
    }
}