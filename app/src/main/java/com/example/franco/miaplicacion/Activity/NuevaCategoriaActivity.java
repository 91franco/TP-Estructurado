package com.example.franco.miaplicacion.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.franco.miaplicacion.Controlador.ControladorNuevaCategoria;
import com.example.franco.miaplicacion.R;
import com.example.franco.miaplicacion.Vista.VistaNuevaCategoria;

public class NuevaCategoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_categoria);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        ControladorNuevaCategoria controladorNuevaCategoria = new ControladorNuevaCategoria();
        VistaNuevaCategoria vistaNuevaCategoria = new VistaNuevaCategoria(this, controladorNuevaCategoria);

        controladorNuevaCategoria.setVistaNuevaCategoria(vistaNuevaCategoria);
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
