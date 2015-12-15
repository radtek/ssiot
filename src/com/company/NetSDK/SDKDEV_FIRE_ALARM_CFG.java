package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * fire alarm
 * \else
 * 火警报警
 * \endif
 */
public class SDKDEV_FIRE_ALARM_CFG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * enable
	 * \else
	 * 火警报警时能；
	 * \endif
	 */
	public boolean                byFireEn; 
	
	/**
	 * \if ENGLISH_LANG
	 * handler
	 * \else
	 * 处理方式
	 * \endif
	 */
	public SDK_MSG_HANDLE_EX    struHandle = new SDK_MSG_HANDLE_EX(); 
}
