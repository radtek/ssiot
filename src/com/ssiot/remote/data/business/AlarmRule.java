package com.ssiot.remote.data.business;

import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.SsiotResult;
import com.ssiot.remote.data.model.AlarmRuleModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlarmRule{
    public int Add(AlarmRuleModel model){
        StringBuilder strSql = new StringBuilder();
        strSql.append("insert into AlarmRule(");
        strSql.append("NodeUniqueID,Relation,RuleStr)");
        strSql.append(" values (");
        strSql.append("?,?,?) ");
        strSql.append(";select @@IDENTITY");
        
        ArrayList<Object> parameters = new ArrayList<Object>();
        parameters.add(model._uniqueID);
        parameters.add(model._relation);
        parameters.add(model._ruleStr);
        return DbHelperSQL.getInstance().Update_object(strSql.toString(), parameters);
    }
    
    public boolean Exists(String uniqueID){
        StringBuilder strSql = new StringBuilder();
        strSql.append("select * from AlarmRule where NodeUniqueID=?");
        ArrayList<Object> parameters = new ArrayList<Object>();
        parameters.add(uniqueID);
        return DbHelperSQL.getInstance().Exists_a(strSql.toString(), parameters);
    }
    
    public boolean Update(AlarmRuleModel model){//注意 是以NodeUniqueID 为查询的
        StringBuilder strSql = new StringBuilder();
        strSql.append("update AlarmRule set ");
//        strSql.append("NodeUniqueID=?,");
        strSql.append("Relation=?,");
        strSql.append("RuleStr=?");
        strSql.append(" NodeUniqueID =?");
        
        ArrayList<Object> parameters = new ArrayList<Object>();
//        parameters.add(model._uniqueID);
        parameters.add(model._relation);
        parameters.add(model._ruleStr);
        parameters.add(model._uniqueID);
        
        int rows = DbHelperSQL.getInstance().Update_object(strSql.toString(), parameters);
        return rows > 0;
    }
    
    public boolean Delete(String nodeunique){
        String cmd = "delete from AlarmRule where NodeUniqueID='" + nodeunique + "'";
        return DbHelperSQL.getInstance().Update(cmd) > 0;
    }
    
    public List<AlarmRuleModel> GetModelList(String strWhere) {
        StringBuilder strSql = new StringBuilder();
        strSql.append("select * ");
        strSql.append(" FROM AlarmRule ");
        if (strWhere.trim() != "") {
            strSql.append(" where " + strWhere);
        }
        SsiotResult sResult = DbHelperSQL.getInstance().Query(strSql.toString());
        List<AlarmRuleModel> list = null;
        if (null != sResult && null != sResult.mRs){
            list = DataTableToList(sResult.mRs);
        }
        if (null != sResult){
            sResult.close();
        }
        return list;
    }
    
    public List<AlarmRuleModel> DataTableToList(ResultSet c){
        List<AlarmRuleModel> models = new ArrayList<AlarmRuleModel>();
        AlarmRuleModel m = new AlarmRuleModel();
        try {
            while(c.next()){
                m = DataRowToModel(c);
                if (m != null){
                    models.add(m);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;
    }
    
    private AlarmRuleModel DataRowToModel(ResultSet c){
        AlarmRuleModel m = new AlarmRuleModel();
        try {
            m._id = c.getInt("ID");
            m._uniqueID = c.getString("NodeUniqueID");
            m._relation = c.getString("Relation");
            m._ruleStr = c.getString("RuleStr");
            return m;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
}