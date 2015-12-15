package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Storage crash event
 * \else
 * 存储崩溃事件
 * \endif
 */
public class ALARM_STORAGE_BREAK_DOWN_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * 0:start 1:stop
	 * \else
	 * 0:开始 1:停止
	 * \endif
	 */
	public int                  nAction;
}
