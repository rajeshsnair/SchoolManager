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

import java.util.ArrayList;

/**
 * The model for the new member signup form.

 */

public class DashBoardForm {
	

	
	
	private int total_students;
	
	private ArrayList<String> standards;
	
	private ArrayList<Integer> standard_students;
	
	private int paid_curr_month;
	
	private int rem_curr_month;

	private String curr_month;
	
	
	
	public String getCurr_month() {
		return curr_month;
	}

	public void setCurr_month(String curr_month) {
		this.curr_month = curr_month;
	}

	public int getTotal_students() {
		return total_students;
	}

	public void setTotal_students(int total_students) {
		this.total_students = total_students;
	}

	public ArrayList<String> getStandards() {
		return standards;
	}

	public void setStandards(ArrayList<String> standards) {
		this.standards = standards;
	}

	public ArrayList<Integer> getStandard_students() {
		return standard_students;
	}

	public void setStandard_students(ArrayList<Integer> standard_students) {
		this.standard_students = standard_students;
	}

	public int getPaid_curr_month() {
		return paid_curr_month;
	}

	public void setPaid_curr_month(int paid_curr_month) {
		this.paid_curr_month = paid_curr_month;
	}

	public int getRem_curr_month() {
		return rem_curr_month;
	}

	public void setRem_curr_month(int rem_curr_month) {
		this.rem_curr_month = rem_curr_month;
	}
	
	
	

}