package com.company.NetSDK;

import java.io.Serializable;

//�����豸��չ����
public class SDKDEV_WLAN_DEVICE_EX implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public byte                szSSID[] = new byte[36];                         // ��������
	public byte                szMacAddr[] = new byte[18];                      // mac��ַ
	public byte                byApConnected;                      // �Ƿ����ӳɹ� 0:û�У�1: ���ӳɹ�
	public byte                byLinkMode;                         // ����ģʽ 0:adhoc 1:Infrastructure;
	public int                 nRSSIQuality;                       // �ź�ǿ��(dbm)
	public int        unApMaxBitRate;                     // վ������������
    public byte                byAuthMode;                         // ��֤ģʽ0:OPEN;1:SHARED;2:WPA;3:WPA-PSK;4:WPA2;5:WPA2-PSK;
                                                            // 6:WPA-NONE(����adhoc����ģʽ),
                                                            // 7-11�ǻ��ģʽ��ѡ�������κ�һ�ֶ����Խ������� 
                                                            // 7:WPA-PSK | WPA2-PSK; 8:WPA | WPA2; 9:WPA | WPA-PSK;
                                                            // 10:WPA2 | WPA2-PSK; 11:WPA | WPA-PSK |WPA2 |WPA2-PSK //12: UnKnown
    public byte                byEncrAlgr;                         // ����ģʽ0:off; 2:WEP64bit; 3:WEP128bit; 4:WEP; 5:TKIP; 6:AES(CCMP)
                                                            // 7: TKIP+AES(���ģʽ) 8: UnKnown
    public byte                byLinkQuality;                      // ����ǿ�� 0~100(%)
}
