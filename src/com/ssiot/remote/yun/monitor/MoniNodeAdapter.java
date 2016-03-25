package com.ssiot.remote.yun.monitor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ssiot.remote.BrowserActivity;
import com.ssiot.remote.R;
import com.ssiot.remote.yun.detail.FarmDetailPagerActivity;

import java.util.List;
import java.util.zip.Inflater;

//注意list嵌套list的问题！！！ 这是一个特殊的adapter，以node为item。地块和设施都是item中的标题
public class MoniNodeAdapter extends RecyclerView.Adapter{
    private static final String tag = "MoniNodeAdapter";
    private List<YunNodeModel> list;
    private Context mContext;
    private LayoutInflater mInflater;
    private Resources mResources;
    View deviceView;
    ImageView deviceImageView;

    public MoniNodeAdapter(Context c,List<YunNodeModel> lis){
        list = lis;
        mContext = c;
        mInflater = LayoutInflater.from(mContext);
        mResources = mContext.getResources();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int arg1) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.node_item_yun3, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        YunNodeModel model = list.get(i);
        long time1 = System.currentTimeMillis();
        for (int j = 0; j < i; j ++){
            if (list.get(j).mLandID == model.mLandID){
                model.landVis = false;
            }
            if (list.get(j).mFacilityID == model.mFacilityID){
                model.facilityVis = false;
                break;
            }
        }
        Log.v(tag, "------count visible cost time" + i + "  " + (System.currentTimeMillis()-time1));
        
        holder.fillData(model);
        
    }
    
    
    protected class MyViewHolder extends RecyclerView.ViewHolder implements OnClickListener{
        private TextView mLandView;
        private TextView mFacilityView;
        private TextView mNodeTitleView;
        private LinearLayout mIconLayout;
        YunNodeModel mModel;
        public MyViewHolder(View v) {
            super(v);
            mLandView = (TextView) v.findViewById(R.id.land_text);
            mFacilityView = (TextView) v.findViewById(R.id.facility_text);
            mNodeTitleView = (TextView) v.findViewById(R.id.node_title);
            mIconLayout = (LinearLayout) v.findViewById(R.id.monitorLinearLayout);
            v.setOnClickListener(this);
            mIconLayout.setOnClickListener(this);//ScrollView click的分配？？TODO in a better way
        }

        public void fillData(YunNodeModel model){
            mModel = model;
            if (model.landVis){
                mLandView.setVisibility(View.VISIBLE);
                mLandView.setText(model.landStr);
            } else {
                mLandView.setVisibility(View.GONE);
            }
            if (model.facilityVis){
                mFacilityView.setVisibility(View.VISIBLE);
                mFacilityView.setText(model.facilityStr);
            } else {
                mFacilityView.setVisibility(View.GONE);
            }
            
            mNodeTitleView.setText(model.nodeStr);
            mIconLayout.removeAllViews();
            if (null != model.list){
                for (int i = 0; i < model.list.size(); i ++){
                    DeviceBean d = (DeviceBean) model.list.get(i);
                    View localdeviceView = setImgBgState(d, DeviceBean.getIconRes(d.mType, d.mDeviceTypeNo));//TODO TODO
                    mIconLayout.addView(localdeviceView);
                }
            }
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, FarmDetailPagerActivity.class);
            intent.putExtra("yunnodemodel", mModel);
            mContext.startActivity(intent);
        }
    }
    
    @SuppressLint({"InflateParams"})
    private View setImgBgState(DeviceBean paramDevice, @DrawableRes int paramInt1) {
      this.deviceView = mInflater.inflate(R.layout.monitor_list_device_item, null);
      this.deviceImageView = ((ImageView)this.deviceView.findViewById(R.id.imageViewPho));
      this.deviceImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      if (paramDevice.getContactStatus() == 1){
        if ((paramDevice.getRunStatus() == 6) || (paramDevice.getRunStatus() == 3) || (paramDevice.getRunStatus() == 8)) {
          this.deviceImageView.setBackgroundResource(R.drawable.icbg_device_warning_actived);
          this.deviceImageView.setImageDrawable(new TintedBitmapDrawable(this.mResources, paramInt1, R.color.white));
        } else {
            this.deviceImageView.setBackgroundResource(R.drawable.icbg_device_connect_actived);
            this.deviceImageView.setImageDrawable(new TintedBitmapDrawable(this.mResources, paramInt1, R.color.device_connect_actived));
        }
      } else {
          this.deviceImageView.setBackgroundResource(R.drawable.icbg_device_offline_actived);
          this.deviceImageView.setImageDrawable(new TintedBitmapDrawable(this.mResources, paramInt1, R.color.white));
      }
      ((TextView) deviceView.findViewById(R.id.deviceName)).setText(paramDevice.mName);
      return this.deviceView;
    }
}