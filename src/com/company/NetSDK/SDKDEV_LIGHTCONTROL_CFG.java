package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Light control config
 * \else
 * 灯光控制配置
 * \endif
 */
public class SDKDEV_LIGHTCONTROL_CFG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Control config
	 * \else
	 * 控制配置
	 * \endif
	 */
	public SDK_CONFIG_CONTROLER    struControlers[] = new SDK_CONFIG_CONTROLER[FinalVar.SDK_MAX_CONTROLER_NUM];
	
	/**
	 * \if ENGLISH_LANG
	 * Effective controller number
	 * \else
	 * 有效控制器数目
	 * \endif
	 */
	public byte                   bControlerNum; 
	
	public SDKDEV_LIGHTCONTROL_CFG() {
		for (int i = 0; i < FinalVar.SDK_MAX_CONTROLER_NUM; i++) {
			struControlers[i] = new SDK_CONFIG_CONTROLER();
		}
	}
}
