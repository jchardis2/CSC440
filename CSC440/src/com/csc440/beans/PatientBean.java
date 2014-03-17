package com.csc440.beans;

import java.sql.Date;

public class PatientBean extends UserBean {

	private int id;
	private String username;
	private String password;
	private Date dob;
	private String name;
	private String address;
	private boolean sex;
	private boolean healthfriend;

	public PatientBean(int id, String username, String password, Date dob,
			String name, String address, boolean sex, boolean healthfriend) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.name = name;
		this.address = address;
		this.sex = sex;
		this.healthfriend = healthfriend;
	}

	public PatientBean() {
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return this.id;
	}

	public void setDOB(Date dob) {
		this.dob = dob;
	}

	public Date getDOB() {
		return this.dob;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public boolean getSex() {
		return this.sex;
	}

	public void setHealthfriend(boolean healthfriend) {
		this.healthfriend = healthfriend;
	}

	public boolean getHealthfriend() {
		return this.healthfriend;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
