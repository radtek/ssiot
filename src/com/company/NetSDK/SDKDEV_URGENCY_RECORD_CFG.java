package com.company.NetSDK;

import java.io.Serializable;

//紧急存储配置
public class SDKDEV_URGENCY_RECORD_CFG implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public boolean    bEnable;            // 是否使能，1使能，0不使能
    public int    nMaxRecordTime;     // 最大录像时间，单位秒
}
