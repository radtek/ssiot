package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * No HDD Alarm Linkage Configuration 
 * \else
 * 无硬盘报警联动配置
 * \endif
 */
public class CFG_STORAGENOEXIST_INFO implements Serializable {
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
	public boolean				 bEnable;
	
 	/**
	 * \if ENGLISH_LANG
	 * Event Handler 
	 * \else
	 * 报警联动
	 * \endif
	 */
	public CFG_ALARM_MSG_HANDLE stuEventHandler = new CFG_ALARM_MSG_HANDLE();							    
}