package com.example.appescolasegura.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.example.appescolasegura.R;
import com.example.appescolasegura.controller.LoginActivity;
import com.example.appescolasegura.controller.MainActivityDrawer;

public class SplashActivity extends AppCompatActivity {
    private Handler handler;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setTitle(" Tela Splash");

        progress = (ProgressBar) findViewById(R.id.progressBarSplash);
        //startButton = (Button) findViewById(R.id.start_button);
        //instancia um novo Handler para executar a thread
        handler = new Handler();
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getBaseContext(), MainActivityDrawer.class));
                finish();
            }

        }, 10000);
        executaThread(progress);
    }

    public void executaThread(View view) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    final int value = i;
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
    }



}
