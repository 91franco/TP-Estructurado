package com.example.franco.miaplicacion.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mimenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cerrar_sesion:
                InicioActivity.vista.borrarShared();
                Intent i = new Intent(this,InicioActivity.class);
                this.startActivity(i);
                return true;
            case R.id.action_categorias:
                Intent e = new Intent(this,CategoriaActivity.class);
                this.startActivity(e);
                return true;
            case R.id.action_favoritos:
                //diseñar pagina
                return true;
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
