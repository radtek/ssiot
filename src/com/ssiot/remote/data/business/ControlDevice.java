package com.ssiot.remote.data.business;

import android.text.TextUtils;

import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.SsiotResult;
import com.ssiot.remote.data.model.ControlDeviceModel;
import com.ssiot.remote.data.model.view.ControlDeviceViewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControlDevice{
    
    public List<ControlDeviceModel> GetModelList(String strWhere){
        SsiotResult sResult = GetList_dataaccess(strWhere);
        List<ControlDeviceModel> list = null;
        if (null != sResult && null != sResult.mRs){
            list = DataTableToList(sResult.mRs);
        }
        if (null != sResult){
            sResult.close();
        }
        return list;
    }
    
    public List<ControlDeviceViewModel> GetControlDeviceInfo(int controlNodeId, String nodeUnique) {
        List<ControlDeviceViewModel> controlDeviceView_list = new ArrayList<ControlDeviceViewModel>();
        try {
            if(controlNodeId <= 0 || TextUtils.isEmpty(nodeUnique)) {
                throw new Exception(" Parameters Exception");
            }
            SsiotResult sResult = GetControlDeviceInfo_dataaccess(controlNodeId, nodeUnique);
            if (null != sResult && null != sResult.mRs) {
                ResultSet ds = sResult.mRs;
                while (ds.next()) {
                    ControlDeviceViewModel controlDeviceView = new ControlDeviceViewModel();
                    
                    controlDeviceView.DeviceID = ds.getInt("DeviceID");
                    controlDeviceView.ControlNodeID = ds.getInt("ControlNodeID");
                    controlDeviceView.DeviceNo = ds.getInt("DeviceNo");
                    controlDeviceView.DeviceName = ds.getString("DeviceName");
                    controlDeviceView.RunTime = ds.getInt("RunTime");
                    controlDeviceView.StartTime = ds.getString("StartTime");
                    controlDeviceView.ControlActionID = ds.getInt("ControlActionID");
                    controlDeviceView.ControlType = ds.getInt("ControlType");
                    controlDeviceView.CollectUniqueIDs = ds.getString("CollectUniqueIDs");
                    controlDeviceView.ControlCondition = ds.getString("ControlCondition");
                    controlDeviceView.OperateTime = ds.getTimestamp("OperateTime");
                    controlDeviceView.StateNow = ds.getInt("StateNow");
                    controlDeviceView.Operate = ds.getString("Operate");
                    
                    controlDeviceView_list.add(controlDeviceView);
                }
            }
            if (null != sResult){
                sResult.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return controlDeviceView_list;
    }
    
    public List<ControlDeviceModel> DataTableToList(ResultSet dt) 
    {
        List<ControlDeviceModel> modelList = new ArrayList<ControlDeviceModel>();
        ControlDeviceModel m = new ControlDeviceModel();
        try {
            while(dt.next()){
                m = DataRowToModel(dt);
                if (m != null){
                    modelList.add(m);
                }
            }
            dt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelList;
    }
    
    private ControlDeviceModel DataRowToModel(ResultSet c){
        ControlDeviceModel m = new ControlDeviceModel();
        try {
            m._id = Integer.parseInt(c.getString("ID"));
            m._controlnodeid = c.getInt("ControlNodeID");
            m._deviceno = c.getInt("DeviceNo");
            m._devicename = c.getString("DeviceName");
            m._devicetype = c.getString("DeviceType");  
            m._address = c.getString("Address");
            m._remark = c.getString("Remark");
            m._extern = c.getString("Extern");
            m._createtime = c.getTimestamp("CreateTime");
            m. _state = c.getString("State");
            return m;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    //-----------------------------
    
    
    private SsiotResult GetList_dataaccess(String strWhere) {
        StringBuilder strSql=new StringBuilder();
        strSql.append("select ID,ControlNodeID,DeviceNo,DeviceName,DeviceType,Address,Remark,Extern,CreateTime,State ");
        strSql.append(" FROM ControlDevice ");
        if(strWhere.trim()!="") {
            strSql.append(" where "+strWhere);
        }
        return DbHelperSQL.getInstance().Query(strSql.toString());
    }
    
    //line459
    private  SsiotResult GetControlDeviceInfo_dataaccess(int controlNodeId,String nodeUnique) {
        try {
            StringBuilder strSql = new StringBuilder();
            strSql.append("SELECT Tbl1.ID AS [DeviceID],Tbl1.ControlNodeID,Tbl1.DeviceNo,Tbl1.deviceName AS [DeviceName],CL.RunTime, CL.EditTime AS [StartTime],Tbl2.ID AS[ControlActionID],Tbl2.ControlType,Tbl2.CollectUniqueIDs,Tbl2.ControlCondition,Tbl2.OperateTime,Tbl2.StateNow,Tbl2.Operate FROM (SELECT ID,ControlNodeID,DeviceNo,deviceName FROM dbo.ControlDevice ");
            strSql.append("WHERE ControlNodeID=? ) Tbl1 ");
            strSql.append("LEFT JOIN ( SELECT  DeviceNo , RunTime ,  EditTime  FROM ( SELECT  DeviceNo , RunTime , EditTime , ROW_NUMBER() OVER ( PARTITION BY UniqueID, DeviceNo ORDER BY EditTime DESC ) AS rowNumber FROM ControlLog WHERE UniqueID =? AND DeviceNo IN ( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 ) ) TC WHERE rowNumber = 1 ) AS CL ON Tbl1.DeviceNo = CL.DeviceNo ");
            strSql.append("LEFT JOIN (SELECT  ID,DeviceNo,ControlType,CollectUniqueIDs,ControlCondition,OperateTime,StateNow,Operate FROM dbo.ControlActionInfo  ");
            strSql.append("WHERE UniqueID=?)Tbl2 ON Tbl1.DeviceNo=Tbl2.DeviceNo");
//            SqlParameter[] parameters = { new SqlParameter("@ControlNodeID", SqlDbType.Int, 4), new SqlParameter("@UniqueID", SqlDbType.Char, 8) };
//            parameters[0].Value = controlNodeId;
//            parameters[1].Value = nodeUnique;
            ArrayList<String> parameters = new ArrayList<String>();
            parameters.add(""+controlNodeId);
            parameters.add(nodeUnique);
            parameters.add(nodeUnique);
            return DbHelperSQL.getInstance().Query(strSql.toString(), parameters);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}