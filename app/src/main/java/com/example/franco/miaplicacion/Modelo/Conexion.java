package com.example.franco.miaplicacion.Modelo;

/**
 * Created by alumno on 27/10/2016.
 */

import android.net.Uri;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Conexion  {

    public byte [] enviarInformacion (String urlString,Uri.Builder postParams,String pedido,String apiKey) throws  IOException {
        URL url = new URL(urlString);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod(pedido);
        if (apiKey!=null){
            urlConnection.setRequestProperty("AUTHORIZATION", apiKey);
        }
        if(pedido.equals("POST")) {
            urlConnection.setDoOutput(true);
            if(!(postParams==null)) {
                String query = postParams.build().getEncodedQuery();
                OutputStream os = urlConnection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new
                        OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
            }
        }

        int response = urlConnection.getResponseCode();
        if(response==200 || response==201) {
            InputStream is = urlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte [] buffer = new byte[1024];
            int length = 0;
            while ((length = is.read(buffer)) != -1){
                baos.write(buffer,0,length);
            }
            is.close();
            return baos.toByteArray();
        }
        else
            throw new IOException();
    }

}
