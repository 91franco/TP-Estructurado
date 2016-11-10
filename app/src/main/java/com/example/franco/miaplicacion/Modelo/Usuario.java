package com.example.franco.miaplicacion.Modelo;

/**
 * Created by Franco on 25/09/2016.
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private String usuario;
    private String contraseña;

    public Usuario(String nombre,String apellido,String usuario, String contraseña){
        this.nombre=nombre;
        this.apellido=apellido;
        this.usuario=usuario;
        this.contraseña=contraseña;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setApellido(String apellido){
        this.apellido=apellido;
    }

    public void setUsuario(String usuario){
        this.usuario=usuario;
    }

    public void setContraseña(String contraseña){
        this.contraseña=contraseña;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public String getUsuario(){
        return this.usuario;
    }

    public String getContraseña(){
        return this.contraseña;
    }


}
