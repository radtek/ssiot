package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Channel Name Structure
 * \else
 * 通道名称
 * \endif
 */
public class AV_CFG_ChannelName implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * \if ENGLISH_LANG
	 * Camera Unique Number 
	 * \else
	 * 摄像头唯一编号 
	 * \endif
	 */
	public int				nSerial;
	
	/**
	 * \if ENGLISH_LANG
	 * Channel
	 * \else
	 * 通道名
	 * \endif
	 */
	public byte				szName[] = new byte[FinalVar.AV_CFG_Channel_Name_Len];
}
