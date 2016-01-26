package com.ssiot.remote.monitor;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import android.widget.Toast;

import com.ssiot.remote.BaseFragment;
import com.ssiot.remote.MainActivity;
import com.ssiot.remote.R;
import com.ssiot.remote.data.AjaxCalibration;
import com.ssiot.remote.data.model.SensorModifyDataModel;
import com.ssiot.remote.data.model.SettingModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MoniCalibrationFrag extends BaseFragment{
    public static final String tag = "CaliFragment";
    private FCaliBtnClickListener mFCaliBtnClickListener;
    private Bundle mBundle;
    private int nodeno = -1;
    private RelativeLayout bar1;
    private RelativeLayout bar2;
    private Spinner sensorSpinner;
    private Spinner channelSpinner;
    private EditText cali_stan_edit;
    private Spinner standardSpinner;
    
    EditText jzEditText;
    private String mSlectedShortName = "";
    private int mSlectedChannel = 0;
    float value = 0;
    private 
    
    TextView bdButton;//标定button
    TextView jzButton;
    Button mSendBtn;
    
    HashMap<String,ArrayList<Integer>> hashMap;
    List<SensorModifyDataModel> smdModels;
    
    private static final int MSG_GETSENSORINFO = 0;
    private static final int MSG_SEND_END = 1;
    private static final int MSG_GET_EXIST_JZ = 2;
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
                case MSG_SEND_END:
                    boolean b = (Boolean) msg.obj;
                    if (b){
                        mSendBtn.setText("发送成功");
                    } else {
                        mSendBtn.setText("发送失败");
                    }
                    break;
                case MSG_GET_EXIST_JZ:
                    if (null != jzEditText){// && jzEditText.getVisibility() == View.VISIBLE bug触发时机
                        float f =  (Float) msg.obj;
                        jzEditText.setText(""+f);
                    }
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
        cali_stan_edit = (EditText) v.findViewById(R.id.cali_stan_edit);
        standardSpinner = (Spinner) v.findViewById(R.id.cali_standard);
        bdButton = (TextView) v.findViewById(R.id.cali_bd);
        jzButton = (TextView) v.findViewById(R.id.cali_jz);
        bdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar1.setVisibility(View.VISIBLE);
                bar2.setVisibility(View.INVISIBLE);
                bdButton.setSelected(true);
                jzButton.setSelected(false);
            }
        });
        jzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar1.setVisibility(View.INVISIBLE);
                bar2.setVisibility(View.VISIBLE);
                bdButton.setSelected(false);
                jzButton.setSelected(true);
            }
        });
        
        bdButton.setSelected(true);
        if (!"c2460cc2-0cec-49e4-9e60-c0dae264".equals(MainActivity.mUniqueID)){//非管理员账户不能进行校准
            jzButton.setVisibility(View.GONE);
        }
        mSendBtn = (Button) v.findViewById(R.id.cali_send);
        mSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (bdButton.isSelected()){
                        value = Float.parseFloat(cali_stan_edit.getText().toString());
                    } else {
                        value = Float.parseFloat(jzEditText.getText().toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                if (value == 0 && bdButton.isSelected()){
                    Toast.makeText(getActivity(), "标定不能为0", Toast.LENGTH_SHORT).show();
                    return;
                }
                mSendBtn.setText("正在发送中");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        boolean b = new AjaxCalibration().SendModify(bdButton.isSelected(), mSlectedChannel, nodeno, value, mSlectedShortName);
                        Message msg = mHandler.obtainMessage(MSG_SEND_END);
                        msg.obj = b;//TODO and 键盘模式
                        mHandler.sendMessage(msg);
                    }
                }).start();                
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
        TextView decreaBtn = (TextView) rootView.findViewById(R.id.cali_decrease);
        TextView increaBtn = (TextView) rootView.findViewById(R.id.cali_increase);
        jzEditText = (EditText) rootView.findViewById(R.id.cali_edit);
        decreaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                try {
                    i = Integer.parseInt(jzEditText.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                jzEditText.setText("" + (i-1));
            }
        });
        increaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                try {
                    i = Integer.parseInt(jzEditText.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                jzEditText.setText("" + (i+1));
            }
        });
    }
    
    private void setSensorAndChannelSpinner(){
        final ArrayList<String> sensorDatas = new ArrayList<String>();//例如（PH值，1001  0123）
        final ArrayList<String> sensorDatasShow = new ArrayList<String>();
        Iterator iterator = hashMap.keySet().iterator();
        while(iterator.hasNext()){
            String str = (String) iterator.next();
            sensorDatas.add(str);
            sensorDatasShow.add(str.substring(0, str.indexOf(",")));
        }
        ArrayAdapter<String> arr_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,sensorDatasShow);
        sensorSpinner.setAdapter(arr_adapter);
        sensorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int posi, long id) {
                ArrayList<String> channelDatas = new ArrayList<String>();
                final ArrayList<Integer> arrayInt = hashMap.get(sensorDatas.get(posi));
                for (int i = 0; i < arrayInt.size(); i ++){
                    channelDatas.add("" + arrayInt.get(i));
                }
                ArrayAdapter<String> channel_adapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_spinner_item,channelDatas);
                channelSpinner.setAdapter(channel_adapter);
                channelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position,
                            long id) {
                        mSlectedChannel = arrayInt.get(position);
//                        if (jzButton.isSelected()){//如果是校准模式 bug初始的时候触发的，所以不能有这个限制
                            String s = sensorDatas.get(posi);
                            try {
                                final int sensorno = Integer.parseInt(s.substring(s.indexOf(",") +1 , s.length()));
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        SettingModel sModel = new AjaxCalibration().GetJiaoZhunBySensorNameAndType(nodeno, 1, sensorno, mSlectedChannel);
                                        if (null != sModel){
                                            Message m = mHandler.obtainMessage(MSG_GET_EXIST_JZ);
                                            m.obj = sModel._value;
                                            mHandler.sendMessage(m);
                                        }
                                    }
                                }).start();
                                
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
//                        }
                        
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
                
                //已有标准的spinner
                ArrayList<String> stanArray = new ArrayList<String>();
                final ArrayList<SensorModifyDataModel> stanModels = new ArrayList<SensorModifyDataModel>();
                if (null != smdModels){
                    for (int i = 0; i < smdModels.size(); i ++){
                        String s = sensorDatas.get(posi);
                        try {
                            int sensorno = Integer.parseInt(s.substring(s.indexOf(",") +1 , s.length()));
                            if (smdModels.get(i)._sensorno == sensorno){
                                stanArray.add(smdModels.get(i)._remark);
                                stanModels.add(smdModels.get(i));
                            }
                            
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Log.e(tag, "----sensormodifydata=null");
                }
                ArrayAdapter<String> stan_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,stanArray);
                standardSpinner.setAdapter(stan_adapter);
                standardSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position,
                            long id) {
                        cali_stan_edit.setText(""+stanModels.get(position)._value);
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
                
                
                mSlectedShortName = sensorDatasShow.get(posi);
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
                hashMap = new AjaxCalibration().GetSensorInfoByNodeNo(""+nodeno);
                smdModels = new AjaxCalibration().GetSensorModifyDataList();
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