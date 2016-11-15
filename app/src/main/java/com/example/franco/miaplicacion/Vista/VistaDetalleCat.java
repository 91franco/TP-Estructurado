package com.example.franco.miaplicacion.Vista;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franco.miaplicacion.Controlador.ControladorDetalleCat;
import com.example.franco.miaplicacion.R;

/**
 * Created by Franco on 15/11/2016.
 */
public class VistaDetalleCat {
    private ImageView imageView;
    private TextView textView;
    private Activity activity;

    public VistaDetalleCat(Activity ac, ControladorDetalleCat controlador){
        activity=ac;
        if(activity.getClass().getName().equals("com.example.franco.miaplicacion.Activity.DetalleCatActivity")){
            this.imageView = (ImageView) ac.findViewById(R.id.imgCategoria);
            this.textView=(TextView) ac.findViewById(R.id.txDetalleCategoria);
        }
    }

}
