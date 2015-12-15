package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * DefenceArea Type
 * \else
 * 防区类型
 * \endif
 */
public class EM_CFG_DEFENCEAREATYPE implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Unkown
	 * \else
	 * 未知
	 * \endif
	 */
	public final static int EM_CFG_DefenceAreaType_Unknown = 0;
	
	/**
	 * \if ENGLISH_LANG
	 * Real-time DefenceArea 
	 * \else
	 * 即时防区 
	 * \endif
	 */
	public final static int EM_CFG_DefenceAreaType_InTime = 1;
	
	/**
	 * \if ENGLISH_LANG
	 * Delay DefenceArea
	 * \else
	 * 延时防区
	 * \endif
	 */
	public final static int EM_CFG_DefenceAreaType_Delay = 2;
	
	/**
	 * \if ENGLISH_LANG
	 * Fullday DefenceArea
	 * \else
	 * 24小时防区
	 * \endif
	 */
	public final static int EM_CFG_DefenceAreaType_FullDay = 3;
	
	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 火警防区
	 * \endif
	 */
	public final static int EM_CFG_DefenceAreaType_Fire = 4;
	
	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 24小时有声防区
	 * \endif
	 */
	public final static int EM_CFG_DefenceAreaType_FullDaySound = 5;
	
	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 24小时无声防区
	 * \endif
	 */
	public final static int EM_CFG_DefenceAreaType_FullDaySlient = 6;
	
	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 出入防区1
	 * \endif
	 */
	public final static int EM_CFG_DefenceAreaType_Entrance1 = 7;
	
	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 出入防区2
	 * \endif
	 */
	public final static int EM_CFG_DefenceAreaType_Entrance2 = 8;
	
	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 内部防区
	 * \endif
	 */
	public final static int EM_CFG_DefenceAreaType_InSide = 9;
	
	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 外部防区
	 * \endif
	 */
	public final static int EM_CFG_DefenceAreaType_OutSide = 10;
}
