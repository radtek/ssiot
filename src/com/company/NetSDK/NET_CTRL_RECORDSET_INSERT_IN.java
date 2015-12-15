package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * New Record Set Operation(Insert)Parameter
 * \else
 * 记录集新增操作(insert)输入参数
 * \endif
 */
public class NET_CTRL_RECORDSET_INSERT_IN implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Record Information Type
	 * \else
	 * 记录集信息类型
	 * 1:交通白名单账户记录,对应 FIND_RECORD_TRAFFICREDLIST_CONDITION
	 * 2:交通黑名单账号记录,对应 FIND_RECORD_TRAFFICREDLIST_CONDITION
	 * 3:刻录案件记录,对应 FIND_RECORD_BURN_CASE_CONDITION 
	 * 4:门禁卡,对应 NET_RECORDSET_ACCESS_CTL_CARD
	 * 5:门禁密码,对应 NET_RECORDSET_ACCESS_CTL_PWD
	 * 6:门禁出入记录,对应 NET_RECORDSET_ACCESS_CTL_CARDREC
	 * 7:假日记录集, 对应 NET_RECORDSET_HOLIDAY
	 * \endif
	 */
	public int		nType;
	
	/**
	 * \if ENGLISH_LANG
	 * Record Information Cache,The EM_NET_RECORD_TYPE Note is Details
	 * \else
	 * 记录集信息缓存，详见EM_NET_RECORD_TYPE注释
	 * \endif
	 */
	public Object	pBuf;
	
	/**
	 * \if ENGLISH_LANG
	 * Record Information Cache Size
	 * \else
	 * 记录集信息缓存大小
	 * \endif
	 */
	public int		nBufLen;
}
