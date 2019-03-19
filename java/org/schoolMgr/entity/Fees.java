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
@Table(name = "FEE_MASTER")
public class Fees implements Serializable {

	private static final long serialVersionUID = 1L;

	int fee_id;

	String standard;

	int annual_fee;

	@Id
	@GenericGenerator(name = "fee_id", strategy = "increment")
	@GeneratedValue(generator = "fee_id")
	@Column(name = "fee_id", length = 20, nullable = false)
	public int getFee_id() {
		return fee_id;
	}

	public void setFee_id(int fee_id) {
		this.fee_id = fee_id;
	}

	@Column(name = "standard", length = 20, nullable = false)
	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	@Column(name = "annual_fee", length = 30, nullable = false)
	public int getAnnual_fee() {
		return annual_fee;
	}

	public void setAnnual_fee(int annual_fee) {
		this.annual_fee = annual_fee;
	}

}
