package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * GPS status info
 * \else
 * GPS状态信息
 * \endif
 */
public class NET_GPS_STATUS_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

 	/**
	 * \if ENGLISH_LANG
	 * time
	 * \else
	 * 定位时间
	 * \endif
	 */
	public NET_TIME            revTime = new NET_TIME();                        
 	/**
	 * \if ENGLISH_LANG
	 * device number
	 * \else
	 * 设备序列号
	 * \endif
	 */
	public byte                DvrSerial[] = new byte[50];                  
 	/**
	 * \if ENGLISH_LANG
	 * longitude(1/1000000,range[0-360])
	 * \else
	 * 经度(单位是百万分之度，范围0-360度)
	 * \endif
	 */
	public double              longitude;                      
 	/**
	 * \if ENGLISH_LANG
	 * latitude(1/1000000,range[0-180])
	 * \else
	 * 纬度(单位是百万分之度，范围0-180度)
	 * \endif
	 */
	public double              latidude;                       
 	/**
	 * \if ENGLISH_LANG
	 * highness(m)
	 * \else
	 * 高度(米)
	 * \endif
	 */
	public double              height;                         
 	/**
	 * \if ENGLISH_LANG
	 * angle(north is source point,clockwise is positive)
	 * \else
	 * 方向角(正北方向为原点，顺时针为正)
	 * \endif
	 */
	public double              angle;                          
 	/**
	 * \if ENGLISH_LANG
	 * speed(sea mile,speed/1000*1.852km/h)
	 * \else
	 * 速度(单位是海里，speed/1000*1.852公里/小时)
	 * \endif
	 */
	public double              speed;                          
 	/**
	 * \if ENGLISH_LANG
	 * star count
	 * \else
	 * 定位星数
	 * \endif
	 */
	public boolean                starCount;                      
 	/**
	 * \if ENGLISH_LANG
	 * antenna state(true good, false bad)
	 * \else
	 * 天线状态(true 好，false 坏)
	 * \endif
	 */
	public boolean                antennaState;                   
 	/**
	 * \if ENGLISH_LANG
	 * orientation state(true orientation, false not)
	 * \else
	 * 定位状态(true 定位，false 不定位)
	 * \endif
	 */
	public boolean                orientationState;               
 	/**
	 * \if ENGLISH_LANG
	 * working state(true normal, false abnormity)
	 * \else
	 * 工作状态(0=未定位，1=非差分定位，2=差分定位，3=无效PPS，6=正在估算 
	 * \endif
	 */
	public boolean                workStae;                       
 	/**
	 * \if ENGLISH_LANG
	 * alarm count
	 * \else
	 * 发生的报警位置个数
	 * \endif
	 */
	public int                 nAlarmCount;                    
 	/**
	 * \if ENGLISH_LANG
	 * alarm type
	 * \else
	 * 发生的报警位置，值可能多个
	 * \endif
	 */
	public int                 nAlarmState[] = new int[128];               
 	/**
	 * \if ENGLISH_LANG
	 * 0- real time 1-fill 
	 * \else
	 * 0-实时 1-补传 
	 * \endif
	 */
	public byte                bOffline;                       
}
