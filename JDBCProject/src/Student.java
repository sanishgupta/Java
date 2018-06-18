
public class Student {
	
	private int id;
	private String name;
	private String college;
	/**
	 * @return Returns the college.
	 */
	public String getCollege() {
		return college;
	}
	/**
	 * @param college The college to set.
	 */
	public void setCollege(String college) {
		this.college = college;
	}
	/**
	 * @return Returns the id.
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	public Student( int id,String college, String name) {
		super();
		// TODO Auto-generated constructor stub
		this.college = college;
		this.id = id;
		this.name = name;
	}
	
	

}
