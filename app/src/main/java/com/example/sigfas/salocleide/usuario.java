package com.example.sigfas.salocleide;

public class usuario {
    public usuario(){

    }

    private int id;
    private int codUser;
    private String pswUser;

    public int getId(){
        return this.id;
    }

    public void setCodUser(int codUser){
        this.codUser = codUser;
    }

    public int getCodUser(){
        return  this.codUser;
    }

    public void setPswUser(String pswUser){
        this.pswUser = pswUser;
    }

    public String getPswUser(){
        return this.pswUser;
    }
}
