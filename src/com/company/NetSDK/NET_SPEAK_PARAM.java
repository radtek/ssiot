package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Audio talk_speak param
 * \else
 * 语音对讲喊话参数	
 * \endif
 */
public class NET_SPEAK_PARAM implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * 0:talk back(default), 1: propaganda,from propaganda ro talk back,need afresh to configure
	 * \else
	 * 0：对讲（默认模式），1：喊话；从喊话切换到对讲要重新设置
	 * \endif
	 */
	public int             nMode;
	
	/**
	 * \if ENGLISH_LANG
	 * Reproducer channel
	 * \else
	 * 扬声器通道号，喊话时有效
	 * \endif
	 */
	public int             nSpeakerChannel;            
}
