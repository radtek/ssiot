package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Video input channel failed(i.e. config video input channel's bit stram but it exceeds device processing capacity)SDK_ALARM_VIDEO_ININVALID
 * \else
 * 视频输入通道失效事件(例：配置的视频输入通道码流，超出设备处理能力)SDK_ALARM_VIDEO_ININVALID
 * \endif
 */
public class ALARM_VIDEO_ININVALID_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Channel no.,form 0
	 * \else
	 * 通道号，从0开始
	 * \endif
	 */
	public int                 nChannelID;
}
