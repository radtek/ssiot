package com.company.NetSDK;

import java.io.Serializable;


public class NET_POWER_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	 public boolean                bPowerOn;                       				// 电源状态, 0-关闭, 1-打开, 2-打开但有故障
	 //电源电流状态 EM_CURRENT_STATE_TYPE
	 public int  emCurrentState ;            
}
