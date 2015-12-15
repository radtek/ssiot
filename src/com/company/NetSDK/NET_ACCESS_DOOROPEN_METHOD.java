package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Unlock Method(Access control event,entry/exit record, actual unlock method)
 * \else
 * 开门方式(门禁事件,门禁出入记录,实际的开门方式)
 * \endif
 */
public class NET_ACCESS_DOOROPEN_METHOD implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Unknown
	 * \else
	 * 未知
	 * \endif
	 */
	public static final int NET_ACCESS_DOOROPEN_METHOD_UNKNOWN = 0;
	
	/**
	 * \if ENGLISH_LANG
	 * Password Unlock
	 * \else
	 * 密码开锁
	 * \endif
	 */
	public static final int NET_ACCESS_DOOROPEN_METHOD_PWD_ONLY = 1;
	
	/**
	 * \if ENGLISH_LANG
	 * Swipe Unlock
	 * \else
	 * 刷卡开锁
	 * \endif
	 */
	public static final int NET_ACCESS_DOOROPEN_METHOD_CARD = 2;
	
	/**
	 * \if ENGLISH_LANG
	 * SwipeCard and Unlock with Password
	 * \else
	 * 先刷卡后密码开锁
	 * \endif
	 */
	public static final int NET_ACCESS_DOOROPEN_METHOD_CARD_FIRST = 3;
	
	/**
	 * \if ENGLISH_LANG
	 * InputPassword and Swipe Card to Unlock
	 * \else
	 * 先密码后刷卡开锁
	 * \endif
	 */
	public static final int NET_ACCESS_DOOROPEN_METHOD_PWD_FIRST = 4;
	
	/**
	 * \if ENGLISH_LANG
	 * Remotely Unlock，such as unlock VTO via VTH or platform
	 * \else
	 * 远程开锁，如通过室内机或者平台对门口机开锁
	 * \endif
	 */
	public static final int NET_ACCESS_DOOROPEN_METHOD_REMOTE = 5;
	
	/**
	 * \if ENGLISH_LANG
	 * Unlock via Button
	 * \else
	 * 开锁按钮进行开锁
	 * \endif
	 */
	public static final int NET_ACCESS_DOOROPEN_METHOD_BUTTON = 6;
}
