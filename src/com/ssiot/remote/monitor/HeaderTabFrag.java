package com.ssiot.remote.monitor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ssiot.remote.BaseFragment;
import com.ssiot.remote.MainActivity;
import com.ssiot.remote.R;
import com.ssiot.remote.SettingFrag;
import com.ssiot.remote.control.ControlDetailFrag;
import com.ssiot.remote.control.ControlDetailHolderFrag;
import com.ssiot.remote.control.ControlListAdapter.ControlDetailListener;
import com.ssiot.remote.control.ControlNodeListFrag;
import com.ssiot.remote.data.model.view.ControlNodeViewModel;
import com.ssiot.remote.data.model.view.NodeView2Model;
import com.ssiot.remote.monitor.MoniNodeListFrag.FMoniNodeListBtnClickListener;
import com.ssiot.remote.monitor.MonitorListAdapter2.DetailListener;

public class HeaderTabFrag extends BaseFragment{
    public static final String tag = "HeaderTabFragment";
    private final static String TAG_MONI = "tag_monitor";
    private final static String TAG_MONI_DETAIL = "tag_monitor_detail";
    private final static String TAG_CTR = "tag_control";
    private final static String TAG_CTR_DETAIL = "tag_control_detail";
    private final static String TAG_SETTING = "tag_setting";
    private FHeaderTabBtnClickListener mFHeaderTabBtnClickListener;
    private FragmentManager fragmentManager;
    private RadioGroup radioGroup; 
    String userKey;
    int defaultTab = 1;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        fragmentManager = getChildFragmentManager();
        userKey = getArguments().getString("uniqueid");
        defaultTab = getArguments().getInt("defaulttab", 1);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v(tag, "----onCreateView----");
        View v = inflater.inflate(R.layout.fragment_header_tab, container, false);
        
        radioGroup = (RadioGroup) v.findViewById(R.id.rg_tab);
        RadioButton radioButtonMoni = (RadioButton) v.findViewById(R.id.radiobutton_moni);
        RadioButton radioButtonCtr = (RadioButton) v.findViewById(R.id.radiobutton_control);
        RadioButton radioButtonVideo = (RadioButton) v.findViewById(R.id.radiobutton_map);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {  
            @Override  
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                startFragment(checkedId);
            }
        });
        switch (defaultTab) {
            case 1:
//                radioGroup.check(R.id.radiobutton_moni);//bug fragment 加载两次
                radioButtonMoni.setChecked(true);
                break;
            case 2:
//                radioGroup.check(R.id.radiobutton_control);
                radioButtonCtr.setChecked(true);
                break;
            case 3:
//                radioGroup.check(R.id.radiobutton_moni);
                radioButtonVideo.setChecked(true);
                break;
            default:
//                radioGroup.check(R.id.radiobutton_moni);
                radioButtonMoni.setChecked(true);
                break;
        }
        
        return v;
    }
    
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.HeaderTab, menu);
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
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.v(tag, "----onActivityResult----" + requestCode + " "+ resultCode);
        switch (requestCode) {
            case MainActivity.REQUEST_CODE_CTR_CIRCLE:
                Fragment f = fragmentManager.findFragmentByTag(TAG_CTR_DETAIL);
                if (null != f){
                    f.onActivityResult(requestCode, resultCode, data);
                }
                break;

            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    
    public void setClickListener(FHeaderTabBtnClickListener listen){
        mFHeaderTabBtnClickListener = listen;
    }
    
    //回调接口，留给activity使用
    public interface FHeaderTabBtnClickListener {  
        void onFHeaderTabBtnClick();  
    }
    
    @Override
    public boolean canGoback() {
        if (fragmentManager.getBackStackEntryCount() != 0){
            return true;
        }
        return false;
    }
    
    @Override
    public void onMyBackPressed() {
        Log.v(tag, "----onMyBackPressed----");
        fragmentManager.popBackStack();
    }
    
    private void startFragment(int checkedId){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        bundle.putString("uniqueid", userKey);
        switch (checkedId) {
            case R.id.radiobutton_moni:
                fragment = new MoniNodeListFrag();
                fragment.setArguments(bundle);
                ((MoniNodeListFrag) fragment).setDetailListener(mDetailListener);
                transaction.replace(R.id.detail_content, fragment, TAG_MONI);
                break;
            case R.id.radiobutton_control:
                fragment = new ControlNodeListFrag();
                fragment.setArguments(bundle);
                ((ControlNodeListFrag) fragment).setCtrDetailListener(mCtrDetailListener);
                transaction.replace(R.id.detail_content, fragment, TAG_CTR);
                break;
//            case 3:
//                fragment = new MapFrag();
//                transaction.replace(R.id.detail_content, fragment, TAG_MAP);
//                break;
                default:
                    fragment = new SettingFrag();
                    transaction.replace(R.id.detail_content, fragment, TAG_SETTING);
                    break;
        }
        
        fragmentManager.popBackStackImmediate();//TODO 是否是全部弹出还是单个弹出
//        transaction.addToBackStack(null);
        transaction.commit();
    }
    
    private Fragment getInstanceByIndex(int index) {
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        bundle.putString("uniqueid", userKey);
        switch (index) {
            case R.id.radiobutton_moni:
                fragment = new MoniNodeListFrag();
                fragment.setArguments(bundle);
                ((MoniNodeListFrag) fragment).setDetailListener(mDetailListener);
                break;
            case R.id.radiobutton_control:
                fragment = new ControlNodeListFrag();
                fragment.setArguments(bundle);
                ((ControlNodeListFrag) fragment).setCtrDetailListener(mCtrDetailListener);
                break;
//            case 3:
//                fragment = new MapFrag();
//                break;
                default:
                    fragment = new SettingFrag();
                    break;
        }
        return fragment;
    }
    
    DetailListener mDetailListener = new DetailListener() {
        @Override
        public void showDetail(NodeView2Model n2m) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            Fragment fragment = new MoniDetailHolderFrag();//TODO
//            Fragment fragment = new MoniDataAndChartFrag();
            Bundle bundle = new Bundle();
            bundle.putString("nodetitle", n2m._location);
            bundle.putBoolean("status", n2m._isonline.equals("在线"));
            bundle.putBoolean("isgprs", "GPRS".equalsIgnoreCase(n2m._onlinetype));
            bundle.putInt("nodeno", n2m._nodeno);
            bundle.putString("uniqueid", n2m._uniqueid);
            fragment.setArguments(bundle);
            transaction.replace(R.id.detail_content, fragment,TAG_MONI_DETAIL);
            transaction.addToBackStack(null);
            transaction.commit();  
        }
    };
    ControlDetailListener mCtrDetailListener = new ControlDetailListener() {
        @Override
        public void showDetail(int position, ControlNodeViewModel model) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            Fragment fragment = new ControlDetailHolderFrag();
//            Fragment fragment = new ControlDetailFrag();
            transaction.replace(R.id.detail_content, fragment, TAG_CTR_DETAIL);
            Bundle bundle = new Bundle();
            bundle.putString("userkey", userKey);
            bundle.putString("controlnodeuniqueid", model._uniqueid);
            bundle.putString("controlnodeid", ""+model._id);
            bundle.putString("controlnodename", model._nodename);
            fragment.setArguments(bundle);
            transaction.addToBackStack(null);
            transaction.commit();  
        }
    };
}