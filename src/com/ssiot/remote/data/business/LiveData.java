package com.ssiot.remote.data.business;

import android.text.TextUtils;
import android.util.Log;

import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.model.LiveDataModel;
import com.ssiot.remote.data.model.view.SensorViewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LiveData{
    
    private Sensor mSensorDataAccess = new Sensor();
    
    public int GetDataCount(String grainsize, String valuetype, String begintime, 
            String endtime, String orderby, boolean unit, int range, String nodenolist){
        StringBuilder sb_sql = new StringBuilder();
        //用于节点编号，安装地点和更新时间三列的生成
        sb_sql.append(" SELECT DISTINCT [Node].NodeNo , [Node].Location ,[ResultData2].DATETIME   as 更新时间 FROM (");
        
        String[] strs = choseWitchTableInfo(grainsize, valuetype);//选择数据源
        String timelength = strs[0];//"15";
        String tablename = strs[1];//"[LiveData]";
        String indexid = strs[2];//"[LiveDataID]";
        String datacolumn = strs[3];//"[Data]";
        String timecolumn = strs[4];//"[CollectionTime]";
        String rangestr = "";
        rangestr = "TOP " + range;
        
        sb_sql.append(
                " SELECT SUBSTRING(CONVERT(VARCHAR(20), "+timecolumn+", 20), 1, "+timelength+") AS DATETIME , [UniqueID] , [Channel] , [SensorNo] , MAX("+datacolumn+") AS DATA ");

        sb_sql.append(" FROM ( SELECT "+rangestr+" * FROM  "+tablename+" ");//TODO 其实10000也还是有问题
        sb_sql.append("  WHERE 1=1");
        if (!TextUtils.isEmpty(nodenolist)) {
            sb_sql.append(
                    " AND UniqueID in(select UniqueID from Node where NodeNo IN ("+nodenolist+"))");
        }
        if (!TextUtils.isEmpty(begintime) && !TextUtils.isEmpty(endtime)) {
            sb_sql.append(" AND "+timecolumn+" > '"+begintime+"' AND "+timecolumn+" < '"+endtime+"' ");
        }
//        sb_sql.append("ORDER BY  " + indexid + " DESC ) ResultData1  ");
        sb_sql.append(") ResultData1 ");
        sb_sql.append(
                " GROUP BY SUBSTRING(CONVERT(VARCHAR(20), "+timecolumn+" , 20) , 1 , "+timelength+")," +
                        "[UniqueID] , [Channel] , [SensorNo] ) [ResultData2] " +
                        "JOIN [Node] ON [ResultData2].UniqueID = [Node].UniqueID JOIN [Sensor] ON [Sensor].SensorNo = [ResultData2].SensorNo");
        if (!TextUtils.isEmpty(orderby)) {
//            sb_sql.append(" ORDER BY "+orderby+" ");
        }
        ResultSet ds = DbHelperSQL.Query(sb_sql.toString());
        try {
            if (null != ds && ds.last()){
                int size = ds.getRow();
                ds.close();
                return size;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
       return 0;
    }
    
    //from cloud svn 2016-01-13 原先的getdata有top10000的问题  
    public ResultSet GetData(String grainsize, String valuetype, String begintime, String endtime, String orderby, 
            int beginindex, int endindex, boolean unit, int range, List<SensorViewModel> sensorlist, String nodenolist){
        Log.v("LiveData", "---------GetData---" + begintime + grainsize);
        //传感器列表
        List<SensorViewModel> list = new ArrayList<SensorViewModel>();
        if (sensorlist != null) {
            list = sensorlist;
        } else {
            list = mSensorDataAccess.GetSensorListByNodeNoString(nodenolist);
        }
        if (list.size() > 0) {
            StringBuilder sb_sql = new StringBuilder();
            //用于节点编号，安装地点和更新时间三列的生成
            sb_sql.append("SELECT NodeNo AS 节点编号 , Location AS 安装地点 , [DATETIME] AS 更新时间 ,");

            StringBuilder sb_columns1 = new StringBuilder();
            StringBuilder sb_columns2 = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {    
                String unitstr = "";
                String sensoradd = "";
                if (unit) {
                    unitstr = " + '" + list.get(i)._unit + "'";
                }
                if (list.get(i)._channel > 0) {
                    sensoradd = ""+list.get(i)._channel;
                }
                sb_columns1.append(" replace(convert(VARCHAR,convert(float,round(SensorColumn.["+ list.get(i)._sensorno+"_"+list.get(i)._channel+"]," +
                        list.get(i)._accuracy+")))"+unitstr+", '32767'"+unitstr+", '无') AS "+list.get(i)._shortname+sensoradd+" ,");
                sb_columns2.append("["+list.get(i)._sensorno+"_"+list.get(i)._channel+"],");
            }
            sb_columns2.deleteCharAt(sb_columns2.length()-1);
            sb_columns1.deleteCharAt(sb_columns1.length()-1);
            sb_columns1.append(" FROM ( SELECT [Node].NodeNo , [Node].Location ,[ResultData2].DATETIME , CAST([ResultData2].[SensorNo] AS VARCHAR) + '_' + CAST([ResultData2].[Channel] AS VARCHAR) AS [SensorList] , [ResultData2].DATA  FROM (");
            if (sb_columns1.length() > 0){
                sb_sql.append(sb_columns1.toString().substring(1));
            }
             
             String[] strs = choseWitchTableInfo(grainsize, valuetype);//选择数据源
             String timelength = strs[0];//"15";
             String tablename = strs[1];//"[LiveData]";
             String indexid = strs[2];//"[LiveDataID]";
             String datacolumn = strs[3];//"[Data]";
             String timecolumn = strs[4];//"[CollectionTime]";
             String rangestr = "";
             rangestr = "TOP " + range;
             
             sb_sql.append(" SELECT SUBSTRING(CONVERT(VARCHAR(20), "+timecolumn+", 20), 1, "+timelength+") AS DATETIME , " +
             		"[UniqueID] , [Channel] , [SensorNo] , MAX("+datacolumn+") AS DATA ");//此句和之前不同

             sb_sql.append(" FROM ( SELECT "+rangestr+" * FROM  "+tablename+" ");
             sb_sql.append("  WHERE 1=1");
             if (!TextUtils.isEmpty(nodenolist)) {
                 sb_sql.append(" AND UniqueID in ( select UniqueID from Node where NodeNo IN ("+nodenolist+"))");
             }
             if (!TextUtils.isEmpty(begintime) && !TextUtils.isEmpty(endtime)){
                 sb_sql.append(" AND "+timecolumn+" > '"+begintime+"' AND "+timecolumn+" < '"+endtime+"' ");
             }
             sb_sql.append("ORDER BY  "+indexid+" DESC ) ResultData1  ");
             sb_sql.append(" GROUP BY SUBSTRING(CONVERT(VARCHAR(20), "+timecolumn+" , 20) , 1 , "+timelength+"),[UniqueID] , [Channel] , [SensorNo] )" +
             		" [ResultData2] JOIN [Node] ON [ResultData2].UniqueID = [Node].UniqueID JOIN [Sensor] ON [Sensor].SensorNo = [ResultData2].SensorNo )" +
             		" [ResultData3] ");


             sb_sql.append("PIVOT ( MAX([ResultData3].DATA) FOR [ResultData3].[SensorList] IN ( "+sb_columns2.toString()+" ) ) [SensorColumn]");
             sb_sql.insert(0, "SELECT TOP 100000 * , ROW_NUMBER() OVER ( ORDER BY " + orderby + " ) AS [RANK] FROM (");
             sb_sql.append(" ) AS [Table] WHERE 1=1");

             //if (!string.IsNullOrEmpty(nodenolist))
             //{
             //    sb_sql.AppendFormat(" AND 节点编号 IN ({0})", nodenolist);
             //}

             if (orderby != null) {
                 sb_sql.append(" ORDER BY "+orderby+" ");
             }
             //分页

             if (beginindex != -1 && endindex != -1) {
                 sb_sql.insert(0, "SELECT * FROM (");
                 sb_sql.append(" ) AS [Table] WHERE 1=1");
                 sb_sql.append(" AND [Table].[RANK] >= "+beginindex+" AND [Table].[RANK] <"+endindex+" ");
             }
             ResultSet ds = DbHelperSQL.Query(sb_sql.toString(),20);//add timeout in 20160118 this function cost long time
             return ds;
        }
        return null;
    }
                 
    
    //获取流水数据(只在前range条中查找)//前10000条的限制加在前面，所以不卡，但可能有问题 暂时只用在所有节点列表显示界面
    public ResultSet GetData_old(String grainsize, String valuetype, String begintime, String endtime, String orderby, 
            int beginindex, int endindex, boolean unit, int range, List<SensorViewModel> sensorlist, String nodenolist){
        ResultSet ds = null;
        //传感器列表
        List<SensorViewModel> list = new ArrayList<SensorViewModel>();

        if (sensorlist != null) {
            list = sensorlist;
        } else {
            list = mSensorDataAccess.GetSensorListByNodeNoString(nodenolist);
        }
        if (list.size() > 0) {
            StringBuilder sb_sql = new StringBuilder();
            //用于节点编号，安装地点和更新时间三列的生成
            sb_sql.append("SELECT NodeNo AS 节点编号 , Location AS 安装地点 , [DATETIME] AS 更新时间 ,");

            StringBuilder sb_columns1 = new StringBuilder();
            StringBuilder sb_columns2 = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                String unitstr = "";
                String sensoradd = "";
                if (unit) {
                    unitstr = " + '" + list.get(i)._unit + "'";
                }
                if (list.get(i)._channel > 0) {
                    sensoradd = "" +list.get(i)._channel;
                }
                //sb_columns1.AppendFormat(" replace(convert(VARCHAR,convert(float,round(SensorColumn.[{0}_{1}],{2}))){3}, '32767'{3}, '无') AS {4} ,",
                //    list[i].SensorNO, list[i].Channel, list[i].Accuracy, unitstr, list[i].ShortName
                //    );
                //
                sb_columns1.append(" replace(convert(VARCHAR,convert(float,round(SensorColumn.["+ list.get(i)._sensorno+"_"+list.get(i)._channel+"]," +
                        list.get(i)._accuracy+")))"+unitstr+", '32767'"+unitstr+", '无') AS "+list.get(i)._shortname+sensoradd+" ,");
                sb_columns2.append("["+list.get(i)._sensorno+"_"+list.get(i)._channel+"],");
            }
            sb_columns2.deleteCharAt(sb_columns2.length()-1);
            sb_columns1.deleteCharAt(sb_columns1.length()-1);
            sb_columns1.append(" FROM ( SELECT [Node].NodeNo , [Node].Location ,[ResultData2].DATETIME , CAST([ResultData2].[SensorNo] AS VARCHAR) + '_' + CAST([ResultData2].[Channel] AS VARCHAR) AS [SensorList] , [ResultData2].DATA  FROM (");
            if (sb_columns1.length() > 0){
                sb_sql.append(sb_columns1.toString().substring(1));
            }

            String[] strs = choseWitchTableInfo(grainsize, valuetype);//选择数据源
            String timelength = strs[0];//"15";
            String tablename = strs[1];//"[LiveData]";
            String indexid = strs[2];//"[LiveDataID]";
            String datacolumn = strs[3];//"[Data]";
            String timecolumn = strs[4];//"[CollectionTime]";
            String rangestr = "";
            rangestr = "TOP " + range;

            //TODO let王桂华 改了 varchar变成datetime because mobileapi de timestr
            //王桂华20160112 said：DataByTen表中NodeID有问题，要用UniqueID ！！
            sb_sql.append(" SELECT SUBSTRING(CONVERT(VARCHAR(20), "+timecolumn+", 20), 1, "+timelength+") AS DATETIME , [UniqueID] , [Channel] , [SensorNo] , MAX("+datacolumn+") AS DATA " +
            		"FROM ( SELECT "+rangestr+" * FROM  "+tablename+" ORDER BY  "+indexid+" DESC ) ResultData1 WHERE 1 = 1 ");

            if (!TextUtils.isEmpty(begintime) && !TextUtils.isEmpty(endtime))
                sb_sql.append(" AND "+timecolumn+" > '"+begintime+"' AND "+timecolumn+" < '"+endtime+"' ");

            sb_sql.append(" GROUP BY SUBSTRING(CONVERT(VARCHAR(20), "+timecolumn+" , 20) , 1 , "+timelength+") ,[UniqueID] , [Channel] , [SensorNo] ) [ResultData2] " +
            		"JOIN [Node] ON [ResultData2].UniqueID = [Node].UniqueID JOIN [Sensor] ON [Sensor].SensorNo = [ResultData2].SensorNo ) [ResultData3] ");

            sb_sql.append("PIVOT ( MAX([ResultData3].DATA) FOR [ResultData3].[SensorList] IN ( "+sb_columns2.toString()+" ) ) [SensorColumn]");
            sb_sql.insert(0, "SELECT TOP 100000 * , ROW_NUMBER() OVER ( ORDER BY " + orderby + " ) AS [RANK] FROM (");
            sb_sql.append(" ) AS [Table] WHERE 1=1");

            if (!TextUtils.isEmpty(nodenolist)) {
                sb_sql.append(" AND 节点编号 IN ("+nodenolist+")");
            }

            if (orderby != null) {
                sb_sql.append(" ORDER BY "+orderby+" ");
            }
            //分页
         
            if (beginindex != -1 && endindex != -1) {
                sb_sql.insert(0, "SELECT * FROM (");
                sb_sql.append(" ) AS [Table] WHERE 1=1");
                sb_sql.append(" AND [Table].[RANK] >= "+beginindex+" AND [Table].[RANK] <"+endindex+" ");
            }
            ds = DbHelperSQL.Query(sb_sql.toString());
        }
        return ds;
    }
    
    //精确查找获取数据
    public ResultSet GetData(String grainsize, String valuetype, String begintime, String endtime, String orderby, 
            int beginindex, int endindex, boolean unit, String nodenolist)
    {
        ResultSet ds = null;
        // 传感器View列表
        List<SensorViewModel> list = new ArrayList<SensorViewModel>();
        if (!TextUtils.isEmpty(nodenolist)) {
            list = mSensorDataAccess.GetSensorListByNodeNoString(nodenolist);
        } else {
            return ds;
        }
        
        if (list.size() > 0) {
            StringBuilder sb_sql = new StringBuilder();
            //用于节点编号，安装地点和更新时间三列的生成
            sb_sql.append("SELECT NodeNo AS 节点编号 , Location AS 安装地点 , [DATETIME] AS 更新时间 ,");

            StringBuilder sb_columns1 = new StringBuilder();//用于标识输出
            StringBuilder sb_columns2 = new StringBuilder();//用于转置
            for (int i = 0; i < list.size(); i++) {
                String unitstr = "";
                String sensoradd = "";
                if (unit) {
                    unitstr = " + '" + list.get(i)._unit + "'";
                }
                if (list.get(i)._channel > 0) {
                    sensoradd = "" +list.get(i)._channel;
                }
                //sb_columns1.AppendFormat(" replace(convert(VARCHAR,convert(float,round(SensorColumn.[{0}_{1}],{2}))){3}, '32767'{3}, '无') AS {4} ,",
                //    list[i].SensorNO, list[i].Channel, list[i].Accuracy, unitstr, list[i].ShortName
                //    );
                //
                sb_columns1.append(" replace(convert(VARCHAR,convert(float,round(SensorColumn.["+ list.get(i)._sensorno+"_"+list.get(i)._channel+"]," +
                        list.get(i)._accuracy+")))"+unitstr+", '32767'"+unitstr+", '无') AS "+list.get(i)._shortname+sensoradd+" ,");
                sb_columns2.append("["+list.get(i)._sensorno+"_"+list.get(i)._channel+"],");
            }
            sb_columns2.deleteCharAt(sb_columns2.length()-1);
            sb_columns1.deleteCharAt(sb_columns1.length()-1);
            sb_columns1.append(" FROM ( SELECT [Node].NodeNo , [Node].Location ,[ResultData2].DATETIME , CAST([ResultData2].[SensorNo] AS VARCHAR) + '_' + CAST([ResultData2].[Channel] AS VARCHAR) AS [SensorList] , [ResultData2].DATA  FROM (");
            if (sb_columns1.length() > 0){
                sb_sql.append(sb_columns1.toString().substring(1));
            }

            String[] strs = choseWitchTableInfo(grainsize, valuetype);//选择数据源
            String timelength = strs[0];//"15";
            String tablename = strs[1];//"[LiveData]";
            String indexid = strs[2];//"[LiveDataID]";
            String datacolumn = strs[3];//"[Data]";
            String timecolumn = strs[4];//"[CollectionTime]";
            
          //根据Nodeno（节点编号）获取节点标识列表串
            ResultSet ds_nodeUniqs = GetNodeUnqiuesByNodeNos(nodenolist);
            String nodeUniques = "";//节点标识列表（已用"'"号区分）
              if(ds_nodeUniqs!=null) {
                  try {
                      while(ds_nodeUniqs.next()){
                          nodeUniques += "'" +ds_nodeUniqs.getString("UniqueID") + "',";
                      }
                } catch (Exception e) {
                    e.printStackTrace();
                }
              }
              if (!TextUtils.isEmpty(nodeUniques) && nodeUniques.endsWith(",")){
                  nodeUniques = nodeUniques.substring(0, nodeUniques.length()-1);
              }

              sb_sql.append(" SELECT SUBSTRING(CONVERT(VARCHAR(20), "+timecolumn+", 20), 1, "+timelength+") AS DATETIME , [UniqueID] , [Channel] , [SensorNo] , MAX("+datacolumn+") AS DATA " +
              		"FROM ( SELECT  "+timecolumn+" ,UniqueID , Channel ,SensorNo ,"+datacolumn+" FROM  "+tablename+" WHERE   "+timecolumn+" > '"+begintime+"' AND "+timecolumn+" < '"+endtime+"' AND UniqueID IN ("+nodeUniques+") ) ResultData1 ");
              
              sb_sql.append(" GROUP BY SUBSTRING(CONVERT(VARCHAR(20), "+timecolumn+" , 20) , 1 , "+timelength+"),[UniqueID] , [Channel] , [SensorNo] ) [ResultData2] JOIN [Node] ON [ResultData2].UniqueID = [Node].UniqueID JOIN [Sensor] ON [Sensor].SensorNo = [ResultData2].SensorNo ) [ResultData3] ");
              //用于转置
              sb_sql.append("PIVOT ( MAX([ResultData3].DATA) FOR [ResultData3].[SensorList] IN ( "+sb_columns2.toString()+" ) ) [SensorColumn]");
              sb_sql.insert(0, "SELECT  * , ROW_NUMBER() OVER ( ORDER BY " + orderby + " ) AS [RANK] FROM (");
              sb_sql.append(" ) AS [Table] WHERE 1=1");
              //筛选出符合该节点编号的数据
              if (!TextUtils.isEmpty(nodenolist)) {
                  sb_sql.append(" AND 节点编号 IN ("+nodenolist+")");
              }
              
            //分页
              if (beginindex != -1 && endindex != -1) {
                  sb_sql.insert(0, "SELECT * FROM (");
                  sb_sql.append(" ) AS [Table] WHERE 1=1");
                  sb_sql.append(" AND [Table].[RANK] >= "+beginindex+" AND [Table].[RANK] <" + endindex);
              }
              ds = DbHelperSQL.Query(sb_sql.toString());
        }

        return ds;
    }
    
    /*
    public int GetDataCount(String grainsize, String valuetype, String begintime, String endtime, boolean unit,String nodenolist){
        String key = grainsize + valuetype + begintime + endtime + unit + nodenolist;
        String hashkey = key.GetHashCode().ToString();//获取hashkey为字典ID
        String CacheKey = "LiveData-GetDataCount-" + hashkey.toString();
//        object objModel = System.Web.HttpRuntime.Cache.Get(CacheKey);
       if(objModel==null) {   
           objModel = dal.GetDataCount(grainsize, valuetype, begintime, endtime,unit, nodenolist);
          DateTime expireTime=DateTime.Now.AddMinutes(15);
            switch (grainsize)
            {
                case "逐分钟":
                    expireTime=DateTime.Now.AddMinutes(1);
                    break;
                case "十分钟":
                   expireTime=DateTime.Now.AddMinutes(6);
                    break;
                default : break;
            }   
            System.Web.HttpRuntime.Cache.Add(CacheKey, objModel, null, expireTime, TimeSpan.Zero, System.Web.Caching.CacheItemPriority.Normal, null);
            return (int)objModel;
       } else {   
           return(int)objModel;
       }
    }*/
    
    /*
    public int GetDataCount(String grainsize, String valuetype, String begintime, String endtime, boolean unit,  String nodenolist) {
        List<SensorViewModel> list = mSensorDataAccess.GetSensorListByNodeNoString(nodenolist);
        if (list.size() > 0) {
            StringBuilder sb_sql = new StringBuilder();
            sb_sql.append("SELECT COUNT(1)as [RowCount]  FROM (");
            sb_sql.append("SELECT NodeNo AS 节点编号 , Location AS 安装地点 , [DATETIME] AS 更新时间 ,");

            StringBuilder sb_columns1 = new StringBuilder();
            StringBuilder sb_columns2 = new StringBuilder();
            for (int i = 0; i < list.size(); i++) 
            {
                String unitstr = "";
                String sensoradd = "";
                if (unit) {
                    unitstr = " + '" + list.get(i)._unit + "'";
                }
                if (list.get(i)._channel > 0) {
                    sensoradd = ""+list.get(i)._channel;
                }
                sb_columns1.AppendFormat(" replace(convert(VARCHAR,convert(float,round(SensorColumn.[{0}_{1}],{2}))){3}, '32767'{3}, '无') AS [{4}] ,",
                        list.get(i)._sensorno, list.get(i)._channel, list.get(i)._accuracy, unitstr, list.get(i)._shortname + sensoradd);
                sb_columns2.AppendFormat("[{0}_{1}],", list.get(i)._sensorno, list.get(i)._channel);

            }
            sb_columns2.deleteCharAt(sb_columns2.length()-1);
            sb_columns1.deleteCharAt(sb_columns1.length()-1);
            sb_columns1.append(" FROM ( SELECT [Node].NodeNo , [Node].Location ,[ResultData2].DATETIME , CAST([ResultData2].[SensorNo] AS VARCHAR) + '_' + CAST([ResultData2].[Channel] AS VARCHAR) AS [SensorList] , [ResultData2].DATA  FROM (");
            if (sb_columns1.length() > 0){
                sb_sql.append(sb_columns1.toString().subString(1));
            }
            String[] strs = choseWitchTableInfo(grainsize, valuetype);//选择数据源
            String timelength = strs[0];//"15";
            String tablename = strs[1];//"[LiveData]";
            String indexid = strs[2];//"[LiveDataID]";
            String datacolumn = strs[3];//"[Data]";
            String timecolumn = strs[4];//"[CollectionTime]";
            
            ////根据Nodeno（节点编号）获取节点标识列表串
            ResultSet ds_nodeUniqs = GetNodeUnqiuesByNodeNos(nodenolist);
            String nodeUniques = "";//节点标识列表（已用"'"号区分）
            if (ds_nodeUniqs != null) {
                while(ds_nodeUniqs.next()){
                    nodeUniques += "'" + ds_nodeUniqs.getString("UniqueID") + "',";
                }
                ds_nodeUniqs.close();
            }
            if (!TextUtils.isEmpty(nodeUniques) && nodeUniques.endsWith(",")){//去除末尾逗号
                nodeUniques = nodeUniques.substring(0, nodeUniques.length()-1);
            }

            sb_sql.AppendFormat(" SELECT SUBSTRING(CONVERT(VARCHAR(20), "+timecolumn+", 20), 1, "+timelength+") AS DATETIME , [UniqueID] , [Channel] , [SensorNo] , MAX({1}) AS DATA FROM" +
            		" ( SELECT  {5} ,UniqueID , Channel ,SensorNo ,{1} FROM" +
            		"  {2} WHERE   {5} > '{3}' AND {5} < '{6}' AND UniqueID IN ({7}) ) ResultData1 ", timelength, datacolumn, tablename, begintime, indexid, timecolumn, endtime, nodeUniques);
            sb_sql.AppendFormat(" GROUP BY SUBSTRING(CONVERT(VARCHAR(20), {1} , 20) , 1 , {0}),[UniqueID] , [Channel] , [SensorNo] ) [ResultData2] JOIN [Node] ON [ResultData2].UniqueID = [Node].UniqueID JOIN [Sensor] ON [Sensor].SensorNo = [ResultData2].SensorNo ) [ResultData3] ", timelength, timecolumn);

            sb_sql.AppendFormat("PIVOT ( MAX([ResultData3].DATA) FOR [ResultData3].[SensorList] IN ( {0} ) ) [SensorColumn]", sb_columns2.toString());
            sb_sql.append(" ) AS [Table] WHERE 1=1");
            //筛选出符合该节点编号的数据
            if (!TextUtils.isEmpty(nodenolist)) {
                sb_sql.append(" AND 节点编号 IN ("+nodenolist+")");
            }
            ResultSet ds = DbHelperSQL.Query(sb_sql.toString());
            if (ds.last()){
                return ds.getRow();
            }
        }
        return 0;
    }*/
    
    private String[] choseWitchTableInfo(String grainsize, String valuetype){
        String[] strs = new String[5];
        
        String timelength = "15";
        String tablename = "[LiveData]";
        String indexid = "[LiveDataID]";
        String datacolumn = "[Data]";
        String timecolumn = "[CollectionTime]";
        
        if ("逐分钟".equals(grainsize)){
            timelength = "19";
            tablename = "[LiveData]";
            timecolumn = "[CollectionTime]";
        } else if ("十分钟".equals(grainsize)){
            timelength = "16";
            tablename = "[DataByTen]";
            timecolumn = "[CountTime]";
            indexid = "[EveryYearByMinuteID]";
        } else if ("逐小时".equals(grainsize)){
            timelength = "13";
            tablename = " [DataByHour]";
            timecolumn = "[CountTime]";
            indexid = "[EveryYearByHourID]";
        } else if ("逐日".equals(grainsize)){
            timelength = "10";
            tablename = "[DataByDay]";
            timecolumn = "[CountTime]";
            indexid = "[EveryYearByDayID]";
        } else if ("逐月".equals(grainsize)){
            timelength = "7";
            tablename = "[DataByMonth]";
            timecolumn = "[CountTime]";
            indexid = "[EveryYearByMonthID]";
        } else if ("逐年".equals(grainsize)){
            timelength = "4";
            tablename = "[DataByDay]";
            timecolumn = "[CountTime]";
            indexid = "[EveryYearByDayID]";
        } else {
            timelength = "15";
            tablename = "[LiveData]";
            timecolumn = "[CollectionTime]";
            indexid = "[LiveDataID]";
        }
        
        if (!"逐分钟".equals(grainsize)){
            if ("最大值".equals(valuetype.toUpperCase())){
                datacolumn = "MaxData";
            } else if ("平均值".equals(valuetype)){
                datacolumn = "AvgData";
            } else if ("最小值".equals(valuetype)){
                datacolumn = "MinData";
            } else if ("累计值".equals(valuetype)){
                datacolumn = "SumData";
            } else {
                datacolumn = "Data";
            }
        }
        strs[0] = timelength;
        strs[1] = tablename;
        strs[2] = indexid;
        strs[3] = datacolumn;
        strs[4] = timecolumn;
        return strs;
    }
    
    public List<LiveDataModel> GetNewestDataFromLiveData(int scanCount, String where){
//        scanCount = 10000;
        String strSql = "SELECT 0 AS [LiveDataID], T2.CollectionTime ,T2.UniqueID,T2.Channel,T2.SensorNo,T2.Data FROM " +
        		"( SELECT T1.LiveDataID ,T1.CollectionTime,T1.UniqueID,T1.Channel,T1.SensorNo,T1.Data,RANK()OVER(PARTITION BY UniqueID ORDER BY CollectionTime DESC)" +
        		"AS [rowNumber]  FROM (SELECT TOP "+scanCount+" * FROM LiveData)T1  where "+where+" )T2 WHERE T2.rowNumber=1 ORDER BY T2.CollectionTime DESC;";
        ResultSet ds = DbHelperSQL.Query(strSql);
        if (null != ds){
            List<LiveDataModel> list = DataTableToList(ds);
            try {
                ds.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return list;
        }
        return null;
    }
    
    public List<LiveDataModel> DataTableToList(ResultSet c){
        List<LiveDataModel> models = new ArrayList<LiveDataModel>();
        LiveDataModel m = new LiveDataModel();
        try {
            while(c.next()){
                m = DataRowToModel(c);
                if (m != null){
                    models.add(m);
                }
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;
    }
    
    private LiveDataModel DataRowToModel(ResultSet c){
        LiveDataModel m = new LiveDataModel();
        try {
            m._livedataid = c.getInt("LiveDataID");
            m._collectiontime = c.getTimestamp("CollectionTime");
            m._uniqueid = c.getString("UniqueID");
            m._channel = c.getInt("Channel");
            m._sensorno = c.getInt("SensorNo");
            m._data = c.getFloat("Data");
            return m;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
    
    
    public ResultSet GetNodeUnqiuesByNodeNos(String nodenos) {
        StringBuilder strSql = new StringBuilder();
        strSql.append("select UniqueID");
        strSql.append(" FROM Node ");
        strSql.append("where NodeNo in (" + nodenos + ")");
        return DbHelperSQL.Query(strSql.toString());
    }
    
}