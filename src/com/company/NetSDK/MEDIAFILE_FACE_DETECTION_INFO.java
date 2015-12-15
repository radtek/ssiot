package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * SDK_FILE_QUERY_FACE_DETECTIONcorresponding face recognition service FINDNEXT search return parameter
 * \else
 * SDK_FILE_QUERY_FACE_DETECTION对应的人脸识别服务FINDNEXT查询返回参数
 * \endif
 */
public class MEDIAFILE_FACE_DETECTION_INFO implements Serializable {
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
	public int        ch;

	/**
	 * \if ENGLISH_LANG
	 * file path
	 * \else
	 * 文件路径
	 * \endif
	 */
	public byte                szFilePath[] = new byte[128];

	/**
	 * \if ENGLISH_LANG
	 * file length
	 * \else
	 * 文件长度
	 * \endif
	 */
	public int        size;

	/**
	 * \if ENGLISH_LANG
	 * start time
	 * \else
	 * 开始时间
	 * \endif
	 */
	public NET_TIME            starttime = new NET_TIME();

	/**
	 * \if ENGLISH_LANG
	 * end time
	 * \else
	 * 结束时间
	 * \endif
	 */
	public NET_TIME            endtime = new NET_TIME();

	/**
	 * \if ENGLISH_LANG
	 * working directory no.
	 * \else
	 * 工作目录编号
	 * \endif
	 */
	public int        nWorkDirSN;

	/**
	 * \if ENGLISH_LANG
	 * file type  1：jpg picture
	 * \else
	 * 文件类型  1：jpg图片
	 * \endif
	 */
	public byte                nFileType;

	/**
	 * \if ENGLISH_LANG
	 * file positioning index
	 * \else
	 * 文件定位索引
	 * \endif
	 */
	public byte                bHint;

	/**
	 * \if ENGLISH_LANG
	 * disk no.
	 * \else
	 * 磁盘号
	 * \endif
	 */
	public byte                bDriveNo;

	/**
	 * \if ENGLISH_LANG
	 * picture type, 0-normal, 1-combined, 2-cut
	 * \else
	 * 图片类型, 0-普通, 1-合成, 2-抠图
	 * \endif
	 */
	public byte                byPictureType;

	/**
	 * \if ENGLISH_LANG
	 * cluster no.
	 * \else
	 * 簇号
	 * \endif
	 */
	public int        nCluster;

	/**
	 * \if ENGLISH_LANG
	 * picture type，see EM_FACE_PIC_TYPE
	 * \else
	 * 图片类型，详见EM_FACE_PIC_TYPE
	 * \endif
	 */
	public int     emPicType;

	/**
	 * \if ENGLISH_LANG
	 * object ID
	 * \else
	 * 物体ID
	 * \endif
	 */
	public int               dwObjectId;

	/**
	 * \if ENGLISH_LANG
	 * frame no.,group has two elements，one means small picture，two means large picture
	 * \else
	 * 帧序号,数组有2个元素时，第一个表示小图，第二个表示大图
	 * \endif
	 */
	public int               dwFrameSequence[] = new int[FinalVar.NET_MAX_FRAMESEQUENCE_NUM];

	/**
	 * \if ENGLISH_LANG
	 * frame no.quantity
	 * \else
	 * 帧序号个数
	 * \endif
	 */
	public int                 nFrameSequenceNum;

	/**
	 * \if ENGLISH_LANG
	 * time，group has two elements，one means small picture，two means large picture
	 * \else
	 * 发生时间，数组有2个元素时，第一个表示小图，第二个表示大图
	 * \endif
	 */
	public NET_TIME_EX         stTimes[] = new NET_TIME_EX[FinalVar.NET_MAX_TIMESTAMP_NUM];
	
	public int                 nTimeStampNum;

	/**
	 * \if ENGLISH_LANG
	 * Picture number in the cluster
	 * For packaged multiple images in the same cluster,provides indexed mode to position pictures
	 * \else
	 * 表示在簇中的图片序号
	 * 对于同一个簇中打包多张图片,提供索引方式定位图片
	 * \endif
	 */
	public int                 nPicIndex;
	
	public MEDIAFILE_FACE_DETECTION_INFO() {
		for (int i = 0; i < FinalVar.NET_MAX_TIMESTAMP_NUM; i++) {
			stTimes[i] = new NET_TIME_EX();
		}
	}
}
