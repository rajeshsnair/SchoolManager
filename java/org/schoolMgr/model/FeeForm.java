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
 * The model for the new member Fee form.

 */

public class FeeForm {
	

	private int fee_id;

	private String standard;

	private int tot_annual_fees;
	
	private ArrayList<FeeInfo> feeList;
	
	


	public int getFee_id() {
		return fee_id;
	}






	public void setFee_id(int fee_id) {
		this.fee_id = fee_id;
	}






	public String getStandard() {
		return standard;
	}






	public void setStandard(String standard) {
		this.standard = standard;
	}













	public int getTot_annual_fees() {
		return tot_annual_fees;
	}






	public void setTot_annual_fees(int tot_annual_fees) {
		this.tot_annual_fees = tot_annual_fees;
	}






	public ArrayList<FeeInfo> getFeeList() {
		return feeList;
	}






	public void setFeeList(ArrayList<FeeInfo> feeList) {
		this.feeList = feeList;
	}






	

}