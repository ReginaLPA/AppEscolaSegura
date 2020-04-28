package com.example.appescolasegura.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appescolasegura.R;

//https://respostas.guj.com.br/18631-login--e-senha-android-
//https://www.youtube.com/watch?v=aI5FCr85fOc
//https://douglasalipio.wordpress.com/2011/06/29/aplicando-mvccamadas-em-um-projeto-android-%E2%80%93-parte-1/ --mvc
public class LoginActivity extends AppCompatActivity {

    private TextView ra;
    private TextView senha;
    private Button b ,c,e;
    private TextView Info;

    String raIdent;
    String SenhaIndent;
    private int counter = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle(" Tela login");

        ra = (EditText) findViewById(R.id.editTextRA);
        senha = (EditText) findViewById(R.id.editTextSenha);
         b = (Button) findViewById(R.id.btnCadastrar);
         c = (Button) findViewById(R.id.btnSair);
         e = (Button) findViewById(R.id.btnEntrar);
        Info = (TextView)findViewById(R.id.tvinfo);

        Info.setText("Tentativas restantes: 5");

        b.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }

   });
        c.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivityDrawer.class);
                startActivity(intent);
               //System.exit(0);
            }

        });
       // raIdent = ra.getText().toString();
       // SenhaIndent = senha.getText().toString();
        //Toast.makeText(LoginActivity.this, raIdent, Toast.LENGTH_SHORT).show();

        e.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                if (ra.getText().toString().equals("")
                        && senha.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "Insira o Ra e Senha", Toast.LENGTH_SHORT).show();

                }
                else{
                       // Intent intent = new Intent(LoginActivity.this, AlunoInicioActivity.class);startActivity(intent);
                       validate(ra.getText().toString(),senha.getText().toString());
                        //Toast.makeText(getApplicationContext(), raIdent, Toast.LENGTH_SHORT).show();
                        //Toast.makeText(LoginActivity.this, raIdent, Toast.LENGTH_SHORT).show();
                    }
                ra.setText("");
                senha.setText("");
                }

        });



}
    private void validate(String userName, String userPassword){
        if((userName.equals("Admin")) && (userPassword.equals("123"))){
            Intent intent = new Intent(LoginActivity.this,AlunoInicioActivity.class);
            startActivity(intent);
        }else{
            counter --;

            Info.setText("Tentativas restantes: " + String.valueOf(counter));

            if (counter == 0) {
                b.setEnabled(false);

            }
        }
    }
}
