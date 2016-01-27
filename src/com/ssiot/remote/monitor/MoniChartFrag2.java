package com.ssiot.remote.monitor;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.ssiot.remote.data.AjaxGetNodesDataByUserkey;
import com.ssiot.remote.data.DbHelperSQL;
import com.ssiot.remote.data.model.view.NodeView2Model;
import com.ssiot.remote.BaseFragment;
import com.ssiot.remote.MainActivity;
import com.ssiot.remote.R;
import com.ssiot.remote.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lecho.lib.hellocharts.listener.LineChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;

public class MoniChartFrag2 extends BaseFragment{
    private static final String tag = "MoniChartFrag2";
    private Context mContext;
    
    Bundle mBundle;
    private int nodeno = -1;
    private String mTitleText;
    private boolean mStatus;
    private boolean mNetType;
    TextView mTitleView;
    ImageView mOnlineView;
    ImageView mNetTypeView;
    
    List<NodeView2Model> mListData = new ArrayList<NodeView2Model>();
    
    private Spinner moni_grain_spinner;
    private View moni_starttime_view;
    private View moni_endtime_view;
    private View mSearchView;
    Spinner chartSpinner;
    private LineChartView chart;
    private LineChartData data;
    private int numberOfLines = 1;
    private int maxNumberOfLines = 4;
    private int numberOfPoints = 12;
    private int selectedSensor = 0;
    private float viewportTop = 100;
    private float viewportBottom = 0;

    float[][] randomNumbersTab = new float[maxNumberOfLines][numberOfPoints];

    private boolean hasAxes = true;//显示坐标轴及底纹所有
    private boolean hasAxesNames = false;
    private boolean hasLines = true;
    private boolean hasPoints = true;
    private ValueShape shape = ValueShape.CIRCLE;//点的形状 圆点 方点 星点
    private boolean isFilled = false;
    private boolean hasLabels = false;//每个点显示数值
    private boolean isCubic = true;//曲线是弧形
    private boolean hasLabelForSelected = true;//选中是否会一直显示数值, true时hasLabels不能也true
    private boolean pointsHaveDifferentColor;
    
    private String grainSize = "十分钟";
    private String[] grainList = {"十分钟","逐小时","逐日","逐月","逐年"};
    private String startTime = "2016-01-01 01:00:00";
    private String endTime = "2016-01-01 02:00:00";
    
    private static final int MSG_GET_END = 0;
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case MSG_GET_END:
                    if (null != mListData){
                        initChartSpinner(mListData);
                        initChart();
                    }
                    break;

                default:
                    break;
            }
        };
    };
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mContext = getActivity();
        mBundle = getArguments();
        if (mBundle != null){
            nodeno = mBundle.getInt("nodeno", -1);
            mTitleText = mBundle.getString("nodetitle");
            mStatus = mBundle.getBoolean("status", false);
            mNetType = mBundle.getBoolean("isgprs", false);
            Log.e(tag, "----onCreate----getArguments = nodetitle:"+mTitleText);
        } else {
            Log.e(tag, "----onCreate----getArguments = null");
        }
    };
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_moni_chart, container, false);
        mTitleView = (TextView) v.findViewById(R.id.moni_title);
        mOnlineView = (ImageView) v.findViewById(R.id.moni_status);
        mNetTypeView = (ImageView) v.findViewById(R.id.moni_net_type);
        moni_grain_spinner = (Spinner) v.findViewById(R.id.moni_grain_spinner);
        moni_starttime_view = (View) v.findViewById(R.id.moni_starttime_view);
        moni_endtime_view = (View) v.findViewById(R.id.moni_endtime_view);
        mSearchView = (View) v.findViewById(R.id.start_search);
        chartSpinner = (Spinner) v.findViewById(R.id.chart_select);
        chart = (LineChartView) v.findViewById(R.id.chart);
        initTitleBar();
        initTopbar();
        if (Utils.isNetworkConnected(getActivity())){
            new GetMoniDataThread().start();
        } else {
            Toast.makeText(getActivity(), "无网络，请检查！", Toast.LENGTH_SHORT).show();
        }
        return v;
    }
    
    private void initTitleBar(){
        mTitleView.setText(mBundle.getString("nodetitle"));
        mOnlineView.setImageResource(mBundle.getBoolean("status", false) ? R.drawable.online : R.drawable.offline);
        mNetTypeView.setImageResource(mBundle.getBoolean("isgprs", false) ? R.drawable.connect_gprs : R.drawable.connect_zigbee);
        Log.v(tag, "-----odetitle:"+mBundle.getString("nodetitle"));
    }
    
    private class GetMoniDataThread extends Thread{
        @Override
        public void run() {
            sendShowMyDlg("正在查询");
            if (nodeno >= 0){
                List<NodeView2Model> nList = new AjaxGetNodesDataByUserkey().GetNodesDetailData(MainActivity.mUniqueID, ""+nodeno, grainSize,startTime,endTime);
                DbHelperSQL.getInstance().outSideClose();
                mListData.clear();
                mListData.addAll(nList);
            } else {
                Log.e(tag, "----!!!! nodeno < 0!");
            }
            
            sendDismissDlg();
//            setCacheData();
//            SimpleAdapter sAdapter = new SimpleAdapter(getParentFragment().getActivity(), data, resource, from, to)
            mHandler.sendEmptyMessage(MSG_GET_END);
        }
    }
    
    private void initTopbar(){
        ArrayAdapter<String> arr_adapter = new ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_item,grainList);
        moni_grain_spinner.setAdapter(arr_adapter);
        moni_grain_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                grainSize = grainList[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                
            }
        });
        
        ((TextView)moni_starttime_view).setText(startTime);
        moni_starttime_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createTimePickDialog(0).show();
            }
        });
        ((TextView)moni_endtime_view).setText(endTime);
        moni_endtime_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createTimePickDialog(1).show();
            }
        });
        
        mSearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    Date end = sdf.parse(endTime);
                    Date start = sdf.parse(startTime);
                    if (grainSize.equals(grainList[0]) && (end.getTime()-start.getTime())> 15 * 24 * 3600 * 1000){
                        Toast.makeText(mContext, "请缩小选择范围", Toast.LENGTH_SHORT).show();
                    } else {
                        new GetMoniDataThread().start();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    private Dialog createTimePickDialog(final int startOrEnd){
        if (getActivity() != null){
            AlertDialog.Builder bui = new AlertDialog.Builder(mContext);
            View view = getActivity().getLayoutInflater().inflate(R.layout.dia_date_time_pick, null);
            final DatePicker dp = (DatePicker) view.findViewById(R.id.date_pick);
            final TimePicker tp = (TimePicker) view.findViewById(R.id.time_pick);
            bui.setTitle("时间选择").setView(view).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date d = new Date(dp.getYear()-1900, dp.getMonth(), dp.getDayOfMonth(), tp.getCurrentHour(), tp.getCurrentMinute());
                    String str = formatter.format(d);
                    
                    if (startOrEnd == 0){
                        startTime = str;
                        ((TextView) moni_starttime_view).setText(startTime);
                    } else {
                        endTime = str;
                        ((TextView) moni_endtime_view).setText(endTime);
                    }
                }
            }).setNegativeButton(android.R.string.cancel, null);
            return bui.create();
        }
        return null;
    }
    
    private void initChartSpinner(List<NodeView2Model> daList){
        if (null == daList || daList.size() == 0){
            return;
        }
        ArrayList<String> mSensorNames = new ArrayList<String>();
        if (null != chartSpinner && null != daList && daList.size() != 0){
            int sensorCount = daList.get(0)._nodeData_list.size();
            for (int i = 0; i < sensorCount; i ++){
                String str = daList.get(0)._nodeData_list.get(i)._name;
                mSensorNames.add(str);
            }
            ArrayAdapter<String> arr_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,
                    mSensorNames);
            chartSpinner.setAdapter(arr_adapter);
            chartSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    selectedSensor = position;
                    initChart();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }
    }
    
    private void initChart(){
        chart.setOnValueTouchListener(new ValueTouchListener());
        generateValues();
        generateData();
        chart.setViewportCalculationEnabled(true);
        resetViewport();
    }
    
    
    private void generateValues() {
        List<NodeView2Model> n2datas = mListData;
        if (null == n2datas || n2datas.size() == 0){
            return;
        }
        numberOfPoints = n2datas.size();
        randomNumbersTab = new float[maxNumberOfLines][numberOfPoints];
        viewportTop = viewportBottom = n2datas.get(0)._nodeData_list.get(selectedSensor)._data;
        for (int i = 0; i < maxNumberOfLines; ++i) {
            for (int j = 0; j < numberOfPoints; ++j) {
//                randomNumbersTab[i][j] = (float) Math.random() * 100f;
                float val = n2datas.get(numberOfPoints - j - 1)._nodeData_list.get(selectedSensor)._data;//顺序反转一下！
                viewportBottom = viewportBottom > val ? val : viewportBottom;
                viewportTop =  viewportTop > val ? viewportTop : val;
                randomNumbersTab[i][j] = val;
            }
        }
        if (viewportBottom >= viewportTop){
            viewportBottom = viewportBottom - 1;
            viewportTop = viewportBottom + 2;
        }
        float totalHeight = viewportTop - viewportBottom;//上下空出一点 防止曲线溢出
        viewportBottom = viewportBottom - totalHeight/20;
        viewportTop = viewportTop + totalHeight/20;
        Log.v(tag, "-----viewportBottom:" + viewportBottom + "  viewportTop:" + viewportTop  + " first:" + randomNumbersTab[0][0]);
    }

    private void reset() {
        numberOfLines = 1;

        hasAxes = true;
        hasAxesNames = true;
        hasLines = true;
        hasPoints = true;
        shape = ValueShape.CIRCLE;
        isFilled = false;
        hasLabels = false;
        isCubic = false;
        hasLabelForSelected = false;
        pointsHaveDifferentColor = false;

        chart.setValueSelectionEnabled(hasLabelForSelected);
        resetViewport();
    }

    private void resetViewport() {
        // Reset viewport height range to (0,100)
        final Viewport v = new Viewport(chart.getMaximumViewport());
        v.bottom = viewportBottom;
        v.top = viewportTop;
        v.left = 0;
        v.right = numberOfPoints - 1;
        if (v.right < 1){
            v.right = 1;
        }
        chart.setMaximumViewport(v);
        chart.setCurrentViewport(v);
    }

    private void generateData() {

        List<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < numberOfLines; ++i) {

            List<PointValue> values = new ArrayList<PointValue>();
            for (int j = 0; j < numberOfPoints; ++j) {
                values.add(new PointValue(j, randomNumbersTab[i][j]));
            }

            Line line = new Line(values);
            line.setColor(ChartUtils.COLORS[i]);
            line.setShape(shape);
            line.setCubic(isCubic);
            line.setFilled(isFilled);
            line.setHasLabels(hasLabels);
            line.setHasLabelsOnlyForSelected(hasLabelForSelected);
            chart.setValueSelectionEnabled(hasLabelForSelected);//jingbo copy
            line.setHasLines(hasLines);
            line.setHasPoints(hasPoints);
            if (pointsHaveDifferentColor){
                line.setPointColor(ChartUtils.COLORS[(i + 1) % ChartUtils.COLORS.length]);
            }
            lines.add(line);
        }

        data = new LineChartData(lines);

        if (hasAxes) {
            Axis axisX = new Axis();
            Axis axisY = new Axis().setHasLines(true);
            if (hasAxesNames) {
                axisX.setName("X 轴");
                axisY.setName("Y 轴");
            }
            data.setAxisXBottom(axisX);
            data.setAxisYLeft(axisY);
        } else {
            data.setAxisXBottom(null);
            data.setAxisYLeft(null);
        }

        data.setBaseValue(Float.NEGATIVE_INFINITY);
        chart.setLineChartData(data);
    }
    
    
    
    
    private class ValueTouchListener implements LineChartOnValueSelectListener {

        @Override
        public void onValueSelected(int lineIndex, int pointIndex, PointValue value) {
            if (null != mListData && mListData.size() != 0){
                String timeStr = mListData.get(numberOfPoints - pointIndex - 1)._detailTime;//顺序反转一下
                Toast.makeText(getActivity(), "时间:" + timeStr + ",传感器值:" + value.getY(), Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(getActivity(), "error onValueSelected", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onValueDeselected() {
            // TODO Auto-generated method stub

        }

    }
}