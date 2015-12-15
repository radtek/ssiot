package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * INetSDK.MatrixGetCameras's interface output param
 * \else
 * INetSDK.MatrixGetCameras�ӿڵ��������
 * \endif
 */
public class SDK_OUT_MATRIX_GET_CAMERAS implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * array
	 * \else
	 * ��ʾԴ��Ϣ����, �û������ڴ�
	 * \endif
	 */
	public SDK_MATRIX_CAMERA_INFO  pstuCameras[]; 
	
	/**
	 * \if ENGLISH_LANG
	 * size of source array
	 * \else
	 * ��ʾԴ�����С
	 * \endif
	 */
    public int                     nMaxCameraCount; 
    
    /**
	 * \if ENGLISH_LANG
	 * return count
	 * \else
	 * ���ص���ʾԴ����
	 * \endif
	 */
    public int                     nRetCameraCount; 
    
    public SDK_OUT_MATRIX_GET_CAMERAS(int nMaxCameraCount) {
    	this.nMaxCameraCount = nMaxCameraCount;
    	pstuCameras = new SDK_MATRIX_CAMERA_INFO[this.nMaxCameraCount];
    	for (int i = 0; i < this.nMaxCameraCount; i++) {
    		pstuCameras[i] = new SDK_MATRIX_CAMERA_INFO();
    	}
    }
}
