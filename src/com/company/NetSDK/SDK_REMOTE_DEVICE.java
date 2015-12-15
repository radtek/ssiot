package com.company.NetSDK;

import java.io.Serializable;

public class SDK_REMOTE_DEVICE implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * enable
	 * \else
	 * 使能
	 * \endif
	 */
	public boolean                bEnable;

	/**
	 * \if ENGLISH_LANG
	 * IP
	 * \else
	 * IP
	 * \endif
	 */
	public byte                szIp[] = new byte[FinalVar.SDK_MAX_IPADDR_LEN];

	/**
	 * \if ENGLISH_LANG
	 * username
	 * \else
	 * 用户名
	 * \endif
	 */
	public byte                szUser[] = new byte[FinalVar.SDK_USER_NAME_LENGTH];

	/**
	 * \if ENGLISH_LANG
	 * password
	 * \else
	 * 密码
	 * \endif
	 */
	public byte                szPwd[] = new byte[FinalVar.SDK_USER_PSW_LENGTH];

	/**
	 * \if ENGLISH_LANG
	 * port
	 * \else
	 * 端口
	 * \endif
	 */
	public int                 nPort;

	/**
	 * \if ENGLISH_LANG
	 * definition. 0-standard definition, 1-high definition
	 * \else
	 * 清晰度, 0-标清, 1-高清
	 * \endif
	 */
	public int                 nDefinition;
	
	/**
	 * \if ENGLISH_LANG
	 * protocol type, SDK_DEVICE_PROTOCOL
	 * \else
	 * 协议类型, SDK_DEVICE_PROTOCOL
	 * \endif
	 */
	public int                 emProtocol;
	
	/**
	 * \if ENGLISH_LANG
	 * device name
	 * \else
	 * 设备名称
	 * \endif
	 */
	public byte                szDevName[] = new byte[FinalVar.SDK_DEVICE_NAME_LEN];

	/**
	 * \if ENGLISH_LANG
	 * count channel of video input
	 * \else
	 * 视频输入通道数
	 * \endif
	 */
	public int                 nVideoInputChannels;

	/**
	 * \if ENGLISH_LANG
	 * count channel of audio input
	 * \else
	 * 音频输入通道数
	 * \endif
	 */
	public int                 nAudioInputChannels;

	/**
	 * \if ENGLISH_LANG
	 * device type, such as IPC, DVR, NVR
	 * \else
	 * 设备类型, 如IPC, DVR, NVR等
	 * \endif
	 */
	public byte                szDevClass[] = new byte[FinalVar.SDK_DEV_TYPE_LEN];

	/**
	 * \if ENGLISH_LANG
	 * device type, such as IPC-HF3300
	 * \else
	 * 设备具体型号, 如IPC-HF3300
	 * \endif
	 */
	public byte                szDevType[] = new byte[FinalVar.SDK_DEV_TYPE_LEN];

	/**
	 * \if ENGLISH_LANG
	 * Http port
	 * \else
	 * Http端口
	 * \endif
	 */
	public int                 nHttpPort;

	/**
	 * \if ENGLISH_LANG
	 * max count of video input
	 * \else
	 * 视频输入通道最大数
	 * \endif
	 */
	public int                 nMaxVideoInputCount;

	/**
	 * \if ENGLISH_LANG
	 * return count
	 * \else
	 * 返回实际通道个数
	 * \endif
	 */
	public int                 nRetVideoInputCount;
	
	/**
	 * \if ENGLISH_LANG
	 * max count of audion input
	 * \else
	 * 视频输入通道信息
	 * \endif
	 */
    public SDK_VIDEO_INPUTS    pstuVideoInputs[]; 
    /**
	 * \if ENGLISH_LANG
	 * machine address
	 * \else
	 * 设备部署地
	 * \endif
	 */
	public byte                szMachineAddress[] = new byte[FinalVar.SDK_MAX_CARD_INFO_LEN];

	/**
	 * \if ENGLISH_LANG
	 * serial no.
	 * \else
	 * 设备序列号
	 * \endif
	 */
	public byte                szSerialNo[] = new byte[FinalVar.SDK_SERIALNO_LEN];

	/**
	 * \if ENGLISH_LANG
	 * Rtsp Port
	 * \else
	 * Rtsp端口
	 * \endif
	 */
	public int                 nRtspPort;
}
