package com.example.sigfas.salocleide;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
