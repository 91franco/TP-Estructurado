package com.example.franco.miaplicacion.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.franco.miaplicacion.Controlador.ControladorInicio;
import com.example.franco.miaplicacion.Modelo.MiDialogo;
import com.example.franco.miaplicacion.R;
import com.example.franco.miaplicacion.Vista.VistaInicio;

public class InicioActivity extends AppCompatActivity {
    public static String apiKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        ControladorInicio controlador = new ControladorInicio();
        VistaInicio vista = new VistaInicio(this,controlador);

        controlador.setVista(vista);


    }

    static MiDialogo ingreseUsuario(){

         MiDialogo dialogo = new MiDialogo();
        dialogo.setTitulo("probando");
        dialogo.setMensaje("probando");
        return dialogo;
    }

    public void  ingreseUsuario (MiDialogo dialogo){
        dialogo.show(getSupportFragmentManager(),"dialogo");
    }

}
