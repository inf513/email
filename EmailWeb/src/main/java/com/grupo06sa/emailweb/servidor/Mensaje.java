package com.grupo06sa.emailweb.servidor;

import java.util.Date;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Mensaje {
    private String email = "";
    private String asunto = "";
    private String contenido = "";
    private Date fecha_envio = null;
    private Date fecha_recibido = null;
    
    public static final String mailAyuda = "D:\\Repositorio\\email\\EmailWeb\\src\\main\\resources\\ayuda.html";
    public static final String mailList = "D:\\Repositorio\\email\\EmailWeb\\src\\main\\resources\\list.html";
    public static final String mailEstado = "D:\\Repositorio\\email\\EmailWeb\\src\\main\\resources\\mail.html";    
    public Mensaje(String mail, String asunto, String contenido, Date fecha_envio, Date fecha_recibido){
        this.contenido = contenido;
        this.email = mail;
        this.asunto = asunto;
        this.fecha_envio  = fecha_envio;
        this.fecha_recibido = fecha_recibido;
    }
    
    @Override
    public String toString(){
        String str ="";
        str += "Asunto : " + this.asunto + "\n";
        str += "De : " + this.email + "\n";
        str += "Fecha Envio : " + this.fecha_envio.toString() + "\n";
        str += "Fecha Recibido : " + this.fecha_recibido.toString() + "\n";
        str += "Contenido : " + this.contenido + "\n";
        
        return str;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email_from) {
        this.email = email_from;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public Date getFecha_recibido() {
        return fecha_recibido;
    }

    public void setFecha_recibido(Date fecha_recibido) {
        this.fecha_recibido = fecha_recibido;
    }
    
}
