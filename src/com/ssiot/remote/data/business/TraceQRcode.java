package com.ssiot.remote.data.business;

import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.SsiotResult;
import com.ssiot.remote.data.model.TraceQRcodeModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TraceQRcode{
    //iot_TracePesticides
    
    public List<TraceQRcodeModel> GetModelList(String strWhere) {
        StringBuilder strSql = new StringBuilder();
        strSql.append("select * ");
        strSql.append(" FROM iot_TraceQRcode ");
        if (strWhere.trim() != "") {
            strSql.append(" where " + strWhere);
        }
        SsiotResult sResult = DbHelperSQL.getInstance().Query(strSql.toString());
        List<TraceQRcodeModel> list = null;
        if (null != sResult && sResult.mRs != null){
            list = DataTableToList(sResult.mRs);
        }
        if (null != sResult){
            sResult.close();
        }
        return list;
    }
    
    private List<TraceQRcodeModel> DataTableToList(ResultSet c){
        List<TraceQRcodeModel> models = new ArrayList<TraceQRcodeModel>();
        TraceQRcodeModel m = new TraceQRcodeModel();
        try {
            while(c.next()){
                m = DataRowToModel(c);
                if (m != null){
                    models.add(m);
                }
            }
//            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;
    }
    
    private TraceQRcodeModel DataRowToModel(ResultSet c){
        TraceQRcodeModel m = new TraceQRcodeModel();
        try {
            m._traceqrcodeid = c.getInt("TraceQRcodeID");
            m._qrcode = c.getString("QRCode");
            m._traceprofilesid = c.getInt("TraceProfilesID");
            m._imgurl = c.getString("ImgUrl");
            return m;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
}