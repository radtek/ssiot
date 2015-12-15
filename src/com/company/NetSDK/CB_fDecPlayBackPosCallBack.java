package com.company.NetSDK;

/**
 * \if ENGLISH_LANG
 * Playback progress recall function 
 * \else
 * 回放进度回调
 * \endif
 */
public interface CB_fDecPlayBackPosCallBack {
	/**
	 * \if ENGLISH_LANG
	 * Playback progress recall function 
	 * @param lLoginID login handle, return from {@link com.company.NetSDK.INetSDK#LoginEx() LoginEx}or{@link com.company.NetSDK.INetSDK#Login() Login}
	 * @param nEncoderID encoder NO.
	 * @param dwTotalSize playback data total size
	 * @param dwPlaySize played data size
	 * \else
	 * 回放进度回调
	 * @param lLoginID 登录句柄, {@link com.company.NetSDK.INetSDK#LoginEx() LoginEx}或者{@link com.company.NetSDK.INetSDK#Login() Login}的返回值
	 * @param nEncoderID 编码器编号
	 * @param dwTotalSize 回放数据的总大小 
	 * @param dwPlaySize 已回放数据的大小 
	 * \endif
	 */
	public void invoke(long lLoginID , int nEncoderID , int dwTotalSize , int dwPlaySize);
}
