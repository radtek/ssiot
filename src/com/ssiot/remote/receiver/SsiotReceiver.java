package com.ssiot.remote.receiver;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.ssiot.remote.R;
import com.ssiot.remote.MainActivity;
import com.ssiot.remote.SettingFrag;
import com.ssiot.remote.SsiotConfig;
import com.ssiot.remote.SsiotService;
import com.ssiot.remote.UpdateDialogActivity;
import com.ssiot.remote.UpdateManager;
import com.ssiot.remote.Utils;

import java.io.File;
import java.util.HashMap;

public class SsiotReceiver extends BroadcastReceiver{
    private static final String tag = "SsiotReceiverFish";
    public static final String ACTION_SSIOT_MSG = "com.ssiot.remote.SHOWMSG";
    static final String BOOTACTION = "android.intent.action.BOOT_COMPLETED";
    public static final String ACTION_SSIOT_V_GOT = "com.ssiot.remote.update.versiongot";
    public static final String ACTION_SSIOT_V_DOWNLOAD_PROGRESS = "com.ssiot.remote.update.downloadprogress";
    public static final String ACTION_SSIOT_V_DOWNLOAD_FINISH = "com.ssiot.remote.update.downfinish";
    public static final String ACTION_SSIOT_V_DOWNLOAD_ERROR = "com.ssiot.remote.update.error";
    
    public static final int NOTIFICATION_FLAG = 1; 
    Notification mProgressNoti;
    @Override
    public void onReceive(Context context, Intent intent) {
        
        String action = intent.getAction();
        Log.v(tag, "-----onReceive-----" + action +" "+ intent);
        
        if (ACTION_SSIOT_MSG.equals(action)){
            
            String extraString = intent.getStringExtra("showmsg");
            Log.v(tag, "----onReceive----showmsg:" +extraString);
            Toast.makeText(context, extraString + "，请检查网络后重试。", Toast.LENGTH_SHORT).show();
        } else if (BOOTACTION.equals(action)){
            if (Utils.getBooleabPref(Utils.PREF_ALARM, context)){
                Intent myintent = new Intent(context, SsiotService.class);
                context.startService(myintent);
            }
        } else if (ACTION_SSIOT_V_GOT.equals(action)){
            intent.getIntExtra("updatestatus", -1);
            int remoteVer = intent.getIntExtra("remoteversion", -1);
            int curentV = intent.getIntExtra("currentversion", -1);
            if (remoteVer <= 0){//大多是网络问题
                Intent i = new Intent(SettingFrag.ACTION_SSIOT_UPDATE);
                i.putExtra("checkresult", 0);
                context.sendBroadcast(i);
            } else if (remoteVer > curentV){//remoteversion > curVersion
                
                HashMap<String, String> mVerInfoMap = (HashMap<String, String>) intent.getSerializableExtra("versionxmlmap");
                Intent userCheckDialog = new Intent(context, UpdateDialogActivity.class);
                userCheckDialog.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                userCheckDialog.putExtra("versionxmlmap", mVerInfoMap);
                context.startActivity(userCheckDialog);
                
                Intent i = new Intent(SettingFrag.ACTION_SSIOT_UPDATE);
                i.putExtra("checkresult", 1);
                context.sendBroadcast(i);
            } else if (remoteVer == curentV){
                Intent i = new Intent(SettingFrag.ACTION_SSIOT_UPDATE);
                i.putExtra("checkresult", 2);
                context.sendBroadcast(i);
            } else {
                Toast.makeText(context, "本地版本高于服务器版本", Toast.LENGTH_SHORT).show();
            }
            
        } else if (ACTION_SSIOT_V_DOWNLOAD_PROGRESS.equals(action)){
            int pro = intent.getIntExtra("downloadprogress", 0);
            Log.v(tag, "----------ACTION_SSIOT_V_DOWNLOAD_PROGRESS"+pro + (null != mProgressNoti));
            if (null != mProgressNoti){
                NotificationManager mnotiManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                mProgressNoti.setLatestEventInfo(context, "正在更新", "已下载：" + pro + "%", 
                        PendingIntent.getActivity(context, -1, new Intent(""), 0));
                mnotiManager.notify(UpdateManager.NOTIFICATION_FLAG, mProgressNoti);
            } else {
                mProgressNoti = showNotification(context,pro);
            }
        } else if (ACTION_SSIOT_V_DOWNLOAD_FINISH.equals(action)){
            NotificationManager mnotiManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mnotiManager.cancel(UpdateManager.NOTIFICATION_FLAG);
            installApk(context);
        } else if (ACTION_SSIOT_V_DOWNLOAD_ERROR.equals(action)){
            NotificationManager mManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mManager.cancel(UpdateManager.NOTIFICATION_FLAG);
            Toast.makeText(context, "下载出现错误", Toast.LENGTH_LONG).show();
        }
    }
    
    
    
    
    
    
    @SuppressLint("NewApi") //必须检查版本
    public Notification showNotification(Context c,int pro) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            Notification notification = new Notification(R.drawable.ic_launcher, "更新", System.currentTimeMillis());
            notification.setLatestEventInfo(c, "111111111", "22222222", 
                    PendingIntent.getActivity(c, -1, new Intent(""), pro));
            NotificationManager mnotiManager = (NotificationManager) c
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            mnotiManager.notify(NOTIFICATION_FLAG, notification);
            return notification;
        } else {
            Notification.Builder builder = new Notification.Builder(c);
            // builder.setTicker(title);
            builder.setSmallIcon(R.drawable.ic_launcher);
            builder.setWhen(System.currentTimeMillis());
            builder.setContentTitle("正在更新");
            builder.setContentText("已下载："+pro+"%");
            builder.setAutoCancel(false);
            builder.setProgress(100, pro, false);
            // builder.setContentIntent(PendingIntent.getActivity(c, 0, new
            // Intent(Intent.ACTION_DELETE), 0));

            // Notification noti = new Notification();
            RemoteViews remoteView = new RemoteViews(c.getPackageName(),
                    R.layout.notification_download);
            remoteView.setProgressBar(R.id.noti_progress, 100, 20, false);
            remoteView.setImageViewResource(R.id.noti_image, R.drawable.ic_launcher);
            remoteView.setTextViewText(R.id.noti_text, "我的新通知");
            // builder.setContent(remoteView);
            Notification noti = builder.build();
            // noti.contentView = remoteView;
//            noti.flags |= Notification.FLAG_ONGOING_EVENT;

            NotificationManager mnotiManager = (NotificationManager) c
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            mnotiManager.notify(NOTIFICATION_FLAG, noti);
            return noti;
        }
    }
    
    public void installApk(Context context) {
        File apkfile = new File(UpdateManager.getSavePath(), "ssiot2.apk");
        if (!apkfile.exists()) {
            Toast.makeText(context, "未找到文件" + apkfile.getPath(), Toast.LENGTH_SHORT).show();
            return;
        }
        // 通过Intent安装APK文件
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
        i.setDataAndType(Uri.parse("file://" + apkfile.toString()), "application/vnd.android.package-archive");
        context.startActivity(i);
    }
    
    
}