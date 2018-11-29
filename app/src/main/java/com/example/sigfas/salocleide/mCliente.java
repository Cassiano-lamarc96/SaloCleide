package com.example.sigfas.salocleide;

public class mCliente {
    public mCliente(){

    }
    private int id;
    private String Nome;
    private int Telefone;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome){
        this.Nome = nome;
    }
    public void setTelefone(int telefone){
        this.Telefone = telefone;
    }
    public String getNome(){
        return this.Nome;
    }
    public int getTelefone() {
        return this.Telefone;
    }

}
