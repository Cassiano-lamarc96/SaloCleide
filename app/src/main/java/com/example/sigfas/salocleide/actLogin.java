package com.example.sigfas.salocleide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class actLogin extends AppCompatActivity {

    EditText edtCodUSer, edtPswUser;
    Button btnAcessar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_login);
    }

    protected void Acessar(View view){
        usuario user = new usuario();
        edtCodUSer = findViewById(R.id.edtCodUser);
        edtPswUser = findViewById(R.id.edtPswUser);
        user.setCodUser(Integer.parseInt(edtCodUSer.getText().toString()));
        user.setPswUser(edtPswUser.getText().toString());
        if (user.getCodUser() == 9615 && user.getPswUser().equals("cacalindo")){
            // Muda para a página de cadastro dos serviços.
        }
    }
}
