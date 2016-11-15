package com.example.franco.miaplicacion.Activity;

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

        ControladorDetalleCat controlador = new ControladorDetalleCat();
        VistaDetalleCat vista = new VistaDetalleCat(this, controlador);
        controlador.setVista(vista);
    }
}
