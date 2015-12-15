package com.company.NetSDK;

/**
 * \if ENGLISH_LANG
 * The callback function prototypes of subscribe to video phone
 * \else
 * 订阅视频电话状态信息回调函数原型
 * \endif
 */
public interface CB_fVTPCallStateCallBack {
	public void invoke(long lAttachHandle, NET_VTP_CALL_STATE_INFO pInfo);
}
