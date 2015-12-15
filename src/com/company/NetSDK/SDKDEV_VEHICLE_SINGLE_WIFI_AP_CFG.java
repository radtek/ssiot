package com.company.NetSDK;

import java.io.Serializable;

public class SDKDEV_VEHICLE_SINGLE_WIFI_AP_CFG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean        bIsScan;                            //0:��ɨ��wifi (�ֶ���ӵ�), 1ɨ�赽��wifi
	public byte        szSSID[] = new byte[128];                        //SSID
	public int         nSafeType;                          //У������
                                                    //0:OPEN 
                                                    //1:RESTRICTE
                                                    //2:WEP
                                                    //3:WPA
                                                    //4:WPA2
                                                    //5:WPA-PSK
                                                    //6:WPA2-PSK
	public int        nEncryprion;                         //���ܷ�ʽ
                                                    //0:OPEN
                                                    //1:TKIP
                                                    //2:WEP
                                                    //3:AES
                                                    //4:NONE(��У��)
                                                    //5:AUTO
                                                    //6:SHARED
    public byte        szKey[] = new byte[128];                         //������Կ
    public int         nStrength;                          //APվ���ź�
    public int         nMaxBitRate;                        //APվ������������,����λ ֻ��
    public int         nIsCnnted;                          //�Ƿ����ӳɹ�ֻ��
    public int         nIsSaved;                           //�Ƿ��Ѿ�����ֻ��
    public int         nPriority;                          //���ȼ�,(1-32)
    public byte        szHostIP[] = new byte[128];                      //������ַ
    public byte        szHostNetmask[] = new byte[128];                 //��������
    public byte        szHostGateway[] = new byte[128];                 //��������
    public int         nWifiFreq;                          //����Ƶ�ʣ�����ͨ����ʶ
    public int         nEnDHCP;                            //0����ʹ�� 1��ʹ��(ɨ�赽��dhcpĬ��ʹ�ܴ�)
    public byte        byKeyIndex;                         //WEPУ�������µ���Կ����,0����֧����Կ���� >0:��Կ����ֵ����Χ1-4
}
