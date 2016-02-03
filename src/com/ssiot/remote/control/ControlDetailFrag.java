package com.ssiot.remote.control;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.ssiot.remote.BaseFragment;
import com.ssiot.remote.R;
import com.ssiot.remote.data.AjaxGetNodesDataByUserkey;
import com.ssiot.remote.data.model.view.ControlDeviceView3Model;

import java.util.ArrayList;
import java.util.List;

public class ControlDetailFrag extends BaseFragment{
    private static final String tag = "ControlDetailFrag";
    private String userkey;
    private String controlnodeuniqueid;
    private String controlnodeid;
    private String controlnodename;
    
    private ListView mListView;
    private List<ControlDeviceView3Model> listDatas = new ArrayList<ControlDeviceView3Model>();
    private DeviceAdapter mAdapter;
    
    private static final int MSG_GET_CONTROLDETAIL_END = 0;
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case MSG_GET_CONTROLDETAIL_END:
                    if (null != listDatas){
                        mAdapter.notifyDataSetChanged();
                    }
                    break;

                default:
                    break;
            }
        }
    };
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Bundle b = getArguments();
        if (null != b){
            userkey = b.getString("userkey");
            controlnodeuniqueid = b.getString("controlnodeuniqueid");
            controlnodeid = b.getString("controlnodeid");
            controlnodename = b.getString("controlnodename");
        } else {
            Log.e(tag, "----!!!! getArguments = null");
        }
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_ctr_detail, container, false);
        initTitleBar(v);
        mListView = (ListView) v.findViewById(R.id.controllerlist);
        mAdapter = new DeviceAdapter(getActivity(), listDatas);
        mListView.setAdapter(mAdapter);
        new GetControlActionInfoThread().start();
        return v;
    }
    
    private void initTitleBar(View rootView){
        TextView mTitleView = (TextView) rootView.findViewById(R.id.moni_title);
        ImageView mOnlineView = (ImageView) rootView.findViewById(R.id.moni_status);
        ImageView mNetTypeView = (ImageView) rootView.findViewById(R.id.moni_net_type);
        mTitleView.setText(controlnodename);
        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) mOnlineView.getLayoutParams();
        rlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mOnlineView.setLayoutParams(rlp);
        mNetTypeView.setVisibility(View.GONE);
    }
    
    public class GetControlActionInfoThread extends Thread{
        @Override
        public void run() {
            sendShowMyDlg("");
            List<ControlDeviceView3Model> models = new AjaxGetNodesDataByUserkey().GetDeviceActionInfo(controlnodeid, controlnodeuniqueid);
            listDatas.clear();
            listDatas.addAll(models);
            Log.v(tag, "----GetControlActionInfoThread----"+controlnodeid +controlnodeuniqueid +" size:" + listDatas.size());
            sendDismissDlg();
            mHandler.sendEmptyMessage(MSG_GET_CONTROLDETAIL_END);
        }
    }
    
    private class DeviceAdapter extends BaseAdapter{
        private List<ControlDeviceView3Model> devices;
        private LayoutInflater mInflater;
        public DeviceAdapter(Context c, List<ControlDeviceView3Model> des){
            devices = des;
            mInflater = LayoutInflater.from(c);
        }
        
        @Override
        public int getCount() {
            return devices.size();
        }

        @Override
        public Object getItem(int position) {
            return devices.get(position);
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
                convertView = mInflater.inflate(R.layout.ctr_device_itm, null);
                holder.device_name = (TextView) convertView.findViewById(R.id.device_name);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            final ControlDeviceView3Model m = devices.get(position);
            holder.device_name.setText(m.DeviceName);
            return convertView;
        }
        
        private class ViewHolder{
            TextView device_name;
        }
        
    }
}