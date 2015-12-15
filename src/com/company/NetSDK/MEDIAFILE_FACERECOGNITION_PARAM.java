package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * SDK_FILE_QUERY_FACE Corresponding face recognition service search parameter
 * \else
 * SDK_FILE_QUERY_FACE对应的人脸识别服务查询参数
 * \endif
 */
public class MEDIAFILE_FACERECOGNITION_PARAM implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * start time
	 * \else
	 * 开始时间
	 * \endif
	 */
	public NET_TIME            stStartTime = new NET_TIME();

	/**
	 * \if ENGLISH_LANG
	 * closing time
	 * \else
	 * 结束时间
	 * \endif
	 */
	public NET_TIME            stEndTime = new NET_TIME();

	/**
	 * \if ENGLISH_LANG
	 * Place to support fuzzy matching
	 * \else
	 * 地点，支持模糊匹配
	 * \endif
	 */
	public byte                szMachineAddress[] = new byte[FinalVar.MAX_PATH];

	/**
	 * \if ENGLISH_LANG
	 * To query the type of alarm, see EM_FACERECOGNITION_ALARM_TYPE
	 * \else
	 * 待查询报警类型，详见 EM_FACERECOGNITION_ALARM_TYPE
	 * \endif
	 */
	public int                 nAlarmType;

	/**
	 * \if ENGLISH_LANG
	 * staff info is valid or not
	 * \else
	 * 人员信息是否有效
	 * \endif
	 */
	public boolean                abPersonInfo;

	/**
	 * \if ENGLISH_LANG
	 * staff info
	 * \else
	 * 人员信息
	 * \endif
	 */
	public FACERECOGNITION_PERSON_INFO stPersonInfo = new FACERECOGNITION_PERSON_INFO();

	/**
	 * \if ENGLISH_LANG
	 * channel no.
	 * \else
	 * 通道号
	 * \endif
	 */
	public int                 nChannelId;

	/**
	 * \if ENGLISH_LANG
	 * staff group
	 * \else
	 * 人员组数
	 * \endif
	 */
	public int                 nGroupIdNum;

	/**
	 * \if ENGLISH_LANG
	 * staff group ID
	 * \else
	 * 人员组ID
	 * \endif
	 */
	public byte                szGroupId[][] = new byte[FinalVar.MAX_GOURP_NUM][FinalVar.SDK_COMMON_STRING_64];
}
