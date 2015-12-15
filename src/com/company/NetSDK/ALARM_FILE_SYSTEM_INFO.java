package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * alarm of file system
 * \else
 * 文件系统告警
 * \endif
 */
public class ALARM_FILE_SYSTEM_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

 	/**
	 * \if ENGLISH_LANG
	 * mount name
	 * \else
	 * 文件系统挂载名
	 * \endif
	 */
	public byte                 szMountDir[] = new byte[FinalVar.MAX_PATH];
	
 	/**
	 * \if ENGLISH_LANG
	 * state, 0: Unkown, 1: Normal, 2: Error
	 * \else
	 * 文件系统状态, 0: Unkown, 1: Normal, 2: Error
	 * \endif
	 */
	public int                nState;
}
