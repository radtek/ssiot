package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Video encode widget config
 * \else
 * 视频编码物件配置
 * \endif
 */
public class AV_CFG_VideoWidget implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Channel title
	 * \else
	 * 通道标题
	 * \endif
	 */
	public AV_CFG_VideoWidgetChannelTitle	stuChannelTitle = new AV_CFG_VideoWidgetChannelTitle();	

	/**
	 * \if ENGLISH_LANG
	 * Time title
	 * \else
	 * 时间标题
	 * \endif
	 */
	public AV_CFG_VideoWidgetTimeTitle		stuTimeTitle = new AV_CFG_VideoWidgetTimeTitle();

	/**
	 * \if ENGLISH_LANG
	 * Privacy mask zone amount
	 * \else
	 * 区域覆盖数量
	 * \endif
	 */
	public int								nConverNum;		

	/**
	 * \if ENGLISH_LANG
	 * Privacy mask zone
	 * \else
	 * 覆盖区域
	 * \endif
	 */
	public AV_CFG_VideoWidgetCover			stuCovers[] = new AV_CFG_VideoWidgetCover[FinalVar.AV_CFG_Max_Video_Widget_Cover];

	/**
	 * \if ENGLISH_LANG
	 *  Self-defined title amount
	 * \else
	 * 自定义标题数量
	 * \endif
	 */
	public int								nCustomTitleNum;	

	/**
	 * \if ENGLISH_LANG
	 * Self-defined title
	 * \else
	 * 自定义标题
	 * \endif
	 */
	public AV_CFG_VideoWidgetCustomTitle	stuCustomTitle[] = new AV_CFG_VideoWidgetCustomTitle[FinalVar.AV_CFG_Max_Video_Widget_Custom_Title];

	/**
	 * \if ENGLISH_LANG
	 * The number of sensor information overlay area
	 * \else
	 * 传感器信息叠加区域数目
	 * \endif
	 */
	public int								nSensorInfo;		

	/**
	 * \if ENGLISH_LANG
	 * Sensor information overlay zone information
	 * \else
	 * 传感器信息叠加区域信息
	 * \endif
	 */
	public AV_CFG_VideoWidgetSensorInfo		stuSensorInfo[] = new AV_CFG_VideoWidgetSensorInfo[FinalVar.AV_CFG_Max_Video_Widget_Sensor_Info];		
	
	public AV_CFG_VideoWidget() {
		for (int i =0 ; i<FinalVar.AV_CFG_Max_Video_Widget_Cover;i++) {
			stuCovers[i] = new AV_CFG_VideoWidgetCover();
		}
		
		for (int i =0 ; i<FinalVar.AV_CFG_Max_Video_Widget_Custom_Title; i++) {
			stuCustomTitle[i] = new AV_CFG_VideoWidgetCustomTitle();
		}
		
		for (int i =0 ; i<FinalVar.AV_CFG_Max_Video_Widget_Sensor_Info; i++) {
			stuSensorInfo[i] = new AV_CFG_VideoWidgetSensorInfo();
		}
	}
}
