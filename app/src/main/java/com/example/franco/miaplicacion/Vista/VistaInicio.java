package com.example.franco.miaplicacion.Vista;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.EditText;

import com.example.franco.miaplicacion.Activity.CategoriaActivity;
import com.example.franco.miaplicacion.Controlador.ControladorInicio;
import com.example.franco.miaplicacion.R;
import com.example.franco.miaplicacion.Activity.RegistrarseActivity;

/**
 * Created by Franco on 28/09/2016.
 */
public class VistaInicio {
    private Button btnIngresar;
    private Button btnRegistrarse;
    private Activity activity;
    private EditText email;
    private EditText clave;
    private String vacio = "CamposVacios";

    public VistaInicio(Activity ac, ControladorInicio controlador){
        activity=ac;
        if(activity.getClass().getName().equals("com.example.franco.miaplicacion.Activity.InicioActivity")){
            this.btnIngresar=(Button) ac.findViewById(R.id.btnIngresar);
            this.btnRegistrarse=(Button) ac.findViewById(R.id.btnRegistrarse);
            this.btnIngresar.setOnClickListener(controlador);
            this.btnRegistrarse.setOnClickListener(controlador);

            this.email=(EditText) ac.findViewById(R.id.ingresoEmail);
            this.clave=(EditText) ac.findViewById(R.id.ingresoClave);

        }
    }

    public void iniciarRegistro(){
        Intent i = new Intent(activity,RegistrarseActivity.class);
        activity.startActivity(i);
    }

    public void cargarCategorias(){
        Intent i = new Intent(activity,CategoriaActivity.class);
        activity.startActivity(i);
    }

    public boolean validaVacio(){
        if (email.getText().toString().equals("") || clave.getText().toString().equals("")){
            return false;
        }else
            return true;
    }

    public Uri.Builder cargarParametros(){
        Uri.Builder params = new Uri.Builder();
        params.appendQueryParameter("email",email.getText().toString());
        params.appendQueryParameter("password",clave.getText().toString());
        return  params;
    }
}
