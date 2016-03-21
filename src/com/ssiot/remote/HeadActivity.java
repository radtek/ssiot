package com.ssiot.remote;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.ssiot.remote.LoginActivity;
import com.ssiot.remote.Utils;

import java.lang.reflect.Field;

public class HeadActivity extends ActionBarActivity{
    private static final String tag = "HeadActivity";
    public static int width = 0;
    public static int height = 0;
    protected LayoutInflater mInflater;
    private boolean windowTranslucent = false;
    private boolean hasActionBar = true;
    private boolean viewIsSet = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.head));
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.DarkGreen));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mInflater = getLayoutInflater();
        if ((width == 0) || (height == 0)) {
            DisplayMetrics localDisplayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
            width = localDisplayMetrics.widthPixels;
            height = localDisplayMetrics.heightPixels;
        }
        
        if (true && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//安卓自定义状态栏颜色以与APP风格保持一致
            windowTranslucent = true;
//            //透明状态栏  
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);  
//            //透明导航栏  
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION); 
            setTranslucentStatus(true);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);    
            tintManager.setStatusBarTintEnabled(true);    
            tintManager.setStatusBarTintResource(R.color.DarkGreen);//通知栏所需颜色  
          
        }
        /*
        SystemBarTintManager tintManager = new SystemBarTintManager(this);  
        // 激活状态栏设置  
        tintManager.setStatusBarTintEnabled(true);  
        // 激活导航栏设置  
        tintManager.setNavigationBarTintEnabled(true); 
        // 设置一个颜色给系统栏  
        tintManager.setTintColor(Color.parseColor("#99000FF"));  
        // 设置一个样式背景给导航栏  
//        tintManager.setNavigationBarTintResource(R.drawable.my_tint);  
        // 设置一个状态栏资源  
//        tintManager.setStatusBarTintDrawable(MyDrawable);*/
    }
    
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        if (windowTranslucent){
            View rootView = ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);
            if (hasActionBar){
                rootView.setPadding(0, getActionBarHeight() + getStatusBarHeight(), 0, 0);
            } else {
                rootView.setPadding(0, getStatusBarHeight(), 0, 0);
            }
        }
        viewIsSet = true;
    }
    
    @TargetApi(19)     
    private void setTranslucentStatus(boolean on) {    
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        //当你把窗口flag设置成 FLAG_TRANSLUCENT_STATUS后，你的应用所占的屏幕扩大到全屏，
        //但是最顶上会有背景透明的状态栏，它的文字可能会盖着你的应用的标题栏，你可以手动将你的app显示的内容向下错出一个状态栏的高度，这样就能完成适配了。
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;    
        if (on) {    
            winParams.flags |= bits;    
        } else {    
            winParams.flags &= ~bits;    
        }    
        win.setAttributes(winParams);   
    }
    
    @TargetApi(19)
    private void testbar(){
      //设置应用布局时是否考虑系统窗口布局；如果为true，将调整系统窗口布局以适应你自定义的布局。
        //比如系统有状态栏，应用也有状态栏时。看你这个布局代码，恰恰是在定义标题栏样式，所以用到这行代码了
        getWindow().getDecorView().setFitsSystemWindows(true);
    }
    
    public void hideActionBar(){//must invoke before setcontentview
        Log.v(tag, "----hideActionBar----");
        getSupportActionBar().hide();
        hasActionBar = false;
//        testbar();
        if (viewIsSet){
            Toast.makeText(this, "must invoke before setcontentview", Toast.LENGTH_SHORT).show();
            Log.e(tag, "must invoke before setcontentview");
        }
    }
    
    public void initTitleLeft(int resid){
        TextView titleLeft = (TextView) findViewById(resid);//R.id.title_bar_left
        titleLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                View v = getWindow().peekDecorView();
                if (v != null){
                    InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputmanger.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    
    //// 获取手机状态栏高度  http://www.cnblogs.com/zhengxt/p/3536905.html
    private int getStatusBarHeight() {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return statusBarHeight;
    }

    // 获取ActionBar的高度
    private int getActionBarHeight() {
        TypedValue tv = new TypedValue();
        int actionBarHeight = 0;
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))// 如果资源是存在的、有效的
        {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources()
                    .getDisplayMetrics());
        }
//        Log.v(tag, "-------getActionBarHeight---------=" + actionBarHeight);//MI3 = 144
        return actionBarHeight;
    }
}