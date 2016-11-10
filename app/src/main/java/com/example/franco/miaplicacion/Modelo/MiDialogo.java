package com.example.franco.miaplicacion.Modelo;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.example.franco.miaplicacion.Controlador.ControladorDialogo;

/**
 * Created by Franco on 28/09/2016.
 */
public class MiDialogo extends DialogFragment {
    private String titulo;
    private String mensaje;

    public void setTitulo (String titulo){
        this.titulo=titulo;
    }

    public void setMensaje (String mensaje){
        this.mensaje=mensaje;
    }

    @Override
    public Dialog onCreateDialog(Bundle bundle){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(titulo);
        builder.setMessage(mensaje);
        ControladorDialogo a = new ControladorDialogo();
        builder.setPositiveButton("Aceptar", a);
        AlertDialog ad = builder.create();

        return ad;
    }

}
