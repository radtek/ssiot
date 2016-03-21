package com.ssiot.remote;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class SettingFrag extends Fragment{
    public static final String tag = "SettingFragment";
    private FSettingBtnClickListener mFSettingBtnClickListener;
    
    private TextView mVerStatusView;
    HashMap<String, String> mHashMap;
    private SharedPreferences mPref;
    
    public static final String ACTION_SSIOT_UPDATE = "com.ssiot.remote.update";
    BroadcastReceiver updateBroadcastReceiver = new BroadcastReceiver(){
        public void onReceive(Context context, Intent intent) {
            int checkRet = intent.getIntExtra("checkresult", -1);
            Log.v(tag, "----------updateBroadcastReceiver---" + checkRet);
            switch (checkRet) {
                case 0:
                    mVerStatusView.setText("未获取到最新版本信息");
                    break;
                case 1:
                    mVerStatusView.setText("有新版本");
                    break;
                case 2:
                    mVerStatusView.setText("已是最新");
                    break;

                default:
                    break;
            }
        }
    };
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        getActivity().registerReceiver(updateBroadcastReceiver, new IntentFilter(ACTION_SSIOT_UPDATE));
        mPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View v = inflater.inflate(R.layout.fragment_setting, container, false);
        TextView mVersionTextView = (TextView) v.findViewById(R.id.app_version);
        mVerStatusView = (TextView) v.findViewById(R.id.app_version_status);
        String text = getActivity().getResources().getString(R.string.app_name) + getCurVersionName(getActivity());
        mVersionTextView.setText(text);
        View b = (View) v.findViewById(R.id.checkupdate);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Utils.isNetworkConnected(getActivity())){
                    Toast.makeText(getActivity(), R.string.please_check_net, Toast.LENGTH_SHORT).show();
                }
                mVerStatusView.setText("");
                if (UpdateManager.updating){
                    Toast.makeText(getActivity(), "更新正在运行,请等待。", Toast.LENGTH_SHORT).show();
                } else {
//                    if (null != mFSettingBtnClickListener){
//                        mFSettingBtnClickListener.onFSettingBtnClick();
//                    }
                    UpdateManager mUpdaManager = new UpdateManager(getActivity());
                    if (mPref.getBoolean(Utils.PREF_AUTOUPDATE, true) == false){
                        Editor editor = mPref.edit();
                        editor.putBoolean(Utils.PREF_AUTOUPDATE, true);
                        editor.commit();
                    }
                    mUpdaManager.startGetRemoteVer();
                }
            }
        });
        CheckBox cb = (CheckBox) v.findViewById(R.id.alarm_switch);
        cb.setChecked(mPref.getBoolean(Utils.PREF_ALARM, true));
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (null != mPref){
                    Editor e = mPref.edit();
                    e.putBoolean("alarm", isChecked);
                    e.commit();
                }
            }
        });
        return v;
    }
    
    @Override
    public void onDestroyView() {
        getActivity().unregisterReceiver(updateBroadcastReceiver);
        super.onDestroyView();
    }
    
    private String getCurVersionName(Context c){
        String versionName = "";
        try {
            versionName = c.getPackageManager().getPackageInfo(c.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return versionName;
    }
    
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.Setting, menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_settings:
//                Log.v(tag, "----------------action-settting");
//                break;
//
//            default:
//                break;
//        }
        return true;
    }
    
    public void setClickListener(FSettingBtnClickListener listen){
        mFSettingBtnClickListener = listen;
    }
    
    //回调接口，留给activity使用
    public interface FSettingBtnClickListener {  
        void onFSettingBtnClick();  
    }
}