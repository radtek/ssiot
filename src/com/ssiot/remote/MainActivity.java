
package com.ssiot.remote;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.AlertDialog.Builder;
import android.app.Notification;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import android.preference.PreferenceManager;

import com.ssiot.remote.ExpertFragment.FExpertBtnClickListener;
import com.ssiot.remote.history.HistoryDetailFragment;
import com.ssiot.remote.history.HistoryFragment;
import com.ssiot.remote.history.HistoryFragment.FHisBtnClickListener;
import com.ssiot.remote.MainFragment.FMainBtnClickListener;
import com.ssiot.remote.SettingFrag.FSettingBtnClickListener;
import com.ssiot.remote.data.model.TraceProfileModel;
import com.ssiot.remote.expert.DiagnoseFishSelectActivity;
import com.ssiot.remote.monitor.HeaderTabFrag;

import java.util.HashMap;
import java.util.List;
//TODO 灌南电商定制merge
public class MainActivity extends ActionBarActivity implements FMainBtnClickListener ,FSettingBtnClickListener ,FExpertBtnClickListener, FHisBtnClickListener{
    private static final String tag = "SSIOT-Main";
    public final static int REQUEST_CODE_SCAN = 1;
    public final static int REQUEST_CODE_CTR_CIRCLE = 2;
    private final static String TAG_MONITOR = "tag_monitor";
    private final static String TAG_VIDEO = "tag_video";
    private final static String TAG_HISTORY = "tag_history";
    private final static String TAG_HISTORY_DETAIL = "tag_history_detail";
    
    private final static String TAG_HEADER_TAB = "tag_header_tab";
    private final static String TAG_EXPERT = "tag_expert";
    private final static String TAG_INFO = "tag_info";
    private final static String TAG_SETTING = "tag_setting";
    
    public static String mUniqueID = "";
    private UpdateManager mUpdaManager;
    private SharedPreferences mPref;
    
    public static int AreaID= -1;
    private MyCache mCache;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.title_green));
        startService(new Intent(this, SsiotService.class));
        mCache = new MyCache(this);
        Bundle b = getIntent().getExtras();
        if (null != b){
            mUniqueID = b.getString("userkey");
            Log.v(tag, "------------mUniqueID:" + mUniqueID);
        }
        if (savedInstanceState == null){
            Log.v(tag, "--------------------savedInstanceState == null");
        }
        if (savedInstanceState == null) {//默认的savedInstanceState会存储一些数据，包括Fragment的实例
            MainFragment mMainFragment = new MainFragment();
            Log.v(tag, "---------------fragcount:"+getSupportFragmentManager().getBackStackEntryCount());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, mMainFragment)
                    .commit();
//            mMainFragment.setClickListener(mfMainBtnClickListener);
        } else {
            savedInstanceState.remove("android:support:fragments");//解决getactivity为空的问题？？
            Log.v(tag, "---------------fragcount&&&&&&&&&&:"+getSupportFragmentManager().getBackStackEntryCount());
        }
        
        mPref = PreferenceManager.getDefaultSharedPreferences(this);
        if (mPref.getBoolean(Utils.PREF_AUTOUPDATE, true) == true){
            mUpdaManager = new UpdateManager(this);
            mUpdaManager.startGetRemoteVer();
        }
//        testsql();
//        Utils.changePic2(getApplicationContext());
    }
    
    public MyCache getCaheManager(){
        return mCache;
    }
    
    public String getUnique(){
        return mUniqueID;
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v(tag, "------onActivityResult----" + requestCode +resultCode);
        switch (requestCode) {
            case REQUEST_CODE_SCAN:
                if (resultCode == RESULT_OK){
                    Bundle bundle = data.getExtras();
                    Log.v(tag, "-------"+bundle.getString("result"));
                    Bitmap bitmap = (Bitmap) data.getParcelableExtra("bitmap");
                    
                    FragmentTransaction mTransaction = getSupportFragmentManager().beginTransaction();
                    HistoryDetailFragment hisDetailFragment = new HistoryDetailFragment();
                    mTransaction.replace(R.id.container, hisDetailFragment, TAG_HISTORY_DETAIL);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("title", bundle.getString("result"));
                    hisDetailFragment.setArguments(bundle);
                    mTransaction.addToBackStack(null);
                    mTransaction.commit();
                }
                break;
            case REQUEST_CODE_CTR_CIRCLE://一层一层传递给fragment
                Fragment frag = getSupportFragmentManager().findFragmentByTag(TAG_HEADER_TAB);
                if (null != frag){
                    frag.onActivityResult(requestCode, resultCode, data);
                }
                break;

            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_logout:
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                SsiotService.cancel = true;
                stopService(new Intent(this, SsiotService.class));
                finish();
                Editor e = mPref.edit();
                e.putString("password", "");
                e.commit();
                return true;
            case android.R.id.home:
                View v = getWindow().peekDecorView();
                if (v != null){
                    InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputmanger.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public void onBackPressed() {
//        FragmentTransaction mTransaction = getSupportFragmentManager().beginTransaction();
//        HistoryFragment tmpFragment = (HistoryFragment) getSupportFragmentManager().findFragmentByTag(TAG_HISTORY);
//        if (null != tmpFragment && tmpFragment.isVisible() && tmpFragment.canGoback()){
//            tmpFragment.onMyBackPressed();
//        } else {
//            super.onBackPressed();
//        }
        
        List<Fragment> frags = getSupportFragmentManager().getFragments();
        for(Fragment f : frags){
            if (f != null && f.isVisible()){
                if (f instanceof BaseFragment && ((BaseFragment) f).canGoback()){
                    ((BaseFragment)f).onMyBackPressed();
                    return;
                }
            }
        }
        super.onBackPressed();
        
    }

    @Override
    public void onFMainBtnClick(String itmTxt) {

        FragmentTransaction mTransaction = getSupportFragmentManager().beginTransaction();
        if (itmTxt.equals(getResources().getString(R.string.iconstr_monitor))){
            HeaderTabFrag monitorFragment = new HeaderTabFrag();
            mTransaction.replace(R.id.container, monitorFragment, TAG_HEADER_TAB);
            Bundle bundle = new Bundle();
            bundle.putString("uniqueid", mUniqueID);
            bundle.putInt("defaulttab", 1);
            monitorFragment.setArguments(bundle);
            mTransaction.addToBackStack(null);
            mTransaction.commit();
        } else if (itmTxt.equals(getResources().getString(R.string.iconstr_control))){
            HeaderTabFrag controlFragment = new HeaderTabFrag();
            mTransaction.replace(R.id.container, controlFragment, TAG_HEADER_TAB);
            Bundle bundle = new Bundle();
            bundle.putString("uniqueid", mUniqueID);
            bundle.putInt("defaulttab", 2);
            controlFragment.setArguments(bundle);
            mTransaction.addToBackStack(null);
            mTransaction.commit();
        } else if (itmTxt.equals(getResources().getString(R.string.iconstr_history))){
            Log.v(tag, "---------------------history");
//            Intent intent = new Intent();
//            intent.setClass(MainActivity.this, MipcaActivityCapture.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivityForResult(intent, REQUEST_CODE_SCAN);
            HistoryFragment mHisFragment = new HistoryFragment();
            mTransaction.replace(R.id.container, mHisFragment, TAG_HISTORY);
            Bundle bundle = new Bundle();
            bundle.putString("uniqueid", mUniqueID);
            mHisFragment.setArguments(bundle);
            mTransaction.addToBackStack(null);
            mTransaction.commit();
        } else if (itmTxt.equals(getResources().getString(R.string.iconstr_video))){
            if (!Utils.isNetworkConnected(MainActivity.this)){
                Toast.makeText(MainActivity.this, R.string.please_check_net, Toast.LENGTH_SHORT).show();
                return;
            }
            VideoFragment videoFragment = new VideoFragment();
            mTransaction.replace(R.id.container, videoFragment, TAG_VIDEO);
            Bundle bundle = new Bundle();
            bundle.putString("title", "ttttteeeeesssst");
            videoFragment.setArguments(bundle);
            mTransaction.addToBackStack(null);
            mTransaction.commit();
        } else if (itmTxt.equals(getResources().getString(R.string.iconstr_expert))){
            
            ExpertFragment expertFragment = new ExpertFragment();
            mTransaction.replace(R.id.container, expertFragment, TAG_EXPERT);
            Bundle bundle = new Bundle();
            bundle.putString("title", "ttttteeeeesssst");
            expertFragment.setArguments(bundle);
            mTransaction.addToBackStack(null);
            mTransaction.commit();
        } else if (itmTxt.equals(getResources().getString(R.string.iconstr_info))){
            if ("gn".equalsIgnoreCase(mPref.getString("username", ""))){
                Intent intent = new Intent(MainActivity.this, BrowserActivity.class);
                intent.putExtra("url", "http://gn.ssiot.com/mobile");
                startActivity(intent);
            } else {
                InfoFragment infoFragment = new InfoFragment();
                mTransaction.replace(R.id.container, infoFragment, TAG_INFO);
                Bundle bundle = new Bundle();
                bundle.putString("title", "ttttteeeeesssst");
                infoFragment.setArguments(bundle);
                mTransaction.addToBackStack(null);
                mTransaction.commit();
            }
        } else if (itmTxt.equals("setting")){//设置界面
            SettingFrag settingFragment = new SettingFrag();
            mTransaction.replace(R.id.container, settingFragment, TAG_SETTING);
//            Bundle bundle = new Bundle();
//            bundle.putString("title", "ttttteeeeesssst");
//            settingFragment.setArguments(bundle);
            mTransaction.addToBackStack(null);
            mTransaction.commit();
        }
    }
    
    @Override
    public void onFSettingBtnClick() {
        if (mUpdaManager == null){
            mUpdaManager = new UpdateManager(MainActivity.this);
        }
        if (mPref.getBoolean(Utils.PREF_AUTOUPDATE, true) == false){
            Editor editor = mPref.edit();
            editor.putBoolean(Utils.PREF_AUTOUPDATE, true);
            editor.commit();
        }
        mUpdaManager.startGetRemoteVer();
    }

    @Override
    public void onFExpertBtnClick() {
        Intent intent = new Intent(MainActivity.this, DiagnoseFishSelectActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFHisBtnClick(TraceProfileModel m, boolean forceScan) {
        FragmentTransaction mTransaction = getSupportFragmentManager().beginTransaction();
        HistoryDetailFragment hisDetailFragment = new HistoryDetailFragment();
        mTransaction.replace(R.id.container, hisDetailFragment, TAG_HISTORY_DETAIL);
        Bundle bundle2 = new Bundle();
//        bundle2.putString("title", bundle.getString("result"));
//        bundle2.putString("code", m._code);
        hisDetailFragment.setArguments(bundle2);
        hisDetailFragment.setModel(m);
        mTransaction.addToBackStack(null);
        mTransaction.commit();
        
    }
}
