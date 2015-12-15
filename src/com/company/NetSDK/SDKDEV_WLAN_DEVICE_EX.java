package com.company.NetSDK;

import java.io.Serializable;

//无线设备扩展配置
public class SDKDEV_WLAN_DEVICE_EX implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public byte                szSSID[] = new byte[36];                         // 服务名称
	public byte                szMacAddr[] = new byte[18];                      // mac地址
	public byte                byApConnected;                      // 是否连接成功 0:没有，1: 连接成功
	public byte                byLinkMode;                         // 连接模式 0:adhoc 1:Infrastructure;
	public int                 nRSSIQuality;                       // 信号强度(dbm)
	public int        unApMaxBitRate;                     // 站点的最大传输速率
    public byte                byAuthMode;                         // 认证模式0:OPEN;1:SHARED;2:WPA;3:WPA-PSK;4:WPA2;5:WPA2-PSK;
                                                            // 6:WPA-NONE(用在adhoc网络模式),
                                                            // 7-11是混合模式，选择其中任何一种都可以进行连接 
                                                            // 7:WPA-PSK | WPA2-PSK; 8:WPA | WPA2; 9:WPA | WPA-PSK;
                                                            // 10:WPA2 | WPA2-PSK; 11:WPA | WPA-PSK |WPA2 |WPA2-PSK //12: UnKnown
    public byte                byEncrAlgr;                         // 加密模式0:off; 2:WEP64bit; 3:WEP128bit; 4:WEP; 5:TKIP; 6:AES(CCMP)
                                                            // 7: TKIP+AES(混合模式) 8: UnKnown
    public byte                byLinkQuality;                      // 连接强度 0~100(%)
}
