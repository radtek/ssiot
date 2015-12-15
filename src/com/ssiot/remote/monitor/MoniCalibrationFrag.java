package com.ssiot.remote.monitor;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.ssiot.remote.BaseFragment;
import com.ssiot.remote.R;
import com.ssiot.remote.data.AjaxGetNodesDataByUserkey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MoniCalibrationFrag extends BaseFragment{
    public static final String tag = "CaliFragment";
    private FCaliBtnClickListener mFCaliBtnClickListener;
    private Bundle mBundle;
    private int nodeno = -1;
    private RelativeLayout bar1;
    private RelativeLayout bar2;
    private Spinner sensorSpinner;
    private Spinner channelSpinner;
    private Spinner standardSpinner;
    
    HashMap<String,ArrayList<Integer>> hashMap;
    
    private static final int MSG_GETSENSORINFO = 0;
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            if (!isVisible()){
                Log.e(tag, "-----not visible: msg:" + msg.what);
                return;
            }
            switch (msg.what) {
                case MSG_GETSENSORINFO:
                    setSensorAndChannelSpinner();
                    break;

                default:
                    break;
            }
        };
    };
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mBundle = getArguments();
        nodeno = mBundle.getInt("nodeno", -1);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_moni_cali, container, false);
        initTitleBar(v);
        bar1 = (RelativeLayout) v.findViewById(R.id.cali_stan_bar);
        bar2 = (RelativeLayout) v.findViewById(R.id.cali_modi_bar);
        sensorSpinner = (Spinner) v.findViewById(R.id.cali_sensor);
        channelSpinner = (Spinner) v.findViewById(R.id.cali_channel);
        standardSpinner = (Spinner) v.findViewById(R.id.cali_standard);
        
        RadioButton bdButton = (RadioButton) v.findViewById(R.id.cali_bd);
        RadioButton jzButton = (RadioButton) v.findViewById(R.id.cali_jz);
        RadioGroup rg = (RadioGroup) v.findViewById(R.id.cali_bd_jz);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.cali_bd:
                        bar1.setVisibility(View.VISIBLE);
                        bar2.setVisibility(View.GONE);
                        break;
                    case R.id.cali_jz:
                        bar1.setVisibility(View.GONE);
                        bar2.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
            }
        });
        initDecreaseIncreaseBar(v);
        new GetCaliThread().start();
        return v;
    }
    
    private void initTitleBar(View rootView){
        TextView mTitleView = (TextView) rootView.findViewById(R.id.moni_title);
        ImageView mOnlineView = (ImageView) rootView.findViewById(R.id.moni_status);
        ImageView mNetTypeView = (ImageView) rootView.findViewById(R.id.moni_net_type);
        mTitleView.setText(mBundle.getString("nodetitle"));
        mOnlineView.setImageResource(mBundle.getBoolean("status", false) ? R.drawable.online : R.drawable.offline);
        mNetTypeView.setImageResource(mBundle.getBoolean("isgprs", false) ? R.drawable.connect_gprs : R.drawable.connect_zigbee);
    }
    
    private void initDecreaseIncreaseBar(View rootView){
        Button decreaBtn = (Button) rootView.findViewById(R.id.cali_decrease);
        Button increaBtn = (Button) rootView.findViewById(R.id.cali_increase);
        final EditText editText = (EditText) rootView.findViewById(R.id.cali_edit);
        decreaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                try {
                    i = Integer.parseInt(editText.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                editText.setText("" + (i-1));
            }
        });
        increaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                try {
                    i = Integer.parseInt(editText.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                editText.setText("" + (i+1));
            }
        });
    }
    
    private void setSensorAndChannelSpinner(){
        final ArrayList<String> sensorDatas = new ArrayList<String>();
        Iterator iterator = hashMap.keySet().iterator();
        while(iterator.hasNext()){
            sensorDatas.add(""+iterator.next());
        }
        ArrayAdapter<String> arr_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,sensorDatas);
        sensorSpinner.setAdapter(arr_adapter);
        sensorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<String> channelDatas = new ArrayList<String>();
                ArrayList<Integer> arrayInt = hashMap.get(sensorDatas.get(position));
                for (int i = 0; i < arrayInt.size(); i ++){
                    channelDatas.add("" + arrayInt.get(i));
                }
                ArrayAdapter<String> channel_adapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_spinner_item,channelDatas);
                channelSpinner.setAdapter(channel_adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    
    public class GetCaliThread extends Thread{
        @Override
        public void run() {
            if (-1 != nodeno){
                hashMap = new AjaxGetNodesDataByUserkey().GetSensorInfoByNodeNo(""+nodeno);
                mHandler.sendEmptyMessage(MSG_GETSENSORINFO);
            }
        }
    }
    
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.Cali, menu);
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
    
    public void setClickListener(FCaliBtnClickListener listen){
        mFCaliBtnClickListener = listen;
    }
    
    //回调接口，留给activity使用
    public interface FCaliBtnClickListener {  
        void onFCaliBtnClick();  
    }
}