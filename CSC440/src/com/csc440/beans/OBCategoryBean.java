package com.csc440.beans;

public class OBCategoryBean {

	private int id;
	private int obid;
	private int type;
	private int cattype;
	private ObservationBean observationBean;

	public OBCategoryBean() {
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCattype() {
		return cattype;
	}

	public void setCattype(int cattype) {
		this.cattype = cattype;
	}

}
