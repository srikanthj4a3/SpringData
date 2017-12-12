package com.spring.data.mongo;

public class Address {
	
	private String houseNo;
	private String street;
	private String city;
	
	public Address() {
		
	}
	
	public Address(String houseNo, String street, String city) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
	}
	
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
