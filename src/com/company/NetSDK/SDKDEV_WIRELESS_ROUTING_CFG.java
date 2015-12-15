package com.company.NetSDK;

import java.io.Serializable;

//����·������
public class SDKDEV_WIRELESS_ROUTING_CFG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean                bEnable;                        // ʹ��
	public byte                szSSID[] = new byte[36];                     // SSID����
    public boolean                bHideSSID;                      // �Ƿ�����SSID
    public byte                szIP[] = new byte[FinalVar.SDK_MAX_IPADDR_LEN];        // IP
    public byte                szSubMark[] = new byte[FinalVar.SDK_MAX_IPADDR_LEN];   // ��������
    public byte                szGateWay[] = new byte[FinalVar.SDK_MAX_IPADDR_LEN];   // ����
    public byte                szCountry[] = new byte[32];                  // ����, DefaultĬ�ϲ�ָ�������������б�ο�����·��������Ϣ
    public int                 nSafeType;                      // ��Ȩģʽ: 1-������; 2-WEPģʽ; 2-WPA-PSKģʽ; 3-WPA2-PSKģʽ
    public int                 nEncryption;                    // ���ܷ�ʽ: WEPģʽ(1-�Զ� 2-���� 3-����); WPA-PSKģʽ/WPA2-PSKģʽ(4-TKIP 5-AES)
    public byte                szKey[] = new byte[32];                      // ������Կ
    public int                 nChannel;                       // �ŵ�, ��Ч�ŵ��б�ο�����·��������Ϣ
    public boolean                bAutoChannelSelect;             // �Զ�ѡ���ŵ�    
}
