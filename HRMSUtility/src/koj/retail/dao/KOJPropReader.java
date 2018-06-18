/****************************************************************************************
 * Copyright (c) 2011 KOJ Group. All Rights Reserved.
 * 
 *
 * Rev 1.0   APR 2012 Sanish Gupta
 * 
 ******************************************************************************************/

package koj.retail.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class KOJPropReader {

	private static Logger log = Logger.getLogger(KOJPropReader.class);
	public static final String DB_PROPERTY_FILE = "db.properties";
	public static Properties properties = null;
	public static String SIMDB_SID = "SIMDB_SID";
	public static String SIMDB_USER = "SIMDB_USER";
	public static String SIMDB_PASSWORD = "SIMDB_PASSWORD";
	public static String DRIVERTYPE = "DRIVERTYPE";
	public static String SERVER_NAME = "SERVER_NAME";
	public static String PORT = "PORT";
	public static KOJPropReader kOJPropReader = null;

	/**
	 * Constructor used to load properties values
	 */
	public KOJPropReader() {
		properties = loadConfiguration();
	}

	/**************************************************************************************
	 * This method used to get the Unique instance of KOJPropReader
	 * 
	 * @return
	 *************************************************************************************/
	public static KOJPropReader getUniqueInstance() {

		if (kOJPropReader == null) {
			kOJPropReader = new KOJPropReader();
		}
		return kOJPropReader;
	}

	/**************************************************************************************
	 * This method used to Re-Load the properties files values
	 * 
	 * @return
	 ***************************************************************************************/
	public static Properties loadConfiguration() {
		properties = new Properties();

		try {
			properties.load(new FileInputStream(DB_PROPERTY_FILE));

		} catch (IOException e) {
			log.error("Error occured : " + e);
			e.printStackTrace();
		}
		return properties;
	}

	/**************************************************************************************
	 * This method used to the values of Properties on basis of Key
	 * 
	 * @return
	 ***************************************************************************************/
	public String getSID() {
		return properties.getProperty(SIMDB_SID);
	}

	public String getUser() {
		return properties.getProperty(SIMDB_USER);
	}

	public String getPasswd() {
		return properties.getProperty(SIMDB_PASSWORD);
	}

	public String getDriverType() {
		return properties.getProperty(DRIVERTYPE);
	}

	public String getServerName() {
		return properties.getProperty(SERVER_NAME);
	}

	public int getPortNo() {
		return Integer.parseInt(properties.getProperty(PORT));
	}

}
