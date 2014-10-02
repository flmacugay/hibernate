package com.mac.dto;

import javax.persistence.Embeddable;

@Embeddable
public class Employment {
	
	private String position;
	private String company;
	public Employment(String position, String company) {
		super();
		this.position = position;
		this.company = company;
	}
	public Employment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

}
