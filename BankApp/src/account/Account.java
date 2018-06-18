package account;


public class Account {
	 
 public Account(int accountNumber, String firstName, String lastName,
		String password,int age, String gender, String maritualStatus, String address, String city, String country) {
	super();
	this.accountNumber = accountNumber;
	this.firstName = firstName;
	this.lastName = lastName;
	this.password = password;
	this.gender = gender;
	this.maritualStatus = maritualStatus;
	this.address = address;
	
	this.city = city;
	this.country = country;
}
public int getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getMaritualStatus() {
	return maritualStatus;
}
public void setMaritualStatus(String maritualStatus) {
	this.maritualStatus = maritualStatus;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
 
private int accountNumber;
private String firstName;
private String lastName;
 private String password;
 private int age;
 public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}

private String gender;
 private String maritualStatus;
 private String address;
 
 private String city;
 private String country;
}
	