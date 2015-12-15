package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Period
 * \else
 * 时间段
 * \endif
 */
public class AV_CFG_TimeSection implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Sub Mask
	 * \else
	 * 掩码
	 * \endif
	 */
	public int			nMask;
	
	/**
	 * \if ENGLISH_LANG
	 * Begin hour
	 * \else
	 * 开始时间
	 * \endif
	 */
	public int			nBeginHour;
	
	public int			nBeginMinute;
	
	public int			nBeginSecond;
	
	/**
	 * \if ENGLISH_LANG
	 * End hour
	 * \else
	 * 结束时间
	 * \endif
	 */
	public int			nEndHour;
	
	public int			nEndMinute;
	
	public int			nEndSecond;
}
