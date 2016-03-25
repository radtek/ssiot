package com.ssiot.remote.yun.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssiot.remote.R;
import com.ssiot.remote.yun.monitor.DeviceBean;

public class CtrlersFragment extends DevicesFragment{
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(R.layout.activity_farm_monitor_detail_webcams_fragment, paramViewGroup, false);//TODO 暂时layout
    }

    @Override
    int getTabID() {
        return R.id.tcagri_farm_detail_tab_cntrols;
    }

    @Override
    void add(@NonNull DeviceBean paramDevice) {
//        if (paramDevice.isSensorDevice())
//            if (!paramDevice.isGroupDevice());
//          while (true)
//          {
//            return;
//            this.allSensorDevices.add(paramDevice);
//            continue;
//            if (paramDevice.isGroupDevice())
//              this.groupedAdapter.add(paramDevice);
//            else
//              this.adapter.add(paramDevice);
//          }
    }

    @Override
    int totalDevices() {
//        int i = this.groupedAdapter.getCount();
//        Iterator localIterator = this.devices.iterator();
//        while (true)
//        {
//          if (!localIterator.hasNext())
//            return i;
//          i += ((CntrolDeviceAdapter)localIterator.next()).getCount();
//        }
        return 0;
    }
    
}