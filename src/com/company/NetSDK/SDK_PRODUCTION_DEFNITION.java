package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Production definition
 * \else
 * 产品定义
 * \endif
 */
public class SDK_PRODUCTION_DEFNITION implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Video input channel amount
	 * \else
	 * 视频输入通道数
	 * \endif
	 */
	public int					nVideoInChannel;				
	/**
	 * \if ENGLISH_LANG
	 * Video output channel amount
	 * \else
	 * 视频输出通道数
	 * \endif
	 */
	public int					nVideoOutChannel;			
	/**
	 * \if ENGLISH_LANG
	 * Remote decode channel amount
	 * \else
	 * 远程解码通道数
	 * \endif
	 */
	public int					nRemoteDecChannel;			
	/**
	 * \if ENGLISH_LANG
	 * Device type
	 * \else
	 * 设备类型
	 * \endif
	 */
	public char				szDevType[] = new char[FinalVar.SDK_DEV_TYPE_LEN];		
	/**
	 * \if ENGLISH_LANG
	 * OEM customer
	 * \else
	 * OEM客户
	 * \endif
	 */
	public char				szVendor[] = new char[FinalVar.SDK_MAX_NAME_LEN];		
	/**
	 * \if ENGLISH_LANG
	 * OEM version
	 * \else
	 * OEM版本
	 * \endif
	 */
	public int					nOEMVersion;					
	/**
	 * \if ENGLISH_LANG
	 * Main version No.
	 * \else
	 * 主版本号
	 * \endif
	 */
	public int					nMajorVerion;					
	/**
	 * \if ENGLISH_LANG
	 * SUb version No.
	 * \else
	 * 次版本号
	 * \endif
	 */
	public int					nMinorVersion;					
	/**
	 * \if ENGLISH_LANG
	 * Revision version
	 * \else
	 * 修订版本
	 * \endif
	 */
	public int					nRevision;						
	/**
	 * \if ENGLISH_LANG
	 * Web version
	 * \else
	 * Web版本
	 * \endif
	 */
	public char				szWebVerion[] = new char[FinalVar.SDK_MAX_NAME_LEN];	
	/**
	 * \if ENGLISH_LANG
	 * Default setup
	 * \else
	 * 默认语言
	 * \endif
	 */
	public char				szDefLanguage[] = new char[FinalVar.SDK_MAX_NAME_LEN];	
	/**
	 * \if ENGLISH_LANG
	 * Release time. Unit is second.
	 * \else
	 * 发布时间, 精确到秒
	 * \endif
	 */
	public NET_TIME			stuBuildDateTime = new NET_TIME();				
	/**
	 * \if ENGLISH_LANG
	 * Audio input channel amount
	 * \else
	 * 音频输入通道数
	 * \endif
	 */
	public int					nAudioInChannel;				
	/**
	 * \if ENGLISH_LANG
	 * Audio output channel amount
	 * \else
	 * 音频输出通道数
	 * \endif
	 */
	public int					nAudioOutChannel;				 
	/**
	 * \if ENGLISH_LANG
	 * Support schedule storage or not.
	 * \else
	 * 是否支持定时存储
	 * \endif
	 */
	public boolean				bGeneralRecord;					
	/**
	 * \if ENGLISH_LANG
	 * Support local storage or not.
	 * \else
	 * 是否支持本地存储
	 * \endif
	 */
	public boolean				bLocalStore;					
	/**
	 * \if ENGLISH_LANG
	 * Support network storage or not.
	 * \else
	 * 是否支持网络存储
	 * \endif
	 */
	public boolean				bRemoteStore;					
	/**
	 * \if ENGLISH_LANG
	 * Support emergency local storage or not.
	 * \else
	 * 是否支持紧急存储到本地
	 * \endif
	 */
	public boolean				bLocalurgentStore;				
	/**
	 * \if ENGLISH_LANG
	 * Support real-time compression storage or not.
	 * \else
	 * 是否支持实时压缩存储
	 * \endif
	 */
	public boolean				bRealtimeCompress;				
	/**
	 * \if ENGLISH_LANG
	 * The video format supported. bit0-PAL, bit1-NTSC
	 * \else
	 * 支持的视频制式列表, bit0-PAL, bit1-NTSC
	 * \endif
	 */
	public int					dwVideoStandards;				
	/**
	 * \if ENGLISH_LANG
	 * Default video format, 0-PAL, 1-NTSC
	 * \else
	 * 端默认视频制式, 0-PAL, 1-NTSC
	 * \endif
	 */
	public int					nDefVideoStandard;				
	/**
	 * \if ENGLISH_LANG
	 * Max extra stream channel amount
	 * \else
	 * 最大辅码流路数
	 * \endif
	 */
	public int					nMaxExtraStream;				
	/**
	 * \if ENGLISH_LANG
	 * Remote record channel amount
	 * \else
	 * 远程录像通道数
	 * \endif
	 */
	public int					nRemoteRecordChannel;			
	/**
	 * \if ENGLISH_LANG
	 * Remote snap channel amount
	 * \else
	 * 远程抓图通道数
	 * \endif
	 */
	public int					nRemoteSnapChannel;				
	/**
	 * \if ENGLISH_LANG
	 * Remote video analysis channel amount
	 * \else
	 * 远程视频分析通道数
	 * \endif
	 */
	public int					nRemoteVideoAnalyseChannel;		
	/**
	 * \if ENGLISH_LANG
	 * Remote real-time stream transmit max channel amount
	 * \else
	 * 远程实时流转发最大通道数
	 * \endif
	 */
	public int					nRemoteTransmitChannel;			
	/**
	 * \if ENGLISH_LANG
	 * Remote transmit file channel amount
	 * \else
	 * 远程文件流竹筏通道通道数
	 * \endif
	 */
	public int					nRemoteTransmitFileChannel;		
	/**
	 * \if ENGLISH_LANG
	 * Max network transmit channel amount
	 * \else
	 * 最大网络传输通道总数
	 * \endif
	 */
	public int					nStreamTransmitChannel;			
	/**
	 * \if ENGLISH_LANG
	 * Max read file channel amount
	 * \else
	 * 最大读文件流通道总数
	 * \endif
	 */
	public int					nStreamReadChannel;				
	/**
	 * \if ENGLISH_LANG
	 * Max bit stream network send capability, kbps
	 * \else
	 * 最大码流网络发送能力, kbps
	 * \endif
	 */
	public int					nMaxStreamSendBitrate;			
	/**
	 * \if ENGLISH_LANG
	 * Max bit stream network interface capability, kbps
	 * \else
	 * 最大码流网络接口能力, kbps
	 * \endif
	 */
	public int					nMaxStreamRecvBitrate;			
	/**
	 * \if ENGLISH_LANG
	 * Old compression file or not. Delete P frame and save I frame.
	 * \else
	 * 是否压缩旧文件, 去除P帧, 保留I帧
	 * \endif
	 */
	public boolean				bCompressOldFile;				
	/**
	 * \if ENGLISH_LANG
	 * Support RAID or not.
	 * \else
	 * 是否支持RAID
	 * \endif
	 */
	public boolean				bRaid;							
	/**
	 * \if ENGLISH_LANG
	 * Max pre-record time.Unit is second.
	 * \else
	 * 最大预录时间, s
	 * \endif
	 */
	public int					nMaxPreRecordTime;				
	/**
	 * \if ENGLISH_LANG
	 * Support PTZ alarm or not.
	 * \else
	 * 是否支持云台报警
	 * \endif
	 */
	public boolean				bPtzAlarm;						
	/**
	 * \if ENGLISH_LANG
	 * Support PTZ or not.
	 * \else
	 * 是否支持云台
	 * \endif
	 */
	public boolean				bPtz;							
	/**
	 * \if ENGLISH_LANG
	 * Support corresponding function of the ATM or not.
	 * \else
	 * 是否显示ATM相关功能
	 * \endif
	 */
	public boolean				bATM;							
	/**
	 * \if ENGLISH_LANG
	 * Support 3G module or not.
	 * \else
	 * 是否支持3G模块
	 * \endif
	 */
	public boolean				b3G;							
	/**
	 * \if ENGLISH_LANG
	 * With number button or not.
	 * \else
	 * 是否带数字键
	 * \endif
	 */
	public boolean				bNumericKey;					
	/**
	 * \if ENGLISH_LANG
	 * With Shift button or not.
	 * \else
	 * 是否带Shift键
	 * \endif
	 */
	public boolean				bShiftKey;						
	/**
	 * \if ENGLISH_LANG
	 * Number character map sheet is right or not.
	 * \else
	 * 数字字母映射表是否正确
	 * \endif
	 */
	public boolean				bCorrectKeyMap;					
	/**
	 * \if ENGLISH_LANG
	 * The new 2nd ATM front panel.
	 * \else
	 * 新的二代ATM前面板
	 * \endif
	 */
	public boolean				bNewATM;						
	/**
	 * \if ENGLISH_LANG
	 * Decoder or not
	 * 是否是解码器
	 * \endif
	 */
	public boolean				bDecoder;						
	/**
	 * \if ENGLISH_LANG
	 * Decoder info. Valid when bDecoder=true.bDecoder=true
	 * \else
	 * 解码器信息, bDecoder=true时有效
	 * \endif
	 */
	public DEV_DECODER_INFO		stuDecoderInfo = new DEV_DECODER_INFO();					
	/**
	 * \if ENGLISH_LANG
	 * Integration ceiling screen output channel
	 * \else
	 * 融合屏输出通道上限
	 * \endif
	 */
	public int					nVideoOutputCompositeChannels;	
	/**
	 * \if ENGLISH_LANG
	 * Support WPS or not
	 * \else
	 * 是否支持WPS功能
	 * \endif
	 */
	public boolean                bSupportedWPS;                  
	/**
	 * \if ENGLISH_LANG
	 * VGA video output channel number
	 * \else
	 * VGA视频输出通道数
	 * \endif
	 */
	public int					nVGAVideoOutputChannels;		
	/**
	 * \if ENGLISH_LANG
	 * TV video output channel number
	 * \else
	 * TV视频输出通道数
	 * \endif
	 */
	public int					nTVVideoOutputChannels;			
	/**
	 * \if ENGLISH_LANG
	 * Max number of remote channels
	 * \else
	 * 最大远程通道数
	 * \endif
	 */
	public int					nMaxRemoteInputChannels;		
	/**
	 * \if ENGLISH_LANG
	 * Max number of matrix channels
	 * \else
	 * 最大矩阵通道数
	 * \endif
	 */
	public int					nMaxMatrixInputChannels;		
	/**
	 * \if ENGLISH_LANG
	 * Max counts of road ways 1~6
	 * \else
	 * 智能交通最大车道数 1~6
	 * \endif
	 */
	public int                 nMaxRoadWays;                  
	/**
	 * \if ENGLISH_LANG
	 * Max counts of screen when docking with the camera 0~20
	 * \else
	 * 和相机对接最多支持的区域屏个数 0~20
	 * \endif
	 */
	public int                 nMaxParkingSpaceScreen;         
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 云台水平最小角度, [0-360]
	 * \endif
	 */
	public int					nPtzHorizontalAngleMin;			
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 云台水平最大角度, [0-360]
	 * \endif
	 */
	public int					nPtzHorizontalAngleMax;			
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 云台垂直最小角度, [-90,90]
	 * \endif
	 */
	public int					nPtzVerticalAngleMin;			
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 云台垂直最大角度, [-90,90]
	 * \endif
	 */
	public int					nPtzVerticalAngleMax;			
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 是否支持云台功能菜单
	 * \endif
	 */
	public boolean				bPtzFunctionMenu;				
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 是否支持灯光控制
	 * \endif
	 */
	public boolean				bLightingControl;				
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 手动灯光控制模式, 按位, 见NET_LIGHTING_CTRL_ON_OFF
	 * \endif
	 */
	public int				dwLightingControlMode;			
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 近光灯组数量, 0表示不支持
	 * \endif
	 */
	public int					nNearLightNumber;				
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 远光灯组数量, 0表示不支持
	 * \endif
	 */
	public int					nFarLightNumber;				
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 是否支持控制聚焦
	 * \endif
	 */
	public boolean				bFocus;							
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 是否支持控制光圈
	 * \endif
	 */
	public boolean				bIris;							
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 云台支持的协议列表, 可以是多个, 每个用';'分隔
	 * \endif
	 */
	public char				szPtzProtocolList[] = new char[FinalVar.SDK_COMMON_STRING_1024];	
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 是否支持雨刷控制
	 * \endif
	 */
	public boolean				bRainBrushControl;				
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 雨刷数量, 为0时表示不支持
	 * \endif
	 */
	public int					nBrushNumber;					
}

