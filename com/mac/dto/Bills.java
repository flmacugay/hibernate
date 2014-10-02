package com.mac.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Bills {
	
	@Id
	@Column(name="BILLS_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name="seq", allocationSize=1, sequenceName="SEQ_BILLS")
	private int id;
	private String type;
	private double amount;
	
	@ManyToMany
	@JoinTable(name="USER_BILLS", joinColumns=@JoinColumn(name="BILLS_ID"), inverseJoinColumns=@JoinColumn(name="USER_ID"))
	private Collection<UserDetails> userDetails;

	public Bills() {
		super();
		this.userDetails=new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public Bills(String type, double amount) {
		super();
		this.type = type;
		this.amount = amount;
		this.userDetails=new ArrayList<>();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Collection<UserDetails> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(Collection<UserDetails> userDetails) {
		this.userDetails = userDetails;
	}

	public int getId() {
		return id;
	}

}
