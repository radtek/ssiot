package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Netabort Alarm Configuration
 * \else
 * 网络断开报警配置
 * \endif
 */
public class CFG_NETABORT_INFO implements Serializable {
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
	public boolean					bEnable;
	
 	/**
	 * \if ENGLISH_LANG
	 * Event Handler  
	 * \else
	 * 报警联动
	 * \endif
	 */
	public CFG_ALARM_MSG_HANDLE	stuEventHandler = new CFG_ALARM_MSG_HANDLE();
}
