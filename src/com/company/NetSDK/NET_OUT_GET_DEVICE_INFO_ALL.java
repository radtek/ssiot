package com.company.NetSDK;

import java.io.Serializable;

public class NET_OUT_GET_DEVICE_INFO_ALL implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int                         nDevMax;        // 设备信息的最大个数, 指明pstuInfo内存空间
	public int                         nDevNum;        // 实际返回的设备信息的个数
	public SDK_REMOTE_DEVICE            pstuInfo[];       // 设备信息指针，该结构体内部成员 dwSize 需用户赋值
	
	public NET_OUT_GET_DEVICE_INFO_ALL(int nDevMax) {
		this.nDevMax = nDevMax;
		pstuInfo = new SDK_REMOTE_DEVICE[this.nDevMax];
		for (int i = 0; i < this.nDevMax; i++) {
			pstuInfo[i] = new SDK_REMOTE_DEVICE();
		}
	}
}
