package com.ssiot.remote.monitor;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.ssiot.remote.BaseFragment;
import com.ssiot.remote.MainActivity;
import com.ssiot.remote.MyCache;
import com.ssiot.remote.R;
import com.ssiot.remote.data.AjaxGetNodesDataByUserkey;
import com.ssiot.remote.data.model.view.NodeView2Model;
import java.lang.reflect.Field;
import java.util.List;

//2016新设计，只有data和chart
//copy from MoniDetailHolderfrag
public class MoniDataAndChartFrag extends BaseFragment{
    public static final String tag = "MoniDataAndChartFragment";
    private FMoniDataAndChartBtnClickListener mFMoniDataAndChartBtnClickListener;
    private FragmentManager moniChildFragmentManager;
    RadioGroup mRadiogroup;
    private String mTitleText;
    private boolean mStatus;
    private boolean mNetType;
    Bundle mBundle;
    
    TextView mTitleView;
    ImageView mOnlineView;
    ImageView mNetTypeView;
    ListView tableList;
    List<NodeView2Model> mListData;
    DataTableAdapter mAdapter;
//    private Bundle mBundle;
    private int nodeno = -1;
    private String grainSize = "十分钟";
    private String[] grainList = {"十分钟","小时","天","月","年"};
    
    private static final int MSG_GET_END = 0;
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case MSG_GET_END:
                    if (null != mListData){//
                        mAdapter = new DataTableAdapter(getParentFragment().getActivity(), mListData);
                        tableList.setAdapter(mAdapter);
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
        setHasOptionsMenu(true);
        mBundle = getArguments();
        if (mBundle != null){
            nodeno = mBundle.getInt("nodeno", -1);
            mTitleText = mBundle.getString("nodetitle");
            mStatus = mBundle.getBoolean("status", false);
            mNetType = mBundle.getBoolean("isgprs", false);
            Log.e(tag, "----onCreate----getArguments = nodetitle:"+mTitleText);
        } else {
            Log.e(tag, "----onCreate----getArguments = null");
        }
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_moni_data_chart, container, false);
        moniChildFragmentManager = getChildFragmentManager();
        mRadiogroup = (RadioGroup) v.findViewById(R.id.rg_data_chart);
        mRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {  
            @Override  
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //TODO
                Log.v(tag, "----onCheckChanged----" + checkedId);
                if (checkedId == R.id.radio_data){
                    
                } else {
                    
                }
//                FragmentTransaction transaction = moniChildFragmentManager.beginTransaction();
//                Fragment fragment = getInstanceByIndex(checkedId);
//                transaction.replace(R.id.moni_detail_holder_content, fragment);
//                transaction.commit();
            }
        });
        mRadiogroup.check(R.id.radio_data);
        
        mTitleView = (TextView) v.findViewById(R.id.moni_title);
        mOnlineView = (ImageView) v.findViewById(R.id.moni_status);
        mNetTypeView = (ImageView) v.findViewById(R.id.moni_net_type);
        tableList = (ListView) v.findViewById(R.id.table_list);
        initTitleBar();
        SeekBar sb = (SeekBar) v.findViewById(R.id.moni_time_checker);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                grainSize = grainList[progress];
                new GetMoniDataThread().start();
            }
        });
        new GetMoniDataThread().start();
        return v;
    }
    
    private void initTitleBar(){
        mTitleView.setText(mBundle.getString("nodetitle"));
        mOnlineView.setImageResource(mBundle.getBoolean("status", false) ? R.drawable.online : R.drawable.offline);
        mNetTypeView.setImageResource(mBundle.getBoolean("isgprs", false) ? R.drawable.connect_gprs : R.drawable.connect_zigbee);
        Log.v(tag, "-----odetitle:"+mBundle.getString("nodetitle"));
    }
    
    private class GetMoniDataThread extends Thread{
        @Override
        public void run() {
            sendShowMyDlg("正在查询");
            if (nodeno >= 0){
                List<NodeView2Model> nList = new AjaxGetNodesDataByUserkey().GetNodesDataByUserkeyAndType(MainActivity.mUniqueID, ""+nodeno, grainSize);

                mListData = nList;
//                Log.v(tag, "------------size:"+nList.size());
//                if (null != nList){
//                    for (int i = 0; i < nList.size(); i ++){
//                        String str = "";
//                        str += nList.get(i)._updatetime + ":::::";
//                        for (int j = 0; j < nList.get(i)._nodeData_list.size(); j ++){
//                            str += nList.get(i)._nodeData_list.get(j)._name + " " +  nList.get(i)._nodeData_list.get(j)._data +" ";
//                        }
//                        Log.v(tag, str);
//                    }
//                }
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
        MainActivity ma = (MainActivity) getParentFragment().getActivity();
        MyCache cache = ma.getCaheManager();
        cache.put("monidata_list", mListData);
    }
    
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.monidetail_holder, menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }
    
    public void setClickListener(FMoniDataAndChartBtnClickListener listen){
        mFMoniDataAndChartBtnClickListener = listen;
    }
    
    public interface FMoniDataAndChartBtnClickListener {  
        void onFMoniDataAndChartBtnClick();  
    }
    
    private class DataTableAdapter extends BaseAdapter {

        private LayoutInflater mInflater;
        private Context context;

        List<NodeView2Model> mData;

        public DataTableAdapter(Context c, List<NodeView2Model> d) {
            mData = d;
            context = c;
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            if (mData.size() == 0) {// 没有值就不显示标题，否则在buildHeaderView会空指针
                return 0;
            }
            return mData.size() + 1;
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (0 == position) {
                convertView = buildHeaderView(mData.get(0));
            } else {
                convertView = buildView(mData.get(position - 1));
            }
            return convertView;
        }

        private View buildView(NodeView2Model n2m) {
            long time1 = SystemClock.uptimeMillis();
            LinearLayout rootLayout = new LinearLayout(context);// 在xml中固定了listview的高度后就没重复调用了
            rootLayout.setOrientation(LinearLayout.HORIZONTAL);
            TextView timeText = new TextView(context);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            timeText.setText("" + n2m._detailTime);
            timeText.setEms(5);
            timeText.setGravity(Gravity.CENTER);
            timeText.setMaxLines(2);
            timeText.setBackgroundColor(getResources().getColor(R.color.ssiot_title_yellow));
            rootLayout.addView(timeText, lp);

            View dividerView = new View(context);
            LinearLayout.LayoutParams lpdivider = new LinearLayout.LayoutParams(1,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            rootLayout.addView(dividerView, lpdivider);

            // View leftView = timeText;
            for (int j = 0; j < n2m._nodeData_list.size(); j++) {
                TextView t = new TextView(context);
                if (null != n2m._nodeData_list.get(j)._unit) {
                    t.setText("" + n2m._nodeData_list.get(j)._data
                            + n2m._nodeData_list.get(j)._unit);
                } else {
                    t.setText("");
                }
                t.setSingleLine();
                t.setGravity(Gravity.CENTER);
                // t.setMaxEms(5);
                // t.setMinEms(5);
                t.setEms(5);
                // t.setPadding(0, 10, 0, 10);
                t.setBackgroundColor(getResources().getColor(R.color.ssiot_title_yellow));
                LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                // lp2.leftMargin = 10;
                // lp2.rightMargin = 10;
                rootLayout.addView(t, lp2);
                // leftView = t;
            }
            // Log.v(tag, "----cost time:" +
            // (SystemClock.uptimeMillis()-time1));
            return rootLayout;
        }

        private View buildHeaderView(NodeView2Model n2m) {
            LinearLayout rootLayout = new LinearLayout(context);// 在xml中固定了listview的高度后就没重复调用了
                                                                // 解决了一个bug
            rootLayout.setOrientation(LinearLayout.HORIZONTAL);

            TextView timeText = new TextView(context);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            timeText.setText("时间");
            timeText.setGravity(Gravity.CENTER);
            timeText.setEms(5);
            timeText.setBackgroundColor(getResources().getColor(R.color.datalist_green));
            rootLayout.addView(timeText, lp);

            // View leftView = timeText;
            for (int j = 0; j < n2m._nodeData_list.size(); j++) {
                TextView t = new TextView(context);
                t.setText(n2m._nodeData_list.get(j)._name);
                t.setSingleLine();
                t.setMaxEms(5);
                t.setMinEms(5);
                t.setGravity(Gravity.CENTER);
                t.setBackgroundColor(getResources().getColor(R.color.datalist_header));
                LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                // lp2.leftMargin = 10;
                // lp2.rightMargin = 10;
                rootLayout.addView(t, lp2);
                // leftView = t;
            }
            return rootLayout;
        }

    }
}