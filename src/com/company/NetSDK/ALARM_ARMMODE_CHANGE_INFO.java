package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Arming/Disarming Status Change Event Info
 * \else
 * 布撤防状态变化事件的信息
 * \endif
 */
public class ALARM_ARMMODE_CHANGE_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Alarm Event Time
	 * \else
	 * 报警事件发生的时间
	 * \endif
	 */
	public NET_TIME            stuTime = new NET_TIME();
	
	/**
	 * \if ENGLISH_LANG
	 * Status After Change {@link com.company.NetSDK.NET_ALARM_MODE NET_ALARM_MODE}
	 * \else
	 * 变化后的状态 {@link com.company.NetSDK.NET_ALARM_MODE NET_ALARM_MODE}
	 * \endif
	 */
	public int                 bArm;
	
	/**
	 * \if ENGLISH_LANG
	 * Scene Mode {@link com.company.NetSDK.NET_SCENE_MODE NET_SCENE_MODE}
	 * \else
	 * 情景模式 {@link com.company.NetSDK.NET_SCENE_MODE NET_SCENE_MODE}
	 * \endif
	 */
	public int                 emSceneMode;
	
	/**
	 * \if ENGLISH_LANG
	 * ID number, remote control number or keypad address, emTriggerMode=0 when  belong to NET_EM_TRIGGER_MODE_NET
	 * \else
	 * ID号, 遥控器编号或键盘地址, emTriggerMode为NET_EM_TRIGGER_MODE_NET类型时为0
	 * \endif
	 */
	public int                 dwID; 
	
	/**
	 * \if ENGLISH_LANG
	 * trigger mode, NET_EM_TRIGGER_MODE
	 * \else
	 * 触发方式, NET_EM_TRIGGER_MODE
	 * \endif
	 */
	public int                 emTriggerMode; 
}
