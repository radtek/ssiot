package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Record Source Structure
 * \else
 * 录像源
 * \endif
 */
public class AV_CFG_RecordSource implements Serializable {
	
 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * \if ENGLISH_LANG
	 * Enable 
	 * \else
	 * 使能
	 * \endif
	 */
	public boolean			bEnable;
	
 	/**
	 * \if ENGLISH_LANG
	 * Device ID 
	 * \else
	 * 设备ID
	 * \endif
	 */
	public byte[]			szDeviceID = new byte[FinalVar.AV_CFG_Device_ID_Len];
	
 	/**
	 * \if ENGLISH_LANG
	 * Video Channel No. 
	 * \else
	 * 视频通道号
	 * \endif
	 */
	public int				nVideoChannel;
	
 	/**
	 * \if ENGLISH_LANG
	 * Video Stream 	
	 * \else
	 * 视频码流
	 * \endif
	 */
	public int				nVideoStream;
	
 	/**
	 * \if ENGLISH_LANG
	 * Audio Channle No. 
	 * \else
	 * 音频通道号
	 * \endif
	 */
	public int				nAudioChannle;
	
 	/**
	 * \if ENGLISH_LANG
	 * AudioStream 
	 * \else
	 * 音频码流
	 * \endif
	 */
	public int				nAudioStream;
}

