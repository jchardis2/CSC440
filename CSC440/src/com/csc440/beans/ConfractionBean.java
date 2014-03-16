package com.csc440.beans;

public class ConfractionBean {

    private int id;
    private int obcatID;
    private int frequency;
    
    public ConfractionBean(int id, int obcatID, int frequency) {
        this.setID(id);
        this.setID(obcatID);
        this.setFrequency(frequency);
    }
    
    public void setID(int id) {
        this.id = id;    
    }
    
    public int getID() {
        return this.id;
    }
    
    public void setOBCATID(int obcatid) {
        this.obcatID = obcatid;
    }
    
    public int getOBCATID() {
        return this.obcatID;
    }
    
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    
    public int getFrequency() {
        return this.frequency;
    }

}
