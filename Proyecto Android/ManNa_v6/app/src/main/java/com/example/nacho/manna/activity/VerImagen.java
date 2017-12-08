package com.example.nacho.manna.activity;

import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

import com.example.nacho.manna.R;
import com.example.nacho.manna.auxiliar.Utilidades;
import com.example.nacho.manna.proveedorDeContenido.Contrato;

import uk.co.senab.photoview.PhotoViewAttacher;

public class VerImagen extends AppCompatActivity {
    long ordenId;
    ImageView imageView;
    PhotoViewAttacher  mAttacher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_imagen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //ActionBar----------------------------
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setTitle(getResources().getText(R.string.app_name));
       // actionBar.setSubtitle(getResources().getText(R.string.subtitulo_autor));
        //----------------------------

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivityDrawer.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );
                startActivity(intent);
                finish();

            }
        });
    //-------------------

        ordenId = this.getIntent().getExtras().getLong(Contrato.Orden._ID);
        imageView = findViewById(R.id.imageViewOrden);
        Utilidades.loadDesdeServidor(getApplicationContext(),imageView,ordenId);
        mAttacher = new PhotoViewAttacher(imageView);

    }
    //----------------------------------------------------------------------------------------------


}