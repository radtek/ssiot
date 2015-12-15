package com.company.NetSDK;

import java.io.Serializable;


public class NET_POWER_STATUS implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	 public boolean            bEnable;                            // 查询是否成功
	 public int                nCount;                             // 电源数量
	 public NET_POWER_INFO     stuPowers[] = new NET_POWER_INFO[FinalVar.SDK_MAX_POWER_NUM];        // 电源状态
	 public int                nBatteryNum;                        // 电池数量
	 public NET_BATTERY_INFO   stuBatteries[] = new NET_BATTERY_INFO[FinalVar.SDK_MAX_BATTERY_NUM];   // 电池状态
	 
	 public NET_POWER_STATUS(){
		 for(int i=0 ; i<FinalVar.SDK_MAX_POWER_NUM ; i++){
			 stuPowers[i] = new NET_POWER_INFO();
		 }
		 
		 for( int i =0 ; i<FinalVar.SDK_MAX_BATTERY_NUM ; i++){
			 stuBatteries[i] = new NET_BATTERY_INFO();
		 }
	 }
}
