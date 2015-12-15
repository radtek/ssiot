package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Record info, corresponde to CLIENT_FindFileEx, search result
 * \else
 * 录像信息对应 FindFileEx接口的 SDK_FILE_QUERY_FILE 命令 查询结果
 * \endif
 */
public class NET_OUT_MEDIA_QUERY_FILE implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Channel ID,from 0,-1 means search all
	 * \else
	 * 通道号从0开始，-1表示查询所有通道
	 * \endif
	 */
	public int					nChannelID;				 
	/**
	 * \if ENGLISH_LANG
	 * Start time
	 * \else
	 * 开始时间
	 * \endif
	 */
    public NET_TIME			stuStartTime = new NET_TIME();			 	
	/**
	 * \if ENGLISH_LANG
	 * End time
	 * \else
	 * 结束时间
	 * \endif
	 */
    public NET_TIME			stuEndTime = new NET_TIME();				 
	/**
	 * \if ENGLISH_LANG
	 * Size of file
	 * \else
	 * 文件长度
	 * \endif
	 */
    public int					nFileSize;				 
	/**
	 * \if ENGLISH_LANG
	 * File type 1:jpg, 2: dav
	 * \else
	 * 文件类型 1:jpg图片, 2: dav
	 * \endif
	 */
    public byte				byFileType;				 
	/**
	 * \if ENGLISH_LANG
	 * Drive no.
	 * \else
	 * 磁盘号
	 * \endif
	 */
    public byte                byDriveNo;               
	/**
	 * \if ENGLISH_LANG
	 * Reserved
	 * \else
	 * 保留字段
	 * \endif
	 */
    public byte                byReserved1[] = new byte[2];          
	/**
	 * \if ENGLISH_LANG
	 * Cluster
	 * \else
	 * 簇号
	 * \endif
	 */
    public int      			nCluster;                
	/**
	 * \if ENGLISH_LANG
	 * Path of file
	 * \else
	 * 文件路径
	 * \endif
	 */
    public char				szFilePath[] = new char[FinalVar.MAX_PATH];	 
}
