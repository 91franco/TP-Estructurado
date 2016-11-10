package com.example.franco.miaplicacion.Modelo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franco.miaplicacion.Controlador.ControladorNuevaCategoria;
import com.example.franco.miaplicacion.R;

/**
 * Created by Franco on 25/09/2016.
 */


public class MiViewHolder  extends RecyclerView.ViewHolder {
    public TextView txtNombre;
    public TextView txtDescripcion;
    public ImageView imgVwImagen;
    public int index;
    public ControladorNuevaCategoria controladorNuevaCategoria;

    public MiViewHolder(View view){
        super(view);
        this.txtNombre = (TextView) view.findViewById(R.id.txtCatNombre);
        this.txtDescripcion = (TextView) view.findViewById(R.id.txtCatDescripcion);
        this.imgVwImagen = (ImageView) view.findViewById(R.id.imgVwImagen);
    }

}
