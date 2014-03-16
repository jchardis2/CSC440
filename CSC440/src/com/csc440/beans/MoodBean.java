package com.csc440.beans;

public class MoodBean {

    private int id;
    private int obcatID;
    private int type;
    
    public MoodBean(int id, int obcatID, int type) {
        this.setId(id);
        this.setObcatID(obcatID);
        this.setType(type);
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getObcatID() {
        return obcatID;
    }
    public void setObcatID(int obcatID) {
        this.obcatID = obcatID;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

}
