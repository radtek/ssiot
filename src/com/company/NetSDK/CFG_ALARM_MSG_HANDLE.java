package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Alarm Linkage Structure
 * \else
 * 报警联动信息
 * \endif
 */
public class CFG_ALARM_MSG_HANDLE implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * \if ENGLISH_LANG
	 * handling ability 
	 * \else
	 * 能力
	 * \endif
	 */
	
	public boolean				abRecordMask;
	public boolean				abRecordEnable;
	public boolean				abRecordLatch;
	public boolean				abAlarmOutMask;
	public boolean				abAlarmOutEn;
	public boolean				abAlarmOutLatch;	
	public boolean				abExAlarmOutMask;
	public boolean				abExAlarmOutEn;
	public boolean				abPtzLinkEn;
	public boolean				abTourMask;
	public boolean				abTourEnable;
	public boolean				abSnapshot;
	public boolean				abSnapshotEn;
	public boolean				abSnapshotPeriod;
	public boolean				abSnapshotTimes;
	public boolean				abTipEnable;
	public boolean				abMailEnable;
	public boolean				abMessageEnable;
	public boolean				abBeepEnable;
	public boolean				abVoiceEnable;
	public boolean				abMatrixMask;
	public boolean				abMatrixEnable;
	public boolean				abEventLatch;
	public boolean				abLogEnable;
	public boolean				abDelay;
	public boolean				abVideoMessageEn;
	public boolean				abMMSEnable;
	public boolean				abMessageToNetEn;
	public boolean				abTourSplit;
	public boolean				abSnapshotTitleEn;

	public boolean                abChannelCount;
	public boolean                abAlarmOutCount;
	public boolean                abPtzLinkEx;
	public boolean                abSnapshotTitle;
	public boolean                abMailDetail;
	public boolean                abVideoTitleEn;
	public boolean                abVideoTitle;
	public boolean                abTour;
	public boolean                abDBKeys;
	public boolean                abJpegSummary;
	public boolean                abFlashEn;
	public boolean                abFlashLatch;
	

	/**
	 * \if ENGLISH_LANG
	 * Device Video Channel Count
	 * \else
	 * 设备的视频通道数
	 * \endif
	 */
	public int					nChannelCount;
	
	/**
	 * \if ENGLISH_LANG
	 * Device Alarm Output Count 
	 * \else
	 * 设备的报警输出个数
	 * \endif
	 */
	public int					nAlarmOutCount;
	
	/**
	 * \if ENGLISH_LANG
	 * Record Channl Mask(By Bits)
	 * \else
	 * 录像通道掩码(按位)
	 * \endif
	 */
	public int					dwRecordMask[] = new int[FinalVar.MAX_CHANNEL_COUNT];
	
	/**
	 * \if ENGLISH_LANG
	 * Record Enable
	 * \else
	 * 录像使能
	 * \endif
	 */
	public boolean				bRecordEnable;
	
	/**
	 * \if ENGLISH_LANG
	 * Record Delay Time(Second) 
	 * \else
	 * 录像延时时间(秒)
	 * \endif
	 */
	public int					nRecordLatch;
	
	/**
	 * \if ENGLISH_LANG
	 * Alarm Output Channel Mask 
	 * \else
	 * 报警输出通道掩码
	 * \endif
	 */
	public int					dwAlarmOutMask[] = new int[FinalVar.MAX_CHANNEL_COUNT];
	
	/**
	 * \if ENGLISH_LANG
	 * Record Output Enable 
	 * \else
	 * 报警输出使能
	 * \endif
	 */
	public boolean				bAlarmOutEn;
	
	/**
	 * \if ENGLISH_LANG
	 * Alarm Output Delay Time(Time)
	 * \else
	 * 报警输出延时时间(秒)
	 * \endif
	 */
	public int					nAlarmOutLatch;
	
	/**
	 * \if ENGLISH_LANG
	 * External Alarm Output Channel Mask 
	 * \else
	 * 扩展报警输出通道掩码
	 * \endif
	 */
	public int					dwExAlarmOutMask[] = new int[FinalVar.MAX_CHANNEL_COUNT];
	
	/**
	 * \if ENGLISH_LANG
	 * External Alarm Output Enable 
	 * \else
	 * 扩展报警输出使能
	 * \endif
	 */
	public boolean				bExAlarmOutEn;
	
	/**
	 * \if ENGLISH_LANG
	 * PTZ Linkage 
	 * \else
	 * 云台联动项
	 * \endif
	 */
	CFG_PTZ_LINK				stuPtzLink[] = new CFG_PTZ_LINK[FinalVar.MAX_VIDEO_CHANNEL_NUM];
	
	/**
	 * \if ENGLISH_LANG
	 * PTZ Linkage Enable 
	 * \else
	 * 云台联动使能
	 * \endif
	 */
	public boolean				bPtzLinkEn;
	
	/**
	 * \if ENGLISH_LANG
	 * Tour Channel Mask 
	 * \else
	 * 轮询通道掩码
	 * \endif
	 */
	public int					dwTourMask[] = new int[FinalVar.MAX_CHANNEL_COUNT];
	
	/**
	 * \if ENGLISH_LANG
	 * Tour Enable 
	 * \else
	 * 轮询使能
	 * \endif
	 */
	public boolean				bTourEnable;
	
	/**
	 * \if ENGLISH_LANG
	 * Snapshot Channel No. Mask 
	 * \else
	 * 快照通道号掩码
	 * \endif
	 */
	public int					dwSnapshot[] = new int[FinalVar.MAX_CHANNEL_COUNT];
	
	/**
	 * \if ENGLISH_LANG
	 * Snapshot Enable 
	 * \else
	 * 快照使能
	 * \endif
	 */
	public boolean				bSnapshotEn;
	
	/**
	 * \if ENGLISH_LANG
	 * Snapshot Period(Second) 
	 * \else
	 * 连拍周期(秒)
	 * \endif
	 */
	public int					nSnapshotPeriod;
	
	/**
	 * \if ENGLISH_LANG
	 * Snapshot Times 	
	 * \else
	 * 连拍次数
	 * \endif
	 */
	public int					nSnapshotTimes;
	
	/**
	 * \if ENGLISH_LANG
	 * Local News Prompt 
	 * \else
	 * 本地消息框提示
	 * \endif
	 */
	public boolean				bTipEnable;
	
	/**
	 * \if ENGLISH_LANG
	 * Send Email，Picture As Attach 
	 * \else
	 * 发送邮件，如果有图片，作为附件
	 * \endif
	 */
	public boolean				bMailEnable;
	
	/**
	 * \if ENGLISH_LANG
	 * Upload to Alarm Server 
	 * \else
	 * 上传到报警服务器
	 * \endif
	 */
	public boolean				bMessageEnable;
	
	/**
	 * \if ENGLISH_LANG
	 * Beep 
	 * \else
	 * 蜂鸣
	 * \endif
	 */
	public boolean				bBeepEnable;
	
	/**
	 * \if ENGLISH_LANG
	 * Voice Prompt 
	 * \else
	 * 语音提示
	 * \endif
	 */
	public boolean				bVoiceEnable;
	
	/**
	 * \if ENGLISH_LANG
	 * Linkage Video Matrix Channel Mask 
	 * \else
	 * 联动视频矩阵通道掩码
	 * \endif
	 */
	public int					dwMatrixMask[] = new int[FinalVar.MAX_CHANNEL_COUNT];
	
	/**
	 * \if ENGLISH_LANG
	 * Linkage Video Matrix 
	 * \else
	 * 联动视频矩阵
	 * \endif
	 */
	public boolean				bMatrixEnable;
	
	/**
	 * \if ENGLISH_LANG
	 * Linkage Start Delay Time，s is the Unit 0-15 
	 * \else
	 * 联动开始延时时间(秒)，0－15
	 * \endif
	 */
	public int					nEventLatch;
	
	/**
	 * \if ENGLISH_LANG
	 * If Record Log 
	 * \else
	 * 是否记录日志
	 * \endif
	 */
	public boolean				bLogEnable;
	
	/**
	 * \if ENGLISH_LANG
	 * Delay Then Take Effect When Setting，Unit is Second 
	 * \else
	 * 设置时先延时再生效，单位为秒
	 * \endif
	 */
	public int					nDelay;
	
	/**
	 * \if ENGLISH_LANG
	 * Overlay Tip Tile To Video。Overlay Tile Includes Event Type，Channel No.，Count By Second
	 * \else
	 * 叠加提示字幕到视频。叠加的字幕包括事件类型，通道号，秒计时。
	 * \endif
	 */
	public boolean				bVideoMessageEn;
	
	/**
	 * \if ENGLISH_LANG
	 * MMS Enable 
	 * \else
	 * 发送彩信使能
	 * \endif
	 */
	public boolean				bMMSEnable;
	
	/**
	 * \if ENGLISH_LANG
	 * Message Send To Network Enable
	 * \else
	 * 消息上传给网络使能
	 * \endif
	 */
	public boolean				bMessageToNetEn;
	
	/**
	 * \if ENGLISH_LANG
	 * Touring Split Mode 0: 1 Picture; 1: 8Picture 
	 * \else
	 * 轮巡时的分割模式 0: 1画面; 1: 8画面
	 * \endif
	 */
	public int					nTourSplit;
	
	/**
	 * \if ENGLISH_LANG
	 * If Overlay Snapshot Title 
	 * \else
	 * 是否叠加图片标题
	 * \endif
	 */
	public boolean				bSnapshotTitleEn;
	
	/**
	 * \if ENGLISH_LANG
	 * PTZ config 
	 * \else
	 * 云台配置数
	 * \endif
	 */
	public int                  nPtzLinkExNum;
	
	/**
	 * \if ENGLISH_LANG
	 * Extension PTZ 
	 * \else
	 * 扩展云台信息
	 * \endif
	 */
	CFG_PTZ_LINK_EX     		stuPtzLinkEx[] = new CFG_PTZ_LINK_EX[FinalVar.MAX_VIDEO_CHANNEL_NUM];
	
	/**
	 * \if ENGLISH_LANG
	 * Picture title content no.
	 * \else
	 * 图片标题内容数
	 * \endif
	 */
	public int                  nSnapTitleNum;
	
	/**
	 * \if ENGLISH_LANG
	 * Picture title content 
	 * \else
	 * 图片标题内容
	 * \endif
	 */
	CFG_EVENT_TITLE     		stuSnapshotTitle[] = new CFG_EVENT_TITLE[FinalVar.MAX_VIDEO_CHANNEL_NUM];
	
	/**
	 * \if ENGLISH_LANG
	 * email detail 
	 * \else
	 * 邮件详细内容
	 * \endif
	 */
	CFG_MAIL_DETAIL     		stuMailDetail = new CFG_MAIL_DETAIL();
	
	/**
	 * \if ENGLISH_LANG
	 * overlay video title or not, for main stream 
	 * \else
	 * 是否叠加视频标题，主要指主码流
	 * \endif
	 */
	public boolean              bVideoTitleEn;
	
	/**
	 * \if ENGLISH_LANG
	 * video title content no. 
	 * \else
	 * 视频标题内容数目
	 * \endif
	 */
	public int                  nVideoTitleNum;
	
	/**
	 * \if ENGLISH_LANG
	 * video title content 
	 * \else
	 * 视频标题内容
	 * \endif
	 */
	CFG_EVENT_TITLE     		stuVideoTitle[] = new CFG_EVENT_TITLE[FinalVar.MAX_VIDEO_CHANNEL_NUM];
	
	/**
	 * \if ENGLISH_LANG
	 * tour activation number 
	 * \else
	 * 轮询联动数目
	 * \endif
	 */
	public int                  nTourNum;
	
	/**
	 * \if ENGLISH_LANG
	 * tour avtivation config 
	 * \else
	 * 轮询联动配置
	 * \endif
	 */
	CFG_TOURLINK        		stuTour[] = new CFG_TOURLINK[FinalVar.MAX_VIDEO_CHANNEL_NUM];
	
	/**
	 * \if ENGLISH_LANG
	 * specify data library releted no. 
	 * \else
	 * 指定数据库关键字的有效数
	 * \endif
	 */
	public int                  nDBKeysNum;
	
	/**
	 * \if ENGLISH_LANG
	 * specify event detail needed data library key 
	 * \else
	 * 指定事件详细信息里需要写到数据库的关键字
	 * \endif
	 */
	public char                 szDBKeys[][] = new char[FinalVar.MAX_DBKEY_NUM][FinalVar.MAX_CHANNELNAME_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * overlay to JPEG summary 
	 * \else
	 * 叠加到JPEG图片的摘要信息
	 * \endif
	 */
	public byte                 byJpegSummary[] = new byte[FinalVar.MAX_SUMMARY_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * compensate light or not 
	 * \else
	 * 是否使能补光灯
	 * \endif
	 */
	public boolean              bFlashEnable;
	
	/**
	 * \if ENGLISH_LANG
	 * light compensation delay(s), delay range：[10,300] 
	 * \else
	 * 补光灯延时时间(秒),延时时间范围：[10,300]
	 * \endif
	 */
	public int                  nFlashLatch;
	
	public CFG_ALARM_MSG_HANDLE() {
		for (int i = 0; i < FinalVar.MAX_VIDEO_CHANNEL_NUM; i++) {
			stuPtzLink[i] = new CFG_PTZ_LINK();
			stuPtzLinkEx[i] = new CFG_PTZ_LINK_EX();
			stuSnapshotTitle[i] = new CFG_EVENT_TITLE();
			stuVideoTitle[i] = new CFG_EVENT_TITLE();
			stuTour[i] = new CFG_TOURLINK();
		}
	}
}
