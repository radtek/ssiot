package com.ssiot.remote.history;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ssiot.remote.BaseFragment;
import com.ssiot.remote.R;
import com.ssiot.remote.data.AjaxHistory;
import com.ssiot.remote.data.model.TraceProfileModel;
import com.ssiot.remote.dblocal.LocalDBHelper;
import com.ssiot.remote.myzxing.MipcaActivityCapture;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends BaseFragment{
    public static final String tag = "HisFragment";
    private FHisBtnClickListener mFHisBtnClickListener;
    private EditText mEditText;
    private ListView mListView;
    private HisAdapter mAdapter;
    private TraceProfileModel mModel;
    private ArrayList<HisBean> mHisList = new ArrayList<HistoryFragment.HisBean>();
    LocalDBHelper dbHelper;
    
    private static final int MSG_GET_END = 1;
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            if (!isVisible()){
                Log.e(tag, "-----not visible: msg:" + msg.what);
                return;
            }
            switch (msg.what) {
                case MSG_GET_END:
                    if (null != mFHisBtnClickListener && mModel != null){
                        mHisList.clear();
                        mHisList.addAll(queryFromLocalDB());
                        mAdapter.notifyDataSetChanged();
                        mFHisBtnClickListener.onFHisBtnClick(mModel, true);
                    } else {
                        Toast.makeText(getActivity(), "未获取到此溯源信息,可用测试码73064098查看效果", Toast.LENGTH_SHORT).show();
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
        String userkey = getArguments().getString("userkey");
        mFHisBtnClickListener = (FHisBtnClickListener) getActivity();
        dbHelper = new LocalDBHelper(getActivity());
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v(tag, "----onCreateView----");
        View rootView = inflater.inflate(R.layout.fragment_history, container, false);
        ImageButton cameraButton = (ImageButton) rootView.findViewById(R.id.startcamera);
        Button searchButton = (Button) rootView.findViewById(R.id.startsearch);
        mEditText = (EditText) rootView.findViewById(R.id.qrcode_edit);
        setHisListTitleColor(rootView);
        mListView = (ListView) rootView.findViewById(R.id.his_his_list);
        mHisList.clear();
        mHisList.addAll(queryFromLocalDB());
        mAdapter = new HisAdapter(getActivity(),mHisList);
        mListView.setAdapter(mAdapter);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), MipcaActivityCapture.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent, REQUEST_CODE_F_SCAN);
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mFHisBtnClickListener && null != mEditText){
                    String code = mEditText.getText().toString();
                    startSearch(code);
                }
            }
        });
        
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String code = mHisList.get(position).codeStr;
                startSearch(code);
            }
        });
        return rootView;
    }
    
    private void startSearch(String code){
        sendShowMyDlg("正在获取溯源信息...");
        mModel = null;
        new GetTraceProfileThread(code).start();
        mEditText.clearFocus();//关闭软键盘
        View view = getActivity().getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    
    private void setHisListTitleColor(View rootView){
        View v = rootView.findViewById(R.id.his_his_title);
        v.findViewById(R.id.his_itm_name).setBackgroundColor(getResources().getColor(R.color.ssiotgreen));
        v.findViewById(R.id.his_itm_batch).setBackgroundColor(getResources().getColor(R.color.ssiotgreen));
        v.findViewById(R.id.his_itm_time).setBackgroundColor(getResources().getColor(R.color.ssiotgreen));
    }
    
    private class GetTraceProfileThread extends Thread{
        String code;
        public GetTraceProfileThread(String code){
            this.code = code;
        }
        @Override
        public void run() {
            mModel = new AjaxHistory().getTraceProfile(code);
            insertToLocalDB(mModel);
            sendDismissDlg();
            mHandler.sendEmptyMessage(MSG_GET_END);
        }
    }
    
    @Override
    public void onResume() {
        super.onResume();
    }
    
    private static final int REQUEST_CODE_F_SCAN = 1;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v(tag, "------onActivityResult----" + requestCode +resultCode);
        switch (requestCode) {
            case REQUEST_CODE_F_SCAN:
                if (resultCode == Activity.RESULT_OK){
                    if (null != mEditText){
                        Bundle bundle = data.getExtras();
                        String qrcodeStr = bundle.getString("result");
                        int index = qrcodeStr.indexOf("ProCode='");
                        if (index > -1){
                            qrcodeStr = qrcodeStr.substring(index + 9, qrcodeStr.length() - 1);
                            mEditText.setText(qrcodeStr);
                        } else {
                            Toast.makeText(getActivity(), "错误的二维码", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                break;

            default:
                break;
        }
    }
    
    private void insertToLocalDB(TraceProfileModel model){
        if (null == model || isExistInLocal(model._code)){
            return;
        }
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ProCode", model._code);
        values.put("ProName", model._name);
        values.put("ProBatchNo", model._batchno);
        String timeString = model._listingDate.toString();
        if (timeString.length() >= 16){
            timeString = timeString.substring(0,16);
        }
        
        values.put("ProListingDate", timeString);
        
        db.insert("traceprofiles", null, values);//nullcolumnhack is null or "id"?
        db.close();
    }
    
    private boolean isExistInLocal(String code){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("traceprofiles", null, "ProCode=?", new String[]{code}, null, null, "id asc");
        if (cursor != null && cursor.moveToFirst()){
            return true;
        }
        if (cursor != null){
            cursor.close();
        }
        db.close();
        return false;
    }
    
    private List<HisBean> queryFromLocalDB(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("traceprofiles", null, null, null, null, null, "id asc");
        int codeIndex = cursor.getColumnIndex("ProCode");
        int nameIndex = cursor.getColumnIndex("ProName");  
        int batchIndex = cursor.getColumnIndex("ProBatchNo"); 
        int timeIndex = cursor.getColumnIndex("ProListingDate");
        List<HisBean> hisList = new ArrayList<HistoryFragment.HisBean>();
        for (cursor.moveToFirst();!(cursor.isAfterLast());cursor.moveToNext()) {
            String code = cursor.getString(codeIndex);
            String name = cursor.getString(nameIndex);
            String batch = cursor.getString(batchIndex);
            String time = cursor.getString(timeIndex);
            HisBean hisBean = new HisBean(code, name, batch, time);
            hisList.add(hisBean);
        }
        cursor.close();
        db.close();
        return hisList;
    }
    
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.his, menu);
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
    
    @Override
    public boolean canGoback(){
        return false;
    }
    
    @Override
    public void onMyBackPressed(){//add by jingbo
    }
    
    public void setClickListener(FHisBtnClickListener listen){
        mFHisBtnClickListener = listen;
    }
    
    //回调接口，留给activity使用
    public interface FHisBtnClickListener {  
        void onFHisBtnClick(TraceProfileModel m, boolean forceScan);  
    }
    
    private class HisAdapter extends BaseAdapter{
        private LayoutInflater mInflater;
        private List<HisBean> mDatas;
        public HisAdapter(Context c, List<HisBean> mdatas){
            mInflater = LayoutInflater.from(c);
            mDatas = mdatas;
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
            ViewHolder holder;
            if (null == convertView){
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.his_list_item, null);
                holder.his_itm_name = (TextView) convertView.findViewById(R.id.his_itm_name);
                holder.his_itm_batch = (TextView) convertView.findViewById(R.id.his_itm_batch);
                holder.his_itm_time = (TextView) convertView.findViewById(R.id.his_itm_time);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            HisBean m = mDatas.get(position);
            holder.his_itm_name.setText(m.nameStr);
            holder.his_itm_batch.setText(m.batchStr);
            holder.his_itm_time.setText(m.timeStr);
            return convertView;
        }
        
        private class ViewHolder{
            TextView his_itm_name;
            TextView his_itm_batch;
            TextView his_itm_time;
        }
    }
    
    private class HisBean{//简单的traceprofile的代替
        String codeStr;
        String nameStr;
        String batchStr;
        String timeStr;
        public HisBean(String code, String name, String batch, String time){
            codeStr = code;
            nameStr = name;
            batchStr = batch;
            timeStr = time;
        }
    }
}