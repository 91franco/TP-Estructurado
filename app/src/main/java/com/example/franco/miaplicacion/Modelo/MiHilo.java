package com.example.franco.miaplicacion.Modelo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.franco.miaplicacion.Activity.InicioActivity;
import com.example.franco.miaplicacion.Controlador.ControladorInicio;
import com.example.franco.miaplicacion.Controlador.ControladorNuevaCategoria;
import com.example.franco.miaplicacion.Controlador.ControladorRegistrarse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

/**
 * Created by alumno on 03/11/2016.
 */
public class MiHilo extends Thread {
    Handler miHandler;
    Conexion miConexion;
    int accion;
    String error;
    String respuesta;
    Uri.Builder params;
    String urlImagen;
    int position;


    public MiHilo(Handler handler, int i,Uri.Builder params,String urlImagen, int position ){
        this.miHandler=handler;
        this.accion=i;
        this.params =params;
        this.urlImagen = urlImagen;
        this.position = position;

    }

    @Override
    public void run (){

        try {

            miConexion= new Conexion();
            if (accion == ControladorInicio.LOGIN){
                byte[] informacion=miConexion.enviarInformacion("http://lkdml.myq-see.com/login",params,"POST",null);
                String info = new String (informacion);
                JSONObject jason = new JSONObject(info);
                error = jason.getString("error");
                Log.d("respuesta:",info);
                if("false".equals(error)){
                    InicioActivity.apiKey = jason.getString("apiKey");
                    byte[] informacion1=miConexion.enviarInformacion("http://lkdml.myq-see.com/categorias",null,"GET",InicioActivity.apiKey);
                    String info2 = new String (informacion1);
                    List<Categoria> categorias = Categoria.obtenerListaPersonaByJason(info2);
                    Message msg = new Message();
                    msg.arg1 = ControladorInicio.LOGIN;
                    msg.obj = categorias;
                    miHandler.sendMessage(msg);
                }else {
                    String mensaje = jason.getString("message");
                    InicioActivity.vista.datosIncorrectos(mensaje);
                }
            }

            if (accion == ControladorRegistrarse.REGISTRARSE){
                byte[] informacion=miConexion.enviarInformacion("http://lkdml.myq-see.com/register",params,"POST",null);
                String info = new String (informacion);
                JSONObject jason = new JSONObject(info);
                error = jason.getString("error");
                respuesta=jason.getString("message");
                Message msg = new Message();
                Log.d("respuesta:",info);
                if("false".equals(error)){
                    msg.arg1 = ControladorRegistrarse.REGISTRARSE_OK;
                    msg.obj = respuesta;
                }else {
                    msg.arg1 = ControladorRegistrarse.REGISTRARSE_NOK;
                    msg.obj = respuesta;
                }
                miHandler.sendMessage(msg);
            }

            if (accion == ControladorNuevaCategoria.CREARCATEGORIA){
                byte[] informacion=miConexion.enviarInformacion("http://lkdml.myq-see.com/categorias",params,"POST",InicioActivity.apiKey);
                String info = new String (informacion);
                JSONObject jason = new JSONObject(info);
                error = jason.getString("error");
                respuesta=jason.getString("message");
                Message msg = new Message();
                if("false".equals(error)){
                    byte[] informacion1=miConexion.enviarInformacion("http://lkdml.myq-see.com/categorias",null,"GET",InicioActivity.apiKey);
                    String info1 = new String (informacion1);
                    List<Categoria> categorias = Categoria.obtenerListaPersonaByJason(info1);
                    msg.arg1 = ControladorNuevaCategoria.CREARCATEGORIA;
                    msg.obj = categorias;
                    miHandler.sendMessage(msg);
                }else {

                }

            }

            if (accion == ControladorInicio.CARGARIMAGEN){
                byte[] informacion=miConexion.enviarInformacion("http://lkdml.myq-see.com/"+urlImagen,null,"GET",null);
                Bitmap bitmap = BitmapFactory.decodeByteArray(informacion,0,informacion.length);
                Message msg1= new Message();
                msg1.arg1= ControladorInicio.CARGARIMAGEN;
                msg1.arg2=position;
                msg1.obj=informacion;
                miHandler.sendMessage(msg1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }catch (JSONException e1){
            e1.printStackTrace();
        }

    }
}