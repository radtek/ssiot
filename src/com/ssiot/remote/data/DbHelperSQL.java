package com.ssiot.remote.data;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;

import com.ssiot.remote.ContextUtilApp;
import com.ssiot.remote.receiver.SsiotReceiver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DbHelperSQL{
    private static final String tag = "DbHelperSQL";
    private static DbHelperSQL mDbHelperSQL;
    private SqlConnection connection;
    private Object objlock = new Object();
    private List<SsiotResult> usingResultList = new ArrayList<SsiotResult>();
    public static String connectionString = "";//Angel.DBUtility.PubConstant.ConnectionString;
    TimerTask currentTask;
    public DbHelperSQL(){
        
    }
    
    private boolean usingListEmpty(){
        for (int i = 0; i < usingResultList.size(); i ++){
            if (usingResultList.get(i).using == false){
                usingResultList.remove(i);
                i --;
            }
        }
        if (null == usingResultList || usingResultList.size() == 0){
            return true;
        }
        for (int j = 0; j < usingResultList.size(); j ++){
            try {
                Log.e(tag, "----------------!!!!!!using column1:"+usingResultList.get(j).mRs.getMetaData().getColumnName(1));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    private void sendDelayClose(){
//        mHandler.removeMessages(MSG_DELAY_CLOSE);
//        mHandler.sendEmptyMessageDelayed(MSG_DELAY_CLOSE, 25 * 1000);
        if (null != currentTask){
            currentTask.cancel();
            currentTask = null;
        }
        TimerTask closeTask = new TimerTask() {
            @Override
            public void run() {
                synchronized (objlock) {
                    if (usingListEmpty()){
                        if (connection != null){
                            connection.Close();
                            connection = null;
                        }
                    } else {
                        sendDelayClose();
                    }
                }
            }
        };
        currentTask = closeTask;
        Timer timer = new Timer();
        timer.schedule(closeTask, 25 * 1000);
    }
    
    public static DbHelperSQL getInstance(){
        if (mDbHelperSQL == null){
            mDbHelperSQL = new DbHelperSQL();
        }
        return mDbHelperSQL;
    }
    
    //doc http://www.java3z.com/cwbwebhome/article/article2/21115.html?id=1922 使用离线的rowset 下载了sun的rowset包
    public synchronized SsiotResult Query(String SQLString) {//must close resultset!!! in outside
        return Query(SQLString, 9);
     }
    
    public synchronized SsiotResult Query(String SQLString, int timeOutSec) {//
        synchronized (objlock) {
            Log.v(tag, "1######Query_1:" + SQLString + "##############" + timeOutSec);
            long time1 = SystemClock.uptimeMillis();
            try {
                if (!connectIsOk(connection)) {
                    connection = new SqlConnection(connectionString);
                    if (!connection.Open()) {
                        return null;
                    }
                }
                Log.v(tag, "2#--------open connection time " + (SystemClock.uptimeMillis() - time1) + !connection.con.isClosed());
                Statement stmt = (Statement) connection.createStatement();// ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE
                Log.v(tag, "2.5#--------statement create time " + (SystemClock.uptimeMillis() - time1));
                stmt.setQueryTimeout(timeOutSec);
                ResultSet rs = stmt.executeQuery(SQLString);
                Log.v(tag, "3#-------------query cost time" + (SystemClock.uptimeMillis() - time1));
                SsiotResult sr = new SsiotResult(rs, stmt);
                usingResultList.add(sr);
                sendDelayClose();
                return sr;
            } catch (SQLException ex) {
                Log.e(tag, "-----SQLException-----costTime:" + (SystemClock.uptimeMillis() - time1));
                closeAll();
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Intent i = new Intent(SsiotReceiver.ACTION_SSIOT_MSG);
            i.putExtra("showmsg", "查询数据出现问题");
            ContextUtilApp.getInstance().sendBroadcast(i);
            return null;
        }
    }
    
    private boolean connectIsOk(SqlConnection c){
        try {
            if (null != c && null != c.con  && !c.con.isClosed()){// && c.con.isValid(5)
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    
    private void closeAll(){
        Log.v(tag, "----closeAll------");
        try {
            if (null != connection){
                connection.Close();
                connection = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void outSideClose(){
        synchronized (objlock) {
            Log.v(tag, "----outSideClose------but noting");
//            closeAll();
        }
    }
    
    //第二个参数其实是params SqlParameter[] cmdParms
    //注意：问号与arrylist个数一致
    public SsiotResult Query(String SQLString, ArrayList<String> cmdParams){
        synchronized (objlock) {
            Log.v(tag, "1#带参数Query####" + SQLString);
            long time1 = SystemClock.uptimeMillis();
            try {
                
                if (!connectIsOk(connection)){
                    connection = new SqlConnection(connectionString);
                    if (!connection.Open()){
                        return null;
                    }
                }
                Log.v(tag, "2#--------open connection time " + (SystemClock.uptimeMillis()-time1) + !connection.con.isClosed());
                PreparedStatement preStatement = connection.prepareStatement(SQLString);
                for(int i = 0;i< cmdParams.size();i ++){
                    preStatement.setString((i+1), cmdParams.get(i));
                }
                preStatement.setQueryTimeout(9);
                ResultSet rs = preStatement.executeQuery();
                Log.v(tag, "3#-------------query参 cost time" + (SystemClock.uptimeMillis()-time1));
                SsiotResult sr = new SsiotResult(rs, preStatement);
                usingResultList.add(sr);
                sendDelayClose();
                return sr;
            } catch (Exception e) {
                closeAll();
                e.printStackTrace();
            }
            Intent i = new Intent(SsiotReceiver.ACTION_SSIOT_MSG);
            i.putExtra("showmsg", "2Query查询数据出现问题:" + (SystemClock.uptimeMillis()-time1));
            ContextUtilApp.getInstance().sendBroadcast(i);
            return null;
        }
    }
    
    public boolean Query_object(String SQLString, ArrayList<Object> cmdParams){
        synchronized (objlock) {
            Log.v(tag, "1#####Query_objecty####" + SQLString);
            long time1 = SystemClock.uptimeMillis();
            try {
                if (!connectIsOk(connection)){
                    connection = new SqlConnection(connectionString);
                    if (!connection.Open()){
                        return false;
                    }
                }
                Log.v(tag, "2#--------open connection time " + (SystemClock.uptimeMillis()-time1) + !connection.con.isClosed());
                
                PreparedStatement preStatement = connection.prepareStatement(SQLString);
                for(int i = 0;i< cmdParams.size();i ++){
                    preStatement.setObject((i+1), cmdParams.get(i));
                }
                preStatement.setQueryTimeout(9);
                
                boolean b = preStatement.execute();
                preStatement.close();
                Log.v(tag, "3#-------------Query_object cost time" + (SystemClock.uptimeMillis()-time1));
                return b;
            } catch (Exception e) {
                closeAll();
                e.printStackTrace();
            }
            Intent i = new Intent(SsiotReceiver.ACTION_SSIOT_MSG);
            i.putExtra("showmsg", "数据操作出现问题" + (SystemClock.uptimeMillis()-time1));
            ContextUtilApp.getInstance().sendBroadcast(i);
            return false;
        }
    }
    
    public boolean Exists_a(String SQLString, ArrayList<Object> cmdParams){
        synchronized (objlock) {
            Log.v(tag, "1#带参数Exist_a####" + SQLString);
            long time1 = SystemClock.uptimeMillis();
            try {
                if (null == connection || connection.con == null || connection.con.isClosed()){
                    connection = new SqlConnection(connectionString);
                    connection.Open();
                }
                Log.v(tag, "2#--------open connection time " + (SystemClock.uptimeMillis()-time1) + !connection.con.isClosed());
                PreparedStatement preStatement = connection.prepareStatement(SQLString);
                for(int i = 0;i< cmdParams.size();i ++){
//                    preStatement.setString((i+1), cmdParams.get(i));
                    preStatement.setObject(i+1, cmdParams.get(i));
                }
                preStatement.setQueryTimeout(9);
                ResultSet rs = preStatement.executeQuery();
                Log.v(tag, "3#-------------Exist_a参 cost time" + (SystemClock.uptimeMillis()-time1));
                if (null != rs && rs.next()){
                    rs.close();
                    preStatement.close();
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Intent i = new Intent(SsiotReceiver.ACTION_SSIOT_MSG);
            i.putExtra("showmsg", "2Exist_a查询数据出现问题:" + (SystemClock.uptimeMillis()-time1));
            ContextUtilApp.getInstance().sendBroadcast(i);
            return false;
        }
    }
    
    public int Update(String SQLString) {
        synchronized (objlock) {
            Log.v(tag, "1#####Update########" + SQLString);
            long time1 = SystemClock.uptimeMillis();
            try {
                if (!connectIsOk(connection)) {
                    connection = new SqlConnection(connectionString);
                    if (!connection.Open()){
                        return 0;
                    }
                }
                Log.v(tag, "2#--------open connection time " + (SystemClock.uptimeMillis() - time1)
                        + !connection.con.isClosed());
                Statement stmt = (Statement) connection.createStatement();
                stmt.setQueryTimeout(9);
                int i = stmt.executeUpdate(SQLString);// 返回更新的条数
                stmt.close();
                Log.v(tag, "3#-------------update time" + (SystemClock.uptimeMillis() - time1));
                return i;
            } catch (SQLException ex) {
                closeAll();
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Intent i = new Intent(SsiotReceiver.ACTION_SSIOT_MSG);
            i.putExtra("showmsg", "Update数据出现问题" +(SystemClock.uptimeMillis() - time1));
            ContextUtilApp.getInstance().sendBroadcast(i);
            return 0;
        }
    }
    
    public int Update_object(String SQLString, ArrayList<Object> cmdParams){
        synchronized (objlock) {
            Log.v(tag, "1#####Update_object####" + SQLString);
            long time1 = SystemClock.uptimeMillis();
            try {
                if (!connectIsOk(connection)){
                    connection = new SqlConnection(connectionString);
                    if (!connection.Open()){
                        return 0;
                    }
                }
                Log.v(tag, "2#--------open connection time " + (SystemClock.uptimeMillis()-time1) + !connection.con.isClosed());
                PreparedStatement preStatement = connection.prepareStatement(SQLString);
                for(int i = 0;i< cmdParams.size();i ++){
                    preStatement.setObject((i+1), cmdParams.get(i));
                }
                preStatement.setQueryTimeout(9);
                int ret = preStatement.executeUpdate();
                preStatement.close();
                Log.v(tag, "3#-------------Update_object time" + (SystemClock.uptimeMillis()-time1));
                return ret;
            } catch (Exception e) {
                closeAll();
                e.printStackTrace();
            }
            Intent i = new Intent(SsiotReceiver.ACTION_SSIOT_MSG);
            i.putExtra("showmsg", "Update_object数据操作出现问题");
            ContextUtilApp.getInstance().sendBroadcast(i);
            return 0;
        }
    }
    
    private static String MSGOPENFAIL = "连接ssiot数据库失败，请检查网络！";
    private static void toastmsg(String msg){//TTOODDOO in zheng ssiot
        Intent i = new Intent(SsiotReceiver.ACTION_SSIOT_MSG);
        i.putExtra("showmsg", ""+msg);
        ContextUtilApp.getInstance().sendBroadcast(i);
    }
    
    public class SqlConnection{
        public String tag = "mySqlConnection";
        public String connectionString= "";
        public Connection con;
        
        public SqlConnection(String connectionString){
            this.connectionString = connectionString;
        }
        
        public boolean Open(){
            String JDriver = "net.sourceforge.jtds.jdbc.Driver";
            String connectDB = "jdbc:jtds:sqlserver://ssiot2014.sqlserver.rds.aliyuncs.com:3433/iot2014;loginTimeout=9;socketTimeout=25";
//            String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//驱动程序无法通过使用安全套接字层(SSL)加密与 SQL Server 建立安全连接。错误:“Socket closed” ??jre jdk??
//            String connectDB = "jdbc:sqlserver://ssiot2014.sqlserver.rds.aliyuncs.com:3433;DatabaseName=iot2014;loginTimeout=9;socketTimeout=25";
            long timebegingopen = SystemClock.uptimeMillis();
            try {
                Class.forName(JDriver);// 加载数据库引擎，返回给定字符串名的类
                Log.v(tag, "############加载jdbcjtds驱动成功#############" + (SystemClock.uptimeMillis()-timebegingopen));
            } catch (ClassNotFoundException e){
                e.printStackTrace();
                Log.e(tag, "######加载数据库引擎失败###########1");
                return false;
            } catch (Exception e) {
                Log.e(tag, "######加载数据库引擎失败###########2");
                e.printStackTrace();
                return false;
            }
            
            try {
                String user = "angeliot";
                String password = "1qaz_PL";
                con = DriverManager.getConnection(connectDB, user, password);// 连接数据库对象
                Log.v(tag, "连接ssiot数据库成功");
            } catch (SQLException e) {
                e.printStackTrace();
                toastmsg(MSGOPENFAIL);
                return false;
            }
            return true;
        }
        
        public Statement createStatement(){
            if (null!= con){
                try {
                    return con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//modify in 20160113 
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Log.e(tag, "!!!!!!!!!!-----con=null when createStatement");
            }
            return null;
        }
        
        public PreparedStatement prepareStatement(String cmd){
            if (null!=con){
                try {
                    return con.prepareStatement(cmd);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        
        public void Close(){
            Log.v(tag, "---------close con-----");
            if (null != con){
                try {
                    con.close();
                    con = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}