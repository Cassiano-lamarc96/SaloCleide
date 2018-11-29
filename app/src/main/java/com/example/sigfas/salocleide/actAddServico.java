package com.example.sigfas.salocleide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class actAddServico extends AppCompatActivity {

    EditText edtNome;
    EditText edtPreco;
    bancoDados bd = new bancoDados(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_add_servico);
    }

    public void cadastraServico(View view){
        edtNome = findViewById(R.id.edtNomeSevico);
        edtPreco = findViewById(R.id.edtPreco);
        mServico serv = new mServico();
        serv.setNome(edtNome.getText().toString());
        serv.setPreco(Double.parseDouble(edtPreco.getText().toString()));
        bd.insereServico(serv);
        limparCampos();
    }

    public void limparCampos(){
        edtNome = findViewById(R.id.edtNomeSevico);
        edtPreco = findViewById(R.id.edtPreco);
        edtNome.setText("");
        edtPreco.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_voltar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.retornar:
                MudarParaAct(actRegisterService.class);
        }
        return true;
    }
    public void MudarParaAct(Class actClass){
        Intent it = new Intent(this, actClass);
        startActivity(it);
    }
}
