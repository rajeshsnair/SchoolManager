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

public class StudentFeeForm {
	

	private String firstname;

	private String lastname;

	private String standard;
	
	private int std_id;
	
	private int adm_no;
	
	private int mnthly_fees;
	
	private String last_paid_dt;
	
	private int rem_fees;
	
	private String last_paid_mnth;
	
	
	
	public int getStd_id() {
		return std_id;
	}




	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}




	public int getMnthly_fees() {
		return mnthly_fees;
	}




	public void setMnthly_fees(int mnthly_fees) {
		this.mnthly_fees = mnthly_fees;
	}




	public String getLast_paid_dt() {
		return last_paid_dt;
	}




	public void setLast_paid_dt(String last_paid_dt) {
		this.last_paid_dt = last_paid_dt;
	}




	public int getRem_fees() {
		return rem_fees;
	}




	public void setRem_fees(int rem_fees) {
		this.rem_fees = rem_fees;
	}




	public String getLast_paid_mnth() {
		return last_paid_mnth;
	}




	public void setLast_paid_mnth(String last_paid_mnth) {
		this.last_paid_mnth = last_paid_mnth;
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





	
	

}