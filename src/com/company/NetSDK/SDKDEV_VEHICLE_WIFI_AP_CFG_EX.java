package com.company.NetSDK;

import java.io.Serializable;

public class SDKDEV_VEHICLE_WIFI_AP_CFG_EX implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean        bEnable;                            //是否启用wifi功能, 0:不使能 1:使能
	public int         nRetWifiApNum;                      //解析得到的DHDEV_VEHICLE_WIFI_AP_CFG结构体有效个数
	public int         nMaxWifiApNum;                      //申请的DHDEV_VEHICLE_SINGLE_WIFI_AP_CFG个数
	public SDKDEV_VEHICLE_SINGLE_WIFI_AP_CFG pWifiAp[];      //单个WIFI AP配置
	
	public SDKDEV_VEHICLE_WIFI_AP_CFG_EX(int nApNum) {
		pWifiAp = new SDKDEV_VEHICLE_SINGLE_WIFI_AP_CFG[nApNum];
		for (int i = 0; i < nApNum; i++) {
			pWifiAp[i] = new SDKDEV_VEHICLE_SINGLE_WIFI_AP_CFG();
		}
	}
}
