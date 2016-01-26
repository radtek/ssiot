package com.ssiot.remote.data.business;

import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.model.TracePesticidesModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TracePesticides{
    //iot_TracePesticides
    
    public List<TracePesticidesModel> GetModelList(String strWhere) {
        StringBuilder strSql = new StringBuilder();
        strSql.append("select * ");
        strSql.append(" FROM iot_TracePesticides ");
        if (strWhere.trim() != "") {
            strSql.append(" where " + strWhere);
        }
        ResultSet ds = DbHelperSQL.Query(strSql.toString());
        if (null != ds){
            List<TracePesticidesModel> list = DataTableToList(ds);
            try {
                ds.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return list;
        }
        return null;
    }
    
    public List<TracePesticidesModel> DataTableToList(ResultSet c){
        List<TracePesticidesModel> models = new ArrayList<TracePesticidesModel>();
        TracePesticidesModel m = new TracePesticidesModel();
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
    
    private TracePesticidesModel DataRowToModel(ResultSet c){
        TracePesticidesModel m = new TracePesticidesModel();
        try {
            m._pesusedate = c.getString("PesUseDate");
            m._pesname = c.getString("PesName");
            m._pesdosage = c.getFloat("PesDosage");
            m._pesproid = c.getInt("PesProID");
            m._pesunit = c.getString("PesUnit");
            m._pesorderno = c.getInt("PesOrderNo");
            return m;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
}