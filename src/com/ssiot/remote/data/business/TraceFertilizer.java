package com.ssiot.remote.data.business;

import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.model.TraceFertilizerModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TraceFertilizer{
    //iot_TraceFertilizer
    
    public List<TraceFertilizerModel> GetModelList(String strWhere) {
        StringBuilder strSql = new StringBuilder();
        strSql.append("select * ");
        strSql.append(" FROM iot_TraceFertilizer ");
        if (strWhere.trim() != "") {
            strSql.append(" where " + strWhere);
        }
        ResultSet ds = DbHelperSQL.Query(strSql.toString());
        if (null != ds){
            List<TraceFertilizerModel> list = DataTableToList(ds);
            try {
                ds.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return list;
        }
        return null;
    }
    
    public List<TraceFertilizerModel> DataTableToList(ResultSet c){
        List<TraceFertilizerModel> models = new ArrayList<TraceFertilizerModel>();
        TraceFertilizerModel m = new TraceFertilizerModel();
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
    
    private TraceFertilizerModel DataRowToModel(ResultSet c){
        TraceFertilizerModel m = new TraceFertilizerModel();
        try {
            m._ferusedate = c.getString("FerUseDate");
            m._fername = c.getString("FerName");
            m._ferdosage = c.getFloat("FerDosage");
            m._ferproid = c.getInt("FerProID");
            m._ferunit = c.getString("FerUnit");
            m._ferorderno = c.getInt("FerOrderNo");
            return m;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
}