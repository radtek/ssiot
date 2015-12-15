package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * INetSDK.ControlDevice's param: SDK_CTRL_STOP_VIDEO_ANALYSE 
 * \else
 * INetSDK.ControlDevice接口的 SDK_CTRL_STOP_VIDEO_ANALYSE 命令参数
 * \endif
 */
public class NET_CTRL_STOP_VIDEO_ANALYSE implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Channel ID  
	 * \else
	 * 通道号  
	 * \endif
	 */
	public int                 nChannelId;  
}
