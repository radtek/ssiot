package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Year
 * \else
 * ÂÖÑ²¿ØÖÆÀàÐÍ
 * \endif
 */
public class DEC_CTRL_TOUR_TYPE implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * stop
	 * \else
	 * Í£Ö¹
	 * \endif
	 */
	public static final int     Dec_Tour_Stop = 0;
	
	/**
	 * \if ENGLISH_LANG
	 * start
	 * \else
	 * ¿ªÊ¼
	 * \endif
	 */
	public static final int     Dec_Tour_Start = 1;
	
	/**
	 * \if ENGLISH_LANG
	 * pause
	 * \else
	 * ÔÝÍ£
	 * \endif
	 */
	public static final int     Dec_Tour_Pause = 2;
	
	/**
	 * \if ENGLISH_LANG
	 * resume
	 * \else
	 * »Ö¸´
	 * \endif
	 */
	public static final int     Dec_Tour_Resume = 3;
}
