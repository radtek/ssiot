package com.company.NetSDK;

import java.io.Serializable;


public class NET_BATTERY_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public 	int        nPercent;                       // 电池容量百分比
	public	boolean    bCharging;                      // 是否真正充电
	//电池在位状态 EM_BATTERY_EXIST_STATE
	public  int        emExistState ;
	//电池电量状态 EM_BATTERY_STATE
	public 	int 		emState;
}
