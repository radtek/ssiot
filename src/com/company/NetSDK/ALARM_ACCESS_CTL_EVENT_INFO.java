package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Access Control Event
 * \else
 * 门禁事件
 * \endif
 */
public class ALARM_ACCESS_CTL_EVENT_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Door Channel No.
	 * \else
	 * 门通道号
	 * \endif
	 */
	public int                         nDoor;
	
	/**
	 * \if ENGLISH_LANG
	 * Access Control Name
	 * \else
	 * 门禁名称
	 * \endif
	 */
	public byte                        szDoorName[] = new byte[FinalVar.SDK_MAX_DOORNAME_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Alarm Event Time
	 * \else
	 * 报警事件发生的时间
	 * \endif
	 */
	public NET_TIME                    stuTime = new NET_TIME();
	
	/**
	 * \if ENGLISH_LANG
	 * Access Control Event Type
	 * \else
	 * 门禁事件类型
	 * \endif
	 */
	public int                         emEventType;
	
	/**
	 * \if ENGLISH_LANG
	 * Access Control Event Type
	 * \else
	 * 刷卡结果，TRUE表示成功，FALSE表示失败
	 * \endif
	 */
	public boolean                     bStatus;
	
	/**
	 * \if ENGLISH_LANG
	 * Card Type
	 * \else
	 * 卡类型
	 * \endif
	 */
	public int                         emCardType;
	
	/**
	 * \if ENGLISH_LANG
	 * Unlock Method
	 * \else
	 * 开门方式
	 * \endif
	 */
	public int                         emOpenMethod;
	
	/**
	 * \if ENGLISH_LANG
	 * Card No.
	 * \else
	 * 卡号
	 * \endif
	 */
	public byte                        szCardNo[] = new byte[FinalVar.SDK_MAX_CARDNO_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Password
	 * \else
	 * 密码
	 * \endif
	 */
	public byte                        szPwd[] = new byte[FinalVar.SDK_MAX_CARDPWD_LEN];
}
