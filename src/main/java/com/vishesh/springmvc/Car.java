package com.vishesh.springmvc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "model")
public class Car {
	@Id
	@Column(name = "ModelNumber")
	String ModelNumber;

	@Column(name = "Make_ID")
	String Make_ID;

	@Column(name = "YearOfProduction")
	String YearOfProduction;

	@Column(name = "DownPayment")
	String DownPayment;

	public Car() {

	}

	public String getModelNumber() {
		return ModelNumber;
	}

	public void setModelNumber(String modelNumber) {
		ModelNumber = modelNumber;
	}

	public String getMakeID() {
		return Make_ID;
	}

	public void setMakeID(String makeID) {
		Make_ID = makeID;
	}

	public String getYearOfProduction() {
		return YearOfProduction;
	}

	public void setYearOfProduction(String yearOfProduction) {
		YearOfProduction = yearOfProduction;
	}

	public String getDownpayment() {
		return DownPayment;
	}

	public void setDownpayment(String downpayment) {
		DownPayment = downpayment;
	}

}
