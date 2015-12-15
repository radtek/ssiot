package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Entrance Guard Record  Information
 * \else
 * 门禁密码记录集信息
 * \endif
 */
public class NET_RECORDSET_ACCESS_CTL_PWD implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Record Number,Read-Only
	 * \else
	 * 记录集编号，只读
	 * \endif
	 */
	public int			nRecNo; 
	
	/**
	 * \if ENGLISH_LANG
	 * Creat Time
	 * \else
	 * 创建时间
	 * \endif
	 */
	public NET_TIME		stuCreateTime; 
	
	/**
	 * \if ENGLISH_LANG
	 * User's ID
	 * \else
	 * 用户ID
	 * \endif
	 */
	public char        	szUserID[] 		= new char[FinalVar.SDK_MAX_USERID_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Open Password
	 * \else
	 * 开门密码
	 * \endif
	 */
	public char			szDoorOpenPwd[] = new char[FinalVar.SDK_MAX_CARDPWD_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Alarm Password
	 * \else
	 * 报警密码
	 * \endif
	 */
	public char			szAlarmPwd[] 	= new char[FinalVar.SDK_MAX_CARDPWD_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Valid Door Number
	 * \else
	 * 有效的的门数目
	 * \endif
	 */
	public int			nDoorNum; 
	
	/**
	 * \if ENGLISH_LANG
	 * Privileged Door Number,That is CFG_CMD_ACCESS_EVENT Configure Array Subscript
	 * \else
	 * 有权限的门序号，即CFG_CMD_ACCESS_EVENT配置CFG_ACCESS_EVENT_INFO的数组下标
	 * \endif
	 */
	public int		    sznDoors[] 		= new int[FinalVar.SDK_MAX_DOOR_NUM]; 
}
