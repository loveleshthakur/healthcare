package com.healthcare.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Target;

@Entity
@Table(name ="patient")
public class Patient {

	

	@Id
    @GeneratedValue
    private int patientId;
    
	private String name;
    private LocalDate dob ;
   
    
    @OneToMany(targetEntity = Phone.class )
    @JoinColumn(name="patientId" ,nullable = false)
    @Cascade({CascadeType.ALL})
    private Set<Phone> phone;
   
    @OneToMany(targetEntity = GovernmentIdentity.class )
    @JoinColumn(name="patientId" ,nullable = false)
    @Cascade({CascadeType.ALL})
    private Set<GovernmentIdentity> govtIds;
    
    @OneToMany(targetEntity = Address.class )
    @JoinColumn(name="patientId" ,nullable = false)
    @Cascade({CascadeType.ALL})
	private Set<Address> addresses;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
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
	}

	public Set<Phone> getPhone() {
		return phone;
	}

	public void setPhone(Set<Phone>phone) {
		this.phone = phone;
	}

	public Set<GovernmentIdentity> getGovtIds() {
		return govtIds;
	}

	public void setGovtIds(Set<GovernmentIdentity> govtIds) {
		this.govtIds = govtIds;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
    
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name + ", dob=" + dob + ", phone=" + phone + ", govtIds="
				+ govtIds + ", addresses=" + addresses + "]";
	}
	
		}
