package com.csc440.beans;

import java.util.Date;

public class AlertBean {

    private int id;
    private int type;
    private long patientid;
    private Date date;
    private int status;

    public AlertBean(int id, int type, long patientid, Date date, int status) {
        this.setID(id);
        this.setType(type);
        this.setPatientID(patientid);
        this.setDate(date);
        this.setStatus(status);
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public int getID() {
        return this.id;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    
    public int getType() {
        return this.type;
    }
    
    public void setPatientID(long patientID) {
        this.patientid = patientID;
    }
    
    public long getPatientID() {
        return this.patientid;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public Date getdate() {
        return this.date;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public int getStatus() {
        return this.status;
    }
    
}
