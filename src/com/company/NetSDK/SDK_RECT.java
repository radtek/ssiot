package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Zone;Each margin is total lenght :8192
 * \else
 * 区域；各边距按整长8192的比例
 * \endif
 */
public class SDK_RECT implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	public long					left;

	public long					top;

	public long					right;

	public long					bottom;
}
