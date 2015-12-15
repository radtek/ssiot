package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Camera Displacement Alarm Event Struction
 * \else
 * 摄像机移位报警事件
 * \endif
 */
public class ALARM_CAMERA_MOVE_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

 	/**
	 * \if ENGLISH_LANG
	 * Alarming Channel Numbers 
	 * \else
	 * 报警发生通道数
	 * \endif
	 */
	public int                         nChannelNum;
	
 	/**
	 * \if ENGLISH_LANG
	 * Alarming Channel Info 
	 * \else
	 * 发生报警通道号信息
	 * \endif
	 */
	public byte               alarmChannels[] = new byte[FinalVar.SDK_MAX_CHANNUM_EX];
}
