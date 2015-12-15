package com.company.NetSDK;

/**
 * \if ENGLISH_LANG
 * Network disconnect deal interface
 * \else
 * 监听CAN总线数据回调函数原形
 * \endif
 */
public interface CB_fAttachCANCB {
	/**
	 * \if ENGLISH_LANG
	 * Callback function when network disconnect
	 * @param lLoginID login handle, return from {@link com.company.NetSDK.INetSDK#LoginEx() LoginEx}or{@link com.company.NetSDK.INetSDK#Login() Login}
	 * @param lAttachHandle return from {@link com.company.NetSDK.INetSDK#AttachCAN() AttachCAN}
	 * @param pBuf data info {@link com.company.NetSDK.NET_CB_CANDATA NET_CB_CANDATA}
	 * \else
	 * 监听CAN总线数据回调函数
	 * @param lLoginID 登录句柄, {@link com.company.NetSDK.INetSDK#LoginEx() LoginEx}或者{@link com.company.NetSDK.INetSDK#Login() Login}的返回值
	 * @param lAttachHandle {@link com.company.NetSDK.INetSDK#AttachCAN() AttachCAN}返回值
	 * @param pBuf 数据信息，{@link com.company.NetSDK.NET_CB_CANDATA NET_CB_CANDATA}
	 * \endif
	 */
	public void invoke(long lLoginID, long lAttachHandle, NET_CB_CANDATA pBuf);
}
