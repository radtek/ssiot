package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * front IPC disconnect alarm info
 * \else
 * 前端断网报警信息
 * \endif
 */
public class ALARM_FRONTDISCONNET_INFO implements Serializable {
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
	public int                nChannelID;
	
 	/**
	 * \if ENGLISH_LANG
	 * 0:stop 1:start	
	 * \else
	 * 0:开始 1:停止
	 * \endif
	 */
	public int                nAction;
	
 	/**
	 * \if ENGLISH_LANG
	 * event happen time
	 * \else
	 * 事件发生时间
	 * \endif
	 */
	public NET_TIME           stuTime = new NET_TIME();
	
 	/**
	 * \if ENGLISH_LANG
	 * front IP's address
	 * \else
	 * 前端IPC的IP地址
	 * \endif
	 */
	public byte               szIpAddress[] = new byte[FinalVar.MAX_PATH];
}
