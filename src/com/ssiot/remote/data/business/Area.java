package com.ssiot.remote.data.business;

import android.text.TextUtils;
import android.util.Log;

import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.SsiotResult;
import com.ssiot.remote.data.model.AreaModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//should copy from 
//Business/Angel.Extend.Business/

public class Area{
    private static final String tag = "Area";
    
    public Area(){
        
    }
    
    public AreaModel GetModel(int AreaID){
        StringBuilder strSql = new StringBuilder();
        strSql.append("select  top 1 * from Area ");
        strSql.append(" where AreaID=?");//?? TODO
//        SqlParameter[] parameters = { 
//                new SqlParameter("@AreaID", SqlDbType.Int,4)
//        };  
//        parameters[0].Value = AreaID;
        ArrayList<String> paramArray = new ArrayList<String>();
        paramArray.add("" + AreaID);
        SsiotResult sResult = DbHelperSQL.getInstance().Query(strSql.toString(), paramArray);
        AreaModel model = null;
        try {
            if (null != sResult && null != sResult.mRs){
                if (sResult.mRs.next()) {
                    model = DataRowToModel(sResult.mRs);
                }
                Log.v(tag, "-------------GetModel-ok");
            } else {
                Log.e(tag, "-------------resultset=null !!!!!!!!!!!!"+strSql.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != sResult){
            sResult.close();
        }
        return model;
    }
    
    public List<AreaModel> GetModelList(String strWhere) {
        StringBuilder strSql = new StringBuilder();
        strSql.append("select * ");
        strSql.append(" FROM Area ");
        if (strWhere.trim() != "") {
            strSql.append(" where " + strWhere);
        }
        SsiotResult sResult = DbHelperSQL.getInstance().Query(strSql.toString());
        List<AreaModel> list = null;
        if (null != sResult && null != sResult.mRs){
            list = DataTableToList(sResult.mRs);
        }
        if (null != sResult){
            sResult.close();
        }
        return list;
    }
    
    private List<AreaModel> DataTableToList(ResultSet c){
        List<AreaModel> mAreaModels = new ArrayList<AreaModel>();
//        int rowCount = c.size();
        AreaModel AreaModel = new AreaModel();
//        for (int i = 0; i < rowCount; i ++){
//            c.next();
//            
//        }
        try {
            while(c.next()){
                AreaModel = DataRowToModel(c);
                if (AreaModel != null){
                    mAreaModels.add(AreaModel);
                }
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mAreaModels;
    }
    
    public List<AreaModel> GetSelfAndChildrenAreaByAreaCode(String areacode) {
        List<AreaModel> area_list = new ArrayList<AreaModel>();
        if (!TextUtils.isEmpty(areacode)) {
            String sql = "  SELECT * FROM Area WHERE AreaCode LIKE '" + areacode.trim() + "%'";
            SsiotResult sResult = DbHelperSQL.getInstance().Query(sql);
            if (null != sResult && null != sResult.mRs){
                area_list = DataTableToList(sResult.mRs);
            }
            if (null != sResult){
                sResult.close();
            }
        }
        return area_list;
    }
    
    private AreaModel DataRowToModel(ResultSet c){//先.next !!
        AreaModel uModel = new AreaModel();
        try {
            uModel._areaid = Integer.parseInt(c.getString("AreaID"));
            uModel._areacode = c.getString("AreaCode");
            //TODO
            return uModel;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}