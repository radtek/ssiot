package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * new Log information. Corresponding to QueryDeviceLog
 * \else
 * 新日志信息结构，对应接口 QueryDeviceLog 接口
 * \endif
 */
public class SDK_DEVICE_LOG_ITEM_EX implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Log type 
	 * \else
	 * 日志类型
	 * \endif
	 */
	public int					nLogType;				
	/**
	 * \if ENGLISH_LANG
	 * Date
	 * \else
	 * 日期
	 * \endif
	 */
	public SDKDEVTIME			stuOperateTime;			
	/**
	 * \if ENGLISH_LANG
	 * Operator
	 * \else
	 * 操作者
	 * \endif
	 */
	public char				szOperator[] = new char[16]; 		
	/**
	 * \if ENGLISH_LANG
	 * Reserved
	 * \else
	 * 保留
	 * \endif
	 */
	public byte				bReserved[] = new byte[3];
	/**
	 * \if ENGLISH_LANG
	 * union structure type,0:szLogContext;1:stuOldLog
	 * \else
	 * union结构类型,0:szLogContext；1:stuOldLog。
	 * \endif
	 */
	public byte				bUnionType;				 

	//union
	//{
	/**
	 * \if ENGLISH_LANG
	 * Log content
	 * \else
	 * 日志备注信息
	 * \endif
	 */
	public char			szLogContext[] = new char[64];		
	/**
	 * \if ENGLISH_LANG
	 * Old log structure 
	 * \else
	 * 旧的日志结构体
	 * \endif
	 */
	public SDK_LOG_ITEM_OLD stuOldLog;
	//};
	/**
	 * \if ENGLISH_LANG
	 * Detail operation
	 * \else
	 * 具体的操作内容
	 * \endif
	 */
	public char                szOperation[] = new char[32];        
	/**
	 * \if ENGLISH_LANG
	 * DetailContext
	 * \else
	 * 详细日志信息描述
	 * \endif
	 */
	public char				szDetailContext[] = new char[4 * 1024];  
	
	public SDK_DEVICE_LOG_ITEM_EX()
	{
		stuOperateTime = new SDKDEVTIME();
		stuOldLog = new SDK_LOG_ITEM_OLD();
	}
}
