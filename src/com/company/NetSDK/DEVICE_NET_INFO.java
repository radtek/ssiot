package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Corresponding to SearchDevices
 * \else
 * 对应 SearchDevices 接口
 * \endif
 */
public class DEVICE_NET_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * IP
	 * \else
	 * IP
	 * \endif
	 */
	public byte				szIP[] = new byte[FinalVar.SDK_MAX_IPADDR_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Port
	 * \else
	 * tcp端口
	 * \endif
	 */
	public int					nPort;
	
	/**
	 * \if ENGLISH_LANG
	 * Subnet mask
	 * \else
	 * 子网掩码
	 * \endif
	 */
	public byte				szSubmask[] = new byte[FinalVar.SDK_MAX_IPADDR_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Gateway
	 * \else
	 * 网关
	 * \endif
	 */
	public byte				szGateway[] = new byte[FinalVar.SDK_MAX_IPADDR_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * MAC address
	 * \else
	 * MAC地址
	 * \endif
	 */
	public byte				szMac[] = new byte[FinalVar.SDK_MACADDR_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Device type
	 * \else
	 * 端设备类型
	 * \endif
	 */
	public byte				szDeviceType[] = new byte[FinalVar.SDK_DEV_TYPE_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Manufactory
	 * \else
	 * 目标设备的生产厂商,具体参考 EM_IPC_TYPE 类
	 * \endif
	 */
	public byte                byManuFactory;
	
	/**
	 * \if ENGLISH_LANG
	 * 4: IPv4, szXXX is in format with dot; 6:IPv6, szXXX is 128-bit *16 bytes) numerical format
	 * \else
	 * 4: IPv4, szXXX为点分字符串形式;  6:IPv6, szXXX为128位(16字节)数值形式
	 * \endif
	 */
	public byte                byIPVersion;
}
