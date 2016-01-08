package com.ssiot.remote.data.business;

import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.model.ProfilesContentModel;
import com.ssiot.remote.data.model.TraceProfileModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfilesContent{
    
    public List<ProfilesContentModel> GetModelList(String strWhere) {
        StringBuilder strSql = new StringBuilder();
        strSql.append("select * ");
        strSql.append(" FROM iot_ProfilesContent ");
        if (strWhere.trim() != "") {
            strSql.append(" where " + strWhere);
        }
        ResultSet ds = DbHelperSQL.Query(strSql.toString());
        if (null != ds){
            return DataTableToList(ds);
        }
        return null;
    }
    
    public List<ProfilesContentModel> DataTableToList(ResultSet c){
        List<ProfilesContentModel> models = new ArrayList<ProfilesContentModel>();
        ProfilesContentModel m = new ProfilesContentModel();
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
    
    private ProfilesContentModel DataRowToModel(ResultSet c){
        ProfilesContentModel m = new ProfilesContentModel();
        try {
            m._profilecontent = c.getString("ProfileContent");
            return m;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
}