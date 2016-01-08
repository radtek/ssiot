package com.ssiot.remote.data.business;

import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.model.TraceCertificationModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TraceCertification{
    //iot_TraceCertification
    
    public List<TraceCertificationModel> GetModelList(String strWhere) {
        StringBuilder strSql = new StringBuilder();
        strSql.append("select * ");
        strSql.append(" FROM iot_TraceCertification ");
        if (strWhere.trim() != "") {
            strSql.append(" where " + strWhere);
        }
        ResultSet ds = DbHelperSQL.Query(strSql.toString());
        if (null != ds){
            return DataTableToList(ds);
        }
        return null;
    }
    
    public List<TraceCertificationModel> DataTableToList(ResultSet c){
        List<TraceCertificationModel> models = new ArrayList<TraceCertificationModel>();
        TraceCertificationModel m = new TraceCertificationModel();
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
    
    private TraceCertificationModel DataRowToModel(ResultSet c){
        TraceCertificationModel m = new TraceCertificationModel();
        try {
            m._proid = c.getInt("CetProID");
            m._name = c.getString("CertName");
            m._orderno = c.getInt("CertOrderNo");
            return m;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
}