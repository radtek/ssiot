package com.ssiot.remote.data.business;

import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.SsiotResult;
import com.ssiot.remote.data.model.TraceImagesModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TraceImages{
    //iot_TraceImages
    
    public List<TraceImagesModel> GetModelList(String strWhere) {
        StringBuilder strSql = new StringBuilder();
        strSql.append("select * ");
        strSql.append(" FROM iot_TraceImages ");
        if (strWhere.trim() != "") {
            strSql.append(" where " + strWhere);
        }
        SsiotResult sResult = DbHelperSQL.getInstance().Query(strSql.toString());
        List<TraceImagesModel> list = null;
        if (null != sResult && sResult.mRs != null){
            list = DataTableToList(sResult.mRs);
        }
        if (null != sResult){
            sResult.close();
        }
        return list;
    }
    
    public List<TraceImagesModel> DataTableToList(ResultSet c){
        List<TraceImagesModel> models = new ArrayList<TraceImagesModel>();
        TraceImagesModel m = new TraceImagesModel();
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
    
    private TraceImagesModel DataRowToModel(ResultSet c){
        TraceImagesModel m = new TraceImagesModel();
        try {
            m._imgproid = c.getInt("ImgProID");
            m._imgfilename = c.getString("ImgFileName");
            m._imgdesc = c.getString("ImgDesc");
            m._imgorderno = c.getInt("ImgOrderNo");
            return m;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
}