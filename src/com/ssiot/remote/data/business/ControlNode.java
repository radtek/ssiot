package com.ssiot.remote.data.business;

import android.text.TextUtils;

import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.SsiotResult;
import com.ssiot.remote.data.model.AreaModel;
import com.ssiot.remote.data.model.ControlNodeModel;
import com.ssiot.remote.data.model.view.ControlNodeViewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControlNode{
    
    //获取控制设备的扩展信息，包括某个控制节点下的设备数量
    public List<ControlNodeViewModel> GetControlNodesExtendInfoByAreaIds(String areaids) {
        List<ControlNodeViewModel> controlNodeView_list = new ArrayList<ControlNodeViewModel>();
        if (!TextUtils.isEmpty(areaids)) {
            SsiotResult sResult = GetControlNodesExtendInfoByAreaIds_dataaccess(areaids);
            if (null != sResult && null != sResult.mRs){
                try {
                    while(sResult.mRs.next()){
                        controlNodeView_list.add(DataRowToObjectModel(sResult.mRs));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != sResult){
                sResult.close();
            }
        }
        return controlNodeView_list;
    }
    
    public List<ControlNodeModel> GetModelList(String strWhere) {
        List<ControlNodeModel> list = null;
        SsiotResult sResult = GetList_dataaccess(strWhere);
        if (null != sResult && null != sResult.mRs){
            list = DataTableToList(sResult.mRs);
        }
        if (null != sResult){
            sResult.close();
        }
        return list;
    }
    
    //----------------------------------------------------
    private SsiotResult GetControlNodesExtendInfoByAreaIds_dataaccess(String areaids) {
        String whereAreaIDStr = "AreaID in ("+areaids+")";
        if ("0".equals(areaids)){//管理员 by jingbo
            whereAreaIDStr = " 1=1 ";
        } else {
            whereAreaIDStr = "AreaID in ("+areaids+")";
        }
        
        String sqlstr = "select CN.ID,CN.UniqueID,CN.NodeNo,CN.Remark,CN.AreaID,CN.Installation,CN.Color,CN.Longitude,CN.Latitude,CN.Image ,DC.DeviceCount from ( select * from ControlNode where "+whereAreaIDStr+")as CN left join ( select Count(DeviceNo) as DeviceCount, ControlNodeID from ControlDevice where ControlNodeID in (select ID from ControlNode where "+whereAreaIDStr+") group by ControlNodeID)as DC on CN.ID=DC.ControlNodeID";
        SsiotResult sResult = DbHelperSQL.getInstance().Query(sqlstr);
        return sResult; 
    }
    
    private SsiotResult GetList_dataaccess(String strWhere) {
        StringBuilder strSql = new StringBuilder();
        strSql.append("select ID,UniqueID,NodeName,NodeNo,Remark,AreaID,X,Y,Longitude,Latitude,Extern,Installation,Color,Image ");
        strSql.append(" FROM ControlNode ");
        if (!TextUtils.isEmpty(strWhere.trim())) {
            strSql.append(" where " + strWhere);
        }
        return DbHelperSQL.getInstance().Query(strSql.toString());
    }
    
    private List<ControlNodeModel> DataTableToList(ResultSet dt) {
        List<ControlNodeModel> modelList = new ArrayList<ControlNodeModel>();
        ControlNodeModel m = new ControlNodeModel();
        try {
            while(dt.next()){
                m = DataRowToModel(dt);
                if (m != null){
                    modelList.add(m);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelList;
    }
    
    private ControlNodeModel DataRowToModel(ResultSet c){
        ControlNodeModel m = new ControlNodeModel();
        try {
            m._id = Integer.parseInt(c.getString("ID"));
            m._uniqueid = c.getString("UniqueID");
            m._nodename = c.getString("NodeName");
            m._nodeno = c.getInt("NodeNo");
            m._remark = c.getString("Remark");
            m._areaid = c.getInt("AreaID");
            m._x = c.getString("X");
            m._y = c.getString("Y");
          //TODO
            m._image = c.getString("Image");
            //TODO
            return m;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    ////jingbo modified this ,move from mobileAPI
    public static ControlNodeViewModel DataRowToObjectModel(ResultSet c){
        ControlNodeViewModel m = new ControlNodeViewModel();
        try {
            m._id = Integer.parseInt(c.getString("ID"));
            m._uniqueid = c.getString("UniqueID");
//            m._nodename = c.getString("Remark");//NodeName
            m._nodeno = c.getInt("NodeNo");
            m._remark = c.getString("Remark");
            m._areaid = c.getInt("AreaID");
//            m._x = c.getString("X");
//            m._y = c.getString("Y");
          //TODO
            m._nodename = c.getString("Installation");//这个名字！！！！！！！！！！！！！！！！ TODO
            m._image = c.getString("Image");
            //TODO
            m._devicecount = c.getInt("DeviceCount");
            return m;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}