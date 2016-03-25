
package com.ssiot.remote.yun.detail;

import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssiot.remote.R;
import com.ssiot.remote.yun.monitor.DeviceBean;

abstract class DevicesFragment extends Fragment {// TODO
    private static final String tag = "DevicesFragment";
    private SwipeRefreshLayout refresh;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        refresh = (SwipeRefreshLayout) view.findViewById(R.id.refresh);
        if (refresh == null) {
            Log.e(tag, "!!!!!!!onViewCreated--------SwipeRefreshLayout = null");
            refresh = new SwipeRefreshLayout(getActivity());
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    abstract int getTabID();
    abstract void add(@NonNull DeviceBean paramDevice);
    abstract int totalDevices();

    static final boolean isUIThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public final void setRefreshing(boolean paramBoolean) {
        if (refresh != null) {
            refresh.setRefreshing(paramBoolean);
        } else {
            Log.e(tag, "!!!!!!!--------SwipeRefreshLayout = null");
        }
    }
}
