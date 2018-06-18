/****************************************************************************************
 * Copyright (c) 2011 KOJ Group. All Rights Reserved.
 * 
 *
 * Rev 1.0   APR 2012 Sanish Gupta
 * 
 ******************************************************************************************/

package koj.retail.ldap;

import javax.naming.NameAlreadyBoundException;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.AttributeModificationException;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;
import org.apache.log4j.Logger;

public class KOJLdapPassword {

	private static Logger log = Logger.getLogger(KOJLdapPassword.class);
	private static String DN = "";
	public static String errorMsg = " : User does not exist in LDAP";

	/**
	 * This method used to update a Employee Password only.
	 * 
	 * @param userId
	 * @param passwd
	 * @return
	 * @throws NamingException
	 */
	public static boolean modifyPassword(String userId, String passwd)
			throws NamingException {

		DN = "uid=" + userId + ",ou=rsimUsers,retekAppName="
				+ KOJLdapUtil.getUniqueInstance().getRetekAppName() + ","
				+ KOJLdapUtil.getUniqueInstance().getBaseDn();
		ModificationItem[] mods = null;
		Attribute mod0 = null;

		mods = new ModificationItem[1];
		mod0 = new BasicAttribute("userPassword", passwd);
		mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod0);

		try {
			if (KOJLdapUtil.getUniqueInstance().getContext().getAttributes(DN) != null) {
				KOJLdapUtil.getUniqueInstance().getContext().modifyAttributes(
						DN, mods);
				return true;
			}
		} catch (NameNotFoundException e) {

			log.error("Error occured : " + userId + errorMsg, e);
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method used to check the existence of user in LDAP if found return
	 * true else return false
	 * 
	 * @param employee
	 * @return
	 * @throws NamingException
	 */
	public static boolean isExist(KOJEmployee employee) throws NamingException {

		DN = "uid=" + employee.getUid() + ",ou=rsimUsers,retekAppName="
				+ KOJLdapUtil.getUniqueInstance().getRetekAppName() + ","
				+ KOJLdapUtil.getUniqueInstance().getBaseDn();
		DirContext dirCtx = null;
		try {
			dirCtx = KOJLdapUtil.getUniqueInstance().getContext();

			if (dirCtx.search(DN, employee.getMyAttrs()) != null) {
				return true;
			} else {
				return false;
			}
		} finally {
			if (dirCtx != null) {
				try {
					dirCtx.close();
				} catch (NamingException e) {
					log.error("Error occured : Employee not [" + employee.getUid()
							+ "] Added in LDAP", e);
					e.printStackTrace();
					return false;
				}
			}
		}
	}

	/**
	 * This method used to Add the employee in LDAP
	 * 
	 * @param employee
	 * @return
	 */
	public static boolean addEmployee(KOJEmployee employee) {
		boolean found = false;
		DN = "uid=" + employee.getUid() + ",ou=rsimUsers,retekAppName="
				+ KOJLdapUtil.getUniqueInstance().getRetekAppName() + ","
				+ KOJLdapUtil.getUniqueInstance().getBaseDn();
		DirContext dirCtx = null;
		try {

			dirCtx = KOJLdapUtil.getUniqueInstance().getContext();

			try {
				found = isExist(employee);

			} catch (NameNotFoundException e) {
				e.printStackTrace();
				found = false;
			}
			if (!found) {
				dirCtx.createSubcontext(DN, employee.getMyAttrs());
				log.info("INFO :** Employee [" + employee.getUid()
						+ "] added in LDAP**");
				return true;
			} else {
				log.info("INFO : Employee [" + employee.getUid()
						+ "] Already exists in LDAP");
				log.info("*****************************************************");
				return false;
			}
		} catch (NamingException e) {

			log.error("Error occured : Employee not [" + employee.getUid()
					+ "] Added in LDAP", e);
			e.printStackTrace();
			return false;
		} finally {
			if (dirCtx != null) {
				try {
					dirCtx.close();
				} catch (NamingException e) {
					log.error("Error occured : Employee not [" + employee.getUid()
							+ "] Added in LDAP", e);
					e.printStackTrace();
					return false;
				}
			}
		}

	}

	/**
	 * This method used to modify All Attributes of Employee
	 * 
	 * @param employee
	 * @return
	 */
	public static boolean modifyAllAttributes(KOJEmployee employee) {

		boolean found = false;
		DN = "uid=" + employee.getUid() + ",ou=rsimUsers,retekAppName="
				+ KOJLdapUtil.getUniqueInstance().getRetekAppName() + ","
				+ KOJLdapUtil.getUniqueInstance().getBaseDn();

		ModificationItem[] mods = new ModificationItem[1];
		Attribute mod0 = new BasicAttribute("userPassword", employee
				.getUserPassword());
		mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod0);
		BasicAttributes basicAttributes = employee.getMyAttrs();
		DirContext dirCtx = null;
		try {
			dirCtx = KOJLdapUtil.getUniqueInstance().getContext();
			try {
				found = isExist(employee);

			} catch (NameNotFoundException e) {
				e.printStackTrace();
				found = false;
			}

			if (found) {
				dirCtx.modifyAttributes(
						DN, DirContext.REPLACE_ATTRIBUTE, basicAttributes);
				log.info("INFO :** Employee [" + employee.getUid()
						+ "] updating in LDAP**");
				return true;
			} else {
				log.info("INFO : Employee [" + employee.getUid()
						+ "] not exists in LDAP");
				return false;
			}

		} catch (AttributeModificationException ame) {
			log.error("Error occured : ", ame);
			ame.printStackTrace();
			return false;
		} catch (NameAlreadyBoundException nabe) {
			log.error("Error occured : ", nabe);
			nabe.printStackTrace();
			return false;
		} catch (NamingException exception) {
			log.error("Error occured : " + employee.getUid() + errorMsg,exception);
			exception.printStackTrace();
			return false;
		}finally {
			if (dirCtx != null) {
				try {
					dirCtx.close();
				} catch (NamingException e) {
					log.error("Error occured : Employee not [" + employee.getUid()
							+ "] Added in LDAP", e);
					e.printStackTrace();
					return false;
				}
			}
		}
	}
	/**
	 * This method used to Delete the employee in LDAP
	 * 
	 * @param employee
	 * @return
	 */
	public static boolean deleteEmployee(KOJEmployee employee) {		
		DN = "uid=" + employee.getUid() + ",ou=rsimUsers,retekAppName="
				+ KOJLdapUtil.getUniqueInstance().getRetekAppName() + ","
				+ KOJLdapUtil.getUniqueInstance().getBaseDn();
		DirContext dirCtx = null;
		try {
			dirCtx = KOJLdapUtil.getUniqueInstance().getContext();
			
			dirCtx.destroySubcontext(DN);
			log.info("INFO :** Employee [" + employee.getUid()
						+ "] Deleted in LDAP**");
			System.out.println("INFO :** Employee [" + employee.getUid()
						+ "] Deleted in LDAP**");
			return true;
			
		} catch (NamingException e) {
			log.error("Error occured : Employee not [" + employee.getUid()
					+ "] Deleted in LDAP", e);
			System.out.println("Error occured : Employee not [" + employee.getUid()
					+ "] Deleted in LDAP" + e);
			e.printStackTrace();
			return false;
		} finally {
			if (dirCtx != null) {
				try {
					dirCtx.close();
				} catch (NamingException e) {
					log.error("Error occured : Employee not [" + employee.getUid()
							+ "] Deleted in LDAP", e);
					System.out.println("Error occured : Employee not [" + employee.getUid()
							+ "] Deleted in LDAP" + e);
					e.printStackTrace();
					return false;
				}
			}
		}

	}

}
