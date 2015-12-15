package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Corresponding to StartSearchDevices
 * \else
 * 对应 StartSearchDevices 接口
 * \endif
 */
public class DEVICE_NET_INFO_EX implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * 4 for IPV4, 6 for IPV6
	 * \else
	 * 端口序号
	 * \endif
	 */
	public int                 iIPVersion;
	
	/**
	 * \if ENGLISH_LANG
	 * IP IPV4 like"192.168.0.1" IPV6 like "2008::1/64"
	 * \else
	 * IP IPV4形如"192.168.0.1" IPV6形如"2008::1/64"
	 * \endif
	 */
	public byte				szIP[] = new byte[64];
	
	/**
	 * \if ENGLISH_LANG
	 * Tcp port
	 * \else
	 * tcp端口
	 * \endif
	 */
	public int				    nPort;
	
	/**
	 * \if ENGLISH_LANG
	 * Subnet mask(IPV6 do not have subnet mask)
	 * \else
	 * 子网掩码 IPV6无子网掩码
	 * \endif
	 */
	public byte				szSubmask[] = new byte[64];
	
	/**
	 * \if ENGLISH_LANG
	 * Gateway
	 * \else
	 * 网关
	 * \endif
	 */
	public byte				szGateway[] = new byte[64];
	
	/**
	 * \if ENGLISH_LANG
	 * MAC address
	 * \else
	 * MAC地址
	 * \endif
	 */
	public byte				szMac[] = new byte[FinalVar.SDK_MACADDR_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Device type
	 * \else
	 * 设备类型
	 * \endif
	 */
	public byte				szDeviceType[] = new byte[FinalVar.SDK_DEV_TYPE_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Device manufactory, see EM_IPC_TYPE
	 * \else
	 * 目标设备的生产厂商,具体参考EM_IPC_TYPE类	
	 * \endif
	 */
	public byte                byManuFactory;
	
	/**
	 * \if ENGLISH_LANG
	 * 1-Standard definition 2-High definition
	 * \else
	 * 1-标清 2-高清
	 * \endif
	 */
	public byte                byDefinition;
	
	/**
	 * \if ENGLISH_LANG
	 * Dhcp, true-open, false-close
	 * \else
	 * Dhcp使能状态, true-开, false-关
	 * \endif
	 */
	public boolean                bDhcpEn;
	
	/**
	 * \if ENGLISH_LANG
	 * ECC data 
	 * \else
	 * 校验数据 通过异步搜索回调获取(在修改设备IP时会用此信息进行校验)
	 * \endif
	 */
	public byte                verifyData[] = new byte[88];
	
	/**
	 * \if ENGLISH_LANG
	 * Serial no
	 * \else
	 * 端序列号
	 * \endif
	 */
	public byte                szSerialNo[] = new byte[FinalVar.SDK_DEV_SERIALNO_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Soft version  
	 * \else
	 * 设备软件版本号   
	 * \endif
	 */
	public byte                szDevSoftVersion[] = new byte[FinalVar.SDK_MAX_URL_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Device detail type
	 * \else
	 * 设备型号
	 * \endif
	 */
	public byte                szDetailType[] = new byte[FinalVar.SDK_DEV_TYPE_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * OEM type
	 * \else
	 * OEM客户类型
	 * \endif
	 */
	public byte                szVendor[] = new byte[FinalVar.SDK_MAX_STRING_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Device name
	 * \else
	 * 设备名称
	 * \endif
	 */
	public byte                szDevName[] = new byte[FinalVar.SDK_MACHINE_NAME_NUM];
	
	/**
	 * \if ENGLISH_LANG
	 * User name for log in device(it need be filled when modify device ip)
	 * \else
	 * 登陆设备用户名（在修改设备IP时需要填写）
	 * \endif
	 */
	public byte                szUserName[] = new byte[FinalVar.SDK_USER_NAME_LENGTH_EX];
	
	/**
	 * \if ENGLISH_LANG
	 * Pass word for log in device(it need be filled when modify device ip)
	 * \else
	 * 登陆设备密码（在修改设备IP时需要填写）
	 * \endif
	 */
	public byte                szPassWord[] = new byte[FinalVar.SDK_USER_NAME_LENGTH_EX];
	
	/**
	 * \if ENGLISH_LANG
	 * HTTP server port
	 * \else
	 * HTTP服务端口号
	 * \endif
	 */
	public int					nHttpPort;
	
	/**
	 * \if ENGLISH_LANG
	 * Count of video input channel
	 * \else
	 * 视频输入通道数
	 * \endif
	 */
	public int                	wVideoInputCh;
	
	/**
	 * \if ENGLISH_LANG
	 * Count of remote video input
	 * \else
	 * 远程视频输入通道数
	 * \endif
	 */
	public int                	wRemoteVideoInputCh;
	
	/**
	 * \if ENGLISH_LANG
	 * Count of video output channel 
	 * \else
	 * 视频输出通道数
	 * \endif
	 */
	public int                	wVideoOutputCh;
	
	/**
	 * \if ENGLISH_LANG
	 * Count of alarm input
	 * \else
	 * 报警输入通道数
	 * \endif
	 */
	public int                	wAlarmInputCh;
	
	/**
	 * \if ENGLISH_LANG
	 * Count of alarm output
	 * \else
	 * 报警输出通道数
	 * \endif
	 */
	public int                	wAlarmOutputCh;
}
