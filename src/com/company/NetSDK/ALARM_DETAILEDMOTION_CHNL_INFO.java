package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Detailed Motion Detection Alarm Info
 * \else
 * 详细动检报警信息
 * \endif
 */

public class ALARM_DETAILEDMOTION_CHNL_INFO implements Serializable {
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
	public int                nChannelID;
	
 	/**
	 * \if ENGLISH_LANG
	 * If Alarm TRUE/FALSE 
	 * \else
	 * 是否报警 TRUE/FALSE
	 * \endif
	 */
	public boolean               bAlarm;
	
 	/**
	 * \if ENGLISH_LANG
	 * Alarm Level,Unit ,Calculate By the Small Grid Numbers of Motion Detect Divide Total Numbers of Small Grid
	 * \else
	 * 报警级别，单位千分之，以动检发生小格数除以总小格数计算
	 * \endif
	 */
	public int                nLevel;        
}
