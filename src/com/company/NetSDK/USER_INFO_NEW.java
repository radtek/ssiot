package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * User info structure body 
 * \else
 * 用户信息
 * \endif
 */
//
public class USER_INFO_NEW implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * ID
	 * \else
	 * Id号
	 * \endif
	 */
	public int				dwID;
	/**
	 * \if ENGLISH_LANG
	 * Group ID 
	 * \else
	 * 组ID号
	 * \endif
	 */
	public int				dwGroupID;
	/**
	 * \if ENGLISH_LANG
	 * Name 
	 * \else
	 * 名字名
	 * \endif
	 */
	public char			name[] = new char[FinalVar.SDK_NEW_USER_NAME_LENGTH];
	/**
	 * \if ENGLISH_LANG
	 * Password 
	 * \else
	 * 密码
	 * \endif
	 */
	public char			passWord[] = new char[FinalVar.SDK_NEW_USER_PSW_LENGTH];
	/**
	 * \if ENGLISH_LANG
	 * Right amount 
	 * \else
	 * 权限列表长度
	 * \endif
	 */
	public int				dwRightNum;
	/**
	 * \if ENGLISH_LANG
	 * Right 
	 * \else
	 * 权限列表
	 * \endif
	 */
	public int				rights[] = new int[FinalVar.SDK_NEW_MAX_RIGHT_NUM];
	/**
	 * \if ENGLISH_LANG
	 * Note 
	 * \else
	 * 备注
	 * \endif
	 */
	public char			memo[] = new char[FinalVar.SDK_MEMO_LENGTH];
	/**
	 * \if ENGLISH_LANG
	 * Submask，0x00000001 - support account reusable
	 * \else
	 * 掩码，0x00000001 - 支持用户复用
	 * \endif
	 */
	public int				dwFouctionMask;			
}
