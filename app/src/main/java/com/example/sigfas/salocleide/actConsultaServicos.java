package com.example.sigfas.salocleide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class actConsultaServicos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_consulta_servicos);
    }

    protected void refresh(View view){
        this.finish();
        Intent itRefresh = new Intent(this, actConsultaServicos.class);
        startActivity(itRefresh);
    }
}
