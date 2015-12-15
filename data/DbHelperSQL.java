package com.ssiot.remote.data;

import android.util.Log;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.rowset.CachedRowSet;

public class DbHelperSQL {
        
    public static String connectionString = "";//Angel.DBUtility.PubConstant.ConnectionString;
    public DbHelperSQL(){
        
    }
    
    //doc http://www.java3z.com/cwbwebhome/article/article2/21115.html?id=1922 使用离线的rowset 下载了sun的rowset包
    public static CachedRowSet Query(String SQLString) {//must close resultset!!!
         SqlConnection connection = new SqlConnection(connectionString);
         
         try {
             CachedRowSet crs = new CachedRowSetImpl();
             connection.Open();
             Statement stmt = (Statement) connection.createStatement();
             ResultSet rs = stmt.executeQuery(SQLString);
             stmt.close();
             crs.populate(rs);
             rs.close();
             connection.Close();
             return crs;
         } catch (SQLException ex) {
             ex.printStackTrace();
         } finally {
         }
         return null;
     }
    
    public static class SqlConnection{
        public String tag = "mySqlConnection";
        public String connectionString= "";
        Connection con;
        
        public SqlConnection(String connectionString){
            this.connectionString = connectionString;
        }
        
        public void Open(){
            String JDriver = "net.sourceforge.jtds.jdbc.Driver";
            String connectDB = "jdbc:jtds:sqlserver://ssiot2014.sqlserver.rds.aliyuncs.com:3433/iot2014";
            try {
                Class.forName(JDriver);// 加载数据库引擎，返回给定字符串名的类
            } catch (ClassNotFoundException e){
                e.printStackTrace();
                Log.e(tag, "######加载数据库引擎失败###########");
                System.exit(0);
            } catch (Exception e) {
                Log.e(tag, "-------------error");
                e.printStackTrace();
                System.exit(0);
            }
            Log.v(tag, "############加载jdbcjtds驱动成功#############");

            try {
                String user = "angeliot";
                String password = "1qaz_PL";
                con = DriverManager.getConnection(connectDB, user, password);// 连接数据库对象
                Log.v(tag, "连接ssiot数据库成功");
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
        
        public Statement createStatement(){
            if (null!= con){
                try {
                    return con.createStatement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        
        public void Close(){
            if (null != con){
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}