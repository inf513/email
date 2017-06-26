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
public class principal {
    public principal(){}
    public static void main(String[] main){
        try {
            Analizador a = new Analizador();
            String trama = "CON|CARGO|[2]";
            //[desc: [codigo => DA1, descripcion => CARGO ULTIMO]]
            Respuesta r = a.analizarTrama(trama);
            System.out.println(r.toString());
            System.exit(0);
        } catch (Exception e) {
            System.out.println("err : " + e.getMessage());
        }
    }
}
