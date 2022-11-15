package com.healthcare.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Phone {
	@Id
	@GeneratedValue
    private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private long phoenumber;
	
	public long getPhoenumber() {
		return phoenumber;
	}
	public void setPhoenumber(long phoenumber) {
		this.phoenumber = phoenumber;
	}
	
}
