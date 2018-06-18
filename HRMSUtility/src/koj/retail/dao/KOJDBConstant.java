/****************************************************************************************
 * Copyright (c) 2011 KOJ Group. All Rights Reserved.
 * 
 *
 * Rev 1.0   APR 2012 Sanish Gupta
 * 
 ******************************************************************************************/

package koj.retail.dao;

public class KOJDBConstant {
	
	/**
	 * Use to get E-Mail from Database
	 */
	public static final String SELECT_EMAIL = "SELECT EM_ADS from LO_EML_ADS A, PA_STR_RTL B "
												+ "WHERE B.ID_STR_RT =? "
												+ "AND   B.ID_PRTY = A.ID_PRTY";

}
