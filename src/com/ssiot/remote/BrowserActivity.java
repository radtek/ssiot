package com.ssiot.remote;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.ssiot.remote.R;
import com.ssiot.remote.Utils;

public class BrowserActivity extends ActionBarActivity{
    private static final String tag  = "BrowserActivity";
    private static String urlString = "http://www.ssiot.com";
    WebView webView;
    MenuItem refreshItem;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        if (null != intent){
            urlString = intent.getStringExtra("url");
        }
        setContentView(R.layout.activity_web_browser);
        
        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setBuiltInZoomControls(false);// 设置出现缩放工具
        webView.getSettings().setUseWideViewPort(true);//扩大比例的缩放
        webView.getSettings().setSupportZoom(true);// 设置可以支持缩放 
        webView.getSettings().setLoadWithOverviewMode(true); 
        webView.setVerticalScrollBarEnabled(true);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true); 
        settings.setAllowFileAccess(true);
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
//                setProgress(progress * 100);
            }
        });
        // url要加载的网址
//        if (TextUtils.isEmpty(userKey)){
//            Toast.makeText(getActivity(), "未获取到key", Toast.LENGTH_SHORT).show();
//        }
        if (!Utils.isNetworkConnected(this)){
            Toast.makeText(this, R.string.please_check_net, Toast.LENGTH_SHORT).show();
        }
        webView.loadUrl(urlString);
        
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (!Utils.isNetworkConnected(BrowserActivity.this)){
                    Toast.makeText(BrowserActivity.this, R.string.please_check_net, Toast.LENGTH_SHORT).show();
                } else {
                    view.loadUrl(url);
                }
                return true;
            }

            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                String title = webView.getTitle();
                // setTitle(title);
            }
        });
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_control, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_control_refresh:
                if (!Utils.isNetworkConnected(BrowserActivity.this)){
                    Toast.makeText(BrowserActivity.this, R.string.please_check_net, Toast.LENGTH_LONG).show();
                } else {
                    webView.reload();
                    showRefreshAnimation(item);
                }
                break;
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return true;
    }
    
    @SuppressLint("NewApi")
    private void showRefreshAnimation(MenuItem item) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
            hideRefreshAnimation();
            refreshItem = item;
            ImageView refreshActionView = (ImageView) BrowserActivity.this.getLayoutInflater().inflate(R.layout.action_refreshing, null);
            refreshActionView.setImageResource(R.drawable.ic_action_refresh);
            refreshItem.setActionView(null);
            refreshItem.setActionView(refreshActionView);
            Animation animation = AnimationUtils.loadAnimation(BrowserActivity.this, R.anim.loading_animation);
            animation.setRepeatMode(Animation.RESTART);
            animation.setRepeatCount(Animation.INFINITE);
            refreshActionView.startAnimation(animation);
            webView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    hideRefreshAnimation();
                }
            }, 800);
        }
    }
    
    @SuppressLint("NewApi")
    private void hideRefreshAnimation() {
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
    
    @Override
    public void onBackPressed() {
        if (null != webView && webView.canGoBack()){
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
    
    @Override
    protected void onDestroy() {
        hideRefreshAnimation();
        super.onDestroy();
    }
}