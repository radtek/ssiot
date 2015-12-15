package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * Picture info
 * \else
 * 物体对应图片文件信息
 * \endif
 */
public class SDK_PIC_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 * Current picture file's offset in the binary file, byte
	 * \else
	 * 文件在二进制数据块中的偏移位置, 单位:字节
	 * \endif
	 */
	public int                dwOffSet;                       
	/**
	 * \if ENGLISH_LANG
	 * Current picture file's size, byte
	 * \else
	 * 文件大小, 单位:字节
	 * \endif
	 */
	public int                dwFileLenth;                    
	/**
	 * \if ENGLISH_LANG
	 * Picture width, pixel
	 * \else
	 * 图片宽度, 单位:像素
	 * \endif
	 */
	public int                wWidth;                         
	/**
	 * \if ENGLISH_LANG
	 * Picture high, pixel
	 * \else
	 * 图片高度, 单位:像素          
	 * \endif
	 */
	public int                wHeight;                        
}
