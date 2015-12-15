package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Reserved 
 * \else
 * 视频诊断全局表结构体
 * \endif
 */
public class CFG_VIDEODIAGNOSIS_GLOBAL implements Serializable {
 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * \if ENGLISH_LANG
	 * Caller allocate global config number  according to capacity  
	 * \else
	 * 调用者分配全局配置个数  根据能力集获取
	 * \endif
	 */
	public int									nTotalGlobalNum;
	
 	/**
	 * \if ENGLISH_LANG
	 * Return actual global config number 
	 * \else
	 * 返回实际全局配置个数
	 * \endif
	 */
	public int									nReturnGlobalNum;
	
 	/**
	 * \if ENGLISH_LANG
	 * Video diagnosis global config caller allocate memory nGlobalCount个CFG_VIDEODIAGNOSIS_GLOBAL_CHNNL 
	 * \else
	 * 视频诊断全局配置 调用者分配内存nGlobalCount个CFG_VIDEODIAGNOSIS_GLOBAL_CHNNL
	 * \endif
	 */
	public CFG_VIDEODIAGNOSIS_GLOBAL_CHNNL[]	pstGlobals;
	
	public CFG_VIDEODIAGNOSIS_GLOBAL(int nTotalGlobalNum) {
		this.nTotalGlobalNum = nTotalGlobalNum;
		pstGlobals = new CFG_VIDEODIAGNOSIS_GLOBAL_CHNNL[nTotalGlobalNum];
		for (int i = 0; i < nTotalGlobalNum; i++) {
			pstGlobals[i] = new CFG_VIDEODIAGNOSIS_GLOBAL_CHNNL();
		}
	}
}
