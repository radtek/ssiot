package com.company.NetSDK;

/**
 * \if ENGLISH_LANG
 * Burning device callback function
 * \else
 * 刻录设备回调函数原形
 * \endif
 */
public interface CB_fBurnFileCallBack {
	/**
	 * \if ENGLISH_LANG
	 * Burning device callback function
	 * @param lLoginID login handle, return from {@link com.company.NetSDK.INetSDK#LoginEx() LoginEx}or{@link com.company.NetSDK.INetSDK#Login() Login}
	 * @param lUploadHandle return from {@link com.company.NetSDK.INetSDK#StartUploadFileBurned() StartUploadFileBurned}
	 * @param nTotalSize file total size
	 * @param nSendSize	sent file length
	 * \else
	 * 刻录设备回调函数原形
	 * @param lLoginID 登录句柄, {@link com.company.NetSDK.INetSDK#LoginEx() LoginEx}或者{@link com.company.NetSDK.INetSDK#Login() Login}的返回值
	 * @param lUploadHandle {@link com.company.NetSDK.INetSDK#StartUploadFileBurned() StartUploadFileBurned}的返回值
	 * @param nTotalSize 文件总共大小
	 * @param nSendSize	已发送文件大小
	 * \endif
	 */
	public void invoke(long lLoginID, long lUploadHandle, int nTotalSize, int nSendSize);
}
