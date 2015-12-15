package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Record Mode
 * \else
 * 录像模式
 * \endif
 */
public class AV_CFG_RecordMode implements Serializable {

 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * \if ENGLISH_LANG
	 * Record Mode, 0-Auto Record，1-Mannul Record，2-Shutdown Record 
	 * \else
	 * 录像模式, 0-自动录像，1-手动录像，2-关闭录像 
	 * \endif
	 */
	public int					nMode;
}