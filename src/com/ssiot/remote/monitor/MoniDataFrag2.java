package com.ssiot.remote.monitor;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.text.StaticLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.ssiot.remote.BaseFragment;
import com.ssiot.remote.MainActivity;
import com.ssiot.remote.MyCache;
import com.ssiot.remote.R;
import com.ssiot.remote.Utils;
import com.ssiot.remote.data.AjaxGetNodesDataByUserkey;
import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.model.view.NodeView2Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class MoniDataFrag2 extends BaseFragment{
    public static final String tag = "DataFragment";
    private FDataBtnClickListener mFDataBtnClickListener;
    private Context mContext;
    private static final int LINEARSIZE = 10;
    TextView mTitleView;
    ImageView mOnlineView;
    ImageView mNetTypeView;
    TextView mTimeTextTitle;
    LinearLayout mLeftLinear;
    LinearLayout mRightLinear;
    
    private Spinner moni_grain_spinner;
    private View moni_starttime_view;
    private View moni_endtime_view;
    private View mSearchView;
    private TextView mPageNext;
    private TextView mPageBefore;
    
    List<NodeView2Model> mListData = new ArrayList<NodeView2Model>();
    List<NodeView2Model> mShowData = new ArrayList<NodeView2Model>();
    private Bundle mBundle;
    private int nodeno = -1;
    private String grainSize = "逐小时";//修改时注意要setSelction
    private String[] grainList = {"十分钟","逐小时","逐日","逐月","逐年"};
    private String startTime = "2016-01-01 01:00:00";
    private String endTime = "2016-01-01 02:00:00";
    private int mPageIndex = 1;//从1开始
    
    private static final int MSG_GET_END = 0;
    private static final int MSG_SEARCH = 1;
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            if (!isVisible()){
                Log.e(tag, "--------not visible----what:" + msg.what);
            }
            switch (msg.what) {
                case MSG_GET_END:
                    if (null != mListData){
                        if (mListData.size() > 0){
                            mShowData.clear();
                            int totalSize = mListData.size();
                            for (int i = 0 ; i < LINEARSIZE; i ++){
                                int realIndex = (mPageIndex -1) * LINEARSIZE + i;
                                if (realIndex < totalSize){
                                    mShowData.add(mListData.get(realIndex));
                                } else {
                                    break;
                                }
                            }
                            buildLeftView(mTimeTextTitle, mLeftLinear, mShowData);
                            buildRightView(mRightLinear, mShowData);
                        } else {
                            Toast.makeText(mContext, "未查询到结果", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
                case MSG_SEARCH:
                    new GetMoniDataThread().start();
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
        mContext = getActivity();
        
        endTime = Utils.buildTime(0);
        if (grainList[0].equals(grainSize)){
            startTime = Utils.buildTime(-2 * 3600);
        } else if (grainList[1].equals(grainSize)){
            startTime = Utils.buildTime(-24 * 3600);
        } else if (grainList[2].equals(grainSize)){
            startTime = Utils.buildTime(-15 * 24 * 3600);
        } else if (grainList[3].equals(grainSize)){
            startTime = Utils.buildTime(-365 * 24 * 3600);
        } else if (grainList[4].equals(grainSize)){
            startTime = Utils.buildTime(-10 * 365 * 24 * 3600);
        } else {
            startTime = Utils.buildTime(-2*3600);
        }
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v(tag, "--------onCreateView--------");
        View v = inflater.inflate(R.layout.frag_moni_data, container, false);
        mTitleView = (TextView) v.findViewById(R.id.moni_title);
        mOnlineView = (ImageView) v.findViewById(R.id.moni_status);
        mNetTypeView = (ImageView) v.findViewById(R.id.moni_net_type);
        mTimeTextTitle = (TextView) v.findViewById(R.id.left_holdertitle);
        mLeftLinear = (LinearLayout) v.findViewById(R.id.left_holder);
        moni_grain_spinner = (Spinner) v.findViewById(R.id.moni_grain_spinner);
        moni_starttime_view = (View) v.findViewById(R.id.moni_starttime_view);
        moni_endtime_view = (View) v.findViewById(R.id.moni_endtime_view);
        mSearchView = (View) v.findViewById(R.id.start_search);
        mRightLinear = (LinearLayout) v.findViewById(R.id.right_holder);
        mPageBefore = (TextView) v.findViewById(R.id.page_before);
        mPageNext = (TextView) v.findViewById(R.id.page_next);
        initTitleBar();
        initTopbar();
        initBottomBar();
        new GetMoniDataThread().start();
        
        return v;
    }
    
    private void initTitleBar(){
        mTitleView.setText(mBundle.getString("nodetitle"));
        mOnlineView.setImageResource(mBundle.getBoolean("status", false) ? R.drawable.online : R.drawable.offline);
        mNetTypeView.setImageResource(mBundle.getBoolean("isgprs", false) ? R.drawable.connect_gprs : R.drawable.connect_zigbee);
        Log.v(tag, "-----odetitle:"+mBundle.getString("nodetitle"));
    }
    
    private void initTopbar(){
        ArrayAdapter<String> arr_adapter = new ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_item,grainList);
        moni_grain_spinner.setAdapter(arr_adapter);
        moni_grain_spinner.setSelection(1);
        moni_grain_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                grainSize = grainList[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                
            }
        });
        
        ((TextView)moni_starttime_view).setText(startTime);
        moni_starttime_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createTimePickDialog(0).show();
            }
        });
        ((TextView)moni_endtime_view).setText(endTime);
        moni_endtime_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createTimePickDialog(1).show();
            }
        });
        
        mSearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    Date end = sdf.parse(endTime);
                    Date start = sdf.parse(startTime);
                    if (grainSize.equals(grainList[0]) && (end.getTime()-start.getTime())> 15 * 24 * 3600 * 1000){
                        Toast.makeText(mContext, "请缩小选择范围", Toast.LENGTH_SHORT).show();
                    } else {
                        new GetMoniDataThread().start();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    private void initBottomBar(){
        mPageBefore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPageIndex > 1){
                    mPageIndex -= 1 ;
                    mHandler.sendEmptyMessage(MSG_GET_END);
                }
            }
        });
        
        mPageNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalPage = (mListData.size() +LINEARSIZE -1)  / LINEARSIZE;
                if (mPageIndex < totalPage){
                    mPageIndex += 1 ;
                    mHandler.sendEmptyMessage(MSG_GET_END);
                }
            }
        });
    }
    
    private Dialog createTimePickDialog(final int startOrEnd){
        if (getActivity() != null){
            AlertDialog.Builder bui = new AlertDialog.Builder(mContext);
            View view = getActivity().getLayoutInflater().inflate(R.layout.dia_date_time_pick, null);
            final DatePicker dp = (DatePicker) view.findViewById(R.id.date_pick);
            final TimePicker tp = (TimePicker) view.findViewById(R.id.time_pick);
            bui.setTitle("时间选择").setView(view).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date d = new Date(dp.getYear()-1900, dp.getMonth(), dp.getDayOfMonth(), tp.getCurrentHour(), tp.getCurrentMinute());
                    String str = formatter.format(d);
                    
                    if (startOrEnd == 0){
                        startTime = str;
                        ((TextView) moni_starttime_view).setText(startTime);
                    } else {
                        endTime = str;
                        ((TextView) moni_endtime_view).setText(endTime);
                    }
                }
            }).setNegativeButton(android.R.string.cancel, null);
            return bui.create();
        }
        return null;
    }
    
    private class GetMoniDataThread extends Thread{
        @Override
        public void run() {
            sendShowMyDlg("正在查询");
            if (nodeno >= 0){
//                List<NodeView2Model> nList = new AjaxGetNodesDataByUserkey().GetNodesDataByUserkeyAndType(MainActivity.mUniqueID, ""+nodeno, grainSize);
                List<NodeView2Model> nList = new AjaxGetNodesDataByUserkey().GetNodesDetailData(MainActivity.mUniqueID, ""+nodeno, grainSize,startTime,endTime);
                DbHelperSQL.outSideClose();
                mListData.clear();
                mListData.addAll(nList);
            } else {
                Log.e(tag, "----!!!! nodeno < 0!");
            }
            
            sendDismissDlg();
            setCacheData();
//            SimpleAdapter sAdapter = new SimpleAdapter(getParentFragment().getActivity(), data, resource, from, to)
            mHandler.sendEmptyMessage(MSG_GET_END);
        }
    }
    
    private void setCacheData(){
        MainActivity ma = (MainActivity) getParentFragment().getParentFragment().getActivity();
        MyCache cache = ma.getCaheManager();
        cache.put("monidata_list", mListData);
    }
    
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.data, menu);
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
    
    public void setClickListener(FDataBtnClickListener listen){
        mFDataBtnClickListener = listen;
    }
    
    //回调接口，留给activity使用
    public interface FDataBtnClickListener {  
        void onFDataBtnClick();  
    }
    
    private void buildLeftView(TextView timeTextTitle, LinearLayout leftLinear, List<NodeView2Model> listData){
        leftLinear.removeAllViews();
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        lp.weight = 1;
        
        timeTextTitle.setText("时间");
        timeTextTitle.setGravity(Gravity.CENTER);
        timeTextTitle.setEms(5);
        timeTextTitle.setBackgroundColor(mContext.getResources().getColor(R.color.datalist_green));
        leftLinear.addView(timeTextTitle, lp);
        
        int size = LINEARSIZE < listData.size() ? LINEARSIZE : listData.size();
        for (int i = 0; i < LINEARSIZE; i ++){
            
            TextView tView = new TextView(mContext);
            if (i < size){
                NodeView2Model n2m = listData.get(i);
                tView.setText("" + n2m._detailTime);
                tView.setBackgroundColor(mContext.getResources().getColor(R.color.ssiot_title_yellow));
            }
            tView.setEms(5);
            tView.setGravity(Gravity.CENTER);
            tView.setMaxLines(2);
            tView.setLayoutParams(lp);
            leftLinear.addView(tView, lp);
            View divider = new View(mContext);
            divider.setLayoutParams(new LinearLayout.LayoutParams(1, 1));
            leftLinear.addView(divider);
        }
    }
    
    private void buildRightView(LinearLayout rootLayout, List<NodeView2Model> listData){
        rootLayout.removeAllViews();
        int size = listData.size();
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        lp.weight = 1;
        
        NodeView2Model n2m = listData.get(0);
        LinearLayout headRow = new LinearLayout(mContext);
        headRow.setOrientation(LinearLayout.HORIZONTAL);
        for (int j = 0; j < n2m._nodeData_list.size(); j ++){
            TextView t = new TextView(mContext);
            t.setText(n2m._nodeData_list.get(j)._name);
            t.setSingleLine();
            t.setMaxEms(5);
            t.setMinEms(5);
            t.setGravity(Gravity.CENTER);
            t.setBackgroundColor(mContext.getResources().getColor(R.color.datalist_header));
            LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            headRow.addView(t,lp2);
            View divider = new View(mContext);
            divider.setLayoutParams(new LinearLayout.LayoutParams(1, 1));
            headRow.addView(divider);
        }
        rootLayout.addView(headRow , lp);
        
        for (int k = 0; k < LINEARSIZE; k ++){
            LinearLayout row = new LinearLayout(mContext);
            row.setOrientation(LinearLayout.HORIZONTAL);
            if (k < size){
                n2m = listData.get(k);
                for (int j = 0; j < n2m._nodeData_list.size(); j ++){
                    TextView t = new TextView(mContext);
                    if (null != n2m._nodeData_list.get(j)._unit){
                        t.setText(""+n2m._nodeData_list.get(j)._data + n2m._nodeData_list.get(j)._unit);
                    } else {
                        t.setText("");
                    }
                    t.setSingleLine();
                    t.setGravity(Gravity.CENTER);
                    t.setEms(5);
                    t.setBackgroundColor(mContext.getResources().getColor(R.color.ssiot_title_yellow));
                    LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
                    row.addView(t,lp2);
                    View divider = new View(mContext);
                    divider.setLayoutParams(new LinearLayout.LayoutParams(1, 1));
                    row.addView(divider);
                }
            }
            rootLayout.addView(row, lp);
            View divider = new View(mContext);
            divider.setLayoutParams(new LinearLayout.LayoutParams(1, 1));
            rootLayout.addView(divider);
        }
        
        
    }
    
}