package com.company.NetSDK;

/**
 * \if ENGLISH_LANG
 * Upgrade device callback function original shape
 * \else
 * 升级设备程序回调
 * \endif
 */
public interface CB_fUpgradeCallBack {
	/**
	 * \if ENGLISH_LANG
	 * Upgrade device callback function original shape
	 * @param lLoginID login handle, return from {@link com.company.NetSDK.INetSDK#LoginEx() LoginEx}or{@link com.company.NetSDK.INetSDK#Login() Login}
	 * @param lUpgradeChannel handle, return from{@link com.company.NetSDK.INetSDK#StartUpgrade() StartUpgrade}
	 * @param nTotalSize update file total length(unit:byte) 
	 * @param nSendSize Sent file length(unit:byte)，when it is-1，meand update file sending ends 
	 * \else
	 * 升级设备程序回调函数
	 * @param lLoginID 登录句柄, {@link com.company.NetSDK.INetSDK#LoginEx() LoginEx}或者{@link com.company.NetSDK.INetSDK#Login() Login}的返回值
	 * @param lUpgradeChannel {@link com.company.NetSDK.INetSDK#StartUpgrade() StartUpgrade}返回的升级句柄ID 
	 * @param nTotalSize 升级文件的总长度(单位:字节) 
	 * @param nSendSize 已发送的文件长度(单位:字节)，为-1时，表示发送升级文件结束 
	 * \endif
	 */
	public void invoke(long lLoginID , long lUpgradeChannel , int nTotalSize , int nSendSize);
}
