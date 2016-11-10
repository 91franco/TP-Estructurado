package com.example.franco.miaplicacion.Controlador;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.example.franco.miaplicacion.Modelo.MiHilo;
import com.example.franco.miaplicacion.R;
import com.example.franco.miaplicacion.Vista.VistaRegistrarse;

/**
 * Created by Franco on 29/09/2016.
 */
public class ControladorRegistrarse implements View.OnClickListener,Handler.Callback {
    public static final int REGISTRARSE = 2;
    public static final int REGISTRARSE_OK = 1;
    public static final int REGISTRARSE_NOK = 1;
    private VistaRegistrarse vista;

    public ControladorRegistrarse(){

    }

    public void setVista(VistaRegistrarse v){
        this.vista=v;
    }

    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.btnReRegistrarse) {
            if(vista.validaVacio() && vista.validaContraseñas()) {
                Handler.Callback callback = this;
                Handler handler = new Handler(callback);
                MiHilo hilo = new MiHilo(handler,REGISTRARSE,vista.cargarParametros());
                hilo.start();
            }else {
                Log.d("Pendiente:","Se lanzara un dialogo indicando que debe ingresar datos de registro");
            }
        }
    }

    @Override
    public boolean handleMessage(Message msg) {
        if(msg.arg1==REGISTRARSE_OK) {
            Log.d("Futurodialogo:",msg.obj.toString());
            vista.iniciarLogin();
        }
        if(msg.arg1==REGISTRARSE_NOK) {
            Log.d("Futurodialogo:",msg.obj.toString());
            vista.iniciarLogin();
        }
        return false;
    }
}
