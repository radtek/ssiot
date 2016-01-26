package com.ssiot.remote.dblocal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LocalDBHelper extends SQLiteOpenHelper{
    public static final String TABLE_TRACEPROFILE = "traceprofiles";
    public static final String TABLE_ALARM = "alarmrule";
    /**  
     *   
     * @param context 应用程序上下文  
     * @param name    数据库的名字  
     * @param factory 查询数据库的游标工厂 一般情况下 用sdk默认的  
     * @param version  数据库的版本 版本号必须不小1   
     *    
     */  
    public LocalDBHelper(Context context) {
        super(context, "ssiot.db", null , 1);
    }  
  
    // 在mydbOpenHelper 在数据库第一次被创建的时候  会执行onCreate();  
    @Override  
    public void onCreate(SQLiteDatabase db) {
        System.out.println("我被调用了 oncreate");
        db.execSQL("create table if not exists traceprofiles("  
                + "id integer primary key," 
                + "ProCode varchar,"
                + "ProName varchar,"  
                + "ProBatchNo varchar,"  
                + "ProListingDate varchar)"); //integer
//        db.execSQL("create table if not exists alarmrule("  
//                + "id integer primary key," 
//                + "NodeUniqueID varchar,"
//                + "Relation varchar,"  
//                + "Rule varchar)"); //integer
//        db.execSQL("CREATE TABLE localssiot (personid integer primary key autoincrement, name varchar(20))");  
    }
        // 通过version的增加来执行数据库版本更新，版本号改为6的同时，调用onUpgrade ，让程序员执行具体更新；  
    @Override  
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!on update " + oldVersion + " "+newVersion);
//        db.execSQL("ALTER TABLE localssiot ADD phone VARCHAR(12) NULL ");
        db.execSQL("DROP TABLE IF EXISTS traceprofiles");
//        db.execSQL("DROP TABLE IF EXISTS alarmrule");
        onCreate(db);//一个山寨的方法 http://blog.csdn.net/zhouy1989/article/details/7484715 
        
        //TODO 升级时有问题 如果数据表格不对应！！不会更新 TODO
    }  
}