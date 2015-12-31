package com.ssiot.remote;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ExpertFragment extends Fragment{
    public static final String tag = "ExpertFragment";
    private FExpertBtnClickListener mFExpertBtnClickListener;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFExpertBtnClickListener = (FExpertBtnClickListener) getActivity();
        setHasOptionsMenu(true);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_expert, container, false);
        TextView fishView = (TextView) v.findViewById(R.id.diagnose_fish);
        fishView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mFExpertBtnClickListener){
                    mFExpertBtnClickListener.onFExpertBtnClick();
                }
            }
        });
        return v;
    }
    
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.menu_expert, menu);
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
    
    public void setClickListener(FExpertBtnClickListener listen){
        mFExpertBtnClickListener = listen;
    }
    
    //回调接口，留给activity使用
    public interface FExpertBtnClickListener {  
        void onFExpertBtnClick();  
    }
}