package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Sensor enumeration type
 * \else
 * 传感器感应方式枚举类型
 * \endif
 */
public class EM_SENSE_METHOD implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Door Sensor
	 * \else
	 * 门磁
	 * \endif
	 */
	public static final int EM_SENSE_DOOR = 0;         

	/**
	 * \if ENGLISH_LANG
	 * Passive IR
	 * \else
	 * 被动红外
	 * \endif
	 */
	public static final int EM_SENSE_PASSIVEINFRA = 1;   

	/**
	 * \if ENGLISH_LANG
	 * Gas Sensor 
	 * \else
	 * 气感
	 * \endif
	 */
	public static final int EM_SENSE_GAS = 2;            

	/**
	 * \if ENGLISH_LANG
	 * Smoke Sensor 
	 * \else
	 * 烟感
	 * \endif
	 */
	public static final int EM_SENSE_SMOKING = 3;        

	/**
	 * \if ENGLISH_LANG
	 * Water Sensor
	 * \else
	 * 水感
	 * \endif
	 */
	public static final int EM_SENSE_WATER = 4;          

	/**
	 * \if ENGLISH_LANG
	 * Active IR 
	 * \else
	 * 主动红外
	 * \endif
	 */
	public static final int EM_SENSE_ACTIVEFRA = 5;
	
	/**
	 * \if ENGLISH_LANG
	 * Glass Broken
	 * \else
	 * 玻璃破碎
	 * \endif
	 */
	public static final int EM_SENSE_GLASS = 6;
	
	/**
	 * \if ENGLISH_LANG
	 * SOS
	 * \else
	 * 紧急开关
	 * \endif
	 */
	public static final int EM_SENSE_EMERGENCYSWITCH = 7;
	
	/**
	 * \if ENGLISH_LANG
	 * Vibrate
	 * \else
	 * 震动
	 * \endif
	 */
	public static final int EM_SENSE_SHOCK = 8;
	
	/**
	 * \if ENGLISH_LANG
	 * Dual(IR+Microwave)
	 * \else
	 * 双鉴(红外+微波)
	 * \endif
	 */
	public static final int EM_SENSE_DOUBLEMETHOD = 9;
	
	/**
	 * \if ENGLISH_LANG
	 * Tritechnology
	 * \else
	 * 三技术
	 * \endif
	 */
	public static final int EM_SENSE_THREEMETHOD = 10;
	
	/**
	 * \if ENGLISH_LANG
	 * Temperature
	 * \else
	 * 温度
	 * \endif
	 */
	public static final int EM_SENSE_TEMP = 11;
	
	/**
	 * \if ENGLISH_LANG
	 * Humidity
	 * \else
	 * 湿度
	 * \endif
	 */
	public static final int EM_SENSE_HUMIDITY = 12;
	
	/**
	 * \if ENGLISH_LANG
	 * Call button
	 * \else
	 * 呼叫按钮
	 * \endif
	 */
	public static final int EM_SENSE_CALLBUTTON = 13;
	
	/**
	 * \if ENGLISH_LANG
	 * Gas pressure
	 * \else
	 * 气体压力
	 * \endif
	 */
	public static final int EM_SENSE_GASPRESSURE = 14;
	
	/**
	 * \if ENGLISH_LANG
	 * Gas concentration
	 * \else
	 * 燃气浓度
	 * \endif
	 */
	public static final int EM_SENSE_GASCONCENTRATION = 15;
	
	/**
	 * \if ENGLISH_LANG
	 * Gas flow
	 * \else
	 * 气体流量
	 * \endif
	 */
	public static final int EM_SENSE_GASFLOW = 16;
	
	/**
	 * \if ENGLISH_LANG
	 * Other
	 * \else
	 * 其他
	 * \endif
	 */
	public static final int EM_SENSE_OTHER = 17;

	/**
	 * \if ENGLISH_LANG
	 * Enumeration total
	 * \else
	 * 枚举类型总数
	 * \endif
	 */
	public static final int EM_SENSE_NUM = 18;             
}
