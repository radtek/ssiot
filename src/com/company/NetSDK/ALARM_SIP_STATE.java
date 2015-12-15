package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * SIP Status Changes Alarm
 * \else
 * SIP状态改变报警
 * \endif
 */
public class ALARM_SIP_STATE implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

 	/**
	 * \if ENGLISH_LANG
	 * Channel No. 
	 * \else
	 * 通道号
	 * \endif
	 */
	public int     nChannelID;
	
 	/**
	 * \if ENGLISH_LANG
	 * 0:Registration Succeed,1:Not Registered,2:Invalid,3:Registering,4:Communicating 
	 * \else
	 * 0:注册成功,1:未注册,2:无效,3:注册中,4:通话中
	 * \endif
	 */
	public byte    byStatus;                         
}
