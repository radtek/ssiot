package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Annex burn, INetSDK.ControlDevice(SDK_BURNING_ATTACH)
 * \else
 *  附件刻录, INetSDK.ControlDevice(SDK_BURNING_ATTACH)
 * \endif
 */
public class BURNING_PARM_ATTACH implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Whether,0:Not; 1:Yes
	 * \else
	 * 是否为附件刻录，0:不是; 1:是
	 * \endif
	 */
	public int				bAttachBurn;
}
