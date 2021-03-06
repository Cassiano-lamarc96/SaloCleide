package com.example.sigfas.salocleide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class actConsultaServicos extends AppCompatActivity {

    ArrayList<String> listItems = new ArrayList<String>();
    bancoDados bd = new bancoDados(this);
    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;
    ListView lstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_consulta_servicos);
        carregaListView();
    }

    public void carregaListView(){
        List<servicoRealizado> lstSrevico = new ArrayList<servicoRealizado>();
        lstSrevico = bd.retornaServicoRealizado();
        for (servicoRealizado Servico : lstSrevico){
            String Itens =  "Cliente: " + bd.retornaClieId(Integer.parseInt(Servico.getIdCliente() + "")).getNome() +
                    "; Servico = " + bd.retornaServId(Integer.parseInt(Servico.getIdServico() + "")).getNome() + " Preço: " + Servico.getPreco();
            listItems.add(Itens);
        }
        setContentView(R.layout.activity_act_consulta_servicos);
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        lstView = findViewById(R.id.lstServicos);
        lstView.setAdapter(adapter);
    }

    protected void refresh(View view){
        this.finish();
        Intent itRefresh = new Intent(this, actConsultaServicos.class);
        startActivity(itRefresh);
    }
}
