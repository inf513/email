/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo06sa.emailweb.negocios;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Respuesta {
    private String code = null;
    private String descripcion = null;
    private String nombreTabla = null;
    public static final String code_replace = "CODIGO1";
    public static final String desc_replace = "DESCRIPCION1";
    
    public Respuesta(String code, String descripcion, String nombreTabla){
        this.code = code;
        this.descripcion = descripcion;
        this.nombreTabla = nombreTabla;
    }
    public String getNombreTabla(){
        return this.nombreTabla;
    }
    public void setNombreTabla(String name){
        this.nombreTabla = name;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public String toString(){
        return "[comando: " + this.getCode() + "] [desc: " + this.getDescripcion() + "]";
    }
}
