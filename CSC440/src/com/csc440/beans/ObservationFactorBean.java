package com.csc440.beans;

public class ObservationFactorBean {
	private int id;
	private int observationtypeid;
	private String name;
	private String factorType;

	
	
	public ObservationFactorBean(int id, int observationtypeid, String name, String factorType) {
		super();
		this.id = id;
		this.observationtypeid = observationtypeid;
		this.name = name;
		this.factorType = factorType;
	}

	public ObservationFactorBean() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getObservationtypeid() {
		return observationtypeid;
	}

	public void setObservationtypeid(int observationtypeid) {
		this.observationtypeid = observationtypeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFactorType() {
		return factorType;
	}

	public void setFactorType(String factorType) {
		this.factorType = factorType;
	}

}
