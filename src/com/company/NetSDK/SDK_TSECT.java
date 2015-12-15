package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Time period structure 
 * \else
 * 时间段结构	
 * \endif
 */
public class SDK_TSECT implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * \if ENGLISH_LANG
	 * Current record period . Bit means the four Enable functions. From the low bit to the high bit:Motion detection record, alarm record and general record, when Motion detection and alarm happened at the same time can record.
	 * \else
	 * 当表示录像时间段时，按位表示四个使能，从低位到高位分别表示动检录象、报警录象、普通录象、动检和报警同时发生才录像
	 * \endif
	 */
	public boolean				bEnable;				
	public int					iBeginHour;
	public int					iBeginMin;
	public int					iBeginSec;
	public int					iEndHour;
	public int					iEndMin;
	public int					iEndSec;
}
