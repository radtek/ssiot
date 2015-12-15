package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Limit HDD Alarm Linkage Configuration
 * \else
 * 存储设备空间不足报警配置
 * \endif
 */
public class CFG_STORAGELOWSAPCE_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

 	/**
	 * \if ENGLISH_LANG
	 * Enable 
	 * \else
	 * 使能开关
	 * \endif
	 */
	public boolean				bEnable;
	
 	/**
	 * \if ENGLISH_LANG
	 * Lower Limit, Percentage(0~99) 
	 * \else
	 * 硬盘剩余容量下限，百分数(0~99)
	 * \endif
	 */
	public int					nLowerLimit;
	
 	/**
	 * \if ENGLISH_LANG
	 * Event Handler 
	 * \else
	 * 报警联动	
	 * \endif
	 */
	public CFG_ALARM_MSG_HANDLE stuEventHandler = new CFG_ALARM_MSG_HANDLE();
}
