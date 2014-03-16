package com.csc440.beans;

public class PatientTypeBean {

    private long patientID;
    private int typeid;
    
    public PatientTypeBean(long patientID, int typeid) {
        this.setPatientID(patientID);
        this.setTypeid(typeid);
    }
    
    public long getPatientID() {
        return patientID;
    }
    public void setPatientID(long patientID) {
        this.patientID = patientID;
    }
    public int getTypeid() {
        return typeid;
    }
    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }
    
    

}
