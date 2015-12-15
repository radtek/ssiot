package com.company.NetSDK;

import java.io.Serializable;

public class CFG_CAP_ALARM_INFO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * \if ENGLISH_LANG
	 * Device support PIR alarm or not(thermal sensors),a kind of external alarm
	 * \else
	 * �豸�Ƿ�֧��PIR(������ʽ��Ӧ��)����,�ⲿ������һ��
	 * \endif
	 */
	public boolean                 bAlarmPir;
	
	/**
	 * \if ENGLISH_LANG
	 * Device support flash light of not
	 * \else
	 * �豸�Ƿ�֧�ֲ����
	 * \endif
	 */
	public boolean                 bFlashLight;
	
	/**
	 * \if ENGLISH_LANG
	 * DefenceArea Type Number ,0 Indicates No Such Alarm Input does not Use as a DefenceArea
	 * \else
	 * ��������������,Ϊ0��ʾ�޴��ֶ�ʱ�������벻��Ϊ����ʹ�á�
	 * \endif
	 */
	public int					 nDefenceAreaTypeNum;
	
	/**
	 * \if ENGLISH_LANG
	 * Supported DefenceArea Type 
	 * \else
	 * ֧�ַ������� , EM_CFG_DEFENCEAREATYPE
	 * \endif
	 */
	public int     			emDefenceAreaType[] = new int[FinalVar.MAX_ALARM_DEFENCE_TYPE_NUM];
	
	/**
	 * \if ENGLISH_LANG
	 * Delay DefenceArea Maximum Time,Unit:Second, Only Support Delay DefenceArea is Effective
	 * \else
	 * ��ʱ�����������ʱʱ��,��λΪ�룬ֻ��֧����ʱ����ʱ���ֶβ���Ч��
	 * \endif
	 */
	public int				 	 nMaxDelay;
	
	/**
	 * \if ENGLISH_LANG
	 * Alarm Channel,In Order to Maintain Compatibility, 0 Indicates that Each Channel  Support All Types of Sensors
	 * \else
	 * ����ͨ����,Ϊ�˱��ּ�����,��Ϊ0ʱ��ʾÿ��ͨ��֧���������͵Ĵ�����
	 * \endif
	 */
	public int					 nAlarmChannelNum;
	
	/**
	 * \if ENGLISH_LANG
	 * Alarm Channel Set
	 * \else
	 * ����ͨ������
	 * \endif
	 */
	public CFG_ALARM_SENSE_METHOD stuAlarmChannel[] = new CFG_ALARM_SENSE_METHOD[FinalVar.MAX_ALARM_CHANNEL_NUM];
	
	/**
	 * \if ENGLISH_LANG
	 * Number of Alarm
	 * \else
	 * ���Ÿ���
	 * \endif
	 */
	public int					 nAlarmBellCount;
	
	/**
	 * \if ENGLISH_LANG
	 * The Maximum number of alarms backup center,The default is 0 when no such field,0 indicates no support for alternate Alarm Center
	 * \else
	 * ����ñ���������,�޴��ֶ�ʱĬ��Ϊ0,0��ʾ��֧�ֱ��ñ�������
	 * \endif
	 */
	public int					 nMaxBackupAlarmServer;
	
	/**
	 * \if ENGLISH_LANG
	 * The Maximum number of Phone alarms  center, he default is 0 when no such field,0 indicates no support for Phone Alarm Center
	 * \else
	 * ���绰����������, �޴��ֶ�ʱĬ��Ϊ0,0��ʾ��֧�ֵ绰�������ġ�
	 * \endif
	 */
	public int					 nMaxPSTNAlarmServer;
	
	public CFG_CAP_ALARM_INFO() {
		for (int i = 0; i < FinalVar.MAX_ALARM_CHANNEL_NUM; i++) {
			stuAlarmChannel[i] = new CFG_ALARM_SENSE_METHOD();
		}
	}
}
