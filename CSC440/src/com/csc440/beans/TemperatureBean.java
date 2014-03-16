package com.csc440.beans;

public class TemperatureBean {

    private int id;
    private int obcatid;
    private double temp;
    
    public TemperatureBean(int id, int obcatid, double temp) {
        this.setId(id);
        this.setObcatid(obcatid);
        this.setTemp(temp);
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getObcatid() {
        return obcatid;
    }
    public void setObcatid(int obcatid) {
        this.obcatid = obcatid;
    }
    public double getTemp() {
        return temp;
    }
    public void setTemp(double temp) {
        this.temp = temp;
    }

}
