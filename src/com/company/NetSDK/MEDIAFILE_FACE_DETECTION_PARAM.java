package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * SDK_FILE_QUERY_FACE_DETECTION corresponding face recognition service search parameter
 * \else
 * SDK_FILE_QUERY_FACE_DETECTION 对应的人脸识别服务查询参数
 * \endif
 */
public class MEDIAFILE_FACE_DETECTION_PARAM implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * \if ENGLISH_LANG
	 * channel no.
	 * \else
	 * 通道号
	 * \endif
	 */
	public int                 nChannelID;

	/**
	 * \if ENGLISH_LANG
	 * start time
	 * \else
	 * 起始时间
	 * \endif
	 */
	public NET_TIME            stuStartTime = new NET_TIME();

	/**
	 * \if ENGLISH_LANG
	 * end time
	 * \else
	 * 结束时间
	 * \endif
	 */
	public NET_TIME            stuEndTime = new NET_TIME();

	/**
	 * \if ENGLISH_LANG
	 * picture type，see  EM_FACEPIC_TYPE
	 * \else
	 * 图片类型，详见 EM_FACEPIC_TYPE
	 * \endif
	 */
	public int     emPicType;

	/**
	 * \if ENGLISH_LANG
	 * if has detailed info
	 * \else
	 * 是否有详细信息
	 * \endif
	 */
	public boolean                bDetailEnable;

	/**
	 * \if ENGLISH_LANG
	 * parameter detailed info
	 * \else
	 * 参数详细信息
	 * \endif
	 */
	public MEDIAFILE_FACE_DETECTION_DETAIL_PARAM stuDetail = new MEDIAFILE_FACE_DETECTION_DETAIL_PARAM();
}
