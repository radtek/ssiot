package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * The length of the video package configuration
 * \else
 * 录像打包长度配置
 * \endif
 */
public class SDKDEV_RECORD_PACKET_CFG implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * 0:by time,1:by size
	 * \else
	 * 0:按时间，1：按大小
	 * \endif
	 */
	public int                 nType; 
	
	/**
	 * \if ENGLISH_LANG
	 * nType = 0:(minutes),nType = 1:(KB)
	 * \else
	 * nType = 0时:单位分钟，nType = 1时:单位KB
	 * \endif
	 */
	public int                 nValue; 
}
