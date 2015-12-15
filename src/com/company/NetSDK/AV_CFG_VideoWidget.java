package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Video encode widget config
 * \else
 * ��Ƶ�����������
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
	 * ͨ������
	 * \endif
	 */
	public AV_CFG_VideoWidgetChannelTitle	stuChannelTitle = new AV_CFG_VideoWidgetChannelTitle();	

	/**
	 * \if ENGLISH_LANG
	 * Time title
	 * \else
	 * ʱ�����
	 * \endif
	 */
	public AV_CFG_VideoWidgetTimeTitle		stuTimeTitle = new AV_CFG_VideoWidgetTimeTitle();

	/**
	 * \if ENGLISH_LANG
	 * Privacy mask zone amount
	 * \else
	 * ���򸲸�����
	 * \endif
	 */
	public int								nConverNum;		

	/**
	 * \if ENGLISH_LANG
	 * Privacy mask zone
	 * \else
	 * ��������
	 * \endif
	 */
	public AV_CFG_VideoWidgetCover			stuCovers[] = new AV_CFG_VideoWidgetCover[FinalVar.AV_CFG_Max_Video_Widget_Cover];

	/**
	 * \if ENGLISH_LANG
	 *  Self-defined title amount
	 * \else
	 * �Զ����������
	 * \endif
	 */
	public int								nCustomTitleNum;	

	/**
	 * \if ENGLISH_LANG
	 * Self-defined title
	 * \else
	 * �Զ������
	 * \endif
	 */
	public AV_CFG_VideoWidgetCustomTitle	stuCustomTitle[] = new AV_CFG_VideoWidgetCustomTitle[FinalVar.AV_CFG_Max_Video_Widget_Custom_Title];

	/**
	 * \if ENGLISH_LANG
	 * The number of sensor information overlay area
	 * \else
	 * ��������Ϣ����������Ŀ
	 * \endif
	 */
	public int								nSensorInfo;		

	/**
	 * \if ENGLISH_LANG
	 * Sensor information overlay zone information
	 * \else
	 * ��������Ϣ����������Ϣ
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
