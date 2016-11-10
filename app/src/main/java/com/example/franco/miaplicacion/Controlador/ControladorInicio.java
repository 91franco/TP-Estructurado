package com.example.franco.miaplicacion.Controlador;

import android.os.Message;
import android.util.Log;
import android.view.View;
import android.os.Handler;


import com.example.franco.miaplicacion.Modelo.Categoria;
import com.example.franco.miaplicacion.Activity.CategoriaActivity;
import com.example.franco.miaplicacion.Modelo.MiHilo;
import com.example.franco.miaplicacion.R;
import com.example.franco.miaplicacion.Vista.VistaInicio;

import java.util.List;


/**
 * Created by Franco on 29/09/2016.
 */
public class ControladorInicio implements View.OnClickListener,Handler.Callback {
    public static final int LOGIN = 1;
    private VistaInicio vista;


    public ControladorInicio(){

    }

    public void setVista(VistaInicio v){
        this.vista=v;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnIngresar) {

            if(vista.validaVacio()) {
                Handler.Callback callback = this;
                Handler handler = new Handler(callback);
                MiHilo hilo = new MiHilo(handler,LOGIN,vista.cargarParametros());
                hilo.start();
            }else{
                Log.d("Pendiente:","Se lanzara un dialogo indicando que debe ingresar email/clave");
            }
        }

        if (v.getId()==R.id.btnRegistrarse){
            vista.iniciarRegistro();
        }
    }

    @Override
    public boolean handleMessage(Message msg) {
        if(msg.arg1==LOGIN) {
            CategoriaActivity.categorias = (List<Categoria>) msg.obj;
            vista.cargarCategorias();
        }
        return false;
    }
}