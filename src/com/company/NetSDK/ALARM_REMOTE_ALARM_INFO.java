package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * alarm of remote 
 * \else
 * 远程外部报警信息
 * \endif
 */
public class ALARM_REMOTE_ALARM_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

 	/**
	 * \if ENGLISH_LANG
	 * channel ID,from 1
	 * \else
	 * 通道号，从1开始
	 * \endif
	 */
	public int        nChannelID;
	
 	/**
	 * \if ENGLISH_LANG
	 * state,0-reset,1-setting
	 * \else
	 * 报警状态，0-报警复位，1-报警置位
	 * \endif
	 */
	public int        nState;
}
