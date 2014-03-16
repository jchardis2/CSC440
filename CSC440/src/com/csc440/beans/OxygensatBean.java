package com.csc440.beans;

public class OxygensatBean {

    private int id;
    private int obcatid;
    private int sat;
    
    public OxygensatBean(int id, int obcatid, int sat) {
        this.setId(id);
        this.setObcatid(obcatid);
        this.setSat(sat);
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
    public int getSat() {
        return sat;
    }
    public void setSat(int sat) {
        this.sat = sat;
    }

}
