package com.company.NetSDK;

import java.io.Serializable;

public class SDKDEV_VEHICLE_SINGLE_WIFI_AP_CFG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean        bIsScan;                            //0:非扫描wifi (手动添加的), 1扫描到的wifi
	public byte        szSSID[] = new byte[128];                        //SSID
	public int         nSafeType;                          //校验类型
                                                    //0:OPEN 
                                                    //1:RESTRICTE
                                                    //2:WEP
                                                    //3:WPA
                                                    //4:WPA2
                                                    //5:WPA-PSK
                                                    //6:WPA2-PSK
	public int        nEncryprion;                         //加密方式
                                                    //0:OPEN
                                                    //1:TKIP
                                                    //2:WEP
                                                    //3:AES
                                                    //4:NONE(不校验)
                                                    //5:AUTO
                                                    //6:SHARED
    public byte        szKey[] = new byte[128];                         //连接密钥
    public int         nStrength;                          //AP站点信号
    public int         nMaxBitRate;                        //AP站点的最大传输速率,带单位 只读
    public int         nIsCnnted;                          //是否连接成功只读
    public int         nIsSaved;                           //是否已经保存只读
    public int         nPriority;                          //优先级,(1-32)
    public byte        szHostIP[] = new byte[128];                      //主机地址
    public byte        szHostNetmask[] = new byte[128];                 //主机掩码
    public byte        szHostGateway[] = new byte[128];                 //主机网关
    public int         nWifiFreq;                          //无线频率，采用通道标识
    public int         nEnDHCP;                            //0：不使能 1：使能(扫描到的dhcp默认使能打开)
    public byte        byKeyIndex;                         //WEP校验类型下的密钥索引,0：不支持密钥索引 >0:密钥索引值，范围1-4
}
