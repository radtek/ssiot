package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * explosion proof alarm configuration
 * \else
 * 防爆盒报警事件配置
 * \endif
 */
public class SDKDEV_EXPLOSION_PROOF_CFG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * explosion proof alarm configuration enable
	 * \else
	 * 防爆盒报警使能
	 * \endif
	 */
	public boolean                bEnable; 
	
	/**
	 * \if ENGLISH_LANG
	 * handle method
	 * \else
	 * 处理方式
	 * \endif
	 */
	public SDK_MSG_HANDLE_EX    struHandle = new SDK_MSG_HANDLE_EX(); 
}
