package com.csc440.beans;

public class DietBean {

    private int id;
    private int obcatID;
    private String consumed;
    private int amount;
    
    public DietBean(int id, int obcatID, String consumed, int amount) {
        this.setID(id);
        this.setOBCATID(obcatID);
        this.setConsumed(consumed);
        this.setAmount(amount);
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public int getID() {
        return this.id;
    }
    
    public void setOBCATID(int obcatID) {
        this.obcatID = obcatID;
    }
    
    public int getOBCATID() {
        return this.obcatID;
    }
    
    public void setConsumed(String consumed) {
        this.consumed = consumed;
    }
    
    public String getConsumed() {
        return this.consumed;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public int getAmount() {
        return this.amount;
    }

}
