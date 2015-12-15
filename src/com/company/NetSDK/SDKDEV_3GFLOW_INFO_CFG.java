package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * 3G Flow info config
 * \else
 * 3G流量信息配置
 * \endif
 */
public class SDKDEV_3GFLOW_INFO_CFG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * strategy, 0: charged by flow every month 1:charged by time every month
	 * \else
	 * 流量使用策略, 0:按流量包月 1:按时间包月
	 * \endif
	 */
	public int                 nStrategy;
	
	/**
	 * \if ENGLISH_LANG
	 * up limit, by flow: MB, by time: h
	 * \else
	 * 流量使用上限, 按流量: 单位MB 按时间: 单位小时
	 * \endif
	 */
	public int                 nUpLimit;
}
