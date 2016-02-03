
package com.ssiot.remote;

import android.util.Log;

import java.sql.*;

public class ConSQL{
    private static final String tag = "ConSQL";
    Statement stmt;
    Connection con;

    public boolean ConnectSQl() {
//        String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL数据库引擎
//        String connectDB = "jdbc:microsoft:sqlserver://ssiot2014.sqlserver.rds.aliyuncs.com:3433;databasename=iot2014";// 数据源
        String JDriver = "net.sourceforge.jtds.jdbc.Driver";
        String connectDB = "jdbc:jtds:sqlserver://ssiot2014.sqlserver.rds.aliyuncs.com:3433/iot2014;loginTimeout=9;socketTimeout=9";
        try {
            Class.forName(JDriver);// 加载数据库引擎，返回给定字符串名的类
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("加载数据库引擎失败");
            Log.v(tag, "######-------------###########");
            System.exit(0);
        } catch (Exception e) {
            Log.e(tag, "-------------error");
            e.printStackTrace();
            System.exit(0);
            return false;
        }
        Log.v(tag, "###########################################################");
        System.out.println("加载驱动成功");

        try {
            String user = "angeliot";
            String password = "1qaz_PL";
            con = DriverManager.getConnection(connectDB, user, password);// 连接数据库对象 //TODO 超时！！
            System.out.println("连接数据库成功");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getUniqueIDFromDB(String name, String password){
        try {
            stmt = (Statement) con.createStatement();
            String sqlcmd = "select * from iot_User where Account='" + name + "'";
            Log.v(tag, "---------cmd:" + sqlcmd + "-----");
            stmt.setQueryTimeout(5);
            ResultSet rs = stmt.executeQuery(sqlcmd);
            StringBuilder str = new StringBuilder();
            int columnCount = rs.getMetaData().getColumnCount();
            String tmpColumnName = "";
            for (int k = 1; k <= columnCount ;k ++){
                tmpColumnName += rs.getMetaData().getColumnName(k) + "\t";
            }
            Log.v(tag, "~~~~~~~~~~~~~~columnName" + tmpColumnName);
            Log.v(tag, "((((((((((((((((((((((((((((((((((((((");
            while (rs.next()) {
                for(int i=1;i<=columnCount;i++){
                    str.append(rs.getString(i) + "\t");
                    
                }
                
                String passwordInServer = rs.getString("UserPassword").trim();//服务器数据库中有空格！！！！！
//                Log.v(tag, "---------username"+ name + " localpass:" + password + " netpass:" + passwordInServer+":end");
                if (null != password && password.equals(passwordInServer)){
                    Log.v(tag, "~~~~~equals~~~~~~");
                    MainActivity.AreaID = rs.getInt("AreaID");
                    return rs.getString("UniqueID");
                }
                str.append("\n");
            }
            Log.v(tag, str.toString());
            Log.v(tag, "))))))))))))))))))))))))))))))))))))))");

            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            Log.e(tag, "----------------select() error");
            e.printStackTrace();
        }
        return "";
    }
}
