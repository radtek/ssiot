package com.ssiot.remote.yun.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssiot.remote.R;
import com.ssiot.remote.yun.monitor.DeviceBean;

public class WebcamsFragment extends DevicesFragment{
    
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
      return paramLayoutInflater.inflate(R.layout.activity_farm_monitor_detail_webcams_fragment, paramViewGroup, false);
    }

    @Override
    int getTabID() {
        return R.id.tcagri_farm_detail_tab_webcams;
    }

    @Override
    void add(@NonNull DeviceBean paramDevice) {
//        if (paramDevice.isCameraDevice()) {
//            this.cameraAdapter.addAsync(paramDevice);
//        } else {
//            this.webcamAdapter.addAsync(paramDevice);
//        }
    }

    @Override
    int totalDevices() {
//        return this.cameraAdapter.getCount() + this.webcamAdapter.getCount();
        return 0;
    }
    
}