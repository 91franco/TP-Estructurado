package com.example.franco.miaplicacion.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.franco.miaplicacion.Controlador.ControladorRegistrarse;
import com.example.franco.miaplicacion.R;
import com.example.franco.miaplicacion.Vista.VistaRegistrarse;

public class RegistrarseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        ControladorRegistrarse controlador = new ControladorRegistrarse();
        VistaRegistrarse vista = new VistaRegistrarse(this,controlador);

        controlador.setVista(vista);
    }
}
