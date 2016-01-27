package com.ssiot.remote.data.business;

import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.SsiotResult;
import com.ssiot.remote.data.model.TraceProfileModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TraceProfiles{
    
    public List<TraceProfileModel> GetModelList(String strWhere) {
        StringBuilder strSql = new StringBuilder();
        strSql.append("select * ");
        strSql.append(" FROM iot_TraceProfiles ");
        if (strWhere.trim() != "") {
            strSql.append(" where " + strWhere);
        }
        SsiotResult sResult = DbHelperSQL.getInstance().Query(strSql.toString());
        List<TraceProfileModel> list = null;
        if (null != sResult && sResult.mRs != null){
            list = DataTableToList(sResult.mRs);
        }
        if (null != sResult){
            sResult.close();
        }
        return list;
    }
    
    public List<TraceProfileModel> DataTableToList(ResultSet c){
        List<TraceProfileModel> models = new ArrayList<TraceProfileModel>();
        TraceProfileModel m = new TraceProfileModel();
        try {
            while(c.next()){
                m = DataRowToModel(c);
                if (m != null){
                    models.add(m);
                }
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;
    }
    
    private TraceProfileModel DataRowToModel(ResultSet c){
        TraceProfileModel m = new TraceProfileModel();
        try {
            m._id = c.getInt("ProID");
            m._code = c.getString("ProCode");
            m._name = c.getString("ProName");
            m._batchno = c.getString("ProBatchNo");
            m._listingDate = c.getTimestamp("ProListingDate");
            m._image = c.getString("ProImage");
            m._comdescid = c.getInt("ProComDescID");
            m._descid = c.getInt("ProDescID");
            m._variety = c.getString("ProVariety");
            return m;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
}