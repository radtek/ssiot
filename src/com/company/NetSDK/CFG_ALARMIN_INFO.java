package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * External Alarm Configuration
 * \else
 * 外部报警配置
 * \endif
 */
public class CFG_ALARMIN_INFO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * \if ENGLISH_LANG
	 * Alarm Channel No.(0 Start) 
	 * \else
	 * 报警通道号(0开始)
	 * \endif
	 */
	public int					nChannelID;
	
	/**
	 * \if ENGLISH_LANG
	 * Enable Switch 
	 * \else
	 * 使能开关
	 * \endif
	 */
	public boolean				bEnable;
	
	/**
	 * \if ENGLISH_LANG
	 * Alarm Channel Name 
	 * \else
	 * 报警通道名称
	 * \endif
	 */
	public char					szChnName[] = new char[FinalVar.MAX_CHANNELNAME_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Sensor Name. 0:Normal Closed,1:Normal Open
	 * \else
	 * 报警器类型,0:常闭,1:常开
	 * \endif
	 */
	public int					nAlarmType;
	
	/**
	 * \if ENGLISH_LANG
	 * Alarm Linkage 
	 * \else
	 * 报警联动
	 * \endif
	 */
	public CFG_ALARM_MSG_HANDLE stuEventHandler = new CFG_ALARM_MSG_HANDLE();
	
	/**
	 * \if ENGLISH_LANG
	 * Event Respond Time Section 
	 * \else
	 * 事件响应时间段
	 * \endif
	 */
	public CFG_TIME_SECTION		stuTimeSection[][] = new CFG_TIME_SECTION[FinalVar.WEEK_DAY_NUM][FinalVar.MAX_REC_TSECT];

	public boolean				abDevID;
	
	/**
	 * \if ENGLISH_LANG
	 * device ID 
	 * \else
	 * 设备ID
	 * \endif
	 */
	public char					szDevID[] = new char[FinalVar.MAX_NAME_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * sensor trigger mode, 0: highly effective，1 low effective; sensor grounding or power，and group with nAlarmType 
	 * \else
	 * 传感器触发模式, 0:高有效,1低有效; 具体表现为传感器接地or电源,与nAlarmType组合使用
	 * \endif
	 */
	public int                  nPole;                                      
	                                                                
	/**
	 * \if ENGLISH_LANG
	 * sensor type, EM_SENSE_METHOD
	 * \else
	 * 传感器感应方式, EM_SENSE_METHOD
	 * \endif
	 */
	public int				     emSense;
	
	/**
	 * \if ENGLISH_LANG
	 * Alarm enable control, EM_CTRL_ENABLE
	 * \else
	 * 报警使能控制方式, EM_CTRL_ENABLE
	 * \endif
	 */
	public int                   emCtrl;
	
	/**
	 * \if ENGLISH_LANG
	 * delay disarm , in s,0~300,emCtrl value is EM_CTRL_NORMAL or EM_CTRL_ALWAYS_EN effective 
	 * \else
	 * 延时撤防时间,单位为秒,0~300,emCtrl值为EM_CTRL_NORMAL或EM_CTRL_ALWAYS_EN 时有效.
	 * \endif
	 */
	public int                  nDisDelay;                                  
	
	public CFG_ALARMIN_INFO() {
		for (int i = 0; i < FinalVar.WEEK_DAY_NUM; i++) {
			for (int j = 0; j < FinalVar.MAX_REC_TSECT; j++) {
				stuTimeSection[i][j] = new CFG_TIME_SECTION();
			}
		}
	}
}
