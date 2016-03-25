package com.ssiot.remote.yun.monitor;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ssiot.remote.BrowserActivity;
import com.ssiot.remote.HeadActivity;
import com.ssiot.remote.R;

import java.util.ArrayList;
import java.util.List;

public class MonitorAct extends HeadActivity{
    private static final String tag = "MonitorAct";
    ImageView homeView;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    List<YunNodeModel> mDatas = new ArrayList<YunNodeModel>();
    
    private static final int MSG_GET_END = 1;
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case MSG_GET_END:
                    mAdapter.notifyDataSetChanged();
                    swipeRefreshLayout.setRefreshing(false);
                    break;

                default:
                    break;
            }
        };
    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_farm);
        
        findViews();
    }
    
    private void findViews(){
        homeView = (ImageView) findViewById(R.id.imageViewMore);
        homeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                home();
            }
        });
        
        initList();
    }
    
    private void initList(){
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipelist_layout);
        mRecyclerView = ((RecyclerView)LayoutInflater.from(this).inflate(R.layout.vertical_recycler_view, null));
        Log.v(tag, "-----inflate mRecyclerView ok--");
        swipeRefreshLayout.addView(mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager bLinearLayoutManager = new LinearLayoutManager(this);
        bLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(bLinearLayoutManager);
//        mRecyclerView.addItemDecoration(new ItemDivider(CompanyListActivity.this, R.drawable.myshape));
        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
    
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new GetYunFarmThread().start();
            }
        });
        mAdapter = new MoniNodeAdapter(this,mDatas);
        mRecyclerView.setAdapter(mAdapter);

        new GetYunFarmThread().start();
    }
    
    private class GetYunFarmThread extends Thread{
        @Override
        public void run() {
//            List<FarmModel> list = new IOTCompany().GetModelList(" 1=1");
//            if (null != list && list.size() > 0){
//                mDatas.clear();
//                mDatas.addAll(list);
//            }
            mDatas.clear();//TODO test
//            for (int i = 0;i < 8 ;i ++){
//                mDatas.add(new YunNodeModel(DeviceBean.TYPE_SENSOR, 21,"地块1", 44,"设施1", 33,"节点名称"));
//            }
//            List<Integer> landVisiblePositions = new ArrayList<Integer>();
//            landVisiblePositions.set
            mDatas.add(new YunNodeModel(DeviceBean.TYPE_SENSOR, 21,"地块1", 101,"设施1", 3001,"节点名称3001"));
            mDatas.add(new YunNodeModel(DeviceBean.TYPE_SENSOR, 21,"地块1", 101,"设施1", 3002,"节点名称3002"));
            mDatas.add(new YunNodeModel(DeviceBean.TYPE_ACTUATOR, 21,"地块1", 101,"设施1", 3801,"控制节点"));
            mDatas.add(new YunNodeModel(DeviceBean.TYPE_CAMERA, 21,"地块1", 101,"设施1", 3901,"视频节点"));
            mDatas.add(new YunNodeModel(DeviceBean.TYPE_SENSOR, 21,"地块1", 102,"设施2", 3101,"节点名称3101"));
            mDatas.add(new YunNodeModel(DeviceBean.TYPE_SENSOR, 21,"地块1", 102,"设施2", 3102,"节点名称3102"));
            mDatas.add(new YunNodeModel(DeviceBean.TYPE_SENSOR, 22,"地块2", 103,"设施3", 3201,"节点名称3201"));
            mDatas.add(new YunNodeModel(DeviceBean.TYPE_SENSOR, 22,"地块2", 103,"设施3", 3202,"节点名称3202"));
            mDatas.add(new YunNodeModel(DeviceBean.TYPE_SENSOR, 22,"地块2", 106,"设施4", 3609,"节点名称3609"));
            mHandler.sendEmptyMessage(MSG_GET_END);
        }
    }
    
}