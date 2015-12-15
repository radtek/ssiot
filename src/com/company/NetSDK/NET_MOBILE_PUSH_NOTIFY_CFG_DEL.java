package com.company.NetSDK;

import java.io.Serializable;

public class NET_MOBILE_PUSH_NOTIFY_CFG_DEL implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public byte                            szRegisterID[] = new byte[FinalVar.MAX_REGISTER_ID_LEN];         // 手机向Appple/ Android服务器注册返回的，每次不同
	public byte                            szAppID[] = new byte[FinalVar.MAX_APP_ID_LEN];                   // 手机每开一个客户端，会产生一个
}
