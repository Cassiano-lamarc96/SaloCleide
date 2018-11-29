package com.example.sigfas.salocleide;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toolbar;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class actRegisterService extends AppCompatActivity {

    bancoDados db = new bancoDados(this);
    Spinner Spn;
    Spinner SpnServ;
    EditText edtPreco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_register_service);
        carregaSpinnerCliente();
    }
    HashMap<Integer, String> lstCliente = new HashMap<Integer, String>();
    HashMap<Integer, String> lstServico = new HashMap<Integer, String>();
    List<mCliente> LstmCliente = new ArrayList<mCliente>();
    
    public void carregaSpinnerCliente(){
        //LstmCliente = db.retornaClientes();
        //Spn = findViewById(R.id.spnCliente);
        //String[] spinnerArray = new String[LstmCliente.size()];
        //List<String> lstNome = new ArrayList<String>();
        //for (mCliente clie : LstmCliente){
        //    lstNome.add(clie.getNome());
        //}
        //List<Integer> lstId = new ArrayList<Integer>();
        //for (mCliente clie : LstmCliente){
        //    lstId.add((clie.getId()));
        //}
        //for (int i = 0; i < LstmCliente.size(); i ++){
        //    lstCliente.put(i, lstId.get(i).toString());
        //    spinnerArray[i] = lstNome.get(i);
        //}

        //ArrayAdapter<String> arrayAdapter =
        //        new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        //arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Spn.setAdapter(arrayAdapter);
    }

    public void carregaSpinnerServico(){
        List<mServico> LstmServico = new ArrayList<mServico>();
        LstmServico = db.retornaServico();
        SpnServ = findViewById(R.id.spnServico);
        String[] spinnerArray = new String[LstmServico.size()];
        List<String> lstNome = new ArrayList<String>();
        for (mServico serv : LstmServico){
            lstNome.add(serv.getNome());
        }
        List<Integer> lstId = new ArrayList<Integer>();
        for (mServico serv : LstmServico){
            lstId.add((serv.getId()));
        }
        for (int i = 0; i < LstmServico.size(); i ++){
            lstServico.put(i, lstId.get(i).toString());
            spinnerArray[i] = lstNome.get(i);
        }

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpnServ.setAdapter(arrayAdapter);
    }

    private boolean cadastrarServico(){
        return  true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menusalao, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.adicionarNovoCliente:
                MudarParaAct(actAddCliente.class);
            case R.id.adicionarNovoServico:
                MudarParaAct(actAddServico.class);

        }
        return true;
    }

    public void MudarParaAct(Class actClass){
        Intent it = new Intent(this, actClass);
        startActivity(it);
    }

    protected void cadastrar(View view){
        Intent it = new Intent(this, actConsultaServicos.class);
        DialogFragment dialog = new DialogFragment();
        if (cadastrarServico()){
            dialog.show(getSupportFragmentManager(), "Cadastro Realizado com sucesso!");
            startActivity(it);
        }else{
            dialog.show(getSupportFragmentManager(), "Não foi possível cadastrar. Tente novamente!");
        }
    }
}
