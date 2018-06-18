/****************************************************************************************
 * Copyright (c) 2011 KOJ Group. All Rights Reserved.
 * 
 *
 * Rev 1.0   APR 2012 Sanish Gupta
 * 
 ******************************************************************************************/

package koj.retail.ldap;

import javax.naming.directory.Attribute;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;


public class KOJEmployee
{
	String   uid,
			 employmentStatus,
			 userPassword,
			 shortName,          
			 firstName,
			 middleName,
			 lastName,
			 preferredCountry,
			 preferredLanguage,
			 ssn,
			 homeStore,
			 role,
			 email,
			 store;




	
	BasicAttributes myAttrs;

	/****************************************************************************************
	 * Method to get All Basic Attributes of Employee for LDAP
	 * 
	 * @return
	 ***************************************************************************************/
	public BasicAttributes getMyAttrs() {
		return myAttrs;
	}

	
	/**
	 * @param uid
	 * @param employmentStatus
	 * @param userPassword
	 * @param givenname
	 * @param shortName
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param preferredCountry
	 * @param preferredLanguage
	 * @param ssn
	 * @param ou
	 * @param email
	 */

	public KOJEmployee(String uid,
			String employmentStatus,
			String userPassword,
			String shortName,
			String firstName,
			String middleName,
			String lastName,
			String preferredCountry,
			String preferredLanguage,
			String ssn,
			String store,
			String homeStore,
			String role,
			String email)
	{
		
		
		this.uid = uid;
		this.employmentStatus = employmentStatus;
		this.userPassword = userPassword;
		this.shortName = shortName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.preferredCountry = preferredCountry;
		this.preferredLanguage = preferredLanguage;
		this.ssn = ssn;
		this.store = store;
		this.homeStore = homeStore;
		this.role = role;
		this.email = email;
		
		
		myAttrs = new BasicAttributes(true); //Basic Attributes
		Attribute objectClass = new BasicAttribute("objectClass", "rsimUser");	//Adding Object Classes

		myAttrs.put(objectClass);
		myAttrs.put("uid",uid);
		myAttrs.put("employmentStatus",employmentStatus);		
		myAttrs.put("userPassword",userPassword);
		myAttrs.put("shortName",shortName);
		myAttrs.put("firstName",firstName);
		myAttrs.put("middleName",middleName);
		myAttrs.put("lastName",lastName);
		myAttrs.put("ssn",ssn);
		myAttrs.put("email",email);
		myAttrs.put("preferredCountry",preferredCountry);
		myAttrs.put("preferredLanguage",preferredLanguage);
		
		if (homeStore!= null)
		{
			myAttrs.put("homeStore", "rsimStoreId=" + homeStore + "," + KOJLdapUtil.getUniqueInstance().getUserStore());
		}
		
		if (role!= null)
		{
			myAttrs.put("userRole", "rsimRoleName=" + role + "," + KOJLdapUtil.getUniqueInstance().getUserRole());
		}
		
		if (store!=null)
		{
			
			myAttrs.put("userStore", "rsimStoreId=" + store + "," + KOJLdapUtil.getUniqueInstance().getUserStore());
		}
	}

	/***************************************************************************
	 * Getters and Setters methods
	 * 
	 ****************************************************************************/
	public String getUid() {
		return this.uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}


	public String getEmploymentStatus() {
		return employmentStatus;
	}


	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getShortName() {
		return shortName;
	}


	public void setShortName(String shortName) {
		this.shortName = shortName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPreferredCountry() {
		return preferredCountry;
	}


	public void setPreferredCountry(String preferredCountry) {
		this.preferredCountry = preferredCountry;
	}


	public String getPreferredLanguage() {
		return preferredLanguage;
	}


	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}


	public String getSsn() {
		return ssn;
	}


	public void setSsn(String ssn) {
		this.ssn = ssn;
	}


	public String getHomeStore() {
		return homeStore;
	}


	public void setHomeStore(String homeStore) {
		this.homeStore = homeStore;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getStore() {
		return store;
	}


	public void setStore(String store) {
		this.store = store;
	}


	@Override
	public String toString() {
		return "Employee [email=" + email + ", employmentStatus="
				+ employmentStatus + ", firstName=" + firstName
				+ ", homeStore=" + homeStore + ", lastName=" + lastName
				+ ", middleName=" + middleName + ", myAttrs=" + myAttrs
				+ ", preferredCountry=" + preferredCountry
				+ ", preferredLanguage=" + preferredLanguage + ", role=" + role
				+ ", shortName=" + shortName + ", ssn=" + ssn + ", store="
				+ store + ", uid=" + uid + ", userPassword=" + userPassword
				+ "]";
	}

}

