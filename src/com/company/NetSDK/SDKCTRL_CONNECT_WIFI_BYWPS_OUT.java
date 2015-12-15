package com.company.NetSDK;

import java.io.Serializable;


public class SDKCTRL_CONNECT_WIFI_BYWPS_OUT implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * return pin,when WPS's connect type is device end,this parameter is valid.
	 * \else
	 * 返回设备PIN码，当WPS连接类型为(设备端)pin码方式时该输出参数有效
	 * \endif
	 */
	public byte            	szRetWLanPin[] = new byte[FinalVar.SDK_MAX_APPIN_LEN];
}
