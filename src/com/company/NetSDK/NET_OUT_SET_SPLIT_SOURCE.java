package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * SetSplitSourceEx Port output parameter
 * \else
 * SetSplitSourceEx 接口的输出参数
 * \endif
 */
public class NET_OUT_SET_SPLIT_SOURCE implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Successfully set return value, corresponding NET_IN_SET_SPLIT_SOURCE window group, user allocated memory, if no need it can be NULL
	 * \else
	 * 设置成功后的返回值, 对应NET_IN_SET_SPLIT_SOURCE中的窗口数组, 用户分配内存, 如果不需要可以为NULL
	 * \endif
	 */
	public NET_SET_SPLIT_SOURCE_RESULT pstuResults[];
	
	/**
	 * \if ENGLISH_LANG
	 * pstuResults group size
	 * \else
	 * pstuResults数组的大小
	 * \endif
	 */
	public int						nMaxResultCount;
	
	/**
	 * \if ENGLISH_LANG
	 * Return quantity
	 * \else
	 * 返回的数量
	 * \endif
	 */
	public int						nRetCount;
	
	public NET_OUT_SET_SPLIT_SOURCE(int nMax)
	{
		nMaxResultCount = nMax;
		for (int i = 0; i < nMaxResultCount; i++)
		{
			pstuResults[i] = new NET_SET_SPLIT_SOURCE_RESULT();
		}
	}
}
