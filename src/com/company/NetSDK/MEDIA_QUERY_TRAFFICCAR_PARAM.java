package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * The corresponding search criteria of  SDK_MEDIA_QUERY_TRAFFICCAR
 * \else
 * SDK_MEDIA_QUERY_TRAFFICCAR对应的查询条件
 * \endif
 */
public class MEDIA_QUERY_TRAFFICCAR_PARAM implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * The channel number begins with 0. -1 is to search information of all channels .
	 * \else
	 * 通道号从0开始，-1表示查询所有通道
	 * \endif
	 */
	public int					nChannelID;
	
	/**
	 * \if ENGLISH_LANG
	 * Start time 	
	 * \else
	 * 开始时间
	 * \endif
	 */
	public NET_TIME			StartTime = new NET_TIME();
	
	/**
	 * \if ENGLISH_LANG
	 * End time 
	 * \else
	 * 结束时间
	 * \endif
	 */
	public NET_TIME			EndTime = new NET_TIME();
	
	/**
	 * \if ENGLISH_LANG
	 * File type:0=search any type.1=search jpg file
	 * \else
	 * 文件类型，0:任意类型, 1:jpg图片, 2:dav文件
	 * \endif
	 */
	public int					nMediaTyp;
	
	/**
	 * \if ENGLISH_LANG
	 * Event type,please refer to Intelligent Analytics Event Type. 0 means search any event. 
	 * \else
	 * 事件类型，详见"智能分析事件类型", 0:表示查询任意事件，此参数废弃，请使用pEventTypes
	 * \endif
	 */
	public int					nEventType;
	
	/**
	 * \if ENGLISH_LANG
	 * Vehicle plate. "\0" is to search any plate number.
	 * \else
	 * 车牌号, "\0"则表示查询任意车牌号
	 * \endif
	 */
	public char				szPlateNumber[] = new char[32];
	
	/**
	 * \if ENGLISH_LANG
	 * The searched vehicle speed range. Max speed unit is km/h
	 * \else
	 * 查询的车速范围; 速度上限 单位: km/h
	 * \endif
	 */
	public int					nSpeedUpperLimit;
	
	/**
	 * \if ENGLISH_LANG
	 * The searched vehicle speed range. Min speed unit is km/h
	 * \else
	 * 查询的车速范围; 速度下限 单位: km/h 
	 * \endif
	 */
	public int					nSpeedLowerLimit;
	
	/**
	 * \if ENGLISH_LANG
	 * Search according to the speed or not.  TRUE: search according to the speed.nSpeedUpperLimit and nSpeedLowerLimit is valid.
	 * \else
	 * 是否按速度查询; TRUE:按速度查询,nSpeedUpperLimit和nSpeedLowerLimit有效。
	 * \endif
	 */
	public boolean				bSpeedLimit;
	
	/**
	 * \if ENGLISH_LANG
	 * <pre>
	 * Illegal type:
	 * When event type is EVENT_IVS_TRAFFICGATE
	 * bit1: Retrograde;   bit2: Overline; 
	 * bit3: Overspend; 	bit4:Under speed; 
	 * bit5: RunRedLight;
	 * When event type is EVENT_IVS_TRAFFICJUNCTION
	 * bit1: RunRedLight;  bit2: WrongLan;  
	 * bit3: Retrograde; 	bit4:UTurn;
	 * bit5: Overline;
	 * </pre>
	 * \else
	 * 违章类型：
	 * <pre>
	 * 当事件类型为 EVENT_IVS_TRAFFICGATE时
	 * 第一位:逆行;  第二位:压线行驶; 第三位:超速行驶; 
	 * 第四位：欠速行驶; 第五位:闯红灯;
	 * 当事件类型为 EVENT_IVS_TRAFFICJUNCTION
	 * 第一位:闯红灯;  第二位:不按规定车道行驶;  
	 * 第三位:逆行; 第四位：违章掉头;
	 * 第五位:压线行驶;
	 * </pre>
	 * \endif
	 */
	public int					dwBreakingRule;
	
	/**
	 * \if ENGLISH_LANG
	 * Plate type,"Unknown" ,"Normal" ,"Yellow" ,"DoubleYellow" ,"Police" ,"Armed","Military","DoubleMilitary"
	 * ,"SAR", "Trainning", "Personal", "Agri", "Embassy", "Moto", "Tractor", "Other"
	 * \else
 	 * 车牌类型，"Unknown" 未知,"Normal" 蓝牌黑牌,"Yellow" 黄牌,"DoubleYellow" 双层黄尾牌,"Police" 警牌"Armed" 武警牌,
     * "Military" 部队号牌,"DoubleMilitary" 部队双层,"SAR" 港澳特区号牌,"Trainning" 教练车号牌
	 * "Personal" 个性号牌,"Agri" 农用牌,"Embassy" 使馆号牌,"Moto" 摩托车号牌,"Tractor" 拖拉机号牌,"Other" 其他号牌
	 * \endif
	 */
	public char                szPlateType[] = new char[32];
	
	/**
	 * \if ENGLISH_LANG
	 * Plate color, "Blue","Yellow", "White","Black"
	 * \else
	 * 车牌颜色, "Blue"蓝色,"Yellow"黄色, "White"白色,"Black"黑色
	 * \endif
	 */
	public char                szPlateColor[] = new char[16];
	
	/**
	 * \if ENGLISH_LANG
	 * Vehicle color:"White", "Black", "Red", "Yellow", "Gray", "Blue","Green"
	 * \else
	 * 车身颜色:"White"白色, "Black"黑色, "Red"红色, "Yellow"黄色, "Gray"灰色, "Blue"蓝色,"Green"绿色
	 * \endif
	 */
	public char				szVehicleColor[] = new char[16];
	
	/**
	 * \if ENGLISH_LANG
	 * Vehicle type:"Light-duty";"Medium"; "Oversize";"Unknown"
	 * \else
	 * 车辆大小类型:"Light-duty":小型车;"Medium":中型车; "Oversize":大型车; "Unknown": 未知
	 * \endif
	 */
	public char				szVehicleSize[] = new char[16];
	
	/**
	 * \if ENGLISH_LANG
	 * Id of event group(it works when >= 0)
	 * \else
	 * 事件组编号(此值>=0时有效)
	 * \endif
	 */
	public int                 nGroupID;
	
	/**
	 * \if ENGLISH_LANG
	 * Lane number(it works when >= 0)
	 * \else
	 * 车道号(此值>=0时表示具体车道，-1表示所有车道，即不下发此字段)
	 * \endif
	 */
	public short               byLane;
	
	/**
	 * \if ENGLISH_LANG
	 * File flag, 0xFF-use nFileFlagEx, 0-all record, 1-timing file, 2-manual, 3-event, 4-important, 5-mosaic
	 * \else
	 * 文件标志, 0xFF-使用nFileFlagEx, 0-表示所有录像, 1-定时文件, 2-手动文件, 3-事件文件, 4-重要文件, 5-合成文件
	 * \endif
	 */
	public byte				byFileFlag;
	
	/**
	 * \if ENGLISH_LANG
	 * During search, it goes to other page，0-No，1-Yes
	 * \else
	 * 是否需要在查询过程中随意跳转，0-不需要，1-需要
	 * \endif
	 */
	public byte				byRandomAccess;
	
	/**
	 * \if ENGLISH_LANG
	 * File flag, bit0-timing, bit1-manual, bit2-event, bit3-important, bit4-mosaic, 0xFFFFFFFF-all
	 * \else
	 * 文件标志, 按位表示: bit0-定时文件, bit1-手动文件, bit2-事件文件, bit3-重要文件, bit4-合成文件, bit5-黑名单图片 0xFFFFFFFF-所有录像
	 * \endif
	 */
	public int					nFileFlagEx;
	
	/**
	 * \if ENGLISH_LANG
	 * Direction(to the direction of car)	0-north 1-northeast 2-east 3-southeast 4-south 5-southwest 6-west 7-northwest 8-unknown -1-all directions
	 * \else
	 * 车道方向（车开往的方向）	0-北 1-东北 2-东 3-东南 4-南 5-西南 6-西 7-西北 8-未知 -1-所有方向
	 * \endif
	 */
	public int					nDirection;
	
	/**
	 * \if ENGLISH_LANG
	 * Working directory list,can inquire multiple directory at a atime,separated by ";",example "/mnt/dvr/sda0;/mnt/dvr/sda1",if szDirs==null or szDirs == "" ,means search all
	 * \else
	 * 工作目录列表,一次可查询多个目录,为空表示查询所有目录。目录之间以分号分隔，如“/mnt/dvr/sda0;/mnt/dvr/sda1”,szDirs==null 或"" 表示查询所有
	 * \endif
	 */
	public String              szDirs;
	
	/**
	 * \if ENGLISH_LANG
	 * Event type to search group indicator,event type, see"IVS analysis event type"，if as NULL then search all events（buffer shall be applied by user）
	 * \else
	 * 待查询的事件类型数组指针,事件类型,详见"智能分析事件类型"，若为NULL则认为查询所有事件（缓冲需由用户申请）
	 * \endif
	 */
	public int                 pEventTypes[];
	
	/**
	 * \if ENGLISH_LANG
	 * Event type group size
	 * \else
	 * 事件类型数组大小
	 * \endif
	 */
	public int                 nEventTypeNum;
	
	/**
	 * \if ENGLISH_LANG
	 * Device address, NULL means field no use
	 * \else
	 * 设备地址, NULL表示该字段不起作用
	 * \endif
	 */
	public String				pszDeviceAddress;
	
	/**
	 * \if ENGLISH_LANG
	 * Device deploy location, NULL means field no use
	 * \else
	 * 机器部署地点, NULL表示该字段不起作用
	 * \endif
	 */
	public String				pszMachineAddress;
	
	/**
	 * \if ENGLISH_LANG
	 * Vehicle mark, such as "Unknown"-unknown, "Audi"-Audi, "Honda"-Honda... NULL means field no use
	 * \else
	 * 车辆标识, 例如 "Unknown"-未知, "Audi"-奥迪, "Honda"-本田... NULL表示该字段不起作用
	 * \endif
	 */
	public String				pszVehicleSign;
	
	public MEDIA_QUERY_TRAFFICCAR_PARAM(int nEventNum) {
		nEventTypeNum = nEventNum;
		pEventTypes = new int[nEventTypeNum];
	}
}
