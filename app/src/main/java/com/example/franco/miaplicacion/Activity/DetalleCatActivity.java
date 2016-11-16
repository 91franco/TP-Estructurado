package com.example.franco.miaplicacion.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.franco.miaplicacion.Controlador.ControladorDetalleCat;
import com.example.franco.miaplicacion.R;
import com.example.franco.miaplicacion.Vista.VistaDetalleCat;

/**
 * Created by Franco on 15/11/2016.
 */
public class DetalleCatActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_cat);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        int intActivity1 = extras.getInt("Posicion");

        ControladorDetalleCat controlador = new ControladorDetalleCat();
        VistaDetalleCat vista = new VistaDetalleCat(this, controlador);
        controlador.setVista(vista);
        vista.cargarDetalle(intActivity1);
    }
}
