package com.example.franco.miaplicacion.Modelo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franco.miaplicacion.Activity.InicioActivity;
import com.example.franco.miaplicacion.Controlador.ControladorInicio;
import com.example.franco.miaplicacion.Controlador.ControladorNuevaCategoria;
import com.example.franco.miaplicacion.R;

/**
 * Created by Franco on 25/09/2016.
 */


public class MiViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtNombre;
    public TextView txtDescripcion;
    public static ImageView imgVwImagen;
    public MiListener miListener;
    public int index;


    public MiViewHolder(View view,MiListener miListener){
        super(view);
        this.txtNombre = (TextView) view.findViewById(R.id.txtCatNombre);
        this.txtDescripcion = (TextView) view.findViewById(R.id.txtCatDescripcion);
        this.imgVwImagen = (ImageView) view.findViewById(R.id.imgVwImagen);
        view.setOnClickListener(this);
        this.miListener=miListener;

    }


    @Override
    public void onClick(View v) {
        miListener.seHizoClick(index);
        InicioActivity.vista.cargarDetalleCat(index);

        Log.d("Se hizo click", "Click en el elemento: "+index );
    }


}
