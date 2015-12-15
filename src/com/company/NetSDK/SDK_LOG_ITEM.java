package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Log information. Corresponding to QueryLog
 * \else
 * 日志信息
 * \endif
 */
public class SDK_LOG_ITEM implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Date
	 * \else
	 * 日期
	 * \endif
	 */
	public SDKDEVTIME			time;									
	/**
	 * \if ENGLISH_LANG
	 * Type
	 * \else
	 * 类型
	 * \endif
	 */
	public short				type;									
	/**
	 * \if ENGLISH_LANG
	 * Reserved
	 * \else
	 * 保留
	 * \endif
	 */
	public char				reserved;								
	/**
	 * \if ENGLISH_LANG
	 * Data
	 * \else
	 * 数据
	 * \endif
	 */
	public char				data;									
	/**
	 * \if ENGLISH_LANG
	 * Content
	 * \else
	 * 内容
	 * \endif
	 */
	public char				context[] = new char[8];				
}
