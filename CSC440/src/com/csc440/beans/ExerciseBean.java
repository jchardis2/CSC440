package com.csc440.beans;

public class ExerciseBean {

    private int id;
    private int obcatID;
    private String type;
    private int duration;
    
    public ExerciseBean(int id, int obcatID, String type, int duration) {
        this.setId(id);
        this.setObcatID(obcatID);
        this.setType(type);
        this.setDuration(duration);
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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

}
