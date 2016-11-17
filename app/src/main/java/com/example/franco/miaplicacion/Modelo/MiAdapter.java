package com.example.franco.miaplicacion.Modelo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.franco.miaplicacion.Activity.CategoriaActivity;
import com.example.franco.miaplicacion.Activity.InicioActivity;
import com.example.franco.miaplicacion.Controlador.ControladorInicio;
import com.example.franco.miaplicacion.R;

import java.util.List;

/**
 * Created by Franco on 25/09/2016.
 */
public class MiAdapter extends RecyclerView.Adapter<MiViewHolder> implements Handler.Callback {
    private List<Categoria> categorias;
    private MiListener miListener;


    public MiAdapter(List<Categoria> categorias,MiListener miListener ){
        this.categorias=categorias;
        this.miListener=miListener;
    }

    @Override
    public MiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        MiViewHolder miViewHolder = new MiViewHolder(v,miListener);
        return miViewHolder;
    }
    @Override
    public void onBindViewHolder(MiViewHolder holder, int position) {
        holder.index=position;
        holder.txtNombre.setText(categorias.get(position).getNombre());
        holder.txtDescripcion.setText(categorias.get(position).getDescripcion());

        if(categorias.get(position).getBitmap()!=null){
            holder.imgVwImagen.setImageBitmap(categorias.get(position).getBitmap());
        }else{
            // hacer con pull de thread
            recuperarImagen(position);
        }



    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    @Override
    public boolean handleMessage(Message msg) {
          if(msg.arg1==ControladorInicio.CARGARIMAGEN){
            byte [] img = (byte[]) msg.obj;
            Bitmap bitmap = BitmapFactory.decodeByteArray(img,0,img.length);
            categorias.get(msg.arg2).setBitmap(bitmap);
            //MiViewHolder.imgVwImagen.setImageBitmap(bitmap);
              InicioActivity.vista.cargarCategorias();
        }

        return false;
    }


    public void recuperarImagen(int position){
        Handler.Callback callback = this;
        Handler handler = new Handler(callback);
        MiHilo hilo = new MiHilo(handler, ControladorInicio.CARGARIMAGEN,null,categorias.get(position).getImagen(),position);
        hilo.start();
    }



}
