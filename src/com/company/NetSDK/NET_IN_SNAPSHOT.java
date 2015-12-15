package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * TrafficSnapByNetwork's input param
 * \else
 * 接口(TrafficSnapByNetwork)输入参数
 * \endif
 */
public class NET_IN_SNAPSHOT implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Trigger type	0-unknown 1-zhongmeng net trigger
	 * \else
	 * 触发类型	0-未知	1-中盟网络触发 2-客户端触发（传入NET_CLIENT_SNAP_INFO类的对象）
	 * \endif
	 */
	public int					nTriggerType;			

	public Object				objType;				
}
