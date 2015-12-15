package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Access Control card Record Information
 * \else
 * 门禁刷卡记录记录集信息
 * \endif
 */
public class NET_RECORDSET_ACCESS_CTL_CARDREC implements Serializable {
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
	 * Card Number
	 * \else
	 * 卡号
	 * \endif
	 */
	public char			szCardNo[] 	= new char[FinalVar.SDK_MAX_CARDNO_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Password
	 * \else
	 * 密码
	 * \endif
	 */
	public char			szPwd[] 	= new char[FinalVar.SDK_MAX_CARDPWD_LEN]; 
	
	/**
	 * \if ENGLISH_LANG
	 * Swing Card Time
	 * \else
	 * 刷卡时间
	 * \endif
	 */
	public NET_TIME		stuTime = new NET_TIME(); 
	
	/**
	 * \if ENGLISH_LANG
	 * Swing Card Result,True is Succes,False is Fail
	 * \else
	 * 刷卡结果，TRUE表示成功，FALSE表示失败
	 * \endif
	 */
	public boolean		bStatus; 
	
	/**
	 * \if ENGLISH_LANG
	 * Open Door Method
	 * \else
	 * 开门方式
	 * 1:密码开锁
	 * 2:刷卡开锁
	 * 3:先刷卡后密码开锁
	 * 4:先密码后刷卡开锁
	 * 5:远程开锁，如通过室内机或者平台对门口机开锁
	 * 6:开锁按钮进行开锁
	 * \endif
	 */
	public int			nMethod;
	
	/**
	 * \if ENGLISH_LANG
	 * Door Number,That is CFG_CMD_ACCESS_EVENT Configure Array Subscript 
	 * \else
	 * 门号，即CFG_CMD_ACCESS_EVENT配置CFG_ACCESS_EVENT_INFO的数组下标
	 * \endif
	 */
	public int			nDoor; 
}
