package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * CoilFault alarm event
 * \else
 * 线圈 / 车检器报警
 * \endif
 */
public class ALARM_WINGDING_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

 	/**
	 * \if ENGLISH_LANG
	 * road number
	 * \else
	 * 车道号
	 * \endif
	 */
	public int                 nDriveWayID;
	
 	/**
	 * \if ENGLISH_LANG
	 * coil ID
	 * \else
	 * 线圈ID
	 * \endif
	 */
	public int                 nWindingID;
	
 	/**
	 * \if ENGLISH_LANG
	 * event happen time 
	 * \else
	 * 报警发生时间
	 * \endif
	 */
	public NET_TIME            stuTime = new NET_TIME();
	
 	/**
	 * \if ENGLISH_LANG
	 * Device state,0 indicate fault recover,1 indicate fault happen
	 * \else
	 * 设备状态，0表示故障恢复，1表示发生故障
	 * \endif
	 */
	public int                 nState;
 	/**
	 * \if ENGLISH_LANG
	 * Channel of alarm
	 * \else
	 * 报警的通道号
	 * \endif
	 */
	public int                 dwChannel;
}
