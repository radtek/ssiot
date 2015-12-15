package com.company.NetSDK;

import java.io.Serializable;

//无线路由配置
public class SDKDEV_WIRELESS_ROUTING_CFG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean                bEnable;                        // 使能
	public byte                szSSID[] = new byte[36];                     // SSID名称
    public boolean                bHideSSID;                      // 是否隐藏SSID
    public byte                szIP[] = new byte[FinalVar.SDK_MAX_IPADDR_LEN];        // IP
    public byte                szSubMark[] = new byte[FinalVar.SDK_MAX_IPADDR_LEN];   // 子网掩码
    public byte                szGateWay[] = new byte[FinalVar.SDK_MAX_IPADDR_LEN];   // 网关
    public byte                szCountry[] = new byte[32];                  // 国家, Default默认不指定。国家名称列表参考无线路由能力信息
    public int                 nSafeType;                      // 鉴权模式: 1-不加密; 2-WEP模式; 2-WPA-PSK模式; 3-WPA2-PSK模式
    public int                 nEncryption;                    // 加密方式: WEP模式(1-自动 2-开放 3-共享); WPA-PSK模式/WPA2-PSK模式(4-TKIP 5-AES)
    public byte                szKey[] = new byte[32];                      // 连接密钥
    public int                 nChannel;                       // 信道, 有效信道列表参考无线路由能力信息
    public boolean                bAutoChannelSelect;             // 自动选择信道    
}
