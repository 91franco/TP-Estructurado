package com.example.franco.miaplicacion.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.franco.miaplicacion.Modelo.Categoria;
import com.example.franco.miaplicacion.Controlador.ControladorCategoria;
import com.example.franco.miaplicacion.Modelo.MiAdapter;
import com.example.franco.miaplicacion.R;
import com.example.franco.miaplicacion.Vista.VistaCategoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaActivity extends AppCompatActivity {
    public static List<Categoria> categorias = new ArrayList<Categoria>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        RecyclerView list = (RecyclerView) findViewById(R.id.rvCategoria);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager (layoutManager);

        MiAdapter adapter = new MiAdapter(categorias);
        list.setAdapter(adapter);


        ControladorCategoria controlador = new ControladorCategoria();
        VistaCategoria vista = new VistaCategoria(this,controlador);

        controlador.setVista(vista);

    }
}
