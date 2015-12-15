package com.ssiot.remote.dahuavideo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.SurfaceHolder.Callback;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.company.NetSDK.CB_fDisConnect;
import com.company.NetSDK.CB_fHaveLogin;
import com.company.NetSDK.CB_fHaveReConnect;
import com.company.NetSDK.CB_fMessageCallBack;
import com.company.NetSDK.CB_fRealDataCallBackEx;
import com.company.NetSDK.CB_fSubDisConnect;
import com.company.NetSDK.CFG_CAP_ALARM_INFO;
import com.company.NetSDK.DEV_PLAY_RESULT;
import com.company.NetSDK.FinalVar;
import com.company.NetSDK.INetSDK;
import com.company.NetSDK.NET_DEVICEINFO;
import com.company.NetSDK.NET_DEVICEINFO_Ex;
import com.company.NetSDK.NET_PARAM;
import com.company.NetSDK.SDK_DEV_ENABLE_INFO;
import com.company.NetSDK.SDK_DEV_FUNC;
import com.company.NetSDK.SDK_EXTPTZ_ControlType;
import com.company.NetSDK.SDK_PRODUCTION_DEFNITION;
import com.company.NetSDK.SDK_PTZ_ControlType;
import com.company.NetSDK.SDK_RealPlayType;
import com.company.NetSDK.SDK_SYS_ABILITY;
import com.company.PlaySDK.IPlaySDK;
import com.company.PlaySDK.IPlaySDKCallBack.DEMUX_INFO;
import com.company.PlaySDK.IPlaySDKCallBack.fDemuxCBFun;
import com.ssiot.remote.R;
import com.ssiot.remote.Utils;

import java.io.FileOutputStream;
import java.io.IOException;

public class DahuaLiveActivity extends ActionBarActivity{
    private static final String tag = "DahuaLiveActivity";
    
    static long m_loginHandle = 0;
    static NET_DEVICEINFO deviceInfo;
    static boolean m_speedCtrl;
    static int m_schedule;
    private int nSpecCap = 20;
    static CFG_CAP_ALARM_INFO stCfgCapAlarm = new CFG_CAP_ALARM_INFO();
    private int nExtraChnNum;
    private int nExtraAlarmOutPortNum;
    
    byte m_bSpeed = 5;
    
    private String mStrIp = "";
    private String mStrport = "";
    private String mStrUserName = "";
    private String mStrPassWord = "";
    
    private String mAddrTitle = "";
    
    private Dialog mDialog;
    //-----------------------------------
    SurfaceView m_PlayView;
    private int nPort;
    private long lRealHandle = 0;
    static int m_nGlobalChn = 0;//jingbo this is in Golobalactivity ori
    private FileOutputStream m_Fout;
    private TestRealDataCallBackEx m_callback = new TestRealDataCallBackEx();
    private TestVideoDataCallBack m_VideoCallback = new TestVideoDataCallBack();
    
    public class DeviceDisConnect implements CB_fDisConnect {
        @Override
        public void invoke(long lLoginID, String pchDVRIP, int nDVRPort) {
            ToolKits.writeLog("Device " + pchDVRIP + " DisConnect!");
            return ;
        }
    }
    
    public class DeviceReConnect implements CB_fHaveReConnect {
        @Override
        public void invoke(long lLoginID, String pchDVRIP, int nDVRPort) {
            ToolKits.writeLog("Device " + pchDVRIP + " ReConnect!");
        }
    }
    
    public class DeviceSubDisConnect implements CB_fSubDisConnect {
        @Override
        public void invoke(int emInterfaceType, boolean bOnline,
                long lOperateHandle, long lLoginID) {
            ToolKits.writeLog("Device SubConnect DisConnect");
        }
    }
    
    private static final int  MSG_VIDEO_LOGIN_FAIL = 1;
    
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case MSG_VIDEO_LOGIN_FAIL:
                    ToolKits.showErrorMessage(DahuaLiveActivity.this, getResources().getString(R.string.login_activity_login_failed));
                    break;

                default:
                    break;
            }
        }
    };
    
    ////连云港已装的大华 112.4.228.23 web9200 tcp37771 rtsp5551
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dahua_videolive);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        INetSDK.LoadLibrarys();
        DeviceDisConnect disConnect = new DeviceDisConnect(); 
        boolean zRet = INetSDK.Init(disConnect);
        INetSDK.SetConnectTime(4000, 3);
        NET_PARAM stNetParam = new NET_PARAM();
        stNetParam.nWaittime = 30000;   //函数等待超时时间
        stNetParam.nSearchRecordTime = 30000;  //录像回放超时时间
        INetSDK.SetNetworkParam(stNetParam);
        
        nSpecCap = 20;
        mStrIp = getIntent().getStringExtra("videoip");
        mStrport = ""+getIntent().getIntExtra("tcpport",0);//videoport
        mStrUserName = getIntent().getStringExtra("videoname");
        mStrPassWord = getIntent().getStringExtra("videopswd");
        mAddrTitle = getIntent().getStringExtra("addrtitle");
        Log.v(tag, ""+mStrIp + " "+mStrport + ""+ mStrUserName +" " +mStrPassWord + " " +mAddrTitle);
//        mStrIp = "112.4.228.23";
//        mStrport = "37771";
//        mStrUserName = "admin";
//        mStrPassWord = "admin";
        
        TextView mTitleView = (TextView) findViewById(R.id.video_title);
        mTitleView.setText(mAddrTitle);
        m_PlayView = (SurfaceView)findViewById(R.id.view_PlayWindow);
        View m_layoutPtz = View.inflate(this, R.layout.dahua_ptzview, null);
        RelativeLayout rLayout = (RelativeLayout) findViewById(R.id.ptzroot);
        initPTZ(rLayout);
        showDialog();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                login(getApplicationContext());
                init_2();
                dismissDialog();
            }
        }).start();
    }
    
    private void login(Context context){
        if (m_loginHandle !=0) {
            INetSDK.Logout(m_loginHandle);
            m_loginHandle = 0;
        }
        
        deviceInfo = new NET_DEVICEINFO();
        Integer error = new Integer(0);
        
        DeviceReConnect reConnect = new DeviceReConnect();
        INetSDK.SetAutoReconnect(reConnect);
        
        DeviceSubDisConnect subDisConnect = new DeviceSubDisConnect();
        INetSDK.SetSubconnCallBack(subDisConnect);
        
        INetSDK.SetDVRMessCallBack(new Test_CB_fMessageCallBack());
//        String strIp        = "blg02.dahuaddns.com";
//        String strPort = "37775";
        String strIp        = mStrIp;
        String strPort      = mStrport;
        String strUser      = mStrUserName;
        String strPassword  = mStrPassWord;
        
        int nDevPort = 37777;
        try {
            nDevPort = Integer.parseInt(strPort);
        } catch (Exception e) {
            e.printStackTrace();
            ToolKits.showMessage(context, getResources().getString(R.string.login_activity_port_err));
            return;
        }
        Log.v(tag, "----------"+strIp + " tcp:"+nDevPort + " rtsp:" + mStrport);
        
        m_loginHandle = INetSDK.LoginEx(strIp, nDevPort, 
                strUser, strPassword, nSpecCap, null, deviceInfo, error);
        
        if ( m_loginHandle != 0 ) {
//            ToolKits.showMessage(context, getResources().getString(R.string.login_activity_login_success));
            
            m_speedCtrl = false;
            m_schedule = 0;
            SDK_DEV_ENABLE_INFO stEnableInfo = new SDK_DEV_ENABLE_INFO();
            if (INetSDK.QuerySystemInfo(m_loginHandle, SDK_SYS_ABILITY.ABILITY_DEVALL_INFO, stEnableInfo, 3000)) {
                if (stEnableInfo.IsFucEnable[SDK_DEV_FUNC.EN_PLAYBACK_SPEED_CTRL] != 0) {
                    m_speedCtrl = true;
                }
                m_schedule = stEnableInfo.IsFucEnable[SDK_DEV_FUNC.EN_SCHEDULE];
            }
            
            stCfgCapAlarm = new CFG_CAP_ALARM_INFO();
            char szOutBuffer[] = new char[10240];
            Integer stError = new Integer(0);
            boolean bQN = INetSDK.QueryNewSystemInfo(m_loginHandle, FinalVar.CFG_CAP_ALARM, 0, szOutBuffer, stError, 5000);
            if (bQN) {
                bQN = INetSDK.ParseData(FinalVar.CFG_CAP_ALARM, szOutBuffer, stCfgCapAlarm, null);
                if (!bQN) {
                    ToolKits.writeErrorLog("INetSDK.ParseData CFG_CAP_ALARM error");
                }
            } else {
                ToolKits.writeErrorLog("INetSDK.QueryNewSystemInfo CFG_CAP_ALARM error");
            }
            
            // TestNetSDKActivity.deviceInfo在activity直接使用出现过问题，改用putextra方式
            nExtraChnNum = deviceInfo.byChanNum;
            if (-1 == deviceInfo.byChanNum) {
                SDK_PRODUCTION_DEFNITION stDef = new SDK_PRODUCTION_DEFNITION();
                boolean bRet = INetSDK.QueryProductionDefinition(m_loginHandle, stDef, 3000);
                if (bRet) {
                    nExtraChnNum = stDef.nVideoInChannel + stDef.nMaxRemoteInputChannels;
                }
            }
            nExtraAlarmOutPortNum = deviceInfo.byAlarmOutPortNum;
            
//            jumpToContentListActivity();
        } else {
            mHandler.sendEmptyMessage(MSG_VIDEO_LOGIN_FAIL);
        }
    }
    
    public void init_2(){
        m_PlayView.getHolder().addCallback(new Callback() {
            
            public void surfaceCreated(SurfaceHolder holder) {
                Log.d("[playsdk]surface", "surfaceCreated");
                IPlaySDK.InitSurface(nPort, m_PlayView);
            }
            
            public void surfaceChanged(SurfaceHolder holder, int format, int width,
                    int height) {
                Log.d("[playsdk]surface", "surfaceChanged");
            }

            public void surfaceDestroyed(SurfaceHolder holder) {
                Log.d("[playsdk]surface", "surfaceDestroyed");
            }
        });
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                if ( StartRealPlay(SDK_RealPlayType.SDK_RType_Realplay) == true ) {
                    m_callback = new TestRealDataCallBackEx();
                    m_VideoCallback = new TestVideoDataCallBack();
                    
                    if (lRealHandle != 0) { 
                        INetSDK.SetRealDataCallBackEx(lRealHandle, m_callback, 1);
                        
                        // below code is needed only if you want to save record
                        // you should confirm app has permission to create filePath
//                      String strFile = "/mnt/sdcard/NetSDK/RealData.h264";
//                      if (createFile("/mnt/sdcard/NetSDK/", "RealData.h264")) {
//                          try {
//                              m_Fout = new FileOutputStream(strFile, true);
//                          } catch (Exception e) {
//                              e.printStackTrace();
//                          }
//                          
//                          if (null != m_Fout) {
//                              IPlaySDK.PLAYSetDemuxCallBack(nPort, m_VideoCallback, 0);
//                          }
//                      }
                    }
                }
                Looper.loop();
            }
        }).start();
    }
    
    
    
    private void jumpToContentListActivity() {
        Intent intent = new Intent();
        intent.putExtra("name_nExtraChnNum", nExtraChnNum);
        intent.putExtra("name_nExtraAlarmOutPortNum", nExtraAlarmOutPortNum);
        intent.setClass(this, ContentListActivity.class);
        startActivityForResult(intent, 2);
    }
    
    private void showDialog(){
        if (null == mDialog){
//            AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(this);
//            mDialogBuilder.setMessage("");
//            mDialogBuilder.setMessage("正在连接...");
//            mDialogBuilder.setCancelable(false);
//            mDialog = mDialogBuilder.create();
            mDialog = Utils.createLoadingDialog(this, "正在连接");
        }
        mDialog.show();
    }
    
    private void dismissDialog(){
        if (null!= mDialog && mDialog.isShowing()){
            mDialog.dismiss();
        }
    }
    
    public boolean StartRealPlay(int nStreamType) {
        try {
            lRealHandle = INetSDK.RealPlayEx(m_loginHandle,
                    m_nGlobalChn, nStreamType);

            if (lRealHandle == 0) {
                ToolKits.showErrorMessage(this,
                        "RealPlayEx " + getResources().getString(R.string.info_failed));
                return false;
            }

            nPort = IPlaySDK.PLAYGetFreePort();
            boolean bOpenRet = IPlaySDK.PLAYOpenStream(nPort, null, 0, 1024 * 1024 * 2) == 0 ? false
                    : true;
            if (bOpenRet) {
                boolean bPlayRet = IPlaySDK.PLAYPlay(nPort, m_PlayView) == 0 ? false : true;
                if (bPlayRet) {
                    boolean bSuccess = IPlaySDK.PLAYPlaySoundShare(nPort) == 0 ? false : true;
                    if (!bSuccess) {
                        IPlaySDK.PLAYStop(nPort);
                        IPlaySDK.PLAYCloseStream(nPort);
                        return false;
                    }
                } else {
                    IPlaySDK.PLAYCloseStream(nPort);
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {//jingbo add this try catch because PLAYOpenStream can cause nullpoint
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    public void StopRealPlay() {
        try {
            IPlaySDK.PLAYStop(nPort);
            IPlaySDK.PLAYStopSoundShare(nPort);
            IPlaySDK.PLAYCloseStream(nPort);
            
//            if (bRecordFlag) {
//                INetSDK.StopSaveRealData(lRealHandle);
//                bRecordFlag = false;
//                m_btStartRecord.setText(R.string.live_activity_start);
//            }
        
            INetSDK.StopRealPlayEx(lRealHandle);
        
            if (null != m_Fout) {
                m_Fout.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        lRealHandle = 0;
    }
    
    public void Logout() {
        if (m_loginHandle==0) {
            return;
        }
        boolean bResult = INetSDK.Logout(m_loginHandle);
        if (bResult) {
            m_loginHandle = 0;
        }
    }
    
    @Override
    protected void onDestroy() {
        if ( lRealHandle != 0 ) {
            StopRealPlay();
        }
        Logout();
        INetSDK.Cleanup();
        super.onDestroy();
    }
    
    @Override
    protected void onResume() {
        GlobalSettingActivity.m_nGlobalChn = 0;
        GlobalSettingActivity.m_nGlobalPbStream = 0;
        super.onResume();
    }
    
    public class TestfHaveLogin implements CB_fHaveLogin {
        @Override
        public void invoke(long lLoginID, String pchDVRIP, int nDVRPort, boolean bOnline, NET_DEVICEINFO_Ex stuDeviceInfo, int nError) {
            ToolKits.writeLog("TestfHaveLogin");
        }
    }
    
    class Test_CB_fMessageCallBack implements CB_fMessageCallBack {
        @Override
        public boolean invoke(int lCommand, long lLoginID, Object obj, String pchDVRIP, int nDVRPort) {
            ToolKits.writeLog("Event: " + lCommand);
            if (12295 == lCommand) {
                DEV_PLAY_RESULT stResult = (DEV_PLAY_RESULT)obj;
                ToolKits.writeLog("ResultCode: " + stResult.dwResultCode + ", PlayHandle: " + stResult.lPlayHandle);
            }
            return true;
        }
    }
    
    //--------------
    
    private void initPTZ(RelativeLayout m_layoutPtz) {
        ImageButton m_btUp;
        ImageButton m_btDown;
        ImageButton m_btRight;
        ImageButton m_btLeft;
        ImageButton m_btLUp;
        ImageButton m_btRUp;
        ImageButton m_btLDown;
        ImageButton m_btRDown;
        ImageButton m_btMore;
        ImageButton m_btZoomA;
        ImageButton m_btZoomD;
        ImageButton m_btFocusA;
        ImageButton m_btFocusD;
        
        
        m_btUp = (ImageButton)m_layoutPtz.findViewById(R.id.btn_up);
        m_btUp.setOnTouchListener(new  OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                Log.v(tag, "-----------onTouch----");
                return PTZControl(event, GlobalSettingActivity.m_nGlobalChn, SDK_PTZ_ControlType.SDK_PTZ_UP_CONTROL, (byte)0, m_bSpeed);
            }});
            
        m_btDown = (ImageButton)m_layoutPtz.findViewById(R.id.btn_down);
        m_btDown.setOnTouchListener(new  OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return PTZControl(event, GlobalSettingActivity.m_nGlobalChn, SDK_PTZ_ControlType.SDK_PTZ_DOWN_CONTROL, (byte)0, m_bSpeed);
            }});
        
        m_btLeft = (ImageButton)m_layoutPtz.findViewById(R.id.btn_left);
        m_btLeft.setOnTouchListener(new  OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return PTZControl(event, GlobalSettingActivity.m_nGlobalChn, SDK_PTZ_ControlType.SDK_PTZ_LEFT_CONTROL, (byte)0, m_bSpeed);
            }});
        
        m_btRight = (ImageButton)m_layoutPtz.findViewById(R.id.btn_right);
        m_btRight.setOnTouchListener(new  OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return PTZControl(event, GlobalSettingActivity.m_nGlobalChn, SDK_PTZ_ControlType.SDK_PTZ_RIGHT_CONTROL, (byte)0, m_bSpeed);
            }});
        
        m_btLUp = (ImageButton)m_layoutPtz.findViewById(R.id.btn_lup);
        m_btLUp.setOnTouchListener(new  OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return PTZControl(event, GlobalSettingActivity.m_nGlobalChn, SDK_EXTPTZ_ControlType.SDK_EXTPTZ_LEFTTOP ,  m_bSpeed, m_bSpeed);
            }});
        
        m_btRUp = (ImageButton)m_layoutPtz.findViewById(R.id.btn_rup);
        m_btRUp.setOnTouchListener(new  OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return PTZControl(event, GlobalSettingActivity.m_nGlobalChn, SDK_EXTPTZ_ControlType.SDK_EXTPTZ_RIGHTTOP ,  m_bSpeed, m_bSpeed);
            }});
        
        m_btLDown = (ImageButton)m_layoutPtz.findViewById(R.id.btn_ldown);
        m_btLDown.setOnTouchListener(new  OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return PTZControl(event, GlobalSettingActivity.m_nGlobalChn, SDK_EXTPTZ_ControlType.SDK_EXTPTZ_LEFTDOWN ,  m_bSpeed, m_bSpeed);
            }});
        
        m_btRDown = (ImageButton)m_layoutPtz.findViewById(R.id.btn_rdown);
        m_btRDown.setOnTouchListener(new  OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return PTZControl(event, GlobalSettingActivity.m_nGlobalChn, SDK_EXTPTZ_ControlType.SDK_EXTPTZ_RIGHTDOWN ,  m_bSpeed, m_bSpeed);
            }});
        
        
        m_btZoomA = (ImageButton)m_layoutPtz.findViewById(R.id.btn_z_add);
        m_btZoomA.setOnTouchListener(new  OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return PTZControl(event, GlobalSettingActivity.m_nGlobalChn, SDK_PTZ_ControlType.SDK_PTZ_ZOOM_ADD_CONTROL, (byte)0, m_bSpeed);
            }
        });
        
        m_btZoomD = (ImageButton)m_layoutPtz.findViewById(R.id.btn_z_dec);
        m_btZoomD.setOnTouchListener(new  OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return PTZControl(event, GlobalSettingActivity.m_nGlobalChn, SDK_PTZ_ControlType.SDK_PTZ_ZOOM_DEC_CONTROL, (byte)0, m_bSpeed);
            }
        });
        
        m_btFocusA = (ImageButton)m_layoutPtz.findViewById(R.id.btn_f_add);
        m_btFocusA.setOnTouchListener(new  OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return PTZControl(event, GlobalSettingActivity.m_nGlobalChn, SDK_PTZ_ControlType.SDK_PTZ_FOCUS_ADD_CONTROL, (byte)0, m_bSpeed);
            }
        });
        
        m_btFocusD = (ImageButton)m_layoutPtz.findViewById(R.id.btn_f_dec);
        m_btFocusD.setOnTouchListener(new  OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return PTZControl(event, GlobalSettingActivity.m_nGlobalChn, SDK_PTZ_ControlType.SDK_PTZ_FOCUS_DEC_CONTROL, (byte)0, m_bSpeed);
            }
        });
    }
    
    private boolean PTZControl( MotionEvent event , int nChn ,  int nControl , byte param1 , byte param2)
    {
        int nAction = event.getAction();
        if( (nAction != MotionEvent.ACTION_DOWN) && (nAction != MotionEvent.ACTION_UP) ) {
            return false;
        }
        boolean zRet = INetSDK.SDKPTZControl(m_loginHandle, nChn , nControl ,
                param1 ,param2 ,(byte) 0 , nAction == MotionEvent.ACTION_UP);
        return false;
    }
    
    public class TestVideoDataCallBack implements fDemuxCBFun {
        @Override
        public void invoke(int nPort, byte[] pOrgBuffer, int nOrgLen, 
                byte[] pBuffer ,int nLen, DEMUX_INFO stInfo, long dwUser) {
            try {
                if (null != m_Fout) {
                    m_Fout.write(pBuffer);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    
    public class TestRealDataCallBackEx implements CB_fRealDataCallBackEx
    {
        @Override
        public void invoke(long lRealHandle, int dwDataType, byte[] pBuffer,
                int dwBufSize, int param) 
        {
            if (0 == dwDataType) {
                IPlaySDK.PLAYInputData(nPort, pBuffer, pBuffer.length);
            }       
        }
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public void onBackPressed() {
        Log.v(tag, "----onBackPressed-----");
        super.onBackPressed();
    }
}