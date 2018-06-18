/****************************************************************************************
 * Copyright (c) 2011 KOJ Group. All Rights Reserved.
 * 
 *
 * Rev 1.0   APR 2012 Sanish Gupta
 * 
 ******************************************************************************************/

package koj.retail.ldap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import koj.retail.dao.KOJDBUtil;
import koj.retail.dao.KOJPropReader;
import org.apache.log4j.Logger;

public class KOJLdapUtil {

	public static final String LDAP_PROPERTY_FILE = "ldap.properties";
	private static String LDAP_URL = "LDAP_URL";
	private static String LDAP_PORT = "LDAP_PORT";
	private static String LDAP_BASE_DN = "LDAP_BASE_DN";
	private static String LDAP_PASSWORD = "LDAP_PASSWORD";
	private static String SECURITY_AUTHENTICATION_TYPE = "SECURITY_AUTHENTICATION_TYPE";
	private static String RETEK_APP_NAME = "RETEK_APP_NAME";
	private static String POS_DIMP_PATH = "POS_DIMP_PATH";
	private static String PASSWORD_FILE = "PASSWORD_FILE";
	private static String LDAP_LOG_PATH = "LDAP_LOG_PATH";
	private static String ERROR_ARCHIEVE_PATH = "ERROR_ARCHIEVE_PATH";
	private static String ARCHIEVE_PATH = "ARCHIEVE_PATH";
	private static String USER_STORE = "USER_STORE";
	private static String USER_ROLE = "USER_ROLE";
	private static String INITIAL_CONTEXT_FACTORY = "INITIAL_CONTEXT_FACTORY";
	private static String POS_TIME_STAMP = "POS_TIME_STAMP";
	private static String FILE_INITIAL = "FILE_INITIAL";
	private static String FILE_NAME_DELIMETER = "FILE_NAME_DELIMETER";
	private static String FILE_EXTENSION = "FILE_EXTENSION";
	private static String XML_FILE_INITIAL = "XML_FILE_INITIAL";
	private static String HRMS_DIMP_PATH = "HRMS_DIMP_PATH";


	public static String ENCRYPTION_DECRYPTION_KEY = "kOjArEnCdEcKeY";
	private static String ENCRYPT_STATUS = "ENCRYPT_STATUS";
	private static String HOME_DIR = "HOME_DIR";

	private static Logger log = Logger.getLogger(KOJLdapUtil.class);
	private static Properties properties = null;
	private static KOJLdapUtil kojLdapUtil = null;
	private Hashtable environmentTable = null;
	private DirContext ctx = null;

	private KOJLdapUtil() {
		properties = loadConfiguration();
	}

	/**
	 * Method to get Unique instance of this class Object
	 * 
	 * @return
	 */
	public static KOJLdapUtil getUniqueInstance() {

		if (kojLdapUtil == null) {
			kojLdapUtil = new KOJLdapUtil();
		}
		return kojLdapUtil;
	}

	/**
	 * This Method used to get the LDAP Connection Contex
	 *    
	 * @return
	 * @throws NamingException
	 */
	public DirContext getContext() throws NamingException {

		environmentTable = new Hashtable();
		environmentTable.put(Context.INITIAL_CONTEXT_FACTORY,
				getInitialContextyFactory());
		environmentTable.put(Context.PROVIDER_URL, getURL() + ":" + getPort());
		environmentTable.put(Context.SECURITY_PRINCIPAL, getBaseDn());
		environmentTable.put(Context.SECURITY_CREDENTIALS, KOJEncryptDecrypt
				.decryptText(getPassword()));
		environmentTable.put(Context.SECURITY_AUTHENTICATION,
				getAuthenticationType());
		ctx = new InitialDirContext(environmentTable);

		return ctx;
	}
	
	
	/**
	 * This method is used to Re-load the configuration file.
	 * 
	 * @return
	 */
	public static Properties loadConfiguration() {
		properties = new Properties();

		try {
			properties.load(new FileInputStream(LDAP_PROPERTY_FILE));

		} catch (IOException e) {
			log.error("Error occured : " + e);
			e.printStackTrace();
		}
		return properties;
	}
	
	
	/**
	 * This method used to update the [properties file value on basis of KEY 
	 * 
	 * @param key
	 * @param value
	 * @param fileName
	 */
	private static boolean updateProperties(String key, String value,
			String fileName) throws Exception {

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(fileName));
			prop.setProperty(key, value);

			prop.store(new FileOutputStream(new File(fileName)), null);
		} catch (IOException e) {
			log.error("Error occured : " + e);
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * This function used to update the Encrypted password in Property file
	 * 
	 * @return
	 */
	public static boolean updatePassword() {

		String ldapPasswd = null, dbPasswd = null;

		try {
			if (!getUniqueInstance().isEncrypted()) {
				ldapPasswd = KOJLdapUtil.getUniqueInstance().getPassword();
				dbPasswd = KOJPropReader.getUniqueInstance().getPasswd();

				if (ldapPasswd != null && !ldapPasswd.trim().equals("")
						&& dbPasswd != null && !dbPasswd.trim().equals("")) {
					if (KOJLdapUtil.updateProperties(KOJLdapUtil.LDAP_PASSWORD,
							KOJEncryptDecrypt.encryptText(ldapPasswd),
							getUniqueInstance().getHomeDir()
									+ "/"+LDAP_PROPERTY_FILE)
							&& KOJLdapUtil.updateProperties(
									KOJPropReader.SIMDB_PASSWORD,
									KOJEncryptDecrypt.encryptText(dbPasswd),
									getUniqueInstance().getHomeDir()
											+ "/"+KOJPropReader.DB_PROPERTY_FILE)
							&& KOJLdapUtil.updateProperties(
									KOJLdapUtil.ENCRYPT_STATUS, "true",
									getUniqueInstance().getHomeDir()
											+  "/"+LDAP_PROPERTY_FILE)) {
						log.info("INFO : LDAP and Database Passoword Encrypted in Properties file");
					}
				}
			} else {
				log.info("INFO : LDAP and Database Passoword Already Encrypted in Properties file");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error occured : " + e);
			return false;
		}
		return true;
	}

	/**
	 * This Method used to checked the DATABASE and LDAP Connection
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean checkConnectivity() throws Exception {

		if (KOJLdapUtil.getUniqueInstance().getContext() != null
				&& KOJDBUtil.getConnection() != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Getter methods to get the Values  on basis of KEY from Properties file
	 * 
	 */
	public String getURL() {
		return properties.getProperty(LDAP_URL);
	}

	public int getPort() {
		return Integer.parseInt(properties.getProperty(LDAP_PORT));
	}

	public String getBaseDn() {
		return properties.getProperty(LDAP_BASE_DN);
	}

	public String getPassword() {
		return properties.getProperty(LDAP_PASSWORD);
	}

	public String getAuthenticationType() {
		return properties.getProperty(SECURITY_AUTHENTICATION_TYPE);
	}

	public String getRetekAppName() {
		return properties.getProperty(RETEK_APP_NAME);
	}

	public String getPOSDimpPath() {
		return properties.getProperty(POS_DIMP_PATH);
	}

	public String getFileName() {
		return properties.getProperty(PASSWORD_FILE);
	}

	public String getLogPath() {
		return properties.getProperty(LDAP_LOG_PATH);
	}

	public String getErrorArchivePath() {
		return properties.getProperty(ERROR_ARCHIEVE_PATH);
	}

	public String getArchivePath() {
		return properties.getProperty(ARCHIEVE_PATH);
	}

	public String getUserRole() {
		return properties.getProperty(USER_ROLE);
	}

	public String getUserStore() {
		return properties.getProperty(USER_STORE);
	}

	public String getInitialContextyFactory() {
		return properties.getProperty(INITIAL_CONTEXT_FACTORY);
	}

	public String getPOSTimeStampFormat() {
		return properties.getProperty(POS_TIME_STAMP);
	}

	public String getFileInitial() {
		return properties.getProperty(FILE_INITIAL);
	}

	public String getFileNameDelimeter() {
		return properties.getProperty(FILE_NAME_DELIMETER);
	}

	public String getFileExtension() {
		return properties.getProperty(FILE_EXTENSION);
	}

	public String getHRMSDimpPath() {
		return properties.getProperty(HRMS_DIMP_PATH);
	}

	public String getHomeDir() {
		return properties.getProperty(HOME_DIR);
	}

	public boolean isEncrypted() {
		return (Boolean.parseBoolean(properties.getProperty(ENCRYPT_STATUS)));
	}

	
}
