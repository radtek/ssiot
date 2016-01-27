package com.ssiot.remote.data.business;

import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.SsiotResult;
import com.ssiot.remote.data.model.CompanyContentModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyContent{
    
    public List<CompanyContentModel> GetModelList(String strWhere) {
        StringBuilder strSql = new StringBuilder();
        strSql.append("select * ");
        strSql.append(" FROM iot_CompanyContent ");
        if (strWhere.trim() != "") {
            strSql.append(" where " + strWhere);
        }
        SsiotResult sResult = DbHelperSQL.getInstance().Query(strSql.toString());
        List<CompanyContentModel> list = null;
        if (null != sResult.mRs){
            list = DataTableToList(sResult.mRs);
        }
        if (null != sResult){
            sResult.close();
        }
        return list;
    }
    
    public List<CompanyContentModel> DataTableToList(ResultSet c){
        List<CompanyContentModel> models = new ArrayList<CompanyContentModel>();
        CompanyContentModel m = new CompanyContentModel();
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
    
    private CompanyContentModel DataRowToModel(ResultSet c){
        CompanyContentModel m = new CompanyContentModel();
        try {
            m._companycontentid = c.getInt("CompanyContentID");
            m._compantemplate = c.getString("CompanTemplate");
            m._compancontent = c.getString("CompanContent");
            return m;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
}