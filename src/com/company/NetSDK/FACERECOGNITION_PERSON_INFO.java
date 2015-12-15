package com.company.NetSDK;

import java.io.Serializable;

/**
 * \if ENGLISH_LANG
 * person info
 * \else
 * 人员信息
 * \endif
 */
public class FACERECOGNITION_PERSON_INFO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * \if ENGLISH_LANG
	 *  name
	 * \else
	 * 姓名，此参数作废
	 * \endif
	 */
	public byte           	szPersonName[] 		= new byte[FinalVar.SDK_MAX_NAME_LEN]; 
	
	/**
	 * \if ENGLISH_LANG
	 * birth year
	 * \else
	 * 出生年，作为查询条件时，此参数填0，则表示此参数无效
	 * \endif
	 */
	public int				wYear; 
	
	/**
	 * \if ENGLISH_LANG
	 * birth month
	 * \else
	 * 出生月，作为查询条件时，此参数填0，则表示此参数无效
	 * \endif
	 */
	public byte				byMonth; 
	
	/**
	 * \if ENGLISH_LANG
	 * birth day
	 * \else
	 * 出生日，作为查询条件时，此参数填0，则表示此参数无效
	 * \endif
	 */
	public byte				byDay; 
	
	/**
	 * \if ENGLISH_LANG
	 * the unicle ID for the person
	 * \else
	 * 人员唯一标示(身份证号码，工号，或其他编号)
	 * \endif
	 */
	public byte      		szID[] 				= new byte[FinalVar.SDK_MAX_PERSON_ID_LEN]; 
	
	/**
	 * \if ENGLISH_LANG
	 * importance level,1~10,the higher value the higher level
	 * \else
	 * 人员重要等级,1~10，数值越高越重要，作为查询条件时，此参数填0，则表示此参数无效
	 * \endif
	 */
	public byte          	bImportantRank; 
	
	/**
	 * \if ENGLISH_LANG
	 * sex, 0-man, 1-female
	 * \else
	 * 性别，1-男，2-女，作为查询条件时，此参数填0，则表示此参数无效
	 * \endif
	 */
	public byte          	bySex; 
	
	/**
	 * \if ENGLISH_LANG
	 * picture number
	 * \else
	 * 图片张数
	 * \endif
	 */
	public int           	wFacePicNum; 
	
	/**
	 * \if ENGLISH_LANG
	 * picture info
	 * \else
	 * 当前人员对应的图片信息
	 * \endif
	 */
	public SDK_PIC_INFO  	szFacePicInfo[] 	= new SDK_PIC_INFO[FinalVar.SDK_MAX_PERSON_IMAGE_NUM];
	
	/**
	 * \if ENGLISH_LANG
	 * Personnel types, see EM_PERSON_TYPE
	 * \else
	 * 人员类型，详见 EM_PERSON_TYPE
	 * \endif
	 */
	public byte          	byType; 
	
	/**
	 * \if ENGLISH_LANG
	 * Document types, see EM_CERTIFICATE_TYPE
	 * \else
	 * 证件类型，详见 EM_CERTIFICATE_TYPE
	 * \endif
	 */
	public byte            	byIDType; 
	
	/**
	 * \if ENGLISH_LANG
	 * province
	 * \else
	 * 省份
	 * \endif
	 */
	public byte         	szProvince[] 		= new byte[FinalVar.SDK_MAX_PROVINCE_NAME_LEN]; 
	
	/**
	 * \if ENGLISH_LANG
	 * city
	 * \else
	 * 城市
	 * \endif
	 */
	public byte          	szCity[] 			= new byte[FinalVar.SDK_MAX_CITY_NAME_LEN]; 
	
	/**
	 * \if ENGLISH_LANG
	 * Name, the name is too long due to the presence of 16 bytes can not be Storage problems, the increase in this parameter
	 * \else
	 * 姓名，因存在姓名过长，16字节无法存放问题，故增加此参数，
	 * \endif
	 */
	public byte          	szPersonNameEx[] 	= new byte[FinalVar.SDK_MAX_PERSON_NAME_LEN];
	
	public FACERECOGNITION_PERSON_INFO() {
		for (int i = 0; i < FinalVar.SDK_MAX_PERSON_IMAGE_NUM; i++) {
			szFacePicInfo[i] = new SDK_PIC_INFO();
		}
	}
}
