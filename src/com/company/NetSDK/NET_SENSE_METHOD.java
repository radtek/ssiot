package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Sensor Enumeration Type
 * \else
 * 传感器感应方式枚举类型
 * \endif
 */
public class NET_SENSE_METHOD implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Unknown Type
	 * \else
	 * 未知类型
	 * \endif
	 */
	public static final int NET_SENSE_UNKNOWN = -1;      //未知类型
	
	/**
	 * \if ENGLISH_LANG
	 * Door Sensor
	 * \else
	 * 门磁
	 * \endif
	 */
	public static final int NET_SENSE_DOOR = 0;            //门磁
	
	/**
	 * \if ENGLISH_LANG
	 * Passive IR
	 * \else
	 * 被动红外
	 * \endif
	 */
	public static final int NET_SENSE_PASSIVEINFRA = 2;      //被动红外
	
	/**
	 * \if ENGLISH_LANG
	 * Gas Sensor
	 * \else
	 * 气感
	 * \endif
	 */
	public static final int NET_SENSE_GAS = 3;               //气感
	
	/**
	 * \if ENGLISH_LANG
	 * Smoke Sensor
	 * \else
	 * 烟感
	 * \endif
	 */
	public static final int NET_SENSE_SMOKING = 4;           //烟感
	
	/**
	 * \if ENGLISH_LANG
	 * Water Sensor
	 * \else
	 * 水感
	 * \endif
	 */
	public static final int NET_SENSE_WATER = 5;             //水感
	
	/**
	 * \if ENGLISH_LANG
	 * Active IR
	 * \else
	 * 主动红外
	 * \endif
	 */
	public static final int NET_SENSE_ACTIVEFRA = 6;         //主动红外
	
	/**
	 * \if ENGLISH_LANG
	 * Broken Glass
	 * \else
	 * 玻璃破碎
	 * \endif
	 */
	public static final int NET_SENSE_GLASS = 7;             //玻璃破碎
	
	/**
	 * \if ENGLISH_LANG
	 * Emergency
	 * \else
	 * 紧急开关
	 * \endif
	 */
	public static final int NET_SENSE_EMERGENCYSWITCH = 8;   //紧急开关
	
	/**
	 * \if ENGLISH_LANG
	 * Shock
	 * \else
	 * 震动
	 * \endif
	 */
	public static final int NET_SENSE_SHOCK = 9;             //震动
	
	/**
	 * \if ENGLISH_LANG
	 * Dual(IR+Microwave)
	 * \else
	 * 双鉴(红外+微波)
	 * \endif
	 */
	public static final int NET_SENSE_DOUBLEMETHOD = 10;      //双鉴(红外+微波)
	
	/**
	 * \if ENGLISH_LANG
	 * Three Technology
	 * \else
	 * 三技术
	 * \endif
	 */
	public static final int NET_SENSE_THREEMETHOD = 11;       //三技术
	
	/**
	 * \if ENGLISH_LANG
	 * Temperature
	 * \else
	 * 温度
	 * \endif
	 */
	public static final int NET_SENSE_TEMP = 12;              //温度
	
	/**
	 * \if ENGLISH_LANG
	 * Humidity
	 * \else
	 * 湿度
	 * \endif
	 */
	public static final int NET_SENSE_HUMIDITY = 13;          //湿度
	
	/**
	 * \if ENGLISH_LANG
	 * Call Button
	 * \else
	 * 呼叫按钮
	 * \endif
	 */
	public static final int NET_SENSE_CALLBUTTON = 14;        //呼叫按钮
	
	/**
	 * \if ENGLISH_LANG
	 * Other
	 * \else
	 * 其他
	 * \endif
	 */
	public static final int NET_SENSE_OTHER = 15;             //其他
	
	/**
	 * \if ENGLISH_LANG
	 * Enumeration Type Total
	 * \else
	 * 枚举类型总数
	 * \endif
	 */
	public static final int NET_SENSE_NUM = 16;               //枚举类型总数
}
