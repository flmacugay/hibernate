package com.mac.dto;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.Type;

@Entity
@Table(name="USER_DETAILS")
@SelectBeforeUpdate
public class UserDetails {
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name="seq", allocationSize=1, initialValue=1, sequenceName="SEQ_USER")
	private int userId;
	@Column(name="USER_NAME")
	private String userName;
	@Column(name="JOINED_DATE")
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	@Transient
	private String description;
	@Embedded
	private Employment employment;

	@ElementCollection
	@JoinTable(name="USER_ADDR", joinColumns=@JoinColumn(name="USER_ID"))
	@CollectionId(columns=@Column(name="ADDR_ID"), generator="seq", type=@Type(type="int")) /* hibernate api */
	@SequenceGenerator(name="seq", allocationSize=1, initialValue=1, sequenceName="SEQ_ADDR")
	private Collection<Address> listOfAddress;
	
	//@OneToMany
	//@JoinTable(name="USER_CARS", joinColumns=@JoinColumn(name="USER_ID"), inverseJoinColumns=@JoinColumn(name="CAR_ID"))
	@OneToMany(mappedBy="userDetails", cascade=CascadeType.ALL)
	private Collection<Vehicle> vehicles;
	
	//@OneToOne
	//@JoinColumn(name="QUAL_ID")
	@OneToOne(mappedBy="userDetails")
	private Qualification qualification;
	
	@ManyToMany(mappedBy="userDetails")
	private Collection<Bills> bills;
	
	public UserDetails() {
		this.listOfAddress=new ArrayList<>();
		this.vehicles=new ArrayList<>();
		this.bills=new ArrayList<>();
	}
	
	
	public UserDetails(String userName, Date joinedDate, String description) {
		super();
		this.userName = userName;
		this.joinedDate = joinedDate;
		this.description = description;
		this.listOfAddress=new ArrayList<>();
		this.vehicles=new ArrayList<>();
		this.bills=new ArrayList<>();
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Employment getEmployment() {
		return employment;
	}
	public void setEmployment(Employment employment) {
		this.employment = employment;
	}
	public Qualification getQualification() {
		return qualification;
	}
	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}
	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	public Collection<Bills> getBills() {
		return bills;
	}
	public void setBills(Collection<Bills> bills) {
		this.bills = bills;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName
				+ ", joinedDate=" + joinedDate + ", description=" + description + "]";
	}
}
