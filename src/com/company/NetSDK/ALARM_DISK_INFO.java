package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * disk alarm
 * \else
 * ”≤≈Ã±®æØ
 * \endif
 */
public class ALARM_DISK_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

 	/**
	 * \if ENGLISH_LANG
	 * channel number
	 * \else
	 * ”≤≈ÃÕ®µ¿∫≈
	 * \endif
	 */
	public int                nChannel;
	
 	/**
	 * \if ENGLISH_LANG
	 * number, 0: main trank,1: extern trank1, 2: extern trank2 
	 * \else
	 * ¥≈≈Ã¡–’Û∫≈, 0: ÷˜πÒ£¨1: ¿©’ππÒ1,  2: ¿©’ππÒ2 
	 * \endif
	 */
	public int                nHDDNumber;
	
 	/**
	 * \if ENGLISH_LANG
	 * state, 0: Unknown, 1: Running, 2: Offline, 3: Warning, 4: Failed
	 * \else
	 * ”≤≈Ã◊¥Ã¨, 0: Unknown, 1: Running, 2: Offline, 3: Warning, 4: Failed
	 * \endif
	 */
	public int                nHDDState;                           
}
