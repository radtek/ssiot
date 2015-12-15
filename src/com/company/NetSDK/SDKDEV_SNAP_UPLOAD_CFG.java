package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * snap upload DH_DEV_SNAP_UPLOAD_CFG configuration
 * \else
 * 图片上传配置信息 DH_DEV_SNAP_UPLOAD_CFG 配置结构
 * \endif
 */
public class SDKDEV_SNAP_UPLOAD_CFG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * the interval time of upload picture(s)
	 * \else
	 * 定时抓图图片上传间隔，单位秒
	 * \endif
	 */
	public int                 nUploadInterval;
}
