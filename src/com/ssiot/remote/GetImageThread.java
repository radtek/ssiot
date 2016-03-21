package com.ssiot.remote;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import com.ssiot.remote.monitor.MoniNodeListFrag;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetImageThread extends Thread{
    private static final String tag = "GetImageThread.java";
    public static final int MSG_GETFTPIMG_END = MoniNodeListFrag.MSG_GET_ONEIMAGE_END;
    String url = "";
    ImageView imageView;
    Handler uiHandler;
    public GetImageThread(ImageView view, String urlString,Handler h){
        url = urlString;
        imageView = view;
        uiHandler = h;
    }
    @Override
    public void run() {
        Bitmap bitmap = getHttpBitmap(url);
        Message message = uiHandler.obtainMessage(MoniNodeListFrag.MSG_GET_ONEIMAGE_END);//MoniNodeListFrag 与ControlNodeListFrag 必须都是2
        message.obj = new ThumnailHolder(imageView, bitmap);
        uiHandler.sendMessage(message);
    }
    
    public static Bitmap getHttpBitmap(String url){
        URL myFileURL;
        Bitmap bitmap=null;
        try{
            Log.v(tag, "----start getftpbitmap---" + url);
			//原先都是http://yun.ssiot.com/的 后来加入溯源 需要cloud了 20160107 http://yun.ssiot.com/
            myFileURL = new URL(url);
            //获得连接
            HttpURLConnection conn=(HttpURLConnection)myFileURL.openConnection();
            //设置超时时间为6000毫秒，conn.setConnectionTiem(0);表示没有时间限制
            conn.setConnectTimeout(4000);
            //连接设置获得数据流
            conn.setDoInput(true);
            //不使用缓存
            conn.setUseCaches(false);
            //这句可有可无，没有影响
            //conn.connect();
            //得到数据流
            InputStream is = conn.getInputStream();
            //解析得到图片
//            BitmapFactory.Options options = new BitmapFactory.Options();
//            options.outWidth = 64;
//            options.outHeight = 64;
            bitmap = BitmapFactory.decodeStream(is);
//            bitmap = BitmapFactory.decodeStream(is, null, options);
            
            bitmap = resizeBitmap(bitmap, 128, 128);
            //关闭数据流
            is.close();
            String fileUrl = "";
            if (url.startsWith("http://yun.ssiot.com/")){
                fileUrl = url.substring(url.length()-21, url.length());
            } else if (url.startsWith("http://cloud.ssiot.com/")){
                fileUrl = url.substring(url.length()-22, url.length());
            } else {
                Log.e(tag, "-----unkonw ftp img file url:" + url);
                return bitmap;
            }
            Log.v(tag, "----- ftp img file url:" + url);
            saveBitmap(bitmap, Environment.getExternalStorageDirectory() + "/"+SsiotConfig.CACHE_DIR +"/" + url);
        }catch(Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }
    
    public static void saveBitmap(Bitmap bm, String path) {
        path = path.replace("http://", "");
        File f = new File(path);
        f.getParentFile().mkdirs();
        if (f.exists()) {
            boolean b = f.delete();
            Log.v(tag, "------exists delete result :" + b + " " + path);
        }
        try {
            FileOutputStream out = new FileOutputStream(f);
            bm.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    public static Bitmap resizeBitmap(Bitmap drawable, int desireWidth,
            int desireHeight) {
        int width = drawable.getWidth();
        int height = drawable.getHeight();

        if (0 < width && 0 < height && desireWidth < width
                || desireHeight < height) {
            // Calculate scale
            float scale;
            if (width < height) {
                scale = (float) desireHeight / (float) height;
                if (desireWidth < width * scale) {
                    scale = (float) desireWidth / (float) width;
                }
            } else {
                scale = (float) desireWidth / (float) width;
            }

            // Draw resized image
            Matrix matrix = new Matrix();
            matrix.postScale(scale, scale);
            Bitmap bitmap = Bitmap.createBitmap(drawable, 0, 0, width, height,
                    matrix, true);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawBitmap(bitmap, 0, 0, null);

            drawable = bitmap;
        }
        return drawable;
    }
    
    public class ThumnailHolder{
        public ImageView imageView;
        public Bitmap bitmap;
        public ThumnailHolder(ImageView image,Bitmap b) {
            this.bitmap = b;
            this.imageView = image;
        }
    }
}
