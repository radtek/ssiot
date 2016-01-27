package com.ssiot.remote.data.business;

import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.SsiotResult;
import com.ssiot.remote.data.model.ProfilesContentModel;
import com.ssiot.remote.data.model.SettingInfo1Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SettingInfo1 {
    
    public SettingInfo1Model GetModel(int ID) {

        StringBuilder strSql=new StringBuilder();
        strSql.append("select  top 1 ID,Name,ReportFrequency,Type,SettingMark,Channel,Other,Value from SettingInfo1 ");
        strSql.append(" where ID=" + ID);

        SettingInfo1Model m = null;
        SsiotResult sResult = DbHelperSQL.getInstance().Query(strSql.toString());
        try {
            if(null != sResult && null != sResult.mRs && sResult.mRs.next()) {
                m = DataRowToModel(sResult.mRs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != sResult){
            sResult.close();
        }
        return m;
    }
    
    
    public List<SettingInfo1Model> GetModelList(String strWhere){
        SsiotResult sResult = GetList_dataaccess(strWhere);
        List<SettingInfo1Model> list = null;
        if (null != sResult && null != sResult.mRs){
            list = DataTableToList(sResult.mRs);
        }
        if (null != sResult){
            sResult.close();
        }
        return list;
    }
    
    private List<SettingInfo1Model> DataTableToList(ResultSet c){
        List<SettingInfo1Model> modelList = new ArrayList<SettingInfo1Model>();
        SettingInfo1Model model = new SettingInfo1Model();
        try {
            while(c.next()){
                model = DataRowToModel(c);
                if (model != null){
                    modelList.add(model);
                }
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelList;
    }
    
    private SettingInfo1Model DataRowToModel(ResultSet s){
        SettingInfo1Model m = new SettingInfo1Model();
        try {
            m._id = s.getInt("ID");
            m._name = s.getString("Name");
            m._reportfrequency = s.getInt("ReportFrequency");
            m._type = s.getInt("Type");
            m._settingmark = s.getInt("SettingMark");
            m._channel = s.getInt("Channel");
            m._other = s.getInt("Other");
            m._value = s.getInt("Value");
            return m;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //---------------------------
    
    private SsiotResult GetList_dataaccess(String strWhere) {
        StringBuilder strSql=new StringBuilder();
        strSql.append("select ID,Name,ReportFrequency,Type,SettingMark,Channel,Other,Value ");
        strSql.append(" FROM SettingInfo1 ");
        if(strWhere.trim()!="") {
            strSql.append(" where "+strWhere);
        }
        return DbHelperSQL.getInstance().Query(strSql.toString());
    }
}