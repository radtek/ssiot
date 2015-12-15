package com.company.NetSDK;

import java.io.Serializable;

public class NET_MOBILE_PUSH_NOTIFY_DEL implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public byte                            szRegisterID[] = new byte[FinalVar.MAX_REGISTER_ID_LEN];         // 手机向Appple/ Android服务器注册返回的，每次不同
}
