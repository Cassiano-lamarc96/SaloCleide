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
import android.widget.Toolbar;

public class actRegisterService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_register_service);
    }

    private boolean cadastrarServico(){
        //Por enquanto retorna true, mas servirá para cadastrar o serviço.
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
