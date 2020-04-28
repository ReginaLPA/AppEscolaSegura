package com.example.appescolasegura.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.appescolasegura.R;
import com.example.appescolasegura.view.OcorrenciaActivity;
import com.example.appescolasegura.view.ThreadMedico;
import com.example.appescolasegura.view.ThreadPolicia;


public class AlunoInicioActivity extends AppCompatActivity {

    MediaPlayer mp, mp1;
    Vibrator vibrator;
    RadioButton radioButton;
    RadioGroup radioGroup;
    RadioButton ocorrencia;
    RadioButton ocMedica;
    RadioButton ocPolicial;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_inicio);

        setTitle(" Tela Aluno Inicio");
        mp = MediaPlayer.create(this, R.raw.sirene);
        mp1 = MediaPlayer.create(this, R.raw.sirenepolicia);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // associa o radiobutton
        ocorrencia = (RadioButton) findViewById(R.id.radioButtonOcorrencia);
        ocMedica = (RadioButton) findViewById(R.id.radioButtonEMedica);
        ocPolicial = (RadioButton) findViewById(R.id.radioButtonEPolicial);
        radioGroup = (RadioGroup) findViewById(R.id.RadioGroupAluno);


        Button btn = (Button) findViewById(R.id.btnSairAluno);

        btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AlunoInicioActivity.this, LoginActivity.class);
                startActivity(intent);
            }

        });
    }
    public void checkButton(View view){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        if(ocorrencia.isChecked() == true) {
            Intent intent = new Intent(AlunoInicioActivity.this, OcorrenciaActivity.class);//parametro a tela  que esta e a tela a ser chamada
           // intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            //msg = nome.getText().toString();
            //intent.putExtra("parametro", msg);
            //startActivityForResult(intent,CONSTANTE_TELA1);
            startActivity(intent);
        }
         if(ocMedica.isChecked() == true){
             Intent intent1 = new Intent(AlunoInicioActivity.this, ThreadMedico.class);//parametro a tela  que esta e a tela a ser chamada
             //intent1.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
             //vibrator.vibrate(5000);
             startActivity(intent1);
        }

         if(ocPolicial.isChecked() == true){
             Intent intent2 = new Intent(AlunoInicioActivity.this, ThreadPolicia.class);//parametro a tela  que esta e a tela a ser chamada
             //intent2.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
             startActivity(intent2);
            //mp.stop();
           // mp1.start();
           // vibrator.vibrate(5000);
        }
        //disableAllOptions(radioGroup);
    }

    private void disableAllOptions(RadioGroup group) {
        for (int i = 0; i < group.getChildCount(); i++) {
            group.getChildAt(i).setEnabled(false);
        }
    }




}

