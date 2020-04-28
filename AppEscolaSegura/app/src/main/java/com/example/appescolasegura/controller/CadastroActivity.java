package com.example.appescolasegura.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appescolasegura.R;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        setTitle(" Tela Cadastro");
        Button cancela = (Button) findViewById(R.id.btnCancelar);

        cancela.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(intent);
            }

        });
    }
}
