package com.company.NetSDK;

/**
 * \if ENGLISH_LANG
 * Writing calibration call function
 * \else
 * 刻录校验回调函数原形
 * \endif
 */
public interface CB_fBurnCheckCallBack {
	/**
	 * \if ENGLISH_LANG
	 * Writing calibration call function
	 * @param lLoginID  login handle, {@link com.company.NetSDK.INetSDK#LoginEx() LoginEx} or{@link com.company.NetSDK.INetSDK#Login() Login} return value 
	 * @param lAttachHandle writing handle, {@link com.company.NetSDK.INetSDK#AttachBurnCheckState() AttachBurnCheckState} return value 
	 * @param pstState writing status info，see {@link com.company.NetSDK.NET_CB_BURN_CHECK_STATE NET_CB_BURN_CHECK_STATE}
	 * \else
	 * 刻录校验回调函数
	 * @param lLoginID 登录句柄, {@link com.company.NetSDK.INetSDK#LoginEx() LoginEx}或者{@link com.company.NetSDK.INetSDK#Login() Login}的返回值
	 * @param lAttachHandle 刻录句柄, {@link com.company.NetSDK.INetSDK#AttachBurnCheckState() AttachBurnCheckState}的返回值
	 * @param pstState 刻录状态信息，详见 {@link com.company.NetSDK.NET_CB_BURN_CHECK_STATE NET_CB_BURN_CHECK_STATE}
	 * \endif
	 */
	public void invoke(long lLoginID, long lAttachHandle, NET_CB_BURN_CHECK_STATE pstState);
}
