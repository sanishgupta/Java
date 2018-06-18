/****************************************************************************************
 * Copyright (c) 2011 KOJ Group. All Rights Reserved.
 * 
 *
 * Rev 1.0   APR 2012 Sanish Gupta
 * 
 ******************************************************************************************/

package koj.retail.dao;

import java.sql.Connection;
import java.sql.SQLException;
import koj.retail.ldap.KOJEncryptDecrypt;
import oracle.jdbc.pool.OracleDataSource;
import org.apache.log4j.Logger;

public class KOJDBUtil {
	private static Logger log = Logger.getLogger(KOJDBUtil.class);

	/**************************************************************************************
	 * This method return the connection.If it will get connection it return the
	 * Connection object else null.
	 * 
	 * @return conn as <code>Connection</code>
	 * @throws SQLException
	 **************************************************************************************/
	public static Connection getConnection() throws SQLException {

		Connection connection = null;

		try {
			OracleDataSource ds = new OracleDataSource();
			ds.setDriverType(KOJPropReader.getUniqueInstance().getDriverType());// driver
																				// type
			ds.setServerName(KOJPropReader.getUniqueInstance().getServerName());
			ds.setPortNumber(KOJPropReader.getUniqueInstance().getPortNo()); // portname
			ds.setDatabaseName(KOJPropReader.getUniqueInstance().getSID()); // sid
			ds.setUser(KOJPropReader.getUniqueInstance().getUser()); // User
			ds.setPassword(KOJEncryptDecrypt.decryptText(KOJPropReader
					.getUniqueInstance().getPasswd())); // Password
			connection = ds.getConnection();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			log.error("Error occured : " + sqlException);
			throw sqlException;
		}

		return connection;
	}

}
