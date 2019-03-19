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
@Table(name = "fee_type")
public class FeesType implements Serializable{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int fee_typ_id;
	
	String fee_name;
	
	String fee_type;
	
	int lkg_value;
	
	int ukg_value;
	
	int first_value;
	
	int second_value;
	
	int third_value;
	
	int fourth_value;
	
	int fifth_value;
	
	int sixth_value;
	
	int seventh_value;
	
	int eighth_value;
	
	int ninth_value;
	
	int tenth_value;
	

	

	

	@Id
	@GenericGenerator(name="fee_typ_id" , strategy="increment")
	@GeneratedValue(generator="fee_typ_id")
	@Column(name = "fee_typ_id", length = 20, nullable = false)
	public int getFee_typ_id() {
		return fee_typ_id;
	}

	public void setFee_typ_id(int fee_typ_id) {
		this.fee_typ_id = fee_typ_id;
	}

	@Column(name = "fee_name", length = 20, nullable = false)
	public String getFee_name() {
		return fee_name;
	}

	public void setFee_name(String fee_name) {
		this.fee_name = fee_name;
	}

	@Column(name = "fee_type", length = 20, nullable = false)
	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	@Column(name = "lkg_value", length = 20, nullable = false)
	public int getLkg_value() {
		return lkg_value;
	}

	public void setLkg_value(int lkg_value) {
		this.lkg_value = lkg_value;
	}

	@Column(name = "ukg_value", length = 20, nullable = false)
	public int getUkg_value() {
		return ukg_value;
	}

	public void setUkg_value(int ukg_value) {
		this.ukg_value = ukg_value;
	}

	@Column(name = "first_value", length = 20, nullable = false)
	public int getFirst_value() {
		return first_value;
	}

	public void setFirst_value(int first_value) {
		this.first_value = first_value;
	}

	@Column(name = "second_value", length = 20, nullable = false)
	public int getSecond_value() {
		return second_value;
	}

	public void setSecond_value(int second_value) {
		this.second_value = second_value;
	}

	@Column(name = "third_value", length = 20, nullable = false)
	public int getThird_value() {
		return third_value;
	}

	public void setThird_value(int third_value) {
		this.third_value = third_value;
	}

	@Column(name = "fourth_value", length = 20, nullable = false)
	public int getFourth_value() {
		return fourth_value;
	}

	public void setFourth_value(int fourth_value) {
		this.fourth_value = fourth_value;
	}

	@Column(name = "fifth_value", length = 20, nullable = false)
	public int getFifth_value() {
		return fifth_value;
	}

	public void setFifth_value(int fifth_value) {
		this.fifth_value = fifth_value;
	}

	@Column(name = "sixth_value", length = 20, nullable = false)
	public int getSixth_value() {
		return sixth_value;
	}

	public void setSixth_value(int sixth_value) {
		this.sixth_value = sixth_value;
	}

	@Column(name = "seventh_value", length = 20, nullable = false)
	public int getSeventh_value() {
		return seventh_value;
	}

	public void setSeventh_value(int seventh_value) {
		this.seventh_value = seventh_value;
	}

	@Column(name = "eighth_value", length = 20, nullable = false)
	public int getEighth_value() {
		return eighth_value;
	}

	public void setEighth_value(int eighth_value) {
		this.eighth_value = eighth_value;
	}

	@Column(name = "ninth_value", length = 20, nullable = false)
	public int getNinth_value() {
		return ninth_value;
	}

	public void setNinth_value(int ninth_value) {
		this.ninth_value = ninth_value;
	}

	@Column(name = "tenth_value", length = 20, nullable = false)
	public int getTenth_value() {
		return tenth_value;
	}

	public void setTenth_value(int tenth_value) {
		this.tenth_value = tenth_value;
	}

	

	
	

	
	
}
