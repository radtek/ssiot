package com.ssiot.remote.history;

import android.R.integer;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ssiot.remote.BaseFragment;
import com.ssiot.remote.GetImageThread;
import com.ssiot.remote.GetImageThread.ThumnailHolder;
import com.ssiot.remote.R;
import com.ssiot.remote.data.AjaxHistory;
import com.ssiot.remote.data.model.CompanyContentModel;
import com.ssiot.remote.data.model.TraceCertificationModel;
import com.ssiot.remote.data.model.TraceFertilizerModel;
import com.ssiot.remote.data.model.TraceImagesModel;
import com.ssiot.remote.data.model.TracePesticidesModel;
import com.ssiot.remote.data.model.TraceProfileModel;
import com.ssiot.remote.monitor.MoniNodeListFrag;

import java.util.List;

public class HistoryDetailFragment extends BaseFragment{
    public static final String tag = "HisDetailFragment";
    private FHisDetailBtnClickListener mFHisDetailBtnClickListener;
    private TraceProfileModel model = null;
    List<TraceImagesModel> mTraceImagesModels;//生长期图片
    List<TraceFertilizerModel> mTraceFertilizerModels;
    List<TracePesticidesModel> mTracePesticidesModels;
    List<TraceCertificationModel> mtCertificationModels;
    private String mInfoString = "";
    private CompanyContentModel mCompanyContentModel;
    
    ImageView mImgView;
    TextView mInfoView;
    TextView mCompanyView;
    TextView mCertView;
    
    private static final int MSG_GETIMG_END = MoniNodeListFrag.MSG_GET_ONEIMAGE_END;//used in GetImgThread
    private static final int MSG_GET_INFO_END = 3;
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            if (!isVisible()){
                Log.e(tag, "-----not visible: msg:" + msg.what);
                return;
            }
            switch (msg.what) {
                case MSG_GETIMG_END:
                    ThumnailHolder thumb = (ThumnailHolder) msg.obj;
                    thumb.imageView.setImageBitmap(thumb.bitmap);
//                    thumb.imageView.setBackgroundDrawable(null);
                    break;
                case MSG_GET_INFO_END:
                    if (null != mInfoView && null != mInfoString){
                        mInfoView.setText(mInfoString);
                    }
                    if (null != mCompanyView && null != mCompanyContentModel){
                        mCompanyView.setText(mCompanyContentModel._compantemplate + "\n" + mCompanyContentModel._compancontent);
                    }
                    if (null != mCertView && mtCertificationModels != null){
                        String str = "";
                        for(int i = 0; i < mtCertificationModels.size(); i ++){
                            str += mtCertificationModels.get(i)._name + "\n";
                        }
                        if (!TextUtils.isEmpty(str)){
                            mCertView.setText(str);
                        }
                    }
                    break;

                default:
                    break;
            }
        };
    };
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        String userkey = getArguments().getString("userkey");
        String code = getArguments().getString("code");
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_history_detail, container, false);
        findAllViews(rootView);
        return rootView;
    }
    
    private void findAllViews(View rootView){
        if (model == null) {
            return;
        }
        TextView mProNameView = (TextView) rootView.findViewById(R.id.pro_name);
        TextView mProVarietyView = (TextView) rootView.findViewById(R.id.pro_variety);
        TextView mProBatchView = (TextView) rootView.findViewById(R.id.pro_batch);
        TextView mProTimeView = (TextView) rootView.findViewById(R.id.pro_time);
        mImgView = (ImageView) rootView.findViewById(R.id.his_img);
        mCertView = (TextView) rootView.findViewById(R.id.certificate_text);
        mInfoView = (TextView) rootView.findViewById(R.id.info_text);
        mCompanyView  = (TextView) rootView.findViewById(R.id.company_text);
        
        if (null != model && model._listingDate != null){
            mProNameView.setText(model._name);
            mProVarietyView.setText("品种:"+model._variety);
            mProBatchView.setText("批次:"+model._batchno);
            String timeString = model._listingDate.toString();
            if (timeString.length() >= 16){
                timeString = timeString.substring(0,16);
            }
            mProTimeView.setText("上市时间:"+timeString);
        }
        new GetImageThread(mImgView, "http://cloud.ssiot.com/"+model._image, mHandler).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mInfoString = "";
                AjaxHistory hisTool = new AjaxHistory();
                mInfoString = hisTool.getProfileContentStr(model._descid);
                mCompanyContentModel = hisTool.getCompanyInfo(model._comdescid);
                mTraceImagesModels = hisTool.geTraceImagesModels(model._id);//TODO
                mTraceFertilizerModels = hisTool.getFertilizerModels(model._id);
                mTracePesticidesModels = hisTool.getPesticidesModels(model._id);
                mtCertificationModels = hisTool.getCertificationModels(model._id);
                mHandler.sendEmptyMessage(MSG_GET_INFO_END);
            }
        }).start();
        
        rootView.findViewById(R.id.his_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        findBtnViews(rootView);
    }
    
    private void findBtnViews(View rootView){
        TextView mBtnSensor = (TextView) rootView.findViewById(R.id.btn_sensor);
        TextView mBtnVideo = (TextView) rootView.findViewById(R.id.btn_video);
        TextView mBtnImg = (TextView) rootView.findViewById(R.id.btn_img);
        TextView mBtnFertilizer = (TextView) rootView.findViewById(R.id.btn_fertilizer);
        TextView mBtnPesticide = (TextView) rootView.findViewById(R.id.btn_pesticide);
        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_sensor:
                        Toast.makeText(getActivity(), "正在开发", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btn_video:
                        Toast.makeText(getActivity(), "正在开发", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btn_img:
                        if (null != mTraceImagesModels && mTraceImagesModels.size() > 0){
                            ImgDialogFrag mdiaf = new ImgDialogFrag(mTraceImagesModels);
                            FragmentTransaction ft = getChildFragmentManager().beginTransaction();//TODO child ??
                            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                            mdiaf.show(ft, "diafragimg");
                        } else {
                            Toast.makeText(getActivity(), "没有图像", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.btn_fertilizer:
                        if (null != mTraceFertilizerModels && mTraceFertilizerModels.size() > 0){
                            TxtDialogFrag mdiaf = new TxtDialogFrag(mTraceFertilizerModels);
                            FragmentTransaction ft = getChildFragmentManager().beginTransaction();//TODO child ??
                            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                            mdiaf.show(ft, "diafragfer");
                        } else {
                            Toast.makeText(getActivity(), "没有肥料记录", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.btn_pesticide:
                        if (null != mTraceFertilizerModels && mTraceFertilizerModels.size() > 0){
                            TxtPesDialogFrag mdiaf = new TxtPesDialogFrag(mTracePesticidesModels);
                            FragmentTransaction ft = getChildFragmentManager().beginTransaction();//TODO child ??
                            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                            mdiaf.show(ft, "diafragpes");
                        } else {
                            Toast.makeText(getActivity(), "没有农药记录", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    default:
                        break;
                }
            }
        };
        mBtnSensor.setOnClickListener(btnListener);
        mBtnVideo.setOnClickListener(btnListener);
        mBtnImg.setOnClickListener(btnListener);
        mBtnFertilizer.setOnClickListener(btnListener);
        mBtnPesticide.setOnClickListener(btnListener);
    }
    
    public void setModel(TraceProfileModel m){
        model = m;
    }
    
    @Override
    public void onResume() {
        super.onResume();
    }
    
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.his_detail, menu);
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
    
    @Override
    public boolean canGoback(){
        return false;
    }
    
    @Override
    public void onMyBackPressed(){//add by jingbo
    }
    
    public void setClickListener(FHisDetailBtnClickListener listen){
        mFHisDetailBtnClickListener = listen;
    }
    
    //回调接口，留给activity使用
    public interface FHisDetailBtnClickListener {  
        void onFHisDetailBtnClick();  
    }
    
    public class ImgDialogFrag extends DialogFragment{
        private List<TraceImagesModel> imgModels;
        //img的文件地址已经查询好，需要下载ftp
        public ImgDialogFrag(List<TraceImagesModel> imgModels){
            this.imgModels = imgModels;
        }
        
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.his_dia_img, container, false);
            getDialog().setTitle("生长期图片");
            ListView mListView = (ListView) v.findViewById(R.id.img_list);
            ImgListAdapter adapter = new ImgListAdapter(getActivity(), imgModels);
            mListView.setAdapter(adapter);
            return v;
        }
        
        private class ImgListAdapter extends BaseAdapter{
            private LayoutInflater mInflater;
            private List<TraceImagesModel> mModels;
            
            public ImgListAdapter(Context c,List<TraceImagesModel> models){
                mInflater = LayoutInflater.from(c);
                mModels = models;
            }
            @Override
            public int getCount() {
                return mModels.size();
            }

            @Override
            public Object getItem(int position) {
                return mModels.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder holder;
                if (null == convertView){
                    holder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.his_imglist_item, null);
                    holder.mImgView = (ImageView) convertView.findViewById(R.id.imgitm_img);
                    holder.mTextView = (TextView) convertView.findViewById(R.id.imgitm_txt);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                TraceImagesModel m = mModels.get(position);
                new GetImageThread(holder.mImgView, "http://cloud.ssiot.com/"+m._imgfilename, mHandler).start();
                holder.mTextView.setText(m._imgdesc);
                return convertView;
            }
            
            private class ViewHolder{
                ImageView mImgView;
                TextView mTextView;
            }
        }
    }
    
    //-------------------
    public class TxtDialogFrag extends DialogFragment{
        private List<TraceFertilizerModel> ferModels;
        //img的文件地址已经查询好，需要下载ftp
        public TxtDialogFrag(List<TraceFertilizerModel> models){
            this.ferModels = models;
        }
        
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.his_dia_img, container, false);
            getDialog().setTitle("肥料使用记录");
            ListView mListView = (ListView) v.findViewById(R.id.img_list);
            TxtListAdapter adapter = new TxtListAdapter(getActivity(), ferModels);
            mListView.setAdapter(adapter);
            return v;
        }
        
        private class TxtListAdapter extends BaseAdapter{
            private LayoutInflater mInflater;
            private List<TraceFertilizerModel> mModels;
            
            public TxtListAdapter(Context c,List<TraceFertilizerModel> models){
                mInflater = LayoutInflater.from(c);
                mModels = models;
            }
            @Override
            public int getCount() {
                return mModels.size();
            }

            @Override
            public Object getItem(int position) {
                return mModels.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder holder;
                if (null == convertView){
                    holder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.his_txtlist_item, null);
                    holder.mTextView1 = (TextView) convertView.findViewById(R.id.txtitm_txt1);
                    holder.mTextView2 = (TextView) convertView.findViewById(R.id.txtitm_txt2);
                    holder.mTextView3 = (TextView) convertView.findViewById(R.id.txtitm_txt3);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                Object o = mModels.get(position);
                if (o instanceof TraceFertilizerModel){
                    
                } else if (o instanceof TracePesticidesModel){
                    TracePesticidesModel m = (TracePesticidesModel) o;
                    holder.mTextView1.setText(m._pesusedate);
                    holder.mTextView2.setText(m._pesname);
                    holder.mTextView3.setText(""+m._pesdosage + m._pesunit);
                } else {
                    Log.e(tag, "------TxtListAdapter error");
                }
                
                TraceFertilizerModel m = mModels.get(position);
                holder.mTextView1.setText(m._ferusedate);
                holder.mTextView2.setText(m._fername);
                holder.mTextView3.setText(""+m._ferdosage + m._ferunit);
                return convertView;
            }
            
            private class ViewHolder{
                TextView mTextView1;
                TextView mTextView2;
                TextView mTextView3;
            }
            
        }
    }
    
    //-------------------------
    public class TxtPesDialogFrag extends DialogFragment{
        private List<TracePesticidesModel> pesModels;
        //img的文件地址已经查询好，需要下载ftp
        public TxtPesDialogFrag(List<TracePesticidesModel> models){
            this.pesModels = models;
        }
        
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.his_dia_img, container, false);
            getDialog().setTitle("农药使用记录");
            ListView mListView = (ListView) v.findViewById(R.id.img_list);
            TxtPesListAdapter adapter = new TxtPesListAdapter(getActivity(), pesModels);
            mListView.setAdapter(adapter);
            return v;
        }
        
        private class TxtPesListAdapter extends BaseAdapter{
            private LayoutInflater mInflater;
            private List<TracePesticidesModel> mModels;
            
            public TxtPesListAdapter(Context c,List<TracePesticidesModel> models){
                mInflater = LayoutInflater.from(c);
                mModels = models;
            }
            @Override
            public int getCount() {
                return mModels.size();
            }

            @Override
            public Object getItem(int position) {
                return mModels.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder holder;
                if (null == convertView){
                    holder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.his_txtlist_item, null);
                    holder.mTextView1 = (TextView) convertView.findViewById(R.id.txtitm_txt1);
                    holder.mTextView2 = (TextView) convertView.findViewById(R.id.txtitm_txt2);
                    holder.mTextView3 = (TextView) convertView.findViewById(R.id.txtitm_txt3);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                TracePesticidesModel m = mModels.get(position);
                holder.mTextView1.setText(m._pesusedate);
                holder.mTextView2.setText(m._pesname);
                holder.mTextView3.setText(""+m._pesdosage + m._pesunit);
                return convertView;
            }
            
            private class ViewHolder{
                TextView mTextView1;
                TextView mTextView2;
                TextView mTextView3;
            }
        }
    }//diafrag end
    
    
}