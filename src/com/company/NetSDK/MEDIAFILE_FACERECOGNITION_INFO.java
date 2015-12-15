package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * corresponding facial recognition service SDK_FILE_QUERY_FACE FINDNEXT search returned parameter
 * \else
 * SDK_FILE_QUERY_FACE对应的人脸识别服务FINDNEXT查询返回参数
 * \endif
 */
public class MEDIAFILE_FACERECOGNITION_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * The existence panorama
	 * \else
	 * 全景图是否存在
	 * \endif
	 */
	public boolean                    bGlobalScenePic;

	/**
	 * \if ENGLISH_LANG
	 * Panoramic image file path
	 * \else
	 * 全景图片文件路径
	 * \endif
	 */
	public SDK_PIC_INFO_EX          stGlobalScenePic = new SDK_PIC_INFO_EX();

	/**
	 * \if ENGLISH_LANG
	 * the target face object information
	 * \else
	 * 目标人脸物体信息
	 * \endif
	 */
	public SDK_MSG_OBJECT           stuObject = new SDK_MSG_OBJECT();

	/**
	 * \if ENGLISH_LANG
	 * the target face file path
	 * \else
	 * 目标人脸文件路径
	 * \endif
	 */
	public SDK_PIC_INFO_EX          stObjectPic = new SDK_PIC_INFO_EX();

	/**
	 * \if ENGLISH_LANG
	 * Face Matching the current number of candidates
	 * \else
	 * 当前人脸匹配到的候选对象数量
	 * \endif
	 */
	public int                     nCandidateNum;

	/**
	 * \if ENGLISH_LANG
	 * Face candidates to match this informatio
	 * \else
	 * 当前人脸匹配到的候选对象信息
	 * \endif
	 */
	public CANDIDATE_INFO          stuCandidates[] = new CANDIDATE_INFO[FinalVar.SDK_MAX_CANDIDATE_NUM];

	/**
	 * \if ENGLISH_LANG
	 * The current face matching candidates to the image file path
	 * \else
	 * 当前人脸匹配到的候选对象图片文件路径
	 * \endif
	 */
	public NET_CANDIDAT_PIC_PATHS  stuCandidatesPic[] = new NET_CANDIDAT_PIC_PATHS[FinalVar.SDK_MAX_CANDIDATE_NUM];

	/**
	 * \if ENGLISH_LANG
	 * time for an alarm
	 * \else
	 * 报警发生时间
	 * \endif
	 */
	public NET_TIME                stTime = new NET_TIME();
	
	/**
	 * \if ENGLISH_LANG
	 * Place for an alarm
	 * \else
	 * 报警发生地点
	 * \endif
	 */
	public byte                    szAddress[] = new byte[FinalVar.MAX_PATH];

	/**
	 * \if ENGLISH_LANG
	 * channel no.
	 * \else
	 * 通道号
	 * \endif
	 */
	public int                     nChannelId;
	
	public MEDIAFILE_FACERECOGNITION_INFO() {
		for (int i = 0; i < FinalVar.SDK_MAX_CANDIDATE_NUM; i++) {
			stuCandidates[i] = new CANDIDATE_INFO();
			stuCandidatesPic[i] = new NET_CANDIDAT_PIC_PATHS();
		}
	}
}
