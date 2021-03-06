package com.example.franco.miaplicacion.Vista;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.franco.miaplicacion.Activity.CategoriaActivity;
import com.example.franco.miaplicacion.Activity.DetalleCatActivity;
import com.example.franco.miaplicacion.Activity.InicioActivity;
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
    private CheckBox checkBox;
    private String vacio = "CamposVacios";

    public VistaInicio(Activity ac, ControladorInicio controlador){
        activity=ac;
        if(activity.getClass().getName().equals("com.example.franco.miaplicacion.Activity.InicioActivity")){
            this.btnIngresar=(Button) ac.findViewById(R.id.btnIngresar);
            this.btnRegistrarse=(Button) ac.findViewById(R.id.btnRegistrarse);
            this.btnIngresar.setOnClickListener(controlador);
            this.btnRegistrarse.setOnClickListener(controlador);

            this.checkBox = (CheckBox) ac.findViewById(R.id.chkRecordarme);
            this.checkBox.setOnClickListener(controlador);
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

    public void cargarDetalleCat(int posicion){
        Intent i = new Intent(activity,DetalleCatActivity.class);
        i.putExtra("Posicion",posicion);
        activity.startActivity(i);
    }

    public boolean validaVacio(){
        if (email.getText().toString().equals("") || clave.getText().toString().equals("")){
            InicioActivity activityInicio = (InicioActivity) activity;
            activityInicio.datosIncompletos();
            return false;
        }else
            return true;
    }

    public boolean validadCheck(){
        if(checkBox.isChecked()){
            SharedPreferences prefs = activity.getSharedPreferences("miConfig", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("usuario", email.getText().toString());
            editor.putString("clave",clave.getText().toString());
            editor.commit();

            return true;
        }
        return false;
    }

    public void borrarShared(){
            SharedPreferences prefs = activity.getSharedPreferences("miConfig", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("usuario", "sin usuario");
            editor.putString("clave", "sin clave");
            editor.commit();
    }

    public Uri.Builder cargarParametros(){
        Uri.Builder params = new Uri.Builder();
        //if( !InicioActivity.usuario.equals("sin usuario") && !InicioActivity.clave.equals("sin clave")) {
          //  params.appendQueryParameter("email", InicioActivity.usuario);
           // params.appendQueryParameter("password",InicioActivity.clave);
        //}else{
            params.appendQueryParameter("email", email.getText().toString());
            params.appendQueryParameter("password", clave.getText().toString());
        //}
        Log.d("parametros:",params.toString());
        return  params;

    }

    public void datosIncorrectos(String mensaje){
        InicioActivity activityInicio = (InicioActivity) activity;
        activityInicio.datosIncorrectos(mensaje);
    }

}
