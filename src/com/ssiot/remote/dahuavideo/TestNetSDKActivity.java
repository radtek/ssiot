package com.ssiot.remote.dahuavideo;

import android.content.Intent;
import android.content.res.Resources;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.content.SharedPreferences;
import com.company.NetSDK.*;
import com.ssiot.remote.R;

//连云港已装的大华 112.4.228.23 web9200 tcp37771 rtsp5551
public class TestNetSDKActivity extends Activity {
	Button m_btLogin;
	EditText m_serverIp;
	EditText m_serverPort;
	EditText m_serverUserName;
	EditText m_serverPassword;
	CheckBox m_cbAutoLogin;
	Resources res;
	
 	static long m_loginHandle = 0;
 	static NET_DEVICEINFO deviceInfo;
 	static boolean m_speedCtrl;
 	static int m_schedule;
 	
 	private int nSpecCap = 20;
 	
 	private SharedPreferences shardPreferences;
 	
 	static CFG_CAP_ALARM_INFO stCfgCapAlarm = new CFG_CAP_ALARM_INFO();
 	
 	private int nExtraChnNum;
 	private int nExtraAlarmOutPortNum;
	
	public class DeviceDisConnect implements CB_fDisConnect
	{
		@Override
		public void invoke(long lLoginID, String pchDVRIP, int nDVRPort) {
			ToolKits.writeLog("Device " + pchDVRIP + " DisConnect!");
			return ;
		}
	}
	
	public class DeviceReConnect implements CB_fHaveReConnect
	{
		@Override
		public void invoke(long lLoginID, String pchDVRIP, int nDVRPort) 
		{
			ToolKits.writeLog("Device " + pchDVRIP + " ReConnect!");
		}
	}
	
	public class DeviceSubDisConnect implements CB_fSubDisConnect
	{
		@Override
		public void invoke(int emInterfaceType, boolean bOnline,
				long lOperateHandle, long lLoginID) {
		
			ToolKits.writeLog("Device SubConnect DisConnect");
		}
	}
		
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dahua_main);
        
        // 一般不需要这个函数，偶尔出现过 程序退入后台较长时间，无法找到native方法的情况
 		INetSDK.LoadLibrarys();
     	
        res =  this.getResources();
        shardPreferences = this.getPreferences(Activity.MODE_WORLD_READABLE);
        
        ToolKits.showMessage(this , res.getString(R.string.DemoInit));

        DeviceDisConnect disConnect = new DeviceDisConnect(); 
    	boolean zRet = INetSDK.Init(disConnect);
        
        INetSDK.SetConnectTime(4000, 3);
    	
    	NET_PARAM stNetParam = new NET_PARAM();
		stNetParam.nWaittime = 30000;   //函数等待超时时间
		stNetParam.nSearchRecordTime = 30000;  //录像回放超时时间
    	INetSDK.SetNetworkParam(stNetParam);
    	
    	// 34317138 -> 3.43.17138
		int dbVersion = INetSDK.GetSDKVersion();
		int nBig = dbVersion / 10000000;
		int nMid = (dbVersion - (nBig * 10000000)) / 100000;
		int nRev = dbVersion - (nBig * 10000000) - (nMid * 100000);
		String strVersion = String.format(res.getString(R.string.SDKVersion) +"%d.%d.%d" , 
				nBig, nMid, nRev);
		ToolKits.showMessage( this ,  strVersion);

    	m_btLogin 			= (Button)findViewById(R.id.button1);
    	m_serverIp 			= (EditText)findViewById(R.id.editText_server);
    	m_serverPort 		= (EditText)findViewById(R.id.editText_server_Port);
    	m_serverUserName 	= (EditText)findViewById(R.id.editText_server_user);
    	m_serverPassword 	= (EditText)findViewById(R.id.editText_server_password);
    	m_cbAutoLogin       = (CheckBox)findViewById(R.id.cb_login_autologin);
    	
    	if (shardPreferences.getBoolean("login_isAutoLogin", false)) {
    		m_cbAutoLogin.setChecked(true);
    	} else {
    		m_cbAutoLogin.setChecked(false);
    	}
    	m_serverIp.setText(shardPreferences.getString("login_ip", "192.168.1.108"));//172.23.2.66
    	m_serverPort.setText(shardPreferences.getString("login_port", "37777"));
    	m_serverUserName.setText(shardPreferences.getString("login_name", "admin"));
    	m_serverPassword.setText(shardPreferences.getString("login_pswd", "admin"));
    	
    	// p2p process
		if ((LoginModeActivity.m_loginMode == LoginModeActivity.LOGIN_MODE.LOGIN_MODE_P2P)
				&& (P2PActivity.localPort > 0)) {
			m_serverIp.setText("127.0.0.1");
			m_serverIp.setEnabled(false);
			m_serverPort.setText("" + P2PActivity.localPort);
			m_serverPort.setEnabled(false);
			nSpecCap = 19;
		} else {
			nSpecCap = 20;
		}
    	
    	m_btLogin.setOnClickListener( new OnClickListener() {
			@Override
			public void onClick(View v) {
		    	if (m_loginHandle !=0)
		    	{
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
		    	
		    	String strIp 		= m_serverIp.getText().toString();
		    	String strPort 		= m_serverPort.getText().toString();
		    	String strUser 		= m_serverUserName.getText().toString();
		    	String strPassword 	= m_serverPassword.getText().toString();
		    	
		    	int nDevPort = 37777;
		    	try {
		    		nDevPort = Integer.parseInt(strPort);
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    		ToolKits.showMessage(v.getContext(), res.getString(R.string.login_activity_port_err));
		    		return;
		    	}
		    	
		    	m_loginHandle = INetSDK.LoginEx(strIp, nDevPort, 
		    			strUser, strPassword, nSpecCap, null, deviceInfo, error);
		    	
		    	if ( m_loginHandle != 0 )
		    	{
		    		ToolKits.showMessage( v.getContext(), res.getString(R.string.login_activity_login_success));
		    		
		    		m_speedCtrl = false;
		    		m_schedule = 0;
		    		SDK_DEV_ENABLE_INFO stEnableInfo = new SDK_DEV_ENABLE_INFO();
		    		if (INetSDK.QuerySystemInfo(TestNetSDKActivity.m_loginHandle, SDK_SYS_ABILITY.ABILITY_DEVALL_INFO, stEnableInfo, 3000)) {
		    			if (stEnableInfo.IsFucEnable[SDK_DEV_FUNC.EN_PLAYBACK_SPEED_CTRL] != 0) {
		    				m_speedCtrl = true;
		    			}
		    			
		    			m_schedule = stEnableInfo.IsFucEnable[SDK_DEV_FUNC.EN_SCHEDULE];
		    		}
		    		
		    		SharedPreferences.Editor editor = shardPreferences.edit();
		    		if (m_cbAutoLogin.isChecked()) {
		    			editor.putBoolean("login_isAutoLogin", true);
		    			if (!((LoginModeActivity.m_loginMode == LoginModeActivity.LOGIN_MODE.LOGIN_MODE_P2P)
		    					&& (P2PActivity.localPort > 0))) {
			    			editor.putString("login_ip", m_serverIp.getText().toString());
			    			editor.putString("login_port", m_serverPort.getText().toString());
		    			}
		    			editor.putString("login_name", m_serverUserName.getText().toString());
		    			editor.putString("login_pswd", m_serverPassword.getText().toString());
		    		} else {
		    			editor.putBoolean("login_isAutoLogin", false);
		    			editor.putString("login_ip", "");
		    			editor.putString("login_port", "");
		    			editor.putString("login_name", "");
		    			editor.putString("login_pswd", "");
		    		}
		    		editor.commit();
		    		
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
		    		nExtraChnNum = TestNetSDKActivity.deviceInfo.byChanNum;
		            if (-1 == TestNetSDKActivity.deviceInfo.byChanNum) {
		            	SDK_PRODUCTION_DEFNITION stDef = new SDK_PRODUCTION_DEFNITION();
		            	boolean bRet = INetSDK.QueryProductionDefinition(TestNetSDKActivity.m_loginHandle, stDef, 3000);
		            	if (bRet) {
		            		nExtraChnNum = stDef.nVideoInChannel + stDef.nMaxRemoteInputChannels;
		            	}
		            }
		            nExtraAlarmOutPortNum = TestNetSDKActivity.deviceInfo.byAlarmOutPortNum;
		        	
		    		jumpToContentListActivity();
		    	}
		    	else
		    	{
		    		ToolKits.showErrorMessage(v.getContext(), res.getString(R.string.login_activity_login_failed));
		    	}
			}
    	});
    }
    
    public void jumpToContentListActivity()
    {
		Intent intent = new Intent();
		intent.putExtra("name_nExtraChnNum", nExtraChnNum);
		intent.putExtra("name_nExtraAlarmOutPortNum", nExtraAlarmOutPortNum);
		intent.setClass(this, ContentListActivity.class);
		startActivityForResult(intent, 2);
    }
    
    public void Logout()
    {
    	if (m_loginHandle==0)
    	{
    		return;
    	}
    	boolean bResult = INetSDK.Logout(m_loginHandle);
    	
    	if ( bResult == true )
    	{
    		m_loginHandle = 0;
    	}
    }

	@Override
	protected void onDestroy() 
	{
		Logout();
		INetSDK.Cleanup();
    	
    	ToolKits.showMessage(this , res.getString(R.string.DemoExit));
    	
		super.onDestroy();
	}
	
	@Override
	protected void onResume() {
		// reset channel
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
}