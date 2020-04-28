package com.example.appescolasegura.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.appescolasegura.R;
import com.example.appescolasegura.controller.MainActivityDrawer;

//https://www.youtube.com/watch?v=ouQGGfmVrQA
//https://www.youtube.com/watch?v=E-U8nY3JWLk
public class OcorrenciaActivity extends AppCompatActivity {
    View myview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocorrencia);
        setTitle(" Tela Ocorrência");

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.activity_ocorrencia, container, false);
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
