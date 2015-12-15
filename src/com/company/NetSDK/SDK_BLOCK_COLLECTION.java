package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Areas collection
 * \else
 * 区块收藏
 * \endif
 */
public class SDK_BLOCK_COLLECTION implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Split mode
	 * \else
	 * 分割模式
	 * \endif
	 */
	public int					emSplitMode;				 
	/**
	 * \if ENGLISH_LANG
	 * Window info array
	 * \else
	 * 窗口信息数组
	 * \endif
	 */
	public SDK_WINDOW_COLLECTION stuWnds[] = new SDK_WINDOW_COLLECTION[FinalVar.SDK_MAX_SPLIT_WINDOW]; 
	/**
	 * \if ENGLISH_LANG
	 * Count of window
	 * \else
	 * 窗口数量
	 * \endif
	 */
	public int					nWndsCount;					 
	/**
	 * \if ENGLISH_LANG
	 * Favorites name
	 * \else
	 * 收藏夹名称
	 * \endif
	 */
	public char				szName[] = new char[FinalVar.SDK_DEVICE_NAME_LEN];	 
	/**
	 * \if ENGLISH_LANG
	 * Port serial number
	 * \else
	 * 输出通道号, 包括拼接屏
	 * \endif
	 */
	public int					nScreen;					 
	
	public SDK_BLOCK_COLLECTION()
	{
		for(int i=0 ; i<FinalVar.SDK_MAX_SPLIT_WINDOW ; i++)
		{
			stuWnds[i] = new SDK_WINDOW_COLLECTION();
		}
	}
}
