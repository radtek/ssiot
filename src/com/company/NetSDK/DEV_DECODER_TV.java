package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * TV parameters
 * \else
 * TV参数信息
 * \endif
 */
public class DEV_DECODER_TV implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * TV ID
	 * \else
	 * TV号
	 * \endif
	 */
	public int				nID;
	
	/**
	 * \if ENGLISH_LANG
	 * Enable, open or close
	 * \else
	 * 使能，开启或关闭
	 * \endif
	 */
	public boolean			bEnable;
	
	/**
	 * \if ENGLISH_LANG
	 * Partition number
	 * \else
	 *  画面分割数
	 * \endif
	 */
	public int				nSplitType;
	
	/**
	 * \if ENGLISH_LANG
	 * All encoder information
	 * \else
	 * 各画面编码器信息dwDisplayType=SDK_SPLIT_DISPLAY_TYPE_GENERAL时有效
	 * \endif
	 */
	public DEV_ENCODER_INFO stuDevInfo[] = new DEV_ENCODER_INFO[16];
	
	/**
	 * \if ENGLISH_LANG
	 * Split mode supported
	 * \else
	 * 支持的分割模式
	 * \endif
	 */
	public byte			bySupportSplit[] = new byte[10];
	
	/**
	 * \if ENGLISH_LANG
	 * Channel input no. 
	 * \else
	 * 输入通道组号,dwDisplayType=SDK_SPLIT_DISPLAY_TYPE_PIP时表示画中画显示类型下有效；
	 * \endif
	 */
	public byte            byGroupNo;
	
	/**
	 * \if ENGLISH_LANG
	 * Display Type, can look for DH_SPLIT_DISPLAY_TYPE
	 * \else
	 * 显示类型；具体见SDK_SPLIT_DISPLAY_TYPE（注释各模式下显示内容由"PicInPic"决定, 各模式下显示内容按NVD旧有规则决定（即DisChn字段决定）。兼容，没有这一个项时，默认为普通显示类型,即"General"）
	 * \endif
	 */
	public int             dwDisplayType;
    
    public DEV_DECODER_TV() {
    	for (int i=0 ; i<16 ; i++) {
    		stuDevInfo[i] = new DEV_ENCODER_INFO();
    	}
    }
}
