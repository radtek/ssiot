package com.ssiot.remote.data.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AlarmRuleModel{
    public int _id = -1;
    public String _uniqueID;
    public String _relation = "";
    public String _ruleStr = "";
//    public ArrayList<AlarmRuleBean> mElementDatas = new ArrayList<AlarmRuleBean>();
    
    @Override
    public String toString(){
        return "ID:"+_id + " " + _uniqueID + " " + _relation +" " + _ruleStr;
    }
    
    public ArrayList<AlarmRuleBean> parseAlarmJSON(String str){
        ArrayList<AlarmRuleBean> arrayList = new ArrayList<AlarmRuleBean>();
        try {
            JSONArray jsonArray = new JSONArray(str);
            for (int i = 0; i < jsonArray.length(); i ++){
                JSONObject obj = jsonArray.optJSONObject(i);
                String sensorName = obj.getString("sensorname");
                int sensorType = obj.getInt("sensorno");
                int chan = obj.getInt("channel");
                String type = obj.getString("type");
                String value = obj.getString("value");
                AlarmRuleBean bean = new AlarmRuleBean(sensorName, sensorType, chan, type, value, 1);
                arrayList.add(bean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}