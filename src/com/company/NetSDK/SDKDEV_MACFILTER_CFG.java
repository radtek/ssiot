package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * MAC filter configuration
 * \else
 * MAC过滤配置结构体
 * \endif
 */
public class SDKDEV_MACFILTER_CFG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * enable
	 * \else
	 * 使能
	 * \endif
	 */
	public int                 dwEnable;

	/**
	 * \if ENGLISH_LANG
	 * current list type,0:white list, 1:blacklist (The device can enable only one type of list) can only user one kind of device
	 * \else
	 * 当前名单类型：0：白名单 1：黑名单（设备只能使一种名单生效，或者是白名单或者是黑名单）
	 * \endif
	 */
	public int                 dwType;

	/**
	 * \if ENGLISH_LANG
	 * black list Mac
	 * \else
	 * 黑名单Mac
	 * \endif
	 */
	public MACFILTER_INFO        stuBannedMac = new MACFILTER_INFO();

	/**
	 * \if ENGLISH_LANG
	 * white list Mac
	 * \else
	 * 白名单Mac
	 * \endif
	 */
	public MACFILTER_INFO        stuTrustMac = new MACFILTER_INFO();
}
