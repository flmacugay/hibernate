package com.mac.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String unit;
	private String street;
	private String city;
	private String state;
	private String country;
	@Column(name="POST_CODE")
	private int postCode;
	private String type;
	
	
	public Address() {
		super();
	}
	
	
	public Address(String unit, String street, String city,
			String state, String country, int postCode, String type) {
		super();
		this.unit = unit;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postCode = postCode;
		this.type = type;
	}


	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Address [unit=" + unit + ", street=" + street + ", city="
				+ city + ", state=" + state + ", country=" + country
				+ ", postCode=" + postCode + "]";
	}
}
