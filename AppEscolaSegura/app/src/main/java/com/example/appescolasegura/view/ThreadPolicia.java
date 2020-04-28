package com.example.appescolasegura.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.appescolasegura.R;
import com.example.appescolasegura.controller.MainActivityDrawer;

public class ThreadPolicia extends AppCompatActivity {
    private Handler handler;
    private ProgressBar progress;
    MediaPlayer  mp1;
    Vibrator vibrator;
    AlertDialog.Builder builder;
    private volatile boolean pause = false;
    View myview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_policia);

        setTitle(" Tela Ocorrência Policial");

        progress = (ProgressBar) findViewById(R.id.progressBarPolicia);
        //startButton = (Button) findViewById(R.id.start_button);
        //instancia um novo Handler para executar a thread
        handler = new Handler();
        mp1 = MediaPlayer.create(this, R.raw.sirenepolicia);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        Intent intent = getIntent();

        builder = new AlertDialog.Builder(this);

    }
    public void executaThread(View view){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    final int value = i;
                    if(pause){
                        return;                    }
                    try {
                        //define 1/10 segundo como o tempo para a barra
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //define o valor para a barra
                            progress.setProgress(value);
                        }
                    });
                }
            }
        };
        //executa a thread
        new Thread(runnable).start();
        pause = false;
        builder.setTitle("Confirme");
        builder.setMessage("Você Chamou a Policia?");
        mp1.start();
        vibrator.vibrate(5000);
        alerta2(view);
    }
    public void pause(View view ){
       pause = true;
        mp1.pause();
        vibrator.cancel();
        TextView txt = (TextView) findViewById(R.id.edtTxtCaixaTextoPolicia);
        txt.setText("Policia Chegou");
    }
    public void alerta2(View view) {
        builder.setIcon(android.R.drawable.ic_dialog_info);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                TextView txt = (TextView) findViewById(R.id.edtTxtCaixaTextoPolicia);
                txt.setText("Policia Chegando...");

            }
        });
        builder.show();
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.activity_thread_policia, container, false);
        return myview;
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
