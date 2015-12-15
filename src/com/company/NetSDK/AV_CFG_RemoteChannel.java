package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Remote Channel Structure
 * \else
 * 远程通道
 * \endif
 */
public class AV_CFG_RemoteChannel implements Serializable {
	
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
	public boolean		bEnable;
	
 	/**
	 * \if ENGLISH_LANG
	 * Device ID 
	 * \else
	 * 设备ID
	 * \endif
	 */
	public byte[]		szDeviceID = new byte[FinalVar.AV_CFG_Device_ID_Len];
	
 	/**
	 * \if ENGLISH_LANG
	 * Channel No. 
	 * \else
	 * 通道号
	 * \endif
	 */
	public int			nChannel;
}

