package com.csc440.beans;

public class PainBean {

    private int id;
    private int obcatid;
    private int scale;
    
    public PainBean(int id, int obcatid, int scale) {
        this.setId(id);
        this.setObcatid(obcatid);
        this.setScale(scale);
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
    public int getScale() {
        return scale;
    }
    public void setScale(int scale) {
        this.scale = scale;
    }
    

}
