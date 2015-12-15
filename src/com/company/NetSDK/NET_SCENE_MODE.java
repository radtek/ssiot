package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Scene Mode
 * \else
 * 情景模式
 * \endif
 */
public class NET_SCENE_MODE implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Unknown Scene
	 * \else
	 * 未知场景
	 * \endif
	 */
	public static final int NET_SCENE_MODE_UNKNOWN = 0;
	
	/**
	 * \if ENGLISH_LANG
	 * Out Mode
	 * \else
	 * 外出模式
	 * \endif
	 */
	public static final int NET_SCENE_MODE_OUTDOOR = 1;
	
	/**
	 * \if ENGLISH_LANG
	 * In Mode
	 * \else
	 * 室内模式
	 * \endif
	 */
	public static final int NET_SCENE_MODE_INDOOR = 2;
	
	public static final int NET_SCENE_MODE_WHOLE = 3;      // 全局模式
	
	public static final int NET_SCENE_MODE_RIGHTNOW = 4;   // 立即模式
}
