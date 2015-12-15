package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Serial Port Configuration
 * \else
 * 串口配置
 * \endif
 */
public class CFG_COMMGROUP_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Serial Ports Numk
	 * \else
	 * 串口个数
	 * \endif
	 */
	public int    nCommNum;
	
	/**
	 * \if ENGLISH_LANG
	 * Serial Port Array 
	 * \else
	 * 串口信息
	 * \endif
	 */
	public CFG_COMM_INFO    stuComms[] = new CFG_COMM_INFO[FinalVar.MAX_COMM_NUM];
	
	public CFG_COMMGROUP_INFO() {
		for (int i = 0; i < FinalVar.MAX_COMM_NUM; i++) {
			stuComms[i] = new CFG_COMM_INFO();
		}
	}
}
