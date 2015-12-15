package com.company.NetSDK;

/**
 * \if ENGLISH_LANG
 * Network disconnection callback function original shape 
 * \else
 * ������ߴ���ӿ�
 * \endif
 */
public interface CB_fDisConnect {
	/**
	 * \if ENGLISH_LANG
	 * Callback function when network disconnect
	 * @param lLoginID login handle, return from {@link com.company.NetSDK.INetSDK#LoginEx() LoginEx}or{@link com.company.NetSDK.INetSDK#Login() Login}
	 * @param pchDVRIP ip of device
	 * @param nDVRPort port of device
	 * \else
	 * ������߻ص�����
	 * @param lLoginID ��¼���, {@link com.company.NetSDK.INetSDK#LoginEx() LoginEx}����{@link com.company.NetSDK.INetSDK#Login() Login}�ķ���ֵ
	 * @param pchDVRIP �豸IP
	 * @param nDVRPort �豸�˿�
	 * \endif
	 */
	public void invoke(long lLoginID, String pchDVRIP, int nDVRPort);
}
