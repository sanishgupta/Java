/****************************************************************************************
 * Copyright (c) 2011 KOJ Group. All Rights Reserved.
 * 
 *
 * Rev 1.0   APR 2012 Sanish Gupta
 * 
 ******************************************************************************************/


package koj.retail.scheduler;


import java.util.concurrent.ScheduledExecutorService;
import koj.retail.dao.KOJPropReader;
import koj.retail.ldap.KOJLdapProcessor;
import koj.retail.ldap.KOJLdapUtil;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class KOJLdapScheduler 
{
	private static Logger log = Logger.getLogger(KOJLdapScheduler.class);
	
	/**
	 * The Main entry method of HRMS-Utility
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		KOJLdapScheduler kojLdapScheduler = new KOJLdapScheduler();
		
		try{ 
			PropertyConfigurator.configure(KOJLdapUtil.getUniqueInstance().getLogPath() + "log4j.properties"); 
			kojLdapScheduler.runLdapProcess();		
		}catch(Exception e){	
			log.error("Error occured ", e);
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * The method is the start point of Execution
	 */
	public void runLdapProcess(){
		
		KOJLdapProcessor kojLdapProcessor = new KOJLdapProcessor();
		
		try {	
			log.info("LDAP Process start ...");
			
				//Update Encrypt Password in Properties File
			if ( KOJLdapUtil.updatePassword() )
			{	
				//Re-Load Properties file 
				KOJLdapUtil.loadConfiguration();
				KOJPropReader.loadConfiguration();
				
				// Start DIMP Consumption
				
				log.info("Start Importing HRMS Dimp..... ");
				kojLdapProcessor.processHRMSDimp();
				log.info("Completed Importing HRMS Dimp..... \n");
	
				log.info("Start Importing POS Dimp..... ");
				kojLdapProcessor.processPOSDimp();
				log.info("Completed Importing POS Dimp..... \n\n");
				
			}	
		}catch(Exception e){
			log.error("Error occured ", e);
			e.printStackTrace();
		}
	}
	
}
