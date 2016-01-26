package com.ssiot.remote.monitor;

import android.R.integer;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ssiot.remote.BaseFragment;
import com.ssiot.remote.R;
import com.ssiot.remote.Utils;
import com.ssiot.remote.control.TriggerDiaFrag.TriRuleElementBean;
import com.ssiot.remote.data.DataAPI;
import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.model.AlarmRuleBean;
import com.ssiot.remote.data.model.AlarmRuleModel;
import com.ssiot.remote.data.model.view.SensorViewModel;
import com.ssiot.remote.dblocal.LocalDBHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MoniAlarmFrag extends BaseFragment{
    public static final String tag = "AlarmFragment";
    private FAlarmBtnClickListener mFAlarmBtnClickListener;
    private Bundle mBundle;
    
    private int mSelectedRelationType = 0;//同时满足条件，满足其中之一
    public static final String[] relationDatas = {"同时满足条件","满足其中之一"};
    Spinner relationSpinner;
    ListView mListView;
    ImageButton addBtn;
    Button mFinishBtn;
    private AlarmRuleAdapter mAdapter;
    private AlarmRuleModel mAlarmModel = new AlarmRuleModel();
    int nodeno = -1;
    String uniqueID= "";
    List<SensorViewModel> mSensorList;
    public ArrayList<AlarmRuleBean> mElementDatas = new ArrayList<AlarmRuleBean>();
    
    ArrayList<String> mSensorDatas = null;//TODO 添加规则时供选择的sensor列表
    private final String[] maxMinDatas = {"大于","小于","范围内"};
    
    private static final int MSG_GET_END = 1;
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case MSG_GET_END:
                    if (null != mAlarmModel && relationSpinner != null){
                        relationSpinner.setSelection(relationDatas[0].equals(mAlarmModel._relation) ? 0 : 1);
                    }
                    if (null != mSensorList && mSensorList.size() != 0){
                        mSensorDatas = new ArrayList<String>();
                        for (int i = 0; i < mSensorList.size(); i ++){
                            mSensorDatas.add(mSensorList.get(i)._sensorname);
                        }
                    }
                    if (null != mAdapter){
                        mAdapter.notifyDataSetChanged();
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
        mBundle = getArguments();
        if (null != mBundle){
            nodeno = mBundle.getInt("nodeno");
            uniqueID = mBundle.getString("uniqueid");
            mAlarmModel._uniqueID = uniqueID;
            Log.v(tag, "-------onCreate-------" + uniqueID + mBundle.getString("nodetitle"));
        }
        setHasOptionsMenu(true);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_moni_alarm, container, false);
        initTitleBar(v.findViewById(R.id.moni_title_alarm));
        relationSpinner = (Spinner) v.findViewById(R.id.ala_relation_type);
        ArrayAdapter<String> relationAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,relationDatas);
        relationSpinner.setAdapter(relationAdapter);
        relationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!relationDatas[position].equals(mAlarmModel._relation)){
                    mAlarmModel._relation = relationDatas[position];
//                    new SaveRuleThread().start();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        LinearLayout alaRuleTitle = (LinearLayout) v.findViewById(R.id.ala_rule_title);
        int titlecolor = getResources().getColor(R.color.ssiotgreen);
        alaRuleTitle.findViewById(R.id.ele_name).setBackgroundColor(titlecolor);
        alaRuleTitle.findViewById(R.id.ele_type).setBackgroundColor(titlecolor);
        alaRuleTitle.findViewById(R.id.ele_num).setBackgroundColor(titlecolor);
        addBtn = (ImageButton) alaRuleTitle.findViewById(R.id.tri_btn);
        addBtn.setBackgroundColor(titlecolor);
        addBtn.setImageResource(R.drawable.tri_rule_add);
        final View anchorView = v;
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddPopup(anchorView);
            }
        });
        if (!TextUtils.isEmpty(uniqueID)){
            mListView = (ListView) v.findViewById(R.id.ala_element_list);
            mAdapter = new AlarmRuleAdapter(getActivity(), mElementDatas);
            mListView.setAdapter(mAdapter);
        }
        
        mFinishBtn = (Button) v.findViewById(R.id.ala_finish);
        mFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SaveRuleThread().start();
            }
        });
        new GetSensorDatasThread().start();
        return v;
    }
    
    private void initTitleBar(View rootView){
        TextView mTitleView = (TextView) rootView.findViewById(R.id.moni_title);
        ImageView mOnlineView = (ImageView) rootView.findViewById(R.id.moni_status);
        ImageView mNetTypeView = (ImageView) rootView.findViewById(R.id.moni_net_type);
        if (null != mBundle){
            mTitleView.setText(mBundle.getString("nodetitle"));
            mOnlineView.setImageResource(mBundle.getBoolean("status", false) ? R.drawable.online : R.drawable.offline);
            mNetTypeView.setImageResource(mBundle.getBoolean("isgprs", false) ? R.drawable.connect_gprs : R.drawable.connect_zigbee);
        }
    }
    
    public class GetSensorDatasThread extends Thread{
        @Override
        public void run() {
            if (!Utils.isNetworkConnected(getActivity())){
                showToastMSG("请检查网络！");
                return;
            }
            if (nodeno != -1){
                sendShowMyDlg("");
                mSensorList = DataAPI.GetSensorListByNodeNoString(""+nodeno);
                getRules(uniqueID);
                DbHelperSQL.outSideClose();
                mHandler.sendEmptyMessage(MSG_GET_END);
                sendDismissDlg();
            }
        }
    }
    
    private void getRules(String unique){//node的UniqueID
        mAlarmModel = DataAPI.GetAlarmRule(unique);
        if (null == mAlarmModel){
            mAlarmModel = new AlarmRuleModel();
        }
        mElementDatas.clear();
        if (!TextUtils.isEmpty(mAlarmModel._ruleStr)){
            mElementDatas.addAll(mAlarmModel.parseAlarmJSON(mAlarmModel._ruleStr));
        }
    }
    
    private class SaveRuleThread extends Thread{
        @Override
        public void run() {
            if (!Utils.isNetworkConnected(getActivity())){
                showToastMSG("请检查网络！");
                return;
            }
            sendShowMyDlg("正在保存预警规则");
            Log.v(tag, "------SaveRuleThread------relation:" +relationSpinner.getSelectedItemPosition() );
            mAlarmModel._uniqueID = uniqueID;
            mAlarmModel._relation = relationDatas[relationSpinner.getSelectedItemPosition()];
            mAlarmModel._ruleStr = buildJSON(mElementDatas);
            boolean b = false;
            if (null == mElementDatas || mElementDatas.size() == 0){
                b = DataAPI.DeleteAlarmRule(uniqueID);
            } else {
                b = DataAPI.SaveAlarmRule(mAlarmModel);
            }
            DbHelperSQL.outSideClose();
            if (!b){
                Log.e(tag, "save fail!!!!!!!!!!!!!!" + mAlarmModel.toString());
            }
            sendDismissDlg();
        }
    }
    
    public String buildJSON(ArrayList<AlarmRuleBean> ruleBeans){
        String str = "";
        try {
            JSONArray jarr = new JSONArray();
            for (int i = 0; i < ruleBeans.size(); i ++){
                JSONObject jo = new JSONObject();
                AlarmRuleBean bean = ruleBeans.get(i);
                jo.put("sensorname", bean.sensorName);
                jo.put("sensorno", bean.sensorType);
                jo.put("channel", bean.channel);
                jo.put("type", bean.type);
                jo.put("value", bean.value);
                jarr.put(jo);
            }
            str = jarr.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
    
    private void showAddPopup(View anchor){
        View popView = LayoutInflater.from(getActivity()).inflate(R.layout.tri_add_popup, null);
        
        final Spinner mSensorSpinner = (Spinner) popView.findViewById(R.id.tri_pop_sensor_spinner);
        final Spinner mMaxMinSpinner = (Spinner) popView.findViewById(R.id.tri_pop_maxmin_spinner);
        final EditText numEdit = (EditText) popView.findViewById(R.id.tri_maxmin_value_edit);
        final EditText numEdit2 = (EditText) popView.findViewById(R.id.tri_maxmin_value_edit_2);
        Button tri_pop_add = (Button) popView.findViewById(R.id.tri_pop_add);
        Button tri_pop_cancel = (Button) popView.findViewById(R.id.tri_pop_cancel);
        
        if (null != mSensorDatas){
            ArrayAdapter<String> sensorAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,mSensorDatas);
            mSensorSpinner.setAdapter(sensorAdapter);
        } else {
            String[] pleaseWait = {"正在查找传感器"};
            ArrayAdapter<String> sensorAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,pleaseWait);
            mSensorSpinner.setAdapter(sensorAdapter);
        }
        
        ArrayAdapter<String> maxminAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,maxMinDatas);
        mMaxMinSpinner.setAdapter(maxminAdapter);
        mMaxMinSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 2){
                    numEdit2.setVisibility(View.VISIBLE);
                } else {
                    numEdit2.setVisibility(View.GONE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        
        final PopupWindow popupWindow = new PopupWindow(popView,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setAnimationStyle(R.style.ModePopupList);
        
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        
        
        tri_pop_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SensorViewModel sModel = mSensorList.get(mSensorSpinner.getSelectedItemPosition());
                int maxMinPosition = mMaxMinSpinner.getSelectedItemPosition();
                String type = maxMinDatas[maxMinPosition];
                String value = numEdit.getText().toString();
                if (TextUtils.isEmpty(value)){
                    Toast.makeText(getActivity(), "数值不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String value2 = "";
                if (maxMinPosition == 2){
                    value2 = numEdit2.getText().toString();
                    if (TextUtils.isEmpty(value2)){
                        Toast.makeText(getActivity(), "数值不能为空", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (Float.parseFloat(value) >= Float.parseFloat(value2)){
                        Toast.makeText(getActivity(), "最小值不能大于最大值", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    value2 = "," + value2;
                }
                
                mElementDatas.add(new AlarmRuleBean(sModel._sensorname,sModel._sensorno,sModel._channel,type,value + value2,1));
                mAdapter.notifyDataSetChanged();
                if (popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
//                new SaveRuleThread().start();
            }
        });
        
        tri_pop_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
            }
        });
        
//        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.ssiot_green));
//        popupWindow.showAtLocation(anchor, Gravity.CENTER, 0, 0);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_card_normal));
        popupWindow.showAsDropDown(addBtn, addBtn.getWidth(), 0);
    }
    
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.Alarm, menu);
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
    
    public void setClickListener(FAlarmBtnClickListener listen){
        mFAlarmBtnClickListener = listen;
    }
    
    //回调接口，留给activity使用
    public interface FAlarmBtnClickListener {  
        void onFAlarmBtnClick();  
    }
    
    public class AlarmRuleAdapter extends BaseAdapter{
        private ArrayList<AlarmRuleBean> mDatas;
        private LayoutInflater mInflater;
        
        public AlarmRuleAdapter(Context c,ArrayList<AlarmRuleBean> d){
            mDatas = d;
            mInflater = LayoutInflater.from(c);
        }

        @Override
        public int getCount() {
            return mDatas.size();
        }

        @Override
        public Object getItem(int position) {
            return mDatas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHold hold;
            if (null == convertView){
                hold = new ViewHold();
                convertView = mInflater.inflate(R.layout.tri_addrule_item, null);
                hold.sensorNameView = (TextView) convertView.findViewById(R.id.ele_name);
                hold.typeView = (TextView) convertView.findViewById(R.id.ele_type);
                hold.numView = (TextView) convertView.findViewById(R.id.ele_num);
                hold.mBtn = (ImageButton) convertView.findViewById(R.id.tri_btn);
                convertView.setTag(hold);
            } else {
                hold = (ViewHold) convertView.getTag();
            }
            final AlarmRuleBean bean = mDatas.get(position);
            hold.sensorNameView.setText(bean.sensorName);
            hold.typeView.setText(bean.type);
            hold.numView.setText(""+bean.value);
            hold.mBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDatas.remove(bean);
                    notifyDataSetChanged();
//                    new SaveRuleThread().start();
                }
            });
            return convertView;
        }
        
        private class ViewHold {
            public TextView sensorNameView;
            public TextView typeView;
            public TextView numView;
            private ImageButton mBtn;
        }
    }
    
}