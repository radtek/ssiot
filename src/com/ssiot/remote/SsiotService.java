package com.ssiot.remote;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;

import com.ssiot.remote.data.DataAPI;
import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.business.AlarmRule;
import com.ssiot.remote.data.business.ControlActionInfo;
import com.ssiot.remote.data.business.LiveData;
import com.ssiot.remote.data.business.Node;
import com.ssiot.remote.data.business.Sensor;
import com.ssiot.remote.data.model.AlarmRuleBean;
import com.ssiot.remote.data.model.AlarmRuleModel;
import com.ssiot.remote.data.model.ControlActionInfoModel;
import com.ssiot.remote.data.model.LiveDataModel;
import com.ssiot.remote.data.model.NodeModel;
import com.ssiot.remote.data.model.SensorModel;
import com.ssiot.remote.monitor.MoniAlarmFrag;

import java.nio.channels.SelectableChannel;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SsiotService extends Service{
    private static final String tag = "SsiotService";
    private static int NOTIFICATION_ID = 101;
    private ControlActionInfo controlActionInfoBll = new ControlActionInfo();
    private LiveData liveDataBll = new LiveData();
//    private List<ControlActionInfoModel> actionInfoList = new ArrayList<ControlActionInfoModel>();
    private List<LiveDataModel> newestDataList = new ArrayList<LiveDataModel>();
    public static boolean cancel = false;
    private Object lock = new Object();
    SharedPreferences mPref;
    private LiveDataBackWorker mWorker;
    List<AlarmRuleModel> mAlarmModels;
    private List<NotiInfo> notiInfos = new ArrayList<SsiotService.NotiInfo>();
    List<SensorModel> sensor_dic;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
        mPref = PreferenceManager.getDefaultSharedPreferences(this);
        Log.v(tag, "-------------onCreate---------------");
//        actionInfoList = controlActionInfoBll.GetModelList(" ControlType=6 AND Operate='打开'");
//        newestDataList = liveDataBll.GetNewestDataFromLiveData(10000);
        mWorker = new LiveDataBackWorker();
    }
    
    @Override
    @Deprecated
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.v(tag, "-------------onStart---------------");
    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(tag, "-------------onStartCommand---------------");
        cancel = false;
        if (!mWorker.isAlive() && isLogedIn() && Utils.getBooleabPref(Utils.PREF_ALARM, this)){
            mWorker.start();//TODO
        }
        return super.onStartCommand(intent, flags, startId);
        
    }
    
    private class LiveDataBackWorker extends Thread{
        @Override
        public void run() {
            cancel = false;
            while (!cancel) {
                synchronized (lock) {
                    
                    try {
                        Thread.sleep(60 * 1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (false == mPref.getBoolean("alarm", true)){//TODO
                        Log.v(tag, "-----alarm set false-----" + new Date().toString());
                        continue;
                    }
                    if (!Utils.isNetworkConnected(SsiotService.this)){
                        Log.v(tag, "-----no net-----" + new Date().toString());
                        continue;
                    }
                    if (null == sensor_dic || sensor_dic.size() == 0){
                        sensor_dic = new Sensor().GetModelList("1=1");
                    }
                    getWitchToCompare("");
                    
                    
                    String alarmUniques = "";
                    if (null != mAlarmModels && mAlarmModels.size() > 0){//找出包含的节点
                        for (int i = 0; i < mAlarmModels.size(); i ++){
                            alarmUniques += mAlarmModels.get(i)._uniqueID + ",";
                        }
                        if (!TextUtils.isEmpty(alarmUniques) && alarmUniques.endsWith(",")){
                            alarmUniques = alarmUniques.substring(0, alarmUniques.length()-1);
                        }
                    } else {
                        continue;//没有预警规则
                    }
                    List<LiveDataModel> tmp = null;
                    if (!TextUtils.isEmpty(alarmUniques)){
                        tmp = liveDataBll.GetNewestDataFromLiveData(10000," UniqueID in(" +alarmUniques+")" );
                    }
                    newestDataList.clear();
                    if (tmp != null && tmp.size() > 0){
                        newestDataList.addAll(tmp);
                    }
                    compare(newestDataList, mAlarmModels);
                }
            }
        }
    }

    private void getWitchToCompare(String account){//TODO account
        account = mPref.getString(Utils.PREF_USERNAME, "");
        if (TextUtils.isEmpty(account)){
            Log.e(tag, "------account = null");
            return;
        }
        String areas = DataAPI.GetAllAreaIDsByAccount(account);
        Node nodeBll = new Node();
        List<NodeModel> nodes = nodeBll.GetModelListByAreaIDs(areas);
        String nodeUniques = "";
        if (null != nodes){
            for (int i = 0; i < nodes.size(); i ++){
                nodeUniques += nodes.get(i)._uniqueid + ",";
            }
        }
        if (!TextUtils.isEmpty(nodeUniques) && nodeUniques.endsWith(",")){
            nodeUniques = nodeUniques.substring(0, nodeUniques.length()-1);
        }
        AlarmRule alarmBll = new AlarmRule();
        if (!TextUtils.isEmpty(nodeUniques)){
            mAlarmModels = alarmBll.GetModelList(" NodeUniqueID in (" + nodeUniques+")");
        }
    }
    
    private void compare(List<LiveDataModel> lives, List<AlarmRuleModel> alarms){
        if (null != alarms){
            for (int i = 0; i < alarms.size();i ++){
                AlarmRuleModel model = alarms.get(i);
                String unique = model._uniqueID;
                List<LiveDataModel> list = getThisNodeData(lives, unique);
                List<AlarmRuleBean> beanList = model.parseAlarmJSON(model._ruleStr);
                if (MoniAlarmFrag.relationDatas[0].equals(model._relation)){//规则1;同时满足条件
                    int alarmFlag = 0;//
                    for(int k = 0; k < beanList.size(); k ++){//遍历一个节点下的 sensor规则
                        AlarmRuleBean bean = beanList.get(k);
                        for (int kk = 0; kk < list.size(); kk ++){//对一条sensor规则 遍历livedata
                            LiveDataModel m = list.get(kk);
                            if (m._sensorno == bean.sensorType && m._channel == bean.channel){//找到了
                                if ("大于".equals(bean.type)){
                                    float val = Float.parseFloat(bean.value);
                                    if (m._data > val){
                                        alarmFlag ++;
                                    }
                                } else if ("小于".equals(bean.type)){
                                    float val = Float.parseFloat(bean.value);
                                    if (m._data < val){
                                        alarmFlag ++;
                                    }
                                } else if ("之间".equals(bean.type)){
                                    float val1 = Float.parseFloat(bean.value.substring(0, bean.value.indexOf(",")));
                                    float val2 = Float.parseFloat(bean.value.substring(bean.value.indexOf(",") + 1,bean.value.length()));
                                    if (m._data >= val1 && m._data <= val2){
                                        alarmFlag ++;
                                    }
                                }
                                break;
                            }
                        }
                    }
                    if (alarmFlag > 0 && alarmFlag == beanList.size()){
                        sendNotification(unique, list);
                    }
                } else {//规则2:满足其中之一
                    boolean alarmF = false;
                    for(int k = 0; k < beanList.size(); k ++){//遍历一个节点下的 sensor规则
                        AlarmRuleBean bean = beanList.get(k);
                        for (int kk = 0; kk < list.size(); kk ++){//对一条sensor规则 遍历livedata
                            LiveDataModel m = list.get(kk);
                            if (m._sensorno == bean.sensorType && m._channel == bean.channel){//找到了
                                if ("大于".equals(bean.type)){
                                    float val = Float.parseFloat(bean.value);
                                    if (m._data > val){
                                        alarmF = true;
                                        sendNotification(unique, list);
                                    }
                                } else if ("小于".equals(bean.type)){
                                    float val = Float.parseFloat(bean.value);
                                    if (m._data < val){
                                        alarmF = true;
                                        sendNotification(unique, list);
                                    }
                                } else if ("之间".equals(bean.type)){
                                    float val1 = Float.parseFloat(bean.value.substring(0, bean.value.indexOf(",")));
                                    float val2 = Float.parseFloat(bean.value.substring(bean.value.indexOf(",") + 1,bean.value.length()));
                                    if (m._data >= val1 && m._data <= val2){
                                        alarmF = true;
                                        sendNotification(unique, list);
                                    }
                                }
                                break;
                            }
                        }
                        if (alarmF){
                            break;
                        }
                    }
                }
                
            }
        }
        //发通知， 且记录到数据库 时间 节点 (传感器s 数值s)
        
    }
    
    private List<LiveDataModel> getThisNodeData(List<LiveDataModel> lives,String nodeUnique){
        List<LiveDataModel> list = new ArrayList<LiveDataModel>();
        for (int i = 0; i < lives.size(); i ++){
            if (nodeUnique.equals(lives.get(i)._uniqueid)){
                list.add(lives.get(i));
            }
        }
        return list;
    }
    
    private void sendNotification(String unique,List<LiveDataModel> thisnodeDatas){
        Log.w(tag, "-----alarming------" + unique);
        showNotification(this, unique, thisnodeDatas);
    }
    
    @SuppressLint("NewApi") //必须检查版本
    private Notification showNotification(Context c, String unique, List<LiveDataModel> singleNodeDatas) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            Notification notification = new Notification(R.drawable.ic_launcher, "更新", System.currentTimeMillis());
            notification.setLatestEventInfo(c, "111111111", "22222222", 
                    PendingIntent.getActivity(c, -1, new Intent(""), 0));
            NotificationManager mnotiManager = (NotificationManager) c
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            mnotiManager.notify(NOTIFICATION_ID, notification);
            return notification;
        } else {
            Notification.Builder builder = new Notification.Builder(c);
            // builder.setTicker(title);
            builder.setSmallIcon(R.drawable.ic_launcher);
            builder.setWhen(System.currentTimeMillis());
            String contentTxt = "";
            if (null != singleNodeDatas && singleNodeDatas.size() > 0){
                builder.setContentTitle("预警节点:" + singleNodeDatas.get(0)._uniqueid);
                
                for (int i = 0; i < singleNodeDatas.size(); i ++){
                    LiveDataModel liveDataModel = singleNodeDatas.get(i);
                    contentTxt += buildContentText(liveDataModel);
                }
                builder.setContentText("监测值：" + contentTxt);
                Log.v(tag, "---notimsg:" + contentTxt);
            }
            
            builder.setAutoCancel(true);
//            builder.setContentIntent(PendingIntent.getActivity(c, 0, new Intent(c, FirstStartActivity.class), PendingIntent.FLAG_UPDATE_CURRENT));//TODO 

            // Notification noti = new Notification();
            /*RemoteViews remoteView = new RemoteViews(c.getPackageName(),
                    R.layout.notification_download);
            remoteView.setProgressBar(R.id.noti_progress, 100, 20, false);
            remoteView.setImageViewResource(R.id.noti_image, R.drawable.ic_launcher);
            remoteView.setTextViewText(R.id.noti_text, "我的新通知");*/
            // builder.setContent(remoteView);
            Notification noti = builder.build();
            // noti.contentView = remoteView;
//            noti.flags |= Notification.FLAG_ONGOING_EVENT;
            noti.sound = Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.beep); 
            NotificationManager mnotiManager = (NotificationManager) c
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            if (!nearlyExists(unique, notiInfos)){
                mnotiManager.notify(Integer.parseInt(unique), noti);
                notiInfos.add(new NotiInfo(System.currentTimeMillis(), unique,contentTxt));
            }
            return noti;
        }
    }
    
    private String buildContentText(LiveDataModel live){
        String str = "";
        if (null != sensor_dic && sensor_dic.size() > 0){
            for (int i = 0; i < sensor_dic.size(); i ++){
                if (live._sensorno == sensor_dic.get(i)._sensorno){
                    if (TextUtils.isEmpty(sensor_dic.get(i)._unit)){
                        str = ""+sensor_dic.get(i)._sensorname + live._channel + ":" + live._data + ";";
                    } else {
                        str = ""+sensor_dic.get(i)._sensorname + live._channel + ":" + live._data + sensor_dic.get(i)._unit + ";";
                    }
                    break;
                }
            }
        } else {
            str = ""+live._sensorno + live._channel + ":" + live._data + ";";
        }
        return str;
    }
    
    private boolean nearlyExists(String unique, List<NotiInfo> notis){
        for (int j = 0; j < notis.size(); j ++){//删除老的记录
            if (System.currentTimeMillis() - notis.get(j).time > 20 * 60 * 1000){//20分钟前的数据 
                notis.remove(j);
                j --;
            }
        }
        if (null != notis){
            for (int i = 0; i < notis.size(); i ++){
                if ((System.currentTimeMillis() - notis.get(i).time < 2 * 60 * 1000) && unique.equals(notis.get(i).nodeUnique)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isLogedIn(){
        if (mPref == null){
            return false;
        }
        String pwd = mPref.getString(Utils.PREF_PWD, "");
        return !TextUtils.isEmpty(pwd);
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(tag, "-------------onDestroy--------restart-------" + !cancel);
        if (!cancel){//特殊情况下ondestroy的才重启
            Intent localIntent = new Intent();  
            localIntent.setClass(this, SsiotService.class);
            startService(localIntent);
        }
        //方法2:如果想让服务不被杀死（也即无动作不改变），在XML的<application段后面加上 android:persistent="true"就行了。
    }
    
    public class NotiInfo{
        public long time;
        public String nodeUnique;
        public String dataStr;
        public NotiInfo(long timeMills, String uni,String datas){
            time = timeMills;
            nodeUnique = uni;
            dataStr = datas;
        }
    }
    
}