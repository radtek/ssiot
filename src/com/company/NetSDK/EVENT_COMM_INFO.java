package com.company.NetSDK;

import java.io.Serializable;

public class EVENT_COMM_INFO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * NTP time sync status 
	 * \else
	 * NTP校时状态
	 * \endif
	 */
	public int                  emNTPStatus;
	
	/**
	 * \if ENGLISH_LANG
	 * driver info number
	 * \else
	 * 驾驶员信息数
	 * \endif
	 */
	public int                  nDriversNum;
	
	/**
	 * \if ENGLISH_LANG
	 * driver info data 
	 * \else
	 * 驾驶员信息数据
	 * \endif
	 */
	public SDK_MSG_OBJECT_EX    pstDriversInfo[];
	
	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 本地硬盘或者sd卡成功写入路径,为NULL时，路径不存在
	 * \endif
	 */
	public String               pszFilePath;
	
	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 设备成功写到ftp服务器的路径
	 * \endif
	 */
	public String               pszFTPPath;
	
	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 当前接入需要获取当前违章的关联视频的FTP上传路径
	 * \endif
	 */
	public String               pszVideoPath;
}
