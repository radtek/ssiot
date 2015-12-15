package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * INetSDK.ControlDevice's param: SDK_CTRL_ACCESS_OPEN
 * \else
 * INetSDK.ControlDevice接口的 SDK_CTRL_ACCESS_OPEN 命令参数
 * \endif
 */
public class NET_CTRL_ACCESS_OPEN implements Serializable {
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
	
	/**
	 * \if ENGLISH_LANG
	 * Target ID, NULL equals to not transmit
	 * \else
	 * 转发目标设备ID,为NULL表示不转发
	 * \endif
	 */
    public String               szTargetID;
}
