package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * IP Filtering configuration
 * \else
 * IP过滤配置结构体
 * \endif
 */
public class SDKDEV_IPIFILTER_CFG implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Enable
	 * \else
	 * 使能
	 * \endif
	 */
	public int               dwEnable;

	/**
	 * \if ENGLISH_LANG
	 * The current list type;0:White List 1:Blacklist(The device can enable only one type of list)
	 * \else
	 * 当前名单类型：0：白名单 1：黑名单（设备只能使一种名单生效，或者是白名单或者是黑名单）
	 * \endif
	 */
	public int               dwType;

	/**
	 * \if ENGLISH_LANG
	 * Black list
	 * \else
	 * 黑名单
	 * \endif
	 */
	public IPIFILTER_INFO      BannedIP = new IPIFILTER_INFO();

	/**
	 * \if ENGLISH_LANG
	 * Trusted sites
	 * \else
	 * 白名单
	 * \endif
	 */
	public IPIFILTER_INFO      TrustIP = new IPIFILTER_INFO();
}
