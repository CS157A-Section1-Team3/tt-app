package registration.model;

public class Employee {
	private String username;
	private String password;
	private String departmentID; 
	private String position;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(String department) {
		this.departmentID = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

}

