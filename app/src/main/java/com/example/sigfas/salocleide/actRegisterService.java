package com.example.sigfas.salocleide;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
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
        carregaSpinnerServico();
    }
    HashMap<Integer, String> lstCliente = new HashMap<Integer, String>();
    HashMap<Integer, String> lstServico = new HashMap<Integer, String>();
    List<mCliente> LstmCliente = new ArrayList<mCliente>();
    
    public void carregaSpinnerCliente(){
        LstmCliente = db.retornaClientes();
        Spn = findViewById(R.id.spnCliente);
        String[] spinnerArray = new String[LstmCliente.size()];
        List<String> lstNome = new ArrayList<String>();
        for (mCliente clie : LstmCliente){
            lstNome.add(clie.getNome());
        }
        List<Integer> lstId = new ArrayList<Integer>();
        for (mCliente clie : LstmCliente){
            lstId.add((clie.getId()));
        }
        for (int i = 0; i < LstmCliente.size(); i ++){
            lstCliente.put(i, lstId.get(i).toString());
            spinnerArray[i] = lstNome.get(i);
        }

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spn.setAdapter(arrayAdapter);
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
        servicoRealizado sere = new servicoRealizado();
        sere.setIdCliente(Integer.parseInt(lstCliente.get(Spn.getSelectedItemPosition())));
        sere.setIdServico(Integer.parseInt(lstServico.get(SpnServ.getSelectedItemPosition())));
        edtPreco = findViewById(R.id.edtPreco);
        if (!edtPreco.getText().toString().isEmpty()){
            sere.setpreco(Double.parseDouble(edtPreco.getText().toString()));
            if (db.insereServicoRealizado(sere)) {
                mensagem(1);
                return true;
            }else{
                mensagem(0);
                return false;
            }
        }else{
            mensagem(0);
            return false;
        }
    }

    public void mensagem(int tipo){
        String Title;
        String Msg;
        if (tipo == 0){
            //error
            Title = "Erro";
            Msg = "Preencha todos os campos e Tente novamente!";
        }else{
            //success
            Title = "Sucesso!";
            Msg = "Serviço Cadastrado com sucesso!";
        }

        AlertDialog.Builder alert = new AlertDialog.Builder(actRegisterService.this);
        alert.setTitle(Title);
        alert.setMessage(Msg)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
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

    public void limparCampos(){
        edtPreco = findViewById(R.id.edtPreco);
        edtPreco.setText("");
    }

    protected void cadastrar(View view){
        Intent it = new Intent(this, actConsultaServicos.class);
        if (cadastrarServico()){
            limparCampos();
            startActivity(it);
        }else{
            limparCampos();
        }
    }
}
