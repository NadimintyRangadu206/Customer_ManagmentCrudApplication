package com.customermanagment.request;

import java.sql.Date;

public class CustomerRequest {

	private String firstName;
	private String lastName;	
	private String sex;
	private Date DOB;
	private String permanentAddress;
	private String residenceAddress;	
	private String state;
	private String city;
	private int zipCode;
	private int areaCode;
	private String MobileNo;
	private String email;
	
	public CustomerRequest(String firstName, String lastName, String sex, Date dOB, String permanentAddress,
			String residenceAddress, String state, String city, int zipCode, int areaCode, String mobileNo,
			String email) {
		
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		DOB = dOB;
		this.permanentAddress = permanentAddress;
		this.residenceAddress = residenceAddress;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.areaCode = areaCode;
		MobileNo = mobileNo;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getResidenceAddress() {
		return residenceAddress;
	}

	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "CustomerRequest [firstName=" + firstName + ", lastName=" + lastName + ", sex=" + sex + ", DOB=" + DOB
				+ ", permanentAddress=" + permanentAddress + ", residenceAddress=" + residenceAddress + ", state="
				+ state + ", city=" + city + ", zipCode=" + zipCode + ", areaCode=" + areaCode + ", MobileNo="
				+ MobileNo + ", email=" + email + "]";
	}
	
	
	
}
