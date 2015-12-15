package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * HDD Error Alarm Linkage Configuration
 * \else
 * 存储设备访问出错报警配置
 * \endif
 */
public class CFG_STORAGEFAILURE_INFO implements Serializable {
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
	 * Event Handle 
	 * \else
	 * 报警联动	
	 * \endif
	 */
	public CFG_ALARM_MSG_HANDLE stuEventHandler = new CFG_ALARM_MSG_HANDLE();
}