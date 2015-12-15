package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * The media file information searched by SDK_MEDIA_QUERY_TRAFFICCAR
 * \else
 * SDK_MEDIA_QUERY_TRAFFICCAR查询出来的media文件信息
 * \endif
 */
public class MEDIAFILE_TRAFFICCAR_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Channel number
	 * \else
	 * 通道号
	 * \endif
	 */
	public int        ch;
	
	/**
	 * \if ENGLISH_LANG
	 * File path
	 * \else
	 * 文件路径
	 * \endif
	 */
	public char			szFilePath[] 		= new char[128];
	
	/**
	 * \if ENGLISH_LANG
	 * File length
	 * \else
	 * 文件长度
	 * \endif
	 */
	public int        size;

	/**
	 * \if ENGLISH_LANG
	 * Start time
	 * \else
	 * 开始时间
	 * \endif
	 */
	public NET_TIME            starttime = new NET_TIME();

	/**
	 * \if ENGLISH_LANG
	 * End time
	 * \else
	 * 结束时间
	 * \endif
	 */
	public NET_TIME            endtime = new NET_TIME();

	/**
	 * \if ENGLISH_LANG
	 * Working directory serial number
	 * \else
	 * 工作目录编号
	 * \endif
	 */
	public int        nWorkDirSN;

	/**
	 * \if ENGLISH_LANG
	 * File type.  1:jpg file
	 * \else
	 * 文件类型  1：jpg图片
	 * \endif
	 */
	public byte                nFileType;

	/**
	 * \if ENGLISH_LANG
	 * File location index
	 * \else
	 * 文件定位索引
	 * \endif
	 */
	public byte                bHint;

	/**
	 * \if ENGLISH_LANG
	 * drive number
	 * \else
	 * 磁盘号
	 * \endif
	 */
	public byte                bDriveNo;

	/**
	 * \if ENGLISH_LANG
	 * cluster number
	 * \else
	 * 簇号
	 * \endif
	 */
	public int        nCluster;

	/**
	 * \if ENGLISH_LANG
	 * flags
	 * \else
	 * 图片类型, 0-普通, 1-合成, 2-抠图
	 * \endif
	 */
	public byte                byPictureType;

	//以下是交通车辆信息
	
	/**
	 * \if ENGLISH_LANG
	 * Vehicle plate number
	 * \else
	 * 车牌号码
	 * \endif
	 */
	public char			szPlateNumber[] 	= new char[32];
	
	/**
	 * \if ENGLISH_LANG
	 * Plate type: "Unknown" =Unknown; "Normal"=Blue and black plate. "Yellow"=Yellow plate. "DoubleYellow"=Double-layer yellow plate
	 * "Police"=Police plate ; "Armed"= =Military police plate; "Military"=Army plate; "DoubleMilitary"=Army double-layer 
	 * "SAR" =HK SAR or Macao SAR plate; "Trainning" =rehearsal plate; "Personal"=Personal plate; "Agri"=Agricultural plate
	 * "Embassy"=Embassy plate; "Moto"=Moto plate ; "Tractor"=Tractor plate; "Other"=Other plate 
	 * \else
	 * 号牌类型"Unknown" 未知; "Normal" 蓝牌黑牌; "Yellow" 黄牌; "DoubleYellow" 双层黄尾牌
	 * "Police" 警牌; "Armed" 武警牌; "Military" 部队号牌; "DoubleMilitary" 部队双层
	 * "SAR" 港澳特区号牌; "Trainning" 教练车号牌; "Personal" 个性号牌; "Agri" 农用牌
	 * "Embassy" 使馆号牌; "Moto" 摩托车号牌; "Tractor" 拖拉机号牌; "Other" 其他号牌
	 * \endif
	 */
	public char			szPlateType[] 		= new char[32];
	
	/**
	 * \if ENGLISH_LANG
	 * Plate color:"Blue","Yellow", "White","Black"
	 * \else
	 * 车牌颜色:"Blue","Yellow", "White","Black"
	 * \endif
	 */
	public char			szPlateColor[] 		= new char[16];
	
	/**
	 * \if ENGLISH_LANG
	 * Vehicle color:"White", "Black", "Red", "Yellow", "Gray", "Blue","Green"
	 * \else
	 * 车身颜色:"White", "Black", "Red", "Yellow", "Gray", "Blue","Green"
	 * \endif
	 */
	public char			szVehicleColor[] 	= new char[16];
	
	/**
	 * \if ENGLISH_LANG
	 * Speed. The unit is Km/H
	 * \else
	 * 车速,单位Km/H
	 * \endif
	 */
	public int                 nSpeed;

	/**
	 * \if ENGLISH_LANG
	 * Activation event amount
	 * \else
	 * 关联的事件个数
	 * \endif
	 */
	public int                 nEventsNum;

	/**
	 * \if ENGLISH_LANG
	 * Activation event list. The number refers to the corresponding event. Please refer to Intelligent Analytics Event Type.
	 * \else
	 * 关联的事件列表,数组值表示相应的事件，详见"智能分析事件类型"
	 * \endif
	 */
	public int                 nEvents[] = new int[32];

	/**
	 * \if ENGLISH_LANG
	 * Detailed offense type subnet mask. The first bit means redlight offense, the second bit is illegal straight/left-turn/right-turn driving.
	 * The third bit is the wrong way driving; the four bit is illegal U-turn. Otherwise default value is intersection accident. 
	 * \else
	 * 具体违章类型掩码,第一位:闯红灯; 第二位:不按规定车道行驶;
	 * 第三位:逆行; 第四位：违章掉头;否则默认为:交通路口事件
	 * \endif
	 */	
	public long			dwBreakingRule;
	
	/**
	 * \if ENGLISH_LANG
	 * Vehicle type:"Light-duty"=small;"Medium"=medium; "Oversize"=large
	 * \else
	 * 车辆大小类型:"Light-duty":小型车;"Medium":中型车; "Oversize":大型车
	 * \endif
	 */
	public char			szVehicleSize[] 	= new char[16];
	
	/**
	 * \if ENGLISH_LANG
	 * Local or remote channel name
	 * \else
	 * 本地或远程的通道名称
	 * \endif
	 */
	public char			szChannelName[]		= new char[FinalVar.SDK_CHAN_NAME_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Local or remote device name
	 * \else
	 * 本地或远程设备名称
	 * \endif
	 */
	public char			szMachineName[] 	= new char[FinalVar.SDK_MAX_NAME_LEN];

	/**
	 * \if ENGLISH_LANG
	 * up limit of speed, km/h
	 * \else
	 * 速度上限 单位: km/h
	 * \endif
	 */
	public int                 nSpeedUpperLimit;

	/**
	 * \if ENGLISH_LANG
	 * lower limit of speed km/h
	 * \else
	 * 速度下限 单位: km/h
	 * \endif
	 */
	public int                 nSpeedLowerLimit;

	/**
	 * \if ENGLISH_LANG
	 * id of event group
	 * \else
	 * 事件里的组编号
	 * \endif
	 */
	public int                 nGroupID;

	/**
	 * \if ENGLISH_LANG
	 * total count of the event group
	 * \else
	 * 一个事件组内的抓拍张数
	 * \endif
	 */
	public byte                byCountInGroup;

	/**
	 * \if ENGLISH_LANG
	 * the index of this event
	 * \else
	 * 一个事件组内的抓拍序号
	 * \endif
	 */
	public byte                byIndexInGroup;

	/**
	 * \if ENGLISH_LANG
	 * lane number
	 * \else
	 * 车道,参见MEDIA_QUERY_TRAFFICCAR_PARAM
	 * \endif
	 */
	public byte                byLane;
	
	/**
	 * \if ENGLISH_LANG
	 * direction,MEDIA_QUERY_TRAFFICCAR_PARAM
	 * \else
	 * 车道方向,参见MEDIA_QUERY_TRAFFICCAR_PARAM
	 * \endif
	 */
	public int			nDirection;
	
	/**
	 * \if ENGLISH_LANG
	 * machine address
	 * \else
	 * 机器部署地点
	 * \endif
	 */
	public char      	szMachineAddress[] 	= new char[FinalVar.MAX_PATH];
}
