package com.example.sigfas.salocleide;

public class mServico {

    private int id;
    public String Nome;
    public Double Preco;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome){
        this.Nome = nome;
    }
    public void setPreco(Double preco){
        this.Preco = preco;
    }
    public String getNome(){
        return this.Nome;
    }
    public Double getPreco(){
        return this.Preco;
    }
}
