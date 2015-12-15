package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * TrafficCar
 * \else
 * 交通车辆信息
 * \endif
 */
public class DEV_EVENT_TRAFFIC_TRAFFICCAR_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Plate number
	 * \else
	 * 车牌号码
	 * \endif
	 */
	public byte               szPlateNumber[] 	= new byte[32];          
	/**
	 * \if ENGLISH_LANG
	 * Plate type
	 * \else
	 * 号牌类型	参见VideoAnalyseRule中车牌类型定义
	 * \endif
	 */
	public byte               szPlateType[] 	= new byte[32];          
	/**
	 * \if ENGLISH_LANG
	 * plate color, "Blue","Yellow", "White","Black"
	 * \else
	 * 车牌颜色	"Blue","Yellow", "White","Black"
	 * \endif
	 */
	public byte               szPlateColor[] 	= new byte[32];          
	/**
	 * \if ENGLISH_LANG
	 * vehicle color, "White", "Black", "Red", "Yellow", "Gray", "Blue","Green"
	 * \else
	 * 车身颜色	"White", "Black", "Red", "Yellow", "Gray", "Blue","Green"
	 * \endif
	 */
	public byte               szVehicleColor[] = new byte[32];          
	/**
	 * \if ENGLISH_LANG
	 * speed, Km/H
	 * \else
	 * 速度	单位Km/H
	 * \endif
	 */
	public int                nSpeed;                          		 
	/**
	 * \if ENGLISH_LANG
	 * trigger event type
	 * \else
	 * 触发的相关事件	参见事件列表Event List，只包含交通相关事件。
	 * \endif
	 */
	public byte               szEvent[] = new byte[64];                 
	/**
	 * \if ENGLISH_LANG
	 * violation code, see TrafficGlobal.ViolationCode
	 * \else
	 * 违章代码	详见TrafficGlobal.ViolationCode
	 * \endif
	 */
	public byte               szViolationCode[] = new byte[32];         
	/**
	 * \if ENGLISH_LANG
	 * violation describe
	 * \else
	 * 违章描述
	 * \endif
	 */
	public byte               szViolationDesc[] = new byte[64];         
	/**
	 * \if ENGLISH_LANG
	 * lower speed limit
	 * \else
	 * 速度下限
	 * \endif
	 */
	public int                nLowerSpeedLimit;                
	/**
	 * \if ENGLISH_LANG
	 * upper speed limit
	 * \else
	 * 速度上限
	 * \endif
	 */
	public int                nUpperSpeedLimit;                
	/**
	 * \if ENGLISH_LANG
	 * over speed margin, km/h 
	 * \else
	 * 限高速宽限值	单位：km/h
	 * \endif
	 */
	public int                nOverSpeedMargin;                 
	/**
	 * \if ENGLISH_LANG
	 * under speed margin, km/h 
	 * \else
	 * 限低速宽限值	单位：km/h 
	 * \endif
	 */
	public int                nUnderSpeedMargin;               
	/**
	 * \if ENGLISH_LANG
	 * lane
	 * \else
	 * 车道	参见事件列表Event List中卡口和路口事件。
	 * \endif
	 */
	public int                nLane;                           
	/**
	 * \if ENGLISH_LANG
	 * vehicle size, see VideoAnalyseRule's describe
	 * \else
	 * 车辆大小,-1表示未知，否则按位
	 * 第0位:"Light-duty", 小型车
	 * 第1位:"Medium", 中型车
	 * 第2位:"Oversize", 大型车
	 * 第3位:"Minisize", 微型车
	 * 第4位:"Largesize", 长车
	 * \endif
	 */
	public int                nVehicleSize;                    

	/**
	 * \if ENGLISH_LANG
	 * vehicle length, (m)
	 * \else
	 * 车辆长度	单位米
	 * \endif
	 */
	public float             fVehicleLength;                  
	/**
	 * \if ENGLISH_LANG
	 * snap mode 0-normal,1-globle,2-near,4-snap on the same side,8-snap on the reverse side,16-plant picture
	 * \else
	 * 抓拍方式	0-未分类，1-全景，2-近景，4-同向抓拍，8-反向抓拍，16-号牌图像
	 * \endif
	 */
	public int                nSnapshotMode;                   
	/**
	 * \if ENGLISH_LANG
	 * channel name
	 * \else
	 * 本地或远程的通道名称，可以是地点信息	来源于通道标题配置ChannelTitle.Name 
	 * \endif
	 */
	public byte               szChannelName[] = new byte[32];               
	/**
	 * \if ENGLISH_LANG
	 * Machine name
	 * \else
	 * 本地或远程设备名称	来源于普通配置General.MachineName
	 * \endif
	 */
	public byte               szMachineName[] = new byte[256];              
	/**
	 * \if ENGLISH_LANG
	 * machine group
	 * \else
	 * 机器分组或叫设备所属单位	默认为空，用户可以将不同的设备编为一组，便于管理，可重复。
	 * \endif
	 */
	public byte               szMachineGroup[] = new byte[256];             
	/**
	 * \if ENGLISH_LANG
	 * road way number	
	 * \else
	 * 道路编号
	 * \endif
	 */
	public byte               szRoadwayNo[] = new byte[64];                 
	/**
	 * \if ENGLISH_LANG
	 * DrivingDirection: for example ["Approach", "Shanghai", "Hangzhou"]
	 * "Approach" means driving direction,where the car is more near;"Leave"-means where if mor far to the car
	 * the second and third param means the location of the driving direction
	 * \else
     * "DrivingDirection" : ["Approach", "上海", "杭州"],行驶方向
     * "Approach"-上行，即车辆离设备部署点越来越近；"Leave"-下行，
     * 即车辆离设备部署点越来越远，第二和第三个参数分别代表上行和
     * 下行的两个地点
	 * \endif
	 */
	public byte               szDrivingDirection[][] = new byte[3][FinalVar.SDK_MAX_DRIVINGDIRECTION];    
	/**
	 * \if ENGLISH_LANG
	 * device address,OSD superimposed onto the image,from TrafficSnapshot.DeviceAddress,'\0'means end.
	 * \else
	 * 设备地址,OSD叠加到图片上的,来源于配置TrafficSnapshot.DeviceAddress,'\0'结束
	 * \endif
	 */
	public byte[]             szDeviceAddress;                 
	/**
	 * \if ENGLISH_LANG
	 * Vehicle mark, such as "Unknown"-unknown, "Audi"-Audi, "Honda"-Honda ...
	 * \else
	 * 车辆标识, 例如 "Unknown"-未知, "Audi"-奥迪, "Honda"-本田 ...
	 * \endif
	 */
	public byte			   szVehicleSign[] = new byte[32];				
	/**
	 * \if ENGLISH_LANG
	 * Vehicle detector generated snapshot signal redundant info
	 * \else
	 * 由车检器产生抓拍信号冗余信息
	 * \endif
	 */
	public SDK_SIG_CARWAY_INFO_EX stuSigInfo = new SDK_SIG_CARWAY_INFO_EX();                   
	/**
	 * \if ENGLISH_LANG
	 * Device allocation location
	 * \else
	 * 设备部署地点
	 * \endif
	 */
	public byte[]			   szMachineAddr;					
	/**
	 * \if ENGLISH_LANG
	 * Current picture exposure time，unit is ms
	 * \else
	 * 当前图片曝光时间，单位为毫秒
	 * \endif
	 */
	public double              fActualShutter;                  
	/**
	 * \if ENGLISH_LANG
	 * Current picture gain，range is 0~100
	 * \else
	 * 当前图片增益，范围为0~100
	 * \endif
	 */
	public byte               byActualGain;                    
	/**
	 * \if ENGLISH_LANG
	 * 0-S to N 1-SW to NE 2-W to E 3-NW to SE 4-N to S 5-NE to SW 6-E to W 7-SE to NW 8-Unknown
	 * \else
	 * 0-南向北 1-西南向东北 2-西向东 3-西北向东南 4-北向南 5-东北向西南 6-东向西 7-东南向西北 8-未知
	 * \endif
	 */
	public byte			   byDirection;						
	/**
	 * \if ENGLISH_LANG
	 * Detailed addreaa, as szDeviceAddress compensation
	 * \else
	 * 详细地址, 作为szDeviceAddress的补充
	 * \endif
	 */
	public byte[]			   szDetailedAddress;				
}
