package com.csc440.beans;

import java.sql.Date;
import java.sql.Timestamp;

public class ObservationBean {

	private int id;
	private int patientID;
	private int type;
	private Date obdate;
	private Timestamp timestamp;
	private Timestamp recordtime;

	public ObservationBean(int id, int patientID, int type, Date obdate,
			Timestamp timestamp, Timestamp recordtime) {
		this.setId(id);
		this.setType(type);
		this.setObdate(obdate);
		this.setTimestamp(timestamp);
		this.setRecordtime(recordtime);
	}

	public ObservationBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getObdate() {
		return obdate;
	}

	public void setObdate(Date obdate) {
		this.obdate = obdate;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Timestamp getRecordtime() {
		return recordtime;
	}

	public void setRecordtime(Timestamp recordtime) {
		this.recordtime = recordtime;
	}

}
