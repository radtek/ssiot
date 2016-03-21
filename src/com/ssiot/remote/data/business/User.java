package com.ssiot.remote.data.business;

import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.SsiotResult;
import com.ssiot.remote.data.model.UserModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//should copy from 
//Business/Angel.Extend.Business/User.cs

public class User{
    
    public User(){
        
    }
    
    public List<UserModel> GetModelList(String strWhere) {
        StringBuilder strSql = new StringBuilder();
        strSql.append("select * ");
        strSql.append(" FROM iot_User ");
        if (strWhere.trim() != "") {
            strSql.append(" where " + strWhere);
        }
        List<UserModel> list = null;
        SsiotResult sResult = DbHelperSQL.getInstance().Query(strSql.toString());
        if (null != sResult && null != sResult.mRs){
            list = DataTableToList(sResult.mRs);
        }
        if (null != sResult){
            sResult.close();
        }
        return list;
    }
    
    private List<UserModel> DataTableToList(ResultSet c){
        List<UserModel> mUserModels = new ArrayList<UserModel>();
//        int rowCount = c.size();
        UserModel userModel = new UserModel();
//        for (int i = 0; i < rowCount; i ++){
//            c.next();
//            
//        }
        try {
            while(c.next()){
                userModel = DataRowToModel(c);
                if (userModel != null){
                    mUserModels.add(userModel);
                }
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mUserModels;
    }
    
    //jingbo single
    private UserModel DataRowToModel(ResultSet c){//先.next !!
        UserModel uModel = new UserModel();
        try {
            uModel._userid = c.getInt("UserID");
            uModel._account = c.getString("Account");
            uModel._userpassword = c.getString("UserPassword");
            uModel._uniqueid = c.getString("UniqueID");
            uModel._areaid = c.getInt("AreaID");
            uModel._userpassword = c.getString("UserPassword");
            uModel._username = c.getString("UserName");
            uModel._address = c.getString("Address");
            uModel._avatar = c.getString("Avatar");
            //TODO
            uModel._parentid = c.getInt("ParentId");
            uModel._usergroupid = c.getInt("UserGroupID");
            uModel._type = c.getInt("UserType");
            return uModel;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
}