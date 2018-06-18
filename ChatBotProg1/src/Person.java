
public class Person
{

	protected String firstName;
	protected String lastName;
	protected char gender;
	protected int age;
	
	Person(String firstName, String lastName, char gender)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}
	
	Person(String firstName, String lastName, char gender, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
	}	

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public char getGender()
	{
		return gender;
	}

	public void setGender(char gender)
	{
		this.gender = gender;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
	
	
}
