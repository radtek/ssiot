package com.ssiot.remote.data.business;

import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.SsiotResult;
import com.ssiot.remote.data.model.ProfilesContentModel;
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
        SsiotResult sResult = DbHelperSQL.getInstance().Query(strSql.toString());
        List<ProfilesContentModel> list = null;
        if (null != sResult && null != sResult.mRs){
            list = DataTableToList(sResult.mRs);
        }
        if (null != sResult){
            sResult.close();
        }
        return list;
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
//            c.close();
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