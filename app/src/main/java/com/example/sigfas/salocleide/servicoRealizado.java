package com.example.sigfas.salocleide;

public class servicoRealizado {

    private int id;
    private int idCliente;
    private int idServico;
    private double preco;

    public void setpreco(double preco){
        this.preco = preco;
    }

    public double getPreco(){
        return this.preco;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setIdCliente(int clie_id){
        this.idCliente = clie_id;
    }

    public void setIdServico(int serv_id){
        this.idServico = serv_id;
    }
    public int getIdCliente(){
        return this.idCliente;
    }
    public int getIdServico(){
        return this.idServico;
    }

}
