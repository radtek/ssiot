package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Motion detection alarm
 * \else
 * 动态检测报警
 * \endif
 */
public class SDK_MOTION_DETECT_CFG_EX implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Motion detection alarm enabling
	 * \else
	 * 动态检测报警使能
	 * \endif
	 */
	public byte                byMotionEn;

	/**
	 * \if ENGLISH_LANG
	 * Sensitivity
	 * \else
	 * 灵敏度
	 * \endif
	 */
	public short                wSenseLevel;

	/**
	 * \if ENGLISH_LANG
	 * Motion detection area rows
	 * \else
	 * 动态检测区域的行数
	 * \endif
	 */
	public short                wMotionRow;

	/**
	 * \if ENGLISH_LANG
	 * Motion detection area lines
	 * \else
	 * 动态检测区域的列数
	 * \endif
	 */
	public short                wMotionCol;
	
	/**
	 * \if ENGLISH_LANG
	 * Motion detection area,most 32*32
	 * \else
	 * 检测区域，最多32*32块区域
	 * \endif
	 */
    public byte                byDetected[][] = new byte[FinalVar.SDK_MOTION_ROW][FinalVar.SDK_MOTION_COL];
    
    /**
	 * \if ENGLISH_LANG
	 * NSP
	 * \else
	 * NSP
	 * \endif
	 */
    public SDK_TSECT            stSect[][] = new SDK_TSECT[FinalVar.SDK_N_WEEKS][FinalVar.SDK_N_REC_TSECT];
    
    /**
	 * \if ENGLISH_LANG
	 * Handle method
	 * \else
	 * 处理方式
	 * \endif
	 */
    public SDK_MSG_HANDLE_EX        struHandle = new SDK_MSG_HANDLE_EX();
    
    public SDK_MOTION_DETECT_CFG_EX() {
    	for (int i = 0; i < FinalVar.SDK_N_WEEKS; i++) {
    		for (int j = 0; j < FinalVar.SDK_N_REC_TSECT; j++) {
    			stSect[i][j] = new SDK_TSECT();
    		}
    	}
    }
}
