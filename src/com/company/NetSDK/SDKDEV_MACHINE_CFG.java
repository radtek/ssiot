package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Device relative configuration
 * \else
 * 机器相关的配置
 * \endif
 */
public class SDKDEV_MACHINE_CFG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * \if ENGLISH_LANG
	 * Device name or SN 
	 * \else
	 * 机器名称或编号
	 * \endif
	 */
	public byte                szMachineName[] = new byte[FinalVar.SDK_MACHINE_NAME_NUM]; 
	
	/**
	 * \if ENGLISH_LANG
	 * Device location
	 * \else
	 * 机器部署地点
	 * \endif
	 */
	public byte                szMachineAddress[] = new byte[FinalVar.SDK_MACHINE_NAME_NUM]; 
}
