package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Intrusion Event Detail
 * \else
 * 闯入事件详细信息
 * \endif
 */
public class ALARM_ACCESS_CTL_BREAK_IN_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Door Channel No.
	 * \else
	 * 门通道号
	 * \endif
	 */
	public int             nDoor;
	
	/**
	 * \if ENGLISH_LANG
	 * Access Control Name
	 * \else
	 * 门禁名称
	 * \endif
	 */
	public byte            szDoorName[] = new byte[FinalVar.SDK_MAX_DOORNAME_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Alarm Event Time
	 * \else
	 * 报警事件发生的时间
	 * \endif
	 */
	public NET_TIME        stuTime = new NET_TIME();
}
