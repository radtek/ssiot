package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Local Alarm Event(对SDK_ALARM_ALARM_EX upgrade)
 * \else
 * 本地报警事件(对SDK_ALARM_ALARM_EX升级)
 * \endif
 */
public class ALARM_ALARM_INFO_EX2 implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Channel No.
	 * \else
	 * 通道号
	 * \endif
	 */
	public int                 nChannelID;
	
	/**
	 * \if ENGLISH_LANG
	 * 0: start 1: stop
	 * \else
	 * 0:开始 1:停止
	 * \endif
	 */
	public int                 nAction;
	
	/**
	 * \if ENGLISH_LANG
	 * Alarm Event Time
	 * \else
	 * 报警事件发生的时间
	 * \endif
	 */
	public NET_TIME            stuTime = new NET_TIME();
	
	/**
	 * \if ENGLISH_LANG
	 * Sensor Type {@link com.company.NetSDK.NET_SENSE_METHOD NET_SENSE_METHOD}
	 * \else
	 * 传感器类型 {@link com.company.NetSDK.NET_SENSE_METHOD NET_SENSE_METHOD}
	 * \endif
	 */
	public int                 emSenseType;
}
