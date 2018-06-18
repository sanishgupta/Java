/****************************************************************************************
 * Copyright (c) 2011 KOJ Group. All Rights Reserved.
 * 
 *
 * Rev 1.0   APR 2012 Sanish Gupta
 * 
 ******************************************************************************************/

package koj.retail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class KOJEmailDao {

	private static Logger log = Logger.getLogger(KOJEmailDao.class);
	private Connection conn = null;
	private PreparedStatement pStmt = null;
	private ResultSet resultSet = null;

	/************************************************************************************
	 * This method used to get the Email of The Store on basis of StoreId
	 * 
	 * @param storeID
	 * @return
	 *************************************************************************************/
	public String getEMail(String storeID) {

		boolean status = false;
		String email = "";

		try {
			conn = KOJDBUtil.getConnection();
			pStmt = conn.prepareStatement(KOJDBConstant.SELECT_EMAIL);
			pStmt.setString(1, storeID);
			resultSet = pStmt.executeQuery();

			while (resultSet.next()) {
				email = resultSet.getString("EM_ADS");
			}

		} catch (SQLException sQLException) {
			sQLException.printStackTrace();
			log.error("Error occured : " + sQLException);

		} finally {
			if (conn != null) {
				try {
					if (resultSet != null) {
						resultSet.close();
					}
					if (pStmt != null) {
						pStmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException sqlExeption) {
					sqlExeption.printStackTrace();
					log.error("Error occured : " + sqlExeption);
				}

			}
		}
		return email;
	}
}