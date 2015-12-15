package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Normal COnfiguration 
 * \else
 * 普通配置 (CFG_CMD_DEV_GENERRAL) General 
 * \endif
 */
public class CFG_DEV_DISPOSITION_INFO implements Serializable {
 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * \if ENGLISH_LANG
	 * Device No.，Mainly for Remoter Indentify Different Device 0~998 
	 * \else
	 * 本机编号，主要用于遥控器区分不同设备	0~998
	 * \endif
	 */
	public int 				nLocalNo;
	
 	/**
	 * \if ENGLISH_LANG
	 * Machine Name Or No. 
	 * \else
	 * 机器名称或编号
	 * \endif
	 */
	public byte[]			szMachineName = new byte[256];
	
 	/**
	 * \if ENGLISH_LANG
	 * Machine Address is Road Code 
	 * \else
	 * 机器部署地点即道路编码
	 * \endif
	 */
	public byte[]			szMachineAddress = new byte[256];
	
 	/**
	 * \if ENGLISH_LANG
	 * Machine Group Or Machine Affiliated Unit Default Empty，User Can Put Different Machines As One Group，Easy Management，Repeatability
	 * \else
	 * 机器分组或叫设备所属单位	默认为空，用户可以将不同的设备编为一组，便于管理，可重复。
	 * \endif
	 */
	public byte[]			szMachineGroup = new byte[256];
	
 	/**
	 * \if ENGLISH_LANG
	 * device no. , only one in platform with interne
	 * \else
	 * 机器编号, 联网平台内唯一
	 * \endif
	 */
	public byte[]			szMachineID = new byte[64];
}
