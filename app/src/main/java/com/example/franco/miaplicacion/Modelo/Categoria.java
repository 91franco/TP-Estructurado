package com.example.franco.miaplicacion.Modelo;

import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Franco on 25/09/2016.
 */
public class Categoria {
    private String nombre;
    private String descripcion;
    private ImageView imagen;

    public Categoria(String nombre,String descripcion){
        this.nombre=nombre;
        this.descripcion=descripcion;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }

    public void setImagen(ImageView imagen){
        this.imagen=imagen;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public ImageView getImagen(){
        return this.imagen;
    }


    public static List<Categoria> obtenerListaPersonaByJason (String jasonCategoria) throws IOException,JSONException {
        List<Categoria> lista = new ArrayList<>();
        JSONObject jason = new JSONObject(jasonCategoria);
        JSONArray categorias = jason.getJSONArray("categorias");

        for (int i = 0; i < categorias.length() ; i++) {
            JSONObject c = categorias.getJSONObject(i);
            int id = c.getInt("id");
            String nombre = c.getString("titulo");
            String descripcion = c.getString("desc");
            String urlImg = c.getString("url_foto");

            Categoria p = new Categoria(nombre,descripcion);
            lista.add(p);
        }

        return  lista;
    }
}
