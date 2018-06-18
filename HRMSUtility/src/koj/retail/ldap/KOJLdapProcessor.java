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
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

public class KOJLdapProcessor {

	private static Logger log = Logger.getLogger(KOJLdapProcessor.class);

	/**
	 * This method used to move file into Error folder
	 * 
	 * @param filePath
	 * @param fileName
	 */
	private void errorArchieveFile(String filePath, String fileName) {

		try {
			String errorArchievePath = KOJLdapUtil.getUniqueInstance()
					.getErrorArchivePath();
			String sourceFile = filePath + "/" + fileName;
			String destFile = errorArchievePath + "/" + fileName;
			log.info("Source : " + sourceFile + " | destination : "
					+ destFile);
			File errorArchiveDirectory = new File(errorArchievePath);
			if (!errorArchiveDirectory.exists()) {
				errorArchiveDirectory.mkdir();
			}
			copyFile(new File(sourceFile), new File(destFile));
			delete(new File(sourceFile));
		} catch (IOException e) {
			log.error("Error occured ", e);
			e.printStackTrace();
		} catch (InterruptedException e) {
			log.error("Error occured ", e);
			e.printStackTrace();
		}
	}

	/**
	 * This method used to move file into Archive folder
	 * 
	 * @param filePath
	 * @param fileName
	 */
	private void archieveFile(String filePath, String fileName) {

		try {
			String archievePath = KOJLdapUtil.getUniqueInstance()
					.getArchivePath();
			String sourceFile = filePath + "/" + fileName;
			String destFile = archievePath + "/" + fileName;
			File archiveDirectory = new File(archievePath);
			if (!archiveDirectory.exists()) {
				archiveDirectory.mkdir();
			}
			copyFile(new File(sourceFile), new File(destFile));
			try {
				delete(new File(sourceFile));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			log.error("Error occured ", e);
			e.printStackTrace();
		}
	}

	/**
	 * This method used to copy file into a folder
	 * 
	 * @param source
	 * @param dest
	 * @throws IOException
	 */
	private void copyFile(File source, File dest) throws IOException {
		if (!dest.exists()) {

			log.info("Destination Path : " + dest.getPath());
			if (dest.createNewFile())
				log.info("Destination file created: " + dest); // My

		}
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(source);
			out = new FileOutputStream(dest);
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
		} finally {
			in.close();
			out.close();
		}
	}

	/**
	 * This method used to delete a file from a folder location
	 * 
	 * @param resource
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private boolean delete(File resource) throws IOException,
			InterruptedException {
		Thread.sleep(100);
		if (resource.isDirectory()) {
			File[] childFiles = resource.listFiles();
			for (File child : childFiles) {
				delete(child);
			}
		}
		return resource.delete();
	}

	/**
	 * This methid used to process POS DIMP Jar file
	 * 
	 * @param filePath
	 * @param fileName
	 * @param storeId
	 * @return
	 * @throws Exception
	 */
	public static boolean processLdapFile(String filePath, String fileName,
			String storeId) throws Exception {

		String file = filePath + "/" + fileName;

		if (KOJLdapUtil.getUniqueInstance().checkConnectivity()) {
			KOJXMLParser parser = new KOJXMLParser();
			parser.parseXml(file, storeId);
			return true;
		}
		return false;
	}

	/**
	 * This methid used to process HRMS DIMP Jar file
	 * 
	 * 
	 * @param filePath
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static boolean processLdapFile(String filePath, String fileName)
			throws Exception {

		String file = filePath + "/" + fileName;

		try {
			if (KOJLdapUtil.getUniqueInstance().checkConnectivity()) {
				KOJXMLParser parser = new KOJXMLParser();
				parser.parseXml(file);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			log.error("Error occured ", e);
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This methid used to Read POS DIMP Directory and List down all files in
	 * MAP so that all files in a sorted order on the basis of Date (Key)
	 * 
	 * @return
	 */
	public TreeMap<Date, String> readPOSDirectory() {

		String FTPPath = "";
		String fileName = "";
		TreeMap<Date, String> fileMap = new TreeMap<Date, String>();

		try {
			FTPPath = KOJLdapUtil.getUniqueInstance().getPOSDimpPath();
			File directory = new File(FTPPath);
			String filename[] = directory.list();

			if (filename != null) {
				for (int index = 0; index < filename.length; index++) {
					fileName = filename[index];
					if ((fileName.endsWith(KOJLdapUtil.getUniqueInstance()
							.getFileExtension()) && fileName
							.startsWith(KOJLdapUtil.getUniqueInstance()
									.getFileInitial()))) {

						File file = new File(FTPPath + "/" + fileName);

						if (!file.isDirectory()) {
							String delimiter = KOJLdapUtil.getUniqueInstance()
									.getFileNameDelimeter();
							String[] split = fileName.split(delimiter);
							String timeStamp = (split[2].split(KOJLdapUtil
									.getUniqueInstance().getFileExtension()))[0];
							String storeID = split[1];

							DateFormat timeStampFormat = new SimpleDateFormat(
									KOJLdapUtil.getUniqueInstance()
											.getPOSTimeStampFormat());
							long date = timeStampFormat.parse(timeStamp)
									.getTime();
							Date date1 = timeStampFormat.parse(timeStamp);
							long dateValue = date1.getTime();

							String revtimestamp = timeStampFormat.format(date1);
							fileMap.put(date1, fileName);
						}
					}
				}
			}
		} catch (Exception e) {
			log.error("Error occured ",e);
			e.printStackTrace();
			errorArchieveFile(FTPPath, fileName);			
		}
		return fileMap;
	}

	/**
	 * This methid used to get all POS DIMP files names from DIMP Directory and process it.
	 *  
	 * @return
	 */
	public boolean processPOSDimp() {
		
		boolean isSuccess = true;
		TreeMap treeMap = readPOSDirectory();
		Iterator i = treeMap.entrySet().iterator();
		String FTPPath = KOJLdapUtil.getUniqueInstance().getPOSDimpPath();
		String fileName;

		while (i.hasNext()) {

			Map.Entry me = (Map.Entry) i.next();
			DateFormat timeStampFormat = new SimpleDateFormat(KOJLdapUtil
					.getUniqueInstance().getPOSTimeStampFormat());
			String timestamp = timeStampFormat.format(me.getKey());
			String storeId = me.getValue().toString();
			fileName = (String) me.getValue();
			log.info("File Name :" + fileName + "  | Path : "
					+ FTPPath);

			if (fileName.endsWith(KOJLdapUtil.getUniqueInstance()
					.getFileExtension())) {
				File file = new File(FTPPath + "/" + fileName);

				try {
					if (!file.isDirectory()
							&& fileName.startsWith(KOJLdapUtil
									.getUniqueInstance().getFileInitial())) {

						if (processLdapFile(FTPPath, fileName, storeId)) {

							archieveFile(FTPPath, fileName);
						} else {

							errorArchieveFile(FTPPath, fileName);
						}
					}
				} catch (Exception e) {
					log.error("Error occured ", e);
					e.printStackTrace();
					errorArchieveFile(FTPPath, fileName);
					isSuccess = false;
				}
			}
		}
		return isSuccess;

	}

	/**
	 * This method used to process HRMS DIMP .
	 * 
	 * @return
	 */
	public boolean processHRMSDimp() {
		boolean isSuccess = true;
		String FTPPath = "";
		String fileName = "";
		try {

			FTPPath = KOJLdapUtil.getUniqueInstance().getHRMSDimpPath();
			File directory = new File(FTPPath);
			String filename[] = directory.list();
			if (filename != null) {
				for (int index = 0; index < filename.length; index++) {
					fileName = filename[index];

					if (fileName.endsWith(KOJLdapUtil.getUniqueInstance()
							.getFileExtension())
							&& !fileName.startsWith(KOJLdapUtil
									.getUniqueInstance().getFileInitial())) {
						log.info("File name : " + fileName
								+ "  | Path : " + FTPPath);

						if (processLdapFile(FTPPath, fileName)) {

							archieveFile(FTPPath, fileName);
						} else {

							errorArchieveFile(FTPPath, fileName);
						}

					}
				}
			}
		} catch (Exception e) {
			log.error("Error occured ", e);
			e.printStackTrace();
			errorArchieveFile(FTPPath, fileName);
			isSuccess = false;
		}
		return isSuccess;
	}

}
