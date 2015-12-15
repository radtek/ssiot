package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * INetSDK.ControlDevice's param SDK_CTRL_MULTIPLAYBACK_CHANNALES 
 * \else
 * INetSDK.ControlDevice接口的 SDK_CTRL_MULTIPLAYBACK_CHANNALES 命令参数 
 * \endif
 */
public class NET_CTRL_MULTIPLAYBACK_CHANNALES implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Playback Handle，CLIENT_MultiPlayBack Returns the Value
	 * \else
	 * 回放句柄，CLIENT_MultiPlayBack接口返回值
	 * \endif
	 */
	public long     	lPlayBackHandle; 
	
	/**
	 * \if ENGLISH_LANG
	 * Preview Channel ID
	 * \else
	 * 预览通道号
	 * \endif
	 */
	public int        	nChannels[] = new int[FinalVar.SDK_MAX_MULTIPLAYBACK_CHANNEL_NUM];
	
	/**
	 * \if ENGLISH_LANG
	 * Preview Channel Number 
	 * \else
	 * 预览通道数 
	 * \endif
	 */
	public int      	nChannelNum; 
}
