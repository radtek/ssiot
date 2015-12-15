package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * limit stream configuration
 * \else
 * 限码流配置
 * \endif
 */
public class SDKDEV_LIMIT_BIT_RATE implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * limit stream (kps)
	 * \else
	 * 限制码流，单位kps
	 * \endif
	 */
    public int                   nExpectCodeRate; 
}
