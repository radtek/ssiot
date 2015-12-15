package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * alarm sub system activation setup parameter(corresponding SDK_CTRL_ALARM_SUBSYSTEM_ACTIVE_SET command)
 * \else
 * 报警子系统激活设置参数(对应SDK_CTRL_ALARM_SUBSYSTEM_ACTIVE_SET命令)
 * \endif
 */
public class NET_CTRL_ALARM_SUBSYSTEM_SETACTIVE implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * sub system no.
	 * \else
	 * 子系统号
	 * \endif
	 */
	public int					nChannelId;
	
	/**
	 * \if ENGLISH_LANG
	 * sub system enable status ,TRUE means enable, FALSE means disable
	 * \else
	 * 子系统启用状态,TRUE 表示启用,FALSE表示不启用
	 * \endif
	 */
	public boolean 				bActive; 
}
