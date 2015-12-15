package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * SDK_DEV_GPS_MODE_CFG configuration
 * \else
 * SDK_DEV_GPS_MODE_CFG 配置结构
 * \endif
 */
public class SDKDEV_GPS_MODE_CFG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * GPS mode
	 * \else
	 * GPS定位模式，见GPS_MODE
	 * \endif
	 */
	public byte                byGPSMode; 
}
