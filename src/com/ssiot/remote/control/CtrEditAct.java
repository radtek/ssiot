package com.ssiot.remote.control;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.ssiot.remote.R;
import com.ssiot.remote.Utils;
import com.ssiot.remote.data.ControlController;
import com.ssiot.remote.data.model.view.ControlDeviceView3Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CtrEditAct extends FragmentActivity{
    private static final String tag = "CtrEditAct";
    TextView startTimeTextView;
    TextView endTimeTextView;
    String startTimeStr = "";
    Date startTime;
    Date endTime;
    String endTimeStr = "";
    TextView workingTimeTextView;
    TextView spandTimeTextView;
    int workingTime = 2;
    int spandTime = 15;
    TextView deviceSelTextView;
    private Dialog mDialog;
    private ArrayList<String> deviceNames;
    private ArrayList<Integer> deviceNos;
    private String selectedDeviceNos = "";
    private String controlnodeuniqueid;
    
    private static final int MSG_SAVE_END = 1;
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case MSG_SAVE_END:
                    if (null != mDialog && mDialog.isShowing()){
                        mDialog.dismiss();
                    }
                    if ((Boolean) msg.obj){
                        Toast.makeText(CtrEditAct.this, "成功", Toast.LENGTH_SHORT).show();
                        setResult(RESULT_OK);
                        finish();
                    } else {
                        Toast.makeText(CtrEditAct.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                    break;

                default:
                    break;
            }
        };
    };
    
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.dia_circle);
        hidActionbar();
        Intent intent = getIntent();
        deviceNames = intent.getStringArrayListExtra(Utils.BUN_DEVICE_NAMES);
        deviceNos = intent.getIntegerArrayListExtra(Utils.BUN_DEVICE_NOS);
        controlnodeuniqueid = intent.getStringExtra("controlnodeuniqueid");
        if (null == deviceNames || null == deviceNos){
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }
        findViews();
    }
    
    @SuppressLint("NewApi")
    private void hidActionbar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
            getActionBar().hide();
        }
    }
    
    private void findViews(){
        startTimeTextView = (TextView) findViewById(R.id.TextViewStart);
        endTimeTextView = (TextView) findViewById(R.id.TextViewEnd);
        workingTimeTextView = (TextView) findViewById(R.id.TextViewTime);
        spandTimeTextView = (TextView) findViewById(R.id.TextViewpand);
        deviceSelTextView = (TextView) findViewById(R.id.TextViewDeviceSelect);
    }
    
    public void StartTimeClick(View v){
        showTimePickDialog(0);
    }
    
    public void EndTimeClick(View v) {
        showTimePickDialog(1);
    }
    
    public void TimeClick(View v) {//持续时长
        showEditDialog(R.string.setTime);
    }
    
    public void SpandClick(View v) {//每次间隔
        showEditDialog(R.string.setSpand);
    }
    
    public void DeviceSelectClick(View v) {//改为了设备选择click
        showDeviceSelDialog();
    }
    
    public void SubClick(View v){
        Log.v(tag, "----SubClick----" + startTimeStr + endTimeStr + workingTime + spandTime);
        if (workingTime > spandTime){
            Toast.makeText(this, "间隔时间必须大于运行时间", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!TextUtils.isEmpty(startTimeStr) && !TextUtils.isEmpty(endTimeStr) && null != endTime && null != startTime){
            if (endTime.getTime() <= startTime.getTime()){//TODO
                Toast.makeText(this, "时段设置错误", Toast.LENGTH_SHORT).show();
                return;
            }
        } else {
            Toast.makeText(this, "时段设置错误", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(selectedDeviceNos)){
            Toast.makeText(this, "未选择设备", Toast.LENGTH_SHORT).show();
            return;
        }
        mDialog = Utils.createLoadingDialog(this, "");
        mDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                JSONArray jArray= new JSONArray();
                JSONObject jsonObj = new JSONObject();
                try {
                    jsonObj.put("ID","1");
                    jsonObj.put("StartTime",startTimeStr);
                    jsonObj.put("EndTime",endTimeStr);
                    jsonObj.put("OnceRunTime",workingTime);
                    jsonObj.put("IntervalTime",spandTime);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jArray.put(jsonObj);
                final String conditionStr = jArray.toString();
                boolean b = new ControlController().SaveControlTimeUser(conditionStr, null, controlnodeuniqueid, 5, selectedDeviceNos, "");
                Message msg = mHandler.obtainMessage(MSG_SAVE_END);
                msg.obj = b;
                mHandler.sendMessage(msg);
            }
        }).start();
    }
    
    private String buildTimeStr(Timestamp t){
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return formater.format(t);
    }
    
    public void onBackClick(View v){
        super.onBackPressed();
    }
    
    private void showTimePickDialog(final int startOrEnd){
        AlertDialog.Builder bui = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dia_date_time_pick, null);
        final DatePicker dp = (DatePicker) view.findViewById(R.id.date_pick);
        final TimePicker tp = (TimePicker) view.findViewById(R.id.time_pick);
        bui.setTitle("时间选择").setView(view).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date d = new Date(dp.getYear()-1900, dp.getMonth(), dp.getDayOfMonth(), tp.getCurrentHour(), tp.getCurrentMinute());
                String str = formatter.format(d);
                if (startOrEnd == 0){ 
                    startTimeStr = str;
                    startTime = d;
                    ((TextView) startTimeTextView).setText(startTimeStr);
                } else {
                    endTimeStr = str;
                    endTime = d;
                    ((TextView) endTimeTextView).setText(endTimeStr);
                }
            }
        }).setNegativeButton(android.R.string.cancel, null);
        bui.create().show();
    }
    
    private void showEditDialog(final int resId){
        AlertDialog.Builder bui = new AlertDialog.Builder(this);
        final EditText editText = new EditText(this);
        editText.setInputType(EditorInfo.TYPE_CLASS_NUMBER);
        bui.setTitle(resId).setView(editText).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = editText.getText().toString();
                int i = 2;
                try {
                    i = Integer.parseInt(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (R.string.setTime == resId){
                    workingTime = i;
                    ((TextView) workingTimeTextView).setText(""+workingTime);
                } else if (R.string.setSpand == resId){
                    spandTime = i;
                    ((TextView) spandTimeTextView).setText(""+spandTime);
                }
            }
        }).setNegativeButton(android.R.string.cancel, null);
        bui.create().show();
    }
    
    private void showDeviceSelDialog(){
        AlertDialog.Builder bui = new AlertDialog.Builder(this);
        final GridView gv = new GridView(this);
        ArrayList<DeviceCheckerData> as = new ArrayList<DeviceCheckerData>();
        for (int i = 0; i < deviceNames.size(); i ++){
            as.add(new DeviceCheckerData(deviceNos.get(i), deviceNames.get(i), false));
        }
        final ControlDeviceGridAdapter adapter = new ControlDeviceGridAdapter(this, as);
        gv.setAdapter(adapter);
        bui.setTitle("选择设备").setView(gv).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectedDeviceNos = adapter.getSelectedListStr();
                deviceSelTextView.setText(selectedDeviceNos);
            }
        }).setNegativeButton(android.R.string.cancel, null);
        bui.create().show();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}