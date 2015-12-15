package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * ATM Withdraw Overtime Configuration 
 * \else
 * ATM取款超时配置
 * \endif
 */
public class CFG_ATMMOTION_INFO implements Serializable {
 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * \if ENGLISH_LANG
	 * Withdraw Overtime Time,Unit:Second 
	 * \else
	 * 取款超时时间,单位:秒
	 * \endif
	 */
	public int				nTimeLimit;
}