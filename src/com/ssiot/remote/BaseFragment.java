package com.ssiot.remote;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class BaseFragment extends Fragment{
    Dialog mDialog = null;
    
    private static final int MSG_SHOW_DLG = 104;
    private static final int MSG_DISMISS_DLG = 105;
    private Handler baseHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case MSG_SHOW_DLG:
                    showMyDlg((String) msg.obj);
                    break;
                case MSG_DISMISS_DLG:
                    dismissMyDialog();
                    break;

                default:
                    break;
            }
        };
    };
    
    public boolean canGoback(){
        return false;
    }
    
    public void onMyBackPressed(){
        
    }
    
    private void showMyDlg(String msg){
        if (null != mDialog && mDialog.isShowing()){//防止多个dialog显示出来？
            mDialog.dismiss();
        }
        mDialog = Utils.createLoadingDialog(getMyActivity(), msg);
        mDialog.show();
    }
    
    public void sendShowMyDlg(String msg){
        Message m = baseHandler.obtainMessage(MSG_SHOW_DLG);
        m.obj = msg;
        baseHandler.sendMessage(m);
    }
    
    private void dismissMyDialog(){
        if (null != mDialog && mDialog.isShowing()){
            mDialog.dismiss();
        }
    }
    
    public void sendDismissDlg(){
        baseHandler.sendEmptyMessage(MSG_DISMISS_DLG);
    }
    
    @SuppressLint("NewApi")
    public void showRefreshAnimation(MenuItem item,View uibase) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
            final MenuItem refreshItem = item;
            hideRefreshAnimation(refreshItem);
            ImageView refreshActionView = (ImageView) getActivity().getLayoutInflater().inflate(R.layout.action_refreshing, null);
            refreshActionView.setImageResource(R.drawable.ic_action_refresh);
            refreshItem.setActionView(null);
            refreshItem.setActionView(refreshActionView);
            Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.loading_animation);
            animation.setRepeatMode(Animation.RESTART);
            animation.setRepeatCount(Animation.INFINITE);
            refreshActionView.startAnimation(animation);
            uibase.postDelayed(new Runnable() {
                @Override
                public void run() {
                    hideRefreshAnimation(refreshItem);
                }
            }, 800);
        }
    }
    
    @SuppressLint("NewApi")
    private void hideRefreshAnimation(MenuItem refreshItem) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
            if (refreshItem != null) {
                View view = refreshItem.getActionView();
                if (view != null) {
                    view.clearAnimation();
                    refreshItem.setActionView(null);
                }
            }
        }
    }
    
    private FragmentActivity getMyActivity(){//Fragmnet未知的BUG？？？
        if (super.getActivity() == null){
            if (getParentFragment() != null){
                return getParentFragment().getActivity();
            }
        } else {
            return getActivity();
        }
        return null;
    }
}