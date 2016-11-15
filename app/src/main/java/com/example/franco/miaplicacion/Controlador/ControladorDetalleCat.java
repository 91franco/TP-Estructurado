package com.example.franco.miaplicacion.Controlador;

import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.example.franco.miaplicacion.Vista.VistaDetalleCat;

/**
 * Created by Franco on 15/11/2016.
 */
public class ControladorDetalleCat implements View.OnClickListener,Handler.Callback {
    private VistaDetalleCat vista;

    public void setVista(VistaDetalleCat v){
        this.vista=v;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean handleMessage(Message msg) {
        return false;
    }
}
