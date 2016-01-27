package com.ssiot.remote.data.business;

import android.text.TextUtils;
import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.SsiotResult;
import com.ssiot.remote.data.model.SensorModel;
import com.ssiot.remote.data.model.view.SensorViewModel;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Sensor {
    private static final String tag = "Sensor";
    
    public List<SensorViewModel> GetSensorListByNodeNoString(String nodenos) {//在ProductSensor表中！！?
        List<SensorViewModel> list = null;
        SsiotResult sResult = null;
        if (TextUtils.isEmpty(nodenos)) {
            sResult = DbHelperSQL.getInstance().Query("SELECT DISTINCT  SensorNo ,  Channel ,  SensorName ,  ShortName ,  Unit , Accuracy ,MinValue ,MaxValue,  Color ,  SensorCategoryNo " +
            		"FROM    [ProductSensor]  JOIN [Sensor] ON [ProductSensor].SensorID = [Sensor].SensorNO WHERE   CAST([SensorID] AS VARCHAR) + '_' + CAST([Channel] AS VARCHAR) IN ( SELECT  CAST([SensorID] AS VARCHAR) + '_' + CAST([Channel] AS VARCHAR)  FROM    productsensor  )");
        } else {
            sResult = DbHelperSQL.getInstance().Query("SELECT DISTINCT  SensorNo ,  Channel ,  SensorName ,  ShortName ,  Unit ,  Accuracy , MinValue ,MaxValue,  Color ,  SensorCategoryNo " +
            		"FROM    [ProductSensor]  JOIN [Sensor] ON [ProductSensor].SensorID = [Sensor].SensorNO WHERE   CAST([SensorID] AS VARCHAR) + '_' + CAST([Channel] AS VARCHAR) IN ( SELECT  CAST([SensorID] AS VARCHAR) + '_' + CAST([Channel] AS VARCHAR)  FROM    productsensor  WHERE   ProductID IN ( SELECT DISTINCT  ProductID FROM     [Node] WHERE    NodeNo in (" + nodenos + " )) )");
        }

        try {
            if (null != sResult && null != sResult.mRs) {
                ResultSet sensords = sResult.mRs;
                list = new ArrayList<SensorViewModel>();
                while(sensords.next()){
                    SensorViewModel model = DataRowToViewModel(sensords);
                    list.add(model);
                }
//                sensords.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != sResult){
            sResult.close();
        }
        
        return list;
    }
    
    public List<SensorModel> GetModelList(String strWhere){
        SsiotResult sResult = GetList_dataaccess(strWhere);
        List<SensorModel> list = null;
        if (null != sResult && null != sResult.mRs){
            list = DataTableToList(sResult.mRs);
        }
        if (null != sResult){
            sResult.close();
        }
        return list;
    }
    
    //-------------------------------------------------------
    private SsiotResult GetList_dataaccess(String strWhere) {
        StringBuilder strSql = new StringBuilder();
        strSql.append("select SensorNo,SensorCategoryNo,SensorName,ShortName,Unit,Accuracy,MinValue,MaxValue,Color ");
        strSql.append(" FROM Sensor ");
        if (!TextUtils.isEmpty(strWhere.trim())) {
            strSql.append(" where " + strWhere);
        }
        return DbHelperSQL.getInstance().Query(strSql.toString());
    }
    
    private List<SensorModel> DataTableToList(ResultSet c){
        List<SensorModel> mModels = new ArrayList<SensorModel>();
        SensorModel mm = new SensorModel();
        try {
            while(c.next()){
                mm = DataRowToModel(c);
                if (mm != null){
                    mModels.add(mm);
                }
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mModels;
    }
    
    private SensorModel DataRowToModel(ResultSet rs){
        SensorModel m = new SensorModel();
        try {
            m._sensorno = Integer.parseInt(rs.getString("SensorNo"));
            m._sensorcategoryno = Integer.parseInt(rs.getString("SensorCategoryNo"));
            m._sensorname = rs.getString("SensorName");
            m._shortname = rs.getString("ShortName");
            m._unit = rs.getString("Unit");
            m._accuracy = Integer.parseInt(rs.getString("Accuracy"));
            m._minvalue = rs.getFloat("MinValue");
            m._maxvalue = rs.getFloat("MaxValue");
            m._color = rs.getString("Color");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }
    
    public SensorViewModel DataRowToViewModel(ResultSet rs){
        SensorViewModel m = new SensorViewModel();
        try {
            m._sensorno = rs.getInt("SensorNO");
            m._channel = Integer.parseInt(rs.getString("Channel"));
            m._sensorcategoryno = rs.getInt("SensorCategoryNo");
            m._sensorname = rs.getString("SensorName");
            m._shortname = rs.getString("ShortName");
            m._unit = rs.getString("Unit");
            m._accuracy = rs.getInt("Accuracy");
            m._minvalue = rs.getFloat("MinValue");
            m._maxvalue = rs.getFloat("MaxValue");
            m._color = rs.getString("Color");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }
}