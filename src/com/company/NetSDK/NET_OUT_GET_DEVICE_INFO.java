package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * INetSDK.QueryDevInfo , NET_QUERY_DEV_REMOTE_DEVICE_INFO inquire the output parameter of remote device information 
 * \else
 * INetSDK.QueryDevInfo , NET_QUERY_DEV_REMOTE_DEVICE_INFO 查询远程设备信息输出参数
 * \endif
 */
public class NET_OUT_GET_DEVICE_INFO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Device information, the member of this structur,  dwSize, should be assigned by user
	 * \else
	 * 设备信息，该结构体内部成员 dwSize 需用户赋值
	 * \endif
	 */
	public SDK_REMOTE_DEVICE            stuInfo = new SDK_REMOTE_DEVICE(); 
}
