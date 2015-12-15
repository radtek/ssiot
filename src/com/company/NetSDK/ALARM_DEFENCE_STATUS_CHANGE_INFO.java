package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * zone status change event, corresponding to event type DH_ALARM_DEFENCE_STATE_CHANGE_EVENT
 * \else
 * 防区状态变化事件, 对应事件类型SDK_ALARM_DEFENCE_STATE_CHANGE_EVENT
 * \endif
 */
public class ALARM_DEFENCE_STATUS_CHANGE_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * zone ID，as alarm input channel no.(from 0)
	 * \else
	 * 防区ID，即报警输入通道号(从0开始)
	 * \endif
	 */
    public int                     nChannelID;
    
    /**
     * \if ENGLISH_LANG
     * event time
     * \else
     * 事件发生的时间
     * \endif
     */
    public NET_TIME                stuTime = new NET_TIME();
    
    /**
     * \if ENGLISH_LANG
     * zone changed status, EM_DEFENCE_STATE_TYPE
     * \else
     * 防区变化后的状态, EM_DEFENCE_STATE_TYPE
     * \endif
     */
    public int   emStatus;
}
