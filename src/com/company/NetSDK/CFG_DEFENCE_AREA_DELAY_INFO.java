package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * 
 * \else
 * 防区延时配置(对应 CFG_CMD_DEFENCE_AREA_DELAY 命令)
 * \endif
 */
public class CFG_DEFENCE_AREA_DELAY_INFO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 有进入延时的防区类型，除防区类型EM_CFG_DefenceAreaType_Entrance2外, 都使用此进入延时
	 * \endif
	 */
	public int                 nEnterDelay1;
	
	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 只有防区类型为EM_CFG_DefenceAreaType_Entrance2, 才会使用此进入延时
	 * \endif
	 */
	public int                 nEnterDelay2;
	
	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 所有有退出延时的防区, 都使用此退出延时
	 * \endif
	 */
	public int                 nExitDelay;
}
