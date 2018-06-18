/****************************************************************************************
 * Copyright (c) 2011 KOJ Group. All Rights Reserved.
 * 
 *
 * Rev 1.0   APR 2012 Sanish Gupta
 * 
 ******************************************************************************************/

package koj.retail.ldap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import koj.retail.dao.KOJEmailDao;
import org.apache.log4j.Logger;
import com.employee.EmployeeImport_type;
import com.employee.types.ChangeType_type;


public class KOJXMLParser {
	
	public static final String StartWith = "Employee";
	public static final String EndWith = ".xml";
	private static Logger log = Logger.getLogger(KOJXMLParser.class);
		
	 
	
	 /**  
	  * This method used to parse the POS DIMP XML Files
	  * 
	  * @param exportPath
	  * @param storeId
	  * @throws Exception
	  */
	public void parseXml(String exportPath, String storeId) throws Exception {

		String loginId = null,accessPasswd = null, xmlFile = null;
		JarFile jarFile = null;
		JarEntry jarEntry = null;
		ChangeType_type changeType = null;
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
	//	KOJLdapUtil kojLdapUtil = new KOJLdapUtil();
		EmployeeImport_type employeeImport_type = new EmployeeImport_type();

		try {
	
			jarFile = new JarFile(exportPath);
			
			for (Enumeration em1 = jarFile.entries(); em1.hasMoreElements();) {
				
				xmlFile = em1.nextElement().toString();

				if (xmlFile.startsWith(StartWith) && xmlFile.endsWith(EndWith))
				{	
					jarEntry = jarFile.getJarEntry(xmlFile);
					inputStream = jarFile.getInputStream(jarEntry);	
						
					log.info("INFO : Pocessing File : " + xmlFile);
				
					if ( inputStream != null )
					{	
						InputStreamReader in = new InputStreamReader(inputStream);
						bufferedReader= new BufferedReader(in);
						employeeImport_type =  EmployeeImport_type.unmarshal( bufferedReader);
						
						for(int i = 0; i < employeeImport_type.getEmployeeCount(); i++){
							
							changeType = employeeImport_type.getEmployee(i).getChangeType();
							
							if (changeType.equals(ChangeType_type.UPD)){
								loginId = employeeImport_type.getEmployee(i).getEmployeeAccess().getEmployeeLoginID();
							    accessPasswd = employeeImport_type.getEmployee(i).getEmployeeAccess().getAccessPassword();
							    
							    try {	
							    	
									log.info("INFO : ******** Updating EMPLOYEE Password *******");
									if (KOJLdapPassword.modifyPassword(loginId, accessPasswd)){
									log.info("INFO : ******** EMPLOYEE ["+loginId+ "] Password updated ********");
									}
								}catch (NameNotFoundException e) {
									log.error("Error occured : " , e);
									e.printStackTrace();
	
								} catch(NamingException ne) {
									
									log.error("Error occured ", ne);
									ne.printStackTrace();
								}
							}
						}
					}
		      }
		   }
		} finally {
			try {
					if (jarFile != null)
						jarFile.close();
					
					if(inputStream != null)
						inputStream.close();
					
					if(bufferedReader != null)
						bufferedReader.close();
				
			} catch (IOException e) {
				log.error("Error occured ", e);
				e.printStackTrace();
				throw e;
			}
		} 	

	}	



	/** 
	 * This method used to parse the HRMS DIMP XML Files
	 * 
	 * @param exportPath
	 * @throws Exception
	 */
	public void parseXml(String exportPath)throws Exception {
	
	String loginId = null,accessPasswd = null, preferredCountry = null, preferredLanguage = null,
			locale = null, ssn = null, email = null, xmlFile = null, middleName = null, shortName = null, lastName = null, firstName = null,employmentStatus = null ;
	JarFile jarFile = null;
	JarEntry jarEntry = null;
	Enumeration enumeration = null;
	ChangeType_type changeType = null;
	InputStream inputStream = null;
	BufferedReader bufferedReader = null;
	String employeeID = null;
//	KOJLdapUtil kojLdapUtil = new KOJLdapUtil();
	EmployeeImport_type employeeImport_type = new EmployeeImport_type();

	try {
		
		jarFile = new JarFile(exportPath);
		
		for (Enumeration em1 = jarFile.entries(); em1.hasMoreElements();) {
			
			xmlFile = em1.nextElement().toString();

			if (xmlFile.startsWith(StartWith) && xmlFile.endsWith(EndWith))
			{	
					jarEntry = jarFile.getJarEntry(xmlFile);
					inputStream = jarFile.getInputStream(jarEntry);	

					log.info("Pocessing File : " + xmlFile);
						if ( inputStream != null )
						{	
							InputStreamReader in = new InputStreamReader(inputStream);
							bufferedReader= new BufferedReader(in);
							employeeImport_type =  EmployeeImport_type.unmarshal( bufferedReader);
							
							for(int i = 0; i < employeeImport_type.getEmployeeCount(); i++){
								
									changeType = employeeImport_type.getEmployee(i).getChangeType();
									if (changeType.equals(ChangeType_type.DEL)) {
										
										employeeID = employeeImport_type.getEmployee(i).getEmployeeID();
										log.info("INFO : ******** DELETING EMPLOYEE  ["+ loginId +"]*******");										
										
										koj.retail.ldap.KOJEmployee delEmployee = new KOJEmployee(employeeID,
												  " ", " "," ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " );
										
										if( KOJLdapPassword.deleteEmployee(delEmployee))
											{	
												log.info("INFO : ******** EMPLOYEE ["+ loginId +"] Deleted in LDAP *******");												
											}
									    } else {
											loginId = employeeImport_type.getEmployee(i).getEmployeeAccess().getEmployeeLoginID();
										    accessPasswd = employeeImport_type.getEmployee(i).getEmployeeAccess().getAccessPassword();
										    
										    // Checking for Empty Attributes of LDAP User 
										    firstName = employeeImport_type.getEmployee(i).getEmployeeFirstName();
										    middleName = employeeImport_type.getEmployee(i).getEmployeeMiddleName();
										    shortName = employeeImport_type.getEmployee(i).getEmployeeFullName();
										    lastName = employeeImport_type.getEmployee(i).getEmployeeLastName();
										    employmentStatus = employeeImport_type.getEmployee(i).getStatusCode().toString();
										    
										    if (firstName == null || firstName == "")
										    	firstName = " ";
										    if (middleName == null || middleName == "")
										    	middleName = " ";
										    if(shortName == null || shortName == "" )
										    	shortName = " ";
										    if(lastName == null || lastName == "")
										    	lastName = " ";
										  /*  
										    if(employmentStatus == null || employmentStatus == "")
										    	employmentStatus = "0";
										   */ 
											KOJEmailDao kojEmailDao = new KOJEmailDao();
											email = kojEmailDao.getEMail(employeeImport_type.getEmployee(i).getEmployeeSSN());
											
										    koj.retail.ldap.KOJEmployee employee = new KOJEmployee( employeeImport_type.getEmployee(i).getEmployeeAccess().getEmployeeLoginID(),
										    												  employeeImport_type.getEmployee(i).getStatusCode().toString(),
										    												  employeeImport_type.getEmployee(i).getEmployeeAccess().getAccessPassword(),
										  /*employeeImport_type.getEmployee(i).getEmployeeFullName()*/ 		shortName,
										  /* employeeImport_type.getEmployee(i).getEmployeeFirstName()*/ 	firstName,
										  /* employeeImport_type.getEmployee(i).getEmployeeMiddleName() */ 	middleName,
										  /*employeeImport_type.getEmployee(i).getEmployeeLastName()*/ 		lastName,
										    												  employeeImport_type.getEmployee(i).getLocale(),
										    												  employeeImport_type.getEmployee(i).getLocale(),
										    												  employeeImport_type.getEmployee(i).getEmployeeSSN(),
										    												  employeeImport_type.getEmployee(i).getEmployeeSSN(),
										    												  employeeImport_type.getEmployee(i).getEmployeeSSN(),
										    												  employeeImport_type.getEmployee(i).getEmployeeRole(),
										    												  email );
										    
										    
											
										    System.out.println("** EMPLOYEE PROCESSED ** : " + i);
											log.info("** EMPLOYEE PROCESSED ** : " + i);
											if( email != "" && email != null && !email.equals(null))
											{
												if (changeType.equals(ChangeType_type.ADD))
												{	
												    log.info("INFO : ******** ADDING EMPLOYEE  *******");
												   								   	
													if( KOJLdapPassword.addEmployee(employee)) 
													{	
														log.info("INFO : ******** EMPLOYEE ["+ loginId +"] Added in LDAP");
													}
												}else if (changeType.equals(ChangeType_type.UPD))
												{	
													log.info("INFO : ******** UPDATING EMPLOYEE  ["+ loginId +"]*******");
																		   								   	
													if( KOJLdapPassword.modifyAllAttributes(employee))
													{	
														log.info("INFO : ******** EMPLOYEE ["+ loginId +"] Updated in LDAP *******");
													}
												}									
											}
									}									
								}
							System.out.println("***TOTAL EMPLOYEE*** : " + employeeImport_type.getEmployeeCount());
							log.info("***TOTAL EMPLOYEE*** : " + employeeImport_type.getEmployeeCount());
							}	
				//		inputStream.close();
						}
					
					}

		} finally {
		try {	
				if (jarFile != null)
				jarFile.close();
				
				if(inputStream != null)
					inputStream.close();
				
				if(bufferedReader != null)
					bufferedReader.close();
			
		} catch (IOException e) {
			log.error("Error occured ", e);
			e.printStackTrace();
			throw e;
		}
	} 	

}	
}