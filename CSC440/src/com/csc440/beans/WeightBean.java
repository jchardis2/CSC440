package com.csc440.beans;

public class WeightBean {

    private int id;
    private int obcatid;
    private double amount;
    
    public WeightBean(int id, int obcatid, double amount) {
        this.setId(id);
        this.setObcatid(obcatid);
        this.setAmount(amount);
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
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

}
