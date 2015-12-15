package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * SYSLOG remote server ability
 * \else
 * syslog的远程服务器配置
 * \endif
 */
public class SDKDEV_SYSLOG_REMOTE_SERVER implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Server IP address
	 * \else
	 * 服务器地址
	 * \endif
	 */
	public byte    szServerIp[] = new byte[FinalVar.SDK_MAX_IPADDR_OR_DOMAIN_LEN];

	/**
	 * \if ENGLISH_LANG
	 * Server port
	 * \else
	 * 服务器端口
	 * \endif
	 */
	public int     nServerPort;

	/**
	 * \if ENGLISH_LANG
	 * Server Enable
	 * \else
	 * 服务器使能
	 * \endif
	 */
	public byte    bEnable;
}
