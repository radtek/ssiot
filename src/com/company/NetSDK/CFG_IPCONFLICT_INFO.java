package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * IP Conflict Alarm Linkage Configuration 
 * \else
 * IP冲突报警配置
 * \endif
 */
public class CFG_IPCONFLICT_INFO implements Serializable {
 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Enable Switch 
	 * \else
	 * 使能开关
	 * \endif
	 */
	public boolean 					bEnable;
	
 	/**
	 * \if ENGLISH_LANG
	 * Alarm Linkage 
	 * \else
	 * 报警联动
	 * \endif
	 */
	public CFG_ALARM_MSG_HANDLE		stuEventHandler = new CFG_ALARM_MSG_HANDLE();
}
