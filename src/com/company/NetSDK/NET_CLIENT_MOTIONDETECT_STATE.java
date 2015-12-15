package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Corresponding structure of motion detect alarm status info
 * \else
 * 动态检测报警状态信息对应结构体
 * \endif
 */
public class NET_CLIENT_MOTIONDETECT_STATE implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Channel amount
	 * \else
	 * 通道个数
	 * \endif
	 */
	public int				channelcount;
	
	/**
	 * \if ENGLISH_LANG
	 * DWORD value is the state by bit of 32 channels,0-no alarm,1-alarm
	 * \else
	 * 每一个int按位表示32通道的报警状态, 0-表示无报警, 1-表示有报警
	 * \endif
	 */
	public int              dwAlarmState[] = new int[FinalVar.SDK_MAX_CHANMASK];
}
