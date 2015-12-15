package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * decode policy configuration
 * \else
 * 机器相关的配置
 * \endif
 */
public class SDKDEV_DECODEPOLICY_CFG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * (read only):minimal delay time(ms)
	 * \else
	 * 码缓冲时间范围(只读)：最小缓冲时间(单位：ms)
	 * \endif
	 */
	public int                 nMinTime;

	/**
	 * \if ENGLISH_LANG
	 * (read only):maximal delay time(ms)
	 * \else
	 * 码缓冲时间范围(只读)：最大缓冲时间(单位：ms)
	 * \endif
	 */
	public int                 nMaxTime;

	/**
	 * \if ENGLISH_LANG
	 * device decode delay time(ms)
	 * \else
	 * 目标设备解码缓冲时间(单位：ms)
	 * \endif
	 */
	public int                 nDeocdeBufTime;
}
