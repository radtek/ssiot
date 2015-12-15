package com.company.NetSDK;

import java.io.Serializable;


public class FinalVar implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * MAX length of path
	 * \else
	 * 通用字符串长度
	 * \endif
	 */
	public static final int MAX_PATH              = 260;   
	/**
	 * \if ENGLISH_LANG
	 * Device SN string length
	 * \else
	 * 设备序列号字符长度
	 * \endif
	 */
	public static final int SDK_SERIALNO_LEN= 48;			  
	/**
	 * \if ENGLISH_LANG
	 * Max HDD number
	 * \else
	 * 最大硬盘个数
	 * \endif
	 */
	public static final int SDK_MAX_DISKNUM= 256;			  
	/**
	 * \if ENGLISH_LANG
	 * Max SD card number
	 * \else
	 * 最大SD卡个数
	 * \endif
	 */
	public static final int SDK_MAX_SDCARDNUM= 32;			  
	/**
	 * \if ENGLISH_LANG
	 * Max buner amount
	 * \else
	 * 最大刻录设备个数
	 * \endif
	 */
	public static final int SDK_MAX_BURNING_DEV_NUM= 32;			  
	/**
	 * \if ENGLISH_LANG
	 * Burner name max length
	 * \else
	 * 刻录设备名字最大长度
	 * \endif
	 */
	public static final int SDK_BURNING_DEV_NAMELEN= 32;			  
	/**
	 * \if ENGLISH_LANG
	 * The max connnect count of SDK
	 * \else
	 * SDK最大连接数
	 * \endif
	 */
	public static final int SDK_MAX_LINK = 6;
	/**
	 * \if ENGLISH_LANG
	 * Max channel amount
	 * \else
	 * 最大通道个数
	 * \endif
	 */
	public static final int SDK_MAX_CHANNUM= 16;			  
	/**
	 * \if ENGLISH_LANG
	 * decoder device max channel number
	 * \else
	 * 解码器最大通道数
	 * \endif
	 */
	public static final int SDK_MAX_DECODER_CHANNUM= 64;			  
	/**
	 * \if ENGLISH_LANG
	 * Max alarm input amount
	 * \else
	 * 最大报警输入个数
	 * \endif
	 */
	public static final int SDK_MAX_ALARMIN= 128;			  
	/**
	 * \if ENGLISH_LANG
	 * Max alarm output amount
	 * \else
	 * 最大报警输出个数
	 * \endif
	 */
	public static final int SDK_MAX_ALARMOUT= 64;			  
	/**
	 * \if ENGLISH_LANG
	 * Max user right amount
	 * \else
	 * 用户权限个数上限
	 * \endif
	 */
	public static final int SDK_MAX_RIGHT_NUM= 100;			  
	/**
	 * \if ENGLISH_LANG
	 * Max user group amount
	 * \else
	 * 用户组个数上限
	 * \endif
	 */
	public static final int SDK_MAX_GROUP_NUM= 20;			  
	/**
	 * \if ENGLISH_LANG
	 * Max user account amount
	 * \else
	 * 用户个数上限
	 * \endif
	 */
	public static final int SDK_MAX_USER_NUM= 200;			  
	/**
	 * \if ENGLISH_LANG
	 * Right name length
	 * \else
	 * 权限名长度
	 * \endif
	 */
	public static final int SDK_RIGHT_NAME_LENGTH= 32;			  
	/**
	 * \if ENGLISH_LANG
	 * User name length
	 * \else
	 * 用户名长度
	 * \endif
	 */
	public static final int SDK_USER_NAME_LENGTH= 8;			  
	/**
	 * \if ENGLISH_LANG
	 * User password length
	 * \else
	 * 用户密码长度
	 * \endif
	 */
	public static final int SDK_USER_PSW_LENGTH= 8;			  
	/**
	 * \if ENGLISH_LANG
	 * Note length 
	 * \else
	 * 备注长度
	 * \endif
	 */
	public static final int SDK_MEMO_LENGTH= 32;			  
	/**
	 * \if ENGLISH_LANG
	 * Max string length
	 * \else
	 * 字符串长度
	 * \endif
	 */
	public static final int SDK_MAX_STRING_LEN= 128;
	/**
	 * \if ENGLISH_LANG
	 * Max six rows
	 * \else
	 * 最多六行
	 * \endif
	 */
	public static final int MAX_STRING_LINE_LEN= 6;			  
	/**
	 * \if ENGLISH_LANG
	 * Line max length
	 * \else
	 * 每行最大长度
	 * \endif
	 */
	public static final int MAX_PER_STRING_LEN= 20;			  
	/**
	 * \if ENGLISH_LANG
	 * The user name length the new mail structure supported
	 * \else
	 * 新的邮件结构体支持的用户名长度
	 * \endif
	 */
	public static final int SDK_MAX_MAIL_NAME_LEN= 64;			  
	/**
	 * \if ENGLISH_LANG
	 * Password length the new mail structhre supported
	 * \else
	 * 新的邮件结构体支持的密码长度
	 * \endif
	 */
	public static final int SDK_MAX_MAIL_PSW_LEN= 64;			  
	/**
	 * \if ENGLISH_LANG
	 * Speed limit string max length
	 * \else
	 * 限速类型字符串长度
	 * \endif
	 */
	public static final int SDK_SPEEDLIMIT_TYPE_LEN= 32;            
	/**
	 * \if ENGLISH_LANG
	 * Vehicle info type max length
	 * \else
	 * 车载自定义信息类型字符串长度
	 * \endif
	 */
	public static final int SDK_VEHICLE_TYPE_LEN= 32;            
	/**
	 * \if ENGLISH_LANG
	 * Vehicle info string max length
	 * \else
	 * 车载自定义信息字符串长度
	 * \endif
	 */
	public static final int SDK_VEHICLE_INFO_LEN= 32;            
	/**
	 * \if ENGLISH_LANG
	 * Driver no string max length
	 * \else
	 * 车载自定义信息司机工号字符串长度
	 * \endif
	 */
	public static final int SDK_VEHICLE_DRIVERNO_LEN= 32;            
	/**
	 * \if ENGLISH_LANG
	 * Max supported crossing num 
	 * \else
	 * 最大点位
	 * \endif
	 */
	public static final int SDK_MAX_CROSSING_NUM= 128;           
	/**
	 * \if ENGLISH_LANG
	 * Max crossing ID length
	 * \else
	 * 路口序列号最大长度
	 * \endif
	 */
	public static final int SDK_MAX_CROSSING_ID= 32;            
	/**
	 * \if ENGLISH_LANG
	 * Max card info length
	 * \else
	 * 卡号信息最大长度
	 * \endif
	 */
	public static final int SDK_MAX_CARD_INFO_LEN= 256;			  
	/**
	 * \if ENGLISH_LANG
	 * Extended max channel number
	 * \else
	 * 最大通道数扩展  
	 * \endif
	 */
	public static final int SDK_MAX_CHANNUM_EX= 32;            
	/**
	 * \if ENGLISH_LANG
	 * Max number of IP for saerch
	 * \else
	 * 最大搜索IP个数
	 * \endif
	 */
	public static final int SDK_MAX_SAERCH_IP_NUM= 256;           
	/**
	 * \if ENGLISH_LANG
	 * Hard disk type maximum length
	 * \else
	 * 硬盘型号最大长度
	 * \endif
	 */
	public static final int SDK_MAX_HARDDISK_TYPE_LEN= 32;			  
	/**
	 * \if ENGLISH_LANG
	 * Hard disk serial maximum length
	 * \else
	 * 硬盘序列号最大长度
	 * \endif
	 */
	public static final int SDK_MAX_HARDDISK_SERIAL_LEN= 32;			  
	/**
	 * \if ENGLISH_LANG
	 * Value of SIM maximum length
	 * \else
	 * SIM卡的值的最大长度
	 * \endif
	 */
	public static final int SDK_MAX_SIM_LEN= 16;			  
	/**
	 * \if ENGLISH_LANG
	 * Pick up SIM maximum number
	 * \else
	 * 车载SIM卡最大个数
	 * \endif
	 */
	public static final int SDK_MAX_SIM_NUM= 10;			  
	/**
	 * \if ENGLISH_LANG
	 * Version maximum length
	 * \else
	 * 软件版本号最大长度
	 * \endif
	 */
	public static final int SDK_MAX_VERSION_LEN= 32;			  
	/**
	 * \if ENGLISH_LANG
	 * Value of MDN maximum length
	 * \else
	 * MDN的值的最大长度
	 * \endif
	 */
	public static final int SDK_MAX_MDN_LEN= 36;			  
	/**
	 * \if ENGLISH_LANG
	 * Support the card number
	 * \else
	 * 支持的网卡个数
	 * \endif
	 */
	public static final int SDK_MAX_NETINTERFACE_NUM= 64;            
	/**
	 * \if ENGLISH_LANG
	 * Length of event name
	 * \else
	 * 事件名称长度
	 * \endif
	 */
	public static final int SDK_EVENT_NAME_LEN= 128;			  
	/**
	 * \if ENGLISH_LANG
	 * Length of storage name
	 * \else
	 * 存储设备名称长度
	 * \endif
	 */
	public static final int SDK_STORAGE_NAME_LEN= 128;			  
	/**
	 * \if ENGLISH_LANG
	 * Carport liht maximum number
	 * \else
	 * 最大车位灯个数
	 * \endif
	 */
	public static final int SDK_MAX_CARPORTLIGHT_NUM= 4;             
	/**
	 * \if ENGLISH_LANG
	 * Length of station name
	 * \else
	 * 车站站点名称长度   
	 * \endif
	 */
	public static final int SDK_STATION_NAME_LEN= 32;
	/**
	 * \if ENGLISH_LANG
	 * Version string max length
	 * \else
	 * 版本字符串最大长度
	 * \endif
	 */
	public static final int SDK_MAX_VERSION_STR= 64;
	/**
	 * \if ENGLISH_LANG
	 * General string length 16
	 * \else
	 * 通用字符串长度16
	 * \endif
	 */
	public static final int SDK_COMMON_STRING_16= 16;            
	/**
	 * \if ENGLISH_LANG
	 * General string length 32
	 * \else
	 * 通用字符串长度32
	 * \endif
	 */
	public static final int SDK_COMMON_STRING_32= 32;            
	/**
	 * \if ENGLISH_LANG
	 * General string length 64
	 * \else
	 * 通用字符串长度64
	 * \endif
	 */
	public static final int SDK_COMMON_STRING_64= 64;            
	/**
	 * \if ENGLISH_LANG
	 * General string length 128
	 * \else
	 * 通用字符串长度128
	 * \endif
	 */
	public static final int SDK_COMMON_STRING_128= 128;           
	/**
	 * \if ENGLISH_LANG
	 * General string length 256
	 * \else
	 * 通用字符串长度256
	 * \endif
	 */
	public static final int SDK_COMMON_STRING_256= 256;           
	/**
	 * \if ENGLISH_LANG
	 * General string length 512
	 * \else
	 * 通用字符串长度512
	 * \endif
	 */
	public static final int SDK_COMMON_STRING_512= 512;           
	/**
	 * \if ENGLISH_LANG
	 * General string length 1024
	 * \else
	 * 通用字符串长度===1024
	 * \endif
	 */
	public static final int SDK_COMMON_STRING_1024= 1024;       
	
	/**
	 * \if ENGLISH_LANG
	 * Max lower matrix number
	 * \else
	 * 最大下位矩阵数
	 * \endif
	 */
	public static final int SDK_MAX_LOWER_MITRIX_NUM             =         16 ;    
	/**
	 * \if ENGLISH_LANG
	 * Max writing channel number
	 * \else
	 * 最大刻录通道数
	 * \endif
	 */
	public static final int SDK_MAX_BURN_CHANNEL_NUM             =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max remote storage area quantity
	 * \else
	 * 最大远程存储区块数量
	 * \endif
	 */
	public static final int SDK_MAX_NET_STRORAGE_BLOCK_NUM       =         64 ;  
	
	/**
	 * \if ENGLISH_LANG
	 * Case staff max quantity
	 * \else
	 * 案件人员最大数量
	 * \endif
	 */
	public static final int SDK_MAX_CASE_PERSON_NUM              =         32 ;
	
	/**
	 * \if ENGLISH_LANG
	 * Max channel preview playback channel number
	 * \else
	 * 最大多通道预览回放通道数
	 * \endif
	 */
	public static final int SDK_MAX_MULTIPLAYBACK_CHANNEL_NUM    =         64 ;
	
	/**
	 * \if ENGLISH_LANG
	 * Max channel preview playback split mode number
	 * \else
	 * 最大多通道预览回放分割模式数
	 * \endif
	 */
	public static final int SDK_MAX_MULTIPLAYBACK_SPLIT_NUM      =         32 ;
	
	/**
	 * \if ENGLISH_LANG
	 * Max audio encode type number
	 * \else
	 * 最大语音编码类型个数
	 * \endif
	 */
	public static final int SDK_MAX_AUDIO_ENCODE_TYPE             =         64 ;
	
	/**
	 * \if ENGLISH_LANG
	 * Access control name length
	 * \else
	 * 门禁名称长度
	 * \endif
	 */
	public static final int SDK_MAX_ACCESS_NAME_LEN               =         64  ;
	
	/**
	 * \if ENGLISH_LANG
	 * Extension module alarm channel name length
	 * \else
	 * 扩展模块报警通道名称长度
	 * \endif
	 */
	public static final int SDK_MAX_EXALARMCHANNEL_NAME_LEN       =         128 ;
  
	/**
	 * \if ENGLISH_LANG
	 * Search general alarm status(including external alarm,video loss, motion detection)
	 * \else
	 * 查询普通报警状态(包括外部报警，视频丢失，动态检测)
	 * \endif
	 */
	public static final int SDK_DEVSTATE_COMM_ALARM	            =     0x0001 ;  
	/**
	 * \if ENGLISH_LANG
	 * Search camera masking alarm status
	 * \else
	 * 查询遮挡报警状态
	 * \endif
	 */
	public static final int SDK_DEVSTATE_SHELTER_ALARM           =     0x0002 ;   
	/**
	 * \if ENGLISH_LANG
	 * Search record status 
	 * \else
	 * 查询录象状态
	 * \endif
	 */
	public static final int SDK_DEVSTATE_RECORDING               =     0x0003 ;   
	/**
	 * \if ENGLISH_LANG
	 * Search HDD information 
	 * \else
	 * 查询硬盘信息
	 * \endif
	 */
	public static final int SDK_DEVSTATE_DISK                    =     0x0004 ;   
	/**
	 * \if ENGLISH_LANG
	 * Search system resources status 
	 * \else
	 * 查询系统资源状态
	 * \endif
	 */
	public static final int SDK_DEVSTATE_RESOURCE                =     0x0005 ;   
	/**
	 * \if ENGLISH_LANG
	 * Search channel bit stream 
	 * \else
	 * 查询通道码流
	 * \endif
	 */
	public static final int SDK_DEVSTATE_BITRATE                 =     0x0006 ;   
	/**
	 * \if ENGLISH_LANG
	 * Search device connection status 
	 * \else
	 * 查询设备连接状态
	 * \endif
	 */
	public static final int SDK_DEVSTATE_CONN                    =     0x0007 ;   
	/**
	 * \if ENGLISH_LANG
	 * Search network protocol version number , pBuf = int*
	 * \else
	 * 查询网络协议版本号，pBuf = int*
	 * \endif
	 */
	public static final int SDK_DEVSTATE_PROTOCAL_VER            =     0x0008 ;   
	/**
	 * \if ENGLISH_LANG
	 * Search the audio talk format the device supported. Please refer to structure SDKDEV_TALKFORMAT_LIST
	 * \else
	 * 查询设备支持的语音对讲格式列表，见结构体 SDKDEV_TALKFORMAT_LIST
	 * \endif
	 */
	public static final int SDK_DEVSTATE_TALK_ECTYPE             =     0x0009 ;   
	/**
	 * \if ENGLISH_LANG
	 * Search SD card information(FOR IPC series)
	 * \else
	 * 查询SD卡信息(IPC类产品)
	 * \endif
	 */
	public static final int SDK_DEVSTATE_SD_CARD                 =     0x000A ;   
	/**
	 * \if ENGLISH_LANG
	 * Search burner information
	 * \else
	 * 查询刻录机信息
	 * \endif
	 */
	public static final int SDK_DEVSTATE_BURNING_DEV             =     0x000B ;   
	/**
	 * \if ENGLISH_LANG
	 * Search burning information
	 * \else
	 * 查询刻录进度
	 * \endif
	 */
	public static final int SDK_DEVSTATE_BURNING_PROGRESS        =     0x000C ;   
	/**
	 * \if ENGLISH_LANG
	 * Search the embedded platform the device supported
	 * \else
	 * 查询设备支持的接入平台
	 * \endif
	 */
	public static final int SDK_DEVSTATE_PLATFORM                =     0x000D ;   
	/**
	 * \if ENGLISH_LANG
	 * Search camera property information ( for IPC series),pBuf = SDKDEV_CAMERA_INFO *,there can be several structure.
	 * \else
	 * 查询摄像头属性信息(IPC类产品)，pBuf = SDKDEV_CAMERA_INFO *，可以有多个结构体
	 * \endif
	 */
	public static final int SDK_DEVSTATE_CAMERA                  =     0x000E ;   
	/**
	 * \if ENGLISH_LANG
	 * Search device software version information
	 * \else
	 * 查询设备软件版本信息
	 * \endif
	 */
	public static final int SDK_DEVSTATE_SOFTWARE                =     0x000F ;   
	/**
	 * \if ENGLISH_LANG
	 * Search the audio type the device supported 
	 * \else
	 * 查询设备支持的语音种类
	 * \endif
	 */
	public static final int SDK_DEVSTATE_LANGUAGE                =     0x0010 ;   
	/**
	 * \if ENGLISH_LANG
	 * Search DSP capacity description 
	 * \else
	 * 查询DSP能力描述(对应结构体SDKDEV_DSP_ENCODECAP)
	 * \endif
	 */
	public static final int SDK_DEVSTATE_DSP                     =     0x0011 ;   
	/**
	 * \if ENGLISH_LANG
	 * Search OEM information
	 * \else
	 * 查询OEM信息
	 * \endif
	 */
	public static final int SDK_DEVSTATE_OEM                     =     0x0012 ;   
	/**
	 * \if ENGLISH_LANG
	 * Search network running status information 
	 * \else
	 * 查询网络运行状态信息
	 * \endif
	 */
	public static final int SDK_DEVSTATE_NET                     =     0x0013 ;   
	/**
	 * \if ENGLISH_LANG
	 * Search function attributes(for IPC serirs)
	 * \else
	 * 查询设备类型
	 * \endif
	 */
	public static final int SDK_DEVSTATE_TYPE                    =     0x0014 ;   
	/**
	 * \if ENGLISH_LANG
	 * Search snapshot function attribute(For IPC series)
	 * \else
	 * 查询功能属性(IPC类产品)
	 * \endif
	 */
	public static final int SDK_DEVSTATE_SNAP                    =     0x0015 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query the first time and the recent video time
	 * \else
	 * 查询最早录像时间和最近录像时间
	 * \endif
	 */
	public static final int SDK_DEVSTATE_RECORD_TIME             =     0x0016 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query the wireless network signal strength,Please refer to structure SDKDEV_WIRELESS_RSS_INFO
	 * \else
	 * 查询无线网络信号强度，见结构体 SDKDEV_WIRELESS_RSS_INFO
	 * \endif
	 */
	public static final int SDK_DEVSTATE_NET_RSSI                =     0x0017 ;   
	/**
	 * \if ENGLISH_LANG
	 * Burning options inquiry
	 * \else
	 * 查询附件刻录选项
	 * \endif
	 */
	public static final int SDK_DEVSTATE_BURNING_ATTACH          =     0x0018 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query the list of backup device
	 * \else
	 * 查询备份设备列表
	 * \endif
	 */
	public static final int SDK_DEVSTATE_BACKUP_DEV              =     0x0019 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query the backup device information
	 * \else
	 * 查询备份设备详细信息
	 * \endif
	 */
	public static final int SDK_DEVSTATE_BACKUP_DEV_INFO         =     0x001a ;   
	/**
	 * \if ENGLISH_LANG
	 * Backup rate of progress
	 * \else
	 * 备份进度反馈
	 * \endif
	 */
	public static final int SDK_DEVSTATE_BACKUP_FEEDBACK         =     0x001b ;   
	/**
	 * \if ENGLISH_LANG
	 * Query ATM trade type
	 * \else
	 * 查询ATM交易类型
	 * \endif
	 */
	public static final int SDK_DEVSTATE_ATM_QUERY_TRADE         =     0x001c ;   
	/**
	 * \if ENGLISH_LANG
	 * Query sip state
	 * \else
	 * 查询sip状态
	 * \endif
	 */
	public static final int SDK_DEVSTATE_SIP                     =     0x001d ;   
	/**
	 * \if ENGLISH_LANG
	 * Query wifi state of mobile DVR
	 * \else
	 * 查询车载wifi状态
	 * \endif
	 */
	public static final int SDK_DEVSTATE_VICHILE_STATE           =     0x001e ;   
	/**
	 * \if ENGLISH_LANG
	 * Query Email Function
	 * \else
	 * 查询邮件配置是否成功
	 * \endif
	 */
	public static final int SDK_DEVSTATE_TEST_EMAIL              =     0x001f ;   
	/**
	 * \if ENGLISH_LANG
	 * Query Hard Disk Information
	 * \else
	 * 查询硬盘smart信息
	 * \endif
	 */
	public static final int SDK_DEVSTATE_SMART_HARD_DISK         =     0x0020 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query Snap Picture Function
	 * \else
	 * 查询抓图设置是否成功
	 * \endif
	 */
	public static final int SDK_DEVSTATE_TEST_SNAPPICTURE        =     0x0021 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query static alarm state
	 * \else
	 * 查询静态报警状态
	 * \endif
	 */
	public static final int SDK_DEVSTATE_STATIC_ALARM            =     0x0022 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query submodule information
	 * \else
	 * 查询设备子模块信息
	 * \endif
	 */
	public static final int SDK_DEVSTATE_SUBMODULE_INFO          =     0x0023 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query harddisk damage ability
	 * \else
	 * 查询硬盘坏道能力 
	 * \endif
	 */
	public static final int SDK_DEVSTATE_DISKDAMAGE              =     0x0024 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query device supported IPC ability,see struct SDK_DEV_IPC_INFO 
	 * \else
	 * 查询设备支持的IPC能力, 见结构体 SDK_DEV_IPC_INFO
	 * \endif
	 */
	public static final int SDK_DEVSTATE_IPC                     =     0x0025 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query alarm arm disarm state
	 * \else
	 * 查询报警布撤防状态
	 * \endif
	 */
	public static final int SDK_DEVSTATE_ALARM_ARM_DISARM        =     0x0026 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query ACC power off state(return a DWORD type value, 1 means power off,0 means power on)
	 * \else
	 * 查询ACC断电报警状态(返回一个DWORD, 1表示断电，0表示通电)
	 * \endif
	 */
	public static final int SDK_DEVSTATE_ACC_POWEROFF_ALARM      =     0x0027 ;   
	/**
	 * \if ENGLISH_LANG
	 * FTP server connect test
	 * \else
	 * 测试FTP服务器连接
	 * \endif
	 */
	public static final int SDK_DEVSTATE_TEST_FTP_SERVER         =     0x0028 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query 3G Flow exceed state info(see struct SDKDEV_3GFLOW_EXCEED_STATE_INFO)
	 * \else
	 * 查询3G流量超出阈值状态,(见结构体SDKDEV_3GFLOW_EXCEED_STATE_INFO)
	 * \endif
	 */
	public static final int SDK_DEVSTATE_3GFLOW_EXCEED           =     0x0029 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query 3G Flow info(see struct SDK_DEV_3GFLOW_INFO )
	 * \else
	 * 端查询3G网络流量信息,见结构体 SDK_DEV_3GFLOW_INFO
	 * \endif
	 */
	public static final int SDK_DEVSTATE_3GFLOW_INFO             =     0x002a ;   
	/**
	 * \if ENGLISH_LANG
	 * Vihicle information uploading, ALARM_VEHICLE_INFO_UPLOAD
	 * \else
	 * 车载自定义信息上传(见结构体ALARM_VEHICLE_INFO_UPLOAD)
	 * \endif
	 */
	public static final int SDK_DEVSTATE_VIHICLE_INFO_UPLOAD     =     0x002b ;   
	/**
	 * \if ENGLISH_LANG
	 * QSpeed limit alarm, ALARM_SPEED_LIMIT
	 * \else
	 * 查询限速报警状态(见结构体ALARM_SPEED_LIMIT)
	 * \endif
	 */
	public static final int SDK_DEVSTATE_SPEED_LIMIT             =     0x002c ;   
	/**
	 * \if ENGLISH_LANG
	 * Query DSP expended cap(struct SDKDEV_DSP_ENCODECAP_EX )
	 * \else
	 * 查询DSP扩展能力描述(对应结构体SDKDEV_DSP_ENCODECAP_EX)
	 * \endif
	 */
	public static final int SDK_DEVSTATE_DSP_EX                  =     0x002d ;   
	/**
	 * \if ENGLISH_LANG
	 * Query 3G module info(struct SDK_DEV_3GMODLE_INFO )
	 * \else
	 * 查询3G模块信息(对应结构体 SDK_DEV_3GMODULE_INFO )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_3GMODULE_INFO           =     0x002e ;   
	/**
	 * \if ENGLISH_LANG
	 * Query multi DDNS status(struct SDK_DEV_MULTI_DDNS_INFO )
	 * \else
	 * 查询多DDNS状态信息(对应结构体 SDK_DEV_MULTI_DDNS_INFO )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_MULTI_DDNS              =     0x002f ;   
	/**
	 * \if ENGLISH_LANG
	 * Query Device URL info(struct SDK_DEV_URL_INFO )
	 * \else
	 * 查询设备配置URL信息(对应结构体 SDK_DEV_URL_INFO )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_CONFIG_URL              =     0x0030 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query Hard key state(struct SDKDEV_HARDKEY_STATE )
	 * \else
	 * 查询HardKey状态（对应结构体 SDKDEV_HARDKEY_STATE )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_HARDKEY                 =     0x0031 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query ISCSI path(struct SDKDEV_ISCSI_PATHLIST )
	 * \else
	 * 查询ISCSI路径列表(对应结构体 SDKDEV_ISCSI_PATHLIST )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_ISCSI_PATH              =     0x0032 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query local preview split capability(struct DEVICE_LOCALPREVIEW_SLIPT_CAP )
	 * \else
	 * 查询设备本地预览支持的分割模式(对应结构体DEVICE_LOCALPREVIEW_SLIPT_CAP)
	 * \endif
	 */
	public static final int SDK_DEVSTATE_DLPREVIEW_SLIPT_CAP     =     0x0033 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query wifi capablity(struct SDKDEV_WIFI_ROUTE_CAP )
	 * \else
	 * 查询无线路由能力信息(对应结构体 SDKDEV_WIFI_ROUTE_CAP )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_WIFI_ROUTE_CAP          =     0x0034 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query device online state(return a DWORD value, 1-online, 0-offline)
	 * \else
	 * 查询设备的在线状态(返回一个DWORD, 1表示在线, 0表示断线)
	 * \endif
	 */
	public static final int SDK_DEVSTATE_ONLINE                  =     0x0035 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query ptz state(struct SDK_PTZ_LOCATION_INFO )
	 * \else
	 * 查询云台状态信息(对应结构体 SDK_PTZ_LOCATION_INFO )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_PTZ_LOCATION            =     0x0036 ;   
	/**
	 * \if ENGLISH_LANG
	 * PQuery monitor state(state SDKDEV_MONITOR_INFO )
	 * \else
	 * 画面监控辅助信息(对应结构体 SDKDEV_MONITOR_INFO )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_MONITOR_INFO            =     0x0037 ;   
	/**
	 * \if ENGLISH_LANG
	 * PQuery subdevcie(fan,cpu...) state(struct CFG_DEVICESTATUS_INFO )
	 * \else
	 * 查询子设备(电源, 风扇等)状态(对应结构体 CFG_DEVICESTATUS_INFO )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_SUBDEVICE               =     0x0300 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query RAID state(struct ALARM_RAID_INFO ) 
	 * \else
	 * 查询RAID状态(对应结构体 ALARM_RAID_INFO )  
	 * \endif
	 */
	public static final int SDK_DEVSTATE_RAID_INFO               =     0x0038 ;   
	/**
	 * \if ENGLISH_LANG
	 * Test DDNS domain enable
	 * \else
	 * 测试DDNS域名是否可用
	 * \endif
	 */
	public static final int SDK_DEVSTATE_TEST_DDNSDOMAIN         =     0x0039 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query virtual camera state(struct SDKDEV_VIRTUALCAMERA_STATE_INFO )
	 * \else
	 * 查询虚拟摄像头状态(对应 SDKDEV_VIRTUALCAMERA_STATE_INFO )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_VIRTUALCAMERA           =     0x003a ;   
	/**
	 * \if ENGLISH_LANG
	 * Get device's state of video/coil module(struct SDKDEV_TRAFFICWORKSTATE_INFO )
	 * \else
	 * 获取设备工作视频/线圈模式状态等(对应 SDKDEV_TRAFFICWORKSTATE_INFO )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_TRAFFICWORKSTATE        =     0x003b ;   
	/**
	 * \if ENGLISH_LANG
	 * Get camera move alarm state(struct ALARM_CAMERA_MOVE_INFO )
	 * \else
	 * 获取摄像机移位报警事件状态(对应 ALARM_CAMERA_MOVE_INFO )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_ALARM_CAMERA_MOVE       =     0x003c ;   
	/**
	 * \if ENGLISH_LANG
	 * Get external alarm(struct NET_CLIENT_ALARM_STATE ) 
	 * \else
	 * 获取外部报警状态(对应 NET_CLIENT_ALARM_STATE )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_ALARM                   =     0x003e ;   
	/**
	 * \if ENGLISH_LANG
	 * Get video loss alarm(struct NET_CLIENT_VIDEOLOST_STATE ) 
	 * \else
	 * 获取视频丢失报警状态(对应  NET_CLIENT_VIDEOLOST_STATE )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_VIDEOLOST               =     0x003f ;   
	/**
	 * \if ENGLISH_LANG
	 * Get motion alarm(struct NET_CLIENT_MOTIONDETECT_STATE )
	 * \else
	 * 获取动态监测报警状态(对应  NET_CLIENT_MOTIONDETECT_STATE )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_MOTIONDETECT            =     0x0040 ;   
	/**
	 * \if ENGLISH_LANG
	 * Get detailed motion alarm(struct NET_CLIENT_DETAILEDMOTION_STATE )
	 * \else
	 * 获取详细的动态监测报警状态(对应  NET_CLIENT_DETAILEDMOTION_STATE )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_DETAILEDMOTION          =     0x0041 ;   
	/**
	 * \if ENGLISH_LANG
	 * Get vehicle device state(struct SDKDEV_VEHICLE_INFO )
	 * \else
	 * 获取车载自身各种硬件信息(对应  SDKDEV_VEHICLE_INFO )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_VEHICLE_INFO            =     0x0042 ;   
	/**
	 * \if ENGLISH_LANG
	 * Get blind alarm(struct NET_CLIENT_VIDEOBLIND_STATE )
	 * \else
	 * 获取视频遮挡报警状态(对应  NET_CLIENT_VIDEOBLIND_STATE )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_VIDEOBLIND              =     0x0043 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query 3G state(struct SDKDEV_VEHICLE_3GMODULE )
	 * \else
	 * 查询3G模块相关信息(对应结构体 SDKDEV_VEHICLE_3GMODULE )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_3GSTATE_INFO            =     0x0044 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query net interface(struct SDKDEV_NETINTERFACE_INFO )
	 * \else
	 * 查询网络接口信息(对应  SDKDEV_NETINTERFACE_INFO )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_NETINTERFACE            =     0x0045 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query picinpic channel(struct DWORD)
	 * \else
	 * 查询画中画通道号(对应DWORD数组)
	 * \endif
	 */
	public static final int SDK_DEVSTATE_PICINPIC_CHN            =     0x0046 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query splice screen(struct SDK_COMPOSITE_CHANNEL )
	 * \else
	 * 查询融合屏通道信息(对应 SDK_COMPOSITE_CHANNEL 数组)
	 * \endif
	 */
	public static final int SDK_DEVSTATE_COMPOSITE_CHN           =     0x0047 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query whole recording status(struct BOOL),as long as ther is a channel running,it indicates that the overall state
	 * \else
	 * 查询设备整体录像状态(对应BOOL), 只要有一个通道在录像，即为设备整体状态为录像
	 * \endif
	 */
	public static final int SDK_DEVSTATE_WHOLE_RECORDING         =     0x0048 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query whole encoding(struct BOOL),as long as ther is a channel running,it indicates that the overall state
	 * \else
	 * 查询设备整体编码状态(对应BOOL), 只要有一个通道在编码，即为设备整体状态为编码
	 * \endif
	 */
	public static final int SDK_DEVSTATE_WHOLE_ENCODING          =     0x0049 ;   
	/**
	 * \if ENGLISH_LANG
	 * Query disk record time(pBuf = DEV_DISK_RECORD_TIME *)
	 * \else
	 * 查询设备硬盘录像时间信息(pBuf = DEV_DISK_RECORD_TIME *，可以有多个结构体)
	 * \endif
	 */
	public static final int SDK_DEVSTATE_DISK_RECORDE_TIME       =     0x004a ;   
	/**
	 * \if ENGLISH_LANG
	 * Whether have pop-up optical dirve(struct NET_DEVSTATE_BURNERDOOR )
	 * \else
	 * 是否已弹出刻录机光驱门(对应结构体  NET_DEVSTATE_BURNERDOOR )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_BURNER_DOOR             =     0x004b ;   
	/**
	 * \if ENGLISH_LANG
	 * Get data validation process(struct NET_DEVSTATE_DATA_CHECK )
	 * \else
	 * 查询光盘数据校验进度(对应 NET_DEVSTATE_DATA_CHECK )
	 * \endif
	 */
	public static final int SDK_DEVSTATE_GET_DATA_CHECK          =     0x004c ;   
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 查询报警输入通道信息(对应NET_ALARM_IN_CHANNEL数组)
	 * \endif
	 */
	public static final int SDK_DEVSTATE_ALARM_IN_CHANNEL        =     0x004f ;   
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 查询报警通道数(对应NET_ALARM_CHANNEL_COUNT)
	 * \endif
	 */
	public static final int SDK_DEVSTATE_ALARM_CHN_COUNT         =     0x0050 ;   
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 查询云台可视域状态(对应SDK_OUT_PTZ_VIEW_RANGE_STATUS)
	 * \endif
	 */
	public static final int SDK_DEVSTATE_PTZ_VIEW_RANGE          =     0x0051 ;   
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 查询设备通道信息(对应NET_DEV_CHN_COUNT_INFO)
	 * \endif
	 */
	public static final int SDK_DEVSTATE_DEV_CHN_COUNT           =     0x0052 ;   
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 查询设备支持的RTSP URL列表，见结构体DEV_RTSPURL_LIST
	 * \endif
	 */
	public static final int SDK_DEVSTATE_RTSP_URL                =     0x0053 ;   
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 查询设备登录的在线超时时间,返回一个BTYE,（单位：分钟） ,0表示不限制,非零正整数表示限制的分钟数
	 * \endif
	 */
	public static final int SDK_DEVSTATE_LIMIT_LOGIN_TIME        =     0x0054 ;   
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 获取串口数 见结构体NET_GET_COMM_COUNT
	 * \endif
	 */
	public static final int SDK_DEVSTATE_GET_COMM_COUNT          =     0x0055 ;   
	
	public static final int SDK_DEVSTATE_RECORDING_DETAIL      = 0x0056;           // 查询录象状态详细信息(pBuf = NET_RECORD_STATE_DETAIL*)
	public static final int SDK_DEVSTATE_PTZ_PRESET_LIST       = 0x0057;           // 获取当前云台的预置点列表(对应结构NET_PTZ_PRESET_LIST)
	public static final int SDK_DEVSTATE_EXTERNAL_DEVICE       = 0x0058;           // 外接设备信息(pBuf = NET_EXTERNAL_DEVICE*)
	public static final int SDK_DEVSTATE_GET_UPGRADE_STATE     = 0x0059;           // 获取设备升级状态(对应结构DHDEV_UPGRADE_STATE_INFO)
	public static final int SDK_DEVSTATE_MULTIPLAYBACK_SPLIT_CAP = 0x005a;         // 获取多通道预览分割能力( 对应结构体 NET_MULTIPLAYBACK_SPLIT_CAP )
	public static final int SDK_DEVSTATE_BURN_SESSION_NUM      = 0x005b;           // 获取刻录会话总数(pBuf = int*)
	public static final int SDK_DEVSTATE_PROTECTIVE_CAPSULE    = 0x005c;           // 查询防护舱状态(对应结构体ALARM_PROTECTIVE_CAPSULE_INFO)


	public static final int SDK_DEVSTATE_POWER_STATE           = 0x0152;           // 查询电源状态(对应结构体NET_POWER_STATUS)
	public static final int SDK_DEVSTATE_ALL_ALARM_CHANNELS_STATE  = 0x153;        // 查询报警通道状态(对应结构体 NET_CLIENT_ALARM_CHANNELS_STATE)
	public static final int SDK_DEVSTATE_ALARMKEYBOARD_COUNT   = 0x0154;           // 查询串口上连接的报警键盘数(对应结构体NET_ALARMKEYBOARD_COUNT)
	public static final int SDK_DEVSTATE_EXALARMCHANNELS       = 0x0155;           // 查询扩展报警模块通道映射关系(对应结构体 NET_EXALARMCHANNELS)
	public static final int SDK_DEVSTATE_GET_BYPASS            = 0x0156;           // 查询通道旁路状态(对应结构体 NET_DEVSTATE_GET_BYPASS)
	public static final int SDK_DEVSTATE_ACTIVATEDDEFENCEAREA  = 0x0157;           // 获取激活的防区信息(对应结构体 NET_ACTIVATEDDEFENCEAREA)
	public static final int SDK_DEVSTATE_DEV_RECORDSET         = 0x0158;           // 查询设备记录集信息(对应NET_CTRL_RECORDSET_PARAM)
	public static final int SDK_DEVSTATE_DOOR_STATE            = 0x0159;           // 查询门禁状态(对应NET_DOOR_STATUS_INFO)
	public static final int SDK_DEVSTATE_ANALOGALARM_CHANNELS  = 0x1560;           // 模拟量报警输入通道映射关系(对应NET_ANALOGALARM_CHANNELS)
	public static final int SDK_DEVSTATE_GET_SENSORLIST        = 0x1561;           // 获取设备支持的传感器列表(对应 NET_SENSOR_LIST)
	public static final int SDK_DEVSTATE_ALARM_CHANNELS	= 0x1562;		// 查询开关量报警模块通道映射关系(对应结构体 NET_ALARM_CHANNELS)
													// 如果设备不支持查询扩展报警模块通道,可以用该功能查询扩展通道的逻辑通道号，并当做本地报警通道使用
	public static final int SDK_DEVSTATE_GET_ALARM_SUBSYSTEM_ACTIVATESTATUS	= 0x1563;	// 获取当前子系统启用状态( 对应 NET_GET_ALARM_SUBSYSTEM_ACTIVATE_STATUES)
	public static final int SDK_DEVSTATE_ALARMSUBSYSTEM_STATE  = 0x1565;            // 获取子系统状态(对应NET_ALARM_SUBSYSTEM_STATE)
	public static final int SDK_DEVSTATE_ALARM_FAULT_STATE     = 0x1566;            // 获取故障状态(对应NET_ALARM_FAULT_STATE)
	public static final int SDK_DEVSTATE_ARM_MODE_GET          = 0x1567;           // 获取当前布防撤防模式(对应NET_ARM_MODE_INFO)
	public static final int SDK_DEVSTATE_DEFENCE_STATE         = 0x1568;           // 获取防区状态(对应NET_DEFENCE_STATE_INFO, 和旁路状态变化事件、本地报警事件、报警信号源事件的状态描述有区别，不能混用，仅个别设备使用)
	public static final int SDK_DEVSTATE_SCADA_POINT_LIST      = 0x1569;           // 获取点位表路径信息(对应 NET_SCADA_POINT_LIST_INFO)
	public static final int SDK_DEVSTATE_SCADA_INFO            = 0x156a;           // 获取监测点位信息(对应 NET_SCADA_INFO)
	public static final int SDK_DEVSTATE_SCADA_CAPS            = 0x156b;           // 获取SCADA能力集(对应 NET_SCADA_CAPS)
	public static final int SDK_DEVSTATE_GET_CODEID_COUNT      = 0x156c;           // 获取对码成功的总条数(对应 NET_GET_CODEID_COUNT)
	public static final int SDK_DEVSTATE_GET_CODEID_LIST       = 0x156d;           // 查询对码信息(对应 NET_GET_CODEID_LIST)
	public static final int SDK_DEVSTATE_ANALOGALARM_DATA      = 0x156e;           // 查询模拟量通道数据(对应 NET_GET_ANALOGALARM_DATA)
	public static final int SDK_DEVSTATE_VTP_CALLSTATE         = 0x156f;           // 获取视频电话呼叫状态(对应 NET_GET_VTP_CALLSTATE)

	/**
	 * \if ENGLISH_LANG
	 * Mail address max length
	 * \else
	 * 邮件发(收)地址最大长度
	 * \endif
	 */
	
	public static final int SDK_MAX_MAIL_ADDR_LEN                =        128 ;   
	/**
	 * \if ENGLISH_LANG
	 * Mail subject max length
	 * \else
	 * 邮件主题最大长度
	 * \endif
	 */
	public static final int SDK_MAX_MAIL_SUBJECT_LEN             =         64 ;   
	
	public static final int SDK_IPIFILTER_NUM                    =         200;
	public static final int SDK_IPIFILTER_NUM_EX                 =         512;
	
	/**
	 * \if ENGLISH_LANG
	 * IP address string length 
	 * \else
	 * IP地址字符串长度
	 * \endif
	 */
	public static final int SDK_MAX_IPADDR_LEN                   =         16 ;   
	
	/**
	 * \if ENGLISH_LANG
	 * MACE address string length
	 * \else
	 * MAC地址字符串长度
	 * \endif
	 */

	public static final int SDK_MAX_IPADDR_LEN_EX                =         40 ; // 扩展IP地址字符串长度, 支持IPV6
		
	public static final int SDK_MACADDR_LEN                      =         40 ;  
	/**
	 * \if ENGLISH_LANG
	 * URL string length
	 * \else
	 * URL字符串长度
	 * \endif
	 */
	public static final int SDK_MAX_URL_LEN                      =        128 ;      
	/**
	 * \if ENGLISH_LANG
	 * Device serial number max length 
	 * \else
	 * 机器编号最大长度
	 * \endif
	 */
	public static final int SDK_MAX_DEV_ID_LEN                   =         48 ;   
	/**
	 * \if ENGLISH_LANG
	 * Host name length
	 * \else
	 * 主机名长度
	 * \endif
	 */
	public static final int SDK_MAX_HOST_NAMELEN                 =         64 ;       
	/**
	 * \if ENGLISH_LANG
	 * Password length 
	 * \else
	 * 密码长度
	 * \endif
	 */
	public static final int SDK_MAX_HOST_PSWLEN                  =         32 ;           
	/**
	 * \if ENGLISH_LANG
	 * Universal name string length 
	 * \else
	 * 通用名字字符串长度
	 * \endif
	 */
	public static final int SDK_MAX_NAME_LEN                     =         16 ;   
	/**
	 * \if ENGLISH_LANG
	 * Ethernet max amount 
	 * \else
	 * 以太网口最大个数
	 * \endif
	 */
	public static final int SDK_MAX_ETHERNET_NUM                 =          2 ;   
	/**
	 * \if ENGLISH_LANG
	 * Extended ethernet max amout
	 * \else
	 * 扩展以太网口最大个数
	 * \endif
	 */
	public static final int SDK_MAX_ETHERNET_NUM_EX              =         10 ;   
	/**
	 * \if ENGLISH_LANG
	 * Serial number string length
	 * \else
	 * 序列号字符串长度
	 * \endif
	 */
	public static final int SDK_DEV_SERIALNO_LEN                 =         48 ;   
	/**
	 * \if ENGLISH_LANG
	 * Device type string length 
	 * \else
	 * 设备类型字符串长度
	 * \endif
	 */
	public static final int SDK_DEV_TYPE_LEN                     =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * The days in one week 
	 * \else
	 * 一周的天数
	 * \endif
	 */
	public static final int SDK_N_WEEKS                          =          7 ;          
	/**
	 * \if ENGLISH_LANG
	 * Time period amount
	 * \else
	 * 通用时间段个数
	 * \endif
	 */
	public static final int SDK_N_TSECT                          =          6 ;     
	/**
	 * \if ENGLISH_LANG
	 * Record period amount 
	 * \else
	 * 录像时间段个数
	 * \endif
	 */
	public static final int SDK_N_REC_TSECT                      =          6 ;     
	/**
	 * \if ENGLISH_LANG
	 * Color period amount 
	 * \else
	 * 颜色时间段个数
	 * \endif
	 */
	public static final int SDK_N_COL_TSECT                      =          2 ;      
	/**
	 * \if ENGLISH_LANG
	 * Channel name lengh. DVR DSP capacity limit. Max 32 bytes.
	 * \else
	 * 通道名长度，DVR DSP能力限制，最多32字节
	 * \endif
	 */
	public static final int SDK_CHAN_NAME_LEN                    =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Extra stream amount 
	 * \else
	 * 扩展码流个数
	 * \endif
	 */
	public static final int SDK_N_ENCODE_AUX                     =          3 ;        
	/**
	 * \if ENGLISH_LANG
	 * Max audio talk channel amount 
	 * \else
	 * 最多对讲通道个数
	 * \endif
	 */
	public static final int SDK_N_TALK                           =          1 ;   
	/**
	 * \if ENGLISH_LANG
	 * Privacy mask zone amount 
	 * \else
	 * 遮挡区域个数
	 * \endif
	 */
	public static final int SDK_N_COVERS                         =          1 ;        
	/**
	 * \if ENGLISH_LANG
	 * Max channel amount 
	 * \else
	 * 最大通道个数
	 * \endif
	 */
	public static final int SDK_N_CHANNEL                        =         16 ;        
	/**
	 * \if ENGLISH_LANG
	 * Alarm prompt period amount 
	 * \else
	 * 报警提示时间段个数
	 * \endif
	 */
	public static final int SDK_N_ALARM_TSECT                    =          2 ;   
	/**
	 * \if ENGLISH_LANG
	 * Alarm output ports max amount 
	 * \else
	 * 报警输出口个数上限
	 * \endif
	 */
	public static final int SDK_MAX_ALARMOUT_NUM                 =         16 ;   
	/**
	 * \if ENGLISH_LANG
	 * Audio input ports max amount 
	 * \else
	 * 音频输入口个数上限
	 * \endif
	 */
	public static final int SDK_MAX_AUDIO_IN_NUM                 =         16 ;   
	/**
	 * \if ENGLISH_LANG
	 * Video input ports max amount 
	 * \else
	 * 视频输入口个数上限
	 * \endif
	 */
	public static final int SDK_MAX_VIDEO_IN_NUM                 =         16 ;   
	/**
	 * \if ENGLISH_LANG
	 * Alarm input ports max amount 
	 * \else
	 * 报警输入口个数上限
	 * \endif
	 */
	public static final int SDK_MAX_ALARM_IN_NUM                 =         16 ;   
	/**
	 * \if ENGLISH_LANG
	 * HDD max amount. Now the value is 16.
	 * \else
	 * 硬盘个数上限，暂定为16
	 * \endif
	 */
	public static final int SDK_MAX_DISK_NUM                     =         16 ;   
	/**
	 * \if ENGLISH_LANG
	 * Decoder(485) max amount 
	 * \else
	 * 解码器(485)个数上限
	 * \endif
	 */
	public static final int SDK_MAX_DECODER_NUM                  =         16 ;   
	/**
	 * \if ENGLISH_LANG
	 * 232 COM function max amount 
	 * \else
	 * 232串口功能个数上限
	 * \endif
	 */
	public static final int SDK_MAX_232FUNCS                     =         10 ;   
	/**
	 * \if ENGLISH_LANG
	 * 232 COM port max amount 
	 * \else
	 * 232串口个数上限
	 * \endif
	 */
	public static final int SDK_MAX_232_NUM                      =          2 ;    
	/**
	 * \if ENGLISH_LANG
	 * Extended 232 COM port max amount 
	 * \else
	 * 扩展串口配置个数上限  
	 * \endif
	 */
	public static final int SDK_MAX_232_NUM_EX                   =         16 ;           
	/**
	 * \if ENGLISH_LANG
	 * Decoder protocol list max amount
	 * \else
	 * 解码器协议列表个数上限
	 * \endif
	 */
	public static final int SDK_MAX_DECPRO_LIST_SIZE             =        100 ;   
	/**
	 * \if ENGLISH_LANG
	 * FTP file folder max length 
	 * \else
	 * FTP文件目录最大长度
	 * \endif
	 */
	public static final int SDK_FTP_MAXDIRLEN                    =        240 ;   
	/**
	 * \if ENGLISH_LANG
	 * Matrix output ports max amount
	 * \else
	 * 矩阵输出口最大个数
	 * \endif
	 */
	public static final int SDK_MATRIX_MAXOUT                    =         16 ;   
	/**
	 * \if ENGLISH_LANG
	 * Matrix output ports max amount 
	 * \else
	 * 矩阵输出组最大个数
	 * \endif
	 */
	public static final int SDK_TOUR_GROUP_NUM                   =          6 ;   
	/**
	 * \if ENGLISH_LANG
	 * Ddns max amount the device supported 
	 * \else
	 * 设备支持的ddns服务器最大个数
	 * \endif
	 */
	public static final int SDK_MAX_DDNS_NUM                     =         10 ;   
	/**
	 * \if ENGLISH_LANG
	 * Ddns type and max string length 
	 * \else
	 * ddns服务器类型，最大字符串长度
	 * \endif
	 */
	public static final int SDK_MAX_SERVER_TYPE_LEN              =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Ddns domain name and max string length 
	 * \else
	 * ddns域名，最大字符串长度
	 * \endif
	 */
	public static final int SDK_MAX_DOMAIN_NAME_LEN              =        256 ;   
	/**
	 * \if ENGLISH_LANG
	 * Ddns alias and max string length
	 * \else
	 * ddns服务器别名，最大字符串长度
	 * \endif
	 */
	public static final int SDK_MAX_DDNS_ALIAS_LEN               =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Ddns default domain, max sring length
	 * \else
	 * dns默认域名，最大字符串长度 
	 * \endif
	 */
	public static final int SDK_MAX_DEFAULT_DOMAIN_LEN           =         60 ;   
	/**
	 * \if ENGLISH_LANG
	 * Motion detection zone row amount
	 * \else
	 * 动态检测区域的行数
	 * \endif
	 */
	public static final int SDK_MOTION_ROW                       =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Motion detection zone column amount 
	 * \else
	 * 动态检测区域的列数
	 * \endif
	 */
	public static final int SDK_MOTION_COL                       =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Static detection zone row amount 
	 * \else
	 * 静态检测区域的行数
	 * \endif
	 */
	public static final int SDK_STATIC_ROW                       =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Static detection zone column amount
	 * \else
	 * 静态检测区域的列数
	 * \endif
	 */
	public static final int SDK_STATIC_COL                       =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * FTP setup:user name max lengh 
	 * \else
	 * FTP配置，用户名最大长度
	 * \endif
	 */
	public static final int SDK_FTP_USERNAME_LEN                 =         64 ;   
	/**
	 * \if ENGLISH_LANG
	 * FTP setup:password max length 
	 * \else
	 * FTP配置，密码最大长度
	 * \endif
	 */
	public static final int SDK_FTP_PASSWORD_LEN                 =         64 ;   
	/**
	 * \if ENGLISH_LANG
	 * FTP setup:time periods in each day.
	 * \else
	 * FTP配置，每天时间段个数
	 * \endif
	 */
	public static final int SDK_TIME_SECTION                     =          2 ;   
	/**
	 * \if ENGLISH_LANG
	 * FTP setup:file path max length
	 * \else
	 * FTP配置，文件路径名最大长度
	 * \endif
	 */
	public static final int SDK_FTP_MAX_PATH                     =        240 ;   
	/**
	 * \if ENGLISH_LANG
	 * FTP setup:sub path max lenth
	 * \else
	 * FTP配置，文件路径名最大长度
	 * \endif
	 */
	public static final int SDK_FTP_MAX_SUB_PATH                 =        128 ;   
	/**
	 * \if ENGLISH_LANG
	 * Platform embedded setup:U China Net Communication (CNC)channel ID
	 * \else
	 * 平台接入配置，U网通通道ID
	 * \endif
	 */
	public static final int SDK_INTERVIDEO_UCOM_CHANID           =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Platform embedded setup:UCNC device ID
	 * \else
	 * 平台接入配置，U网通设备ID
	 * \endif
	 */
	public static final int SDK_INTERVIDEO_UCOM_DEVID            =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Platform embedded setup:UCNC registration password
	 * \else
	 * 平台接入配置，U网通注册密码
	 * \endif
	 */
	public static final int SDK_INTERVIDEO_UCOM_REGPSW           =         16 ;   
	/**
	 * \if ENGLISH_LANG
	 * Platform embedded setup:UCNC user name 
	 * \else
	 * 平台接入配置，U网通用户名
	 * \endif
	 */
	public static final int SDK_INTERVIDEO_UCOM_USERNAME         =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Platform embedded setup: UCNC password 
	 * \else
	 * 平台接入配置，U网通密码
	 * \endif
	 */
	public static final int SDK_INTERVIDEO_UCOM_USERPSW          =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Platform embedded setup:ZTE Netview IP
	 * \else
	 * 平台接入配置，中兴力维IP
	 * \endif
	 */
	public static final int SDK_INTERVIDEO_NSS_IP                =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Serial Platform embedded setup:ZTE Netview  serial
	 * \else
	 * 平台接入配置，中兴力维serial
	 * \endif
	 */
	public static final int SDK_INTERVIDEO_NSS_SERIAL            =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * User Platform embedded setup:ZTE Netview user
	 * \else
	 * 平台接入配置，中兴力维user
	 * \endif
	 */
	public static final int SDK_INTERVIDEO_NSS_USER              =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Password Platform embedded setup:ZTE Netview password
	 * \else
	 * 平台接入配置，中兴力维password
	 * \endif
	 */
	public static final int SDK_INTERVIDEO_NSS_PWD               =         50 ;   
	/**
	 * \if ENGLISH_LANG
	 * Privacy mask zones max amount
	 * \else
	 * 遮挡区域最大个数
	 * \endif
	 */
	public static final int SDK_MAX_VIDEO_COVER_NUM              =         16 ;   
	/**
	 * \if ENGLISH_LANG
	 * Watermark data max length 
	 * \else
	 * 水印图片数据最大长度
	 * \endif
	 */
	public static final int SDK_MAX_WATERMAKE_DATA               =       4096 ;   
	/**
	 * \if ENGLISH_LANG
	 * Watermark text max length
	 * \else
	 * 水印文字最大长度
	 * \endif
	 */
	public static final int SDK_MAX_WATERMAKE_LETTER             =        128 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max searched wireless device amount 
	 * \else
	 * 最多搜索出的无线设备个数
	 * \endif
	 */
	public static final int SDK_MAX_WLANDEVICE_NUM               =         10 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max searched wireless device amount
	 * \else
	 * 最多搜索出的无线设备个数
	 * \endif
	 */
	public static final int SDK_MAX_WLANDEVICE_NUM_EX            =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Address length
	 * \else
	 * 地址长度
	 * \endif
	 */
	public static final int SDK_MAX_ALARM_NAME                   =         64 ;           
	/**
	 * \if ENGLISH_LANG
	 * Auto registration server amount
	 * \else
	 * 主动注册服务器个数
	 * \endif
	 */
	public static final int SDK_MAX_REGISTER_SERVER_NUM          =         10 ;   
	/**
	 * \if ENGLISH_LANG
	 * 6 FRAME ID options
	 * \else
	 * 6个FRAME ID 选项
	 * \endif
	 */
	public static final int SDK_SNIFFER_FRAMEID_NUM              =          6 ;   
	/**
	 * \if ENGLISH_LANG
	 * 4 sniffer in each FRAME
	 * \else
	 * 每个FRAME对应的4个抓包内容
	 * \endif
	 */
	public static final int SDK_SNIFFER_CONTENT_NUM              =          4 ;   
	/**
	 * \if ENGLISH_LANG
	 * 8 sniffer in each FRAME
	 * \else
	 * 每个FRAME对应的8个抓包内容
	 * \endif
	 */
	public static final int SDK_SNIFFER_CONTENT_NUM_EX           =          8 ;   
	/**
	 * \if ENGLISH_LANG
	 * Protocol length
	 * \else
	 * 协议名字长度
	 * \endif
	 */
	public static final int SDK_SNIFFER_PROTOCOL_SIZE            =         20 ;       
	/**
	 * \if ENGLISH_LANG
	 * 4 group sniffer setup 
	 * \else
	 * 端口序号
	 * \endif
	 */
	public static final int SDK_MAX_PROTOCOL_NAME_LENGTH         =         20 ;           
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 4组抓包设置
	 * \endif
	 */
	public static final int SDK_SNIFFER_GROUP_NUM                =          4 ;        
	/**
	 * \if ENGLISH_LANG
	 * Remote folder length
	 * \else
	 * 远程目录的长度
	 * \endif
	 */
	public static final int MAX_PATH_STOR                       =        240 ;     
	/**
	 * \if ENGLISH_LANG
	 * New alarm upload time length
	 * \else
	 * 新的报警上传时间的长度
	 * \endif
	 */
	public static final int SDK_ALARM_OCCUR_TIME_LEN             =         40 ;   
	/**
	 * \if ENGLISH_LANG
	 * Overlay name length. Now it supports 32-digit English and 16-digit Chinese
	 * \else
	 * 叠加的名称长度，目前支持32个英文，16个中文
	 * \endif
	 */
	public static final int SDK_VIDEO_OSD_NAME_NUM               =         64 ;   
	/**
	 * \if ENGLISH_LANG
	 * The self-defined amount supported excluding time and channel
	 * \else
	 * 支持的自定义叠加的数目，不包含时间和通道
	 * \endif
	 */
	public static final int SDK_VIDEO_CUSTOM_OSD_NUM             =          8 ;   
	/**
	 * \if ENGLISH_LANG
	 * Targeted initiatives to support the number of registration servers
	 * \else
	 * 支持定向主动注册服务器的个数
	 * \endif
	 */
	public static final int SDK_CONTROL_AUTO_REGISTER_NUM        =        100 ;   
	/**
	 * \if ENGLISH_LANG
	 * Support the number of messages the recipient
	 * \else
	 * 支持短信接收者的个数
	 * \endif
	 */
	public static final int SDK_MMS_RECEIVER_NUM                 =        100 ;   
	/**
	 * \if ENGLISH_LANG
	 * Support the number of SMS sender
	 * \else
	 * 支持短信发送者的个数
	 * \endif
	 */
	public static final int SDK_MMS_SMSACTIVATION_NUM            =        100 ;   
	/**
	 * \if ENGLISH_LANG
	 * Support for dial-up number of the sender
	 * \else
	 * 支持拨号发送者的个数
	 * \endif
	 */
	public static final int SDK_MMS_DIALINACTIVATION_NUM         =        100 ;   
	/**
	 * \if ENGLISH_LANG
	 * Alarm output amount max limit
	 * \else
	 * 报警输出口个数上限扩展
	 * \endif
	 */
	public static final int SDK_MAX_ALARMOUT_NUM_EX              =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Video input amount max limit
	 * \else
	 * 视频输入口个数上限扩展
	 * \endif
	 */
	public static final int SDK_MAX_VIDEO_IN_NUM_EX              =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Alarm input amount max limit
	 * \else
	 * 报警输入口个数上限
	 * \endif
	 */
	public static final int SDK_MAX_ALARM_IN_NUM_EX              =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * IP or domain name length
	 * \else
	 * IP地址字符串长度
	 * \endif
	 */
	public static final int SDK_MAX_IPADDR_OR_DOMAIN_LEN         =         64 ;   
	/**
	 * \if ENGLISH_LANG
	 * The upper limit number of object id that detected by device in intelligent analysis
	 * \else
	 * 智能分析设备检测到的物体ID个数上限
	 * \endif
	 */
	public static final int SDK_MAX_OBJECT_LIST                  =         16 ;   
	/**
	 * \if ENGLISH_LANG
	 * The upper limit number of device rule in intelligent analysis 
	 * \else
	 * 智能分析设备规则个数上限
	 * \endif
	 */
	public static final int SDK_MAX_RULE_LIST                    =         16 ;   
	/**
	 * \if ENGLISH_LANG
	 * The max number of polygon's culmination
	 * \else
	 * 多边形最大顶点个数
	 * \endif
	 */
	public static final int SDK_MAX_POLYGON_NUM                  =         16 ;   
	/**
	 * \if ENGLISH_LANG
	 * Rule detect line's max point number
	 * \else
	 * 规则检测线最大顶点数
	 * \endif
	 */
	public static final int SDK_MAX_DETECT_LINE_NUM              =         20 ;   
	/**
	 * \if ENGLISH_LANG
	 * Rule detect region's max point number
	 * \else
	 * 规则检测区域最大顶点数
	 * \endif
	 */
	public static final int SDK_MAX_DETECT_REGION_NUM            =         20 ;   
	/**
	 * \if ENGLISH_LANG
	 * Object moving track's max point number
	 * \else
	 * 物体运动轨迹最大顶点数
	 * \endif
	 */
	public static final int SDK_MAX_TRACK_LINE_NUM               =         20 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max candidate number
	 * \else
	 * 人脸识别最大匹配数
	 * \endif
	 */
	public static final int SDK_MAX_CANDIDATE_NUM                =         50 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max image of ervery person
	 * \else
	 * 每个人员对应的最大人脸图片数
	 * \endif
	 */
	public static final int SDK_MAX_PERSON_IMAGE_NUM             =         48 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max fance line number
	 * \else
	 * 围栏最大曲线数
	 * \endif
	 */
	public static final int SDK_MAX_FENCE_LINE_NUM               =          2 ;     
	/**
	 * \if ENGLISH_LANG
	 * The max number of smart disk information
	 * \else
	 * 最多的smart信息个数
	 * \endif
	 */
	public static final int MAX_SMART_VALUE_NUM                 =         30 ;   
	/**
	 * \if ENGLISH_LANG
	 * Device name length
	 * \else
	 * 机器名称长度
	 * \endif
	 */
	public static final int SDK_MACHINE_NAME_NUM                 =         64 ;       
	/**
	 * \if ENGLISH_LANG
	 * Platform embedded setup, AMP,Device serial num length
	 * \else
	 * 平台接入配置，天地阳光 设备序列号字符串长度
	 * \endif
	 */
	public static final int SDK_INTERVIDEO_AMP_DEVICESERIAL      =         48 ;   
	/**
	 * \if ENGLISH_LANG
	 * Platform embedded setup, AMP,Device Name length
	 * \else
	 * 平台接入配置，天地阳光 设备名称字符串长度
	 * \endif
	 */
	public static final int SDK_INTERVIDEO_AMP_DEVICENAME        =         16 ;   
	/**
	 * \if ENGLISH_LANG
	 * Platform embedded setup, AMP,User Name Length
	 * \else
	 * 平台接入配置，天地阳光 注册用户名字符串长度
	 * \endif
	 */
	public static final int SDK_INTERVIDEO_AMP_USER              =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Platform embedded setup, AMP,password length
	 * \else
	 * 平台接入配置，天地阳光 注册密码字符串长度
	 * \endif
	 */
	public static final int SDK_INTERVIDEO_AMP_PWD               =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max number of submodule infomation
	 * \else
	 * 最多子模块信息个数
	 * \endif
	 */
	public static final int MAX_SUBMODULE_NUM                   =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Traffic snapshot,the max car way number
	 * \else
	 * 交通抓拍，最大车道数
	 * \endif
	 */
	public static final int SDK_MAX_CARWAY_NUM                   =          8 ;   
	/**
	 * \if ENGLISH_LANG
	 * One car way max time for snapshot
	 * \else
	 * 一个车道的最大抓拍张数
	 * \endif
	 */
	public static final int SDK_MAX_SNAP_SIGNAL_NUM              =          3 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max number of card
	 * \else
	 * 卡号的最大个数
	 * \endif
	 */
	public static final int SDK_MAX_CARD_NUM                     =        128 ;     
	/**
	 * \if ENGLISH_LANG
	 * Max lenth of card infomation
	 * \else
	 * 每条卡号最长字符数
	 * \endif
	 */
	public static final int SDK_MAX_CARDINFO_LEN                 =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max supported controller number
	 * \else
	 * 最大支持控制器数目
	 * \endif
	 */
	public static final int SDK_MAX_CONTROLER_NUM                =         64 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max control light group number
	 * \else
	 * 最多控制灯组数
	 * \endif
	 */
	public static final int SDK_MAX_LIGHT_NUM                    =         32 ;     
	/**
	 * \if ENGLISH_LANG
	 * Max Snmp read or write buffer
	 * \else
	 * snmp 读写数据长度
	 * \endif
	 */
	public static final int SDK_MAX_SNMP_COMMON_LEN              =         64 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max DDNS state buffer
	 * \else
	 * DDNS 状态信息长度
	 * \endif
	 */
	public static final int SDK_MAX_DDNS_STATE_LEN               =        128 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max phone len
	 * \else
	 * 电话号码长度
	 * \endif
	 */
	public static final int SDK_MAX_PHONE_NO_LEN                 =         16 ;       
	/**
	 * \if ENGLISH_LANG
	 * Max type len
	 * \else
	 * 导航类型或短信息类型长度
	 * \endif
	 */
	public static final int SDK_MAX_MSGTYPE_LEN                  =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max message len
	 * \else
	 * 导航和短信息长度
	 * \endif
	 */
	public static final int SDK_MAX_MSG_LEN                      =        256 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max drivingdirection len
	 * \else
	 * 行驶方向字符串长度
	 * \endif
	 */
	public static final int SDK_MAX_DRIVINGDIRECTION             =        256 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max snapshot count
	 * \else
	 * 多张图片抓拍个数
	 * \endif
	 */
	public static final int SDK_MAX_GRAB_INTERVAL_NUM            =          4 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max flash count
	 * \else
	 * 最多支持闪光灯个数
	 * \endif
	 */
	public static final int SDK_MAX_FLASH_NUM                    =          5 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max number of road in every channel
	 * \else
	 * 视频分析设备每个通道对应车道数上限
	 * \endif
	 */
	public static final int SDK_MAX_LANE_NUM                     =          8 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max ISCSI remote path number
	 * \else
	 * ISCSI远程目录最大数量
	 * \endif
	 */
	public static final int SDK_MAX_ISCSI_PATH_NUM               =         64 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max wireless channel number
	 * \else
	 * 无线路由最大信道数
	 * \endif
	 */
	public static final int SDK_MAX_WIRELESS_CHN_NUM             =        256 ;   
	/**
	 * \if ENGLISH_LANG
	 * Protocol 3 base value
	 * \else
	 * 三代协议版本基数
	 * \endif
	 */
	public static final int SDK_PROTOCOL3_BASE                   =        100 ;   
	/**
	 * \if ENGLISH_LANG
	 * Prococol 3 support
	 * \else
	 * 只支持3代协议
	 * \endif
	 */
	public static final int SDK_PROTOCOL3_SUPPORT                =         11 ;      
	/**
	 * \if ENGLISH_LANG
	 * Max channel mask
	 * \else
	 * 通道掩码最大值
	 * \endif
	 */
	public static final int SDK_MAX_CHANMASK                     =         64 ;     
	/**
	 * \if ENGLISH_LANG
	 * Max of compressed video configuration staff number
	 * \else
	 * 浓缩视频配置信息中标尺数上限
	 * \endif
	 */
	public static final int SDK_MAX_STAFF_NUM                    =         20 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max of compressed video configuration calibrate region
	 * \else
	 * 浓缩视频配置信息中标定区域数上限
	 * \endif
	 */
	public static final int SDK_MAX_CALIBRATEBOX_NUM             =         10 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max of compressed video configuration exclude region
	 * \else
	 * 浓缩视频配置信息中排除区域数上限
	 * \endif
	 */
	public static final int SDK_MAX_EXCLUDEREGION_NUM            =         10 ;   
	/**
	 * \if ENGLISH_LANG
	 * Number of compressed video configuration poly line
	 * \else
	 * 浓缩视频配置信息中标尺线数
	 * \endif
	 */
	public static final int SDK_MAX_POLYLINE_NUM                 =         20 ;   
	/**
	 * \if ENGLISH_LANG
	 * Color maximum number
	 * \else
	 * 最大颜色数目
	 * \endif
	 */
	public static final int SDK_MAX_COLOR_NUM                    =         16 ;       
	/**
	 * \if ENGLISH_LANG
	 * Max number of  filter type 
	 * \else
	 * 最大过滤种类个数
	 * \endif
	 */
	public static final int MAX_OBJFILTER_NUM                   =         16 ;   
	/**
	 * \if ENGLISH_LANG
	 * String state length of compressed video 
	 * \else
	 * 视频浓缩状态字符串长度
	 * \endif
	 */
	public static final int SDK_MAX_SYNOPSIS_STATE_NAME          =         64 ;   
	/**
	 * \if ENGLISH_LANG
	 * The file number limit
	 * \else
	 * 视频浓缩相关原始文件按照路径查找时文件个数上限
	 * \endif
	 */
	public static final int SDK_MAX_SYNOPSIS_QUERY_FILE_COUNT    =         10 ;   
	/**
	 * \if ENGLISH_LANG
	 * Length of SSID
	 * \else
	 * SSID长度
	 * \endif
	 */
	public static final int SDK_MAX_SSID_LEN                     =         36 ;           
	/**
	 * \if ENGLISH_LANG
	 * Length of PIN
	 * \else
	 * PIN码长度
	 * \endif
	 */
	public static final int SDK_MAX_APPIN_LEN                    =         16 ;          
	/**
	 * \if ENGLISH_LANG
	 * Length of net port
	 * \else
	 * 网口名称长度
	 * \endif
	 */
	public static final int SDK_NETINTERFACE_NAME_LEN            =        260 ;       
	/**
	 * \if ENGLISH_LANG
	 * Length of net type
	 * \else
	 * 网络类型长度
	 * \endif
	 */
	public static final int SDK_NETINTERFACE_TYPE_LEN            =        260 ;       
	/**
	 * \if ENGLISH_LANG
	 * Length of connect status
	 * \else
	 * 连接状态字符串长度
	 * \endif
	 */
	public static final int SDK_MAX_CONNECT_STATUS_LEN           =        260 ;   
	/**
	 * \if ENGLISH_LANG
	 * Length of 3G mode support
	 * \else
	 * 3G支持的网络模式长度
	 * \endif
	 */
	public static final int SDK_MAX_MODE_LEN                     =         64 ;   
	/**
	 * \if ENGLISH_LANG
	 * Number of 3G mode support
	 * \else
	 * 3G支持的网络模式个数
	 * \endif
	 */
	public static final int SDK_MAX_MODE_NUM                     =         64 ;   
	
	public static final int SDK_MAX_COMPRESSION_TYPES_NUM        =         16 ;
	
	/**
	 * \if ENGLISH_LANG
	 * Number of video resolution 
	 * \else
	 * 视频分辨率个数
	 * \endif
	 */
	public static final int SDK_MAX_CAPTURE_SIZE_NUM             =         64 ;     
	/**
	 * \if ENGLISH_LANG
	 * Length of node name
	 * \else
	 * 组织结构节点名称长度
	 * \endif
	 */
	public static final int SDK_NODE_NAME_LEN                    =         64 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max number of point support
	 * \else
	 * 支持最大标定点数
	 * \endif
	 */
	public static final int MAX_CALIBPOINTS_NUM                 =        256 ;   
	/**
	 * \if ENGLISH_LANG
	 * The maximum number display element attributes
	 * \else
	 * 显示单元属性最大数量
	 * \endif
	 */
	public static final int SDK_MAX_ATTR_NUM                     =         32 ;   
	/**
	 * \if ENGLISH_LANG
	 * Length of cloud connect state
	 * \else
	 * 云注册连接状态信息长度
	 * \endif
	 */
	public static final int SDK_MAX_CLOUDCONNECT_STATE_LEN       =        128 ;   
	/**
	 * \if ENGLISH_LANG
	 * IP entended maximum length
	 * \else
	 * 扩展IP地址最大长度
	 * \endif
	 */
	public static final int SDK_MAX_IPADDR_EX_LEN                =        128 ;   
	/**
	 * \if ENGLISH_LANG
	 * Plate character length
	 * \else
	 * 车牌字符串长度  
	 * \endif
	 */
	public static final int SDK_MAX_PLATE_NUMBER_LEN             =         32 ;    
	/**
	 * \if ENGLISH_LANG
	 * Right list max number
	 * \else
	 * 权限列表最大个数   
	 * \endif
	 */
	public static final int SDK_MAX_AUTHORITY_LIST_NUM           =         16 ;   
	/**
	 * \if ENGLISH_LANG
	 * City name max length
	 * \else
	 * 城市名称最大长度
	 * \endif
	 */
	public static final int SDK_MAX_CITY_NAME_LEN                =         64 ;   
	/**
	 * \if ENGLISH_LANG
	 * Province name max length
	 * \else
	 * 省份名称最大长度
	 * \endif
	 */
	public static final int SDK_MAX_PROVINCE_NAME_LEN            =         64 ;  
	/**
	 * \if ENGLISH_LANG
	 * Staff ID max length
	 * \else
	 * 人员id最大长度
	 * \endif
	 */
	public static final int SDK_MAX_PERSON_ID_LEN                =         32 ;     
	/**
	 * \if ENGLISH_LANG
	 * Max face area number
	 * \else
	 * 最大人脸区域个数 
	 * \endif
	 */
	public static final int MAX_FACE_AREA_NUM                   =          8 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max face database number
	 * \else
	 * 最大人脸数据库个数
	 * \endif
	 */
	public static final int MAX_FACE_DB_NUM                     =          8 ;   
	/**
	 * \if ENGLISH_LANG
	 * Max event name
	 * \else
	 * 最长事件名
	 * \endif
	 */
	public static final int MAX_EVENT_NAME                      =        128 ;         
	/**
	 * \if ENGLISH_LANG
	 * Max net card name
	 * \else
	 * 最大网卡名
	 * \endif
	 */
	public static final int SDK_MAX_ETH_NAME                     =         64 ;         
	/**
	 * \if ENGLISH_LANG
	 * Staff name max length
	 * \else
	 * 人员名字最大长度
	 * \endif
	 */
	public static final int SDK_MAX_PERSON_NAME_LEN              =         64 ;   
	/**
	 * \if ENGLISH_LANG
	 * Time table element number 
	 * \else
	 * 时间表元素个数
	 * \endif
	 */
	public static final int SDK_N_SCHEDULE_TSECT                 =          8 ;      
	/**
	 * \if ENGLISH_LANG
	 * URL max number
	 * \else
	 * URL最大个数
	 * \endif
	 */
	public static final int SDK_MAX_URL_NUM                      =          8 ;       
	
	/**
	 * \if ENGLISH_LANG
	 * Max battery quantity
	 * \else
	 * 最大电池数量
	 * \endif
	 */
	public static final int SDK_BATTERY_NUM_MAX                  =          16;
	
	/**
	 * \if ENGLISH_LANG
	 * Max power quantity
	 * \else
	 * 最大电源数量
	 * \endif
	 */
	public static final int SDK_POWER_NUM_MAX                    =          16;
	
	/**
	 * \if ENGLISH_LANG
	 * Max audio file path length
	 * \else
	 * 最大音频文件路长度
	 * \endif
	 */
	public static final int SDK_MAX_AUDIO_PATH                   =          260;
	
	/**
	 * \if ENGLISH_LANG
	 * Max access control name length
	 * \else
	 * 最大门禁名称长度
	 * \endif
	 */
	public static final int SDK_MAX_DOORNAME_LEN                 =          128;
	
	/**
	 * \if ENGLISH_LANG
	 * Max access control name length
	 * \else
	 * 最大门禁密码长度
	 * \endif
	 */
	public static final int SDK_MAX_CARDPWD_LEN                  =          64;
	
	public static final int  NET_MAX_FISHEYE_MOUNTMODE_NUM      = 4;                // 最大鱼眼安装模式个数
	public static final int  NET_MAX_FISHEYE_CALIBRATEMODE_NUM  = 16;               // 最大鱼眼矫正模式个数
	public static final int  NET_MAX_FISHEYE_EPTZCMD_NUM        = 64;               // 最大鱼眼电子云台操作个数   
	public static final int  POINT_NUM_IN_PAIR                  = 2;                // 标定点对中的点数量
	public static final int  MAX_POINT_PAIR_NUM                 = 128;              // 标定点最大数量
	public static final int  CHANNEL_NUM_IN_POINT_GROUP         = 2;                // 标定点中的视频通道数
	public static final int  MAX_POINT_GROUP_NUM                = 32;               // 标定点组最大数量, 每两个通道进行拼接需要一组标定点
	public static final int  MAX_LANE_INFO_NUM                  = 32;               // 最大车道信息数
	public static final int  MAX_LANE_DIRECTION_NUM             = 8;                // 车道方向总数
	public static final int  SDK_MAX_MONITORWALL_NUM             = 32;               // 电视墙最大数量
	public static final int  SDK_MAX_OPTIONAL_URL_NUM            = 8;                // 备用url最大数量
	
	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 最大有权限门禁数目
	 * \endif
	 */
	public static final int SDK_MAX_DOOR_NUM                     =          32;
	
	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 最大有效时间段数目
	 * \endif
	 */
	public static final int SDK_MAX_TIMESECTION_NUM              =          32;
	
	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 门禁卡号最大长度
	 * \endif
	 */
	public static final int SDK_MAX_CARDNO_LEN                   =          32;
	
	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 门禁卡用户ID最大长度
	 * \endif
	 */
	public static final int SDK_MAX_USERID_LEN                   =          32;

	/**
	 * \if ENGLISH_LANG
	 * User name length
	 * \else
	 * 用户名长度
	 * \endif
	 */
	public static final int     SDK_USER_NAME_LENGTH_EX = 16;			  
	/**
	 * \if ENGLISH_LANG
	 * Password 
	 * \else
	 * 密码
	 * \endif
	 */
	public static final int     SDK_USER_PSW_LENGTH_EX = 16;			
	
	/**
	 * \if ENGLISH_LANG
	 * Max bell number
	 * \else
	 *  最大警号个数
	 * \endif
	 */
	public static final int     SDK_MAX_BELL_NUM = 4;
	
	/**
	 * \if ENGLISH_LANG
	 * Max keyboard num
	 * \else
	 * 最大键盘数
	 * \endif
	 */
	public static final int     SDK_MAX_KEYBOARD_NUM  =  256;       

	/**
	 * \if ENGLISH_LANG
	 * Max user right amount
	 * \else
	 * 用户权限个数上限
	 * \endif
	 */
	public static final int     SDK_NEW_MAX_RIGHT_NUM     = 1024;

	
	public static final int 	SDK_MAX_ALARM_SUBSYSTEM_NUM = 8;
	/**
	 * \if ENGLISH_LANG
	 * Device property setup 
	 * \else
	 * 设备属性配置
	 * \endif
	 */
	public static final int SDK_DEV_DEVICECFG			 = 0x0001	;   
	/**
	 * \if ENGLISH_LANG
	 * Network setup
	 * \else
	 * 网络配置
	 * \endif
	 */
	public static final int SDK_DEV_NETCFG				 = 0x0002	;   
	/**
	 * \if ENGLISH_LANG
	 * Video channel setup
	 * \else
	 * 图象通道配置
	 * \endif
	 */
	public static final int SDK_DEV_CHANNELCFG			 = 0x0003	;   
	/**
	 * \if ENGLISH_LANG
	 * Preview parameter setup
	 * \else
	 * 预览参数配置
	 * \endif
	 */
	public static final int SDK_DEV_PREVIEWCFG 			 = 0x0004	;   
	/**
	 * \if ENGLISH_LANG
	 * Record setup
	 * \else
	 * 录像配置
	 * \endif
	 */
	public static final int SDK_DEV_RECORDCFG			 = 0x0005	;   
	/**
	 * \if ENGLISH_LANG
	 * COM property setup
	 * \else
	 * 串口属性配置
	 * \endif
	 */
	public static final int SDK_DEV_COMMCFG				 = 0x0006	;   
	/**
	 * \if ENGLISH_LANG
	 * Alarm property setup
	 * \else
	 * 报警属性配置
	 * \endif
	 */
	public static final int SDK_DEV_ALARMCFG 			 = 0x0007	;   
	/**
	 * \if ENGLISH_LANG
	 * DVR time setup
	 * \else
	 * DVR时间配置
	 * \endif
	 */
	public static final int SDK_DEV_TIMECFG 				 = 0x0008	;   
	/**
	 * \if ENGLISH_LANG
	 * Audio talk parameter setup
	 * \else
	 * 对讲参数配置
	 * \endif
	 */
	public static final int SDK_DEV_TALKCFG				 = 0x0009	;   
	/**
	 * \if ENGLISH_LANG
	 * Auto matrix setup
	 * \else
	 * 自动维护配置
	 * \endif
	 */
	public static final int SDK_DEV_AUTOMTCFG			 = 0x000A	;   		
	/**
	 * \if ENGLISH_LANG
	 * Local matrix control strategy setup
	 * \else
	 * 本机矩阵控制策略配置	
	 * \endif
	 */
	public static final int SDK_DEV_VEDIO_MARTIX			 = 0x000B	;   
	/**
	 * \if ENGLISH_LANG
	 * Multiple ddns setup 
	 * \else
	 * 多ddns服务器配置
	 * \endif
	 */
	public static final int SDK_DEV_MULTI_DDNS			 = 0x000C	;   
	/**
	 * \if ENGLISH_LANG
	 * Snapshot corresponding setup 
	 * \else
	 * 抓图相关配置
	 * \endif
	 */
	public static final int SDK_DEV_SNAP_CFG				 = 0x000D	;   
	/**
	 * \if ENGLISH_LANG
	 * HTTP path setup 
	 * \else
	 * HTTP路径配置
	 * \endif
	 */
	public static final int SDK_DEV_WEB_URL_CFG			 = 0x000E	;   
	/**
	 * \if ENGLISH_LANG
	 * FTP upload setup
	 * \else
	 * FTP上传配置
	 * \endif
	 */
	public static final int SDK_DEV_FTP_PROTO_CFG		 = 0x000F	;   
	/**
	 * \if ENGLISH_LANG
	 * Plaform embedded setup. Now the channel parameter represents the platform type.\n
	 * channel=4:Bell alcatel;channel=10:ZTE Netview;channel=11:U CNC  channel = 51 AMP
	 * \else
	 * 平台接入配置，此时channel参数代表平台类型，
	 * channel=4： 代表贝尔阿尔卡特；channel=10：代表中兴力维；channel=11：代表U网通；channel=51：代表天地阳光\n
	 * \endif
	 */
	public static final int SDK_DEV_INTERVIDEO_CFG		 = 0x0010	;   
	/**
	 * \if ENGLISH_LANG
	 * Privacy mask setup
	 * \else
	 * 区域遮挡配置
	 * \endif
	 */
	public static final int SDK_DEV_VIDEO_COVER			 = 0x0011	;   
	/**
	 * \if ENGLISH_LANG
	 * Transmission strategy. Video quality \ Fluency
	 * \else
	 * 传输策略配置，画质优先 \ 流畅性优先
	 * \endif
	 */
	public static final int SDK_DEV_TRANS_STRATEGY		 = 0x0012	;   
	/**
	 * \if ENGLISH_LANG
	 * Record download strategy setup:high-speed \ general download
	 * \else
	 * 录象下载策略配置，高速下载 \ 普通下载
	 * \endif
	 */
	public static final int SDK_DEV_DOWNLOAD_STRATEGY	 = 0x0013	;   
	/**
	 * \if ENGLISH_LANG
	 * Video watermark setup
	 * \else
	 * 图象水印配置
	 * \endif
	 */
	public static final int SDK_DEV_WATERMAKE_CFG		 = 0x0014	;   
	/**
	 * \if ENGLISH_LANG
	 * Wireless network setup
	 * \else
	 * 无线网络配置
	 * \endif
	 */
	public static final int SDK_DEV_WLAN_CFG				 = 0x0015	;   
	/**
	 * \if ENGLISH_LANG
	 * Search wireless device setup 
	 * \else
	 * 搜索无线设备配置
	 * \endif
	 */
	public static final int SDK_DEV_WLAN_DEVICE_CFG		 = 0x0016	;   
	/**
	 * \if ENGLISH_LANG
	 * Auto register parameter setup 
	 * \else
	 * 主动注册参数配置
	 * \endif
	 */
	public static final int SDK_DEV_REGISTER_CFG			 = 0x0017	;   
	/**
	 * \if ENGLISH_LANG
	 * Camera property setup
	 * \else
	 * 摄像头属性配置
	 * \endif
	 */
	public static final int SDK_DEV_CAMERA_CFG			 = 0x0018	;   
	/**
	 * \if ENGLISH_LANG
	 * IR alarm setup 
	 * \else
	 * 红外报警配置
	 * \endif
	 */
	public static final int SDK_DEV_INFRARED_CFG 		 = 0x0019	;   
	/**
	 * \if ENGLISH_LANG
	 * Sniffer setup 
	 * \else
	 * Sniffer抓包配置
	 * \endif
	 */
	public static final int SDK_DEV_SNIFFER_CFG			 = 0x001A	;   
	/**
	 * \if ENGLISH_LANG
	 * Mail setup 
	 * \else
	 * 邮件配置
	 * \endif
	 */
	public static final int SDK_DEV_MAIL_CFG				 = 0x001B	;   
	/**
	 * \if ENGLISH_LANG
	 * DNS setup 
	 * \else
	 * DNS服务器配置
	 * \endif
	 */
	public static final int SDK_DEV_DNS_CFG				 = 0x001C	;   
	/**
	 * \if ENGLISH_LANG
	 * NTP setup
	 * \else
	 * NTP配置
	 * \endif
	 */
	public static final int SDK_DEV_NTP_CFG				 = 0x001D	;   
	/**
	 * \if ENGLISH_LANG
	 * Audio detection setup 
	 * \else
	 * 音频检测配置
	 * \endif
	 */
	public static final int SDK_DEV_AUDIO_DETECT_CFG		 = 0x001E	;   
	/**
	 * \if ENGLISH_LANG
	 * Storage position setup
	 * \else
	 * 存储位置配置
	 * \endif
	 */
	public static final int SDK_DEV_STORAGE_STATION_CFG   = 0x001F      ; 
	/**
	 * \if ENGLISH_LANG
	 * PTZ operation property(It is invalid now. Please use CLIENT_GetPtzOptAttr to get PTZ operation property.)
	 * \else
	 * 云台操作属性(已经废除，请使用 GetPtzOptAttr 获取云台操作属性)
	 * \endif
	 */
	public static final int SDK_DEV_PTZ_OPT_CFG			 = 0x0020	;   
	/**
	 * \if ENGLISH_LANG
	 * Daylight Saving Time (DST)setup
	 * \else
	 * 夏令时配置
	 * \endif
	 */
	public static final int SDK_DEV_DST_CFG				 = 0x0021      ; 
	/**
	 * \if ENGLISH_LANG
	 * Alarm centre setup
	 * \else
	 * 报警中心配置
	 * \endif
	 */
	public static final int SDK_DEV_ALARM_CENTER_CFG		 = 0x0022	;   
	/**
	 * \if ENGLISH_LANG
	 * VIdeo OSD setup
	 * \else
	 * 视频OSD叠加配置
	 * \endif
	 */
	public static final int SDK_DEV_VIDEO_OSD_CFG         = 0x0023	;   
	/**
	 * \if ENGLISH_LANG
	 * CDMA \ GPRS configuration
	 * \else
	 * CDMA \ GPRS网络配置
	 * \endif
	 */
	public static final int SDK_DEV_CDMAGPRS_CFG          = 0x0024	;   
	/**
	 * \if ENGLISH_LANG
	 * IP Filter configuration
	 * \else
	 * IP过滤配置
	 * \endif
	 */
	
	public static final int SDK_DEV_IPFILTER_CFG          = 0x0025	;   
	/**
	 * \if ENGLISH_LANG
	 * Talk encode configuration
	 * \else
	 * 语音对讲编码配置
	 * \endif
	 */
	public static final int SDK_DEV_TALK_ENCODE_CFG       = 0x0026      ; 
	/**
	 * \if ENGLISH_LANG
	 * The length of the video package configuration
	 * \else
	 * 录像打包长度配置
	 * \endif
	 */
	public static final int SDK_DEV_RECORD_PACKET_CFG     = 0x0027      ; 
	/**
	 * \if ENGLISH_LANG
	 * SMS MMS configuration 
	 * \else
	 * 短信MMS配置 
	 * \endif
	 */
	public static final int SDK_DEV_MMS_CFG               = 0x0028	;   
	/**
	 * \if ENGLISH_LANG
	 * SMS to activate the wireless connection configuration
	 * \else
	 * 短信激活无线连接配置
	 * \endif
	 */
	public static final int SDK_DEV_SMSACTIVATION_CFG	 = 0x0029	;   
	/**
	 * \if ENGLISH_LANG
	 * Dial-up activation of a wireless connection configuration
	 * \else
	 * 拨号激活无线连接配置
	 * \endif
	 */
	public static final int SDK_DEV_DIALINACTIVATION_CFG	 = 0x002A	;   
	/**
	 * \if ENGLISH_LANG
	 * Capture network configuration
	 * \else
	 * 网络抓包配置
	 * \endif
	 */
	public static final int SDK_DEV_SNIFFER_CFG_EX		 = 0x0030	;   
	/**
	 * \if ENGLISH_LANG
	 * Download speed limit
	 * \else
	 * 下载速度限制
	 * \endif
	 */
	public static final int SDK_DEV_DOWNLOAD_RATE_CFG	 = 0x0031	;   
	/**
	 * \if ENGLISH_LANG
	 * Panorama switch alarm configuration
	 * \else
	 * 全景切换报警配置
	 * \endif
	 */
	public static final int SDK_DEV_PANORAMA_SWITCH_CFG	 = 0x0032	;   
	/**
	 * \if ENGLISH_LANG
	 * Lose focus alarm configuration
	 * \else
	 * 失去焦点报警配置
	 * \endif
	 */
	public static final int SDK_DEV_LOST_FOCUS_CFG		 = 0x0033	;   
	/**
	 * \if ENGLISH_LANG
	 * Alarm decoder configuration
	 * \else
	 * 报警解码器配置
	 * \endif
	 */
	public static final int SDK_DEV_ALARM_DECODE_CFG		 = 0x0034	;   
	/**
	 * \if ENGLISH_LANG
	 * Video output configuration
	 * \else
	 * 视频输出参数配置
	 * \endif
	 */
	public static final int SDK_DEV_VIDEOOUT_CFG          = 0x0035      ; 
	/**
	 * \if ENGLISH_LANG
	 * Preset enable configuration
	 * \else
	 * 预制点使能配置
	 * \endif
	 */
	public static final int SDK_DEV_POINT_CFG			 = 0x0036	;   
	/**
	 * \if ENGLISH_LANG
	 * IP conflication configurationIp
	 * \else
	 * Ip冲突检测报警配置
	 * \endif
	 */
	public static final int SDK_DEV_IP_COLLISION_CFG      = 0x0037      ; 
	/**
	 * \if ENGLISH_LANG
	 * OSD overlay enable configuration
	 * \else
	 * OSD叠加使能配置
	 * \endif
	 */
	public static final int SDK_DEV_OSD_ENABLE_CFG		 = 0x0038	;   
	/**
	 * \if ENGLISH_LANG
	 * Local alarm configuration(Structure DH_ALARMIN_CFG_EX)
	 * \else
	 * 本地报警配置(结构体SDK_ALARMIN_CFG_EX)
	 * \endif
	 */
	public static final int SDK_DEV_LOCALALARM_CFG 		 = 0x0039	;   
	/**
	 * \if ENGLISH_LANG
	 * Network alarm configuration(Structure DH_ALARMIN_CFG_EX)
	 * \else
	 * 网络报警配置(结构体SDK_ALARMIN_CFG_EX)
	 * \endif
	 */
	public static final int SDK_DEV_NETALARM_CFG 		 = 0x003A	;   
	/**
	 * \if ENGLISH_LANG
	 * Motion detection configuration(Structure DH_MOTION_DETECT_CFG_EX)
	 * \else
	 * 动检报警配置(结构体SDK_MOTION_DETECT_CFG_EX)
	 * \endif
	 */
	public static final int SDK_DEV_MOTIONALARM_CFG 		 = 0x003B	;   
	/**
	 * \if ENGLISH_LANG
	 * Video loss configuration(Structure DH_VIDEO_LOST_CFG_EX)
	 * \else
	 * 视频丢失报警配置(结构体SDK_VIDEO_LOST_CFG_EX)
	 * \endif
	 */
	public static final int SDK_DEV_VIDEOLOSTALARM_CFG 	 = 0x003C	;   
	/**
	 * \if ENGLISH_LANG
	 * Camera masking configuration(Structure DH_BLIND_CFG_EX)
	 * \else
	 * 视频遮挡报警配置(结构体SDK_BLIND_CFG_EX)
	 * \endif
	 */
	public static final int SDK_DEV_BLINDALARM_CFG 		 = 0x003D	;   
	/**
	 * \if ENGLISH_LANG
	 * HDD alarm configuration(Structure DH_DISK_ALARM_CFG_EX)
	 * \else
	 * 硬盘报警配置(结构体SDK_DISK_ALARM_CFG_EX)
	 * \endif
	 */
	public static final int SDK_DEV_DISKALARM_CFG 		 = 0x003E	;   
	/**
	 * \if ENGLISH_LANG
	 * Network disconnection alarm configuration(Structure DH_NETBROKEN_ALARM_CFG_EX)
	 * \else
	 * 网络中断报警配置(结构体SDK_NETBROKEN_ALARM_CFG_EX)
	 * \endif
	 */
	public static final int SDK_DEV_NETBROKENALARM_CFG 	 = 0x003F	;   
	/**
	 * \if ENGLISH_LANG
	 * Digital channel info of front encoders(Hybrid DVR use,Structure DEV_ENCODER_CFG)
	 * \else
	 * 数字通道的前端编码器信息(混合DVR使用，结构体DEV_ENCODER_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_ENCODER_CFG           = 0x0040      ; 
	/**
	 * \if ENGLISH_LANG
	 * TV adjust configuration(Now the channel parameter represents the TV numble(from 0), Structure SDKDEV_TVADJUST_CFG)
	 * \else
	 * TV调节配置（channel代表TV号(0开始)，类型结构体）
	 * \endif
	 */
	public static final int SDK_DEV_TV_ADJUST_CFG         = 0x0041      ; 
	/**
	 * \if ENGLISH_LANG
	 * about vehicle configuration
	 * \else
	 * 车载相关配置，北京公交使用
	 * \endif
	 */
	public static final int SDK_DEV_ABOUT_VEHICLE_CFG	 = 0x0042	;   
	/**
	 * \if ENGLISH_LANG
	 * ATM ability information
	 * \else
	 * 获取atm叠加支持能力信息
	 * \endif
	 */
	public static final int SDK_DEV_ATM_OVERLAY_ABILITY	 = 0x0043	;   
	/**
	 * \if ENGLISH_LANG
	 * ATM overlay configuration
	 * \else
	 * atm叠加配置，新atm特有
	 * \endif
	 */
	public static final int SDK_DEV_ATM_OVERLAY_CFG		 = 0x0044	;   
	/**
	 * \if ENGLISH_LANG
	 * Decoder tour configuration
	 * \else
	 * 解码器解码轮巡配置
	 * \endif
	 */
	public static final int SDK_DEV_DECODER_TOUR_CFG		 = 0x0045	;   
	/**
	 * \if ENGLISH_LANG
	 * SIP configuration
	 * \else
	 * SIP配置
	 * \endif
	 */
	public static final int SDK_DEV_SIP_CFG				 = 0x0046	;   
	/**
	 * \if ENGLISH_LANG
	 * wifi ap configuration
	 * \else
	 * wifi ap配置
	 * \endif
	 */
	public static final int SDK_DEV_VICHILE_WIFI_AP_CFG	 = 0x0047	;   
	/**
	 * \if ENGLISH_LANG
	 * Static
	 * \else
	 * 静态报警配置 
	 * \endif
	 */
	public static final int SDK_DEV_STATICALARM_CFG       = 0x0048      ; 
	/**
	 * \if ENGLISH_LANG
	 * decode policy configuration(Structure SDKDEV_DECODEPOLICY_CFG,channel start with 0) 
	 * \else
	 * 设备的解码策略配置(结构体SDKDEV_DECODEPOLICY_CFG，channel为解码通道0开始)
	 * \endif
	 */
	public static final int SDK_DEV_DECODE_POLICY_CFG     = 0x0049      ;  
	/**
	 * \if ENGLISH_LANG
	 * Device relative config (Structure SDKDEV_MACHINE_CFG)
	 * \else
	 * 机器相关的配置(结构体SDKDEV_MACHINE_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_MACHINE_CFG			 = 0x004A	;   
	/**
	 * \if ENGLISH_LANG
	 * MACconflication configuration(Structure ALARM_MAC_COLLISION_CFG)
	 * \else
	 * MAC冲突检测配置(结构体ALARM_MAC_COLLISION_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_MAC_COLLISION_CFG     = 0x004B      ; 
	/**
	 * \if ENGLISH_LANG
	 * RTSP configuration(structure SDKDEV_RTSP_CFG)
	 * \else
	 * RTSP配置(对应结构体SDKDEV_RTSP_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_RTSP_CFG              = 0x004C      ; 
	/**
	 * \if ENGLISH_LANG
	 * 232 com card signal event configuration(structure COM_CARD_SIGNAL_LINK_CFG)
	 * \else
	 * 232串口卡号信号事件配置(对应结构体COM_CARD_SIGNAL_LINK_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_232_COM_CARD_CFG      = 0x004E      ; 
	/**
	 * \if ENGLISH_LANG
	 * 485 com card signal event configuration(structure COM_CARD_SIGNAL_LINK_CFG)
	 * \else
	 * 485串口卡号信号事件配置(对应结构体COM_CARD_SIGNAL_LINK_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_485_COM_CARD_CFG      = 0x004F      ; 
	/**
	 * \if ENGLISH_LANG
	 * extend FTP upload setup(Structure SDKDEV_FTP_PROTO_CFG_EX)
	 * \else
	 * FTP上传扩展配置(对应结构体SDKDEV_FTP_PROTO_CFG_EX)
	 * \endif
	 */
	public static final int SDK_DEV_FTP_PROTO_CFG_EX		 = 0x0050	;   
	/**
	 * \if ENGLISH_LANG
	 * SYSLOG remote server config (Structure SDKDEV_SYSLOG_REMOTE_SERVER)
	 * \else
	 * SYSLOG 远程服务器配置(对应结构体SDKDEV_SYSLOG_REMOTE_SERVER)
	 * \endif
	 */
	public static final int SDK_DEV_SYSLOG_REMOTE_SERVER	 = 0x0051	;   
	/**
	 * \if ENGLISH_LANG
	 * Extended com configuration(structure SDKDEV_COMM_CFG_EX)
	 * \else
	 * 扩展串口属性配置(对应结构体SDKDEV_COMM_CFG_EX) 
	 * \endif
	 */
	public static final int SDK_DEV_COMMCFG_EX            = 0x0052      ;            
	/**
	 * \if ENGLISH_LANG
	 * net card configuration(structure SDKDEV_NETCARD_CFG)
	 * \else
	 * 卡口信息配置(对应结构体SDKDEV_NETCARD_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_NETCARD_CFG           = 0x0053      ; 
	/**
	 * \if ENGLISH_LANG
	 * Video backup format(structure SDKDEV_BACKUP_VIDEO_FORMAT)
	 * \else
	 * 视频备份格式配置(对应结构体SDKDEV_BACKUP_VIDEO_FORMAT)
	 * \endif
	 */
	public static final int SDK_DEV_BACKUP_VIDEO_FORMAT   = 0x0054	;   
	/**
	 * \if ENGLISH_LANG
	 * stream encrypt configuration(structure DHEDV_STREAM_ENCRYPT)
	 * \else
	 * 码流加密配置(对应结构体DHEDV_STREAM_ENCRYPT)
	 * \endif
	 */
	public static final int SDK_DEV_STREAM_ENCRYPT_CFG    = 0x0055      ; 
	/**
	 * \if ENGLISH_LANG
	 * IP filter extended configuration(structure SDKDEV_IPIFILTER_CFG_EX)
	 * \else
	 * IP过滤配置扩展(对应结构体SDKDEV_IPIFILTER_CFG_EX)
	 * \endif
	 */
	public static final int SDK_DEV_IPFILTER_CFG_EX       = 0x0056	;   
	/**
	 * \if ENGLISH_LANG
	 * custom configuration(structure SDKDEV_CUSTOM_CFG)
	 * \else
	 * 用户自定义配置(对应结构体SDKDEV_CUSTOM_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_CUSTOM_CFG            = 0x0057      ; 
	/**
	 * \if ENGLISH_LANG
	 * Search wireless device extended setup(structure SDKDEV_WLAN_DEVICE_LIST_EX)
	 * \else
	 * 搜索无线设备扩展配置(对应结构体SDKDEV_WLAN_DEVICE_LIST_EX)
	 * \endif
	 */
	public static final int SDK_DEV_WLAN_DEVICE_CFG_EX    = 0x0058      ; 
	/**
	 * \if ENGLISH_LANG
	 * ACC power off configuration(structure SDKDEV_ACC_POWEROFF_CFG)
	 * \else
	 * ACC断线事件配置(对应结构体SDKDEV_ACC_POWEROFF_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_ACC_POWEROFF_CFG      = 0x0059      ; 
	/**
	 * \if ENGLISH_LANG
	 * explosion proof alarm configuration(structure SDKDEV_EXPLOSION_PROOF_CFG)
	 * \else
	 * 防爆盒报警事件配置(对应结构体SDKDEV_EXPLOSION_PROOF_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_EXPLOSION_PROOF_CFG   = 0x005a      ; 
	/**
	 * \if ENGLISH_LANG
	 * Network extended setup(struct SDKDEV_NET_CFG_EX)
	 * \else
	 * 网络扩展配置(对应结构体SDKDEV_NET_CFG_EX)
	 * \endif
	 */
	public static final int SDK_DEV_NETCFG_EX			 = 0x005b	;   
	/**
	 * \if ENGLISH_LANG
	 * light control config(struct SDKDEV_LIGHTCONTROL_CFG)
	 * \else
	 * 灯光控制配置(对应结构体SDKDEV_LIGHTCONTROL_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_LIGHTCONTROL_CFG      = 0x005c      ; 
	/**
	 * \if ENGLISH_LANG
	 * 3G flow info config(struct SDKDEV_3GFLOW_INFO_CFG)
	 * \else
	 * 3G流量信息配置(对应结构体SDKDEV_3GFLOW_INFO_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_3GFLOW_CFG            = 0x005d      ; 
	/**
	 * \if ENGLISH_LANG
	 * IPv6 config(struct SDKDEV_IPV6_CFG)
	 * \else
	 * IPv6配置(对应结构体SDKDEV_IPV6_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_IPV6_CFG              = 0x005e      ; 
	/**
	 * \if ENGLISH_LANG
	 * Snmp config(struct SDKDEV_NET_SNMP_CFG)
	 * \else
	 * Snmp配置(对应结构体SDKDEV_NET_SNMP_CFG), 设置完成后需要重启设备
	 * \endif
	 */
	public static final int SDK_DEV_SNMP_CFG              = 0x005f      ; 
	/**
	 * \if ENGLISH_LANG
	 * snap control config(struct SDKDEV_SNAP_CONTROL_CFG)
	 * \else
	 * 抓图开关配置(对应结构体SDKDEV_SNAP_CONTROL_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_SNAP_CONTROL_CFG      = 0x0060      ; 
	/**
	 * \if ENGLISH_LANG
	 * GPS mode config(struct SDKDEV_GPS_MODE_CFG)
	 * \else
	 * GPS定位模式配置(对应结构体SDKDEV_GPS_MODE_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_GPS_MODE_CFG          = 0x0061      ; 
	/**
	 * \if ENGLISH_LANG
	 * Snap upload config(struct SDKDEV_SNAP_UPLOAD_CFG)
	 * \else
	 * 图片上传配置信息(对应结构体 SDKDEV_SNAP_UPLOAD_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_SNAP_UPLOAD_CFG       = 0x0062      ; 
	/**
	 * \if ENGLISH_LANG
	 * Speed limit config(struct SDKDEV_SPEED_LIMIT_CFG)
	 * \else
	 * 限速配置信息(对应结构体SDKDEV_SPEED_LIMIT_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_SPEED_LIMIT_CFG       = 0x0063      ; 
	/**
	 * \if ENGLISH_LANG
	 * iSCSI config(struct SDKDEV_ISCSI_CFG), need reboot
	 * \else
	 * iSCSI配置(对应结构体SDKDEV_ISCSI_CFG), 设置完成后需要重启设备
	 * \endif
	 */
	public static final int SDK_DEV_ISCSI_CFG			 = 0x0064	;   
	/**
	 * \if ENGLISH_LANG
	 * wifi config(struc SDKDEV_WIRELESS_ROUTING_CFG)
	 * \else
	 * 无线路由配置(对应结构体SDKDEV_WIRELESS_ROUTING_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_WIRELESS_ROUTING_CFG	 = 0x0065	;   
	/**
	 * \if ENGLISH_LANG
	 * enclosure config(stuct SDKDEV_ENCLOSURE_CFG)
	 * \else
	 * 电子围栏配置(对应结构体SDKDEV_ENCLOSURE_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_ENCLOSURE_CFG         = 0x0066      ; 
	/**
	 * \if ENGLISH_LANG
	 * enclosure version config(struct SDKDEV_ENCLOSURE_VERSION_CFG)
	 * \else
	 * 电子围栏版本号配置(对应结构体SDKDEV_ENCLOSURE_VERSION_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_ENCLOSURE_VERSION_CFG  = 0x0067     ; 
	/**
	 * \if ENGLISH_LANG
	 * Raid event config(struct SDKDEV_RAID_EVENT_CFG)
	 * \else
	 * Raid事件配置(对应结构体SDKDEV_RAID_EVENT_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_RIAD_EVENT_CFG         = 0x0068     ; 
	/**
	 * \if ENGLISH_LANG
	 * fire alarm config(struct SDKDEV_FIRE_ALARM_CFG)
	 * \else
	 * 火警报警配置(对应结构体SDKDEV_FIRE_ALARM_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_FIRE_ALARM_CFG         = 0x0069     ; 
	/**
	 * \if ENGLISH_LANG
	 * local alarm name config(string like "Name1&&name2&&name3...")
	 * \else
	 * 本地名称报警配置(对应Name1&&name2&&name3...格式字符串)
	 * \endif
	 */
	public static final int SDK_DEV_LOCALALARM_NAME_CFG    = 0x006a     ; 
	/**
	 * \if ENGLISH_LANG
	 * urgency storage config(struct SDKDEV_URGENCY_RECORD_CFG)
	 * \else
	 * 紧急存储配置(对应结构体SDKDEV_URGENCY_RECORD_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_URGENCY_RECORD_CFG     = 0x0070     ; 
	/**
	 * \if ENGLISH_LANG
	 * elevator parameter config(struct SDKDEV_ELEVATOR_ATTRI_CFG)
	 * \else
	 * 电梯运行参数配置(对应结构体SDKDEV_ELEVATOR_ATTRI_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_ELEVATOR_ATTRI_CFG     = 0x0071     ; 
	/**
	 * \if ENGLISH_LANG
	 * TM overlay function. For latest ATM series product only. 
	 * \else
	 * atm叠加配置，新atm特有,支持大于32通道的设备(对应结构体SDKDEV_ATM_OVERLAY_CONFIG_EX)
	 * \endif
	 */
	public static final int SDK_DEV_ATM_OVERLAY_CFG_EX	  = 0x0072	;   
	/**
	 * \if ENGLISH_LANG
	 * Support devices of 32-channel or higher.( struct SDKDEV_ATM_OVERLAY_CONFIG_EX)
	 * \else
	 * MAC过滤配置(对应结构体SDKDEV_MACFILTER_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_MACFILTER_CFG		  = 0x0073	;   
	/**
	 * \if ENGLISH_LANG
	 * MAC filter config(struct SDKDEV_MACFILTER_CFG)
	 * \else
	 * MAC,IP过滤(要求ip,mac是一一对应的)配置(对应结构体SDKDEV_MACIPFILTER_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_MACIPFILTER_CFG		  = 0x0074	;   
	/**
	 * \if ENGLISH_LANG
	 * MAC,IP filter config(need ip,mac one to one corresponding)(struct SDKDEV_MACIPFILTER_CFG)
	 * \else
	 * 码流加密(加密计划)配置(对应结构体DHEDV_STREAM_ENCRYPT)
	 * \endif
	 */
	public static final int SDK_DEV_STREAM_ENCRYPT_TIME_CFG  = 0x0075   ; 
	/**
	 * \if ENGLISH_LANG
	 * stream encrypt(encryot plan)(struct DHEDV_STREAM_ENCRYPT)
	 * \else
	 * 限码流配置(对应结构体 SDKDEV_LIMIT_BIT_RATE) 
	 * \endif
	 */
	public static final int SDK_DEV_LIMIT_BIT_RATE_CFG     = 0x0076     ; 
	/**
	 * \if ENGLISH_LANG
	 * limit bit rate config(struct SDKDEV_LIMIT_BIT_RATE)
	 * \else
	 * 抓图相关配置扩展(对应结构体 SDKDEV_SNAP_CFG_EX)
	 * \endif
	 */
	public static final int SDK_DEV_SNAP_CFG_EX			  = 0x0077	;   
	/**
	 * \if ENGLISH_LANG
	 * snap extern config(struct SDKDEV_SNAP_CFG_EX)
	 * \else
	 * 解码器url配置(对应结构体SDKDEV_DECODER_URL_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_DECODER_URL_CFG		 = 0x0078	;   
	/**
	 * \if ENGLISH_LANG
	 * decoder url config(struct SDKDEV_DECODER_URL_CFG)
	 * \else
	 * 轮巡使能配置(对应结构体SDKDEV_TOUR_ENABLE_CFG)
	 * \endif
	 */
	public static final int SDK_DEV_TOUR_ENABLE_CFG		 = 0x0079	;   
	/**
	 * \if ENGLISH_LANG
	 * toyr enable config(struct SDKDEV_TOUR_ENABLE_CFG)
	 * \else
	 * wifi ap配置扩展(对应结构体SDKDEV_VEHICLE_WIFI_AP_CFG_EX)
	 * \endif
	 */
	public static final int SDK_DEV_VICHILE_WIFI_AP_CFG_EX  = 0x007a    ; 
	/**
	 * \if ENGLISH_LANG
	 * wifi ap extern config(struct SDKDEV_VEHICLE_WIFI_AP_CFG_EX)
	 * \else
	 * 数字通道的前端编码器信息扩展，(对应结构体DEV_ENCODER_CFG_EX)
	 * \endif
	 */
	public static final int SDK_DEV_ENCODER_CFG_EX          = 0x007b    ; 

	public static final int SDK_DEV_USER_END_CFG			 = 1000;
	
	// 扩展报警类型，对应CLIENT_StartListenEx接口
	public static final int SDK_ALARM_ALARM_EX                 = 0x2101;           // 外部报警
	public static final int SDK_MOTION_ALARM_EX                = 0x2102;           // 动态检测报警
	public static final int SDK_VIDEOLOST_ALARM_EX             = 0x2103;           // 视频丢失报警
	public static final int SDK_SHELTER_ALARM_EX               = 0x2104;           // 视频遮挡报警
	public static final int SDK_SOUND_DETECT_ALARM_EX          = 0x2105;           // 音频检测报警
	public static final int SDK_DISKFULL_ALARM_EX              = 0x2106;           // 硬盘满报警
	public static final int SDK_DISKERROR_ALARM_EX             = 0x2107;           // 坏硬盘报警
	public static final int SDK_ENCODER_ALARM_EX               = 0x210A;           // 编码器报警
	public static final int SDK_URGENCY_ALARM_EX               = 0x210B;           // 紧急报警
	public static final int SDK_WIRELESS_ALARM_EX              = 0x210C;           // 无线报警
	public static final int SDK_NEW_SOUND_DETECT_ALARM_EX      = 0x210D;           // 新音频检测报警，报警信息的结构体见DH_NEW_SOUND_ALARM_STATE；
	public static final int SDK_ALARM_DECODER_ALARM_EX         = 0x210E;           // 报警解码器报警
	public static final int SDK_DECODER_DECODE_ABILITY         = 0x210F;           // 解码器：解码能力报警
	public static final int SDK_FDDI_DECODER_ABILITY           = 0x2110;           // 光纤编码器状态报警
	public static final int SDK_PANORAMA_SWITCH_ALARM_EX       = 0x2111;           // 切换场景报警
	public static final int SDK_LOSTFOCUS_ALARM_EX             = 0x2112;           // 失去焦点报警
	public static final int SDK_OEMSTATE_EX                    = 0x2113;           // oem报停状态
	public static final int SDK_DSP_ALARM_EX                   = 0x2114;           // DSP报警
	public static final int SDK_ATMPOS_BROKEN_EX               = 0x2115;           // atm和pos机断开报警， 0：连接断开 1：连接正常
	public static final int SDK_RECORD_CHANGED_EX              = 0x2116;           // 录像状态变化报警
	public static final int SDK_CONFIG_CHANGED_EX              = 0x2117;           // 配置发生变化报警
	public static final int SDK_DEVICE_REBOOT_EX               = 0x2118;           // 设备重启报警
	public static final int SDK_WINGDING_ALARM_EX              = 0x2119;           // 线圈/车检器故障报警
	public static final int SDK_TRAF_CONGESTION_ALARM_EX       = 0x211A;           // 交通阻塞报警(车辆出现异常停止或者排队)
	public static final int SDK_TRAF_EXCEPTION_ALARM_EX        = 0x211B;           // 交通异常报警(交通流量趋于0或异常空闲)
	public static final int SDK_EQUIPMENT_FILL_ALARM_EX        = 0x211C;           // 补光设备故障报警
	public static final int SDK_ALARM_ARM_DISARM_STATE         = 0x211D;           // 报警布撤防状态
	public static final int SDK_ALARM_ACC_POWEROFF             = 0x211E;           // ACC断电报警
	public static final int SDK_ALARM_3GFLOW_EXCEED            = 0x211F;           // 3G流量超出阈值报警(报警信息的结构体见结构体DHDEV_3GFLOW_EXCEED_STATE_INFO)
	public static final int SDK_ALARM_SPEED_LIMIT              = 0x2120;           // 限速报警
	public static final int SDK_ALARM_VEHICLE_INFO_UPLOAD      = 0x2121;           // 车载自定义信息上传 
	public static final int SDK_STATIC_ALARM_EX                = 0x2122;           // 静态检测报警
	public static final int SDK_PTZ_LOCATION_EX                = 0x2123;           // 云台定位信息
	public static final int SDK_ALARM_CARD_RECORD_UPLOAD       = 0x2124;           // 卡号录像信息上传(对应结构体 ALARM_CARD_RECORD_INFO_UPLOAD)
	public static final int SDK_ALARM_ATM_INFO_UPLOAD          = 0x2125;           // ATM交易信息上传(对应结构体 ALARM_ATM_INFO_UPLOAD)
	public static final int SDK_ALARM_ENCLOSURE                = 0x2126;           // 电子围栏报警(对应结构体ALARM_ENCLOSURE_INFO)
	public static final int SDK_ALARM_SIP_STATE                = 0x2127;           // SIP状态报警(对应结构体ALARM_SIP_STATE)
	public static final int SDK_ALARM_RAID_STATE               = 0x2128;           // RAID异常报警(对应结构体ALARM_RAID_INFO)
	public static final int SDK_ALARM_CROSSING_SPEED_LIMIT     = 0x2129;           // 路口限速报警(对应结构体ALARM_SPEED_LIMIT)
	public static final int SDK_ALARM_OVER_LOADING             = 0x212A;           // 超载报警(对应结构体ALARM_OVER_LOADING)
	public static final int SDK_ALARM_HARD_BRAKING             = 0x212B;           // 急刹车报警(对应机构体ALARM_HARD_BRAKING)
	public static final int SDK_ALARM_SMOKE_SENSOR             = 0x212C;           // 烟感报警(对应结构体ALARM_SMOKE_SENSOR)
	public static final int SDK_ALARM_TRAFFIC_LIGHT_FAULT      = 0x212D;           // 交通灯故障报警(对应结构体ALARM_TRAFFIC_LIGHT_FAULT) 
	public static final int SDK_ALARM_TRAFFIC_FLUX_STAT        = 0x212E;           // 交通流量统计报警(对应结构体ALARM_TRAFFIC_FLUX_LANE_INFO)
	public static final int SDK_ALARM_CAMERA_MOVE              = 0x212F;           // 摄像机移位报警事件(对应结构体ALARM_CAMERA_MOVE_INFO)
	public static final int SDK_ALARM_DETAILEDMOTION           = 0x2130;           // 详细动检报警上报信息(对应结构体ALARM_DETAILEDMOTION_CHNL_INFO)
	public static final int SDK_ALARM_STORAGE_FAILURE          = 0x2131;           // 存储异常报警(对应结构体ALARM_STORAGE_FAILURE数组)
	public static final int SDK_ALARM_FRONTDISCONNECT          = 0x2132;           // 前端IPC断网报警(对应结构体ALARM_FRONTDISCONNET_INFO)
	public static final int SDK_ALARM_ALARM_EX_REMOTE          = 0x2133;           // 远程外部报警(对应结构体 ALARM_REMOTE_ALARM_INFO)
	public static final int SDK_ALARM_BATTERYLOWPOWER          = 0x2134;           // 电池电量低报警(对应结构体ALARM_BATTERYLOWPOWER_INFO)
	public static final int SDK_ALARM_TEMPERATURE              = 0x2135;           // 温度过高报警(对应结构体ALARM_TEMPERATURE_INFO)
	public static final int SDK_ALARM_TIREDDRIVE               = 0x2136;           // 疲劳驾驶报警(对应结构体ALARM_TIREDDRIVE_INFO)
	public static final int SDK_ALARM_LOST_RECORD              = 0x2137;           // 丢录像事件报警(对应结构体ALARM_LOST_RECORD)
	public static final int SDK_ALARM_HIGH_CPU                 = 0x2138;           // CPU占用率过高事件报警(对应结构体ALARM_HIGH_CPU)
	public static final int SDK_ALARM_LOST_NETPACKET           = 0x2139;           // 网络发送数据丢包事件报警(对应结构体ALARM_LOST_NETPACKET)
	public static final int SDK_ALARM_HIGH_MEMORY              = 0x213A;           // 内存占用率过高事件报警(对应结构体ALARM_HIGH_MEMORY)
	public static final int SDK_LONG_TIME_NO_OPERATION         = 0x213B;           // WEB用户长时间无操作事件（无扩展信息）
	public static final int SDK_BLACKLIST_SNAP                 = 0x213C;           // 黑名单车辆抓拍事件(对应结构体DH_BLACKLIST_SNAP_INFO)         
	public static final int SDK_ALARM_DISK                     = 0x213E;           // 硬盘报警(对应ALARM_DISK_INFO数组)
	public static final int SDK_ALARM_FILE_SYSTEM              = 0x213F;           // 文件系统报警(对应ALARM_FILE_SYSTEM_INFO数组)
	public static final int SDK_ALARM_IVS                      = 0x2140;           // 智能报警事件(对应结构体ALARM_IVS_INFO)
	public static final int SDK_ALARM_GOODS_WEIGHT_UPLOAD      = 0x2141;           // 货重信息上报(对应ALARM_GOODS_WEIGHT_UPLOAD_INFO)
	public static final int SDK_ALARM_GOODS_WEIGHT             = 0x2142;           // 货重信息报警(对应ALARM_GOODS_WEIGHT_INFO)
	public static final int SDK_GPS_STATUS                     = 0x2143;           // GPS定位信息(对应 NET_GPS_STATUS_INFO)
	public static final int SDK_ALARM_DISKBURNED_FULL          = 0x2144;           // 硬盘刻录满报警(对应 ALARM_DISKBURNED_FULL_INFO)
	public static final int SDK_ALARM_STORAGE_LOW_SPACE        = 0x2145;           // 存储容量不足事件(对应ALARM_STORAGE_LOW_SPACE_INFO)
	public static final int SDK_ALARM_DISK_FLUX                = 0x2160;           // 硬盘数据异常事件(对应ALARM_DISK_FLUX)
	public static final int SDK_ALARM_NET_FLUX                 = 0x2161;           // 网络数据异常事件(对应ALARM_NET_FLUX)
	public static final int SDK_ALARM_FAN_SPEED                = 0x2162;           // 风扇转速异常事件(对应ALARM_FAN_SPEED)
	public static final int SDK_ALARM_STORAGE_FAILURE_EX       = 0x2163;           // 存储错误报警(对应结构体ALARM_STORAGE_FAILURE_EX)
	public static final int SDK_ALARM_RECORD_FAILED            = 0x2164;           // 录像异常报警(对应结构体ALARM_RECORD_FAILED_INFO)
	public static final int SDK_ALARM_STORAGE_BREAK_DOWN       = 0x2165;           // 存储崩溃事件(对应结构体ALARM_STORAGE_BREAK_DOWN_INFO)
	public static final int SDK_ALARM_VIDEO_ININVALID          = 0x2166;           // 视频输入通道失效事件（例：配置的视频输入通道码流，超出设备处理能力）ALARM_VIDEO_ININVALID_INFO
	public static final int SDK_ALARM_VEHICLE_TURNOVER         = 0x2167;           // 车辆侧翻报警事件(对应结构体ALARM_VEHICEL_TURNOVER_EVENT_INFO)
	public static final int SDK_ALARM_VEHICLE_COLLISION        = 0x2168;           // 车辆撞车报警事件(对应结构体ALARM_VEHICEL_COLLISION_EVENT_INFO)
	public static final int SDK_ALARM_VEHICLE_CONFIRM          = 0x2169;           // 车辆上传信息事件(对应结构体ALARM_VEHICEL_CONFIRM_INFO)
	public static final int SDK_ALARM_VEHICLE_LARGE_ANGLE      = 0x2170;           // 车载摄像头大角度扭转事件(对应结构体ALARM_VEHICEL_LARGE_ANGLE)
	public static final int SDK_ALARM_TALKING_INVITE           = 0x2171;           // 设备请求对方发起对讲事件(对应结构体ALARM_TALKING_INVITE_INFO)
	public static final int SDK_ALARM_ALARM_EX2                = 0x2175;           // 本地报警事件(对应结构体ALARM_ALARM_INFO_EX2，对DH_ALARM_ALARM_EX升级)
	public static final int SDK_ALARM_VIDEO_TIMING             = 0x2176;           // 视频定时检测事件(对应结构体ALARM_VIDEO_TIMING)
	public static final int SDK_ALARM_COMM_PORT                = 0x2177;           // 串口事件(对应结构体ALARM_COMM_PORT_EVENT_INFO)
	public static final int SDK_ALARM_AUDIO_ANOMALY            = 0x2178;           // 音频异常事件(对应结构体ALARM_AUDIO_ANOMALY)
	public static final int SDK_ALARM_AUDIO_MUTATION           = 0x2179;           // 声强突变事件(对应结构体ALARM_AUDIO_MUTATION)
	public static final int SDK_EVENT_TYREINFO                 = 0x2180;           // 轮胎信息上报事件(对应结构体EVENT_TYRE_INFO)
	public static final int SDK_ALARM_POWER_ABNORMAL           = 0x2181;           // 冗余电源异常报警(对应结构体ALARM_POWER_ABNORMAL_INFO)
	public static final int SDK_EVENT_REGISTER_OFF             = 0x2182;           // 车载设备主动下线事件(对应结构体 EVENT_REGISTER_OFF_INFO)
	public static final int SDK_ALARM_NO_DISK                  = 0x2183;           // 无硬盘报警(对应结构体ALARM_NO_DISK_INFO)
	public static final int SDK_ALARM_FALLING                  = 0x2184;           // 跌落事件报警(对应结构体ALARM_FALLING_INFO)
	public static final int SDK_ALARM_PROTECTIVE_CAPSULE       = 0x2185;           // 防护舱事件(对应结构体ALARM_PROTECTIVE_CAPSULE_INFO)
	public static final int SDK_ALARM_NO_RESPONSE              = 0x2186;           // 呼叫未应答警报(对应结构体ALARM_NO_RESPONSE_INFO)
	public static final int SDK_ALARM_CONFIG_ENABLE_CHANGE     = 0x2187;           // 配置使能改变上报事件(对应结构体 ALARM_CONFIG_ENABLE_CHANGE_INFO)

	public static final int SDK_ALARM_STORAGE_NOT_EXIST        = 0x3167;           // 存储组不存在事件(对应结构体ALARM_STORAGE_NOT_EXIST_INFO)
	public static final int SDK_ALARM_NET_ABORT                = 0x3169;           // 网络故障事件(对应结构体ALARM_NETABORT_INFO)
	public static final int SDK_ALARM_IP_CONFLICT              = 0x3170;           // IP冲突事件(对应结构体ALARM_IP_CONFLICT_INFO)
	public static final int SDK_ALARM_MAC_CONFLICT             = 0x3171;           // MAC冲突事件(对应结构体ALARM_MAC_CONFLICT_INFO)
	public static final int SDK_ALARM_POWERFAULT               = 0x3172;           // 电源故障事件(对应结构体ALARM_POWERFAULT_INFO)
	public static final int SDK_ALARM_CHASSISINTRUDED          = 0x3173;           // 机箱入侵(防拆)报警事件(对应结构体ALARM_CHASSISINTRUDED_INFO)
	public static final int SDK_ALARM_ALARMEXTENDED            = 0x3174;           // 本地扩展报警事件(对应结构体 ALARM_ALARMEXTENDED_INFO)
	public static final int SDK_ALARM_ARMMODE_CHANGE_EVENT     = 0x3175;           // 布撤防状态变化事件(对应结构体ALARM_ARMMODE_CHANGE_INFO)
	public static final int SDK_ALARM_BYPASSMODE_CHANGE_EVENT  = 0x3176;           // 旁路状态变化事件(对应结构体ALARM_BYPASSMODE_CHANGE_INFO)
	public static final int SDK_ALARM_ACCESS_CTL_NOT_CLOSE     = 0x3177;           // 门禁未关事件(对应结构体ALARM_ACCESS_CTL_NOT_CLOSE_INFO)
	public static final int SDK_ALARM_ACCESS_CTL_BREAK_IN      = 0x3178;           // 闯入事件(对应结构体ALARM_ACCESS_CTL_BREAK_IN_INFO)
	public static final int SDK_ALARM_ACCESS_CTL_REPEAT_ENTER  = 0x3179;           // 反复进入事件(对应结构体ALARM_ACCESS_CTL_REPEAT_ENTER_INFO)
	public static final int SDK_ALARM_ACCESS_CTL_DURESS        = 0x3180;           // 胁迫卡刷卡事件(对应结构体ALARM_ACCESS_CTL_DURESS_INFO)
	public static final int SDK_ALARM_ACCESS_CTL_EVENT         = 0x3181;           // 门禁事件(对应结构体ALARM_ACCESS_CTL_EVENT_INFO)
	public static final int SDK_URGENCY_ALARM_EX2              = 0x3182;           // 紧急报警EX2(对DH_URGENCY_ALARM_EX的升级,对应结构体ALARM_URGENCY_ALARM_EX2, 人为触发的紧急事件, 一般处理是联动外部通讯功能请求帮助
	public static final int SDK_ALARM_INPUT_SOURCE_SIGNAL      = 0x3183;           // 报警输入源信号事件(只要有输入就会产生该事件, 不论防区当前的模式，无法屏蔽, 对应ALARM_INPUT_SOURCE_SIGNAL_INFO)
	public static final int SDK_ALARM_ANALOGALARM_EVENT        = 0x3184;           // 模拟量报警输入通道事件(对应结构体ALARM_ANALOGALARM_EVENT_INFO)
	public static final int SDK_ALARM_ACCESS_CTL_STATUS        = 0x3185;           // 门禁状态事件(对应结构体ALARM_ACCESS_CTL_STATUS_INFO)
	public static final int SDK_ALARM_ACCESS_SNAP              = 0x3186;           // 门禁抓图事件(对应结构体ALARM_ACCESS_SNAP_INFO)
	public static final int SDK_ALARM_ALARMCLEAR               = 0x3187;           // 消警事件(对应结构体ALARM_ALARMCLEAR_INFO)
	public static final int SDK_ALARM_CIDEVENT                 = 0x3188;           // CID事件(对应结构体ALARM_CIDEVENT_INFO)
	public static final int SDK_ALARM_TALKING_HANGUP           = 0x3189;           // 设备主动挂断对讲事件(对应结构体ALARM_TALKING_HANGUP_INFO)
	public static final int SDK_ALARM_BANKCARDINSERT           = 0x318a;           // 银行卡插卡事件(对应结构体ALARM_BANKCARDINSERT_INFO)
	public static final int SDK_ALARM_RCEMERGENCY_CALL         = 0x318b;           // 紧急呼叫报警事件(对应结构体 ALARM_RCEMERGENCY_CALL_INFO)
	public static final int SDK_ALARM_OPENDOORGROUP            = 0x318c;           // 多人组合开门事件(对应结构体ALARM_OPEN_DOOR_GROUP_INFO)
	public static final int SDK_ALARM_FINGER_PRINT             = 0x318d;           // 获取指纹事件(对应结构体ALARM_CAPTURE_FINGER_PRINT_INFO)
	public static final int SDK_ALARM_CARD_RECORD              = 0x318e;           // 卡号录像事件(对应结构体 ALARM_CARD_RECORD_INFO)
	public static final int SDK_ALARM_SUBSYSTEM_STATE_CHANGE   = 0x318f;           // 子系统状态改变事件(对应结构体ALARM_SUBSYSTEM_STATE_CHANGE_INFO)
	public static final int SDK_ALARM_BATTERYPOWER_EVENT       = 0x3190;           // 电池电量定时通知事件(对应结构体ALARM_BATTERYPOWER_INFO)
	public static final int SDK_ALARM_BELLSTATUS_EVENT         = 0x3191;           // 警号状态事件(对应结构体ALARM_BELLSTATUS_INFO)
	public static final int SDK_ALARM_DEFENCE_STATE_CHANGE_EVENT = 0x3192;         // 防区状态变化事件(对应结构体ALARM_DEFENCE_STATUS_CHANGE_INFO), 
	                                                           // 定制需求，和布防撤防变化事件、旁路状态变化事件中的状态定义不同，
	                                                           // 该状态通过CLIENT_QueryDevState()接口的DH_DEVSTATE_DEFENCE_STATE命令获取


	public static final int SDK_ALARM_TICKET_STATISTIC         = 0x3193;           // 车票统计信息事件(对应结构体 ALARM_TICKET_STATISTIC)
	public static final int SDK_ALARM_LOGIN_FAILIUR            = 0x3194;           // 登陆失败事件(对应结构体ALARM_LOGIN_FAILIUR_INFO)
	public static final int SDK_ALARM_MODULE_LOST              = 0x3195;           // 扩展模块掉线事件(对应结构体 ALARM_MODULE_LOST_INFO)
	public static final int SDK_ALARM_PSTN_BREAK_LINE          = 0x3196;           // PSTN掉线事件(对应结构体ALARM_PSTN_BREAK_LINE_INFO)
	public static final int SDK_ALARM_ANALOG_PULSE             = 0x3197;           // 模拟量报警事件(瞬时型事件), 特定传感器类型时才触发(对应结构体ALARM_ANALOGPULSE_INFO)
	public static final int SDK_ALARM_MISSION_CONFIRM          = 0x3198;           // 任务确认事件(对应结构体 ALARM_MISSION_CONFIRM_INFO)
	public static final int SDK_ALARM_DEVICE_MSG_NOTIFY        = 0x3199;           // 设备向平台发通知的事件(对应结构体 ALARM_DEVICE_MSG_NOTIFY_INFO)
	public static final int SDK_ALARM_VEHICLE_STANDING_OVER_TIME = 0x319A;         // 停车超时报警(对应结构体 ALARM_VEHICLE_STANDING_OVER_TIME_INFO)
	public static final int SDK_ALARM_ENCLOSURE_ALARM          = 0x319B;           // 电子围栏事件(对应结构体 ALARM_ENCLOSURE_ALARM_INFO)
	public static final int SDK_ALARM_GUARD_DETECT			  = 0x319C;		   // 岗亭检测事件,此事件岗亭有第一个人时上报start事件，岗亭最后一个人离开时上报stop 事件(对应结构体ALARM_GUARD_DETECT_INFO)
	public static final int SDK_ALARM_GUARD_INFO_UPDATE		  = 0x319D;		   // 岗亭信息更新事件，只要岗亭有人员出入就上报(对应结构体ALARM_GUARD_UPDATE_INFO)  
	public static final int SDK_ALARM_NODE_ACTIVE              = 0x319e;           // 节点激活事件(对应结构体ALARM_NODE_ACTIVE_INFO)
	public static final int SDK_ALARM_VIDEO_STATIC             = 0x319F;           // 视频静态检测事件(对应结构体 ALARM_VIDEO_STATIC_INFO)
	public static final int SDK_ALARM_REGISTER_REONLINE        = 0x31a0;           // 主动注册设备重新登陆事件(对应结构体ALARM_REGISTER_REONLINE_INFO)
	public static final int SDK_ALARM_ISCSI_STATUS             = 0x31a1;           // ISCSI告警事件(对应结构体 ALARM_ISCSI_STATUS_INFO)
	public static final int SDK_ALARM_SCADA_DEV_ALARM          = 0x31a2;           // 检测采集设备报警事件(对应结构体 ALARM_SCADA_DEV_INFO)
	public static final int SDK_ALARM_AUXILIARY_DEV_STATE      = 0x31a3;           // 辅助设备状态(对应结构体ALARM_AUXILIARY_DEV_STATE)
	public static final int SDK_ALARM_PARKING_CARD             = 0x31a4;           // 停车刷卡事件(对应结构体ALARM_PARKING_CARD)
	public static final int SDK_ALARM_PROFILE_ALARM_TRANSMIT   = 0x31a5;           // 报警传输事件(对应结构体ALARM_PROFILE_ALARM_TRANSMIT_INFO)
	public static final int SDK_ALARM_VEHICLE_ACC              = 0x31a6;           // 车辆ACC报警事件(对应结构体 ALARM_VEHICLE_ACC_INFO)

	// 事件类型
	public static final int SDK_CONFIG_RESULT_EVENT_EX         = 0x3000;           // 修改配置的返回码；返回结构见DEV_SET_RESULT
	public static final int SDK_REBOOT_EVENT_EX                = 0x3001;           // 设备重启事件；如果未发送重启命令，当前修改的配置不会立即生效
	public static final int SDK_AUTO_TALK_START_EX             = 0x3002;           // 设备主动邀请开始语音对讲
	public static final int SDK_AUTO_TALK_STOP_EX              = 0x3003;           // 设备主动停止语音对讲
	public static final int SDK_CONFIG_CHANGE_EX               = 0x3004;           // 设备配置发生改变
	public static final int SDK_IPSEARCH_EVENT_EX              = 0x3005;           // IP搜索事件, 返回字符串格式如下:DevName::Manufacturer::MAC::IP::Port::DevType::POEPort::SubMask::GateWay&&DevName::Manufacturer::MAC::IP::Port::DevType::POEPort::SubMask::GateWay &&…
	public static final int SDK_AUTO_RECONNECT_FAILD           = 0x3006;           // 自动重连失败事件
	public static final int SDK_REALPLAY_FAILD_EVENT           = 0x3007;           // 监视失败事件,返回结构体DEV_PLAY_RESULT
	public static final int SDK_PLAYBACK_FAILD_EVENT           = 0x3008;           // 回放失败事件,返回结构体DEV_PLAY_RESULT   
	public static final int SDK_IVS_TRAFFIC_REALFLOWINFO       = 0x3009;           // 交通实时流量信息事件ALARM_IVS_TRAFFIC_REALFLOW_INFO
	public static final int SDK_DEVICE_ABORT_EVENT             = 0x300a;           // 客户端被踢出, 对应结构体 DEV_CLIENT_ABORT_INFO
	public static final int SDK_TALK_FAILD_EVENT               = 0x300b;           // 请求语音对讲失败, 对应结构体 DEV_TALK_RESULT
	
	/**
	 * \if ENGLISH_LANG
	 * User name length
	 * \else
	 * 用户名长度
	 * \endif
	 */
	public static final int     SDK_NEW_USER_NAME_LENGTH	 = 128;			  
	/**
	 * \if ENGLISH_LANG
	 * password
	 * \else
	 * 密码
	 * \endif
	 */
	public static final int     SDK_NEW_USER_PSW_LENGTH	 = 128;			  


	/**
	 * \if ENGLISH_LANG
	 * Signal interface name length
	 * \else
	 * 信号接口名称长度
	 * \endif
	 */
	public static final int     SDK_MATRIX_INTERFACE_LEN		= 16;		  
	/**
	 * \if ENGLISH_LANG
	 * Matrix sub card max amount
	 * \else
	 * 矩阵子卡最大数量
	 * \endif
	 */
	public static final int     SDK_MATRIX_MAX_CARDS			= 128;		  
	/**
	 * \if ENGLISH_LANG
	 * The basic value of the PIP split mode
	 * \else
	 * 分割模式画中画的基础值
	 * \endif
	 */
	public static final int     SDK_SPLIT_PIP_BASE			= 1000;	  
	/**
	 * \if ENGLISH_LANG
	 * Max split matrix amount
	 * \else
	 * 最大分割模式数
	 * \endif
	 */
	public static final int     SDK_MAX_SPLIT_MODE_NUM		= 64;		  
	/**
	 * \if ENGLISH_LANG
	 * Matrix max input channel amount
	 * \else
	 * 矩阵最大输入通道数
	 * \endif
	 */
	public static final int     SDK_MATRIX_MAX_CHANNEL_IN	= 1500;	  
	/**
	 * \if ENGLISH_LANG
	 * Matrix max output channel amount
	 * \else
	 * 矩阵最大输出通道数
	 * \endif
	 */
	public static final int     SDK_MATRIX_MAX_CHANNEL_OUT	= 256;		  
	/**
	 * \if ENGLISH_LANG
	 * Device name length
	 * \else
	 * 设备名称长度
	 * \endif
	 */
	public static final int     SDK_DEVICE_NAME_LEN			= 64;		  
	/**
	 * \if ENGLISH_LANG
	 * Max CPU amount
	 * \else
	 * 最大CPU数量
	 * \endif
	 */
	public static final int     SDK_MAX_CPU_NUM				= 16;		  
	/**
	 * \if ENGLISH_LANG
	 * Max fan amount
	 * \else
	 * 最大风扇数量
	 * \endif
	 */
	public static final int     SDK_MAX_FAN_NUM				= 16;		  
	/**
	 * \if ENGLISH_LANG
	 * Max power amount
	 * \else
	 * 最大电源数量
	 * \endif
	 */
	public static final int     SDK_MAX_POWER_NUM			= 16;		 
	
	/**
	 * \if ENGLISH_LANG
	 * Max battery amount
	 * \else
	 * 最大电池数量
	 * \endif
	 */
	public static final int 		SDK_MAX_BATTERY_NUM		= 16;
	
	/**
	 * \if ENGLISH_LANG
	 * Max temperature sensor amount
	 * \else
	 * 最大温度传感器数量
	 * \endif
	 */
	public static final int     SDK_MAX_TEMPERATURE_NUM		= 16;		  
	/**
	 * \if ENGLISH_LANG
	 * ISCSI Name length
	 * \else
	 * ISCSI名称长度
	 * \endif
	 */
	public static final int     SDK_MAX_ISCSI_NAME_LEN		= 128;		  
	/**
	 * \if ENGLISH_LANG
	 * Version info length
	 * \else
	 * 版本信息长度
	 * \endif
	 */
	public static final int     SDK_VERSION_LEN				= 64;		  
	/**
	 * \if ENGLISH_LANG
	 * Storage partition max number
	 * \else
	 * 存储分区最大数量
	 * \endif
	 */
	public static final int     SDK_MAX_STORAGE_PARTITION_NUM = 32;		  
	/**
	 * \if ENGLISH_LANG
	 * Mount length
	 * \else
	 * 挂载点长度
	 * \endif
	 */
	public static final int     SDK_STORAGE_MOUNT_LEN		= 64;		  
	/**
	 * \if ENGLISH_LANG
	 * File system name length
	 * \else
	 * 文件系统名称长度
	 * \endif
	 */
	public static final int     SDK_STORAGE_FILE_SYSTEM_LEN	= 16;		  
	/**
	 * \if ENGLISH_LANG
	 * RAID max members
	 * \else
	 * RAID成员最大数量
	 * \endif
	 */
	public static final int     SDK_MAX_MEMBER_PER_RAID		= 32;		  
	/**
	 * \if ENGLISH_LANG
	 * Device ID max length
	 * \else
	 * 设备ID最大长度
	 * \endif
	 */
	public static final int     SDK_DEV_ID_LEN_EX			= 128;		  
	/**
	 * \if ENGLISH_LANG
	 * Max number of block
	 * \else
	 * 最大区块数量
	 * \endif
	 */
	public static final int     SDK_MAX_BLOCK_NUM			= 32;		  
	/**
	 * \if ENGLISH_LANG
	 * Max number of split window
	 * \else
	 * 最大分割窗口数量
	 * \endif
	 */
	public static final int     SDK_MAX_SPLIT_WINDOW			= 128;		  
	/**
	 * \if ENGLISH_LANG
	 * Length of file type
	 * \else
	 * 文件类型长度
	 * \endif
	 */
	public static final int     SDK_FILE_TYPE_LEN			= 64;		  
	/**
	 * \if ENGLISH_LANG
	 * Length of device ID
	 * \else
	 * 设备ID最大长度
	 * \endif
	 */
	public static final int     SDK_DEV_ID_LEN				= 128;		  
	/**
	 * \if ENGLISH_LANG
	 * Max length of device name  
	 * \else
	 * 设备名称最大长度
	 * \endif
	 */
	public static final int     SDK_DEV_NAME_LEN				= 128;		  
	/**
	 * \if ENGLISH_LANG
	 * Schedule the first dimension size, means days
	 * \else
	 * 时间表第一维大小, 表示天数
	 * \endif
	 */
	public static final int     SDK_TSCHE_DAY_NUM			= 8;		  
	/**
	 * \if ENGLISH_LANG
	 * Schedule the second dimension size, means time
	 * \else
	 * 时间表第二维大小, 表示时段数
	 * \endif
	 */
	public static final int     SDK_TSCHE_SEC_NUM			= 6;		  
	/**
	 * \if ENGLISH_LANG
	 * Event report info including max card number
	 * \else
	 * 事件上报信息包含最大卡片个
	 * \endif
	 */
	public static final int SDK_EVENT_MAX_CARD_NUM   = 16;      
	/**
	 * \if ENGLISH_LANG
	 * Card name length
	 * \else
	 * 卡片名称长度
	 * \endif
	 */
	public static final int SDK_EVENT_CARD_LEN   	= 36;      

	/**
	 * \if ENGLISH_LANG
	 * Subscription all event
	 * \else
	 * 订阅所有事件
	 * \endif
	 */
	public static final int EVENT_IVS_ALL                       = 0x00000001 ;    
	/**
	 * \if ENGLISH_LANG
	 * Cross line event
	 * \else
	 * 警戒线事件
	 * \endif
	 */
	public static final int EVENT_IVS_CROSSLINEDETECTION        = 0x00000002 ; 	  
	/**
	 * \if ENGLISH_LANG
	 * Cross region event
	 * \else
	 * 警戒区事件
	 * \endif
	 */
	public static final int EVENT_IVS_CROSSREGIONDETECTION      = 0x00000003 ;    
	/**
	 * \if ENGLISH_LANG
	 * Past event
	 * \else
	 * 贴条事件
	 * \endif
	 */
	public static final int EVENT_IVS_PASTEDETECTION            = 0x00000004 ;    
	/**
	 * \if ENGLISH_LANG
	 * Left event
	 * \else
	 * 物品遗留事件
	 * \endif
	 */
	public static final int EVENT_IVS_LEFTDETECTION             = 0x00000005 ;    
	/**
	 * \if ENGLISH_LANG
	 * Stay event
	 * \else
	 * 停留事件
	 * \endif
	 */
	public static final int EVENT_IVS_STAYDETECTION             = 0x00000006 ;    
	/**
	 * \if ENGLISH_LANG
	 * Wander event
	 * \else
	 * 徘徊事件
	 * \endif
	 */
	public static final int EVENT_IVS_WANDERDETECTION           = 0x00000007 ;    
	/**
	 * \if ENGLISH_LANG
	 * Reservation event
	 * \else
	 * 物品保全事件
	 * \endif
	 */
	public static final int EVENT_IVS_PRESERVATION              = 0x00000008 ;   
	/**
	 * \if ENGLISH_LANG
	 * Move event
	 * \else
	 * 移动事件
	 * \endif
	 */
	public static final int EVENT_IVS_MOVEDETECTION             = 0x00000009 ;    
	/**
	 * \if ENGLISH_LANG
	 * Tail event
	 * \else
	 * 尾随事件
	 * \endif
	 */
	public static final int EVENT_IVS_TAILDETECTION             = 0x0000000A ;    
	/**
	 * \if ENGLISH_LANG
	 * Rioter event
	 * \else
	 * 聚众事件
	 * \endif
	 */
	public static final int EVENT_IVS_RIOTERDETECTION           = 0x0000000B ;    
	/**
	 * \if ENGLISH_LANG
	 * Fire event
	 * \else
	 * 火警事件
	 * \endif
	 */
	public static final int EVENT_IVS_FIREDETECTION             = 0x0000000C ;    
	/**
	 * \if ENGLISH_LANG
	 * Smoke event
	 * \else
	 * 烟雾报警事件
	 * \endif
	 */
	public static final int EVENT_IVS_SMOKEDETECTION            = 0x0000000D ;    
	/**
	 * \if ENGLISH_LANG
	 * Fight event
	 * \else
	 * 斗殴事件
	 * \endif
	 */
	public static final int EVENT_IVS_FIGHTDETECTION            = 0x0000000E ;    
	/**
	 * \if ENGLISH_LANG
	 * Flow stat event
	 * \else
	 * 流量统计事件
	 * \endif
	 */
	public static final int EVENT_IVS_FLOWSTAT                  = 0x0000000F ;    
	/**
	 * \if ENGLISH_LANG
	 * Number stat event
	 * \else
	 * 数量统计事件
	 * \endif
	 */
	public static final int EVENT_IVS_NUMBERSTAT                = 0x00000010 ;     
	/**
	 * \if ENGLISH_LANG
	 * Camera cover event
	 * \else
	 * 摄像头覆盖事件
	 * \endif
	 */
	public static final int EVENT_IVS_CAMERACOVERDDETECTION     = 0x00000011 ;     
	/**
	 * \if ENGLISH_LANG
	 * Camera move event
	 * \else
	 * 摄像头移动事件
	 * \endif
	 */
	public static final int EVENT_IVS_CAMERAMOVEDDETECTION      = 0x00000012 ;     
	/**
	 * \if ENGLISH_LANG
	 * Video abnormal event
	 * \else
	 * 视频异常事件
	 * \endif
	 */
	public static final int EVENT_IVS_VIDEOABNORMALDETECTION    = 0x00000013 ;       
	/**
	 * \if ENGLISH_LANG
	 * Video bad event
	 * \else
	 * 视频损坏事件
	 * \endif
	 */
	public static final int EVENT_IVS_VIDEOBADDETECTION         = 0x00000014 ;       
	/**
	 * \if ENGLISH_LANG
	 * Traffic control event
	 * \else
	 * 交通管制事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFICCONTROL            = 0x00000015 ;       
	/**
	 * \if ENGLISH_LANG
	 * Traffic accident event
	 * \else
	 * 交通事故事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFICACCIDENT           = 0x00000016 ;       
	/**
	 * \if ENGLISH_LANG
	 * Traffic junction event
	 * \else
	 * 交通路口事件----老规则
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFICJUNCTION           = 0x00000017 ;   
	/**
	 * \if ENGLISH_LANG
	 * Traffic gate event
	 * \else
	 * 交通卡口事件----老规则
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFICGATE               = 0x00000018 ;   
	/**
	 * \if ENGLISH_LANG
	 * Traffic snapshot
	 * \else
	 * 端交通抓拍事件
	 * \endif
	 */
	public static final int EVENT_TRAFFICSNAPSHOT               = 0x00000019 ;       
	/**
	 * \if ENGLISH_LANG
	 * Face detection
	 * \else
	 * 人脸检测事件 
	 * \endif
	 */
	public static final int EVENT_IVS_FACEDETECT                = 0x0000001A ;      
	/**
	 * \if ENGLISH_LANG
	 * Traffic-Jam
	 * \else
	 * 交通拥堵事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFICJAM                = 0x0000001B ;       
	/**
	 * \if ENGLISH_LANG
	 * Traffic-RunRedLight
	 * \else
	 * 交通违章-闯红灯事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_RUNREDLIGHT       = 0x00000100 ;   
	/**
	 * \if ENGLISH_LANG
	 * Traffic-Overline
	 * \else
	 * 交通违章-压车道线事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_OVERLINE          = 0x00000101 ;   
	/**
	 * \if ENGLISH_LANG
	 * Traffic-Retrograde
	 * \else
	 * 交通违章-逆行事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_RETROGRADE        = 0x00000102 ;   
	/**
	 * \if ENGLISH_LANG
	 * Traffic-TurnLeft
	 * \else
	 * 交通违章-违章左转
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_TURNLEFT          = 0x00000103 ;   
	/**
	 * \if ENGLISH_LANG
	 * Traffic-TurnRight
	 * \else
	 * 交通违章-违章右转
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_TURNRIGHT         = 0x00000104 ;   
	/**
	 * \if ENGLISH_LANG
	 * Traffic-Uturn
	 * \else
	 * 交通违章-违章掉头
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_UTURN             = 0x00000105 ;   
	/**
	 * \if ENGLISH_LANG
	 * Traffic-Overspeed
	 * \else
	 * 交通违章-超速
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_OVERSPEED         = 0x00000106 ;      
	/**
	 * \if ENGLISH_LANG
	 * Traffic-Underspeed
	 * \else
	 * 交通违章-低速
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_UNDERSPEED        = 0x00000107 ;      
	/**
	 * \if ENGLISH_LANG
	 * Traffic-Parking
	 * \else
	 * 交通违章-违章停车
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_PARKING           = 0x00000108 ;   
	/**
	 * \if ENGLISH_LANG
	 * Traffic-WrongRoute
	 * \else
	 * 交通违章-不按车道行驶
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_WRONGROUTE        = 0x00000109 ;   
	/**
	 * \if ENGLISH_LANG
	 * Traffic-CrossLane
	 * \else
	 * 交通违章-违章变道
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_CROSSLANE         = 0x0000010A ;   
	/**
	 * \if ENGLISH_LANG
	 * Traffic-OverYellowLine
	 * \else
	 * 交通违章-压黄线 
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_OVERYELLOWLINE    = 0x0000010B ;   
	/**
	 * \if ENGLISH_LANG
	 * Traffic-DrivingOnShoulder   
	 * \else
	 * 交通违章-路肩行驶事件 
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_DRIVINGONSHOULDER = 0x0000010C ;   
	/**
	 * \if ENGLISH_LANG
	 * Traffic-YellowPlateInLane
	 * \else
	 * 交通违章-黄牌车占道事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_YELLOWPLATEINLANE = 0x0000010E ;   
	/**
	 * \if ENGLISH_LANG
	 * Traffic offense-Pedestral has higher priority at the  crosswalk
	 * \else
	 * 交通违章-斑马线行人优先事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_PEDESTRAINPRIORITY = 0x0000010F ;   
	/**
	 * \if ENGLISH_LANG
	 * Cross fence 
	 * \else
	 * 翻越围栏事件
	 * \endif
	 */
	public static final int EVENT_IVS_CROSSFENCEDETECTION       = 0x0000011F ;       
	/**
	 * \if ENGLISH_LANG
	 * ElectroSpark event 
	 * \else
	 * 电火花事件
	 * \endif
	 */
	public static final int EVENT_IVS_ELECTROSPARKDETECTION     = 0X00000110 ;         
	/**
	 * \if ENGLISH_LANG
	 * No passing
	 * \else
	 * 交通违章-禁止通行事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_NOPASSING         = 0x00000111 ;   
	/**
	 * \if ENGLISH_LANG
	 * Abnormal run
	 * \else
	 * 异常奔跑事件
	 * \endif
	 */
	public static final int EVENT_IVS_ABNORMALRUNDETECTION      = 0x00000112 ;       
	/**
	 * \if ENGLISH_LANG
	 * Retrograde
	 * \else
	 * 人员逆行事件
	 * \endif
	 */
	public static final int EVENT_IVS_RETROGRADEDETECTION       = 0x00000113 ;       
	/**
	 * \if ENGLISH_LANG
	 * In region detection
	 * \else
	 * 区域内检测事件
	 * \endif
	 */
	public static final int EVENT_IVS_INREGIONDETECTION         = 0x00000114 ;     
	/**
	 * \if ENGLISH_LANG
	 * Taking away things
	 * \else
	 * 物品搬移事件
	 * \endif
	 */
	public static final int EVENT_IVS_TAKENAWAYDETECTION        = 0x00000115 ;       
	/**
	 * \if ENGLISH_LANG
	 * Parking
	 * \else
	 * 非法停车事件
	 * \endif
	 */
	public static final int EVENT_IVS_PARKINGDETECTION          = 0x00000116 ;       
	/**
	 * \if ENGLISH_LANG
	 * Face recognition
	 * \else
	 * 人脸识别事件
	 * \endif
	 */
	public static final int EVENT_IVS_FACERECOGNITION           = 0x00000117 ;       
	/**
	 * \if ENGLISH_LANG
	 * Manual snap
	 * \else
	 * 交通手动抓拍事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_MANUALSNAP        = 0x00000118 ;   
	/**
	 * \if ENGLISH_LANG
	 * Traffic flow state
	 * \else
	 * 交通流量统计事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_FLOWSTATE         = 0x00000119 ;   
	/**
	 * \if ENGLISH_LANG
	 * Traffic stay
	 * \else
	 * 交通滞留事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_STAY              = 0x0000011A ;       
	/**
	 * \if ENGLISH_LANG
	 * Traffic vehicle route
	 * \else
	 * 有车占道事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_VEHICLEINROUTE    = 0x0000011B ;       
	/**
	 * \if ENGLISH_LANG
	 * Motion detect
	 * \else
	 * 视频移动侦测事件
	 * \endif
	 */
	public static final int EVENT_ALARM_MOTIONDETECT            = 0x0000011C ;   
	/**
	 * \if ENGLISH_LANG
	 * Local alarm
	 * \else
	 * 外部报警事件
	 * \endif
	 */
	public static final int EVENT_ALARM_LOCALALARM              = 0x0000011D ;       
	/**
	 * \if ENGLISH_LANG
	 * Prisoner rise detect
	 * \else
	 * 看守所囚犯起身事件
	 * \endif
	 */
	public static final int EVENT_IVS_PRISONERRISEDETECTION     = 0X0000011E ;   
	/**
	 * \if ENGLISH_LANG
	 * Traffic tollgate
	 * \else
	 * 交通违章-卡口事件----新规则
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_TOLLGATE          = 0X00000120 ;   
	/**
	 * \if ENGLISH_LANG
	 * Density detection of persons
	 * \else
	 * 人员密集度检测
	 * \endif
	 */
	public static final int EVENT_IVS_DENSITYDETECTION          = 0x00000121 ;     
	/**
	 * \if ENGLISH_LANG
	 * Video diagnosis result
	 * \else
	 * 视频诊断结果事件
	 * \endif
	 */
	public static final int EVENT_IVS_VIDEODIAGNOSIS            = 0X00000122 ;   
	/**
	 * \if ENGLISH_LANG
	 * Queue detection
	 * \else
	 * 排队检测报警事件
	 * \endif
	 */
	public static final int EVENT_IVS_QUEUEDETECTION            = 0x00000123 ;   
	/**
	 * \if ENGLISH_LANG
	 * Take up in bus route
	 * \else
	 * 占用公交车道事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_VEHICLEINBUSROUTE = 0x00000124 ;   
	/**
	 * \if ENGLISH_LANG
	 * Illegal astern 
	 * \else
	 * 违章倒车事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_BACKING           = 0x00000125 ;       
	/**
	 * \if ENGLISH_LANG
	 * Audio abnormity
	 * \else
	 * 声音异常检测
	 * \endif
	 */
	public static final int EVENT_IVS_AUDIO_ABNORMALDETECTION   = 0x00000126 ;       
	/**
	 * \if ENGLISH_LANG
	 * Run yellow light
	 * \else
	 * 交通违章-闯黄灯事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_RUNYELLOWLIGHT    = 0x00000127 ;   
	/**
	 * \if ENGLISH_LANG
	 * Climb detection 
	 * \else
	 * 攀高检测事件
	 * \endif
	 */
	public static final int EVENT_IVS_CLIMBDETECTION            = 0x00000128 ;       
	/**
	 * \if ENGLISH_LANG
	 * Leave detection
	 * \else
	 * 离岗检测事件
	 * \endif
	 */
	public static final int EVENT_IVS_LEAVEDETECTION            = 0x00000129 ;       
	/**
	 * \if ENGLISH_LANG
	 * Parking on yellow box
	 * \else
	 * 黄网格线抓拍事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_PARKINGONYELLOWBOX = 0x0000012A ;   
	/**
	 * \if ENGLISH_LANG
	 * Parking space parking
	 * \else
	 * 车位有车事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_PARKINGSPACEPARKING = 0x0000012B ;       
	/**
	 * \if ENGLISH_LANG
	 * Parking space no parking
	 * \else
	 * 车位无车事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_PARKINGSPACENOPARKING = 0x0000012C ;        
	/**
	 * \if ENGLISH_LANG
	 * Passerby
	 * \else
	 * 交通行人事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_PEDESTRAIN        = 0x0000012D ;       
	/**
	 * \if ENGLISH_LANG
	 * Throw
	 * \else
	 * 交通抛洒物品事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_THROW             = 0x0000012E ;   
	/**
	 * \if ENGLISH_LANG
	 * Idle
	 * \else
	 * 交通空闲事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_IDLE              = 0x0000012F ;       
	/**
	 * \if ENGLISH_LANG
	 * Mobile ACC outage alarm event
	 * \else
	 * 车载ACC断电报警事件
	 * \endif
	 */
	public static final int EVENT_ALARM_VEHICLEACC              = 0x00000130 ;   
	/**
	 * \if ENGLISH_LANG
	 * Vehicle side turn alarm event
	 * \else
	 * 车辆侧翻报警事件
	 * \endif
	 */
	public static final int EVENT_ALARM_VEHICLE_TURNOVER        = 0x00000131 ;   
	/**
	 * \if ENGLISH_LANG
	 * Vehicle collision alarm event
	 * \else
	 * 车辆撞车报警事件
	 * \endif
	 */
	public static final int EVENT_ALARM_VEHICLE_COLLISION       = 0x00000132 ;   
	/**
	 * \if ENGLISH_LANG
	 * Mobile camera rotate event
	 * \else
	 * 车载摄像头大角度扭转事件
	 * \endif
	 */
	public static final int EVENT_ALARM_VEHICLE_LARGE_ANGLE     = 0x00000133 ;   
	/**
	 * \if ENGLISH_LANG
	 * Spot cross line event
	 * \else
	 * 车位压线事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_PARKINGSPACEOVERLINE = 0x00000134 ;       
	/**
	 * \if ENGLISH_LANG
	 * Multi scene switch event
	 * \else
	 * 多场景切换事件
	 * \endif
	 */
	public static final int EVENT_IVS_MULTISCENESWITCH          = 0x00000135 ;
	
	/**
	 * \if ENGLISH_LANG
	 * Plate limit event
	 * \else
	 * 受限车牌事件
	 * \endif
	 */
	public static final int EVENT_IVS_TRAFFIC_RESTRICTED_PLATE   =  0X00000136 ;
	
	/**
	 * \if ENGLISH_LANG
	 * Analog alarm channel event(corresponding to DEV_EVENT_ALARM_ANALOGALRM_INFO)
	 * \else
	 * 模拟量报警通道的报警事件(对应DEV_EVENT_ALARM_ANALOGALRM_INFO)
	 * \endif
	 */
	public static final int EVENT_ALARM_ANALOGALARM               =  0x00000150 ;
	
	public static final int DECODER_OUT_SLOTS_MAX_NUM            = 16;
	public static final int DECODER_IN_SLOTS_MAX_NUM             = 16;
	
	/**
	 * \if ENGLISH_LANG
	 * No error 
	 * \else
	 * 没有错误
	 * \endif
	 */
	public static final int NET_NOERROR= 0;			  
	/**
	 * \if ENGLISH_LANG
	 * Unknown error
	 * \else
	 * 未知错误
	 * \endif
	 */
	public static final int NET_ERROR= -1;			  
	/**
	 * \if ENGLISH_LANG
	 * Windows system error
	 * \else
	 * Windows系统出错
	 * \endif
	 */
	public static final int NET_SYSTEM_ERROR= (0x80000000|1);		  
	/**
	 * \if ENGLISH_LANG
	 * Protocol error it may result from network timeout
	 * \else
	 * 网络错误，可能是因为网络超时
	 * \endif
	 */
	public static final int NET_NETWORK_ERROR= (0x80000000|2);		  
	/**
	 * \if ENGLISH_LANG
	 * Device protocol does not match 
	 * \else
	 * 设备协议不匹配
	 * \endif
	 */
	public static final int NET_DEV_VER_NOMATCH= (0x80000000|3);		  
	/**
	 * \if ENGLISH_LANG
	 * Handle is invalid
	 * \else
	 * 句柄无效
	 * \endif
	 */
	public static final int NET_INVALID_HANDLE= (0x80000000|4);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to open channel 
	 * \else
	 * 打开通道失败
	 * \endif
	 */
	public static final int NET_OPEN_CHANNEL_ERROR= (0x80000000|5);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to close channel
	 * \else
	 * 关闭通道失败
	 * \endif
	 */
	public static final int NET_CLOSE_CHANNEL_ERROR= (0x80000000|6);		  
	/**
	 * \if ENGLISH_LANG
	 * User parameter is illegal 
	 * \else
	 * 用户参数不合法
	 * \endif
	 */
	public static final int NET_ILLEGAL_PARAM= (0x80000000|7);		  
	/**
	 * \if ENGLISH_LANG
	 * SDK initialization error
	 * \else
	 * SDK初始化出错
	 * \endif
	 */
	public static final int NET_SDK_INIT_ERROR= (0x80000000|8);		  
	/**
	 * \if ENGLISH_LANG
	 * SDK clear error
	 * \else
	 * SDK清理出错
	 * \endif
	 */
	public static final int NET_SDK_UNINIT_ERROR= (0x80000000|9);		  
	/**
	 * \if ENGLISH_LANG
	 * Error occurs when apply for render resources.
	 * \else
	 * 申请render资源出错
	 * \endif
	 */
	public static final int NET_RENDER_OPEN_ERROR= (0x80000000|10);		  
	/**
	 * \if ENGLISH_LANG
	 * Error occurs when opening the decoder library 
	 * \else
	 * 打开解码库出错
	 * \endif
	 */
	public static final int NET_DEC_OPEN_ERROR= (0x80000000|11);		  
	/**
	 * \if ENGLISH_LANG
	 * Error occurs when closing the decoder library
	 * \else
	 * 关闭解码库出错
	 * \endif
	 */
	public static final int NET_DEC_CLOSE_ERROR= (0x80000000|12);		  
	/**
	 * \if ENGLISH_LANG
	 * The detected channel number is 0 in multiple-channel preview. 
	 * \else
	 * 多画面预览中检测到通道数为0
	 * \endif
	 */
	public static final int NET_MULTIPLAY_NOCHANNEL= (0x80000000|13);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to initialize record library 
	 * \else
	 * 录音库初始化失败
	 * \endif
	 */
	public static final int NET_TALK_INIT_ERROR= (0x80000000|14);		  
	/**
	 * \if ENGLISH_LANG
	 * The record library has not been initialized
	 * \else
	 * 录音库未经初始化
	 * \endif
	 */
	public static final int NET_TALK_NOT_INIT= (0x80000000|15);		  
	/**
	 * \if ENGLISH_LANG
	 * Error occurs when sending out audio data 
	 * \else
	 * 发送音频数据出错
	 * \endif
	 */
	public static final int	NET_TALK_SENDDATA_ERROR= (0x80000000|16);		  
	/**
	 * \if ENGLISH_LANG
	 * The real-time has been protected.
	 * \else
	 * 实时数据已经处于保存状态
	 * \endif
	 */
	public static final int NET_REAL_ALREADY_SAVING= (0x80000000|17);		  
	/**
	 * \if ENGLISH_LANG
	 * The real-time data has not been save.
	 * \else
	 * 未保存实时数据
	 * \endif
	 */
	public static final int NET_NOT_SAVING= (0x80000000|18);		  
	/**
	 * \if ENGLISH_LANG
	 * Error occurs when opening the file.
	 * \else
	 * 打开文件出错
	 * \endif
	 */
	public static final int NET_OPEN_FILE_ERROR= (0x80000000|19);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to enable PTZ to control timer.
	 * \else
	 * 启动云台控制定时器失败
	 * \endif
	 */
	public static final int NET_PTZ_SET_TIMER_ERROR= (0x80000000|20);		  
	/**
	 * \if ENGLISH_LANG
	 * Error occurs when verify returned data.
	 * \else
	 * 对返回数据的校验出错
	 * \endif
	 */
	public static final int NET_RETURN_DATA_ERROR= (0x80000000|21);		  
	/**
	 * \if ENGLISH_LANG
	 * There is no sufficient buffer.
	 * \else
	 * 没有足够的缓存
	 * \endif
	 */
	public static final int NET_INSUFFICIENT_BUFFER= (0x80000000|22);		  
	/**
	 * \if ENGLISH_LANG
	 * The current SDK does not support this fucntion.
	 * \else
	 * 当前SDK未支持该功能
	 * \endif
	 */
	public static final int NET_NOT_SUPPORTED= (0x80000000|23);		  
	/**
	 * \if ENGLISH_LANG
	 * There is no searched result.
	 * \else
	 * 查询不到录象
	 * \endif
	 */
	public static final int NET_NO_RECORD_FOUND= (0x80000000|24);		  
	/**
	 * \if ENGLISH_LANG
	 * You have no operation right.
	 * \else
	 * 无操作权限
	 * \endif
	 */
	public static final int NET_NOT_AUTHORIZED= (0x80000000|25);		  
	/**
	 * \if ENGLISH_LANG
	 * Can not operate right now. 
	 * \else
	 * 暂时无法执行
	 * \endif
	 */
	public static final int NET_NOT_NOW= (0x80000000|26);		  
	/**
	 * \if ENGLISH_LANG
	 * There is no audio talk channel.
	 * \else
	 * 未发现对讲通道
	 * \endif
	 */
	public static final int NET_NO_TALK_CHANNEL= (0x80000000|27);		  
	/**
	 * \if ENGLISH_LANG
	 * There is no audio.
	 * \else
	 * 未发现音频
	 * \endif
	 */
	public static final int NET_NO_AUDIO= (0x80000000|28);		  
	/**
	 * \if ENGLISH_LANG
	 * The network SDK has not been initialized.
	 * \else
	 * 网络SDK未经初始化
	 * \endif
	 */
	public static final int NET_NO_INIT= (0x80000000|29);		  
	/**
	 * \if ENGLISH_LANG
	 * The download completed.
	 * \else
	 * 下载已结束
	 * \endif
	 */
	public static final int NET_DOWNLOAD_END= (0x80000000|30);		  
	/**
	 * \if ENGLISH_LANG
	 * There is no searched result.
	 * \else
	 * 查询结果为空
	 * \endif
	 */
	public static final int NET_EMPTY_LIST= (0x80000000|31);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get system property setup.
	 * \else
	 * 获取系统属性配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_SYSATTR= (0x80000000|32);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get SN.
	 * \else
	 * 获取序列号失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_SERIAL= (0x80000000|33);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get general property.
	 * \else
	 * 获取常规属性失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_GENERAL= (0x80000000|34);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get DSP capacity description.
	 * \else
	 * 获取DSP能力描述失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_DSPCAP= (0x80000000|35);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get network channel setup.
	 * \else
	 * 获取网络配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_NETCFG= (0x80000000|36);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get channel name.
	 * \else
	 * 获取通道名称失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_CHANNAME= (0x80000000|37);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get video property.
	 * \else
	 * 获取视频属性失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_VIDEO= (0x80000000|38);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get record setup
	 * \else
	 * 获取录象配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_RECORD= (0x80000000|39);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get decoder protocol name 
	 * \else
	 * 获取解码器协议名称失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_PRONAME= (0x80000000|40);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get 232 COM function name.
	 * \else
	 * 获取232串口功能名称失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_FUNCNAME= (0x80000000|41);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get decoder property
	 * \else
	 * 获取解码器属性失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_485DECODER= (0x80000000|42);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get 232 COM setup
	 * \else
	 * 获取232串口配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_232COM= (0x80000000|43);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get external alarm input setup
	 * \else
	 * 获取外部报警输入配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_ALARMIN= (0x80000000|44);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get motion detection alarm
	 * \else
	 * 获取动态检测报警失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_ALARMDET= (0x80000000|45);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get device time
	 * \else
	 * 获取设备时间失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_SYSTIME= (0x80000000|46);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get preview parameter
	 * \else
	 * 获取预览参数失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_PREVIEW= (0x80000000|47);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get audio maintenance setup
	 * \else
	 * 获取自动维护配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_AUTOMT= (0x80000000|48);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get video matrix setup
	 * \else
	 * 获取视频矩阵配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_VIDEOMTRX= (0x80000000|49);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get privacy mask zone setup
	 * \else
	 * 获取区域遮挡配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_COVER= (0x80000000|50);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get video watermark setup
	 * \else
	 * 获取图象水印配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_WATERMAKE= (0x80000000|51);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify general property
	 * \else
	 * 修改常规属性失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_GENERAL= (0x80000000|55);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify channel setup
	 * \else
	 * 修改网络配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_NETCFG= (0x80000000|56);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify channel name
	 * \else
	 * 修改通道名称失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_CHANNAME= (0x80000000|57);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify video channel 
	 * \else
	 * 修改视频属性失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_VIDEO= (0x80000000|58);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify record setup 
	 * \else
	 * 端修改录象配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_RECORD= (0x80000000|59);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify decoder property 
	 * \else
	 * 修改解码器属性失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_485DECODER= (0x80000000|60);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify 232 COM setup 
	 * \else
	 * 修改232串口配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_232COM= (0x80000000|61);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify external input alarm setup
	 * \else
	 * 修改外部输入报警配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_ALARMIN= (0x80000000|62);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify motion detection alarm setup 
	 * \else
	 * 修改动态检测报警配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_ALARMDET= (0x80000000|63);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify device time 
	 * \else
	 * 修改设备时间失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_SYSTIME= (0x80000000|64);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify preview parameter
	 * \else
	 * 修改预览参数失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_PREVIEW= (0x80000000|65);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify auto maintenance setup 
	 * \else
	 * 修改自动维护配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_AUTOMT= (0x80000000|66);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify video matrix setup 
	 * \else
	 * 修改视频矩阵配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_VIDEOMTRX= (0x80000000|67);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify privacy mask zone
	 * \else
	 * 修改区域遮挡配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_COVER= (0x80000000|68);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify video watermark setu
	 * \else
	 * 修改图象水印配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_WATERMAKE= (0x80000000|69);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify wireless network information
	 * \else
	 * 修改无线网络信息失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_WLAN= (0x80000000|70);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to select wireless network device
	 * \else
	 * 选择无线网络设备失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_WLANDEV= (0x80000000|71);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify the actively registration parameter setup.
	 * \else
	 * 修改主动注册参数配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_REGISTER= (0x80000000|72);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify camera property
	 * \else
	 * 修改摄像头属性配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_CAMERA= (0x80000000|73);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify IR alarm setup
	 * \else
	 * 修改红外报警配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_INFRARED= (0x80000000|74);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify audio alarm setup
	 * \else
	 * 修改音频报警配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_SOUNDALARM= (0x80000000|75);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to modify storage position setup
	 * \else
	 * 修改存储位置配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_STORAGE= (0x80000000|76);		  
	/**
	 * \if ENGLISH_LANG
	 * The audio encode port has not been successfully initialized.
	 * \else
	 * 音频编码接口没有成功初始化
	 * \endif
	 */
	public static final int NET_AUDIOENCODE_NOTINIT= (0x80000000|77);		  
	/**
	 * \if ENGLISH_LANG
	 * The data are too long.
	 * \else
	 *  数据过长
	 * \endif
	 */
	public static final int NET_DATA_TOOLONGH= (0x80000000|78);		 
	/**
	 * \if ENGLISH_LANG
	 * The device does not support current operation. 
	 * \else
	 * 设备不支持该操作
	 * \endif
	 */
	public static final int NET_UNSUPPORTED= (0x80000000|79);		  
	/**
	 * \if ENGLISH_LANG
	 * Device resources is not sufficient.
	 * \else
	 * 设备资源不足
	 * \endif
	 */
	public static final int NET_DEVICE_BUSY= (0x80000000|80);		  
	/**
	 * \if ENGLISH_LANG
	 * The server has boot up 
	 * \else
	 * 服务器已经启动
	 * \endif
	 */
	public static final int NET_SERVER_STARTED= (0x80000000|81);		  
	/**
	 * \if ENGLISH_LANG
	 * The server has not fully boot up 
	 * \else
	 * 服务器尚未成功启动
	 * \endif
	 */
	public static final int NET_SERVER_STOPPED= (0x80000000|82);		  
	/**
	 * \if ENGLISH_LANG
	 * Input serial number is not correct.
	 * \else
	 * 输入序列号有误
	 * \endif
	 */
	public static final int NET_LISTER_INCORRECT_SERIAL= (0x80000000|83);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get HDD information.
	 * \else
	 * 获取硬盘信息失败
	 * \endif
	 */
	public static final int NET_QUERY_DISKINFO_FAILED= (0x80000000|84);		  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get connect session information.
	 * \else
	 * 获取连接Session信息
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_SESSION= (0x80000000|85);		  
	/**
	 * \if ENGLISH_LANG
	 * The password you typed is incorrect. You have exceeded the maximum number of retries.
	 * \else
	 * 输入密码错误超过限制次数
	 * \endif
	 */
	public static final int NET_USER_FLASEPWD_TRYTIME= (0x80000000|86);		  
	/**
	 * \if ENGLISH_LANG
	 * Password is not correct
	 * \else
	 * 密码不正确
	 * \endif
	 */
	public static final int NET_LOGIN_ERROR_PASSWORD= (0x80000000|100);	  
	/**
	 * \if ENGLISH_LANG
	 * The account does not exist
	 * \else
	 * 帐户不存在
	 * \endif
	 */
	public static final int NET_LOGIN_ERROR_USER= (0x80000000|101);	  
	/**
	 * \if ENGLISH_LANG
	 * Time out for log in returned value.
	 * \else
	 * 等待登录返回超时
	 * \endif
	 */
	public static final int NET_LOGIN_ERROR_TIMEOUT= (0x80000000|102);	  
	/**
	 * \if ENGLISH_LANG
	 * The account has logged in 
	 * \else
	 * 帐号已登录
	 * \endif
	 */
	public static final int NET_LOGIN_ERROR_RELOGGIN= (0x80000000|103);	  
	/**
	 * \if ENGLISH_LANG
	 * The account has been locked
	 * \else
	 *帐号已被锁定
	 * \endif
	 */
	public static final int NET_LOGIN_ERROR_LOCKED= (0x80000000|104);	  
	/**
	 * \if ENGLISH_LANG
	 * The account bas been in the black list
	 * \else
	 * 帐号已被列为黑名单
	 * \endif
	 */
	public static final int NET_LOGIN_ERROR_BLACKLIST= (0x80000000|105);	  
	/**
	 * \if ENGLISH_LANG
	 * Resources are not sufficient. System is busy now.
	 * \else
	 * 资源不足，系统忙
	 * \endif
	 */
	public static final int NET_LOGIN_ERROR_BUSY= (0x80000000|106);	  
	/**
	 * \if ENGLISH_LANG
	 * Time out. Please check network and try again.
	 * \else
	 * 登录设备超时，请检查网络并重试
	 * \endif
	 */
	public static final int NET_LOGIN_ERROR_CONNECT= (0x80000000|107);	  
	/**
	 * \if ENGLISH_LANG
	 * Network connection failed.
	 * \else
	 * 网络连接失败
	 * \endif
	 */
	public static final int NET_LOGIN_ERROR_NETWORK= (0x80000000|108);	  
	/**
	 * \if ENGLISH_LANG
	 * Successfully logged in the device but can not create video channel. Please check network connection.
	 * \else
	 * 登录设备成功，但无法创建视频通道，请检查网络状况
	 * \endif
	 */
	public static final int NET_LOGIN_ERROR_SUBCONNECT= (0x80000000|109);	  
	/**
	 * \if ENGLISH_LANG
	 * Exceed the max connect number
	 * \else
	 * 超过最大连接数
	 * \endif
	 */
	public static final int NET_LOGIN_ERROR_MAXCONNECT= (0x80000000|110);      
	/**
	 * \if ENGLISH_LANG
	 * Protocol 3 support
	 * \else
	 * 只支持3代协议
	 * \endif
	 */
	public static final int NET_LOGIN_ERROR_PROTOCOL3_ONLY= (0x80000000|111);	  
	/**
	 * \if ENGLISH_LANG
	 * There is no USB or USB info error
	 * \else
	 * 未插入U盾或U盾信息错误
	 * \endif
	 */
	public static final int NET_LOGIN_ERROR_UKEY_LOST= (0x80000000|112);	  
	/**
	 * \if ENGLISH_LANG
	 * Client-end IP address has no right to login
	 * \else
	 * 客户端IP地址没有登录权限  
	 * \endif
	 */
	public static final int NET_LOGIN_ERROR_NO_AUTHORIZED= (0x80000000|113);    
	/**
	 * \if ENGLISH_LANG
	 * Error occurs when Render library open audio.
	 * \else
	 * Render库打开音频出错
	 * \endif
	 */
	public static final int NET_RENDER_SOUND_ON_ERROR= (0x80000000|120);	  
	/**
	 * \if ENGLISH_LANG
	 * Error occurs when Render library close audio 
	 * \else
	 * Render库关闭音频出错
	 * \endif
	 */
	public static final int NET_RENDER_SOUND_OFF_ERROR= (0x80000000|121);	  
	/**
	 * \if ENGLISH_LANG
	 * Error occurs when Render library control volume
	 * \else
	 * 端Render库控制音量出错
	 * \endif
	 */
	public static final int NET_RENDER_SET_VOLUME_ERROR= (0x80000000|122);	  
	/**
	 * \if ENGLISH_LANG
	 * Error occurs when Render library set video parameter
	 * \else
	 * Render库设置画面参数出错
	 * \endif
	 */
	public static final int NET_RENDER_ADJUST_ERROR= (0x80000000|123);	  
	/**
	 * \if ENGLISH_LANG
	 * Error occurs when Render library pause play
	 * \else
	 * Render库暂停播放出错
	 * \endif
	 */
	public static final int NET_RENDER_PAUSE_ERROR= (0x80000000|124);	  
	/**
	 * \if ENGLISH_LANG
	 * Render library snapshot error
	 * \else
	 * Render库抓图出错
	 * \endif
	 */
	public static final int NET_RENDER_SNAP_ERROR= (0x80000000|125);	  
	/**
	 * \if ENGLISH_LANG
	 * Render library stepper error
	 * \else
	 * Render库步进出错
	 * \endif
	 */
	public static final int NET_RENDER_STEP_ERROR= (0x80000000|126);	  
	/**
	 * \if ENGLISH_LANG
	 * Error occurs when Render library set frame rate.
	 * \else
	 * Render库设置帧率出错
	 * \endif
	 */
	public static final int NET_RENDER_FRAMERATE_ERROR= (0x80000000|127);	  
	/**
	 * \if ENGLISH_LANG
	 * Error occurs when Render lib setting show region
	 * \else
	 * Render库设置显示区域出错
	 * \endif
	 */
	public static final int NET_RENDER_DISPLAYREGION_ERROR= (0x80000000|128);  
	/**
	 * \if ENGLISH_LANG
	 * Group name has been existed.
	 * \else
	 * 组名已存在
	 * \endif
	 */
	public static final int NET_GROUP_EXIST= (0x80000000|140);	  
	/**
	 * \if ENGLISH_LANG
	 * The group name does not exist. 
	 * \else
	 * 组名不存在
	 * \endif
	 */
	public static final int	NET_GROUP_NOEXIST= (0x80000000|141);	  
	/**
	 * \if ENGLISH_LANG
	 * The group right exceeds the right list!
	 * \else
	 * 组的权限超出权限列表范围
	 * \endif
	 */
	public static final int NET_GROUP_RIGHTOVER= (0x80000000|142);	  
	/**
	 * \if ENGLISH_LANG
	 * The group can not be removed since there is user in it!
	 * \else
	 * 组下有用户，不能删除
	 * \endif
	 */
	public static final int NET_GROUP_HAVEUSER= (0x80000000|143);	  
	/**
	 * \if ENGLISH_LANG
	 * The user has used one of the group right. It can not be removed. 
	 * \else
	 * 组的某个权限被用户使用，不能出除
	 * \endif
	 */
	public static final int NET_GROUP_RIGHTUSE= (0x80000000|144);	  
	/**
	 * \if ENGLISH_LANG
	 * New group name has been existed
	 * \else
	 * 新组名同已有组名重复
	 * \endif
	 */
	public static final int NET_GROUP_SAMENAME= (0x80000000|145);	  
	/**
	 * \if ENGLISH_LANG
	 * The user name has been existed
	 * \else
	 * 用户已存在
	 * \endif
	 */
	public static final int	NET_USER_EXIST= (0x80000000|146);	  
	/**
	 * \if ENGLISH_LANG
	 * The account does not exist.
	 * \else
	 * 用户不存在
	 * \endif
	 */
	public static final int NET_USER_NOEXIST= (0x80000000|147);	  
	/**
	 * \if ENGLISH_LANG
	 * User right exceeds the group right. 
	 * \else
	 * 用户权限超出组权限
	 * \endif
	 */
	public static final int NET_USER_RIGHTOVER= (0x80000000|148);	  
	/**
	 * \if ENGLISH_LANG
	 * Reserved account. It does not allow to be modified.
	 * \else
	 * 保留帐号，不容许修改密码
	 * \endif
	 */
	public static final int NET_USER_PWD= (0x80000000|149);	  
	/**
	 * \if ENGLISH_LANG
	 * password is not correct
	 * \else
	 * 密码不正确
	 * \endif
	 */
	public static final int NET_USER_FLASEPWD= (0x80000000|150);	  
	/**
	 * \if ENGLISH_LANG
	 * Password is invalid
	 * \else
	 * 密码不匹配
	 * \endif
	 */
	public static final int NET_USER_NOMATCHING= (0x80000000|151);	  
	/**
	 * \if ENGLISH_LANG
	 * Account in use
	 * \else
	 *  账号正在使用中
	 * \endif
	 */
	public static final int NET_USER_INUSE= (0x80000000|152);	 
	/**
	 * \if ENGLISH_LANG
	 * Failed to get network card setup.
	 * \else
	 * 获取网卡配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_ETHERNET= (0x80000000|300);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get wireless network information.
	 * \else
	 * 获取无线网络信息失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_WLAN= (0x80000000|301);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get wireless network device.
	 * \else
	 * 获取无线网络设备失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_WLANDEV= (0x80000000|302);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get actively registration parameter.
	 * \else
	 * 获取主动注册参数失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_REGISTER= (0x80000000|303);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get camera property 
	 * \else
	 * 获取摄像头属性失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_CAMERA= (0x80000000|304);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get IR alarm setup
	 * \else
	 * 获取红外报警配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_INFRARED= (0x80000000|305);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get audio alarm setup
	 * \else
	 * 获取音频报警配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_SOUNDALARM= (0x80000000|306);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get storage position 
	 * \else
	 * 获取存储位置配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_STORAGE= (0x80000000|307);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get mail setup.
	 * \else
	 * 获取邮件配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_MAIL= (0x80000000|308);	  
	/**
	 * \if ENGLISH_LANG
	 * Can not set right now. 
	 * \else
	 * 暂时无法设置
	 * \endif
	 */
	public static final int NET_CONFIG_DEVBUSY= (0x80000000|309);	  
	/**
	 * \if ENGLISH_LANG
	 * The configuration setup data are illegal.
	 * \else
	 * 配置数据不合法
	 * \endif
	 */
	public static final int NET_CONFIG_DATAILLEGAL= (0x80000000|310);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get DST setup
	 * \else
	 * 获取夏令时配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_DST= (0x80000000|311);      
	/**
	 * \if ENGLISH_LANG
	 * Failed to set DST 
	 * \else
	 * 设置夏令时配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_DST= (0x80000000|312);      
	/**
	 * \if ENGLISH_LANG
	 * Failed to get video osd setup.
	 * \else
	 * 获取视频OSD叠加配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_VIDEO_OSD= (0x80000000|313);      
	/**
	 * \if ENGLISH_LANG
	 * Failed to set video osd 
	 * \else
	 * 设置视频OSD叠加配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_VIDEO_OSD= (0x80000000|314);      
	/**
	 * \if ENGLISH_LANG
	 * Failed to get CDMA \ GPRS configuration
	 * \else
	 * 获取CDMA、GPRS网络配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_GPRSCDMA= (0x80000000|315);      
	/**
	 * \if ENGLISH_LANG
	 * Failed to set CDMA \ GPRS configuration
	 * \else
	 * 设置CDMA、GPRS网络配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_GPRSCDMA= (0x80000000|316);      
	/**
	 * \if ENGLISH_LANG
	 * Failed to get IP Filter configuration
	 * \else
	 * 获取IP过滤配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_IPFILTER= (0x80000000|317);      
	/**
	 * \if ENGLISH_LANG
	 * Failed to set IP Filter configuration
	 * \else
	 * 设置IP过滤配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_IPFILTER= (0x80000000|318);      
	/**
	 * \if ENGLISH_LANG
	 * Failed to get Talk Encode configuration
	 * \else
	 * 获取语音对讲编码配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_TALKENCODE= (0x80000000|319);      
	/**
	 * \if ENGLISH_LANG
	 * Failed to set Talk Encode configuration
	 * \else
	 * 设置语音对讲编码配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_TALKENCODE= (0x80000000|320);      
	/**
	 * \if ENGLISH_LANG
	 * Failed to get The length of the video package configuration
	 * \else
	 * 获取录像打包长度配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_RECORDLEN= (0x80000000|321);      
	/**
	 * \if ENGLISH_LANG
	 * Failed to set The length of the video package configuration
	 * \else
	 * 设置录像打包长度配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_RECORDLEN= (0x80000000|322);      
	/**
	 * \if ENGLISH_LANG
	 * Not support Network hard disk partitionr
	 * \else
	 * 不支持网络硬盘分区
	 * \endif
	 */
	public static final int	NET_DONT_SUPPORT_SUBAREA= (0x80000000|323);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get the register server information
	 * \else
	 * 获取设备上主动注册服务器信息失败
	 * \endif
	 */
	public static final int	NET_ERROR_GET_AUTOREGSERVER= (0x80000000|324);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to control actively registration
	 * \else
	 * 主动注册重定向注册错误
	 * \endif
	 */
	public static final int	NET_ERROR_CONTROL_AUTOREGISTER= (0x80000000|325);	
	/**
	 * \if ENGLISH_LANG
	 * Failed to disconnect actively registration
	 * \else
	 * 断开主动注册服务器错误
	 * \endif
	 */
	public static final int	NET_ERROR_DISCONNECT_AUTOREGISTER= (0x80000000|326);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get mms configuration
	 * \else
	 * 获取mms配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_MMS= (0x80000000|327);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to set mms configuration
	 * \else
	 * 设置mms配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_MMS= (0x80000000|328);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get SMS configuration
	 * \else
	 * 获取短信激活无线连接配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_SMSACTIVATION= (0x80000000|329);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to set SMS configuration
	 * \else
	 * 设置短信激活无线连接配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_SMSACTIVATION= (0x80000000|330);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get activation of a wireless connection
	 * \else
	 * 获取拨号激活无线连接配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_DIALINACTIVATION= (0x80000000|331);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to set activation of a wireless connection
	 * \else
	 * 设置拨号激活无线连接配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_DIALINACTIVATION= (0x80000000|332);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get the parameter of video output
	 * \else
	 * 查询视频输出参数配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_VIDEOOUT= (0x80000000|333);      
	/**
	 * \if ENGLISH_LANG
	 * Failed to set the configuration of video output
	 * \else
	 * 设置视频输出参数配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_VIDEOOUT= (0x80000000|334);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get osd overlay enabling
	 * \else
	 * 获取osd叠加使能配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_OSDENABLE= (0x80000000|335);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to set OSD overlay enabling
	 * \else
	 * 设置osd叠加使能配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_OSDENABLE= (0x80000000|336);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to set digital input configuration of front encoders
	 * \else
	 * 设置数字通道前端编码接入配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_ENCODERINFO= (0x80000000|337);      
	/**
	 * \if ENGLISH_LANG
	 * Failed to get TV adjust configuration
	 * \else
	 * 获取TV调节配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_TVADJUST= (0x80000000|338);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to set TV adjust configuration
	 * \else
	 * 设置TV调节配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_TVADJUST= (0x80000000|339);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to request to establish a connection
	 * \else
	 * 请求建立连接失败
	 * \endif
	 */
	public static final int NET_ERROR_CONNECT_FAILED= (0x80000000|340);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to request to upload burn files
	 * \else
	 * 请求刻录文件上传失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_BURNFILE= (0x80000000|341);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get capture configuration information
	 * \else
	 * 获取抓包配置信息失败
	 * \endif
	 */
	public static final int NET_ERROR_SNIFFER_GETCFG= (0x80000000|342);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to set capture configuration information
	 * \else
	 * 设置抓包配置信息失败
	 * \endif
	 */
	public static final int NET_ERROR_SNIFFER_SETCFG= (0x80000000|343);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get download restrictions information
	 * \else
	 * 查询下载限制信息失败
	 * \endif
	 */
	public static final int NET_ERROR_DOWNLOADRATE_GETCFG= (0x80000000|344);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to set download restrictions information
	 * \else
	 * 设置下载限制信息失败
	 * \endif
	 */
	public static final int NET_ERROR_DOWNLOADRATE_SETCFG= (0x80000000|345);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to query serial port parameters
	 * \else
	 * 查询串口参数失败
	 * \endif
	 */
	public static final int NET_ERROR_SEARCH_TRANSCOM= (0x80000000|346);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get the preset info
	 * \else
	 * 获取预制点信息错误
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_POINT= (0x80000000|347);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to set the preset info
	 * \else
	 * 设置预制点信息错误
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_POINT= (0x80000000|348);	  
	/**
	 * \if ENGLISH_LANG
	 * SDK log out the device abnormally
	 * \else
	 * SDK没有正常登出设备
	 * \endif
	 */
	public static final int NET_SDK_LOGOUT_ERROR= (0x80000000|349);      
	/**
	 * \if ENGLISH_LANG
	 * Failed to get vehicle configuration
	 * \else
	 * 获取车载配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GET_VEHICLE_CFG= (0x80000000|350);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to set vehicle configuration
	 * \else
	 * 设置车载配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SET_VEHICLE_CFG= (0x80000000|351);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get ATM overlay configuration
	 * \else
	 * 获取atm叠加配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GET_ATM_OVERLAY_CFG= (0x80000000|352);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to set ATM overlay configuration
	 * \else
	 * 设置atm叠加配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SET_ATM_OVERLAY_CFG= (0x80000000|353);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get ATM overlay ability
	 * \else
	 * 获取atm叠加能力失败
	 * \endif
	 */
	public static final int NET_ERROR_GET_ATM_OVERLAY_ABILITY= (0x80000000|354);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get decoder tour configuration
	 * \else
	 * 获取解码器解码轮巡配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GET_DECODER_TOUR_CFG= (0x80000000|355);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to set decoder tour configuration
	 * \else
	 * 设置解码器解码轮巡配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SET_DECODER_TOUR_CFG= (0x80000000|356);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to control decoder tour
	 * \else
	 * 控制解码器解码轮巡失败
	 * \endif
	 */
	public static final int NET_ERROR_CTRL_DECODER_TOUR= (0x80000000|357);	  
	/**
	 * \if ENGLISH_LANG
	 * Beyond the device supports for the largest number of user groups
	 * \else
	 * 超出设备支持最大用户组数目
	 * \endif
	 */
	public static final int NET_GROUP_OVERSUPPORTNUM= (0x80000000|358);	  
	/**
	 * \if ENGLISH_LANG
	 * Beyond the device supports for the largest number of users 
	 * \else
	 * 超出设备支持最大用户数目
	 * \endif
	 */
	public static final int NET_USER_OVERSUPPORTNUM= (0x80000000|359);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get SIP configuration
	 * \else
	 * 获取SIP配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GET_SIP_CFG= (0x80000000|368);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to set SIP configuration
	 * \else
	 * 设置SIP配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SET_SIP_CFG= (0x80000000|369);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get SIP capability
	 * \else
	 * 获取SIP能力失败
	 * \endif
	 */
	public static final int NET_ERROR_GET_SIP_ABILITY= (0x80000000|370);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get "WIFI ap' configuration 
	 * \else
	 * 获取WIFI ap配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GET_WIFI_AP_CFG= (0x80000000|371);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to set "WIFI ap" configuration  
	 * \else
	 * 设置WIFI ap配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SET_WIFI_AP_CFG= (0x80000000|372);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get decode policy 
	 * \else
	 * 获取解码策略配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GET_DECODE_POLICY= (0x80000000|373);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to set decode policy 
	 * \else
	 * 设置解码策略配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SET_DECODE_POLICY= (0x80000000|374);	  
	/**
	 * \if ENGLISH_LANG
	 * Refuse talk
	 * \else
	 * 拒绝对讲
	 * \endif
	 */
	public static final int NET_ERROR_TALK_REJECT= (0x80000000|375);	  
	/**
	 * \if ENGLISH_LANG
	 * Talk has opened by other client
	 * \else
	 * 对讲被其他客户端打开
	 * \endif
	 */
	public static final int NET_ERROR_TALK_OPENED= (0x80000000|376);	  
	/**
	 * \if ENGLISH_LANG
	 * Resource conflict
	 * \else
	 * 资源冲突
	 * \endif
	 */
	public static final int NET_ERROR_TALK_RESOURCE_CONFLICIT= (0x80000000|377);	  
	/**
	 * \if ENGLISH_LANG
	 * Unsupported encode type
	 * \else
	 * 不支持的语音编码格式
	 * \endif
	 */
	public static final int NET_ERROR_TALK_UNSUPPORTED_ENCODE= (0x80000000|378);	  
	/**
	 * \if ENGLISH_LANG
	 * No right
	 * \else
	 * 无权限
	 * \endif
	 */
	public static final int NET_ERROR_TALK_RIGHTLESS= (0x80000000|379);	  
	/**
	 * \if ENGLISH_LANG
	 * Request failed
	 * \else
	 * 请求对讲失败
	 * \endif
	 */
	public static final int NET_ERROR_TALK_FAILED= (0x80000000|380);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to get device relative config
	 * \else
	 * 获取机器相关配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GET_MACHINE_CFG= (0x80000000|381);	  
	/**
	 * \if ENGLISH_LANG
	 * Failed to set device relative config
	 * \else
	 * 设置机器相关配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SET_MACHINE_CFG= (0x80000000|382);	  
	/**
	 * \if ENGLISH_LANG
	 * Get data failed
	 * \else
	 * 设备无法获取当前请求数据
	 * \endif
	 */
	public static final int NET_ERROR_GET_DATA_FAILED= (0x80000000|383);	  
	/**
	 * \if ENGLISH_LANG
	 * MAC validate failed
	 * \else
	 * MAC地址验证失败 
	 * \endif
	 */
	public static final int NET_ERROR_MAC_VALIDATE_FAILED= (0x80000000|384);      
	/**
	 * \if ENGLISH_LANG
	 * Failed to get server instance 
	 * \else
	 * 获取服务器实例失败
	 * \endif
	 */
	public static final int NET_ERROR_GET_INSTANCE= (0x80000000|385);      
	/**
	 * \if ENGLISH_LANG
	 * Generated json string is error
	 * \else
	 * 生成的jason字符串错误
	 * \endif
	 */
	public static final int NET_ERROR_JSON_REQUEST= (0x80000000|386);      
	/**
	 * \if ENGLISH_LANG
	 * The responding json string is error
	 * \else
	 * 响应的jason字符串错误
	 * \endif
	 */
	public static final int NET_ERROR_JSON_RESPONSE= (0x80000000|387);      
	/**
	 * \if ENGLISH_LANG
	 * The protocol version is lower than current version
	 * \else
	 * 协议版本低于当前使用的版本
	 * \endif
	 */
	public static final int NET_ERROR_VERSION_HIGHER= (0x80000000|388);      
	/**
	 * \if ENGLISH_LANG
	 * Hotspare disk operation failed. The capacity is low
	 * \else
	 * 热备操作失败, 容量不足
	 * \endif
	 */
	public static final int NET_SPARE_NO_CAPACITY= (0x80000000|389);	  
	/**
	 * \if ENGLISH_LANG
	 * Display source is used by other output
	 * \else
	 * 显示源被其他输出占用
	 * \endif
	 */
	public static final int NET_ERROR_SOURCE_IN_USE= (0x80000000|390);	  
	/**
	 * \if ENGLISH_LANG
	 * Advanced users grab low-level user resource
	 * \else
	 * 高级用户抢占低级用户资源
	 * \endif
	 */
	public static final int NET_ERROR_REAVE= (0x80000000|391);      
	/**
	 * \if ENGLISH_LANG
	 * Net forbid
	 * \else
	 * 禁止入网 
	 * \endif
	 */
	public static final int NET_ERROR_NETFORBID= (0x80000000|392);      
	/**
	 * \if ENGLISH_LANG
	 * Get MAC filter configuration error
	 * \else
	 * 获取MAC过滤配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_MACFILTER= (0x80000000|393);      
	/**
	 * \if ENGLISH_LANG
	 * Set MAC filter configuration error
	 * \else
	 * 设置MAC过滤配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_MACFILTER= (0x80000000|394);      
	/**
	 * \if ENGLISH_LANG
	 * Get IP/MAC filter configuration error
	 * \else
	 *  获取IP/MAC过滤配置失败
	 * \endif
	 */
	public static final int NET_ERROR_GETCFG_IPMACFILTER= (0x80000000|395);     
	/**
	 * \if ENGLISH_LANG
	 * Set IP/MAC filter configuration error
	 * \else
	 * 设置IP/MAC过滤配置失败
	 * \endif
	 */
	public static final int NET_ERROR_SETCFG_IPMACFILTER= (0x80000000|396);      
	/**
	 * \if ENGLISH_LANG
	 * Operation over time 
	 * \else
	 * 当前操作超时 
	 * \endif
	 */
	public static final int NET_ERROR_OPERATION_OVERTIME= (0x80000000|397);      
	/**
	 * \if ENGLISH_LANG
	 * Senior validation failure
	 * \else
	 * 高级校验失败 
	 * \endif
	 */
	public static final int NET_ERROR_SENIOR_VALIDATE_FAILED= (0x80000000|398);      
	/**
	 * \if ENGLISH_LANG
	 * Device ID is not exist
	 * \else
	 * 设备ID不存在
	 * \endif
	 */
	public static final int NET_ERROR_DEVICE_ID_NOT_EXIST= (0x80000000|399);	  
	/**
	 * \if ENGLISH_LANG
	 * Unsupport operation
	 * \else
	 * 不支持当前操作
	 * \endif
	 */
	public static final int NET_ERROR_UNSUPPORTED= (0x80000000|400);      
	/**
	 * \if ENGLISH_LANG
	 * Proxy dll load error
	 * \else
	 * 代理库加载失败
	 * \endif
	 */
	public static final int NET_ERROR_PROXY_DLLLOAD= (0x80000000|401);	  
	/**
	 * \if ENGLISH_LANG
	 * Proxy user parameter is not legal
	 * \else
	 * 代理用户参数不合法
	 * \endif
	 */
	public static final int NET_ERROR_PROXY_ILLEGAL_PARAM= (0x80000000|402);	  
	/**
	 * \if ENGLISH_LANG
	 * Handle invalid
	 * \else
	 * 代理句柄无效
	 * \endif
	 */
	public static final int NET_ERROR_PROXY_INVALID_HANDLE= (0x80000000|403);	  
	/**
	 * \if ENGLISH_LANG
	 * Login device error
	 * \else
	 * 代理登入前端设备失败
	 * \endif
	 */
	public static final int NET_ERROR_PROXY_LOGIN_DEVICE_ERROR= (0x80000000|404);	  
	/**
	 * \if ENGLISH_LANG
	 * Start proxy server error
	 * \else
	 * 启动代理服务失败
	 * \endif
	 */
	public static final int NET_ERROR_PROXY_START_SERVER_ERROR= (0x80000000|405);	  
	/**
	 * \if ENGLISH_LANG
	 * Request speak failed
	 * \else
	 * 请求喊话失败
	 * \endif
	 */
	public static final int NET_ERROR_SPEAK_FAILED= (0x80000000|406);	  
	/**
	 * \if ENGLISH_LANG
	 * Unsupport F6
	 * \else
	 * 设备不支持此F6接口调用
	 * \endif
	 */
	public static final int NET_ERROR_NOT_SUPPORT_F6= (0x80000000|407);      
	/**
	 * \if ENGLISH_LANG
	 * Disk not ready
	 * \else
	 * 光盘未就绪
	 * \endif
	 */
	public static final int NET_ERROR_CD_UNREADY= (0x80000000|408);	  
	/**
	 * \if ENGLISH_LANG
	 * Directory inexists
	 * \else
	 * 目录不存在
	 * \endif
	 */
	public static final int NET_ERROR_DIR_NOT_EXIST= (0x80000000|409);	  
	/**
	 * \if ENGLISH_LANG
	 * Device does not support split mode
	 * \else
	 * 设备不支持的分割模式
	 * \endif
	 */
	public static final int NET_ERROR_UNSUPPORTED_SPLIT_MODE= (0x80000000|410);	  
	/**
	 * \if ENGLISH_LANG
	 * Open window parameter invalid
	 * \else
	 * 开窗参数不合法
	 * \endif
	 */
	public static final int NET_ERROR_OPEN_WND_PARAM= (0x80000000|411);	  
	/**
	 * \if ENGLISH_LANG
	 * Open window quantity over limit
	 * \else
	 * 开窗数量超过限制
	 * \endif
	 */
	public static final int NET_ERROR_LIMITED_WND_COUNT= (0x80000000|412);	  
	/**
	 * \if ENGLISH_LANG
	 * Request command and current mode not matched
	 * \else
	 * 请求命令与当前模式不匹配
	 * \endif
	 */
	public static final int NET_ERROR_UNMATCHED_REQUEST= (0x80000000|413);
	
	/**
	 * \if ENGLISH_LANG
	 * Render base enable HD image internal adjustment strategy error
	 * \else
	 * Render库启用高清图像内部调整策略出错
	 * \endif
	 */
	public static final int NET_RENDER_ENABLELARGEPICADJUSTMENT_ERROR = (0x80000000|414);
	
	/**
	 * \if ENGLISH_LANG
	 * Device fasiled to upgrade
	 * \else
	 * 设备升级失败
	 * \endif
	 */
	public static final int NET_ERROR_UPGRADE_FAILED                = (0x80000000|415);
	
	/**
	 * \if ENGLISH_LANG
	 * Target device not found
	 * \else
	 * 找不到目标设备
	 * \endif
	 */
	public static final int NET_ERROR_NO_TARGET_DEVICE              = (0x80000000|416);
	
	/**
	 * \if ENGLISH_LANG
	 * Target device not found
	 * \else
	 * 找不到目标设备
	 * \endif
	 */
	public static final int NET_ERROR_NO_VERIFY_DEVICE              = (0x80000000|417);
	
	/**
	 * \if ENGLISH_LANG
	 * No cascading right
	 * \else
	 * 无级联权限
	 * \endif
	 */
	public static final int NET_ERROR_CASCADE_RIGHTLESS             = (0x80000000|418);
	
	/**
	 * \if ENGLISH_LANG
	 * Low priority
	 * \else
	 * 低优先级
	 * \endif
	 */
	public static final int NET_ERROR_LOW_PRIORITY                  = (0x80000000|419);
	
	/**
	 * \if ENGLISH_LANG
	 * Remote device request time out
	 * \else
	 * 远程设备请求超时
	 * \endif
	 */
	public static final int NET_ERROR_REMOTE_REQUEST_TIMEOUT        = (0x80000000|420);
	
	/**
	 * \if ENGLISH_LANG
	 * Input source over max channel limit
	 * \else
	 * 输入源超出最大路数限制
	 * \endif
	 */
	public static final int NET_ERROR_LIMITED_INPUT_SOURCE          = (0x80000000|421);
	
	/**
	 * \if ENGLISH_LANG
	 * Failed to access folder
	 * \else
	 * 访问文件失败
	 * \endif
	 */
	public static final int NET_ERROR_VISITE_FILE                   = (0x80000000|510);
	
	/**
	 * \if ENGLISH_LANG
	 * Device is busy
	 * \else
	 * 设备忙
	 * \endif
	 */
	public static final int NET_ERROR_DEVICE_STATUS_BUSY            = (0x80000000|511);
	
	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 修改密码无权限
	 * \endif
	 */
	public static final int NET_USER_PWD_NOT_AUTHORIZED             = (0x80000000|512);
	
	/**
	 * \if ENGLISH_LANG
	 * 
	 * \else
	 * 密码强度不够
	 * \endif
	 */
	public static final int NET_USER_PWD_NOT_STRONG                 = (0x80000000|513);
	
	/**
	 * \if ENGLISH_LANG
	 * the number of tour combination
	 * \else
	 * 轮巡组合个数
	 * \endif
	 */
	public static final int  DEC_COMBIN_NUM 	= 32;					  
	/**
	 * \if ENGLISH_LANG
	 * length of name 
	 * \else
	 * 名称长度
	 * \endif
	 */
	public static final int  NAME_MAX_LEN  = 16;
	

	public static final int MAX_ALARM_DECODER_NUM = 16;
	
	public static final int SDK_MAX_RAID_NUM = 16;
	
	public static final int SDK_MAX_USER_DEFINE_INFO	= 1024;
	
	public static final int ALARM_MAX_NAME = 64;
	
	// defined in c++ configsdk.h
	public static final int  MAX_CHANNEL_COUNT=16;
	/**
	 * \if ENGLISH_LANG
	 * Max channel number 256
	 * \else
	 * 最大通道数256
	 * \endif
	 */
	public static final int  MAX_VIDEO_CHANNEL_NUM=256;					  
	/**
	 * \if ENGLISH_LANG
	 * Max channel name length
	 * \else
	 * 最大通道名称长度
	 * \endif
	 */
	public static final int  MAX_CHANNELNAME_LEN=64;					  
	/**
	 * \if ENGLISH_LANG
	 * Max bit stream quantity
	 * \else
	 * 最大码流个数
	 * \endif
	 */
	public static final int  MAX_VIDEOSTREAM_NUM=3;					  
	/**
	 * \if ENGLISH_LANG
	 * Max masked area quantity
	 * \else
	 * 最大遮挡区域个数
	 * \endif
	 */
	public static final int  MAX_VIDEO_COVER_NUM=16;					  
	/**
	 * \if ENGLISH_LANG
	 * Day in a week
	 * \else
	 * 一周的天数
	 * \endif
	 */
	public static final int  WEEK_DAY_NUM=7;					  
	/**
	 * \if ENGLISH_LANG
	 * Record period quantity
	 * \else
	 * 录像时间段个数
	 * \endif
	 */
	public static final int  MAX_REC_TSECT=6;					  
	/**
	 * \if ENGLISH_LANG
	 * Record time extension quantity
	 * \else
	 * 录像时间段扩展个数
	 * \endif
	 */
	public static final int  MAX_REC_TSECT_EX= 10;					  
	/**
	 * \if ENGLISH_LANG
	 * Number watermark data max langth
	 * \else
	 * 数字水印数据最大长度
	 * \endif
	 */
	public static final int  MAX_WATERMARK_LEN= 4096;				  
	/**
	 * \if ENGLISH_LANG
	 * Motion detect rows
	 * \else
	 * 动态检测区域的行数
	 * \endif
	 */
	public static final int  MAX_MOTION_ROW= 32;					  
	/**
	 * \if ENGLISH_LANG
	 * Motion detect columns
	 * \else
	 * 动态检测区域的列数
	 * \endif
	 */
	public static final int  MAX_MOTION_COL= 32;					  
	/**
	 * \if ENGLISH_LANG
	 * Max supported resolution quantity
	 * \else
	 * 最大支持的分辨率个数
	 * \endif
	 */
	public static final int  MAX_IMAGESIZE_NUM= 256;					  
	/**
	 * \if ENGLISH_LANG
	 * Max supported frame quantity
	 * \else
	 * 最大支持的帧率个数
	 * \endif
	 */
	public static final int  MAX_FPS_NUM= 1024;				  
	/**
	 * \if ENGLISH_LANG
	 * Max supported quality quantity
	 * \else
	 * 最大支持的画质个数
	 * \endif
	 */
	public static final int  MAX_QUALITY_NUM= 32;		
	
	public static final int  MAX_QUALITY_REGION_NUM = 8;
	/**
	 * \if ENGLISH_LANG
	 * Max address length
	 * \else
	 * 最大的地址长度
	 * \endif
	 */
	public static final int  MAX_ADDRESS_LEN= 256;					  
	/**
	 * \if ENGLISH_LANG
	 * Max username length
	 * \else
	 * 最大用户名长度
	 * \endif
	 */
	public static final int  MAX_USERNAME_LEN= 64;					  
	/**
	 * \if ENGLISH_LANG
	 * Max password length
	 * \else
	 * 最大密码长度
	 * \endif
	 */
	public static final int  MAX_PASSWORD_LEN= 64;					  
	/**
	 * \if ENGLISH_LANG
	 * Folder name string length
	 * \else
	 * 文件夹名字字符串长度
	 * \endif
	 */
	public static final int  MAX_DIRECTORY_LEN= 256;					  
	/**
	 * \if ENGLISH_LANG
	 * Net storage period quantity
	 * \else
	 * 网络存储时间段个数
	 * \endif
	 */
	public static final int  MAX_NAS_TIME_SECTION= 2;					  
	/**
	 * \if ENGLISH_LANG
	 * General name string length
	 * \else
	 * 通用名字字符串长度
	 * \endif
	 */
	public static final int  MAX_NAME_LEN= 128;					  
	/**
	 * \if ENGLISH_LANG
	 * Decoder protocol list limit
	 * \else
	 * 解码器协议列表个数上限
	 * \endif
	 */
	public static final int  MAX_DECPRO_LIST_SIZE= 100;					  
	/**
	 * \if ENGLISH_LANG
	 * Video analysis device supported scene type limit
	 * \else
	 * 视频分析设备支持的场景类型列表个数上限
	 * \endif
	 */
	public static final int  MAX_SCENE_LIST_SIZE= 32;					  
	/**
	 * \if ENGLISH_LANG
	 * Video analysis device supported detection object type list limit
	 * \else
	 * 视频分析设备支持的检测物体类型列表个数上限
	 * \endif
	 */
	public static final int  MAX_OBJECT_LIST_SIZE= 16;					  
	/**
	 * \if ENGLISH_LANG
	 * Video analysis device supported rule list quantity limit
	 * \else
	 * 视频分析设备支持的规则列表个数上限
	 * \endif
	 */
	public static final int  MAX_RULE_LIST_SIZE= 128;					  
	/**
	 * \if ENGLISH_LANG
	 * Video analysis device max detection module number
	 * \else
	 * 视频分析设备最大检测模块个数
	 * \endif
	 */
	public static final int  MAX_ANALYSE_MODULE_NUM= 16;					  
	/**
	 * \if ENGLISH_LANG
	 * Video analysis device max rule number
	 * \else
	 *  视频分析设备最大规则个数
	 * \endif
	 */
	public static final int  MAX_ANALYSE_RULE_NUM= 32;					 
	/**
	 * \if ENGLISH_LANG
	 * Video analysis device area top limit
	 * \else
	 * 视频分析设备区域顶点个数上限
	 * \endif
	 */
	public static final int  MAX_POLYGON_NUM= 20;					  
	/**
	 * \if ENGLISH_LANG
	 * Video analysis device broken line top limit
	 * \else
	 * 视频分析设备折线顶点个数上限
	 * \endif
	 */
	public static final int  MAX_POLYLINE_NUM= 20;					  
	/**
	 * \if ENGLISH_LANG
	 * Video analysis device vehicle size quantity limit
	 * \else
	 * 视频分析设备车辆大小个数上限
	 * \endif
	 */
	public static final int  MAX_VEHICLE_SIZE_LIST= 4;					  
	/**
	 * \if ENGLISH_LANG
	 * Video analysis device vehicle type quantity limit
	 * \else
	 * 视频分析设备车辆类型个数上限
	 * \endif
	 */
	public static final int  MAX_VEHICLE_TYPE_LIST= 4;					  
	/**
	 * \if ENGLISH_LANG
	 * Video analysis device plate type quantity limit
	 * \else
	 * 视频分析设备车牌类型个数上限
	 * \endif
	 */
	public static final int  MAX_PLATE_TYPE_LIST= 32;					  
	/**
	 * \if ENGLISH_LANG
	 * Video analysis device each channel corresponding lane limit
	 * \else
	 * 视频分析设备每个通道对应车道数上限
	 * \endif
	 */
	public static final int  MAX_LANE_NUM= 8;                     
	/**
	 * \if ENGLISH_LANG
	 * Video analysis device each channel corresponding rule limit
	 * \else
	 * 视频分析设备每个通道对应的标尺数上限
	 * \endif
	 */
	public static final int  MAX_STAFF_NUM= 20;                    
	/**
	 * \if ENGLISH_LANG
	 * Video analysis device mark area limit
	 * \else
	 * 视频分析设备标定区域的上限
	 * \endif
	 */
	public static final int  MAX_CALIBRATEAREA_NUM= 20;					  
	/**
	 * \if ENGLISH_LANG
	 * Intelligent analysis detection area need to exclude area quantity limit
	 * \else
	 * 智能分析检测区域中需要排除的区域个数上限
	 * \endif
	 */
	public static final int  MAX_EXCLUDEREGION_NUM= 10;                    
	/**
	 * \if ENGLISH_LANG
	 * Intelligent analysis calibration frame limit
	 * \else
	 *  智能分析校准框个数上限
	 * \endif
	 */
	public static final int  MAX_CALIBRATEBOX_NUM= 10;                   
	/**
	 * \if ENGLISH_LANG
	 * Intelligent analysis special detection area limit
	 * \else
	 * 智能分析特殊检测区域上限
	 * \endif
	 */
	public static final int  MAX_SPECIALDETECT_NUM= 10;                    
	/**
	 * \if ENGLISH_LANG
	 * Video analysis device supported face recognition type list limit
	 * \else
	 * 视频分析设备支持的人脸检测类型列表个数上限
	 * \endif
	 */
	public static final int  MAX_HUMANFACE_LIST_SIZE= 8;					  
	/**
	 * \if ENGLISH_LANG
	 * Server type limit
	 * \else
	 * 服务类型上限
	 * \endif
	 */
	public static final int  MAX_SEVER_NUM= 16;                    
	/**
	 * \if ENGLISH_LANG
	 * Server name string size
	 * \else
	 * 服务名称字符串大小
	 * \endif
	 */
	public static final int  MAX_SERVER_NAME_LEN= 16;                    
	/**
	 * \if ENGLISH_LANG
	 * Power quantity limit
	 * \else
	 * 电源个数上限
	 * \endif
	 */
	public static final int  MAX_POWER_NUM= 8;                     
	/**
	 * \if ENGLISH_LANG
	 * Fan quantity limit
	 * \else
	 * 风扇个数上限
	 * \endif
	 */
	public static final int  MAX_FUN_NUM= 8;                     
	/**
	 * \if ENGLISH_LANG
	 * cpu quantity limit
	 * \else
	 * cpu个数上限
	 * \endif
	 */
	public static final int  MAX_CPU_NUM= 8;                     
	/**
	 * \if ENGLISH_LANG
	 * HDD limit
	 * \else
	 * 硬盘上限
	 * \endif
	 */
	public static final int  MAX_HARDDISK_NUM= 32;                    
	/**
	 * \if ENGLISH_LANG
	 * Max storage cabinet limit
	 * \else
	 * 最大存储柜上限
	 * \endif
	 */
	public static final int  MAX_TANK_NUM= 16;                    
	/**
	 * \if ENGLISH_LANG
	 * Max channel limit
	 * \else
	 * 最大通道数上限
	 * \endif
	 */
	public static final int  MAX_CHAN_NUM= 256;                   
	/**
	 * \if ENGLISH_LANG
	 * Max disk array limit
	 * \else
	 * 最大磁盘阵列上限
	 * \endif
	 */
	public static final int  MAX_RAID_NUM= 16;                    
	/**
	 * \if ENGLISH_LANG
	 * Max device limit
	 * \else
	 * 最大设备上限
	 * \endif
	 */
	public static final int  MAX_DEV_NUM= 16;                    
	/**
	 * \if ENGLISH_LANG
	 * Max storage pool limit
	 * \else
	 * 最大存储池上限
	 * \endif
	 */
	public static final int  MAX_STORAGEPOOL_NUM= 16;                    
	/**
	 * \if ENGLISH_LANG
	 * Max storage position limit
	 * \else
	 * 最大存储位置上限
	 * \endif
	 */
	public static final int  MAX_STRORAGEPOS_NUM= 16;                    
	/**
	 * \if ENGLISH_LANG
	 * Front device limit
	 * \else
	 * 前端设备上限
	 * \endif
	 */
	public static final int	 MAX_VIDEODEV_NUM= 256;                   
	/**
	 * \if ENGLISH_LANG
	 * Max remote device name length
	 * \else
	 * 最大远程设备名字长度
	 * \endif
	 */
	public static final int  MAX_REMOTEDEVICENAME_LEN= 32;					  
	/**
	 * \if ENGLISH_LANG
	 * Max remote device quantity
	 * \else
	 * 最大远程设备数量
	 * \endif
	 */
	public static final int	 MAX_REMOTE_DEV_NUM= 64;                   
	/**
	 * \if ENGLISH_LANG
	 * Plate string suggested quantity limit
	 * \else
	 * 车牌字符暗示个数上限
	 * \endif
	 */
	public static final int  MAX_PLATEHINT_NUM= 8;                     
	/**
	 * \if ENGLISH_LANG
	 * Traffic light quantity limit
	 * \else
	 * 交通灯个数上限
	 * \endif
	 */
	public static final int  MAX_LIGHT_NUM= 8;                     
	/**
	 * \if ENGLISH_LANG
	 * Traffic light group limit
	 * \else
	 * 交通灯组个数上限
	 * \endif
	 */
	public static final int  MAX_LIGHTGROUP_NUM= 8;                     
	/**
	 * \if ENGLISH_LANG
	 * Traffic light type limit
	 * \else
	 * 交通灯类型上限
	 * \endif
	 */
	public static final int  MAX_LIGHT_TYPE= 8;                     
	/**
	 * \if ENGLISH_LANG
	 * Traffic light direction limit
	 * \else
	 * 交通灯指示方向数上限
	 * \endif
	 */
	public static final int  MAX_LIGHT_DIRECTION= 8;                     
	/**
	 * \if ENGLISH_LANG
	 * Traffic intersection rule trigger mode limit
	 * \else
	 * 交通路口规则触发模式上限
	 * \endif
	 */
	public static final int  MAX_TRIGGERMODE_NUM= 32;                    
	/**
	 * \if ENGLISH_LANG
	 * ITC violation code length limit
	 * \else
	 * 智能交通违章代码长度上限
	 * \endif
	 */
	public static final int  MAX_VIOLATIONCODE= 16;                    
	/**
	 * \if ENGLISH_LANG
	 * ITC vehicle detector config limit
	 * \else
	 * 智能交通车检器配置上限
	 * \endif
	 */
	public static final int  MAX_DETECTOR= 6;                     
	/**
	 * \if ENGLISH_LANG
	 * ITC vehicle detector coil config limit
	 * \else
	 * 智能交通车检器线圈配置上限
	 * \endif
	 */
	public static final int  MAX_COILCONFIG= 3;                     
	/**
	 * \if ENGLISH_LANG
	 * TrafficSnapshot ITC device address
	 * \else
	 * TrafficSnapshot智能交通设备地址
	 * \endif
	 */
	public static final int  MAX_DEVICE_ADDRESS= 256;                   
	/**
	 * \if ENGLISH_LANG
	 * DepartmentITC device organization
	 * \else
	 * Department智能交通设备所属单位
	 * \endif
	 */
	public static final int  MAX_DEPARTMENT= 256;                   
	/**
	 * \if ENGLISH_LANG
	 * Road no. has 32 characters of number and letter. 
	 * \else
	 * 道路编号	由32个数字和字母构成
	 * \endif
	 */
	public static final int  MAX_ROADWAYNO= 128;                   
	/**
	 * \if ENGLISH_LANG
	 * ITC violation code length limit
	 * \else
	 * 智能交通违章代码长度上限
	 * \endif
	 */
	public static final int  MAX_VIOLATIONCODE_DESCRIPT= 64;              
	/**
	 * \if ENGLISH_LANG
	 * Direction string length
	 * \else
	 *  行驶方向字符串长度
	 * \endif
	 */
	public static final int  MAX_DRIVINGDIRECTION= 256;            
	/**
	 * \if ENGLISH_LANG
	 * Max alive user info
	 * \else
	 * 最大活动用户信息数
	 * \endif
	 */
	public static final int  MAX_ACTIVEUSER_NUM= 64;              
	/**
	 * \if ENGLISH_LANG
	 * Video analysis device area top quantity limit
	 * \else
	 * 视频分析设备区域顶点个数上限
	 * \endif
	 */
	public static final int  MAX_POLYGON_NUM10=10;				  
	/**
	 * \if ENGLISH_LANG
	 * Video diagnosis type quantity limit
	 * \else
	 * 视频诊断类型个数上限
	 * \endif
	 */
	public static final int  MAX_VIDEODIAGNOSIS_DETECT_TYPE= 11;          
	/**
	 * \if ENGLISH_LANG
	 * Video analysis device supported rule type list quantity limit
	 * \else
	 * 视频分析设备支持的规则的动作类型列表个数上限
	 * \endif
	 */
	public static final int  MAX_ACTION_LIST_SIZE=16;					  
	/**
	 * \if ENGLISH_LANG
	 * Storage group buffer limit
	 * \else
	 * 存储组名称缓冲区上限
	 * \endif
	 */
	public static final int  MAX_STORAGEGROUPNAME_LEN= 32;                   
	/**
	 * \if ENGLISH_LANG
	 * Mark area type limit
	 * \else
	 * 标定区域类型上限
	 * \endif
	 */
	public static final int  MAX_CALIBRATEAREA_TYPE_NUM= 4;                  
	/**
	 * \if ENGLISH_LANG
	 * Protocol name length
	 * \else
	 * 协议名称长度
	 * \endif
	 */
	public static final int  MAX_PROTOCOL_NAME_LEN= 32;					  
	/**
	 * \if ENGLISH_LANG
	 * Max serial quantity
	 * \else
	 * 最大串口数量
	 * \endif
	 */
	public static final int	 MAX_COMM_NUM= 16;					  
	/**
	 * \if ENGLISH_LANG
	 * DNS max quantity
	 * \else
	 * DNS最大数量
	 * \endif
	 */
	public static final int  MAX_DNS_SERVER_NUM= 2;					  
	/**
	 * \if ENGLISH_LANG
	 * Max network quantity
	 * \else
	 * 最大网卡数量
	 * \endif
	 */
	public static final int  MAX_NETWORK_INTERFACE_NUM= 32;				  
	/**
	 * \if ENGLISH_LANG
	 * NVS max quantity
	 * \else
	 * 网络存储服务器最大数量
	 * \endif
	 */
	public static final int	 MAX_NAS_NUM= 16;				
	/**
	 * \if ENGLISH_LANG
	 * Record storage mapping max quantity
	 * \else
	 * 录像存储点映射最大数量
	 * \endif
	 */
	public static final int  MAX_STORAGEPOINT_NUM= 32;                
	/**
	 * \if ENGLISH_LANG
	 * Intelligent tracking scene max quantity
	 * \else
	 * 智能跟踪场景最大数量
	 * \endif
	 */
	public static final int  MAX_TRACKSCENE_NUM= 10;                
	/**
	 * \if ENGLISH_LANG
	 * Traffic device status max quantity
	 * \else
	 * 交通设备状态最大个数
	 * \endif
	 */
	public static final int  MAX_STATUS_NUM= 16;                    
	/**
	 * \if ENGLISH_LANG
	 * Server supported max services
	 * \else
	 * 服务器支持的最大服务数
	 * \endif
	 */
	public static final int  MAX_SERVICE_NUM= 128;                   
	/**
	 * \if ENGLISH_LANG
	 * Database keyword max value
	 * \else
	 * 数据库关键字最大值
	 * \endif
	 */
	public static final int  MAX_DBKEY_NUM= 64;                    
	/**
	 * \if ENGLISH_LANG
	 * Overlay to JPEG summary info max length
	 * \else
	 * 叠加到JPEG图片的摘要信息最大长度
	 * \endif
	 */
	public static final int  MAX_SUMMARY_LEN= 1024;                  
	/**
	 * \if ENGLISH_LANG
	 * Motion detection supported video window value
	 * \else
	 * 动检支持的视频窗口值
	 * \endif
	 */
	public static final int  MAX_MOTION_WINDOW= 10;                    
	/**
	 * \if ENGLISH_LANG
	 * osd overlay content max length
	 * \else
	 * osd叠加内容最大长度
	 * \endif
	 */
	public static final int  MAX_OSD_SUMMARY_LEN= 256;                   
	/**
	 * \if ENGLISH_LANG
	 * osd overlay title max length
	 * \else
	 * osd叠加标题最大长度
	 * \endif
	 */
	public static final int  MAX_OSD_TITLE_LEN= 128;                   
	/**
	 * \if ENGLISH_LANG
	 * Custom judicial case max quantity
	 * \else
	 * 自定义司法案件最大个数
	 * \endif
	 */
	public static final int  MAX_CUSTOMCASE_NUM= 16;                    
	/**
	 * \if ENGLISH_LANG
	 * Master/slave tracking max global config number
	 * \else
	 * 主从式跟踪器最大全局配置数
	 * \endif
	 */
	public static final int  MAX_GLOBAL_MSTERSLAVE_NUM= 64;               
	/**
	 * \if ENGLISH_LANG
	 * Video analysis device supported detection object property type list quantity limit
	 * \else
	 * 视频分析设备支持的检测物体属性类型列表个数上限
	 * \endif
	 */
	public static final int  MAX_OBJECT_ATTRIBUTES_SIZE= 16;				  
	/**
	 * \if ENGLISH_LANG
	 * Device model length
	 * \else
	 * 设备型号长度
	 * \endif
	 */
	public static final int  MAX_MODEL_LEN= 32;					  
	/**
	 * \if ENGLISH_LANG
	 * Max writing device quantity
	 * \else
	 * 最大刻录设备个数
	 * \endif
	 */
	public static final int  MAX_BURNING_DEV_NUM= 32;					  
	/**
	 * \if ENGLISH_LANG
	 * Max net type quantity
	 * \else
	 * 最大网络类型个数
	 * \endif
	 */
	public static final int  MAX_NET_TYPE_NUM= 8;                     
	/**
	 * \if ENGLISH_LANG
	 * Net type string length 
	 * \else
	 * 网络类型字符串长度
	 * \endif
	 */
	public static final int  MAX_NET_TYPE_LEN= 64;                    
	/**
	 * \if ENGLISH_LANG
	 * Device name
	 * \else
	 * 机器名称
	 * \endif
	 */
	public static final int  MAX_DEVICE_NAME_LEN= 64;					  
	/**
	 * \if ENGLISH_LANG
	 * Device ID max length
	 * \else
	 * 设备ID最大长度
	 * \endif
	 */
	public static final int  MAX_DEV_ID_LEN_EX= 128;					  
	/**
	 * \if ENGLISH_LANG
	 * Month in a year
	 * \else
	 * 一年中月份数
	 * \endif
	 */
	public static final int  MONTH_OF_YEAR= 12;					  
	/**
	 * \if ENGLISH_LANG
	 * Server max quantity
	 * \else
	 * 服务器最大个数
	 * \endif
	 */
	public static final int  MAX_SERVER_NUM= 10;                    
	/**
	 * \if ENGLISH_LANG
	 * Auto registration config max quantity 
	 * \else
	 * 主动注册配置最大个数
	 * \endif
	 */
	public static final int  MAX_REGISTER_NUM= 10;                    
	/**
	 * \if ENGLISH_LANG
	 * Single channel max speed change config quantity
	 * \else
	 * 单通道最大变速配置个数
	 * \endif
	 */
	public static final int  MAX_VIDEO_IN_ZOOM= 32;                    
	/**
	 * \if ENGLISH_LANG
	 * Video analysis global config scene max quantity
	 * \else
	 * 视频分析全局配置场景最大数量
	 * \endif
	 */
	public static final int	 MAX_ANALYSE_SCENE_NUM= 32;					  
	/**
	 * \if ENGLISH_LANG
	 * Each PTZ max config quantity
	 * \else
	 * 每个云台的最大配置数
	 * \endif
	 */
	public static final int	 MAX_CONFIG_NUM	= 32;					  
	/**
	 * \if ENGLISH_LANG
	 * General string length 16
	 * \else
	 * 通用字符串长度16
	 * \endif
	 */
	public static final int  CFG_COMMON_STRING_16= 16;                    
	/**
	 * \if ENGLISH_LANG
	 * General string length 32
	 * \else
	 * 通用字符串长度32
	 * \endif
	 */
	public static final int  CFG_COMMON_STRING_32= 32;                    
	/**
	 * \if ENGLISH_LANG
	 * General string length 64
	 * \else
	 * 通用字符串长度64
	 * \endif
	 */
	public static final int  CFG_COMMON_STRING_64= 64;                    
	/**
	 * \if ENGLISH_LANG
	 * General string length 128
	 * \else
	 * 通用字符串长度128
	 * \endif
	 */
	public static final int  CFG_COMMON_STRING_128= 128;                   
	/**
	 * \if ENGLISH_LANG
	 * General string length 256
	 * \else
	 * 通用字符串长度256
	 * \endif
	 */
	public static final int  CFG_COMMON_STRING_256= 256;                   
	/**
	 * \if ENGLISH_LANG
	 * General string length 512
	 * \else
	 * 通用字符串长度512
	 * \endif
	 */
	public static final int  CFG_COMMON_STRING_512= 512;
	
	/**
	 * \if ENGLISH_LANG
	 * Channel name length
	 * \else
	 * 通道名称长度
	 * \endif
	 */
	public static final int  AV_CFG_Channel_Name_Len= 64;			  
	/**
	 * \if ENGLISH_LANG
	 * A week day
	 * \else
	 * 一周天数
	 * \endif
	 */
	public static final int  AV_CFG_Weekday_Num	= 7;			  
	/**
	 * \if ENGLISH_LANG
	 * Period quantity
	 * \else
	 * 时间段数量
	 * \endif
	 */
	public static final int  AV_CFG_Max_TimeSection= 6;			  
	/**
	 * \if ENGLISH_LANG
	 * Device ID length
	 * \else
	 * 设备ID长度
	 * \endif
	 */
	public static final int  AV_CFG_Device_ID_Len= 64;			
	/**
	 * \if ENGLISH_LANG
	 * ip length
	 * \else
	 * ip长度
	 * \endif
	 */
	public static final int  AV_CFG_IP_Address_Len= 32;			 
	/**
	 * \if ENGLISH_LANG
	 * Username length
	 * \else
	 * 用户名长度
	 * \endif
	 */
	public static final int  AV_CFG_User_Name_Len= 64;			
	/**
	 * \if ENGLISH_LANG
	 * Password length
	 * \else
	 * 密码长度
	 * \endif
	 */
	public static final int  AV_CFG_Password_Len= 64;			
	/**
	 * \if ENGLISH_LANG
	 * Protocol name length
	 * \else
	 * 协议名长度
	 * \endif
	 */
	public static final int  AV_CFG_Protocol_Len= 32;			 
	/**
	 * \if ENGLISH_LANG
	 * SN length
	 * \else
	 * 序列号长度
	 * \endif
	 */
	public static final int  AV_CFG_Serial_Len= 32;			
	/**
	 * \if ENGLISH_LANG
	 * Device type length
	 * \else
	 * 设备类型长度
	 * \endif
	 */
	public static final int  AV_CFG_Device_Class_Len= 16;			 
	/**
	 * \if ENGLISH_LANG
	 * Device detailed model length
	 * \else
	 * 设备具体型号长度
	 * \endif
	 */
	public static final int  AV_CFG_Device_Type_Len= 32;			 
	/**
	 * \if ENGLISH_LANG
	 * Device name
	 * \else
	 * 机器名称
	 * \endif
	 */
	public static final int  AV_CFG_Device_Name_Len= 64;			 
	/**
	 * \if ENGLISH_LANG
	 * Device deploy location
	 * \else
	 * 机器部署地点
	 * \endif
	 */
	public static final int  AV_CFG_Address_Len= 128;			 
	/**
	 * \if ENGLISH_LANG
	 * Group name length
	 * \else
	 * 分区名称
	 * \endif
	 */
	public static final int  AV_CFG_Group_Name_Len= 64;			
	/**
	 * \if ENGLISH_LANG
	 * Path length
	 * \else
	 * 路径长度
	 * \endif
	 */
	public static final int  AV_CFG_Max_Path= 260;			
	/**
	 * \if ENGLISH_LANG
	 * Max split window quantity
	 * \else
	 * 最大分割窗口数量
	 * \endif
	 */
	public static final int  AV_CFG_Max_Split_Window= 128;			
	/**
	 * \if ENGLISH_LANG
	 * Each output channel max tour image favorite quantity
	 * \else
	 * 每个输出通道的最大轮训画面收藏数量
	 * \endif
	 */
	public static final int  AV_CFG_Monitor_Favorite_In_Channel= 64;			 
	/**
	 * \if ENGLISH_LANG
	 * Image favorite name length
	 * \else
	 * 画面收藏名称长度
	 * \endif
	 */
	public static final int  AV_CFG_Monitor_Favorite_Name_Len= 64;			
	/**
	 * \if ENGLISH_LANG
	 * Image favorite max window quantity
	 * \else
	 * 画面收藏的最大窗口数量
	 * \endif
	 */
	public static final int  AV_CFG_Max_Monitor_Favorite_Window= 64;			 
	/**
	 * \if ENGLISH_LANG
	 * Split max group quantity
	 * \else
	 * 分割最大分组数量
	 * \endif
	 */
	public static final int  AV_CFG_Max_Split_Group= 64;			
	/**
	 * \if ENGLISH_LANG
	 * Split mode max quantity
	 * \else
	 * 分割模式最大数量
	 * \endif
	 */
	public static final int  AV_CFG_Max_Split_Mode= 32;			
	/**
	 * \if ENGLISH_LANG
	 * RAID name length
	 * \else
	 * RAID名称长度
	 * \endif
	 */
	public static final int  AV_CFG_Raid_Name_Len= 64;			
	/**
	 * \if ENGLISH_LANG
	 * Single RAID included disk quantity
	 * \else
	 * 单个RAID包含磁盘数
	 * \endif
	 */
	public static final int  AV_CFG_Max_Rail_Member= 32;			
	/**
	 * \if ENGLISH_LANG
	 * Main stream encode type quantity
	 * \else
	 * 主码流编码类型数
	 * \endif
	 */
	public static final int  AV_CFG_Max_Encode_Main_Format= 3;			
	/**
	 * \if ENGLISH_LANG
	 * Sub stream encode type
	 * \else
	 * 辅码流编码类型数
	 * \endif
	 */
	public static final int  AV_CFG_Max_Encode_Extra_Format= 3;			
	/**
	 * \if ENGLISH_LANG
	 * Snapshot encode type
	 * \else
	 * 抓图编码类型数
	 * \endif
	 */
	public static final int	 AV_CFG_Max_Encode_Snap_Format= 3;			
	/**
	 * \if ENGLISH_LANG
	 * Each channel max video input color config quantity
	 * \else
	 * 每个通道最大视频输入颜色配置数量
	 * \endif
	 */
	public static final int  AV_CFG_Max_VideoColor= 24;			
	/**
	 * \if ENGLISH_LANG
	 * Custom title name length
	 * \else
	 * 自定义标题名称长度
	 * \endif
	 */
	public static final int  AV_CFG_Custom_Title_Len= 256;			
	/**
	 * \if ENGLISH_LANG
	 * Custom title type length
	 * \else
	 * 自定义标题类型长度
	 * \endif
	 */
	public static final int  AV_CFG_Custom_TitleType_Len= 32;         
	/**
	 * \if ENGLISH_LANG
	 * Encode area coverage max quantity
	 * \else
	 *  编码区域覆盖最大数量
	 * \endif
	 */
	public static final int  AV_CFG_Max_Video_Widget_Cover= 16;			
	/**
	 * \if ENGLISH_LANG
	 * Encode object custom title max quantity
	 * \else
	 * 编码物件自定义标题最大数量
	 * \endif
	 */
	public static final int  AV_CFG_Max_Video_Widget_Custom_Title= 8;	
	/**
	 * \if ENGLISH_LANG
	 * Encode object max number of sensor info
	 * \else
	 * 编码物件叠加传感器信息的最大数目
	 * \endif
	 */
	public static final int AV_CFG_Max_Video_Widget_Sensor_Info  = 2;
	/**
	 * \if ENGLISH_LANG
	 * max description number
	 * \else
	 * 叠加区域描述信息的最大个数
	 * \endif
	 */
	public static final int AV_CFG_Max_Description_Num = 4;
	/**
	 * \if ENGLISH_LANG
	 * Group note length
	 * \else
	 * 分组说明长度
	 * \endif
	 */
	public static final int  AV_CFG_Group_Memo_Len= 128;			
	/**
	 * \if ENGLISH_LANG
	 * Max channel quantity
	 * \else
	 * 最大通道数量
	 * \endif
	 */
	public static final int  AV_CFG_Max_Channel_Num= 1024;		
	/**
	 * \if ENGLISH_LANG
	 * Time format length
	 * \else
	 * 时间格式长度
	 * \endif
	 */
	public static final int  AV_CFG_Time_Format_Len= 32;			 
	/**
	 * \if ENGLISH_LANG
	 * White list quantity
	 * \else
	 * 白名单数量
	 * \endif
	 */
	public static final int  AV_CFG_Max_White_List= 1024;		
	/**
	 * \if ENGLISH_LANG
	 * Black list quantity
	 * \else
	 * 黑名单数量
	 * \endif
	 */
	public static final int  AV_CFG_Max_Black_List= 1024;		
	/**
	 * \if ENGLISH_LANG
	 * Filter IP max length
	 * \else
	 * 过滤IP最大长度
	 * \endif
	 */
	public static final int  AV_CFG_Filter_IP_Len= 96;			
	/**
	 * \if ENGLISH_LANG
	 * Channel storage rule max length, only channel part
	 * \else
	 * 通道存储规则最大长度, 仅通道部分
	 * \endif
	 */
	public static final int  AV_CFG_Max_ChannelRule= 32;			
	/**
	 * \if ENGLISH_LANG
	 * Event keyword quantity
	 * \else
	 * 事件关键字数量
	 * \endif
	 */
	public static final int  AV_CFG_Max_DBKey_Num= 64;			
	/**
	 * \if ENGLISH_LANG
	 * Event keyword length
	 * \else
	 * 事件关键字长度
	 * \endif
	 */
	public static final int  AV_CFG_DBKey_Len= 32;			
	/**
	 * \if ENGLISH_LANG
	 * Summary length
	 * \else
	 * 摘要长度
	 * \endif
	 */
	public static final int  AV_CFG_Max_Summary_Len= 1024;		
	/**
	 * \if ENGLISH_LANG
	 * Event title max length
	 * \else
	 * 事件标题最大数量
	 * \endif
	 */
	public static final int  AV_CFG_Max_Event_Title_Num= 32;			
	/**
	 * \if ENGLISH_LANG
	 * Activation tour max quantity
	 * \else
	 * 联动轮巡最大数量
	 * \endif
	 */
	public static final int  AV_CFG_Max_Tour_Link_Num= 128;			
	/**
	 * \if ENGLISH_LANG
	 * PIP split mode basic value
	 * \else
	 * 画中画分割模式基础值
	 * \endif
	 */
	public static final int  AV_CFG_PIP_BASE= 1000;		
	/**
	 * \if ENGLISH_LANG
	 * DES key byte length
	 * \else
	 * DES密钥的字节长度
	 * \endif
	 */
	public static final int  DES_KEY_LEN= 8;			
	/**
	 * \if ENGLISH_LANG
	 * 3DES key byte length
	 * \else
	 * 3DES密钥的个数
	 * \endif
	 */
	public static final int  DES_KEY_NUM= 3;			
	/**
	 * \if ENGLISH_LANG
	 * AES key byte length
	 * \else
	 * AES密钥的字节长度
	 * \endif
	 */
	public static final int  AES_KEY_LEN= 32;			
	/**
	 * \if ENGLISH_LANG
	 * Time table element quantity
	 * \else
	 * 时间表元素个数
	 * \endif
	 */
	public static final int  MAX_TIME_SCHEDULE_NUM= 8;
	
	/**
	 * \if ENGLISH_LANG
	 * Scene sub type string length
	 * \else
	 * 场景子类型字符串长度
	 * \endif
	 */
	public static final int MAX_SCENE_SUBTYPE_LEN               = 64 ;
	
	/**
	 * \if ENGLISH_LANG
	 * Scene sub type max quantity
	 * \else
	 * 场景子类型最大个数
	 * \endif
	 */
	public static final int MAX_SCENE_SUBTYPE_NUM               = 32 ;
	
	/**
	 * \if ENGLISH_LANG
	 * Single channel max focus config quantity
	 * \else
	 * 单通道最大聚焦配置个数
	 * \endif
	 */
	public static final int MAX_VIDEO_IN_FOCUS                  = 32 ;
	
	/**
	 * \if ENGLISH_LANG
	 * Max time period speed config quantity
	 * \else
	 * 最大时间段限速配置个数
	 * \endif
	 */
	public static final int MAX_TIMESPEEDLIMIT_NUM				= 16 ;
	
	/**
	 * \if ENGLISH_LANG
	 * Max audio prompt config quantity
	 * \else
	 * 最大语音提示配置个数
	 * \endif
	 */
	public static final int MAX_VOICEALERT_NUM					= 64 ;
	
	/**
	 * \if ENGLISH_LANG
	 * Max lower matrix quantity
	 * \else
	 * 最大下位矩阵数量
	 * \endif
	 */
	public static final int CFG_MAX_LOWER_MATRIX_NUM			= 16 ;
	
	/**
	 * \if ENGLISH_LANG
	 * Max lower matrix input channel quantity
	 * \else
	 * 最大下位矩阵输入通道数
	 * \endif
	 */
	public static final int CFG_MAX_LOWER_MATRIX_INPUT			= 64 ;
	
	/**
	 * \if ENGLISH_LANG
	 * Max lower matrix output channel quantity
	 * \else
	 * 最大下位矩阵输出通道数
	 * \endif
	 */
	public static final int CFG_MAX_LOWER_MATRIX_OUTPUT			= 32 ;
	
	public static final int CFG_MAX_FISHEYE_WINDOW_NUM          =     8;         // 最大鱼眼窗口数
	public static final int CFG_MAX_FISHEYE_MODE_NUM            =     8;         // 最大鱼眼模式数   
	
	/**
	 * \if ENGLISH_LANG
	 * Max IR panel template quantity
	 * \else
	 * 最大红外面板模板数量
	 * \endif
	 */
	public static final int CFG_MAX_INFRARED_BOARD_TEMPLATE_NUM = 16 ;
	
	/**
	 * \if ENGLISH_LANG
	 * Max IR panel button quantity
	 * \else
	 * 最大红外面板按键数量
	 * \endif
	 */
	public static final int	CFG_MAX_INFRARED_KEY_NUM			= 128;
	
	/**
	 * \if ENGLISH_LANG
	 * Max IR panel quantity
	 * \else
	 * 最大红外面板数量
	 * \endif
	 */
	public static final int	CFG_MAX_INFRARED_BOARD_NUM			= 16 ;
	
	public static final int	MAX_ALARM_CHANNEL_NUM				= 32;			// 最大报警通道数
	public static final int	MAX_ALARM_DEFENCE_TYPE_NUM		    = 8;			// 最大报警防区类型数
	public static final int	MAX_ALARM_SENSE_METHOD_NUM			= 16;			// 最大报警感应器方式数
	
	/**
	 * \if ENGLISH_LANG
	 * Local device ID
	 * \else
	 * 本地设备ID
	 * \endif
	 */
	public static final String  AV_CFG_Local_Device_ID= "Local";		
	/**
	 * \if ENGLISH_LANG
	 * Remote device ID
	 * \else
	 * 远程设备ID
	 * \endif
	 */
	public static final String  AV_CFG_Remote_Devce_ID= "Remote";	 
	/**
	 * \if ENGLISH_LANG
	 * COM configuration (Corresponding of CFG_COMMGROUP_INFO)
	 * \else
	 * 串口配置(对应CFG_COMMGROUP_INFO)
	 * \endif
	 */
	public static final String  CFG_CMD_COMM= "Comm";				
	/**
	 * \if ENGLISH_LANG
	 * CAN config(corresponding to  CFG_CANFILTER_LIST)
	 * \else
	 * CAN透传配置(对应 CFG_CANFILTER_LIST)
	 * \endif
	 */
	public static final String  CFG_CMD_CANFILTER= "CANFilter";			
	/**
	 * \if ENGLISH_LANG
	 * Device alive config(corresponding to structure CFG_DEVICEKEEPALIVELIST)
	 * \else
	 * 设备保活配置(对应结构体 CFG_DEVICEKEEPALIVELIST)
	 * \endif
	 */
	public static final String  CFG_CMD_DEVICEKEEPALIVE = "DeviceKeepAlive"; 
	
	/**
	 * \if ENGLISH_LANG
	 * Call analysis video info summary type， corresponding structure as CFG_VIDEOSATA_SUMMARY_INFO 
	 * \else
	 * 回调解析视频信息摘要类型，对应结构体为CFG_VIDEOSATA_SUMMARY_INFO
	 * \endif
	 */
	public static final int     TYPE_CB_VIDEOSTAT=       0x1000000;      
	/**
	 * \if ENGLISH_LANG
	 * Call analysis video input channel corresponding all event rule types, corresponding to structure CFG_ANALYSERULES_INFO
	 * \else
	 * 回调解析视频输入通道对应的所有事件规则类型，对应结构体为CFG_ANALYSERULES_INFO
	 * \endif
	 */
	public static final int     TYPE_CB_ANARULES=        0x1000001;     
	/**
	 * \if ENGLISH_LANG
	 * Call analysis compressed video intelligent frame, corresponding to structure DH_MSG_OBJECT
	 * \else
	 * 回调解析浓缩视频的智能帧，对应结构体SDK_MSG_OBJECT
	 * \endif
	 */
	public static final int     TYPE_CB_VIDEOSYNOPSIS=   0x1000002;	 
	/**
	 * \if ENGLISH_LANG
	 * Call analysis traffic info, corresponding to structure DEV_EVENT_TRAFFIC_FLOWSTAT_INFO 
	 * \else
	 * 回调解析交通流量信息，对应结构体DEV_EVENT_TRAFFIC_FLOWSTAT_INFO
	 * \endif
	 */
	public static final int     TYPE_CB_TRAFFICFLOWINFO= 0x1000003;

	/**
	 * \if ENGLISH_LANG
	 * Call analysis traffic flow rule info，corresponding to structure CFG_TRAFFIC_FLOWSTAT_INFO
	 * \else
	 * 回调解析交通流量规则信息，对应结构体 CFG_TRAFFIC_FLOWSTAT_INFO
	 * \endif
	 */
	public static final int    TYPE_CB_TRAFFICFLOWRULE = 0x1000004; 
	

	/************************************************************************
	 ** 配置命令 对应 GetNewDevConfig和 SetNewDevConfig接口
	 ***********************************************************************/
	
	/**
	 * \if ENGLISH_LANG
	 * image channel property config,structure CFG_ENCODE_INFO
	 * \else
	 * 图像通道属性配置(对应CFG_ENCODE_INFO)
	 * \endif
	 */
	public static final String  CFG_CMD_ENCODE = "Encode";
	
	/**
	 * \if ENGLISH_LANG
	 * timed recordconfig,structure CFG_RECORD_INFO 
	 * \else
	 * 定时录像配置(对应CFG_RECORD_INFO)
	 * \endif
	 */
	public static String CFG_CMD_RECORD		    = "Record";    		
	/**
	 * \if ENGLISH_LANG
	 * external inputalarmconfig,structure CFG_ALARMIN_INFO 
	 * \else
	 * 外部输入报警配置(对应CFG_ALARMIN_INFO)
	 * \endif
	 */
	public static String CFG_CMD_ALARMINPUT	    = "Alarm";    			
	/**
	 * \if ENGLISH_LANG
	 * network alarmconfig,structure CFG_NETALARMIN_INFO 
	 * \else
	 * 网络报警配置(对应CFG_NETALARMIN_INFO)
	 * \endif
	 */
	public static String CFG_CMD_NETALARMINPUT    = "NetAlarm";    		
	/**
	 * \if ENGLISH_LANG
	 * dynamic detectionalarmconfig,structure CFG_MOTION_INFO 
	 * \else
	 * 动态检测报警配置(对应CFG_MOTION_INFO)
	 * \endif
	 */
	public static String CFG_CMD_MOTIONDETECT    = "MotionDetect";    	
	/**
	 * \if ENGLISH_LANG
	 * video loss alarmconfig,structure CFG_VIDEOLOST_INFO 
	 * \else
	 * 视频丢失报警配置(对应CFG_VIDEOLOST_INFO)
	 * \endif
	 */
	public static String CFG_CMD_VIDEOLOST	    = "LossDetect";    	
	/**
	 * \if ENGLISH_LANG
	 * video mask alarmconfig,structure CFG_SHELTER_INFO 
	 * \else
	 * 视频遮挡报警配置(对应CFG_SHELTER_INFO)
	 * \endif
	 */
	public static String CFG_CMD_VIDEOBLIND	    = "BlindDetect";    	
	/**
	 * \if ENGLISH_LANG
	 * no storage device config,structure CFG_STORAGENOEXIST_INFO 
	 * \else
	 * 无存储设备报警配置(对应CFG_STORAGENOEXIST_INFO)
	 * \endif
	 */
	public static String CFG_CMD_STORAGENOEXIST    = "StorageNotExist";    
	/**
	 * \if ENGLISH_LANG
	 * storage device access mistake config,structure CFG_STORAGEFAILURE_INFO 
	 * \else
	 * 存储设备访问出错报警配置(对应CFG_STORAGEFAILURE_INFO)
	 * \endif
	 */
	public static String CFG_CMD_STORAGEFAILURE    = "StorageFailure";    
	/**
	 * \if ENGLISH_LANG
	 * storage device low volume config,structure CFG_STORAGELOWSAPCE_INFO 
	 * \else
	 * 存储设备空间不足报警配置(对应CFG_STORAGELOWSAPCE_INFO)
	 * \endif
	 */
	public static String CFG_CMD_STORAGELOWSAPCE    = "StorageLowSpace";    
	/**
	 * \if ENGLISH_LANG
	 * disconnected config,structure CFG_NETABORT_INFO 
	 * \else
	 * 网络断开报警配置(对应CFG_NETABORT_INFO)	
	 * \endif
	 */
	public static String CFG_CMD_NETABORT	    = "NetAbort";    		
	/**
	 * \if ENGLISH_LANG
	 * IP conflict setting,structure CFG_IPCONFLICT_INFO 
	 * \else
	 * IP冲突报警配置(对应CFG_IPCONFLICT_INFO)
	 * \endif
	 */
	public static String CFG_CMD_IPCONFLICT	    = "IPConflict";    	
	/**
	 * \if ENGLISH_LANG
	 * snapshot ,structure CFG_SNAPCAPINFO_INFO 
	 * \else
	 * 抓图能力查询(对应CFG_SNAPCAPINFO_INFO)
	 * \endif
	 */
	public static String CFG_CMD_SNAPCAPINFO	    = "SnapInfo";    		
	/**
	 * \if ENGLISH_LANG
	 * network storage serverconfig,structure CFG_NAS_INFO 
	 * \else
	 * 网络存储服务器配置(对应CFG_NAS_INFO)
	 * \endif
	 */
	public static String CFG_CMD_NAS			    = "NAS";    			
	/**
	 * \if ENGLISH_LANG
	 * PTZ config,structure CFG_PTZ_INFO
	 * \else
	 * 云台配置(对应CFG_PTZ_INFO)
	 * \endif
	 */
	public static String CFG_CMD_PTZ			    = "Ptz";    			
	/**
	 * \if ENGLISH_LANG
	 * PTZ schedule action config(corresponding to CFG_PTZ_AUTOMOVE_INFO)
	 * \else
	 * 云台定时动作配置(对应CFG_PTZ_AUTOMOVE_INFO)
	 * \endif
	 */
	public static String	CFG_CMD_PTZ_AUTO_MOVEMENT   = "PtzAutoMovement";    
	/**
	 * \if ENGLISH_LANG
	 * video water mark config,structure CFG_WATERMARK_INFO 
	 * \else
	 * 视频水印配置(对应CFG_WATERMARK_INFO)
	 * \endif
	 */
	public static String CFG_CMD_WATERMARK	    = "WaterMark";    		
	/**
	 * \if ENGLISH_LANG
	 * video full analysis config,structure CFG_ANALYSEGLOBAL_INFO
	 * \else
	 * 视频分析全局配置(对应CFG_ANALYSEGLOBAL_INFO)
	 * \endif
	 */
	public static String CFG_CMD_ANALYSEGLOBAL    = "VideoAnalyseGlobal";    
	/**
	 * \if ENGLISH_LANG
	 * object's detection module config,structure CFG_ANALYSEMODULES_INFO 
	 * \else
	 * 物体的检测模块配置(对应CFG_ANALYSEMODULES_INFO)
	 * \endif
	 */
	public static String CFG_CMD_ANALYSEMODULE    = "VideoAnalyseModule";    
	/**
	 * \if ENGLISH_LANG
	 * video analyzing rule config,structure CFG_ANALYSERULES_INFO 
	 * \else
	 * 视频分析规则配置(对应CFG_ANALYSERULES_INFO)
	 * \endif
	 */
	public static String CFG_CMD_ANALYSERULE	    = "VideoAnalyseRule";    
	/**
	 * \if ENGLISH_LANG
	 * video analyzing resource config,structure CFG_ANALYSESOURCE_INFO 
	 * \else
	 * 视频分析资源配置(对应CFG_ANALYSESOURCE_INFO)
	 * \endif
	 */
	public static String CFG_CMD_ANALYSESOURCE    = "VideoAnalyseSource";    
	/**
	 * \if ENGLISH_LANG
	 * wiper config CFG_RAINBRUSH_INFO 
	 * \else
	 * 雨刷配置(对应CFG_RAINBRUSH_INFO)
	 * \endif
	 */
	public static String CFG_CMD_RAINBRUSH         = "RainBrush";            
	/**
	 * \if ENGLISH_LANG
	 * ITC CFG_TRAFFICSNAPSHOT_INFO for compatible with old protocol；please use CFG_CMD_TRAFFICSNAPSHOT_MULTI)
	 * \else
	 * 智能交通抓拍(CFG_TRAFFICSNAPSHOT_INFO只为兼容老协议；请使用CFG_CMD_TRAFFICSNAPSHOT_MULTI)
	 * \endif
	 */
	public static String CFG_CMD_INTELLECTIVETRAFFIC   = "TrafficSnapshot";    
	/**
	 * \if ENGLISH_LANG
	 * full intellifent traffic config CFG_TRAFFICGLOBAL_INFO 
	 * \else
	 * 智能交通全局配置(CFG_TRAFFICGLOBAL_INFO)
	 * \endif
	 */
	public static String CFG_CMD_TRAFFICGLOBAL     = "TrafficGlobal";        
	/**
	 * \if ENGLISH_LANG
	 * normal config CFG_DEV_DISPOSITION_INFO
	 * \else
	 * 普通配置 (CFG_DEV_DISPOSITION_INFO)
	 * \endif
	 */
	public static String CFG_CMD_DEV_GENERRAL      = "General";              
	/**
	 * \if ENGLISH_LANG
	 * ATM expired config CFG_ATMMOTION_INFO
	 * \else
	 * ATM取款超时配置(对应CFG_ATMMOTION_INFO)
	 * \endif
	 */
	public static String CFG_CMD_ATMMOTION	    = "FetchMoneyOverTime";    
	/**
	 * \if ENGLISH_LANG
	 * device status info CFG_DEVICESTATUS_INFO 
	 * \else
	 * 设备状态信息(对应CFG_DEVICESTATUS_INFO)
	 * \endif
	 */
	public static String CFG_CMD_DEVICESTATUS      = "DeviceStatus";         
	/**
	 * \if ENGLISH_LANG
	 * extension info,structure CFG_HARDISKTANKGROUP_INFO 
	 * \else
	 * 扩展柜信息(对应CFG_HARDISKTANKGROUP_INFO)
	 * \endif
	 */
	public static String CFG_CMD_HARDDISKTANK      = "HardDiskTank";         
	/**
	 * \if ENGLISH_LANG
	 * Raid froup info,structure CFG_RAIDGROUP_INFO 
	 * \else
	 * Raid组信息(对应CFG_RAIDGROUP_INFO)
	 * \endif
	 */
	public static String CFG_CMD_RAIDGROUP         = "RaidGroup";            
	/**
	 * \if ENGLISH_LANG
	 * storage pool info,structure CFG_STORAGEPOOLGROUP_INFO
	 * \else
	 * 存储池组信息(对应CFG_STORAGEPOOLGROUP_INFO)
	 * \endif
	 */
	public static String CFG_CMD_STORAGEPOOLGROUP   = "StoragePoolGroup";    
	/**
	 * \if ENGLISH_LANG
	 * file system group info,structure CFG_STORAGEPOSITIONGROUP_INFO 
	 * \else
	 * 文件系统组信息(对应CFG_STORAGEPOSITIONGROUP_INFO)
	 * \endif
	 */
	public static String CFG_CMD_STORAGEPOSITIONGROUP    = "StoragePositionGroup";     
	/**
	 * \if ENGLISH_LANG
	 * frong-end device group info CFG_VIDEOINDEVGROUP_INFO
	 * \else
	 * 前端设备组信息(对应CFG_VIDEOINDEVGROUP_INFO)
	 * \endif
	 */
	public static String CFG_CMD_VIDEOINDEVGROUP   = "VideoInDevGroup";      
	/**
	 * \if ENGLISH_LANG
	 * channelrecord group status,structure CFG_DEVRECORDGROUP_INFO
	 * \else
	 * 通道录像组状态(对应CFG_DEVRECORDGROUP_INFO)
	 * \endif
	 */
	public static String CFG_CMD_DEVRECORDGROUP    = "DevRecordGroup";       
	/**
	 * \if ENGLISH_LANG
	 * service status,structure CFG_IPSERVER_STATUS
	 * \else
	 * 服务状态(对应CFG_IPSERVER_STATUS)
	 * \endif
	 */
	public static String CFG_CMD_IPSSERVER         = "IpsServer";            
	/**
	 * \if ENGLISH_LANG
	 * Spot vide matrix,structure CFG_VIDEO_MATRIX
	 * \else
	 * 抓图源配置(对应CFG_SNAPSOURCE_INFO)
	 * \endif
	 */
	public static String CFG_CMD_SNAPSOURCE	    = "SnapSource";    	
	/**
	 * \if ENGLISH_LANG
	 * Dahua rador
	 * \else
	 * 大华雷达配置
	 * \endif
	 */
	public static String CFG_CMD_DHRADER           = "DahuaRadar";           
	/**
	 * \if ENGLISH_LANG
	 * Chuansu radar
	 * \else
	 * 川苏雷达配置
	 * \endif
	 */
	public static String CFG_CMD_TRANSRADER         = "TransRadar";          
	/**
	 * \if ENGLISH_LANG
	 * Landun radar
	 * \else
	 * 蓝盾雷达配置
	 * \endif
	 */
	public static String CFG_CMD_LANDUNRADER        = "LanDunRadar";         //
	/**
	 * \if ENGLISH_LANG
	 * Landun coil
	 * \else
	 * 蓝盾线圈配置
	 * \endif
	 */
	public static String CFG_CMD_LANDUNCOILS        = "LanDunCoils";         
	/**
	 * \if ENGLISH_LANG
	 * Spot vide matrix,structure CFG_VIDEO_MATRIX 
	 * \else
	 * Spot视屏矩阵(对应CFG_VIDEO_MATRIX)
	 * \endif
	 */
	public static String CFG_CMD_MATRIX_SPOT        = "SpotMatrix";          
	/**
	 * \if ENGLISH_LANG
	 * every number channel dsp info,structure CFG_DSPENCODECAP_INFO
	 * \else
	 * HDVR传每个数字通道的dsp信息 数字通道可以连IPC或DVR 也就是IPC或DVR的能力(对应CFG_DSPENCODECAP_INFO)
	 * \endif
	 */
	public static String CFG_CMD_HDVR_DSP           = "DspEncodeCap";        
	/**
	 * \if ENGLISH_LANG
	 * HDVR each digital channel connected device info
	 * \else
	 * HDVR传每个数字通道的所连设备的信息
	 * \endif
	 */
	public static String CFG_CMD_HDVR_ATTR_CFG      = "SystemAttr";          
	/**
	 * \if ENGLISH_LANG
	 * Holiday record plan(correspondting to strcture CFG_HOLIDAY_SCHEDULE group)
	 * \else
	 * 假期录像计划(对应结构体CFG_HOLIDAY_SCHEDULE数组)
	 * \endif
	 */
	public static String CFG_CMD_CHANNEL_HOLIDAY    = "HolidaySchedule";     
	/**
	 * \if ENGLISH_LANG
	 * Health mail
	 * \else
	 * 健康邮件
	 * \endif
	 */
	public static String CFG_CMD_HEALTH_MAIL        = "HealthMail";          
	/**
	 * \if ENGLISH_LANG
	 * Camera move detect activation 
	 * \else
	 * 摄像机移位侦测联动 
	 * \endif
	 */
	public static String CFG_CMD_CAMERAMOVE         = "IntelliMoveDetect";         
	/**
	 * \if ENGLISH_LANG
	 * video splicing tour config,structure CFG_VIDEO_MATRIX
	 * \else
	 * 视频分割轮巡配置(对应CFG_VIDEO_MATRIX)
	 * \endif
	 */
	public static String CFG_CMD_SPLITTOUR          = "SplitTour";           
	/**
	 * \if ENGLISH_LANG
	 * video encode ROI(Region of Intrest)config,structure
	 * \else
	 * 视频编码ROI(Region of Intrest)配置
	 * \endif
	 */
	public static String CFG_CMD_VIDEOENCODEROI     = "VideoEncodeROI";      
	/**
	 * \if ENGLISH_LANG
	 * light inspection config,structure CFG_VIDEO_INMETERING_INFO
	 * \else
	 * 测光配置(对应CFG_VIDEO_INMETERING_INFO)
	 * \endif
	 */
	public static String CFG_CMD_VIDEO_INMETERING   = "VideoInMetering";     
	/**
	 * \if ENGLISH_LANG
	 * traffic flow statistics config,structure CFG_TRAFFIC_FLOWSTAT_INFO
	 * \else
	 * 交通流量统计配置(对应CFG_TRAFFIC_FLOWSTAT_INFO)
	 * \endif
	 */
	public static String CFG_CMD_TRAFFIC_FLOWSTAT   = "TrafficFlowStat";     
	/**
	 * \if ENGLISH_LANG
	 * HDMI video matrix config
	 * \else
	 * HDMI视频矩阵配置
	 * \endif
	 */
	public static String CFG_CMD_HDMIMATRIX          = "HDMIMatrix";         
	/**
	 * \if ENGLISH_LANG
	 * videoinput front-end option,structure CFG_VIDEO_IN_OPTIONS 
	 * \else
	 * 视频输入前端选项(对应CFG_VIDEO_IN_OPTIONS)
	 * \endif
	 */
	public static String CFG_CMD_VIDEOINOPTIONS	   = "VideoInOptions";    
	/**
	 * \if ENGLISH_LANG
	 * RTSP的config,structure CFG_RTSP_INFO_IN , CFG_RTSP_INFO_OUT
	 * \else
	 * RTSP的配置( 对应CFG_RTSP_INFO_IN和CFG_RTSP_INFO_OUT )
	 * \endif
	 */
	public static String CFG_CMD_RTSP               = "RTSP";                

	public static String CFG_CMD_TRAFFICSNAPSHOT    = "TrafficSnapshotNew";    
	/**
	 * \if ENGLISH_LANG
	 * intelligent traffic snapshot CFG_TRAFFICSNAPSHOT_NEW_INFO
	 * \else
	 * 智能交通抓拍(CFG_TRAFFICSNAPSHOT_NEW_INFO)
	 * \endif
	 */
	public static String CFG_CMD_TRAFFICSNAPSHOT_MULTI    = "TrafficSnapshotNew";    
	/**
	 * \if ENGLISH_LANG
	 * multicast related config,structure CFG_MULTICASTS_INFO_IN , CFG_MULTICASTS_INFO_OUT
	 * \else
	 * 组播的相关配置(对应CFG_MULTICASTS_INFO_IN和CFG_MULTICASTS_INFO_OUT)
	 * \endif
	 */
	public static String CFG_CMD_MULTICAST          = "Multicast";            
	/**
	 * \if ENGLISH_LANG
	 * video diagnosis parameter list,structure CFG_VIDEODIAGNOSIS_PROFILE 
	 * \else
	 * 视频诊断参数表(CFG_VIDEODIAGNOSIS_PROFILE)
	 * \endif
	 */
	public static String CFG_CMD_VIDEODIAGNOSIS_PROFILE     = "VideoDiagnosisProfile";    	
	/**
	 * \if ENGLISH_LANG
	 * video diagnosis task list,structure CFG_VIDEODIAGNOSIS_TASK 
	 * \else
	 * 视频诊断任务表(CFG_VIDEODIAGNOSIS_TASK)
	 * \endif
	 */
	public static String CFG_CMD_VIDEODIAGNOSIS_TASK	        = "VideoDiagnosisTask";    		
	/**
	 * \if ENGLISH_LANG
	 * video diagnosis plan list CFG_VIDEODIAGNOSIS_PROJECT
	 * \else
	 * 视频诊断计划表(CFG_VIDEODIAGNOSIS_PROJECT)
	 * \endif
	 */
	public static String CFG_CMD_VIDEODIAGNOSIS_PROJECT      = "VideoDiagnosisProject";    	
	/**
	 * \if ENGLISH_LANG
	 * 1111
	 * \else
	 * 视频诊断实时计划表(CFG_VIDEODIAGNOSIS_REALPROJECT)
	 * \endif
	 */
	public static String CFG_CMD_VIDEODIAGNOSIS_REALPROJECT      = "VideoDiagnosisRealProject";    
	/**
	 * \if ENGLISH_LANG
	 * video full diagnosis list CFG_VIDEODIAGNOSIS_GLOBAL 
	 * \else
	 * 视频诊断全局表(CFG_VIDEODIAGNOSIS_GLOBAL)
	 * \endif
	 */
	public static String CFG_CMD_VIDEODIAGNOSIS_GLOBAL       = "VideoDiagnosisGlobal";    	
	/**
	 * \if ENGLISH_LANG
	 * video diagnosis task list CFG_VIDEODIAGNOSIS_TASK
	 * \else
	 * 视频诊断任务表(CFG_VIDEODIAGNOSIS_TASK)
	 * \endif
	 */
	public static String CFG_CMD_VIDEODIAGNOSIS_TASK_ONE     = "VideoDiagnosisTask.x";        
	/**
	 * \if ENGLISH_LANG
	 * device working status relatedconfig,structure CFG_TRAFFIC_WORKSTATE_INFO
	 * \else
	 * 设备工作状态相关配置(对应CFG_TRAFFIC_WORKSTATE_INFO)
	 * \endif
	 */
	public static String CFG_CMD_TRAFFIC_WORKSTATE           = "WorkState";                      
	/**
	 * \if ENGLISH_LANG
	 * disk storage group config,structure CFG_STORAGEGROUP_INFO
	 * \else
	 * 磁盘存储组配置(对应CFG_STORAGEGROUP_INFO)
	 * \endif
	 */
	public static String CFG_CMD_STORAGEDEVGROUP             = "StorageDevGroup";                
	/**
	 * \if ENGLISH_LANG
	 * record stored storage group config,structure CFG_RECORDTOGROUP_INFO
	 * \else
	 * 录像存放的存储组配置(对应CFG_RECORDTOGROUP_INFO)
	 * \endif
	 */
	public static String CFG_CMD_RECORDTOGROUP               = "RecordToGroup";                  
	/**
	 * \if ENGLISH_LANG
	 * intelligent tracking scene config,structure CFG_INTELLITRACKSCENE_INFO
	 * \else
	 * 智能跟踪场景配置(CFG_INTELLITRACKSCENE_INFO) 
	 * \endif
	 */
	public static String CFG_CMD_INTELLITRACKSCENE           = "IntelliTrackScene";              
	/**
	 * \if ENGLISH_LANG
	 * intelligent frame rule config,structure CFG_ANALYSERULES_INFO 
	 * \else
	 * 智能帧规则配置(对应CFG_ANALYSERULES_INFO)
	 * \endif
	 */
	public static String CFG_CMD_IVSFRAM_RULE                = "IVSFramRule";                    
	/**
	 * \if ENGLISH_LANG
	 * record storage point mapping config,structure CFG_RECORDTOSTORAGEPOINT_INFO
	 * \else
	 * 录像存储点映射配置(对应CFG_RECORDTOSTORAGEPOINT_INFO)
	 * \endif
	 */
	public static String CFG_CMD_RECORD_STORAGEPOINT         = "RecordStoragePoint";             
	/**
	 * \if ENGLISH_LANG
	 * source data serverconfig,structure CFG_METADATA_SERVER
	 * \else
	 * 元数据服务器配置(对应CFG_METADATA_SERVER结构体)
	 * \endif
	 */
	public static String CFG_CMD_MD_SERVER		            = "MetaDataServer";                
	/**
	 * \if ENGLISH_LANG
	 * channel name AV_CFG_ChannelName 
	 * \else
	 * 通道名称(对应AV_CFG_ChannelName)
	 * \endif
	 */
	public static String CFG_CMD_CHANNELTITLE    = "ChannelTitle";    	
	/**
	 * \if ENGLISH_LANG
	 * record mode AV_CFG_RecordMode 
	 * \else
	 * 录像模式(对应AV_CFG_RecordMode)
	 * \endif
	 */
	public static String	CFG_CMD_RECORDMODE	    = "RecordMode";    	
	/**
	 * \if ENGLISH_LANG
	 * videooutput property AV_CFG_VideoOutAttr 
	 * \else
	 * 视频输出属性(对应AV_CFG_VideoOutAttr)
	 * \endif
	 */
	public static String CFG_CMD_VIDEOOUT	    = "VideoOut";    		
	/**
	 * \if ENGLISH_LANG
	 * remote device info AV_CFG_RemoteDevice
	 * \else
	 * 远程设备信息(对应AV_CFG_RemoteDevice数组, 通道无关)
	 * \endif
	 */
	public static String CFG_CMD_REMOTEDEVICE      = "RemoteDevice";    	
	/**
	 * \if ENGLISH_LANG
	 * remote channel AV_CFG_RemoteChannel
	 * \else
	 * 远程通道(对应AV_CFG_RemoteChannel)
	 * \endif
	 */
	public static String CFG_CMD_REMOTECHANNEL    = "RemoteChannel";    	
	/**
	 * \if ENGLISH_LANG
	 * image tour config AV_CFG_MonitorTour 
	 * \else
	 * 画面轮训配置(对应AV_CFG_MonitorTour)
	 * \endif
	 */
	public static String CFG_CMD_MONITORTOUR	    = "MonitorTour";    	
	/**
	 * \if ENGLISH_LANG
	 * image favorite config AV_CFG_MonitorCollection 
	 * \else
	 * 画面收藏配置(对应AV_CFG_MonitorCollection)
	 * \endif
	 */
	public static String CFG_CMD_MONITORCOLLECTION    = "MonitorCollection";    
	/**
	 * \if ENGLISH_LANG
	 * image splicing display source config AV_CFG_ChannelDisplaySource
	 * \else
	 * 画面分割显示源配置(对应AV_CFG_ChannelDisplaySource)(废除，不建议使用)
	 * \endif
	 */
	public static String CFG_CMD_DISPLAYSOURCE    = "DisplaySource";    	
	/**
	 * \if ENGLISH_LANG
	 * storage group config AV_CFG_Raid 
	 * \else
	 * 存储卷组配置(对应AV_CFG_Raid数组, 通道无关)
	 * \endif
	 */
	public static String CFG_CMD_RAID		    = "Raid";    			
	/**
	 * \if ENGLISH_LANG
	 * record source config AV_CFG_RecordSource
	 * \else
	 * 录像源配置(对应AV_CFG_RecordSource)
	 * \endif
	 */
	public static String CFG_CMD_RECORDSOURCE    = "RecordSource";    	
	/**
	 * \if ENGLISH_LANG
	 * videoinput color config AV_CFG_ChannelVideoColor 
	 * \else
	 * 视频输入颜色配置(对应AV_CFG_ChannelVideoColor)
	 * \endif
	 */
	public static String CFG_CMD_VIDEOCOLOR	    = "VideoColor";    	
	/**
	 * \if ENGLISH_LANG
	 * video encoding object config AV_CFG_VideoWidget
	 * \else
	 * 视频编码物件配置(对应AV_CFG_VideoWidget)
	 * \endif
	 */
	public static String CFG_CMD_VIDEOWIDGET	    = "VideoWidget";    	
	/**
	 * \if ENGLISH_LANG
	 * storage group info AV_CFG_StorageGroup
	 * \else
	 * 存储组信息(对应AV_CFG_StorageGroup数组, 通道无关)
	 * \endif
	 */
	public static String CFG_CMD_STORAGEGROUP    = "StorageGroup";    	
	/**
	 * \if ENGLISH_LANG
	 * area config AV_CFG_Locales
	 * \else
	 * 区域配置(对应AV_CFG_Locales)
	 * \endif
	 */
	public static String CFG_CMD_LOCALS		    = "Locales";    		
	/**
	 * \if ENGLISH_LANG
	 * language selection AV_CFG_Language 
	 * \else
	 * 语言选择(对应AV_CFG_Language)
	 * \endif
	 */
	public static String CFG_CMD_LANGUAGE	    = "Language";    		
	/**
	 * \if ENGLISH_LANG
	 * visit address filter AV_CFG_AccessFilter 
	 * \else
	 * 访问地址过滤(对应AV_CFG_AccessFilter)
	 * \endif
	 */
	public static String CFG_CMD_ACCESSFILTER    = "AccessFilter";    	
	/**
	 * \if ENGLISH_LANG
	 * auto maintenance AV_CFG_AutoMaintain 
	 * \else
	 * 自动维护(对应AV_CFG_AutoMaintain)
	 * \endif
	 */
	public static String CFG_CMD_AUTOMAINTAIN    = "AutoMaintain";    	
	/**
	 * \if ENGLISH_LANG
	 * remote device event process AV_CFG_RemoteEvent
	 * \else
	 * 远程设备事件处理(对应AV_CFG_RemoteEvent数组)
	 * \endif
	 */
	public static String CFG_CMD_REMOTEEVENT	    = "RemoteEvent";    	
	/**
	 * \if ENGLISH_LANG
	 * display wall config AV_CFG_MonitorWall
	 * \else
	 * 电视墙配置(对应AV_CFG_MonitorWall数组, 通道无关)
	 * \endif
	 */
	public static String CFG_CMD_MONITORWALL	    = "MonitorWall";    	
	/**
	 * \if ENGLISH_LANG
	 * mixing screen config AV_CFG_SpliceScreen
	 * \else
	 * 融合屏配置(对应AV_CFG_SpliceScreen数组, 通道无关)
	 * \endif
	 */
	public static String	CFG_CMD_SPLICESCREEN    = "VideoOutputComposite";    	
	/**
	 * \if ENGLISH_LANG
	 * temperature alarmconfig AV_CFG_TemperatureAlarm
	 * \else
	 * 温度报警配置(对应AV_CFG_TemperatureAlarm, 通道无关)
	 * \endif
	 */
	public static String CFG_CMD_TEMPERATUREALARM    = "TemperatureAlarm";    	
	/**
	 * \if ENGLISH_LANG
	 * fan speed alarmconfig AV_CFG_FanSpeedAlarm 
	 * \else
	 * 风扇转速报警配置(对应AV_CFG_FanSpeedAlarm, 通道无关)
	 * \endif
	 */
	public static String	CFG_CMD_FANSPEEDALARM	    = "FanSpeedAlarm";    		
	/**
	 * \if ENGLISH_LANG
	 * record rotate config AV_CFG_RecordBackup
	 * \else
	 * 录像回传配置(对应AV_CFG_RecordBackup, 通道无关)
	 * \endif
	 */
	public static String CFG_CMD_RECORDBACKUP	    = "RecordBackupRestore";    
	/**
	 * \if ENGLISH_LANG
	 * network config CFG_NETWORK_INFO 
	 * \else
	 * 网络配置(对应CFG_NETWORK_INFO)
	 * \endif
	 */
	public static String	CFG_CMD_NETWORK			      = "Network";    		
	/**
	 * \if ENGLISH_LANG
	 * network storage serverconfig, multi-server CFG_NAS_GROUP_INFO_EX
	 * \else
	 * 网络存储服务器配置, 多服务器(对应CFG_NAS_INFO_EX)
	 * \endif
	 */
	public static String CFG_CMD_NASEX			      = "NAS";    			
	/**
	 * \if ENGLISH_LANG
	 * LDAP config
	 * \else
	 * LDAP配置
	 * \endif
	 */
	public static String CFG_CMD_LDAP                  = "LDAP";                 
	/**
	 * \if ENGLISH_LANG
	 * active directory config
	 * \else
	 * 活动目录配置
	 * \endif
	 */
	public static String CFG_CMD_ACTIVE_DIR            = "ActiveDirectory";      
	/**
	 * \if ENGLISH_LANG
	 * Compensation light config(corresponding CFG_FLASH_LIGHT)
	 * \else
	 * 补光灯配置(对应 CFG_FLASH_LIGHT)
	 * \endif
	 */
	public static String CFG_CMD_FLASH                 = "FlashLight";           
	/**
	 * \if ENGLISH_LANG
	 * Audio analysis rule config(corresponding CFG_ANALYSERULES_INFO)
	 * \else
	 * 音频分析规则配置(对应 CFG_ANALYSERULES_INFO)
	 * \endif
	 */
	public static String CFG_CMD_AUDIO_ANALYSERULE     = "AudioAnalyseRule";     
	/**
	 * \if ENGLISH_LANG
	 * Judicial config(corresponding to CFG_JUDICATURE_INFO)
	 * \else
	 * 司法刻录配置(对应 CFG_JUDICATURE_INFO)
	 * \endif
	 */
	public static String CFG_CMD_JUDICATURE            = "Judicature";           
	/**
	 * \if ENGLISH_LANG
	 * Mobile load config(corresponding to CFG_GOOD_WEIGHT_INFO)
	 * \else
	 * 车载货重配置(对应CFG_GOOD_WEIGHT_INFO)
	 * \endif
	 */
	public static String CFG_CMD_GOODS_WEIGHT	    = "CQDTSet";    		
	/**
	 * \if ENGLISH_LANG
	 * Input channel config(corresponding CFG_VIDEO_IN_INFO)
	 * \else
	 * 输入通道配置(对应CFG_VIDEO_IN_INFO)
	 * \endif
	 */
	public static String CFG_CMD_VIDEOIN			    = "VideoIn";    		
	/**
	 * \if ENGLISH_LANG
	 * Write dick encode plan(corresponding CFG_ENCODE_PLAN_INFO)
	 * \else
	 * 刻录光盘编码计划(对应 CFG_ENCODE_PLAN_INFO)
	 * \endif
	 */
	public static String CFG_CMD_ENCODEPLAN            = "EncodePlan";           
	/**
	 * \if ENGLISH_LANG
	 * Judicial PIP(corresponding to CFG_PICINPIC_INFO) as group，compatible with single config according to length
	 * \else
	 * 司法审讯画中画(对应 CFG_PICINPIC_INFO)改为数组方式，兼容以前单个配置，根据长度区分
	 * \endif
	 */
	public static String CFG_CMD_PICINPIC              = "PicInPic";             
	/**
	 * \if ENGLISH_LANG
	 * Write full event config(corresponding CFG_BURNFULL_INFO)
	 * \else
	 * 刻录满事件配置(对应 CFG_BURNFULL_INFO)
	 * \endif
	 */
	public static String CFG_CMD_BURNFULL              = "BurnFull";             
	/**
	 * \if ENGLISH_LANG
	 * Master/slave global config（correspinding）
	 * \else
	 * 主从式全局配置（对应）
	 * \endif
	 */
	public static String CFG_CMD_MASTERSLAVE_GLOBAL    = "MasterSlaveTrackerGlobal";      
	/**
	 * \if ENGLISH_LANG
	 * Video analysis global config(corresponding to CFG_ANALYSEWHOLE_INFO)
	 * \else
	 * 视频分析整体配置(对应CFG_ANALYSEWHOLE_INFO)
	 * \endif
	 */
	public static String CFG_CMD_ANALYSEWHOLE    = "VideoAnalyseWhole";     
	/**
	 * \if ENGLISH_LANG
	 * Video input border config(corresponding CFG_VIDEO_IN_BOUNDARY)
	 * \else
	 * 视频输入边界配置(对应CFG_VIDEO_IN_BOUNDARY)
	 * \endif
	 */
	public static String CFG_CMD_VIDEO_IN_BOUNDARY    = "VideoInBoundary";    
	/**
	 * \if ENGLISH_LANG
	 * TV wall scheme (corresponding CFG_MONITORWALL_COLLECTION group)
	 * \else
	 * 电视墙预案(对应CFG_MONITORWALL_COLLECTION数组)
	 * \endif
	 */
	public static String	CFG_CMD_MONITORWALL_COLLECTION    = "MonitorWallCollection";    
	/**
	 * \if ENGLISH_LANG
	 * Analog matrix(corresponding to CFG_ANALOG_MATRIX_INFO)
	 * \else
	 * 模拟矩阵(对应CFG_ANALOG_MATRIX_INFO)
	 * \endif
	 */
	public static String CFG_CMD_ANALOGMATRIX	    = "AnalogMatrix";    	
	/**
	 * \if ENGLISH_LANG
	 * Analog matrix protocol config(Corresponding CFG_ANALOG_MATRIX_PROTOCOL group)
	 * \else
	 * 模拟矩阵协议配置(对应CFG_ANALOG_MATRIX_PROTOCOL数组)
	 * \endif
	 */
	public static String CFG_CMD_ANALOG_MATRIX_PROTOCOL    = "AnalogMatrixProtocol";    
	/**
	 * \if ENGLISH_LANG
	 * Video output title(corresponding to CFG_VIDEO_OUT_TITLE)
	 * \else
	 * 视频输出标题(对应CFG_VIDEO_OUT_TITLE)
	 * \endif
	 */
	public static String	CFG_CMD_VIDEO_OUT_TITLE	    = "VideoOutputTitle";    	
	/**
	 * \if ENGLISH_LANG
	 * Hark disk data flow alarm config(corresponding to CFG_DISK_FLUX_INFO)
	 * \else
	 * 硬盘数据流量报警配置(对应CFG_DISK_FLUX_INFO)
	 * \endif
	 */
	public static String CFG_CMD_DISK_FLUX_ALARM	    = "DiskFluxAlarm";    	
	/**
	 * \if ENGLISH_LANG
	 * Net data flow alarm config(corresponding to CFG_NET_FLUX_INFO)
	 * \else
	 * 网络数据流量报警配置(对应CFG_NET_FLUX_INFO)
	 * \endif
	 */
	public static String CFG_CMD_NET_FLUX_ALARM	    = "NetFluxAlarm";    	
	/**
	 * \if ENGLISH_LANG
	 * Net protocol config(corresponding to CFG_DVRIP_INFO)
	 * \else
	 * 网络协议配置(对应CFG_DVRIP_INFO)
	 * \endif
	 */
	public static String CFG_CMD_DVRIP                 = "DVRIP";                
	/**
	 * \if ENGLISH_LANG
	 * and camera corresponding area config(corresponding to  CFG_PARKINGSPACE_SCREEN_INFO ,group，element max value is DH_PRODUCTION_DEFNITION.nMaxParkingSpaceScreen)
	 * \else 
	 * 和相机对接的区域屏配置(对应 CFG_PARKINGSPACE_SCREEN_INFO ,是数组，元素最大值是SDK_PRODUCTION_DEFNITION.nMaxParkingSpaceScreen)
	 * \endif
	 */
	public static String CFG_CMD_PARKINGSPACE_SCREEN   = "ParkingSpaceScreen";    
	/**
	 * \if ENGLISH_LANG
	 * Spot setup(special spot and general spot setup)(corresponding to  CFG_PARKINGSPACE_STATUS_INFO ，is group，element max value is DH_PRODUCTION_DEFNITION.nMaxRoadWays)
	 * \else
	 * 车位设置(专有车位和普通车位设置)(对应 CFG_PARKINGSPACE_STATUS_INFO ，是数组，元素最大值是SDK_PRODUCTION_DEFNITION.nMaxRoadWays)
	 * \endif
	 */
	public static String CFG_CMD_PARKINGSPACE_STATUS   = "ParkingSpaceCellStatus";    
	/**
	 * \if ENGLISH_LANG
	 * Platform custom info(corresponding to  CFG_CLIENT_CUSTOM_INFO)
	 * \else
	 * 平台自定义信息(对应 CFG_CLIENT_CUSTOM_INFO)
	 * \endif
	 */
	public static String CFG_CMD_CLIENT_CUSTOM_DATA    = "ClientCustomData";     
	/**
	 * \if ENGLISH_LANG
	 * Writing format config(corresponding to  CFG_BURN_RECORD_FORMAT)
	 * \else
	 * 刻录格式配置(对应 CFG_BURN_RECORD_FORMAT)
	 * \endif
	 */
	public static String CFG_CMD_BURN_RECORD_FORMAT    = "BurnRecordFormat";     
	/**
	 * \if ENGLISH_LANG
	 * Multi disk sync write(corresponding to  CFG_MULTIBURN_INFO)group, each element means one group multi-disk sync writing and calibration
	 * \else
	 * 多光盘同步刻录(对应 CFG_MULTIBURN_INFO)是一个数组，每一个元素表示一组多光盘同步刻录及校验
	 * \endif
	 */
	public static String CFG_CMD_MULTIBURN             = "MultiBurn";            
	/**
	 * \if ENGLISH_LANG
	 * Encode encryption config info( CFG_ENCODE_ENCRYPT_CHN_INFO )
	 * \else
	 * 编码加密配置信息( CFG_ENCODE_ENCRYPT_CHN_INFO )
	 * \endif
	 */
	public static String	CFG_CMD_ENCODE_ENCRYPT	    = "EncodeEncrypt";    	
	/**
	 * \if ENGLISH_LANG
	 * PTZ channel zoom config(corresponding to  CFG_VIDEO_IN_ZOOM)
	 * \else
	 * 云台通道变倍配置(对应 CFG_VIDEO_IN_ZOOM)
	 * \endif
	 */
	public static String CFG_CMD_VIDEO_IN_ZOOM         = "VideoInZoom";          
	/**
	 * \if ENGLISH_LANG
	 * Snapshot config(corresponding to  CFG_SNAP_INFO)
	 * \else
	 * 抓图配置(对应 CFG_SNAP_INFO)
	 * \endif
	 */
	public static String CFG_CMD_SNAP			    = "Snap";    			
	/**
	 * \if ENGLISH_LANG
	 * Net storage server limit config(corresponding to  CFG_REMOTE_STORAGELIMIT_GROUP)
	 * \else
	 * 网络存储服务器限制配置(对应 CFG_REMOTE_STORAGELIMIT_GROUP)
	 * \endif
	 */
	public static String CFG_CMD_REMOTE_STORAGE_LIMIT      = "RemoteStorageLimit";       
	/**
	 * \if ENGLISH_LANG
	 * Special usage directory custom(corresponding to  CFG_SPECIAL_DIR_INFO)
	 * \else
	 * 特殊用途目录定义(对应 CFG_SPECIAL_DIR_INFO)
	 * \endif
	 */
	public static String CFG_CMD_SPECIAL_DIR		    = "SpecialDirectoryDefine";    
	/**
	 * \if ENGLISH_LANG
	 * After shut down delay auto boot up config(corresponding to  CFG_AUTO_STARTUP_DELAY_INFO)
	 * \else
	 * 关机后延时自动开机配置(对应 CFG_AUTO_STARTUP_DELAY_INFO)
	 * \endif
	 */
	public static String CFG_CMD_AUTO_STARTUP_DELAY    = "AutoStartupDelay";    		
	/**
	 * \if ENGLISH_LANG
	 * focus setup(corresponding to  CFG_VIDEO_IN_FOCUS)
	 * \else
	 * 聚焦设置(对应 CFG_VIDEO_IN_FOCUS)
	 * \endif
	 */
	public static String CFG_CMD_VIDEOIN_FOCUS         = "VideoInFocus";         
	/**
	 * \if ENGLISH_LANG
	 * Encode self-adaptive config(corresponding to  CFG_ENCODE_ADAPT_INFO)
	 * \else
	 * 编码自适应配置(对应 CFG_ENCODE_ADAPT_INFO)
	 * \endif
	 */
	public static String CFG_CMD_ENCODE_ADAPT	    = "EncodeAdapt";    	
	/**
	 * \if ENGLISH_LANG
	 * Video analysis config(corresponding to CFG_VIDEO_ANALYSE_CALIBRATEAREA)
	 * \else
	 * 视频分析标定配置(对应CFG_VIDEO_ANALYSE_CALIBRATEAREA)
	 * \endif
	 */
	public static String CFG_CMD_VIDEOANALYSE_CALIBRATE    = "VideoAnalyseCalibrate";     
	/**
	 * \if ENGLISH_LANG
	 * PTZ preset config (corresponding to structure PTZ_PRESET_INFO)
	 * \else
	 * 云台预置点配置(对应结构PTZ_PRESET_INFO)
	 * \endif
	 */
	public static String CFG_CMD_PTZ_PRESET             = "PtzPreset";           
	/**
	 * \if ENGLISH_LANG
	 * Period speed limit config(corresponding to structure CFG_TIMESPEEDLIMIT_LIST)
	 * \else
	 * 时间段限速值配置(对应结构体 CFG_TIMESPEEDLIMIT_LIST)
	 * \endif
	 */
	public static String CFG_CMD_TIMESPEEDLIMIT	    = "TimeSpeedLimit";    
	/**
	 * \if ENGLISH_LANG
	 * Prompt config(corresponding to structure CFG_VOICEALERT_LIST)
	 * \else
	 * 语音提示配置(对应结构体 CFG_VOICEALERT_LIST)
	 * \endif
	 */
	public static String CFG_CMD_VOICEALERT		    = "VoiceAlert";    	
	/**
	 * \if ENGLISH_LANG
	 * Audio spirit(corresponding to  CFG_AUDIO_SPIRIT)
	 * \else
	 * 语音激励(对应 CFG_AUDIO_SPIRIT)
	 * \endif
	 */
	public static String CFG_CMD_AUDIO_SPIRIT	    = "AudioSpirit";    	
	/**
	 * \if ENGLISH_LANG
	 * Combine channel config (corresponding to  CFG_COMPOSE_CHANNEL)
	 * \else
	 * 合成通道配置(对应 CFG_COMPOSE_CHANNEL)
	 * \endif
	 */
	public static String CFG_CMD_COMPOSE_CHANNEL	    = "ComposeChannel";    
	/**
	 * \if ENGLISH_LANG
	 * Lower matrix config(corresponding to  CFG_LOWER_MATRIX_LIST) 
	 * \else
	 * 下位矩阵配置(对应 CFG_LOWER_MATRIX_LIST)  	
	 * \endif
	 */
	public static String CFG_CMD_LOWER_MATRIX	    = "LowerMatrix";    
	
	public static String CFG_CMD_INFRARED_BOARD_TEMPLATE	 = "InfraredBoardTemplate";	// 红外面板模板(对应 CFG_INFRARED_BOARD_TEMPLATE_GROUP)
	public static String CFG_CMD_INFRARED_BOARD		 = "InfraredBoard";	// 红外面板模板(对应 CFG_INFRARED_BOARD_GROUP)
	public static String CFG_CMD_VIDEOIN_EXPOSURE     = "VideoInExposure";   // 曝光设置(对应CFG_VIDEOIN_EXPOSURE_INFO)
	public static String CFG_CMD_ACCESS_GENERAL       = "AccessControlGeneral"; // 门禁基本配置(对应 CFG_ACCESS_GENERAL_INFO)
	public static String CFG_CMD_ACCESS_EVENT         = "AccessControl";        // 门禁事件配置(对应 CFG_ACCESS_EVENT_INFO 数组)     
	public static String CFG_CMD_WIRELESS			 = "Wireless";			// 无线网络连接设置(对应 CFG_WIRELESS_INFO)
	public static String CFG_CMD_ALARMSERVER			 = "AlarmServer";		// 报警服务器配置(对应CFG_ALARMCENTER_INFO)
	public static String CFG_CMD_COMMGLOBAL			 = "CommGlobal";		// 报警全局配置(对应CFG_COMMGLOBAL_INFO)
	public static String CFG_CMD_ANALOGALARM			 = "AnalogAlarm";		// 模拟量报警通道配置(对应CFG_ANALOGALARM_INFO)
	public static String CFG_CMD_ALARMOUT			 = "AlarmOut";			// 报警输出通道配置(对应CFG_ALARMOUT_INFO)
	public static String CFG_CMD_NTP					 = "NTP";				// 时间同步服务器(对应CFG_NTP_INFO)
	public static String CFG_CMD_ALARMBELL			 = "AlarmBell";			// 警号配置(对应CFG_ALARMBELL_INFO)
	public static String CFG_CMD_MOBILE				 = "Mobile";			// 移动相关业务配置(对应CFG_MOBILE_INFO)
	public static String CFG_CMD_PHONEEVENTNOTIFY	 = "PhoneEventNotify";	// (对应CFG_PHONEEVENTNOTIFY_INFO)
	public static String CFG_CMD_PSTN_ALARM_SERVER	 = "PSTNAlarmServer";	// 电话报警中心配置(CFG_PSTN_ALARM_CENTER_INFO)
	public static String CFG_CMD_AUDIO_OUTPUT_VOLUME	 = "AudioOutputVolume";	// 音频输出音量(CFG_AUDIO_OUTPUT_VOLUME)
	public static String CFG_CMD_ALARMKEYBOARD		 = "AlarmKeyboard";		// 报警键盘配置(CFG_ALARMKEYBOARD_INFO)
	public static String CFG_CMD_POWERFAULT			 = "PowerFault";		// 电源故障配置(CFG_POWERFAULT_INFO)
	public static String CFG_CMD_CHASSISINTRUSION	 = "ChassisIntrusion";	// 机箱入侵报警(防拆报警)配置(CFG_CHASSISINTRUSION_INFO)
	public static String CFG_CMD_EXALARMBOX			 = "ExAlarmBox";		// 扩展报警盒配置 (CFG_EXALARMBOX_INFO)
	public static String CFG_CMD_EXALARMOUTPUT		 = "ExAlarmOut";		// 扩展报警输出配置(CFG_EXALARMOUTPUT_INFO)
	public static String CFG_CMD_EXALARMINPUT		 = "ExAlarm";			// 扩展报警输入配置(CFG_EXALARMINPUT_INFO)
	public static String CFG_CMD_ACCESSTIMESCHEDULE	 = "AccessTimeSchedule"; // 门禁刷卡时间段(CFG_ACCESS_TIMESCHEDULE_INFO)
	public static String CFG_CMD_URGENCY				 = "Emergency";			// 紧急事件配置(CFG_URGENCY_INFO)
	public static String CFG_CMD_SENSORSAMPLING		 = "SensorSampling";	// 传感器采样(CFG_SENSORSAMPLING_INFO)
	public static String CFG_CMD_STP					 = "STP";				// 环网配置(CFG_STP_INFO)
	public static String CFG_CMD_ALARM_SUBSYSTEM		 = "AlarmSubSystem";	// 报警子系统配置(CFG_ALARM_SUBSYSTEM_INFO)
	public static String CFG_CMD_BATTERY_LOW_POWER	 = "BatteryLowPowerAlarm";	// 电池电量低配置(CFG_BATTERY_LOW_POWER_INFO)
	public static String CFG_CMD_SNAPLIKAGE           = "SnapLinkage";       // 抓图通道联动外设配置(CFG_SNAPLINKAGE_INFO)
	public static String CFG_CMD_AUDIOINPUT           = "AudioInput";        // 音频输入配置(CFG_AUDIO_INPUT)
	public static String CFG_CMD_EMAIL				 = "Email";				// 邮件发送配置(CFG_EMAIL_INFO)
	public static String CFG_CMD_TRAFFIC_TRANSFER_OFFLINE  = "TrafficTransferOffline";    // 传输离线文件配置(TRAFFIC_TRANSFER_OFFLINE_INFO)
	public static String CFG_CMD_COMMSUBSCRIBE		 = "CommSubscribe";		// 订阅串口数据配置(CFG_DEVCOMM_SUBSCRIBE)
	public static String CFG_CMD_PARKINGSPACE_LIGHT_STATE  = "ParkingSpaceLightState";    // 车位状态对应的车位指示灯(CFG_PARKINGSPACE_LIGHT_STATE)
	public static String CFG_CMD_AIRCONDITION		 = "AirCondition";		// 空调设备配置(CFG_AIRCONDITION_INFO)
	public static String CFG_CMD_COMPRESS_PLAY        = "CompressPlay";      //压缩回放配置(CFG_COMPRESS_PLAY_INFO)
	public static String CFG_CMD_BUILDING             = "Building";          // VTO楼层配置(CFG_BUILDING_INFO)
	public static String CFG_CMD_BUILDING_EXTERNAL    = "BuildingExternal";  // VTO楼层扩展配置(CFG_BUILDING_EXTERNAL_INFO)
	public static String CFG_CMD_DIALRULE             = "DialRule";          // 拨号规则(CFG_DIALRULE_INFO)
	public static String CFG_CMD_OIL_MASS_INFO        = "OilMassInfo";       // 车辆油箱配置(CFG_OIL_MASS_INFO)
	public static String CFG_CMD_FISHEYE_INFO         = "FishEye";           // 鱼眼详细信息配置(CFG_FISHEYE_DETAIL_INFO)
	public static String CFG_CMD_VTNOANSWER_FORWARD   = "VTNoAnswerForward"; // 平台下发呼叫无应答转移配置列表(CFG_VT_NOANSWER_FORWARD_INFO)
	public static String CFG_CMD_VTO_CALL             = "VTOCall";           // VTO呼叫配置(CFG_VTO_CALL_INFO)
	public static String CFG_CMD_MACCONFLICT          = "MacConflict";       // MAC冲突报警配置(CFG_MACCONFLICT_INFO)
	public static String CFG_CMD_IDLEMOTION_INFO      = "IdleMotion";        // 空闲动作配置(CFG_IDLE_MOTION_INFO)
	public static String CFG_CMD_MONITORWALL_COLL_TOUR  = "MonitorWallCollectionTour";   // 电视墙预案轮巡配置(CFG_MONITORWALL_COLLECTION_TOUR_INFO)
	public static String CFG_CMD_PSTN_BREAK_LINE      = "PSTNBreakLine";     // PSTN断线事件配置(CFG_PSTN_BREAK_LINE_INFO)
	public static String CFG_CMD_NET_COLLECTION       = "NetCollection";	    // 网络采集设备配置(CFG_NET_COLLECTION_INFO)
	public static String CFG_CMD_ALARM_SLOT_BOND      = "AlarmSlotBond";     // 虚拟Slot节点与具体物理设备的对应关系(CFG_ALARM_SLOT_BOND_INFO)
	public static String CFG_CMD_TRAFFICSTROBE        = "TrafficStrobe";     // 道闸配置(CFG_TRAFFICSTROBE_INFO)
	public static String CFG_CMD_TRAFFICVOICE         = "TrafficVoiceBroadcast";         // 智能交通语音播报配置(CFG_TRAFFICVOICE_BROADCAST)
	public static String CFG_CMD_STANDING_TIME        = "StandingTime";      // 停车时间配置(CFG_STANDING_TIME_INFO)
	public static String CFG_CMD_ENCLOSURE_TIME_SCHEDULE   = "EnclosureTimeSchedule";     // 电子围栏报警时间段配置(CFG_ENCLOSURE_TIME_SCHEDULE_INFO)
	public static String CFG_CMD_ECKCONFIG			 = "ECKConfig";			// 停车场出入口控制器配置(CFG_ECKCONFIG_INFO)
	public static String CFG_CMD_PARKING_CARD         = "ParkingCard";       // 停车场出入口刷卡报警事件配置(CFG_PARKING_CARD_INFO)
	public static String CFG_CMD_RCEMERGENCY_CALL      = "RCEmergencyCall";  // 紧急呼叫报警事件配置(CFG_RCEMERGENCY_CALL_INFO)
	public static String CFG_CMD_LANES_STATE_REPORT    = "LanesStateReport"; // 车道信息上报配置(CFG_LANES_STATE_REPORT)
	public static String CFG_CMD_OPEN_DOOR_GROUP      = "OpenDoorGroup";     // 多人多开门方式组合配置(CFG_OPEN_DOOR_GROUP_INFO)
	public static String CFG_CMD_OPEN_DOOR_ROUTE      = "OpenDoorRoute";     // 开门路线集合，或称防反潜路线配置(CFG_OPEN_DOOR_ROUTE_INFO)
	public static String CFG_CMD_BURNPLAN             = "BurnPlan";          // 刻录计划配置(对应CFG_BURNPLAN_INFO)
	public static String CFG_CMD_SCADA_DEV            = "SCADADev";          // 检测采集设备配置(CFG_SCADA_DEV_INFO)
	public static String CFG_CMD_VSP_GAYS             = "VSP_GAYS";          // 公安一所平台接入配置(CFG_VSP_GAYS_INFO)
	public static String CFG_CMD_AUDIODETECT          = "AudioDetect";       // 音频检测报警配置(CFG_AUDIO_DETECT_INFO数组)
	public static String CFG_CMD_GUIDESCREEN          = "GuideScreen";       // 诱导屏系统配置(CFG_GUIDESCREEN_INFO)
	public static String CFG_CMD_VTS_CALL_INFO        = "VTSCallInfo";       // VTS呼叫配置(CFG_VTS_CALL_INFO)
	public static String CFG_CMD_DEV_LIST             = "DevList";           // 设备列表配置(CFG_DEV_LIST_INFO)
	public static String CFG_CMD_CALIBRATE_MATRIX     = "CalibrateMatrix";   // 主从式跟踪器标定矩阵配置(CFG_CALIBRATE_MATRIX_INFO)
	public static String CFG_CMD_DEFENCE_AREA_DELAY   = "DefenceAreaDelay";  // 防区延时配置(CFG_DEFENCE_AREA_DELAY_INFO)
	
	/************************************************************************
	 ** 能力集命令  对应CLIENT_QueryNewSystemInfo
	 ***********************************************************************/
	public static String CFG_CAP_CMD_VIDEOANALYSE   =   "devVideoAnalyse.getCaps"   ;   		// 视频分析能力集(对应CFG_CAP_ANALYSE_INFO)
	public static String CFG_NETAPP_REMOTEDEVICE	   =   "netApp.getRemoteDeviceStatus"   ;   	// 获取后端设备的的在线状态(对应CFG_REMOTE_DEVICE_STATUS)
	public static String CFG_CAP_CMD_PRODUCTDEFINITION   =   "magicBox.getProductDefinition"   ;   // 接入设备信息
	public static String CFG_DEVICE_CAP_CMD_VIDEOANALYSE   =   "intelli.getVideoAnalyseDeviceChannels"   ;     // 设备智能分析能力(对应CFG_CAP_DEVICE_ANALYSE_INFO)兼容老设备
	public static String CFG_DEVICE_CAP_NEW_CMD_VIDEOANALYSE   =   "devVideoAnalyse.factory.getCollect"   ;    // 设备智能分析能力(对应CFG_CAP_DEVICE_ANALYSE_INFO)
	public static String CFG_CAP_CMD_CPU_COUNT    =   "magicBox.getCPUCount"   ;                 // 获得CPU个数
	public static String CFG_CAP_CMD_CPU_USAGE    =   "magicBox.getCPUUsage"   ;                 // 获取CPU占用率
	public static String CFG_CAP_CMD_MEMORY_INFO    =   "magicBox.getMemoryInfo"   ;             // 获得内存容量
	public static String CFG_CAP_CMD_DEVICE_STATE   =   "trafficSnap.getDeviceStatus"   ;        // 获取设备状态信息 (对应CFG_CAP_TRAFFIC_DEVICE_STATUS)
	public static String CFG_CAP_CMD_VIDEOINPUT   =   "devVideoInput.getCaps"   ;                // 视频输入能力集(对应CFG_CAP_VIDEOINPUT_INFO)
	public static String CFG_USERMANAGER_ACTIVEUSER      =   "userManager.getActiveUserInfoAll"   ;        // 得到所有活动的用户信息(对应CFG_ACTIVEUSER_INFO)
	public static String CFG_CAP_VIDEOSTAT_SUMMARY       =   "videoStatServer.getSummary"   ;              // 获取视频统计摘要信息(对应CFG_VIDEOSATA_SUMMARY_INFO)
	public static String CFG_CAP_CMD_VIDEODIAGNOSIS_SERVER   =   "videoDiagnosisServer.getCaps"   ;   		// 获取视频诊断服务能力(CFG_VIDEODIAGNOSIS_CAPS_INFO)
	public static String CFG_CMD_VIDEODIAGNOSIS_GETCOLLECT            =   "videoDiagnosisServer.factory.getCollect"   ;               // 获取视频诊断通道数目(CFG_VIDEODIAGNOSIS_GETCOLLECT_INFO)
	public static String CFG_CMD_VIDEODIAGNOSIS_GETSTATE              =   "videoDiagnosisServer.getState"   ;                         // 获取视频诊断进行状态(CFG_VIDEODIAGNOSIS_STATE_INFO)
	public static String CFG_CAP_CMD_SERVICE_LIST                     =   "system.listService"   ;          //获取服务器上支持的服务列表(CFG_DEV_SERVICE_LIST)
	public static String CFG_CAP_CMD_EVENTHANDLER      =   "capsManager.get&EventManagerEventHandler"   ;         // 获取服务器报警联动能力集(CFG_CAP_EVENTHANDLER_INFO)
	public static String CFG_CAP_ALARM                 =   "alarm.getAlarmCaps"   ;                               // 获取报警能力集(CFG_CAP_ALARM_INFO)
	public static String CFG_CAP_CMD_AUDIO_ANALYSE     =   "devAudioAnalyse.getCaps"   ;                          // 获取音频分析能力集(CFG_CAP_AUDIO_ANALYSE_INFO)
	public static String CFG_CMD_MASTERSLAVE_GETCOLLECT          =   "masterSlaveTracker.factory.getCollect"   ;      // 获取主从式跟踪器通道数目(对应结构体CFG_MASTERSLAVETRACKER_INFO)
	public static String CFG_CAP_CMD_MASTERSLAVE                 =   "capsManager.get&MasterSlaveTracker"   ;         // 获取主从式设备能力集(CFG_CAP_MASTERSLAVE_INFO)
	public static String CFG_CAP_CMD_FOCUS_STATE	   =   "devVideoInput.getFocusStatus"   ;   					// 获取镜头聚焦状态信息 (对应CFG_CAP_FOCUS_STATUS)
	public static String CFG_CAP_CMD_NETAPP            =   "netApp.getCaps"   ;                                      // 获取网络应用能力集(对应CFG_CAP_NETAPP)
	public static String CFG_CAP_CMD_PTZ_ENABLE     =   "ptz.factory.instance"   ;   				// 获取云台支持信息(CFG_CAP_PTZ_ENABLEINFO )
	public static String CFG_CAP_CMD_RECORD		   =   "recordManager.getCaps"   ;                   // 获取录像能力集(CFG_CAP_RECORD_INFO)
	public static String CFG_CAP_CMD_BURN_MANAGER      =   "BurnManager.getCaps"   ;                     // 获取刻录管理能力集( CFG_CAP_BURN_MANAGER)
	public static String CFG_CAP_CMD_PTZ     	   =   "ptz.getCurrentProtocolCaps"   ;   		// 获取云台能力集(CFG_PTZ_PROTOCOL_CAPS_INFO)
	public static String CFG_CMD_ENCODE_GETCAPS        =   "encode.getCaps"   ;                          // 获取编码能力集(CFG_ENCODECAP)
	public static String CFG_CAP_CMD_VIDEOINPUT_EX     =   "devVideoInput.getCapsEx"   ;                 // 视频输入能力集扩展(对应CFG_CAP_VIDEOINPUT_INFO_EX)
	public static String CFG_CAP_CMD_ANALYSE_MODE      =   "intelli.getCaps.AnalyseMode"   ;             // 获取设备智能分析模式(对应 CFG_ANALYSE_MODE)
	public static String CFG_CAP_CMD_EVENTMANAGER      =   "eventManager.getCaps"   ;   		// 获取设备报警联动能力,老协议已废除,新开发请使用该字段(CFG_CAP_EVENTMANAGER_INFO)
	public static String CFG_CAP_CMD_FILEMANAGER	   =   "FileManager.getCaps"   ;   		// 获取文件能力(CFG_CAP_FILEMANAGER)
	public static String	CFG_CAP_CMD_LOG			   =   "log.getCaps"   ;   				// 获取日志服务能力(CFG_CAP_LOG)
	public static String CFG_CAP_CMD_SPEAK		   =   "speak.getCaps"   ;   				// 扬声器播放能力(CFG_CAP_SPEAK)
	public static String CFG_CAP_CMD_ACCESSCONTROLMANAGER   =   "accessControlManager.getCaps"   ;   // 门禁能力(CFG_CAP_ACCESSCONTROL)
	public static String CFG_CAP_CMD_EXALARM		   =   "alarm.getExAlarmCaps"   ;   				// 获取扩展报警能力集, (对应结构体 CFG_CAP_EXALARM_INFO)
	public static String CFG_CAP_CMD_EXALARMBOX	   =   "alarm.getExAlarmBoxCaps"   ;   			// 获取扩展报警盒能力集, (对应结构体 CFG_CAP_EXALARMBOX_INFO)
	public static String CFG_CAP_CMD_RECORDFINDER   =   "RecordFinder.getCaps"   ;   				// 获取查询记录能力集, (对应结构体 CFG_CAP_RECORDFINDER_INFO)
	public static String CFG_CAP_CMD_ANALOGALARM	   =   "AnalogAlarm.getCaps"   ;   		// 模拟量报警输入通道能力(对应结构体 CFG_CAP_ANALOGALARM)
	public static String CFG_CAP_CMD_LOWRATEWPAN	   =   "LowRateWPAN.getCaps"   ;   		// 获取LowRateWPAN能力(对应的结构体 CFG_CAP_LOWRATEWPAN)
		
  	/**
	 * \if ENGLISH_LANG
	 * Max length of backup file name
	 * \else
	 * 最大备份名称长度	
	 * \endif
	 */
	public static final int SDK_MAX_BACKUP_NAME = 32;			
	
	/**
	 * \if ENGLISH_LANG
	 * Max number of backup file 
	 * \else
	 * 最大备份文件个数	
	 * \endif
	 */
	public static final int SDK_MAX_BACKUPRECORD_NUM = 1024;	
	
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 最大CAN个数
	 * \endif
	 */
	public static final int MAX_CAN_COUNT = 16;
	
	
	/**
	 * \if ENGLISH_LANG
	 * Max length of audio file path 
	 * \else
	 * 最大音频文件路长度	
	 * \endif
	 */	
	public static final int SDK_MAX_AUDIO_PATH_1 = 260;			//最大音频文件路长度
	
	public static final int NET_MAX_FRAMESEQUENCE_NUM     = 2;
	public static final int NET_MAX_TIMESTAMP_NUM         = 2;
	
	/* MAC过滤配置 */
	public static final int SDK_MACFILTER_NUM             = 512;             // MAC
	
	/* MAC,IP过滤配置 */
	public static final int SDK_MACIPFILTER_NUM           = 512;            // MAC,IP
	
	public static final int ARM_DISARM_ZONE_MAX           = 256;            // 防区最大个数
	
	public static final int NET_DEV_CAP_SEQPOWER            = 0x01;                // 电源时序器能力, pInBuf=NET_IN_CAP_SEQPOWER*, pOutBuf=NET_OUT_CAP_SEQPOWER*
	public static final int NET_ENCODE_CFG_CAPS             = 0x02;                // 设备编码配置对应能力, pInBuf=NET_IN_ENCODE_CFG_CAPS*, pOutBuf= NET_OUT_ENCODE_CFG_CAPS*
	public static final int NET_VIDEOIN_FISHEYE_CAPS        = 0x03;                // 鱼眼能力, pInBuf=NET_IN_VIDEOIN_FISHEYE_CAPS*, pOutBuf=NET_OUT_VIDEOIN_FISHEYE_CAPS*
	
	// 设备信息类型，对应CLIENT_QueryDevInfo接口
	public static final int  NET_QUERY_DEV_STORAGE_NAMES            = 0x01;                // 查询设备的存储模块名列表 , pInBuf=NET_IN_STORAGE_DEV_NAMES *, pOutBuf=NET_OUT_STORAGE_DEV_NAMES *
	public static final int  NET_QUERY_DEV_STORAGE_INFOS            = 0x02;                // 查询设备的存储模块信息列表, pInBuf=NET_IN_STORAGE_DEV_INFOS*, pOutBuf= NET_OUT_STORAGE_DEV_INFOS *
	public static final int  NET_QUERY_RECENCY_JNNCTION_CAR_INFO    = 0x03;                // 查询最近的卡口车辆信息接口, pInBuf=NET_IN_GET_RECENCY_JUNCTION_CAR_INFO*, pOutBuf=NET_OUT_GET_RECENCY_JUNCTION_CAR_INFO*
	public static final int  NET_QUERY_LANES_STATE                  = 0x04;                // 查询车道信息,pInBuf = NET_IN_GET_LANES_STATE , pOutBuf = NET_OUT_GET_LANES_STATE
	public static final int  NET_QUERY_DEV_FISHEYE_WININFO          = 0x05;                // 查询鱼眼窗口信息 , pInBuf= NET_IN_FISHEYE_WININFO*, pOutBuf=NET_OUT_FISHEYE_WININFO *
	public static final int  NET_QUERY_DEV_REMOTE_DEVICE_INFO       = 0x06;                // 查询远程设备信息 , pInBuf= NET_IN_GET_DEVICE_INFO*, pOutBuf= NET_OUT_GET_DEVICE_INFO *
	public static final int  NET_QUERY_DEV_REMOTE_DEVICE_INFO_ALL   = 0x07;                // 查询所有远程设备信息 , pInBuf= NET_IN_GET_DEVICE_INFO_ALL*, pOutBuf= NET_OUT_GET_DEVICE_INFO_ALL *

	public static final int  MAX_LOG_PATH_LEN             = 260;                // 日志路径名最大长度
	
	public static final int   MAX_REGISTER_ID_LEN        = (256);
	public static final int   MAX_APP_ID_LEN             = (256);
	public static final int   MAX_URL_LEN                = (1024);
	public static final int   MAX_IOS_CERTIFICATE_LEN     = (1024 * 14);
	public static final int   MAX_IOS_SECRET_KEY_LEN      = (512);
	public static final int   MAX_MOBILE_CHANNEL_NUM      = (256);
	
	public static final int  MAX_GOURP_NUM               =  128 ;             //人脸库最大个数
	
	// 编码模式列表，用于与编码模式掩码进行与、或操作
	public static final int SDK_CAPTURE_COMP_DIVX_MPEG4        = 0x00000001;
	public static final int SDK_CAPTURE_COMP_MS_MPEG4          = 0x00000002;
	public static final int SDK_CAPTURE_COMP_MPEG2             = 0x00000004;
	public static final int SDK_CAPTURE_COMP_MPEG1             = 0x00000008;
	public static final int SDK_CAPTURE_COMP_H263              = 0x00000010;
	public static final int SDK_CAPTURE_COMP_MJPG              = 0x00000020;
	public static final int SDK_CAPTURE_COMP_FCC_MPEG4         = 0x00000040;
	public static final int SDK_CAPTURE_COMP_H264              = 0x00000080;
	public static final int SDK_CAPTURE_COMP_H265              = 0x00000100;
}

