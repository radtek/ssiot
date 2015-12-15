package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * TV Wall Display Information Control Parameters
 * \else
 * 电视墙显示信息控制参数
 * \endif
 */
public class NET_CTRL_MONITORWALL_TVINFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * TV Wall ID
	 * \else
	 * 电视墙ID
	 * \endif
	 */
	public int					nMonitorWallID;
	
	/**
	 * \if ENGLISH_LANG
	 * Display Decoding Channel Information
	 * \else
	 * 显示解码通道信息
	 * \endif
	 */
	public boolean				bDecodeChannel;
}
