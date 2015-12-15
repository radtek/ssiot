package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Split capability
 * \else
 * �ָ�����
 * \endif
 */
public class SDK_SPLIT_CAPS implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * The split amount supported
	 * \else
	 * ֧�ֵķָ�ģʽ����
	 * \endif
	 */
	public int					nModeCount;				
	/**
	 * \if ENGLISH_LANG
	 * The split mode supported
	 * \else
	 * ֧�ֵķָ�ģʽ
	 * \endif
	 */
	public int					emSplitMode[] = new int[FinalVar.SDK_MAX_SPLIT_MODE_NUM];	
	/**
	 * \if ENGLISH_LANG
	 * Max display source allocation amount
	 * \else
	 * �����ʾԴ������
	 * \endif
	 */
	public int				    nMaxSourceCount;		
	/**
	 * \if ENGLISH_LANG
	 * Count of free window support
	 * \else
	 * ֧�ֵ�������ɿ�����Ŀ
	 * \endif
	 */
	public int					nFreeWindowCount;		
	/**
	 * \if ENGLISH_LANG
	 * Support collection
	 * \else
	 * �Ƿ�֧�������ղ�
	 * \endif
	 */
	public boolean				bCollectionSupported;	
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * �����ʾ�����ʾ���ͣ������SDK_SPLIT_DISPLAY_TYPE��ע�͸�ģʽ����ʾ������"PicInPic"����, ��ģʽ����ʾ���ݰ�NVD���й����������DisChn�ֶξ����������ݣ�û����һ����ʱ��Ĭ��Ϊ��ͨ��ʾ����,��"General"��
	 * \endif
	 */
	public int              	dwDisplayType;          
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * ���л�֧�ֵķָ�ģʽ����
	 * \endif
	 */
	public int					nPIPModeCount;			
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * ���л�֧�ֵķָ�ģʽ
	 * \endif
	 */
	public int					emPIPSplitMode[] = new int[FinalVar.SDK_MAX_SPLIT_MODE_NUM];	
}
