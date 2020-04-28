package com.example.appescolasegura.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.example.appescolasegura.R;
import com.example.appescolasegura.controller.MainActivityDrawer;
//https://www.youtube.com/watch?v=92a0NQZEqFY

public class ThreadMedico extends AppCompatActivity {

    Chronometer chronometer;
    Button btnStart, btnPause, btnReset;
    long time = 0;
    boolean isPause = false;

    MediaPlayer mp;
    Vibrator vibrator;
    AlertDialog.Builder builder;
    View myview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_medico);

        setTitle(" Tela Ocorrência Médica");

        mp = MediaPlayer.create(this, R.raw.sirene);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        Intent intent = getIntent();
        // setando os botões
        btnStart = (Button) findViewById(R.id.btnIniciar);
        btnPause = (Button) findViewById(R.id.btnPausar);
        btnReset = (Button) findViewById(R.id.btnReiniciar);
        chronometer = (Chronometer) findViewById(R.id.chnCronometro);
        btnPause.setEnabled(false);
        btnReset.setEnabled(false);

        builder = new AlertDialog.Builder(this);



    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.activity_thread_medico, container, false);
        return myview;
    }


    public void start(View view) {
        if (isPause == false) {
            chronometer.setBase(SystemClock.elapsedRealtime());
        } else {
            chronometer.setBase(SystemClock.elapsedRealtime() + time);
            btnStart.setText("Iniciar");
            isPause = false;
        }
        chronometer.start();
        btnPause.setEnabled(true);
        btnReset.setEnabled(true);
        builder.setTitle("Confirme");
        builder.setMessage("Você Chamou a Ambulância?");
        mp.start();
        vibrator.vibrate(5000);
        alerta1(view);


    }

    public void pause(View view) {
        time = chronometer.getBase() - SystemClock.elapsedRealtime();
        chronometer.stop();
        btnPause.setEnabled(false);
        btnStart.setText("Continuar");
        isPause = true;
        TextView txt = (TextView) findViewById(R.id.edtTxtCaixaTexto);
        txt.setText("Ambulância Chegou.");
        mp.pause();

    }

    public void reset(View view) {
        chronometer.stop();
        chronometer.setText("00:00");
        if (isPause) {
            btnStart.setText("Iniciar");
            isPause = false;
        }
        btnPause.setEnabled(false);
        btnReset.setEnabled(false);
        mp.start();
        TextView txt = (TextView) findViewById(R.id.edtTxtCaixaTexto);
        txt.setText("Ambulância Chegando...");
    }
    public void alerta1(View view) {
        builder.setIcon(android.R.drawable.ic_dialog_info);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                TextView txt = (TextView) findViewById(R.id.edtTxtCaixaTexto);
                txt.setText("Ambulância Chegando...");

            }
        });
        builder.show();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2_activity_drawer, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Inicio) {
            startActivity(new Intent(this, MainActivityDrawer.class));
            return true;
        }
        if (id == R.id.Ocorrencia) {
            if (id == R.id.Relata_Ocorrencia) {
                startActivity(new Intent(this, OcorrenciaActivity.class));
                return true;
            }
            if (id == R.id.Emergencia_Medica) {
                startActivity(new Intent(this, ThreadMedico.class));
                return true;
            }
            if (id == R.id.Emergencia_Policial) {
                startActivity(new Intent(this, ThreadPolicia.class));
                return true;
            }
        }
        if (id == R.id.Sobre) {
            startActivity(new Intent(this, ApresentaActivity.class));
            return true;
        }
        if (id == R.id.Sair) {
            System.exit(0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
