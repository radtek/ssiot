
package com.ssiot.remote.yun.monitor;

import android.R.integer;
import android.widget.ImageView;

import com.ssiot.remote.R;

import java.io.Serializable;
import java.util.HashMap;

public class DeviceBean implements Serializable{
    public static final int TYPE_SENSOR = 1;
    public static final int TYPE_ACTUATOR = 2;
    public static final int TYPE_CAMERA = 3;
    public int mType = 0;//大类 1 2 3 
    public int mDeviceTypeNo = 0;
    public String mName;
    private static HashMap<Integer, Integer> mSensorIconMap = new HashMap<Integer, Integer>();
    private static HashMap<Integer, Integer> mCtrlIconMap = new HashMap<Integer, Integer>();
    private static HashMap<Integer, Integer> mCameraIconMap = new HashMap<Integer, Integer>();
    static{
        mSensorIconMap.put(769, R.drawable.ic_section_humidity);//湿度
        mSensorIconMap.put(770, R.drawable.ic_section_temp);//温度
        mSensorIconMap.put(771, R.drawable.ic_section_soiltension);//大气压？？
        mSensorIconMap.put(772, R.drawable.ic_section_rain);//雨量
        mSensorIconMap.put(773, R.drawable.ic_section_vane);//风向
        mSensorIconMap.put(774, R.drawable.ic_section_wind);//风速
        mSensorIconMap.put(1001, R.drawable.ic_section_ph);//PH
        mSensorIconMap.put(1002, R.drawable.ic_section_do);//溶解氧？
        mSensorIconMap.put(1003, R.drawable.ic_section_default);//氨离子
        mSensorIconMap.put(1006, R.drawable.ic_section_default);//溶解氧饱和度？
        mSensorIconMap.put(1007, R.drawable.ic_section_default);//溶解氧相位
        mSensorIconMap.put(1008, R.drawable.ic_section_default);//氨氮
        mSensorIconMap.put(1009, R.drawable.ic_section_default);//铅离子
        mSensorIconMap.put(1010, R.drawable.ic_section_default);//镉离子
        mSensorIconMap.put(1011, R.drawable.ic_section_default);//氟离子传感器
        mSensorIconMap.put(1020, R.drawable.ic_section_erate);//电导率
        mSensorIconMap.put(1022, R.drawable.ic_section_default);//盐度传感器
        mSensorIconMap.put(1025, R.drawable.ic_section_soilhumidity);//土壤水分传感器
        mSensorIconMap.put(1102, R.drawable.ic_section_co2);//二氧化碳传感器浓度中
        mSensorIconMap.put(1123, R.drawable.ic_section_default);//钠离子浓度
        mSensorIconMap.put(1124, R.drawable.ic_section_default);//钾离子
        mSensorIconMap.put(1281, R.drawable.ic_section_lux);//光照强度  Lux
        mSensorIconMap.put(1282, R.drawable.ic_section_default);//光辐射度
        mSensorIconMap.put(1301, R.drawable.ic_section_default);//距离
        mSensorIconMap.put(1302, R.drawable.ic_section_default);//植物茎直径
        mSensorIconMap.put(1303, R.drawable.ic_section_wetness);//叶面湿度
        mSensorIconMap.put(1304, R.drawable.ic_section_default);//植物茎流量
        mSensorIconMap.put(1305, R.drawable.ic_section_default);//叶面温
        mSensorIconMap.put(1306, R.drawable.ic_section_default);//环境温
        mSensorIconMap.put(1401, R.drawable.ic_section_default);//电池电量
        mSensorIconMap.put(1402, R.drawable.ic_section_default);//电池电压
        mSensorIconMap.put(6101, R.drawable.ic_section_flow);//累计流量
        mSensorIconMap.put(6201, R.drawable.ic_section_default);//实时流量
        mSensorIconMap.put(7101, R.drawable.ic_section_default);//经度
        mSensorIconMap.put(7102, R.drawable.ic_section_default);//纬度
        mSensorIconMap.put(7201, R.drawable.ic_section_default);//速度
        mSensorIconMap.put(7202, R.drawable.ic_section_default);//方位角
        mSensorIconMap.put(7203, R.drawable.ic_section_default);//磁偏角
        mSensorIconMap.put(8001, R.drawable.ic_section_default);//十分钟平均风速
        mSensorIconMap.put(8002, R.drawable.ic_section_default);//十分钟平均风向
        mSensorIconMap.put(8003, R.drawable.ic_section_default);//总辐射传感器
        mSensorIconMap.put(8004, R.drawable.ic_section_default);//日照时数传感器
        mSensorIconMap.put(8005, R.drawable.ic_section_default);//十分钟累计雨量
        mSensorIconMap.put(8006, R.drawable.ic_section_default);//亚硝酸盐传感器
        mSensorIconMap.put(8007, R.drawable.ic_section_level);//水位传感器
        mSensorIconMap.put(8008, R.drawable.ic_section_default);//水氨氮传感器
        mSensorIconMap.put(8009, R.drawable.ic_section_default);//浊度传感器
        mSensorIconMap.put(8010, R.drawable.ic_section_cod);//COD传感器
        mSensorIconMap.put(8011, R.drawable.ic_section_default);//氨气传感器
        mSensorIconMap.put(8012, R.drawable.ic_section_h2s);//硫化氢传感器
        mSensorIconMap.put(8013, R.drawable.ic_section_default);//水温
        mSensorIconMap.put(8014, R.drawable.ic_section_default);//土壤肥力
        mSensorIconMap.put(8015, R.drawable.ic_section_soiltemp);//土壤温度
        mSensorIconMap.put(8016, R.drawable.ic_section_default);//气温
        mSensorIconMap.put(8017, R.drawable.ic_section_default);//分贝
        mSensorIconMap.put(8018, R.drawable.ic_section_default);//粉尘
        mSensorIconMap.put(8019, R.drawable.ic_section_default);//光谱
        mSensorIconMap.put(8020, R.drawable.ic_section_default);//扬尘
        mSensorIconMap.put(8021, R.drawable.ic_section_default);//土壤ph
        mSensorIconMap.put(8022, R.drawable.ic_section_default);//草料温度
        mSensorIconMap.put(8023, R.drawable.ic_section_default);//空气温度
        mSensorIconMap.put(8024, R.drawable.ic_section_default);//环境温度
        mSensorIconMap.put(8025, R.drawable.ic_section_default);//环境湿度
        mSensorIconMap.put(8026, R.drawable.ic_section_default);//光照照度
        mSensorIconMap.put(8027, R.drawable.ic_section_default);//设定温度
        mSensorIconMap.put(8028, R.drawable.ic_section_default);//设定湿度
        mSensorIconMap.put(8029, R.drawable.ic_section_default);//设定COⅡ浓度
        mSensorIconMap.put(8030, R.drawable.ic_section_default);//果实大小
        mSensorIconMap.put(8031, R.drawable.ic_section_default);//系统开关机输出状态
        mSensorIconMap.put(8032, R.drawable.ic_section_default);//门磁
        mSensorIconMap.put(8033, R.drawable.ic_section_default);//硝酸根离子
        mSensorIconMap.put(8034, R.drawable.ic_section_default);//开关状态
        mSensorIconMap.put(8035, R.drawable.ic_section_default);//铜离子
        mSensorIconMap.put(8036, R.drawable.ic_section_default);//溴离子
        mSensorIconMap.put(8037, R.drawable.ic_section_default);//钙离子
        mSensorIconMap.put(8038, R.drawable.ic_section_default);//硬度
        mSensorIconMap.put(8039, R.drawable.ic_section_default);//ORP
        
        mCtrlIconMap.put(1, R.drawable.ic_section_default);
        
        mCameraIconMap.put(1, R.drawable.ic_section_surveillance);
        mCameraIconMap.put(2, R.drawable.ic_section_surveillance);
    }

    public DeviceBean(int type, int deviceTypeNo, String name) {// 例如 光照
        mType = type;
        mDeviceTypeNo = deviceTypeNo;
        mName = name;
//        Imageview setColorFilter 可以动态改变图标的颜色
    }
    
    public int getContactStatus(){//TODO
        return 1;
    }
    
    public int getRunStatus(){//TODO
        return 6;
    }

    // 设置为static比较好
    public static int getIconRes(int type, int deviceno) {
        int resId = 0;
        try {
            switch (type) {
                case 1:// sensor 类
                    resId = mSensorIconMap.get(deviceno);
                    break;
                case 2:// 控制 类
                    resId = mCtrlIconMap.get(deviceno);
                    break;
                case 3:// 视频 类
                    resId = mCameraIconMap.get(deviceno);
                    break;

                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resId = R.drawable.ic_section_default;
        }
        
        return resId;
    }
    
    public boolean isSensorDevice(){
        return mType == TYPE_SENSOR;
    }
    
    public boolean isWebcamDevice(){
        return mType == TYPE_CAMERA;
    }
    
    public boolean isCntrolDevice(){
        return mType == TYPE_ACTUATOR;
    }
}
