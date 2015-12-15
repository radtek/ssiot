package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * INetSDK.ControlDevice's param: SDK_CTRL_CLEAR_ALARM
 * \else
 * INetSDK.ControlDevice接口的 SDK_CTRL_CLEAR_ALARM 命令参数
 * \endif
 */
public class NET_CTRL_CLEAR_ALARM implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Defence Area's ID
	 * \else
	 * 防区通道号
	 * \endif
	 */
	public int		nChannelID;
	
	/**
	 * \if ENGLISH_LANG
	 * Event Type
	 * \else
	 * 事件类型
	 * \endif
	 */
	public int		emAlarmType;
	
	/**
	 * \if ENGLISH_LANG
	 * Landing Equipment Such As Password, Do not Use Encryption Disappear the Police, Direct Assignment of NULL
	 * \else
	 * 登陆设备的密码,如不使用加密消警,直接赋值为NULL
	 * \endif
	 */
	public String	szDevPwd;
}
