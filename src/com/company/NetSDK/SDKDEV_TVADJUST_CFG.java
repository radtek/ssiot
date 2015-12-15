package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * TV adjust
 * \else
 * µ÷½ÚTVÊä³ö
 * \endif
 */
public class SDKDEV_TVADJUST_CFG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * top(0 - 100)
	 * \else
	 * ÉÏ²â±ß¾à£¨0£­100£©
	 * \endif
	 */
	public int             nTop;

	/**
	 * \if ENGLISH_LANG
	 * botton(0 - 100)
	 * \else
	 * ÏÂ²â±ß¾à£¨0£­100£©
	 * \endif
	 */
	public int             nBotton;

	/**
	 * \if ENGLISH_LANG
	 * left(0 - 100)
	 * \else
	 * ×ó²â±ß¾à£¨0£­100£©
	 * \endif
	 */
	public int             nLeft;

	/**
	 * \if ENGLISH_LANG
	 * right(0 - 100)
	 * \else
	 * ÓÒ²â±ß¾à£¨0£­100£©
	 * \endif
	 */
	public int             nRight;
}
