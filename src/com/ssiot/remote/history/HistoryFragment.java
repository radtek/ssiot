package com.ssiot.remote.history;

import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ssiot.remote.BaseFragment;
import com.ssiot.remote.BrowserActivity;
import com.ssiot.remote.GetImageThread;
import com.ssiot.remote.GetImageThread.ThumnailHolder;
import com.ssiot.remote.R;
import com.ssiot.remote.data.AjaxHistory;
import com.ssiot.remote.data.DataAPI;
import com.ssiot.remote.data.business.TraceQRcode;
import com.ssiot.remote.data.business.User;
import com.ssiot.remote.data.model.TraceProfileModel;
import com.ssiot.remote.data.model.TraceQRcodeModel;
import com.ssiot.remote.dblocal.LocalDBHelper;
import com.ssiot.remote.monitor.MoniNodeListFrag;
import com.ssiot.remote.myzxing.MipcaActivityCapture;
import com.ssiot.remote.view.SquareLayout;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends BaseFragment{
    public static final String tag = "HisFragment";
    private static final String URL_START = "http://t.ssiot.com/?p=";
    private FHisBtnClickListener mFHisBtnClickListener;
    private EditText mEditText;
//    private ListView mListView;
    private ViewPager pager;
    ArrayList<View> viewList = new ArrayList<View>();
    RadioGroup rGroup;
    View indicater;
    private HisAdapter mHisAdapter;
    private TraceProfilesAdapter mAllAdapter;
    private TraceProfileModel mModel;
    private List<TraceProfileModel> mAllTraces = new ArrayList<TraceProfileModel>();
    private ArrayList<HisBean> mHisList = new ArrayList<HistoryFragment.HisBean>();
    LocalDBHelper dbHelper;
    private String userKey;
    
    private static final int MSG_GET_SINGLE_END = 1;
    private static final int MSG_QRIMG = MoniNodeListFrag.MSG_GET_ONEIMAGE_END;
    private static final int MSG_NOTIFY_HIS = 4;
    private static final int MSG_GET_ALL_END = 3;
    
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            if (!isVisible()){
                Log.e(tag, "-----not visible: msg:" + msg.what);
                return;
            }
            switch (msg.what) {
                case MSG_GET_SINGLE_END:
                    if (null != mFHisBtnClickListener && mModel != null){
                        mHisList.clear();
                        mHisList.addAll(queryFromLocalDB());
                        mAllAdapter.notifyDataSetChanged();
                        mFHisBtnClickListener.onFHisBtnClick(mModel, true);
                    } else {
                        Toast.makeText(getActivity(), R.string.procode_not_found, Toast.LENGTH_SHORT).show();
                    }
                    break;
                case MSG_NOTIFY_HIS:
                    mHisList.clear();
                    mHisList.addAll(queryFromLocalDB());
                    mHisAdapter.notifyDataSetChanged();
                    break;
                case MSG_GET_ALL_END:
                    mAllAdapter.notifyDataSetChanged();
                    break;
                case MSG_QRIMG:
                    ThumnailHolder thumb = (ThumnailHolder) msg.obj;
                    int pix = thumb.imageView.getWidth();
                    RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(pix, pix);//把二维码寬高最大化
                    thumb.imageView.setLayoutParams(rl);
                    thumb.imageView.setImageBitmap(thumb.bitmap);
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
        userKey = getArguments().getString("uniqueid");
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
        pager = (ViewPager) rootView.findViewById(R.id.pager);
        rGroup = (RadioGroup) rootView.findViewById(R.id.tabs);
        indicater = (View) rootView.findViewById(R.id.indicator);
        initRadioGroup();
        initViewPager(inflater);
        setHisListTitleColor(rootView);
//        mListView = (ListView) rootView.findViewById(R.id.his_his_list);
        
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
                    final String code = mEditText.getText().toString();
//                    startSearch(code);
                    if (TextUtils.isEmpty(code)){
                        Toast.makeText(getActivity(), R.string.procode_not_found, Toast.LENGTH_SHORT).show();
                        return;
                    }
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            TraceProfileModel m = new AjaxHistory().getTraceProfile(code);
                            if (null != m){
                                startBrowserAndSave(code, m);
                            } else {
                                showToastMSG(getResources().getString(R.string.procode_not_found));
                            }
                        }
                    }).start();
                }
            }
        });
        
        
        
        return rootView;
    }
    
    private void initRadioGroup(){
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (null != pager) {
                    RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                    Log.v(tag, "----------onCheckedChanged----------" + checkedId + radioButton.isChecked());
                    if (radioButton.isChecked()) {
                        switch (radioButton.getId()) {
                            case R.id.radio0:
                                pager.setCurrentItem(0, true);
                                break;
                            case R.id.radio1:
                                pager.setCurrentItem(1, true);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        });
    }
    
    private void initViewPager(LayoutInflater inflater){
        viewList.clear();
        viewList.add(inflater.inflate(R.layout.list_container, null, false));
        viewList.add(inflater.inflate(R.layout.list_container, null, false));
        pager.setAdapter(new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View page = viewList.get(position);
                container.addView(page);
//                fillPagerViewDataFromList(page, listDatas, position);
                fillPage(page, position);
                return page;
            }
            
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(container.getChildAt(position));
            }
            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }
            
            @Override
            public int getCount() {
                return viewList.size();
            }
        });
        pager.setOnPageChangeListener(new OnPageChangeListener() {
            
            @Override
            public void onPageSelected(int arg0) {
                ((RadioButton) rGroup.getChildAt(arg0)).setChecked(true);
            }
            
            @Override
            public void onPageScrolled(int arg0, float argfloat, int arg2) {
//                Log.v(tag, "----onPageScrolled----" +arg0+"float:"+ argfloat + " arg2:" + arg2);
                View localView = rGroup.getChildAt(arg0);//rGroup.findViewById());
                ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams) indicater.getLayoutParams();
                localMarginLayoutParams.width = (localView.getRight() - localView.getLeft());
                localMarginLayoutParams.leftMargin = ((int)(argfloat * localMarginLayoutParams.width) + localView.getLeft());
                indicater.setLayoutParams(localMarginLayoutParams);
                indicater.setVisibility(View.VISIBLE);
            }
            
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }
    
    private void fillPage(View page, int index){
        if (index == 0){
            ListView mAllListView = (ListView) page.findViewById(R.id.mylist);
            mAllAdapter = new TraceProfilesAdapter(getActivity(),mAllTraces);
            mAllListView.setAdapter(mAllAdapter);
            mAllListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    TraceProfileModel model = mAllTraces.get(position);
                    String code = model._code;
//                    startSearch(code);
                    startBrowserAndSave(code, model);
                }
            });
            new GetUserTraceProfiles().start();
        } else {
            ListView mHisListView = (ListView) page.findViewById(R.id.mylist);
            mHisList.clear();
            mHisList.addAll(queryFromLocalDB());
            mHisAdapter = new HisAdapter(getActivity(), mHisList);
            mHisListView.setAdapter(mHisAdapter);
            mHisListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String code = mHisList.get(position).codeStr;
//                    startSearch(code);
                    startBrowser(code);
                }
            });
        }
    }
    
    private void startBrowser(String code){
        Intent brower = new Intent(getActivity(), BrowserActivity.class);
        brower.putExtra("url", URL_START + code);
        startActivity(brower);
    }
    
    private void startBrowserAndSave(final String code, TraceProfileModel model){
        if (null == model){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    TraceProfileModel m = new AjaxHistory().getTraceProfile(code);
                    insertToLocalDB(m);
                    mHandler.sendEmptyMessage(MSG_NOTIFY_HIS);
                }
            });
        } else {
            insertToLocalDB(model);
            mHandler.sendEmptyMessage(MSG_NOTIFY_HIS);
        }
        startBrowser(code);
    }
    
    private class GetUserTraceProfiles extends Thread{
        @Override
        public void run() {
            sendShowMyDlg("正在获取溯源信息...");
            mAllTraces.clear();
            int parentID = new DataAPI().GetUserIDByUserKey(userKey);
            List<TraceProfileModel> list = new AjaxHistory().getUserTraceProfiles(parentID);
            if (null != list && list.size() > 0){
                mAllTraces.addAll(list);
            }
            sendDismissDlg();
            mHandler.sendEmptyMessage(MSG_GET_ALL_END);
        }
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
        v.setVisibility(View.GONE);
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
            mHandler.sendEmptyMessage(MSG_GET_SINGLE_END);
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
                        int index = qrcodeStr.indexOf(URL_START);
                        if (index > -1){
                            qrcodeStr = qrcodeStr.substring(URL_START.length(), qrcodeStr.length());
                            mEditText.setText(qrcodeStr);
                            startBrowserAndSave(qrcodeStr,null);
                        } else {
                            Toast.makeText(getActivity(), "错误的溯源码", Toast.LENGTH_SHORT).show();
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
            Log.v(tag, "----localdb exists:" + model._code);
            return;
        }
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ProID", model._id);
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
        int proidIndex = cursor.getColumnIndex("ProID");
        int codeIndex = cursor.getColumnIndex("ProCode");
        int nameIndex = cursor.getColumnIndex("ProName");  
        int batchIndex = cursor.getColumnIndex("ProBatchNo"); 
        int timeIndex = cursor.getColumnIndex("ProListingDate");
        List<HisBean> hisList = new ArrayList<HistoryFragment.HisBean>();
        for (cursor.moveToFirst();!(cursor.isAfterLast());cursor.moveToNext()) {
            int proid = cursor.getInt(proidIndex);
            String code = cursor.getString(codeIndex);
            String name = cursor.getString(nameIndex);
            String batch = cursor.getString(batchIndex);
            String time = cursor.getString(timeIndex);
            HisBean hisBean = new HisBean(proid, code, name, batch, time);
            hisList.add(hisBean);
        }
        cursor.close();
        db.close();
        return hisList;
    }
    
    private void deleteLocalHis(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("traceprofiles", null, null);
    }
    
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_his, menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete_his:
                Log.v(tag, "----------------action-settting");
                deleteLocalHis();
                mHandler.sendEmptyMessage(MSG_NOTIFY_HIS);
                break;

            default:
                break;
        }
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
                holder.his_itm_qr = (ImageView) convertView.findViewById(R.id.his_itm_qr);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            final HisBean m = mDatas.get(position);
            holder.his_itm_name.setText(m.nameStr);
            holder.his_itm_batch.setText("批次:"+m.batchStr);
            holder.his_itm_time.setText(m.timeStr);
            holder.his_itm_qr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showQRDialog(m.proID);
                }
            });
            return convertView;
        }
        
        private class ViewHolder{
            TextView his_itm_name;
            TextView his_itm_batch;
            TextView his_itm_time;
            ImageView his_itm_qr;
        }
    }
    
    private void showQRDialog(int traceProfileId){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        RelativeLayout square = (RelativeLayout) inflater.inflate(R.layout.dia_qrcode, null);
        final ImageView imageView = (ImageView) square.findViewById(R.id.qr_imageview);
        final int tpID = traceProfileId;
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<TraceQRcodeModel> list = new TraceQRcode().GetModelList(" TraceProfilesID=" + tpID);
                if (null != list && list.size() > 0){
                    String imgUrl = list.get(0)._imgurl;
                    new GetImageThread(imageView, "http://cloud.ssiot.com/"+imgUrl, mHandler).start();
                }
            }
        }).start();
        builder.setView(square);
        builder.create().show();
    }
    
    private class TraceProfilesAdapter extends BaseAdapter{
        private LayoutInflater mInflater;
        private List<TraceProfileModel> mDatas;
        public TraceProfilesAdapter(Context c, List<TraceProfileModel> mdatas){
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
                holder.his_itm_qr = (ImageView) convertView.findViewById(R.id.his_itm_qr);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            final TraceProfileModel m = mDatas.get(position);
            holder.his_itm_name.setText(m._name);
            holder.his_itm_batch.setText("批次:"+m._batchno);
            String timeString = m._listingDate.toString();
            if (null != timeString && timeString.length() >= 16){
                timeString = timeString.substring(0,16);
            }
            holder.his_itm_time.setText(timeString);
            holder.his_itm_qr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showQRDialog(m._id);
                }
            });
            return convertView;
        }
        
        private class ViewHolder{
            TextView his_itm_name;
            TextView his_itm_batch;
            TextView his_itm_time;
            ImageView his_itm_qr;
        }
    }
    
    private class HisBean{//简单的traceprofile的代替
        int proID;
        String codeStr;
        String nameStr;
        String batchStr;
        String timeStr;
        public HisBean(int proid, String code, String name, String batch, String time){
            proID = proid;
            codeStr = code;
            nameStr = name;
            batchStr = batch;
            timeStr = time;
        }
    }
}