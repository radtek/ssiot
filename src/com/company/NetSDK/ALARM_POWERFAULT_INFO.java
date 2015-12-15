package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Power Failure Event
 * \else
 * 电源故障事件
 * \endif
 */
public class ALARM_POWERFAULT_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Power Type {@link com.company.NetSDK.EM_POWER_TYPE EM_POWER_TYPE}
	 * \else
	 * 电源类型 {@link com.company.NetSDK.EM_POWER_TYPE EM_POWER_TYPE}
	 * \endif
	 */
	public int            emPowerType;
	
	/**
	 * \if ENGLISH_LANG
	 * Power Failure Event {@link com.company.NetSDK.EM_POWERFAULT_EVENT_TYPE EM_POWERFAULT_EVENT_TYPE}
	 * \else
	 * 电源故障事件 {@link com.company.NetSDK.EM_POWERFAULT_EVENT_TYPE EM_POWERFAULT_EVENT_TYPE}
	 * \endif
	 */
	public int            emPowerFaultEvent;
	
	/**
	 * \if ENGLISH_LANG
	 * Alarm Event Time
	 * \else
	 * 报警事件发生的时间
	 * \endif
	 */
	public NET_TIME                 stuTime = new NET_TIME();
	
	/**
	 * \if ENGLISH_LANG
	 * 0:start 1: stop
	 * \else
	 * 0:开始 1:停止
	 * \endif
	 */
	public int                      nAction;
}
