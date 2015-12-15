package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Log information. Corresponding to QueryDeviceLog
 * \else
 * ��־��Ϣ����Ӧ�ӿ� QueryDeviceLog �ӿ�
 * \endif
 */
public class SDK_DEVICE_LOG_ITEM implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Log type 
	 * \else
	 * ��־����
	 * \endif
	 */
	public int					nLogType;				
	/**
	 * \if ENGLISH_LANG
	 * Date
	 * \else
	 * ����
	 * \endif
	 */
	public SDKDEVTIME			stuOperateTime;			
	/**
	 * \if ENGLISH_LANG
	 * Operator
	 * \else
	 * ������
	 * \endif
	 */
	public char				szOperator[] = new char[16]; 		
	/**
	 * \if ENGLISH_LANG
	 * Reserved
	 * \else
	 * ����
	 * \endif
	 */
	public byte				bReserved[] = new byte[3];
	/**
	 * \if ENGLISH_LANG
	 * union structure type,0:szLogContext;1:stuOldLog
	 * \else
	 * union�ṹ����,0:szLogContext��1:stuOldLog��
	 * \endif
	 */
	public byte				bUnionType;				 
	//union
	//{
	/**
	 * \if ENGLISH_LANG
	 * Log content
	 * \else
	 * ��־��ע��Ϣ
	 * \endif
	 */
	public char			szLogContext[] = new char[64];		
	/**
	 * \if ENGLISH_LANG
	 * �ɵ���־�ṹ��
	 * \else
	 * �˿����
	 * \endif
	 */
	public SDK_LOG_ITEM_OLD stuOldLog;
	//};
	/**
	 * \if ENGLISH_LANG
	 * Reserved
	 * \else
	 * ����
	 * \endif
	 */
	public char				reserved[] = new char[16];
	
	public SDK_DEVICE_LOG_ITEM()
	{
		stuOperateTime = new SDKDEVTIME();
		stuOldLog = new SDK_LOG_ITEM_OLD();
	}
}
