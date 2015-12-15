package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Control type, Corresponding to ControlDevice
 * \else
 * 控制类型，对应ControlDevice接口
 * \endif
 */
public class CtrlType implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Reboot device
	 * \else
	 * 重启设备
	 * \endif
	 */
	public static final int     SDK_CTRL_REBOOT = 0;
	
	/**
	 * \if ENGLISH_LANG
	 * Shut down device
	 * \else
	 * 关闭设备
	 * \endif
	 */
	public static final int     SDK_CTRL_SHUTDOWN = 1;
	
	/**
	 * \if ENGLISH_LANG
	 * HDD management
	 * \else
	 * 硬盘管理
	 * \endif
	 */
	public static final int     SDK_CTRL_DISK = 2;
	
	/**
	 * \if ENGLISH_LANG
	 * Network keyboard
	 * \else
	 * 网络键盘
	 * \endif
	 */
	public static final int     SDK_KEYBOARD_POWER = 3;						
	public static final int     SDK_KEYBOARD_ENTER = 4;
	public static final int     SDK_KEYBOARD_ESC = 5;
	public static final int     SDK_KEYBOARD_UP = 6;
	public static final int     SDK_KEYBOARD_DOWN = 7;
	public static final int     SDK_KEYBOARD_LEFT = 8;
	public static final int     SDK_KEYBOARD_RIGHT = 9;
	public static final int     SDK_KEYBOARD_BTN0 = 10;
	public static final int     SDK_KEYBOARD_BTN1 = 11;
	public static final int     SDK_KEYBOARD_BTN2 = 12;
	public static final int     SDK_KEYBOARD_BTN3 = 13;
	public static final int     SDK_KEYBOARD_BTN4 = 14;
	public static final int     SDK_KEYBOARD_BTN5 = 15;
	public static final int     SDK_KEYBOARD_BTN6 = 16;
	public static final int     SDK_KEYBOARD_BTN7 = 17;
	public static final int     SDK_KEYBOARD_BTN8 = 18;
	public static final int     SDK_KEYBOARD_BTN9 = 19;
	public static final int     SDK_KEYBOARD_BTN10 = 20;
	public static final int     SDK_KEYBOARD_BTN11 = 21;
	public static final int     SDK_KEYBOARD_BTN12 = 22;
	public static final int     SDK_KEYBOARD_BTN13 = 23;
	public static final int     SDK_KEYBOARD_BTN14 = 24;
	public static final int     SDK_KEYBOARD_BTN15 = 25;
	public static final int     SDK_KEYBOARD_BTN16 = 26;
	public static final int     SDK_KEYBOARD_SPLIT = 27;
	public static final int     SDK_KEYBOARD_ONE = 28;
	public static final int     SDK_KEYBOARD_NINE = 29;
	public static final int     SDK_KEYBOARD_ADDR = 30;
	public static final int     SDK_KEYBOARD_INFO = 31;
	public static final int     SDK_KEYBOARD_REC = 32;
	public static final int     SDK_KEYBOARD_FN1 = 33;
	public static final int     SDK_KEYBOARD_FN2 = 34;
	public static final int     SDK_KEYBOARD_PLAY = 35;
	public static final int     SDK_KEYBOARD_STOP = 36;
	public static final int     SDK_KEYBOARD_SLOW = 37;
	public static final int     SDK_KEYBOARD_FAST = 38;
	public static final int     SDK_KEYBOARD_PREW = 39;
	public static final int     SDK_KEYBOARD_NEXT = 40;
	public static final int     SDK_KEYBOARD_JMPDOWN = 41;
	public static final int     SDK_KEYBOARD_JMPUP = 42;
	public static final int     SDK_KEYBOARD_10PLUS = 43;
	public static final int     SDK_KEYBOARD_SHIFT = 44;
	public static final int     SDK_KEYBOARD_BACK = 45;
	
	/**
	 * \if ENGLISH_LANG
	 * new network keyboard function
	 * \else
	 * 新网络键盘功能
	 * \endif
	 */
	public static final int     SDK_KEYBOARD_LOGIN = 46; 
	
	/**
	 * \if ENGLISH_LANG
	 * switch video channel
	 * \else
	 * 切换视频通道
	 * \endif
	 */
	public static final int     SDK_KEYBOARD_CHNNEL = 47; 
    
	/**
	 * \if ENGLISH_LANG
	 * Activate alarm input
	 * \else
	 * 触发报警输入
	 * \endif
	 */
	public static final int     SDK_TRIGGER_ALARM_IN = 100;
	
	/**
	 * \if ENGLISH_LANG
	 * Activate alarm output
	 * \else
	 * 触发报警输出
	 * \endif
	 */
	public static final int     SDK_TRIGGER_ALARM_OUT = 101;
	
	/**
	 * \if ENGLISH_LANG
	 * Matrix control
	 * \else
	 * 矩阵控制
	 * \endif
	 */
	public static final int     SDK_CTRL_MATRIX = 102;
	
	/**
	 * \if ENGLISH_LANG
	 * SD card control(for IPC series). Please refer to HDD control
	 * \else
	 * SD卡控制(IPC产品)参数同硬盘控制
	 * \endif
	 */
	public static final int     SDK_CTRL_SDCARD = 103;
	
	/**
	 * \if ENGLISH_LANG
	 * Burner control:begin burning 
	 * \else
	 * 刻录机控制，开始刻录
	 * \endif
	 */
	public static final int     SDK_BURNING_START = 104;
	
	/**
	 * \if ENGLISH_LANG
	 * Burner control:stop burning
	 * \else
	 * 刻录机控制，结束刻录
	 * \endif
	 */
	public static final int     SDK_BURNING_STOP = 105;
	
	/**
	 * \if ENGLISH_LANG
	 * Burner control:overlay password(The string ended with '\0'. Max length is 8 bits. )
	 * \else
	 * 刻录机控制，叠加密码(以'\0'为结尾的字符串，最大长度8位)
	 * \endif
	 */
	public static final int     SDK_BURNING_ADDPWD = 106;
	
	/**
	 * \if ENGLISH_LANG
	 * Burner control:overlay head title(The string ended with '\0'. Max length is 1024 bytes. Use '\n' to Enter.)
	 * \else
	 * 刻录机控制，叠加片头(以'\0'为结尾的字符串，最大长度1024字节，支持分行，行分隔符'\n')
	 * \endif
	 */
	public static final int     SDK_BURNING_ADDHEAD = 107;
	
	/**
	 * \if ENGLISH_LANG
	 * Burner control:overlay dot to the burned information(No parameter)
	 * \else
	 * 刻录机控制，叠加打点到刻录信息(参数无)
	 * \endif
	 */
	public static final int     SDK_BURNING_ADDSIGN = 108;
	
	/**
	 * \if ENGLISH_LANG
	 * Burner control:self-defined overlay (The string ended with '\0'. Max length is 1024 bytes. Use '\n' to Enter)
	 * \else
	 * 刻录机控制，自定义叠加(以'\0'为结尾的字符串，最大长度1024字节，支持分行，行分隔符'\n')
	 * \endif
	 */
	public static final int     SDK_BURNING_ADDCURSTOMINFO = 109;
	
	/**
	 * \if ENGLISH_LANG
	 * restore device default setup 
	 * \else
	 * 恢复设备的默认设置
	 * \endif
	 */
	public static final int     SDK_CTRL_RESTOREDEFAULT = 110;
	
	/**
	 * \if ENGLISH_LANG
	 * Activate device snapshot
	 * \else
	 * 触发设备抓图
	 * \endif
	 */
	public static final int     SDK_CTRL_CAPTURE_START = 111;
	
	/**
	 * \if ENGLISH_LANG
	 * Clear log
	 * \else
	 * 清除日志
	 * \endif
	 */
	public static final int     SDK_CTRL_CLEARLOG = 112;
	
	/**
	 * \if ENGLISH_LANG
	 * Activate wireless alarm (IPC series)
	 * \else
	 * 触发无线报警(IPC产品)
	 * \endif
	 */
	public static final int     SDK_TRIGGER_ALARM_WIRELESS = 200;
	
	/**
	 * \if ENGLISH_LANG
	 * Mark important record
	 * \else
	 * 标识重要录像文件
	 * \endif
	 */
	public static final int     SDK_MARK_IMPORTANT_RECORD = 201;
	
	/**
	 * \if ENGLISH_LANG
	 * Network hard disk partition
	 * \else
	 * 网络硬盘分区
	 * \endif
	 */
	public static final int     SDK_CTRL_DISK_SUBAREA = 202;
	
	/**
	 * \if ENGLISH_LANG
	 * Annex burning
	 * \else
	 * 刻录机控制，附件刻录.
	 * \endif
	 */
	public static final int     SDK_BURNING_ATTACH = 203;
	
	/**
	 * \if ENGLISH_LANG
	 * Burn Pause
	 * \else
	 * 刻录暂停
	 * \endif
	 */
	public static final int     SDK_BURNING_PAUSE = 204;
	
	/**
	 * \if ENGLISH_LANG
	 * Burn Resume
	 * \else
	 * 刻录继续
	 * \endif
	 */
	public static final int     SDK_BURNING_CONTINUE = 205;
	
	/**
	 * \if ENGLISH_LANG
	 * Burn Postponed
	 * \else
	 * 刻录顺延
	 * \endif
	 */
	public static final int     SDK_BURNING_POSTPONE = 206;
	
	/**
	 * \if ENGLISH_LANG
	 * OEM control
	 * \else
	 * 报停控制
	 * \endif
	 */
	public static final int     SDK_CTRL_OEMCTRL = 207;
	
	/**
	 * \if ENGLISH_LANG
	 * Start to device backup
	 * \else
	 * 设备备份开始
	 * \endif
	 */
	public static final int     SDK_BACKUP_START = 208;
	
	/**
	 * \if ENGLISH_LANG
	 * Stop to device backup
	 * \else
	 * 设备备份停止
	 * \endif
	 */
	public static final int     SDK_BACKUP_STOP = 209;
	
	/**
	 * \if ENGLISH_LANG
	 * Add WIFI configuration manually for car device
	 * \else
	 * 车载手动增加WIFI配置
	 * \endif
	 */
	public static final int     SDK_VIHICLE_WIFI_ADD = 210;
	
	/**
	 * \if ENGLISH_LANG
	 * Delete WIFI configuration manually for car device
	 * \else
	 * 车载手动删除WIFI配置
	 * \endif
	 */
	public static final int     SDK_VIHICLE_WIFI_DEC = 211;
	
	/**
	 * \if ENGLISH_LANG
	 * Start to buzzer control 
	 * \else
	 * 蜂鸣器控制开始
	 * \endif
	 */
	public static final int     SDK_BUZZER_START = 212;
	
	/**
	 * \if ENGLISH_LANG
	 * Stop to buzzer control
	 * \else
	 * 蜂鸣器控制结束
	 * \endif
	 */
	public static final int     SDK_BUZZER_STOP = 213;
	
	/**
	 * \if ENGLISH_LANG
	 * Reject User
	 * \else
	 * 剔除用户
	 * \endif
	 */
	public static final int     SDK_REJECT_USER = 214;
	
	/**
	 * \if ENGLISH_LANG
	 * Shield User
	 * \else
	 * 屏蔽用户
	 * \endif
	 */
	public static final int     SDK_SHIELD_USER = 215;
	
	/**
	 * \if ENGLISH_LANG
	 * Rain Brush 
	 * \else
	 * 智能交通, 雨刷控制 
	 * \endif
	 */
	public static final int     SDK_RAINBRUSH = 216;
	
	/**
	 * \if ENGLISH_LANG
	 * manual snap (struct MANUAL_SNAP_PARAMETER)
	 * \else
	 * 年智能交通, 手动抓拍 (对应结构体MANUAL_SNAP_PARAMETER)
	 * \endif
	 */
	public static final int     SDK_MANUAL_SNAP = 217;
	
	/**
	 * \if ENGLISH_LANG
	 * manual ntp time adjust
	 * \else
	 * 手动NTP校时
	 * \endif
	 */
	public static final int     SDK_MANUAL_NTP_TIMEADJUST = 218;
	
	/**
	 * \if ENGLISH_LANG
	 * navigation info and note
	 * \else
	 * 导航信息和短消息
	 * \endif
	 */
	public static final int     SDK_NAVIGATION_SMS = 219;
	
	/**
	 * \if ENGLISH_LANG
	 * route info
	 * \else
	 * 路线点位信息
	 * \endif
	 */
	public static final int     SDK_CTRL_ROUTE_CROSSING = 220;
	
	/**
	 * \if ENGLISH_LANG
	 * backup device format
	 * \else
	 * 格式化备份设备
	 * \endif
	 */
	public static final int     SDK_BACKUP_FORMAT = 221;
	
	/**
	 * \if ENGLISH_LANG
	 * local preview split(struct DEVICE_LOCALPREVIEW_SLIPT_PARAMETER)
	 * \else
	 * 控制设备端本地预览分割(对应结构体DEVICE_LOCALPREVIEW_SLIPT_PARAMETER)  
	 * \endif
	 */
	public static final int     SDK_DEVICE_LOCALPREVIEW_SLIPT = 222;
	
	/**
	 * \if ENGLISH_LANG
	 * RAID init
	 * \else
	 * RAID初始化
	 * \endif
	 */
	public static final int     SDK_CTRL_INIT_RAID = 223;
	
	/**
	 * \if ENGLISH_LANG
	 * RAID control
	 * \else
	 * RAID操作
	 * \endif
	 */
	public static final int     SDK_CTRL_RAID = 224;
	
	/**
	 * \if ENGLISH_LANG
	 * sapredisk control
	 * \else
	 * 热备盘操作
	 * \endif
	 */
	public static final int     SDK_CTRL_SAPREDISK = 225;
	
	/**
	 * \if ENGLISH_LANG
	 * wifi connect(struct WIFI_CONNECT)
	 * \else
	 * 手动发起WIFI连接(对应结构体WIFI_CONNECT)
	 * \endif
	 */
	public static final int     SDK_WIFI_CONNECT = 226;
	
	/**
	 * \if ENGLISH_LANG
	 * wifi disconnect(struct WIFI_CONNECT)
	 * \else
	 * 手动断开WIFI连接(对应结构体WIFI_CONNECT)
	 * \endif
	 */
	public static final int     SDK_WIFI_DISCONNECT = 227;
	
	/**
	 * \if ENGLISH_LANG
	 * Arm/disarm operation 
	 * \else
	 * 布撤防操作
	 * \endif
	 */
	public static final int     SDK_CTRL_ARMED = 228;
	
	/**
	 * \if ENGLISH_LANG
	 * IP modify(struct DHCTRL_IPMODIFY_PARAM)     
	 * \else
	 * 修改前端IP(对应结构体SDKCTRL_IPMODIFY_PARAM)  
	 * \endif
	 */
	public static final int     SDK_CTRL_IP_MODIFY = 229;
	
	/**
	 * \if ENGLISH_LANG
	 * wps connect wifi(struct DHCTRL_CONNECT_WIFI_BYWPS)
	 * \else
	 * wps连接wifi(对应结构体SDKCTRL_CONNECT_WIFI_BYWPS)
	 * \endif
	 */
	public static final int     SDK_CTRL_WIFI_BY_WPS = 230;
	
	/**
	 * \if ENGLISH_LANG
	 * format pattion (struct DH_FORMAT_PATITION)
	 * \else
	 * 格式化分区(对应结构体SDK_FORMAT_PATITION)
	 * \endif
	 */
	public static final int     SDK_CTRL_FORMAT_PATITION = 231;
	
	/**
	 * \if ENGLISH_LANG
	 * eject storage device(struct DH_EJECT_STORAGE_DEVICE)
	 * \else
	 * 手动卸载设备(对应结构体SDK_EJECT_STORAGE_DEVICE)
	 * \endif
	 */
	public static final int     SDK_CTRL_EJECT_STORAGE = 232;
	
	/**
	 * \if ENGLISH_LANG
	 * load storage device(struct DH_LOAD_STORAGE_DEVICE)
	 * \else
	 * 手动装载设备(对应结构体SDK_LOAD_STORAGE_DEVICE)
	 * \endif
	 */
	public static final int     SDK_CTRL_LOAD_STORAGE = 233;
	
	/**
	 * \if ENGLISH_LANG
	 * close burner(struct NET_CTRL_BURNERDOOR) need wait 6s
	 * \else
	 * 关闭刻录机光驱门(对应结构体 NET_CTRL_BURNERDOOR) 一般需要等6秒
	 * \endif
	 */
	public static final int     SDK_CTRL_CLOSE_BURNER = 234;
	
	/**
	 * \if ENGLISH_LANG
	 * eject burner(struct NET_CTRL_BURNERDOOR) need wait 4s
	 * \else
	 * 弹出刻录机光驱门(对应结构体 NET_CTRL_BURNERDOOR) 一般需要等4秒
	 * \endif
	 */
	public static final int     SDK_CTRL_EJECT_BURNER = 235;
	
	/**
	 * \if ENGLISH_LANG
	 * confirm alarm NET_CTRL_CLEAR_ALARM
	 * \else
	 * 消警(对应结构体 NET_CTRL_CLEAR_ALARM)
	 * \endif
	 */
	public static final int     SDK_CTRL_CLEAR_ALARM = 236;
	
	/**
	 * \if ENGLISH_LANG
	 * Monitorwall_TV info (struct  NET_CTRL_MONITORWALL_TVINFO)
	 * \else
	 * 电视墙信息显示(对应结构体 NET_CTRL_MONITORWALL_TVINFO)
	 * \endif
	 */
	public static final int     SDK_CTRL_MONITORWALL_TVINFO = 237;
	
	/**
	 * \if ENGLISH_LANG
	 * start Intelligent VIDEO analysis (corresponding structure NET CTRL START VIDEO ANALYSE)
	 * \else
	 * 开始视频智能分析(对应结构体 NET_CTRL_START_VIDEO_ANALYSE)
	 * \endif
	 */
	public static final int     SDK_CTRL_START_VIDEO_ANALYSE =   238; 
	
	/**
	 * \if ENGLISH_LANG
	 * STOP intelligent VIDEO analysis corresponding structure NET (CTRL STOP VIDEO ANALYSE)
	 * \else
	 * 停止视频智能分析(对应结构体 NET_CTRL_STOP_VIDEO_ANALYSE)
	 * \endif
	 */
	public static final int     SDK_CTRL_STOP_VIDEO_ANALYSE =   239;
	
	/**
	 * \if ENGLISH_LANG
	 * Controlled start equipment upgrades, independently complete the upgrade process by the equipment do not need to upgrade file
	 * \else
	 * 控制启动设备升级,由设备独立完成升级过程,不需要传输升级文件
	 * \endif
	 */
	public static final int     SDK_CTRL_UPGRADE_DEVICE =   240;
	
	/**
	 * \if ENGLISH_LANG
	 * Multi-channel preview playback channel switching corresponding structure NET (CTRL MULTIPLAYBACK CHANNALES)
	 * \else
	 * 切换多通道预览回放的通道(对应结构体 NET_CTRL_MULTIPLAYBACK_CHANNALES)
	 * \endif
	 */
	public static final int     SDK_CTRL_MULTIPLAYBACK_CHANNALES =   241;
	
	/**
	 * \if ENGLISH_LANG
	 * Turn on the switch power supply timing device output corresponding.net (CTRL SEQPOWER PARAM)
	 * \else
	 * 电源时序器打开开关量输出口(对应 NET_CTRL_SEQPOWER_PARAM)
	 * \endif
	 */
	public static final int     SDK_CTRL_SEQPOWER_OPEN =   242;
	
	/**
	 * \if ENGLISH_LANG
	 * Close the switch power supply timing device output corresponding.net (CTRL SEQPOWER PARAM)
	 * \else
	 * 电源时序器关闭开关量输出口(对应 NET_CTRL_SEQPOWER_PARAM)
	 * \endif
	 */
	public static final int     SDK_CTRL_SEQPOWER_CLOSE =   243;
	
	/**
	 * \if ENGLISH_LANG
	 * Power timing group open the switch quantity output corresponding.net (CTRL SEQPOWER PARAM)
	 * \else
	 * 电源时序器打开开关量输出口组(对应 NET_CTRL_SEQPOWER_PARAM)
	 * \endif
	 */
	public static final int     SDK_CTRL_SEQPOWER_OPEN_ALL =   244;
	
	/**
	 * \if ENGLISH_LANG
	 * Power sequence set close the switch quantity output corresponding.net (CTRL SEQPOWER PARAM)
	 * \else
	 * 电源时序器关闭开关量输出口组(对应 NET_CTRL_SEQPOWER_PARAM)
	 * \endif
	 */
	public static final int     SDK_CTRL_SEQPOWER_CLOSE_ALL =   245;
	
	/**
	 * \if ENGLISH_LANG
	 * PROJECTOR up corresponding.net (CTRL PROJECTOR PARAM)
	 * \else
	 * 投影仪上升(对应 NET_CTRL_PROJECTOR_PARAM)
	 * \endif
	 */
	public static final int     SDK_CTRL_PROJECTOR_RISE =   246;
	
	/**
	 * \if ENGLISH_LANG
	 * PROJECTOR drop (corresponding to the.net CTRL PROJECTOR PARAM)
	 * \else
	 * 投影仪下降(对应 NET_CTRL_PROJECTOR_PARAM)
	 * \endif
	 */
	public static final int     SDK_CTRL_PROJECTOR_FALL =   247;
	
	/**
	 * \if ENGLISH_LANG
	 * PROJECTOR stop (corresponding to the.net CTRL PROJECTOR PARAM)
	 * \else
	 * 投影仪停止(对应 NET_CTRL_PROJECTOR_PARAM)
	 * \endif
	 */
	public static final int     SDK_CTRL_PROJECTOR_STOP =   248;
	
	/**
	 * \if ENGLISH_LANG
	 * INFRARED buttons (corresponding to the.net CTRL INFRARED KEY PARAM)
	 * \else
	 * 红外按键(对应 NET_CTRL_INFRARED_KEY_PARAM)
	 * \endif
	 */
	public static final int     SDK_CTRL_INFRARED_KEY =   249;
	
	/**
	 * \if ENGLISH_LANG
	 * Device START playback of audio file corresponding structure NET (CTRL START PLAYAUDIO)
	 * \else
	 * 设备开始播放音频文件(对应结构体 NET_CTRL_START_PLAYAUDIO)
	 * \endif
	 */
	public static final int     SDK_CTRL_START_PLAYAUDIO =   250;
	
	/**
	 * \if ENGLISH_LANG
	 * Equipment stop playback of audio file
	 * \else
	 * 设备停止播放音频文件
	 * \endif
	 */
	public static final int     SDK_CTRL_STOP_PLAYAUDIO =   251;
	
	/**
	 * \if ENGLISH_LANG
	 * Corresponding structure NET open alarm (CTRL ALARMBELL)
	 * \else
	 * 开启警号(对应结构体 NET_CTRL_ALARMBELL)
	 * \endif
	 */
	public static final int     SDK_CTRL_START_ALARMBELL =   252;
	
	/**
	 * \if ENGLISH_LANG
	 * Close the warning signal corresponding structure NET (CTRL ALARMBELL)
	 * \else
	 * 关闭警号(对应结构体 NET_CTRL_ALARMBELL)
	 * \endif
	 */
	public static final int     SDK_CTRL_STOP_ALARMBELL =   253;
	
	/**
	 * \if ENGLISH_LANG
	 * OPEN ACCESS control - corresponding structure NET (CTRL ACCESS OPEN)
	 * \else
	 * 门禁控制-开门(对应结构体 NET_CTRL_ACCESS_OPEN)
	 * \endif
	 */
	public static final int     SDK_CTRL_ACCESS_OPEN =   254;
	
	/**
	 * \if ENGLISH_LANG
	 * Corresponding structure NET BYPASS function (CTRL SET BYPASS)
	 * \else
	 * 设置旁路功能(对应结构体 NET_CTRL_SET_BYPASS)
	 * \endif
	 */
	public static final int     SDK_CTRL_SET_BYPASS =   255;
	
	/**
	 * \if ENGLISH_LANG
	 * Add records to record set number (corresponding to the.net CTRL you INSERT PARAM)
	 * \else
	 * 添加记录，获得记录集编号(对应NET_CTRL_RECORDSET_INSERT_PARAM)
	 * \endif
	 */
	public static final int     SDK_CTRL_RECORDSET_INSERT =   256;
	
	/**
	 * \if ENGLISH_LANG
	 * Update a record of the number (corresponding to the.net CTRL you PARAM)
	 * \else
	 * 更新某记录集编号的记录(对应NET_CTRL_RECORDSET_PARAM)
	 * \endif
	 */
	public static final int     SDK_CTRL_RECORDSET_UPDATE =   257;
	
	/**
	 * \if ENGLISH_LANG
	 * According to the record set number to delete a record (corresponding to the.net CTRL you PARAM)
	 * \else
	 * 根据记录集编号删除某记录(对应NET_CTRL_RECORDSET_PARAM)
	 * \endif
	 */
	public static final int     SDK_CTRL_RECORDSET_REMOVE =   258;
	
	/**
	 * \if ENGLISH_LANG
	 * Remove all RECORDSET information corresponding.net (CTRL you PARAM)
	 * \else
	 * 清除所有记录集信息(对应NET_CTRL_RECORDSET_PARAM)
	 * \endif
	 */
	public static final int     SDK_CTRL_RECORDSET_CLEAR =   259;
	
	/**
	 * \if ENGLISH_LANG
	 * Entrance guard control - CLOSE corresponding structure NET (CTRL ACCESS CLOSE)
	 * \else
	 * 门禁控制-关门(对应结构体 NET_CTRL_ACCESS_CLOSE)
	 * \endif
	 */
	public static final int     SDK_CTRL_ACCESS_CLOSE =   260;
	
	/**
	 * \if ENGLISH_LANG
	 * Alarm sub system activation setup(corresponding structure NET_CTRL_ALARM_SUBSYSTEM_SETACTIVE)
	 * \else
	 * 报警子系统激活设置(对应结构体NET_CTRL_ALARM_SUBSYSTEM_SETACTIVE)
	 * \endif
	 */
	public static final int     SDK_CTRL_ALARM_SUBSYSTEM_ACTIVE_SET =   261;
	
	/**
	 * \if ENGLISH_LANG
	 * Disable device open gateway(corresponding to structure  NET_CTRL_FORBID_OPEN_STROBE)
	 * \else
	 * 禁止设备端开闸(对应结构体 NET_CTRL_FORBID_OPEN_STROBE)
	 * \endif
	 */
	public static final int     SDK_CTRL_FORBID_OPEN_STROBE =   262;
	
	/**
	 * \if ENGLISH_LANG
	 * Enable gateway(corresponding to structure  NET_CTRL_OPEN_STROBE)
	 * \else
	 * 开启道闸(对应结构体 NET_CTRL_OPEN_STROBE)
	 * \endif
	 */
	public static final int     SDK_CTRL_OPEN_STROBE =   263;
	
	/**
	 * \if ENGLISH_LANG
	 * Talk no response(corresponding to structure  NET_CTRL_TALKING_REFUSE)
	 * \else
	 * 对讲拒绝接听(对应结构体 NET_CTRL_TALKING_REFUSE)
	 * \endif
	 */
	public static final int     SDK_CTRL_TALKING_REFUSE =   264;
	
	/**
	 * \if ENGLISH_LANG
	 * arm-disarm operation(corresponding to structure CTRL_ARM_DISARM_PARAM_EX), CTRL_ARM_DISARM_PARAM upgrade，recommended
	 * \else
	 * 布撤防操作(对应结构体 CTRL_ARM_DISARM_PARAM_EX), 对CTRL_ARM_DISARM_PARAM 升级，建议用这个
	 * \endif
	 */
	public static final int     SDK_CTRL_ARMED_EX = 265;
	
	/**
	 * \if ENGLISH_LANG
	 * Net keyboard control(corresponding to structure  DHCTRL_NET_KEYBOARD)
	 * \else
	 * 网络键盘控制(对应结构体 DHCTRL_NET_KEYBOARD)
	 * \endif
	 */
    public static final int     SDK_CTRL_NET_KEYBOARD = 400;
    
    /**
	 * \if ENGLISH_LANG
	 * Open air conditioner(corresponding to structure  NET_CTRL_OPEN_AIRCONDITION)
	 * \else
	 * 打开空调(对应结构体 NET_CTRL_OPEN_AIRCONDITION)
	 * \endif
	 */
    public static final int     SDK_CTRL_AIRCONDITION_OPEN = 401;
    
    /**
	 * \if ENGLISH_LANG
	 * Close air-conditioner(corresponding to structure  NET_CTRL_CLOSE_AIRCONDITION)
	 * \else
	 * 关闭空调(对应结构体 NET_CTRL_CLOSE_AIRCONDITION)
	 * \endif
	 */
    public static final int     SDK_CTRL_AIRCONDITION_CLOSE = 402;
    
    /**
	 * \if ENGLISH_LANG
	 * Set temperature (corresponding to structure  NET_CTRL_SET_TEMPERATURE)
	 * \else
	 * 设定空调温度(对应结构体 NET_CTRL_SET_TEMPERATURE)
	 * \endif
	 */
    public static final int     SDK_CTRL_AIRCONDITION_SET_TEMPERATURE = 403;
    
    /**
	 * \if ENGLISH_LANG
	 * Adjust temperature(corresponding to structure  NET_CTRL_ADJUST_TEMPERATURE)
	 * \else
	 * 调节空调温度(对应结构体 NET_CTRL_ADJUST_TEMPERATURE)
	 * \endif
	 */
    public static final int     SDK_CTRL_AIRCONDITION_ADJUST_TEMPERATURE = 404;
    
    /**
	 * \if ENGLISH_LANG
	 * Set air work mode(corresponding to structure  NET_CTRL_ADJUST_TEMPERATURE)
	 * \else
	 * 设置空调工作模式(对应结构体 NET_CTRL_ADJUST_TEMPERATURE)
	 * \endif
	 */
    public static final int     SDK_CTRL_AIRCONDITION_SETMODE = 405;
    
    /**
	 * \if ENGLISH_LANG
	 * Set fan mode(corresponding to structure  NET_CTRL_AIRCONDITION_SETMODE)
	 * \else
	 * 设置空调送风模式(对应结构体 NET_CTRL_AIRCONDITION_SETMODE)
	 * \endif
	 */
    public static final int     SDK_CTRL_AIRCONDITION_SETWINDMODE = 406;
    
    /**
	 * \if ENGLISH_LANG
	 * Recover device default and set new protocol(corresponding to structure NET_CTRL_RESTORE_DEFAULT)
	 * Recover config and use this enumeration first, if port failed,
	 * and CLIENT_GetLastError return NET_UNSUPPORTED, try again DH_CTRL_RESTOREDEFAULT restore config
	 * \else
	 * 恢复设备的默认设置新协议(对应结构体NET_CTRL_RESTORE_DEFAULT)
	 * 恢复配置优先使用该枚举，如果接口失败，
	 * 且CLIENT_GetLastError返回NET_UNSUPPORTED,再尝试使用SDK_CTRL_RESTOREDEFAULT恢复配置
	 * \endif
	 */
    public static final int     SDK_CTRL_RESTOREDEFAULT_EX  = 407;
    
    /**
	 * \if ENGLISH_LANG
	 * send event to device (corresponding to  structure  NET_NOTIFY_EVENT_DATA)
	 * \else
	 * 向设备发送事件(对应结构体 NET_NOTIFY_EVENT_DATA)
	 * \endif
	 */
    public static final int     SDK_CTRL_NOTIFY_EVENT = 408;
    
    /**
	 * \if ENGLISH_LANG
	 * mute alarm setup
	 * \else
	 * 无声报警设置
	 * \endif
	 */
    public static final int     SDK_CTRL_SILENT_ALARM_SET = 409;
    
    /**
	 * \if ENGLISH_LANG
	 * device start sound report(corresponding to  structure  NET_CTRL_START_PLAYAUDIOEX)
	 * \else
	 * 设备开始语音播报(对应结构体 NET_CTRL_START_PLAYAUDIOEX)
	 * \endif
	 */
	public static final int     SDK_CTRL_START_PLAYAUDIOEX = 410;
	
	/**
	 * \if ENGLISH_LANG
	 * device stop sound report
	 * \else
	 * 设备停止语音播报
	 * \endif
	 */
    public static final int     SDK_CTRL_STOP_PLAYAUDIOEX = 411;
    
    /**
	 * \if ENGLISH_LANG
	 * close gateway(corresponding to  structure  NET_CTRL_CLOSE_STROBE)
	 * \else
	 * 关闭道闸(对应结构体 NET_CTRL_CLOSE_STROBE)
	 * \endif
	 */
    public static final int     SDK_CTRL_CLOSE_STROBE = 412;
    
    /**
	 * \if ENGLISH_LANG
	 * set parking reservation status (corresponding to  structure  NET_CTRL_SET_ORDER_STATE)
	 * \else
	 * 设置车位预定状态(对应结构体 NET_CTRL_SET_ORDER_STATE)
	 * \endif
	 */
	public static final int     SDK_CTRL_SET_ORDER_STATE = 413;
	
	/**
	 * \if ENGLISH_LANG
	 * add record，get record collection no.(corresponding to NET_CTRL_RECORDSET_INSERT_PARAM)
	 * \else
	 * 添加记录，获得记录集编号(对应NET_CTRL_RECORDSET_INSERT_PARAM)
	 * \endif
	 */
	public static final int     SDK_CTRL_RECORDSET_INSERTEX = 414;
	
	/**
	 * \if ENGLISH_LANG
	 * update record set no.’s record(corresponding to NET_CTRL_RECORDSET_PARAM)
	 * \else
	 * 更新某记录集编号的记录(对应NET_CTRL_RECORDSET_PARAM)
	 * \endif
	 */
    public static final int     SDK_CTRL_RECORDSET_UPDATEEX = 415;
    
    /**
	 * \if ENGLISH_LANG
	 * fingerprint collection (corresponding to structure NET_CTRL_CAPTURE_FINGER_PRINT)
	 * \else
	 * 指纹采集(对应结构体 NET_CTRL_CAPTURE_FINGER_PRINT)
	 * \endif
	 */
    public static final int     SDK_CTRL_CAPTURE_FINGER_PRINT = 416;
    
    /**
	 * \if ENGLISH_LANG
	 * Parking lot entrance/exit controller LED setup(corresponding structure  NET_CTRL_ECK_LED_SET_PARAM)
	 * \else
	 * 停车场出入口控制器LED设置(对应结构体 NET_CTRL_ECK_LED_SET_PARAM)
	 * \endif
	 */
	public static final int     SDK_CTRL_ECK_LED_SET = 417;
	
	/**
	 * \if ENGLISH_LANG
	 * Intelligent parking system in/out device IC card info import (corresponding structure  NET_CTRL_ECK_IC_CARD_IMPORT_PARAM)
	 * \else
	 * 智能停车系统出入口机IC卡信息导入(对应结构体 NET_CTRL_ECK_IC_CARD_IMPORT_PARAM)
	 * \endif
	 */
    public static final int     SDK_CTRL_ECK_IC_CARD_IMPORT = 418;
    
    /**
	 * \if ENGLISH_LANG
	 * Intelligent parking system in/out device IC card info sync command, receive this command, device will delete original IC card info(corresponding structure  NET_CTRL_ECK_SYNC_IC_CARD_PARAM)
	 * \else
	 * 智能停车系统出入口机IC卡信息同步指令，收到此指令后，设备删除原有IC卡信息(对应结构体 NET_CTRL_ECK_SYNC_IC_CARD_PARAM)
	 * \endif
	 */
    public static final int     SDK_CTRL_ECK_SYNC_IC_CARD = 419;
    
    /**
	 * \if ENGLISH_LANG
	 * Delete specific wireless device(corresponding structure  NET_CTRL_LOWRATEWPAN_REMOVE)
	 * \else
	 * 删除指定无线设备(对应结构体 NET_CTRL_LOWRATEWPAN_REMOVE)
	 * \endif
	 */
    public static final int     SDK_CTRL_LOWRATEWPAN_REMOVE = 420;
    
    /**
	 * \if ENGLISH_LANG
	 * Modify wireless device info(corresponding structure  NET_CTRL_LOWRATEWPAN_MODIFY)
	 * \else
	 * 修改无线设备信息(对应结构体 NET_CTRL_LOWRATEWPAN_MODIFY)
	 * \endif
	 */
    public static final int     SDK_CTRL_LOWRATEWPAN_MODIFY = 421;
    
    /**
	 * \if ENGLISH_LANG
	 * Set up the vehicle spot information of the machine at the passageway of the intelligent parking system (corresponding to  NET_CTRL_ECK_SET_PARK_INFO_PARAM)
	 * \else
	 * 智能停车系统出入口机设置车位信息(对应结构体 NET_CTRL_ECK_SET_PARK_INFO_PARAM)
	 * \endif
	 */
    public static final int     SDK_CTRL_ECK_SET_PARK_INFO = 422;
    
    /**
	 * \if ENGLISH_LANG
	 * hang up the video phone (corresponding to NET_CTRL_VTP_DISCONNECT)
	 * \else
	 * 挂断视频电话(对应结构体 NET_CTRL_VTP_DISCONNECT)
	 * \endif
	 */
	public static final int     SDK_CTRL_VTP_DISCONNECT = 423;
}
