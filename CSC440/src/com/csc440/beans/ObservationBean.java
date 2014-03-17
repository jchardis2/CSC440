package com.csc440.beans;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ObservationBean {

	private int id;
	private int patientID;
	private int observationtypeid;
	private Date obdate;
	private Timestamp obtime;
	private Timestamp recordtime;
	private ObservationTypeBean observationTypeBean;
	private ArrayList<ObservationInfoBean<?>> observationInfo = new ArrayList<>();

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

	public int getObservationtypeid() {
		return observationtypeid;
	}

	public void setObservationtypeid(int observationtypeid) {
		this.observationtypeid = observationtypeid;
	}

	public Date getObdate() {
		return obdate;
	}

	public void setObdate(Date obdate) {
		this.obdate = obdate;
	}

	public Timestamp getObtime() {
		return obtime;
	}

	public void setObtime(Timestamp obtime) {
		this.obtime = obtime;
	}

	public Timestamp getRecordtime() {
		return recordtime;
	}

	public void setRecordtime(Timestamp recordtime) {
		this.recordtime = recordtime;
	}

	public ObservationTypeBean getObservationTypeBean() {
		return observationTypeBean;
	}

	public void setObservationTypeBean(ObservationTypeBean observationTypeBean) {
		this.observationTypeBean = observationTypeBean;
	}

	public ArrayList<ObservationInfoBean<?>> getObservationInfo() {
		return observationInfo;
	}

	public void setObservationInfo(
			ArrayList<ObservationInfoBean<?>> observationInfo) {
		this.observationInfo = observationInfo;
	}

}
