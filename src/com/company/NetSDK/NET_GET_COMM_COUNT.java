package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Port serial number
 * \else
 * 设备信息
 * \endif
 */
public class NET_GET_COMM_COUNT implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 获取到的串口数
	 * \endif
	 */
	public int				nChannelCout;		 
}
