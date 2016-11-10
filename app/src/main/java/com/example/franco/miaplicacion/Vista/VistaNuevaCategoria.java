package com.example.franco.miaplicacion.Vista;


import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.app.Activity;
import android.widget.EditText;

import com.example.franco.miaplicacion.Activity.CategoriaActivity;
import com.example.franco.miaplicacion.Controlador.ControladorNuevaCategoria;
import com.example.franco.miaplicacion.R;


/**
 * Created by Franco on 24/09/2016.
 */
public class VistaNuevaCategoria {
    private Button btnCrearCategoria;
    private Activity activity;
    private EditText editNombre;
    private EditText editDescripcion;
    public VistaNuevaCategoria(Activity ac, ControladorNuevaCategoria controladorNuevaCategoria){
        activity = ac;

        if (activity.getClass().getName().equals("com.example.franco.miaplicacion.Activity.NuevaCategoriaActivity")) {
            this.btnCrearCategoria=(Button) activity.findViewById(R.id.btnCrearCategoria);
            this.btnCrearCategoria.setOnClickListener(controladorNuevaCategoria);
            this.editNombre = (EditText) activity.findViewById(R.id.editCatNombre);
            this.editDescripcion = (EditText) activity.findViewById(R.id.editCatDescripcion);

        }
    }

    public void crearCategoria(){
        Intent i = new Intent(activity,CategoriaActivity.class);
        activity.startActivity(i);
    }

    public boolean validaVacio(){
        if (editNombre.getText().toString().equals("") || editDescripcion.getText().toString().equals("")){
            return false;
        }else
            return true;
    }


    public Uri.Builder cargarParametros(){
        Uri.Builder params = new Uri.Builder();
        params.appendQueryParameter("titulo",editNombre.getText().toString());
        params.appendQueryParameter("descripcion",editDescripcion.getText().toString());
        return  params;
    }

}

