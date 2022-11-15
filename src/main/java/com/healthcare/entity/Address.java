package com.healthcare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table (name="address")
public class Address {
	
	@Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
	
	
	/*
	 * @JoinColumn(name = "patientId") private int patientId;
	 */
	 
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public int getPatientId() { return patientId; } public void setPatientId(int
	 * patientId) { this.patientId = patientId; }
	 */
private String state ;
private String city;
private int pin;
private String street;


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
public int getPin() {
	return pin;
}
public void setPin(int pin) {
	this.pin = pin;
}
@Override
public String toString() {
	return "Address [state=" + state + ", city=" + city + ", pin=" + pin + ", street=" + street + "]";
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}


}
