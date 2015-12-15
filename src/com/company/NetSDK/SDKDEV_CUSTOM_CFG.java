package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * custom configuration
 * \else
 * 用户自定义配置
 * \endif
 */
public class SDKDEV_CUSTOM_CFG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * custom configuration information
	 * \else
	 * 用户自定义配置信息
	 * \endif
	 */
	public byte                   szData[] = new byte[1024]; 
}
