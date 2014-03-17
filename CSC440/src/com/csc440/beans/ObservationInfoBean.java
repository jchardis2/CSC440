package com.csc440.beans;

public class ObservationInfoBean<T> {
	private int id;
	private int obid;
	private String name;
	private T info;

	public ObservationInfoBean() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getObid() {
		return obid;
	}

	public void setObid(int obid) {
		this.obid = obid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

}
