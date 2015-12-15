package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * The describe of EVENT_IVS_TRAFFICJUNCTION's data
 * \else
 * 事件类型EVENT_IVS_TRAFFICJUNCTION(交通路口事件)对应的数据块描述信息
 * \endif
 */
public class DEV_EVENT_TRAFFICJUNCTION_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * ChannelId
	 * \else
	 * 通道号
	 * \endif
	 */
	public int				nChannelID;
	
	/**
	 * \if ENGLISH_LANG
	 * Event name
	 * \else
	 * 事件名称
	 * \endif
	 */
	public byte				szName[] = new byte[128];
	
	/**
	 * \if ENGLISH_LANG
	 * PTS(ms)
	 * \else
	 * 时间戳(单位是毫秒)
	 * \endif
	 */
	public double			PTS;
	
	/**
	 * \if ENGLISH_LANG
	 * The event happen time
	 * \else
	 * 事件发生的时间
	 * \endif
	 */
	public NET_TIME_EX		UTC = new NET_TIME_EX();
	
	/**
	 * \if ENGLISH_LANG
	 * Event ID
	 * \else
	 * 事件ID
	 * \endif
	 */
	public int				nEventID;
	
	/**
	 * \if ENGLISH_LANG
	 * Have being detected object
	 * \else
	 * 检测到的物体
	 * \endif
	 */
	public SDK_MSG_OBJECT	stuObject = new SDK_MSG_OBJECT();
	
	/**
	 * \if ENGLISH_LANG
	 * Road number
	 * \else
	 * 对应车道号
	 * \endif
	 */
	public int				nLane;
	
	/**
	 * \if ENGLISH_LANG
	 * <pre>
	 * BreakingRule's mask,first byte: crash red light; 
	 * secend byte:break the rule of driving road number; 
	 * the third byte:converse; the forth byte:break rule to turn around;
	 * the five byte:traffic jam; the six byte:traffic vacancy; 
	 * the seven byte: Overline; defalt:trafficJunction    
	 * </pre>
	 * \else
	 * <pre>
  	 * 违反规则掩码,第一位:闯红灯; 
     * 第二位:不按规定车道行驶;
     * 第三位:逆行; 第四位：违章掉头;
	 * 第五位:交通堵塞; 第六位:交通异常空闲
     * 第七位:压线行驶; 否则默认为:交通路口事件
     * </pre>
	 * \endif
	 */
	public int				dwBreakingRule;
	
	/**
	 * \if ENGLISH_LANG
	 * The begin time of red light
	 * \else
	 * 红灯开始UTC时间
	 * \endif
	 */
	public NET_TIME_EX			RedLightUTC = new NET_TIME_EX();
	
	/**
	 * \if ENGLISH_LANG
	 * Event file info
	 * \else
	 * 事件对应文件信息
	 * \endif
	 */
	public SDK_EVENT_FILE_INFO  	stuFileInfo = new SDK_EVENT_FILE_INFO();
	
	/**
	 * \if ENGLISH_LANG
	 * Snap index,such as 3,2,1,1 means the last one,0 means there has some exception and snap stop
	 * \else
	 * 表示抓拍序号，如3,2,1,1表示抓拍结束,0表示异常结束
	 * \endif
	 */
	public int                 	nSequence;
	
	/**
	 * \if ENGLISH_LANG
	 * Car's speed (km/h)
	 * \else
	 * 端车辆实际速度Km/h  
	 * \endif
	 */
	public int                 	nSpeed;
	
	/**
	 * \if ENGLISH_LANG
	 * Event action,0 means pulse event,1 means continuous event's begin,2means continuous event's end;
	 * \else
	 * 事件动作，0表示脉冲事件,1表示持续性事件开始,2表示持续性事件结束;
	 * \endif
	 */
	public byte                	bEventAction;
	
	/**
	 * \if ENGLISH_LANG
	 * Picture no.,, within same time(second)may have multiple pictures, from 0 to
	 * \else
	 * 图片的序号, 同一时间内(精确到秒)可能有多张图片, 从0开始
	 * \endif
	 */
	public byte					byImageIndex;
	
	/**
	 * \if ENGLISH_LANG
	 * Vehicle info
	 * \else
	 * 车身信息
	 * \endif
	 */
	public SDK_MSG_OBJECT       	stuVehicle = new SDK_MSG_OBJECT();
	
	/**
	 * \if ENGLISH_LANG
	 * Flag(by bit),see NET_RESERVED_COMMON
	 * \else
	 * 抓图标志(按位)，具体见NET_RESERVED_COMMON	
	 * \endif
	 */
    public int               	dwSnapFlagMask;
    
	/**
	 * \if ENGLISH_LANG
	 * Picture resolution
	 * \else
	 * 对应图片的分辨率
	 * \endif
	 */
	public SDK_RESOLUTION_INFO 	stuResolution = new SDK_RESOLUTION_INFO();
	
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 报警对应的原始录像文件信息
	 * \endif
	 */
	public byte                	szRecordFile[] = new byte[FinalVar.SDK_COMMON_STRING_128];
	
	/**
	 * \if ENGLISH_LANG
	 * Traffic vehicle info
	 * \else
	 * 交通车辆信息
	 * \endif
	 */
	public DEV_EVENT_TRAFFIC_TRAFFICCAR_INFO stTrafficCar = new DEV_EVENT_TRAFFIC_TRAFFICCAR_INFO();
	
	/**
	 * \if ENGLISH_LANG
	 * Card quantity
	 * \else
	 * 卡片个数
	 * \endif
	 */
	public int               	dwRetCardNumber;
	
	/**
	 * \if ENGLISH_LANG
	 * Card Info
	 * \else
	 * 卡片信息
	 * \endif
	 */
    public EVENT_CARD_INFO     	stuCardInfo[] = new EVENT_CARD_INFO[FinalVar.SDK_EVENT_MAX_CARD_NUM];
    
    public DEV_EVENT_TRAFFICJUNCTION_INFO() {
    	for (int i = 0; i < FinalVar.SDK_EVENT_MAX_CARD_NUM; i++) {
    		stuCardInfo[i] = new EVENT_CARD_INFO();
    	}
    }
}
