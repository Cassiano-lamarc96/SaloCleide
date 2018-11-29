package com.example.sigfas.salocleide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class actAddCliente extends AppCompatActivity {

    EditText edtNome;
    EditText edtTelefone;
    bancoDados db = new bancoDados(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_add_cliente);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_voltar, menu);
        return true;
    }

    public void CadastrarCliente(View view){
        edtNome = findViewById(R.id.edtAddCliente);
        edtTelefone = findViewById(R.id.edtTelefoneCliente);
        mCliente clie = new mCliente();
        clie.setNome(edtNome.getText().toString());
        clie.setTelefone(Integer.parseInt(edtTelefone.getText().toString()));
        db.insereCliente(clie);
        limparCampos();
    }

    public void limparCampos(){
        edtNome = findViewById(R.id.edtNomeSevico);
        edtTelefone = findViewById(R.id.edtPreco);
        edtNome.setText("");
        edtTelefone.setText("");
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
