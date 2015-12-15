package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * INetSDK.MatrixGetCameras's interface output param
 * \else
 * INetSDK.MatrixGetCameras接口的输出参数
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
	 * 显示源信息数组, 用户分配内存
	 * \endif
	 */
	public SDK_MATRIX_CAMERA_INFO  pstuCameras[]; 
	
	/**
	 * \if ENGLISH_LANG
	 * size of source array
	 * \else
	 * 显示源数组大小
	 * \endif
	 */
    public int                     nMaxCameraCount; 
    
    /**
	 * \if ENGLISH_LANG
	 * return count
	 * \else
	 * 返回的显示源数量
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
