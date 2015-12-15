package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * available according to the source of information
 * \else
 * 可用的显示源信息
 * \endif
 */
public class SDK_MATRIX_CAMERA_INFO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * \if ENGLISH_LANG
	 * name
	 * \else
	 * 名称
	 * \endif
	 */
	public byte                szName[] = new byte[FinalVar.SDK_DEV_ID_LEN_EX];

	/**
	 * \if ENGLISH_LANG
	 * device ID
	 * \else
	 * 设备ID
	 * \endif
	 */
	public byte                szDevID[] = new byte[FinalVar.SDK_DEV_ID_LEN_EX];

	/**
	 * \if ENGLISH_LANG
	 * control ID
	 * \else
	 * 控制ID
	 * \endif
	 */
	public byte                szControlID[] = new byte[FinalVar.SDK_DEV_ID_LEN_EX];

	/**
	 * \if ENGLISH_LANG
	 * channel ID, DeviceID is unique
	 * \else
	 * 通道号, DeviceID设备内唯一
	 * \endif
	 */
	public int                 nChannelID;

	/**
	 * \if ENGLISH_LANG
	 * unique channel
	 * \else
	 * 设备内统一编号的唯一通道号
	 * \endif
	 */
	public int                 nUniqueChannel;

	/**
	 * \if ENGLISH_LANG
	 * support remote device or not
	 * \else
	 * 是否远程设备
	 * \endif
	 */
	public boolean                bRemoteDevice;

	/**
	 * \if ENGLISH_LANG
	 * info of remote device
	 * \else
	 * 远程设备信息
	 * \endif
	 */
	public SDK_REMOTE_DEVICE    stuRemoteDevice = new SDK_REMOTE_DEVICE();
	
	/**
	 * \if ENGLISH_LANG
	 * stream type, NET_STREAM_TYPE
	 * \else
	 * 视频码流类型, NET_STREAM_TYPE
	 * \endif
	 */
	public int                 emStreamType;
	
	/**
	 * \if ENGLISH_LANG
	 * Channel Types, NET_LOGIC_CHN_TYPE
	 * \else
	 * 通道类型, NET_LOGIC_CHN_TYPE
	 * \endif
	 */
	public int                 emChannelType;
}
