package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * External Alarm Configuration
 * \else
 * �ⲿ��������
 * \endif
 */
public class CFG_ALARMIN_INFO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * \if ENGLISH_LANG
	 * Alarm Channel No.(0 Start) 
	 * \else
	 * ����ͨ����(0��ʼ)
	 * \endif
	 */
	public int					nChannelID;
	
	/**
	 * \if ENGLISH_LANG
	 * Enable Switch 
	 * \else
	 * ʹ�ܿ���
	 * \endif
	 */
	public boolean				bEnable;
	
	/**
	 * \if ENGLISH_LANG
	 * Alarm Channel Name 
	 * \else
	 * ����ͨ������
	 * \endif
	 */
	public char					szChnName[] = new char[FinalVar.MAX_CHANNELNAME_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * Sensor Name. 0:Normal Closed,1:Normal Open
	 * \else
	 * ����������,0:����,1:����
	 * \endif
	 */
	public int					nAlarmType;
	
	/**
	 * \if ENGLISH_LANG
	 * Alarm Linkage 
	 * \else
	 * ��������
	 * \endif
	 */
	public CFG_ALARM_MSG_HANDLE stuEventHandler = new CFG_ALARM_MSG_HANDLE();
	
	/**
	 * \if ENGLISH_LANG
	 * Event Respond Time Section 
	 * \else
	 * �¼���Ӧʱ���
	 * \endif
	 */
	public CFG_TIME_SECTION		stuTimeSection[][] = new CFG_TIME_SECTION[FinalVar.WEEK_DAY_NUM][FinalVar.MAX_REC_TSECT];

	public boolean				abDevID;
	
	/**
	 * \if ENGLISH_LANG
	 * device ID 
	 * \else
	 * �豸ID
	 * \endif
	 */
	public char					szDevID[] = new char[FinalVar.MAX_NAME_LEN];
	
	/**
	 * \if ENGLISH_LANG
	 * sensor trigger mode, 0: highly effective��1 low effective; sensor grounding or power��and group with nAlarmType 
	 * \else
	 * ����������ģʽ, 0:����Ч,1����Ч; �������Ϊ�������ӵ�or��Դ,��nAlarmType���ʹ��
	 * \endif
	 */
	public int                  nPole;                                      
	                                                                
	/**
	 * \if ENGLISH_LANG
	 * sensor type, EM_SENSE_METHOD
	 * \else
	 * ��������Ӧ��ʽ, EM_SENSE_METHOD
	 * \endif
	 */
	public int				     emSense;
	
	/**
	 * \if ENGLISH_LANG
	 * Alarm enable control, EM_CTRL_ENABLE
	 * \else
	 * ����ʹ�ܿ��Ʒ�ʽ, EM_CTRL_ENABLE
	 * \endif
	 */
	public int                   emCtrl;
	
	/**
	 * \if ENGLISH_LANG
	 * delay disarm , in s,0~300,emCtrl value is EM_CTRL_NORMAL or EM_CTRL_ALWAYS_EN effective 
	 * \else
	 * ��ʱ����ʱ��,��λΪ��,0~300,emCtrlֵΪEM_CTRL_NORMAL��EM_CTRL_ALWAYS_EN ʱ��Ч.
	 * \endif
	 */
	public int                  nDisDelay;                                  
	
	public CFG_ALARMIN_INFO() {
		for (int i = 0; i < FinalVar.WEEK_DAY_NUM; i++) {
			for (int j = 0; j < FinalVar.MAX_REC_TSECT; j++) {
				stuTimeSection[i][j] = new CFG_TIME_SECTION();
			}
		}
	}
}
