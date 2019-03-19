/**
 * 
 */
package org.schoolMgr.entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "student_details")
public class Student implements Serializable{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int std_id;
	
	String firstName;
	
	String lastName;
	
	String standard;
	
	Date dob;
	
	String sex;
	
	String guardian_name;
	
	int contact;
	
	
	int adm_no;

	


	
	
	@Id
	@GenericGenerator(name="std_id" , strategy="increment")
	@GeneratedValue(generator="std_id")
	@Column(name = "std_id", length = 20, nullable = false)
	public int getStd_id() {
		return std_id;
	}

	public void setStd_id(int std_id) {
		this.std_id = std_id;
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

	@Column(name = "standard", length = 20, nullable = false)
	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	@Column(name = "adm_no", length = 20, nullable = false)
	public int getAdm_no() {
		return adm_no;
	}

	public void setAdm_no(int adm_no) {
		this.adm_no = adm_no;
	}

	@Column(name = "dob", length = 20, nullable = false)
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "sex", length = 20, nullable = false)
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "guardian_name", length = 20, nullable = false)
	public String getGuardian_name() {
		return guardian_name;
	}

	public void setGuardian_name(String guardian_name) {
		this.guardian_name = guardian_name;
	}

	@Column(name = "contact", length = 20, nullable = false)
	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}
	
	
	
	
}
