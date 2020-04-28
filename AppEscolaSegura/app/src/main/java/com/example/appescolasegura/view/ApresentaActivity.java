package com.example.appescolasegura.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.appescolasegura.R;
import com.example.appescolasegura.controller.MainActivityDrawer;

public class ApresentaActivity extends AppCompatActivity {
    View myview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apresenta);

        setTitle("Tela Sobre");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main2_activity_drawer, menu);

        //return super.onCreateOptionsMenu(menu);
        return  true;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.activity_apresenta, container, false);
        return myview;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id==R.id.Inicio){
            startActivity(new Intent(this, MainActivityDrawer.class));
            //Toast.makeText(this,"Menu inicio clicado",Toast.LENGTH_SHORT).show();
            return true;
        }

        else if (id == R.id.Ocorrencia) {
            if (id == R.id.Relata_Ocorrencia) {
                //startActivity(new Intent(getBaseContext(), OcorrenciaActivity.class));
                startActivity(new Intent(this,OcorrenciaActivity.class));
                return true;
            }
            else if (id == R.id.Emergencia_Medica) {
                //startActivity(new Intent(getBaseContext(), ThreadMedico.class));
                startActivity(new Intent(this,ThreadMedico.class));
                return true;
            }
            else if (id == R.id.Emergencia_Policial) {
                startActivity(new Intent(getBaseContext(), ThreadPolicia.class));
                startActivity(new Intent(this,ThreadPolicia.class));
                return true;
            }
        }
        else  if (id == R.id.Sobre) {
            // startActivity(new Intent(getBaseContext(), SobreActivity.class));
            // startActivity(new Intent(this,SobreActivity.class));
            return true;
        }
        else if (id == R.id.Sair) {
            System.exit(0);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

}
