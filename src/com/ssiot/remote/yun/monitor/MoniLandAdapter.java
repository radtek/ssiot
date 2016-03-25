package com.ssiot.remote.yun.monitor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.ssiot.remote.BrowserActivity;
import com.ssiot.remote.R;

import java.util.List;

//注意list嵌套list的问题！！！
public class MoniLandAdapter extends RecyclerView.Adapter{
    private List<FarmModel> list;
    private Context mContext;

    public MoniLandAdapter(Context c,List<FarmModel> lis){
        list = lis;
        mContext = c;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int arg1) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.farm_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        FarmModel fishpondModel = list.get(i);
        holder.fillData(fishpondModel);
    }
    
    
    protected class MyViewHolder extends RecyclerView.ViewHolder implements OnClickListener{
        private TextView mTitleView;
        private TextView mContentView;
        FarmModel mModel;
        public MyViewHolder(View v) {
            super(v);
            mTitleView = (TextView) v.findViewById(R.id.txt_title);
            mContentView = (TextView) v.findViewById(R.id.txt_content);
            v.setOnClickListener(this);
        }

        public void fillData(FarmModel model){
            mModel = model;
            mTitleView.setText(model._name);
            mContentView.setText(model._detail);
            
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, BrowserActivity.class);
            intent.putExtra("company", mModel);
            mContext.startActivity(intent);
        }
    }
}