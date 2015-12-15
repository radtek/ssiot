package com.company.NetSDK;

import java.io.Serializable;


//CLIENT_FindFileEx(DH_FILE_QUERY_FACE) 录像信息对应查询参数
public class NET_IN_MEDIA_QUERY_FILE implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public String           szDirs;                 // 工作目录列表,一次可查询多个目录,为空表示查询所有目录。目录之间以分号分隔，如“/mnt/dvr/sda0;/mnt/dvr/sda1”,szDirs==null 或"" 表示查询所有
	public int				nMediaType;		        // 文件类型，0:查询任意类型,1:查询jpg图片,2:查询dav
}
