package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Port serial number
 * \else
 * 监听CAN总线数据
 * \endif
 */
public class NET_CB_CANDATA implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 普通数据长度
	 * \endif
	 */
	public int					nDataLength;
	
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 普通数据内容
	 * \endif
	 */
	public char[]				pDataContent;
}
