package com.example.franco.miaplicacion.Vista;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.widget.Button;

import com.example.franco.miaplicacion.Activity.DetalleCatActivity;
import com.example.franco.miaplicacion.Controlador.ControladorCategoria;
import com.example.franco.miaplicacion.Activity.NuevaCategoriaActivity;
import com.example.franco.miaplicacion.R;

/**
 * Created by Franco on 29/09/2016.
 */
public class VistaCategoria {
    private Activity activity;
    private FloatingActionButton btnAgregar;

    public VistaCategoria(Activity ac, ControladorCategoria controlador) {
        activity = ac;


        if (activity.getClass().getName().equals("com.example.franco.miaplicacion.Activity.CategoriaActivity")) {
            this.btnAgregar = (FloatingActionButton) activity.findViewById(R.id.btnAgregar);
            this.btnAgregar.setOnClickListener(controlador);

        }
    }

    public void crearCategoria(){
        Intent i = new Intent(activity,NuevaCategoriaActivity.class);
        activity.startActivity(i);
    }


}
