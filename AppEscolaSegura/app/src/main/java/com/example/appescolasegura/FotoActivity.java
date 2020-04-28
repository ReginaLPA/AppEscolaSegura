package com.example.appescolasegura;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class FotoActivity extends AppCompatActivity {
    ImageView imagemViewFoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);
        setTitle("Tela Foto");

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA}, 0);
        }

        imagemViewFoto = (ImageView) findViewById(R.id.imageViewFoto);
        findViewById(R.id.btnFoto).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tirarFoto();
            }
        });
    }
    public void tirarFoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);
    }
}
