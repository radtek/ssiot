package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Sensor Alarm Way
 * \else
 * 传感器报警方式
 * \endif
 */
public class CFG_ALARM_SENSE_METHOD implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * \if ENGLISH_LANG
	 * The Number of Supported Sensors Way
	 * \else
	 * 支持的传感器方式数
	 * \endif
	 */
	public int                 nSupportSenseMethodNum;
	
	/**
	 * \if ENGLISH_LANG
	 * Supported Sensor Way
	 * \else
	 * 支持的传感器方式
	 * \endif
	 */
	public int                 emSupportSenseMethod[] = new int[FinalVar.MAX_ALARM_SENSE_METHOD_NUM];
}
