package com.example.appescolasegura.controller;

import android.content.Intent;
import android.os.Bundle;

import com.example.appescolasegura.FotoActivity;
import com.example.appescolasegura.R;
import com.example.appescolasegura.view.ApresentaActivity;
import com.example.appescolasegura.view.OcorrenciaActivity;
import com.example.appescolasegura.view.ThreadMedico;
import com.example.appescolasegura.view.ThreadPolicia;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

//https://developer.android.com/guide/components/fragments?hl=pt-br#java **exemplos
//https://www.youtube.com/watch?v=oh4YOj9VkVE **submenu
//https:www.youtube.com/watch?v=TY-2Cx4IW9A **drawer
public class MainActivityDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);

        setTitle(" Tela Inicio");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
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
            startActivity(new Intent(getBaseContext(), MainActivityDrawer.class));
            return true;
    }
        else if (id == R.id.Ocorrencia) {
            if (id == R.id.Relata_Ocorrencia) {
                //Intent intent = new Intent(MainActivityDrawer.this,OcorrenciaActivity.class);
                //startActivity(intent);
                startActivity(new Intent(getBaseContext(), OcorrenciaActivity.class));
                return true;
            }
           else if (id == R.id.Emergencia_Medica) {
                //startActivity(new Intent(getBaseContext(), ThreadMedico.class));
               //Intent intent1 = new Intent(MainActivityDrawer.this,ThreadMedico.class);
              // startActivity(intent1);

                startActivity(new Intent(MainActivityDrawer.this,ThreadMedico.class));
                //return true;
            }
            else if (id == R.id.Emergencia_Policial) {
                //Intent intent2 = new Intent(MainActivityDrawer.this,ThreadPolicia.class);
                //startActivity(intent2);
                startActivity(new Intent(getBaseContext(), ThreadPolicia.class));
               // return true;
            }
        }
       else  if (id == R.id.Sobre) {
            //startActivity(new Intent(getBaseContext(), ApresentaActivity.class));
            //Intent intent3 = new Intent(MainActivityDrawer.this,ApresentaActivity.class);
            //startActivity(intent3);
            startActivity(new Intent(getBaseContext(), ApresentaActivity.class));

            //return true;
        }
        else if (id == R.id.Sair) {
            //System.exit(0);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            startActivity(new Intent(getBaseContext(), LoginActivity.class));
        } else if (id == R.id.nav_foto) {
                        startActivity(new Intent(getBaseContext(), FotoActivity.class));
        } else if (id == R.id.nav_sair) {
            //startActivity(new Intent(this, SobreActivity.class));
            finish();

        } else if (id == R.id.nav_sobre) {
            startActivity(new Intent(getBaseContext(), ApresentaActivity.class));
       } /*else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
