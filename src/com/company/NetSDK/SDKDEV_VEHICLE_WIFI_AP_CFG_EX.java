package com.company.NetSDK;

import java.io.Serializable;

public class SDKDEV_VEHICLE_WIFI_AP_CFG_EX implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean        bEnable;                            //�Ƿ�����wifi����, 0:��ʹ�� 1:ʹ��
	public int         nRetWifiApNum;                      //�����õ���DHDEV_VEHICLE_WIFI_AP_CFG�ṹ����Ч����
	public int         nMaxWifiApNum;                      //�����DHDEV_VEHICLE_SINGLE_WIFI_AP_CFG����
	public SDKDEV_VEHICLE_SINGLE_WIFI_AP_CFG pWifiAp[];      //����WIFI AP����
	
	public SDKDEV_VEHICLE_WIFI_AP_CFG_EX(int nApNum) {
		pWifiAp = new SDKDEV_VEHICLE_SINGLE_WIFI_AP_CFG[nApNum];
		for (int i = 0; i < nApNum; i++) {
			pWifiAp[i] = new SDKDEV_VEHICLE_SINGLE_WIFI_AP_CFG();
		}
	}
}
