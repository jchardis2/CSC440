package com.csc440.beans;

public class ExerciseToleranceBean {

    private int id;
    private int obcatID;
    private int steps;
    
    public ExerciseToleranceBean(int id, int obcatID, int steps) {
        this.setId(id);
        this.setObcatID(obcatID);
        this.setSteps(steps);
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
    public int getSteps() {
        return steps;
    }
    public void setSteps(int steps) {
        this.steps = steps;
    }
    
    

}
