/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.schoolMgr.model;



/**
 * The model for the new member signup form.

 */

public class StudentInfo {
	
   private int std_id;
	
	private String firstname;

	private String lastname;

	private String standard;
	
	private int adm_no;
	
	private String dob;
	
	private String sex;
	
	private String guardian_name;
	
	private int contact;
	
	public StudentInfo(){}
	
	public StudentInfo(String firstname,String lastname,String standard,int adm_no,String dob,String sex,String guardian_name,int contact){
		this.firstname = firstname;
		this.lastname = lastname;
		this.standard = standard;
		this.adm_no = adm_no;
		this.dob = dob;
		this.sex = sex;
		this.guardian_name = guardian_name;
		this.contact = contact;
		
	}
	
	
	
	
	public int getStd_id() {
		return std_id;
	}

	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}

	public String getFirstname() {
		return firstname;
	}




	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}




	public String getLastname() {
		return lastname;
	}




	public void setLastname(String lastname) {
		this.lastname = lastname;
	}




	public String getStandard() {
		return standard;
	}




	public void setStandard(String standard) {
		this.standard = standard;
	}




	public int getAdm_no() {
		return adm_no;
	}




	public void setAdm_no(int adm_no) {
		this.adm_no = adm_no;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGuardian_name() {
		return guardian_name;
	}

	public void setGuardian_name(String guardian_name) {
		this.guardian_name = guardian_name;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}





	
	

}