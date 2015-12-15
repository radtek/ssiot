package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Media file search criteria
 * \else
 * 端media文件查询条件
 * \endif
 */
public class EM_FILE_QUERY_TYPE implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Vehicle information 
	 * \else
	 * 交通车辆信息
	 * \endif
	 */
	public static final int     SDK_FILE_QUERY_TRAFFICCAR = 0;							 
	/**
	 * \if ENGLISH_LANG
	 * ATM information
	 * \else
	 * ATM信息
	 * \endif
	 */
	public static final int     SDK_FILE_QUERY_ATM = 1;									 
	/**
	 * \if ENGLISH_LANG
	 * ATM transaction information 
	 * \else
	 * ATM交易信息 
	 * \endif
	 */
	public static final int     SDK_FILE_QUERY_ATMTXN = 2;								 
	/**
	 * \if ENGLISH_LANG
	 * Face info, corresponding to MEDIAFILE_FACERECOGNITION_PARAM and MEDIAFILE_FACERECOGNITION_INFO
	 * \else
	 * 端人脸信息 MEDIAFILE_FACERECOGNITION_PARAM 和  MEDIAFILE_FACERECOGNITION_INFO
	 * \endif
	 */
	public static final int     SDK_FILE_QUERY_FACE = 3;  								 
	/**
	 * \if ENGLISH_LANG
	 * File info, corresponding to NET_IN_MEDIA_QUERY_FILE and NET_OUT_MEDIAFILE_FILE
	 * \else
	 * 文件信息对应 NET_IN_MEDIA_QUERY_FILE 和 NET_OUT_MEDIAFILE_FILE
	 * \endif
	 */
	public static final int     SDK_FILE_QUERY_FILE = 4;
	
	/**
	 * \if ENGLISH_LANG
	 * Traffic vehicle info, extension DH_FILE_QUERY_TRAFFICCAR, support more fields
	 * \else
	 * 交通车辆信息, 扩展SDK_FILE_QUERY_TRAFFICCAR, 支持更多的字段
	 * \endif
	 */
	public static final int     SDK_FILE_QUERY_TRAFFICCAR_EX = 5;

	/**
	 * \if ENGLISH_LANG
	 * Face recignition event info MEDIAFILE_FACE_DETECTION_PARAM and MEDIAFILE_FACE_DETECTION_INFO
	 * \else
	 * 人脸检测事件信息 MEDIAFILE_FACE_DETECTION_PARAM 和 MEDIAFILE_FACE_DETECTION_INFO
	 * \endif
	 */
	public static final int     SDK_FILE_QUERY_FACE_DETECTION = 6;	
}
