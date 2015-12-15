package com.company.NetSDK;

import java.io.Serializable;


//抓拍客户端类型
public class SNAP_CLIENT_TYPE implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static final int SNAP_CLIENT_TYPE_COMMON = 0;                // 对应"Common"类型, 默认类型
	public static final int SNAP_CLIENT_TYPE_PARKINGSPACE = 1;          // 对应"ParkingSpace"类型, 停车场
}
