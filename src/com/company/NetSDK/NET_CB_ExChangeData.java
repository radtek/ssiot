package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Port serial number
 * \else
 * ¶Ë¿ÚÐòºÅ
 * \endif
 */
public class NET_CB_ExChangeData implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * ¶Ë¿ÚÐòºÅ
	 * \endif
	 */
	public int					nDataLength;
	
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * ¶Ë¿ÚÐòºÅ
	 * \endif
	 */
	public String				pRevData;
}
