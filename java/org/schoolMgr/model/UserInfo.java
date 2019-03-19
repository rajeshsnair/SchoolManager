/**
 * 
 */
package org.schoolMgr.model;

/**
 * @author narajesh
 *
 */
public class UserInfo {
	
	int userId;
	
	String firstName;
	
	String lastName;
	
	String userName;
	
	String password;
	
	String designation;
	
	String phone;
	
	String email;
	
	String role;
	

	public UserInfo(String firstName,String lastName,String username,String password,String email,String designation,String phone,String role){
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = username;
		this.password = password;
		this.email = email;
		this.designation = designation;
		this.phone = phone;
		this.role = role;
		
	}
	
	
	
	
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

    public String getPhone() {
		return phone;
	}

    public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
	
	

}
