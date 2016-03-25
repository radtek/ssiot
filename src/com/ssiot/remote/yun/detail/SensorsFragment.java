package com.ssiot.remote.yun.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssiot.remote.R;
import com.ssiot.remote.yun.monitor.DeviceBean;

public class SensorsFragment extends DevicesFragment{
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_farm_monitor_detail_sensors_fragment, container, false);
    }

    @Override
    int getTabID() {
        return R.id.tcagri_farm_detail_tab_sensors;
    }

    @Override
    void add(@NonNull DeviceBean paramDevice) {
//        try
//        {
//            if (paramDevice.isGroupDevice()) {
//                this.groupedSensorsArray.addAsync(paramDevice);
//                return;
//            }
//            if (paramDevice.isOffline()) {
//                this.offlineSensorsArray.addAsync(paramDevice);
//                continue;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//        }
//        if (paramDevice.isWarning()) {
//            this.warningSensorsArray.addAsync(paramDevice);
//        } else {
//            this.workingSensorsArray.addAsync(paramDevice);
//        }
    }

    @Override
    int totalDevices() {
//        if (isUIThread()) {
//          this.warningSensorsArray.notifyDataSetChanged();
//          this.offlineSensorsArray.notifyDataSetChanged();
//          this.groupedSensorsArray.notifyDataSetChanged();
//          this.workingSensorsArray.notifyDataSetChanged();
//        }
//        return this.warningSensorsArray.getCount() + this.offlineSensorsArray.getCount() + this.groupedSensorsArray.getCount() + this.workingSensorsArray.getCount();
        return 0;
    }
}