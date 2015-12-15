package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Even the authentication information
 * \else
 * 级联权限验证信息
 * \endif
 */
public class SDK_CASCADE_AUTHENTICATOR implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * User name
	 * \else
	 * 用户名
	 * \endif
	 */
	public char				szUser[] = new char[FinalVar.SDK_NEW_USER_NAME_LENGTH];		
	/**
	 * \if ENGLISH_LANG
	 * Passwd
	 * \else
	 * 密码
	 * \endif
	 */
	public char				szPwd[] = new char[FinalVar.SDK_NEW_USER_PSW_LENGTH];			
	/**
	 * \if ENGLISH_LANG
	 * Serial no.
	 * \else
	 * 设备序列号
	 * \endif
	 */
	public char				szSerialNo[] = new char[FinalVar.SDK_SERIALNO_LEN];			
}
