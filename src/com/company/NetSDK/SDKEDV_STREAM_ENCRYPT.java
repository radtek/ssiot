package com.company.NetSDK;

import java.io.Serializable;

//��������������Ϣ
public class SDKEDV_STREAM_ENCRYPT implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public byte                    byEncrptAlgoType;           // �����㷨���ͣ�00: AES��01:DES��02: 3DES
	public ALGO_PARAM_INFO         stuEncrptAlgoparam = new ALGO_PARAM_INFO();         // �����㷨����
	public ENCRYPT_KEY_INFO        stuEncryptKeys[] = new ENCRYPT_KEY_INFO[32];         // ��ͨ������Կ��Ϣ 
    public byte                    byEncrptPlanEnable;         // ���ܼƻ�ʹ��
    public NET_TIME                stuPreTime = new NET_TIME();                 // ���ܼƻ��Ŀ�ʼʱ��
    
    public SDKEDV_STREAM_ENCRYPT() {
    	for (int i = 0; i < 32; i++) {
    		stuEncryptKeys[i] = new ENCRYPT_KEY_INFO();
    	}
    }
}
