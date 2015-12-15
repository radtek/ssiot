package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Alarm configuration
 * \else
 * 警号配置
 * \endif
 */
public class CFG_ALARMBELL_INFO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Duty cycle
	 * \else
	 * 警号输出持续时间, 单位: 分钟(0-99), 0 表示响一下就停止
	 * \endif
	 */
	public int nPersistentTime;
}
