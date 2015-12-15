package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * INetSDK.ControlDevice port SDK_CTRL_START_ALARMBELL、SDK_CTRL_STOP_ALARMBELL command parameter
 * \else
 * INetSDK.ControlDevice接口的 SDK_CTRL_START_ALARMBELL、SDK_CTRL_STOP_ALARMBELL命令参数
 * \endif
 */
public class NET_CTRL_ALARMBELL implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Channel ID (start from 0) 
	 * \else
	 * 通道号(0开始)      
	 * \endif
	 */
	public int					nChannelID;			
}
