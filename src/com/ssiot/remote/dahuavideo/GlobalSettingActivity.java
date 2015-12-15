package com.ssiot.remote.dahuavideo;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.view.View.OnClickListener;
import java.util.ArrayList;

import com.company.NetSDK.INetSDK;
import com.company.NetSDK.EM_USEDEV_MODE;
import com.ssiot.remote.R;

public class GlobalSettingActivity extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dahua_globalsetting);
        
        // һ�㲻��Ҫ�������ż����ֹ� ���������̨�ϳ�ʱ�䣬�޷��ҵ�native���������
        INetSDK.LoadLibrarys();
        
        nExtraChnNum = getIntent().getIntExtra("name_nExtraChnNum", 0);
        nExtraAlarmOutPortNum = getIntent().getIntExtra("name_nExtraAlarmOutPortNum", 0);
        
        res = this.getResources();
        
        m_spGlobalChn = (Spinner)findViewById(R.id.sp_globalsetting_chn);
        m_spGlobalPbStream = (Spinner)findViewById(R.id.sp_globalsetting_pb_stream);
        m_btGlobalSet = (Button)findViewById(R.id.bt_globalsetting_set);
        
        int nChnNum = nExtraChnNum;
        
        ArrayList<String> alChn = new ArrayList<String>();
        for (int i = 0; i < nChnNum; i++) {
        	alChn.add(res.getString(R.string.channel_name) + (i + 1));
        }
        ArrayAdapter<String> aaChn = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, alChn);
        m_spGlobalChn.setAdapter(aaChn);
        m_spGlobalChn.setSelection(m_nGlobalChn);
        
        ArrayList<String> alPbStream = new ArrayList<String>();
        alPbStream.add(res.getString(R.string.global_setting_activity_pb_stream_all));
        alPbStream.add(res.getString(R.string.global_setting_activity_pb_stream_main));
        alPbStream.add(res.getString(R.string.global_setting_activity_pb_stream_sub));
        
        ArrayAdapter<String> aaStream = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, alPbStream);
        m_spGlobalPbStream.setAdapter(aaStream);
        m_spGlobalPbStream.setSelection(m_nGlobalPbStream);
        
        m_btGlobalSet.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		m_nGlobalChn = m_spGlobalChn.getSelectedItemPosition();
        		m_nGlobalPbStream = m_spGlobalPbStream.getSelectedItemPosition(); //0-��������,1-������,2-������
        		boolean bPbStream = INetSDK.SetDeviceMode(TestNetSDKActivity.m_loginHandle, EM_USEDEV_MODE.SDK_RECORD_STREAM_TYPE, m_nGlobalPbStream);
        		if (!bPbStream) {
        			ToolKits.showMessage(v.getContext(), res.getString(R.string.info_failed));
        			return;
        		}

        		ToolKits.showMessage(v.getContext(), res.getString(R.string.info_success));
        	}
        });
	}
	
	private Spinner m_spGlobalChn;
	private Spinner m_spGlobalPbStream;
	private Button m_btGlobalSet;
	static int m_nGlobalChn = 0;
	static int m_nGlobalPbStream = 0;
	Resources res;
	
	private int nExtraChnNum;
 	private int nExtraAlarmOutPortNum;
}
