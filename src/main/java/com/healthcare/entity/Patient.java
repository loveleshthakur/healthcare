package com.healthcare.entity;

import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
    @GeneratedValue
    private int id;
    
	private String name;
    private LocalDate dob ;
    private String address;
    private String phone;
    private BigInteger aadharNo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
		System.out.println(dob);
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public BigInteger getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(BigInteger aadharNo) {
		this.aadharNo = aadharNo;
	}
	}
