package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * disk flux abnormal
 * \else
 * 硬盘流量异常事件
 * \endif
 */
public class ALARM_DISK_FLUX implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

 	/**
	 * \if ENGLISH_LANG
	 * 0-start, 1-stop
	 * \else
	 * 0-开始, 1-停止
	 * \endif
	 */
	public int                dwAction;
	
 	/**
	 * \if ENGLISH_LANG
	 * data flux,KB	
	 * \else
	 * 当前数据流量, KB
	 * \endif
	 */
	public int                dwDataFlux;
	
 	/**
	 * \if ENGLISH_LANG
	 * time
	 * \else
	 * 事件发生时间
	 * \endif
	 */
	public NET_TIME             stuTime = new NET_TIME(); 
}
