package com.ssiot.remote.data.business;

import com.ssiot.remote.data.dataaccess.UserSQL;
import com.ssiot.remote.data.model.UserModel;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

//should copy from 
//Business/Angel.Extend.Business/User.cs

public class User{
    
    private UserSQL dal = new UserSQL();
    public User(){
        
    }
    
    public List<UserModel> GetModelList(String strWhere) {
        CachedRowSet ds = dal.GetList(strWhere);
        return DataTableToList(ds);
    }
    
    public List<UserModel> DataTableToList(CachedRowSet c){
        List<UserModel> mUserModels = new ArrayList<UserModel>();
//        int rowCount = c.size();
        UserModel userModel = new UserModel();
//        for (int i = 0; i < rowCount; i ++){
//            c.next();
//            
//        }
        try {
            while(c.next()){
                userModel = dal.DataRowToModel(c);
                if (userModel != null){
                    mUserModels.add(userModel);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mUserModels;
    }
}