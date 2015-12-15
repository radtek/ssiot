package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * black list snap info
 * \else
 * 黑名单车辆抓拍事件
 * \endif
 */
public class SDK_BLACKLIST_SNAP_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

 	/**
	 * \if ENGLISH_LANG
	 * number of plate
	 * \else
	 * 车牌号
	 * \endif
	 */
	public byte      szPlateNumber[] = new byte[32];                          
 	/**
	 * \if ENGLISH_LANG
	 * time
	 * \else
	 * 事件发生时间
	 * \endif
	 */
	public NET_TIME  stuTime = new NET_TIME();                                    
}
