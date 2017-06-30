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
            
            //String trama = "UPD|GESTION|[2,18,2018-01-01,2018-12-31]"; XXX
            //String trama = "UPD|CARGO|[2,003,OPERADOR]"; XXX
            //String trama = "ADD|ORDEN|[1,2,001,NOMBRE DE OT,JUAN PERES,10]"; xxx
            //String trama = "UPD|ACTIVIDAD|[1,1,01,BASUREO]"; xxxx
            //String trama = "ADD|POLIGONO|[0,1,A04,POLIGONO - A04]";
            //ID_IO|IDordentrabajo|IDctividad|IDpoligono|descripcion|areatrab|rendimiento xx
            //String trama = "ADD|ITEMOBRA|[0,1,2,2,CADENEO POLIGONO A4,1000,0.5]";
            //String trama = "LST|ITEMOBRA|[]";
           // String trama = "ADD|CARGO|[0,010,GERENTE]";
           String trama = "LST|CARGO|[]";
            
            Respuesta r = a.analizarTrama(trama);
            System.out.println(r.getCode());
            System.out.println(r.getDescripcion());
            System.exit(0);
        } catch (Exception e) {
            System.out.println("err : " + e.getMessage());
        }
    }
}
