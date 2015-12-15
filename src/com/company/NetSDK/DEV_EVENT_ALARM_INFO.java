package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * the describe of EVENT_ALARM_LOCALALARM and EVENT_ALARM_MOTIONALARM's data
 * \else
 * 报警事件类型 EVENT_ALARM_LOCALALARM(外部报警)，EVENT_ALARM_MOTIONALARM(动检报警)报警)
 * \endif
 */
public class DEV_EVENT_ALARM_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * channel id
	 * \else
	 * 通道号
	 * \endif
	 */
	public int                 nChannelID;
	
	/**
	 * \if ENGLISH_LANG
	 * evnent name
	 * \else
	 * 事件名称
	 * \endif
	 */
	public byte                szName[] = new byte[128];
	
	/**
	 * \if ENGLISH_LANG
	 * PTS(ms)
	 * \else
	 * 时间戳(单位是毫秒)
	 * \endif
	 */
	public double              PTS;
	
	/**
	 * \if ENGLISH_LANG
	 * the event happen time
	 * \else
	 * 事件发生的时间
	 * \endif
	 */
	public NET_TIME_EX         UTC = new NET_TIME_EX();
	
	/**
	 * \if ENGLISH_LANG
	 * evnet ID 
	 * \else
	 * 事件ID
	 * \endif
	 */
	public int                 nEventID;
}
