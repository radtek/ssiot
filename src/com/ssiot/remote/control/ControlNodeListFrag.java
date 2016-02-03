package com.ssiot.remote.control;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.ssiot.remote.BaseFragment;
import com.ssiot.remote.GetImageThread;
import com.ssiot.remote.R;
import com.ssiot.remote.Utils;
import com.ssiot.remote.data.AjaxGetNodesDataByUserkey;
import com.ssiot.remote.data.model.view.ControlNodeViewModel;
import com.ssiot.remote.control.ControlListAdapter;
import com.ssiot.remote.control.ControlListAdapter.ControlDetailListener;

import java.util.ArrayList;
import java.util.List;

public class ControlNodeListFrag extends BaseFragment{
    public static final String tag = "ControlNodeListFrag";
    private FControlNodeListBtnClickListener mFControlNodeListBtnClickListener;
    private ControlDetailListener mCtrDetailListener;
    private String userKey = "";
    List<ControlNodeViewModel> mNodes = new ArrayList<ControlNodeViewModel>();
    ListView mNodeListView;
    ControlListAdapter mNodeAdapter;
    
    private static final int MSG_GETNODES_END = 1;
    public static final int MSG_GET_ONEIMAGE_END = 2;
    private static final int MSG_REFRESH = 3;
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            if (!isVisible()){
                Log.e(tag, "----fragment is not visible----!!!!");
                return;
            }
            Log.v(tag, "---handleMessage----" + msg.what + " " + mNodes.size());
            switch (msg.what) {
                case MSG_GETNODES_END:
                    if (null != mNodes && mNodes.size() > 0 && null != mNodeAdapter){
                        Log.v(tag, "----------refresh node list");
                        
                        mNodeAdapter = new ControlListAdapter(getActivity(), mNodes,mCtrDetailListener,mHandler);
                        mNodeListView.setAdapter(mNodeAdapter);
                        mNodeAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(getParentFragment().getActivity(), "节点数量" + mNodes.size(), Toast.LENGTH_SHORT).show();
                        Log.e(tag, "----------MSG_GETNODES_END-error!!!!!!!!!!!!!!");
                    }
                    break;
                case MSG_GET_ONEIMAGE_END:
//                    mNodeAdapter.notifyDataSetChanged();//不能notify，会无限循环
                    GetImageThread.ThumnailHolder thumb = (GetImageThread.ThumnailHolder) msg.obj;
                    thumb.imageView.setImageBitmap(thumb.bitmap);
                    break;
                case MSG_REFRESH:
                    new GetCtrNodeThread().start();
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
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_control_list, container, false);
        if (TextUtils.isEmpty(userKey)){
            Toast.makeText(getActivity(), "未获取到key", Toast.LENGTH_SHORT).show();
        }
        if (!Utils.isNetworkConnected(getActivity())){
            Toast.makeText(getActivity(), R.string.please_check_net, Toast.LENGTH_SHORT).show();
        }
        mNodeListView = (ListView) v.findViewById(R.id.control_list);
        mNodeAdapter = new ControlListAdapter(getActivity(), mNodes,null,mHandler);
        mNodeListView.setAdapter(mNodeAdapter);
        new GetCtrNodeThread().start();
        return v;
    }
    
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_control, menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_control_refresh:
                if (!Utils.isNetworkConnected(getActivity())){
                    Toast.makeText(getActivity(), R.string.please_check_net, Toast.LENGTH_LONG).show();
                } else {
                    showRefreshAnimation(item,mNodeListView);
                    mHandler.sendEmptyMessage(MSG_REFRESH);
                }
                break;

            default:
                break;
        }
        return true;
    }
    
    @Override
    public void onDestroyView() {
        Log.v(tag, "----onDestroyView----");
        mHandler.removeMessages(MSG_GETNODES_END);
        mHandler.removeMessages(MSG_GET_ONEIMAGE_END);
        super.onDestroyView();
    };
    
    public void onMyBackPressed(){//add by jingbo
    }
    
    public void setCtrDetailListener(ControlDetailListener lis){
        mCtrDetailListener = lis;
    }
    
    public void setClickListener(FControlNodeListBtnClickListener listen){
        mFControlNodeListBtnClickListener = listen;
    }
    
    //回调接口，留给activity使用
    public interface FControlNodeListBtnClickListener {  
        void onFControlNodeListBtnClick(int position);  
    }
    
    private class GetCtrNodeThread extends Thread{
        @Override
        public void run() {
            sendShowMyDlg("正在查询");
            mNodes = new AjaxGetNodesDataByUserkey().GetControlNodesByUserkey(userKey);
            sendDismissDlg();
            mHandler.sendEmptyMessage(MSG_GETNODES_END);
        }
    }
}