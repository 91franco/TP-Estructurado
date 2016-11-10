package com.example.franco.miaplicacion.Vista;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.EditText;

import com.example.franco.miaplicacion.Controlador.ControladorRegistrarse;
import com.example.franco.miaplicacion.Activity.InicioActivity;
import com.example.franco.miaplicacion.R;

/**
 * Created by Franco on 29/09/2016.
 */
public class VistaRegistrarse {
    private Activity activity;
    private Button btnReRegistrarse;
    private EditText editNombre;
    private EditText editApellido;
    private EditText editUsuario;
    private EditText editContraseña;
    private EditText editReContraseña;
    private EditText editEmail;


    public VistaRegistrarse(Activity ac, ControladorRegistrarse controlador) {
        activity = ac;

        if (activity.getClass().getName().equals("com.example.franco.miaplicacion.Activity.RegistrarseActivity")) {
            this.btnReRegistrarse = (Button) activity.findViewById(R.id.btnReRegistrarse);
            this.btnReRegistrarse.setOnClickListener(controlador);
            this.editNombre = (EditText) activity.findViewById(R.id.editRNombre);
            this.editApellido = (EditText) activity.findViewById(R.id.editRApellido);
            this.editUsuario = (EditText) activity.findViewById(R.id.editRUsuarioEmail);
            this.editEmail = (EditText) activity.findViewById(R.id.editREmail);
            this.editContraseña = (EditText) activity.findViewById(R.id.editRClave);
            this.editReContraseña = (EditText) activity.findViewById(R.id.editRReinClave);
        }
    }

    public void iniciarLogin(){
        Intent i = new Intent(activity,InicioActivity.class);
        activity.startActivity(i);
    }

    public boolean validaVacio(){
        if (editNombre.getText().toString().equals("") || editApellido.getText().toString().equals("") ||
                editUsuario.getText().toString().equals("") || editContraseña.getText().toString().equals("") ||
                editReContraseña.getText().toString().equals("") || editEmail.getText().toString().equals("")){
            return false;
        }else
            return true;
    }

    public boolean validaContraseñas(){
        if(editContraseña.getText().toString().equals(editReContraseña.getText().toString())){
            return true;
        }else {
            return false;
        }
    }

    public Uri.Builder cargarParametros(){
        Uri.Builder params = new Uri.Builder();
        params.appendQueryParameter("nombre",editNombre.getText().toString());
        params.appendQueryParameter("apellido",editApellido.getText().toString());
        params.appendQueryParameter("usuario",editUsuario.getText().toString());
        params.appendQueryParameter("email",editEmail.getText().toString());
        params.appendQueryParameter("password",editApellido.getText().toString());
        return  params;
    }

}
