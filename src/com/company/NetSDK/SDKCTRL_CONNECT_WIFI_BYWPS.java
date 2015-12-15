package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * INetSDK.ControlDevice interface SDK_CTRL_WIFI_BY_WPS command parameter(WPS rapid configuration WIFI)
 * \else
 * INetSDK.ControlDevice接口的SDK_CTRL_WIFI_BY_WPS命令参数(WPS快速配置WIFI)
 * \endif
 */
public class SDKCTRL_CONNECT_WIFI_BYWPS implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * connect parameter(user to fill in)
	 * \else
	 * 连接参数(由用户填写)
	 * \endif
	 */
	public SDKCTRL_CONNECT_WIFI_BYWPS_IN     	stuWpsInfo = new SDKCTRL_CONNECT_WIFI_BYWPS_IN(); 
	
	/**
	 * \if ENGLISH_LANG
	 * return data(device to return to)
	 * \else
	 * 返回数据(由设备返回)
	 * \endif
	 */
	public SDKCTRL_CONNECT_WIFI_BYWPS_OUT    	stuWpsResult = new SDKCTRL_CONNECT_WIFI_BYWPS_OUT();
}
