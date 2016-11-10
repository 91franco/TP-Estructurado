package com.example.franco.miaplicacion.Controlador;

import android.util.Log;
import android.view.View;

import com.example.franco.miaplicacion.R;
import com.example.franco.miaplicacion.Vista.VistaCategoria;

/**
 * Created by Franco on 29/09/2016.
 */
public class ControladorCategoria implements View.OnClickListener {
    private VistaCategoria vista;

    public ControladorCategoria(){

    }

    public void setVista(VistaCategoria v){
        this.vista=v;
    }

    @Override
    public void onClick(View v){

        if(v.getId()== R.id.btnAgregar){
            Log.d("Se hizo clic","clic");
            vista.crearCategoria();
        }

    }

}