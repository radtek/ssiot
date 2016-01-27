package com.ssiot.remote.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//TODO
public class SsiotResult {
    public boolean using = true;
    public ResultSet mRs;
    private Statement stmt;
    private PreparedStatement preStmt;
    
    public SsiotResult(ResultSet rs, Statement statement){
        mRs = rs;
        stmt = statement;
    }
    
    public SsiotResult(ResultSet rs, PreparedStatement statement){
        mRs = rs;
        preStmt = statement;
    }
    
    public void close(){
        try {
            if (null != mRs) {
                mRs.close();
                mRs = null;
            }
            if (null != stmt){
                stmt.close();
                stmt = null;
            }
            if(null != preStmt){
                preStmt.close();
                preStmt = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        using = false;
    }
}