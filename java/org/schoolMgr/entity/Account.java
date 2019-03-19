/**
 * 
 */
package org.schoolMgr.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author narajesh
 *
 */

@Entity
@Table(name = "UserDetails")
public class Account implements Serializable{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int userId;
	
	String firstName;
	
	String lastName;
	
	String designation;
	
	String phone;
	
	String role;
	
	boolean active;
	
	String userName;
	
	String password;
	
	String email;
	


	public static final String ROLE_ADMIN = "ADMIN";
	 public static final String ROLE_USER = "OPERATOR";
	
	
	@Id
	@GenericGenerator(name="usrid" , strategy="increment")
	@GeneratedValue(generator="usrid")
	@Column(name = "usr_id", length = 20, nullable = false)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "first_name", length = 20, nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 20, nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "designation", length = 20, nullable = false)
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column(name = "phone", length = 20, nullable = false)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	@Column(name = "role", length = 20, nullable = false)
	public String getRole() {
		return role;
	}

	

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "active", length = 1, nullable = false)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Column(name = "usr_name", length = 20, nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	@Column(name = "password", length = 20, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Column(name = "email", length = 20, nullable = false)
	 public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
