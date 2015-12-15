package com.ssiot.remote.dahuavideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.ssiot.remote.R;

public class LoginModeActivity extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dahua_loginmode);
		
		m_btIP = (Button)findViewById(R.id.bt_loginmode_ip);
		m_btP2P = (Button)findViewById(R.id.bt_loginmode_p2p);
		
		m_btIP.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				m_loginMode = LOGIN_MODE.LOGIN_MODE_IP;
				jumpToIPActivity();
			}
		});
		
		m_btP2P.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				m_loginMode = LOGIN_MODE.LOGIN_MODE_P2P;
				jumpToP2PActivity();
			}
		});
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	private void jumpToIPActivity() {
		Intent intent = new Intent();
		intent.setClass(this, TestNetSDKActivity.class);
		startActivityForResult(intent, 2);
	}
	
	private void jumpToP2PActivity() {
		Intent intent = new Intent();
		intent.setClass(this, P2PActivity.class);
		startActivityForResult(intent, 3);
	}
	
	private Button m_btIP;
	private Button m_btP2P;
	
	public static LOGIN_MODE m_loginMode;
	
	public enum LOGIN_MODE {
		LOGIN_MODE_IP,
		LOGIN_MODE_P2P
	}
}
