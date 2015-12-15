package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Pic resolution 
 * \else
 * Í¼Æ¬·Ö±æÂÊ
 * \endif
 */
public class SDK_RESOLUTION_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Width
	 * \else
	 * ¿í
	 * \endif
	 */
	public short   snWidth;
	
	/**
	 * \if ENGLISH_LANG
	 * Hight
	 * \else
	 * ¸ß
	 * \endif
	 */
	public short   snHight;
}
