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
            
            //String trama = "UPD|GESTION|[2,18,2018-01-01,2018-12-31]";
            //String trama = "UPD|CARGO|[2,003,OPERADOR]";
            //String trama = "ADD|ORDEN|[1, 2, 001, NOMBRE DE OT, JUAN PERES, 10]";
            String trama = "DEL|ORDEN|[2]";
            Respuesta r = a.analizarTrama(trama);
            System.out.println(r.toString());
            System.exit(0);
        } catch (Exception e) {
            System.out.println("err : " + e.getMessage());
        }
    }
}
