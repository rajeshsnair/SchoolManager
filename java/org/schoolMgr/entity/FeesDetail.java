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
@Table(name = "fee_details")
public class FeesDetail implements Serializable{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int fee_det_id;
	
	int std_id;
	
	int adm_no;
	
	int mnthly_fees;
	
	int rem_fees;
	
	Date last_paid_dt;
	
	String last_paid_mnth;




	
	





	
	
	@Id
	@GenericGenerator(name="fee_det_id" , strategy="increment")
	@GeneratedValue(generator="fee_det_id")
	@Column(name = "fee_det_id", length = 20, nullable = false)
	public int getFee_det_id() {
		return fee_det_id;
	}

	public void setFee_det_id(int fee_det_id) {
		this.fee_det_id = fee_det_id;
	}

	
	@Column(name = "std_id", length = 20, nullable = false)

	public int getStd_id() {
		return std_id;
	}

	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}
	
	@Column(name = "adm_no", length = 20, nullable = false)

	public int getAdm_no() {
		return adm_no;
	}

	public void setAdm_no(int adm_no) {
		this.adm_no = adm_no;
	}

	@Column(name = "mnthly_fees", length = 20, nullable = false)
	public int getMnthly_fees() {
		return mnthly_fees;
	}

	public void setMnthly_fees(int mnthly_fees) {
		this.mnthly_fees = mnthly_fees;
	}

	@Column(name = "rem_fees", length = 20, nullable = false)
	public int getRem_fees() {
		return rem_fees;
	}

	public void setRem_fees(int rem_fees) {
		this.rem_fees = rem_fees;
	}
	
	@Column(name = "last_paid_dt", length = 20, nullable = false)
	public Date getLast_paid_dt() {
		return last_paid_dt;
	}

	public void setLast_paid_dt(Date last_paid_dt) {
		this.last_paid_dt = last_paid_dt;
	}
	
	@Column(name = "last_paid_mnth", length = 20, nullable = false)
	public String getLast_paid_mnth() {
		return last_paid_mnth;
	}

	public void setLast_paid_mnth(String last_paid_mnth) {
		this.last_paid_mnth = last_paid_mnth;
	}

	
	
}
