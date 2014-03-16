package com.csc440.beans;

public class HealthProfessionalBean extends UserBean {

	private int id;
	private String username;
	private String password;
	private String type;
	private String name;
	private String clinic;

	public HealthProfessionalBean(int id, String type, String name,
			String clinic) {
		this.setId(id);
		this.setType(type);
		this.setName(name);
		this.setClinic(clinic);
	}

	public HealthProfessionalBean() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClinic() {
		return clinic;
	}

	public void setClinic(String clinic) {
		this.clinic = clinic;
	}

}
