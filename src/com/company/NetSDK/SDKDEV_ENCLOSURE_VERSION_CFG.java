package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * enclosure version config
 * \else
 * 电子围栏版本号配置 
 * \endif
 */
public class SDKDEV_ENCLOSURE_VERSION_CFG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * type mask,such as LIMITSPEED | DRIVEALLOW
	 * \else
	 * 围栏类型掩码，如LIMITSPEED | DRIVEALLOW
	 * \endif
	 */
	public int          unType; 
	
	/**
	 * \if ENGLISH_LANG
	 * version
	 * \else
	 * 每个类型一个版本号,用于统一平台与设备上的围栏配置
	 * \endif
	 */
	public int          unVersion[] = new int[32]; 
}
