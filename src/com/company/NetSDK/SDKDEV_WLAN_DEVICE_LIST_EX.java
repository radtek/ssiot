package com.company.NetSDK;

import java.io.Serializable;

//�������������豸��չ�����б�
public class SDKDEV_WLAN_DEVICE_LIST_EX implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public byte                bWlanDevCount;            // �������������豸����
	public SDKDEV_WLAN_DEVICE_EX  lstWlanDev[] = new SDKDEV_WLAN_DEVICE_EX[FinalVar.SDK_MAX_WLANDEVICE_NUM_EX];

}
