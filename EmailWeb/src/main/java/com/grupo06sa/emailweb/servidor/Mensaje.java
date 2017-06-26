/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo06sa.emailweb.servidor;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Mensaje {
    public String email_from = "";
    public String email_to = "";
    public String asunto = "";
    public String data = "";
    
    public Mensaje(String to, String from, String asunto, String data){
        this.data = data;
        this.email_from = from;
        this.email_to = to;
        this.asunto = asunto;
    }
    
    @Override
    public String toString(){
        String str ="";
        str += "Asunto : " + this.asunto + "\n";
        str += "Remitente : " + this.email_from + "\n";
        str += "Contenido : " + this.data + "\n";
        
        return str;
    }

}
