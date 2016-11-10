package com.example.franco.miaplicacion.Modelo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.franco.miaplicacion.R;

import java.util.List;

/**
 * Created by Franco on 25/09/2016.
 */
public class MiAdapter extends RecyclerView.Adapter<MiViewHolder> {
    private List<Categoria> categorias;

    public MiAdapter(List<Categoria> categorias){
        this.categorias=categorias;
    }

    @Override
    public MiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        MiViewHolder miViewHolder = new MiViewHolder(v);
        return miViewHolder;
    }
    @Override
    public void onBindViewHolder(MiViewHolder holder, int position) {
        Categoria categoria = categorias.get(position);
        holder.txtNombre.setText(categoria.getNombre());
        holder.txtDescripcion.setText(categoria.getDescripcion());
        //holder.imgVwImagen.setI(categoria.getImagen());
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }
}
