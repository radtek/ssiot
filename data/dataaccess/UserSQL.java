package com.ssiot.remote.data.dataaccess;

import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.model.UserModel;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

//should copy dataaceess
//DataAccess/Angel.Extend.DataAccess/User.cs
public class UserSQL {
    public UserSQL(){
        
    }
    
    public CachedRowSet GetList(String strWhere) {
        StringBuilder strSql = new StringBuilder();
        strSql.append("select * ");
        strSql.append(" FROM tbl_User ");
        if (strWhere.trim() != "") {
            strSql.append(" where " + strWhere);
        }
        return DbHelperSQL.Query(strSql.toString());
    }
    
    public UserModel DataRowToModel(CachedRowSet c){//先.next !!
        UserModel uModel = new UserModel();
        try {
            uModel._userid = Integer.parseInt(c.getString("UserID"));
            uModel._uniqueid = c.getString("UniqueID");
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