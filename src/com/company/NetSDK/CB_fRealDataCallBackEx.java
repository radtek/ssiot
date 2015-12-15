package com.company.NetSDK;

/**
 * \if ENGLISH_LANG
 * Real-time monitor data callback function original shape---extensive
 * \else
 * 实时监控回调函数原型
 * \endif
 */
public interface CB_fRealDataCallBackEx {
	/**
	 * \if ENGLISH_LANG
	 * Real-time monitor data callback function original shape---extensive
	 * @param lRealHandle real time monitor ID ,return from {@link com.company.NetSDK.INetSDK#RealPlay() RealPlay}or{@link com.company.NetSDK.INetSDK#RealPlayEx() RealPlayEx}
	 * @param dwDataType label recalled data type ，only dwFlag set labeled data will be recalled：
	 * <table>
	 * <tr><td>dwDataType</td><td>data type </td></tr>
	 * <tr><td>0</td><td>original data (identicla SaveRealData saveddata)</td></tr>
	 * <tr><td>1</td><td>frame data </td></tr>
	 * <tr><td>2</td><td>yuv data </td></tr>
	 * <tr><td>3</td><td>pcm audio data </td></tr>
	 * </table>
	 * @param pBuffer recall data ，based on different data type each time recall different length data ，except type 0，other data type all by frame，each time recall one frame data 
	 * @param dwBufSize recall data parameter structure，based on different type ，parameter structure differ
	 * @param param recall data length，based on different type ，length differ(unit byte) 
	 * \else
	 * 网络断线回调函数
	 * @param lRealHandle 实时监视ID,{@link com.company.NetSDK.INetSDK#RealPlay() RealPlay}或者{@link com.company.NetSDK.INetSDK#RealPlayEx() RealPlayEx}返回值
	 * @param dwDataType 回调出来的数据类型
	 * <table>
	 * <tr><td>dwDataType</td><td>pBuffer数据类型</td></tr> 
	 * <tr><td>0</td><td>原始数据(与SaveRealData保存的数据一致) </td></tr>
	 * <tr><td>1</td><td>帧数据 </td></tr>
	 * <tr><td>2</td><td>yuv数据 </td></tr>
	 * <tr><td>3</td><td>pcm音频数据 </td></tr>
	 * </table>
	 * @param pBuffer 回调数据，根据数据类型的不同每次回调不同的长度的数据，除类型0，其他数据类型都是按帧，每次回调一帧数据 
	 * @param dwBufSize 回调数据参数结构体，根据不同的类型，参数结构也不一致
	 * @param param 回调数据的长度，根据不同的类型，长度也不同(单位字节) 
	 * \endif
	 */
	public void invoke(long lRealHandle, int dwDataType, byte[] pBuffer, int dwBufSize, int param);
}
