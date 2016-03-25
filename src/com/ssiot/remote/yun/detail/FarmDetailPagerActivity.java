
package com.ssiot.remote.yun.detail;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ssiot.remote.HeadActivity;
import com.ssiot.remote.R;
import com.ssiot.remote.yun.monitor.DeviceBean;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FarmDetailPagerActivity extends HeadActivity implements SwipeRefreshLayout.OnRefreshListener{
    private static final String tag = "FarmDetailPagerActivity";

    ViewPager pager;
    final List<DevicesFragment> fragments = new ArrayList(3);// DevicesFragment
    RadioGroup tabs;
    View indicator;
    RadioButton sensorsTab;
    RadioButton cntrolsTab;
    RadioButton webcamsTab;
    final ImplementationAdapter adapter = new ImplementationAdapter(getSupportFragmentManager());
    final DevicesFragment sensorsFragment = new SensorsFragment();
    final DevicesFragment cntrolsFragment = new CtrlersFragment();
    final DevicesFragment webcamsFragment = new WebcamsFragment();

    volatile transient long mLastRefreshedTimeMS = System.currentTimeMillis();
    private volatile transient AsyncTask<?, ?, ?> lastTask;
    int _OrgID;//组织的id，在此理解为设施id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_monitor_detail_pager);
        getSupportActionBar().setTitle("title");
        findViews();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        pager.removeCallbacks(adapter);
        pager.postDelayed(adapter, 30000L);
    }
    
    protected void onStart() {
      super.onStart();
      onRefresh();
    }

    private void findViews() {
        tabs = (RadioGroup) findViewById(R.id.tabs);
        sensorsTab = (RadioButton) findViewById(R.id.tcagri_farm_detail_tab_sensors);
        cntrolsTab = (RadioButton) findViewById(R.id.tcagri_farm_detail_tab_cntrols);
        webcamsTab = (RadioButton) findViewById(R.id.tcagri_farm_detail_tab_webcams);
        indicator = findViewById(R.id.indicator);
        pager = (ViewPager) findViewById(R.id.myViewPager);

        tabs.setOnCheckedChangeListener(adapter);
        pager.addOnPageChangeListener(adapter);
        pager.setAdapter(adapter);

        // findViewById(R.id.FrameLayoutWarn).setOnClickListener(this.adapter);
        // findViewById(R.id.toOldLayout).setOnClickListener(new
        // View.OnClickListener() {
        // public void onClick(View paramAnonymousView) {
        // startActivity(getIntent()
        // .setClass(FarmDetailPagerActivity.this, FarmDetailed.class));
        // finish();
        // }
        // });
    }
    
    @Override
    public void onRefresh() {
        Log.v(tag, "----onRefresh----fragSize:" + fragments.size());
      internalRefresh();
      Iterator localIterator = fragments.iterator();
      while (localIterator.hasNext()){
          ((DevicesFragment)localIterator.next()).setRefreshing(true);
      }
    }

    private final void internalRefresh() {// TODO Thread
        mLastRefreshedTimeMS = System.currentTimeMillis();
         if (this.lastTask != null){
         lastTask.cancel(true);
         }
         NetworkTask localNetworkTask = new NetworkTask();
         Integer[] arrayOfInteger = new Integer[1];
         arrayOfInteger[0] = Integer.valueOf(_OrgID);
         lastTask = localNetworkTask.execute(arrayOfInteger);
        mLastRefreshedTimeMS = System.currentTimeMillis();
    }

    private final class ImplementationAdapter extends FragmentPagerAdapter
            implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener,
            View.OnClickListener, Runnable {// PopupMenu.OnMenuItemClickListener
    // ImplementationAdapter() {
    // super();
    // }

        public ImplementationAdapter(FragmentManager fm) {
            super(fm);
        }

        private void updateOrgName(String paramString) {
            int i = paramString.lastIndexOf(' ');
            // FarmDetailPagerActivity.this._parentOrgName =
            // paramString.substring(0, i);
            // FarmDetailPagerActivity.this._orgName = paramString.substring(i +
            // 1);
            // FarmDetailPagerActivity.this.title.setText(FarmDetailPagerActivity.this._orgName);
        }

        public int getCount() {
            return fragments.size();
        }

        public DevicesFragment getItem(int paramInt) {
            return (DevicesFragment) fragments.get(paramInt);
        }

        public long getItemId(int paramInt) {
            return getItem(paramInt).getTabID();
        }

        @Override
        public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt) {
            for (int i = 0;; i++) {
                if (i >= fragments.size()) {
                    return;
                }
                if (((DevicesFragment) fragments.get(i)).getTabID() == paramInt) {
                    pager.setCurrentItem(i);
                }
            }
        }

        @Override
        public void onClick(View paramView) {
            if (paramView != null) {
                // switch (paramView.getId()) {
                // case R.id.FrameLayoutWarn:
                // Intent intent = new
                // Intent(FarmDetailPagerActivity.this.getBaseContext(),
                // WarningAct.class);
                // intent.putExtra("TITLE",
                // FarmDetailPagerActivity.this.getTitle().toString());
                // intent.putExtra("OrgID",
                // FarmDetailPagerActivity.this._OrgID);
                // FarmDetailPagerActivity.this.startActivity(intent);
                // break;
                // case R.id.textViewTitle:
                // navilist.dismiss();
                // navilist.setAdapter(FarmDetailPagerActivity.this.mFarmDataAdapter);
                // navilist.showAsDropDown(paramView);
                // break;
                // }
            }
        }

        // @Override
        // public void onItemClick(AdapterView<?> paramAdapterView, View
        // paramView, int paramInt, long paramLong)
        // {
        // Object localObject =
        // FarmDetailPagerActivity.this.mFarmDataAdapter.getItem(paramInt);
        // FarmDetailPagerActivity.this.navilist.dismiss();
        // FarmDetailPagerActivity.this._OrgID = localObject.hashCode();
        // updateOrgName(localObject.toString());
        // FarmDetailPagerActivity.this.onRefresh();
        // }
        //
        // @Override
        // public boolean onMenuItemClick(MenuItem paramMenuItem)
        // {
        // FarmDetailPagerActivity.this._OrgID = paramMenuItem.getItemId();
        // updateOrgName(paramMenuItem.getTitle().toString());
        // FarmDetailPagerActivity.this.onRefresh();
        // return false;
        // }

        @Override
        public void onPageScrollStateChanged(int paramInt) {
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (fragments.size() >= 1) {
                DevicesFragment localDevicesFragment = (DevicesFragment) fragments.get(position);
                View localView = tabs.findViewById(localDevicesFragment.getTabID());
                ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams) indicator
                        .getLayoutParams();
                localMarginLayoutParams.width = (localView.getRight() - localView.getLeft());
                localMarginLayoutParams.leftMargin = ((int) (positionOffset * localMarginLayoutParams.width) + localView
                        .getLeft());
                indicator.setLayoutParams(localMarginLayoutParams);
            }
        }

        @Override
        public void onPageSelected(int paramInt) {
            tabs.check((int) getItemId(paramInt));
        }

        @Override
        public void run() {
            long l = System.currentTimeMillis() - mLastRefreshedTimeMS;
            if (l > 30000L) {// 30秒自动刷新
                FarmDetailPagerActivity.this.internalRefresh();
                pager.removeCallbacks(this);
                pager.postDelayed(this, 30000L);
            } else {
                pager.removeCallbacks(this);
                pager.postDelayed(this, 30000L - l);
            }
        }

        final void updateIndicatorWidth() {
            int i = 0;
            if (sensorsTab.getVisibility() == View.VISIBLE) {
                i = sensorsTab.getMeasuredWidth();
            } else if (cntrolsTab.getVisibility() == View.VISIBLE) {
                i = cntrolsTab.getMeasuredWidth();
            } else if (webcamsTab.getVisibility() == ViewGroup.VISIBLE) {
                i = webcamsTab.getMeasuredWidth();
            }
            ViewGroup.LayoutParams localLayoutParams = indicator.getLayoutParams();
            localLayoutParams.width = i;
            indicator.setLayoutParams(localLayoutParams);
        }

    }

    private final class NetworkTask extends AsyncTask<Integer, DeviceBean, JSONArray> {
        private final String tag = "地块详情网络数据";

        NetworkTask() {
        }

        @Override
        protected JSONArray doInBackground(Integer[] paramArrayOfInteger) {
            // paramArrayOfInteger 存储 设施id
            // 通过id 查询webservice 解析json return jsonarray，中途可以updateProgress DeviceBean
            return null;
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Log.w("地块详情", "更新被取消！");
            sensorsFragment.totalDevices();
            cntrolsFragment.totalDevices();
            webcamsFragment.totalDevices();
            adapter.notifyDataSetChanged();
        }

        @Override
        protected void onPostExecute(JSONArray paramJSONArray) {// 执行完毕了，in UI线程
            Log.v(tag, "-------onPostExecute---------paramJSONArray:" + paramJSONArray);
            // 控制fragment的个数 两页还是3页 visibility， tab的个数
            // fragments的add contains remove

            if (!fragments.contains(sensorsFragment)) {
                sensorsTab.setVisibility(View.VISIBLE);
                fragments.add(sensorsFragment);
            }
            if (!fragments.contains(cntrolsFragment)) {
                cntrolsTab.setVisibility(View.VISIBLE);
                fragments.add(cntrolsFragment);
            }
            if (!fragments.contains(webcamsFragment)) {
                webcamsTab.setVisibility(View.VISIBLE);
                fragments.add(webcamsFragment);
            }
            adapter.notifyDataSetChanged();
            // indicator的更新
        }

        @Override
        protected void onProgressUpdate(DeviceBean[] devices) {
            super.onProgressUpdate(devices);
            if (devices == null) {
                return;
            }
            int i = devices.length;
            for (int j = 0; j < i; j++) {
                DeviceBean localDevice = devices[j];
                if (null != localDevice) {
                    if (localDevice.isSensorDevice()) {
                        sensorsFragment.add(localDevice);
                    } else if (localDevice.isCntrolDevice()) {
                        cntrolsFragment.add(localDevice);
                    } else if (localDevice.isWebcamDevice()) {
                        webcamsFragment.add(localDevice);
                    }
                }
            }
        }

    }
}
