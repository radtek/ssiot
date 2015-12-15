package com.company.NetSDK;

import java.io.Serializable;

//码流加密配置信息
public class SDKEDV_STREAM_ENCRYPT implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public byte                    byEncrptAlgoType;           // 加密算法类型：00: AES、01:DES、02: 3DES
	public ALGO_PARAM_INFO         stuEncrptAlgoparam = new ALGO_PARAM_INFO();         // 加密算法参数
	public ENCRYPT_KEY_INFO        stuEncryptKeys[] = new ENCRYPT_KEY_INFO[32];         // 各通道的密钥信息 
    public byte                    byEncrptPlanEnable;         // 加密计划使能
    public NET_TIME                stuPreTime = new NET_TIME();                 // 加密计划的开始时间
    
    public SDKEDV_STREAM_ENCRYPT() {
    	for (int i = 0; i < 32; i++) {
    		stuEncryptKeys[i] = new ENCRYPT_KEY_INFO();
    	}
    }
}
