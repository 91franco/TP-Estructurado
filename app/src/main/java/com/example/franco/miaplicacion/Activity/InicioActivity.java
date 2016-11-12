package com.example.franco.miaplicacion.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.franco.miaplicacion.Controlador.ControladorInicio;
import com.example.franco.miaplicacion.Modelo.Categoria;
import com.example.franco.miaplicacion.Modelo.MiDialogo;
import com.example.franco.miaplicacion.Modelo.MiHilo;
import com.example.franco.miaplicacion.R;
import com.example.franco.miaplicacion.Vista.VistaInicio;

import java.util.List;

public class InicioActivity extends AppCompatActivity {
    public static String apiKey;
    public static String usuario;
    public static String clave;
    public static String mensaje = "sin mensaje";
    public static VistaInicio vista;
    private MiDialogo dialogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        SharedPreferences prefs = getSharedPreferences("miConfig", Context.MODE_PRIVATE);
        usuario= prefs.getString("usuario","sin usuario");
        clave=prefs.getString("clave","sin clave");

        ControladorInicio controlador = new ControladorInicio();
        vista = new VistaInicio(this,controlador);

        controlador.setVista(vista);

        if( !usuario.equals("sin usuario")  && !clave.equals("sin clave")){
            controlador.login();
        }


    }

    public void datosIncompletos(){
        dialogo  = new MiDialogo();
        dialogo.setTitulo("Alerta");
        dialogo.setMensaje("Debe ingresar Email/Clave");
        dialogo.show(getSupportFragmentManager(),"dialogo");
    }

    public void datosIncorrectos(){
        dialogo  = new MiDialogo();
        dialogo.setTitulo("Alerta");
        dialogo.setMensaje(mensaje);
        dialogo.show(getSupportFragmentManager(),"dialogo");
    }


}
