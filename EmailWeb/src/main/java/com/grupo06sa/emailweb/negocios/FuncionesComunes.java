/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo06sa.emailweb.negocios;

import com.grupo06sa.emailweb.modelos.Spcargo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class FuncionesComunes {
    
    public static boolean esNumero(String cadena){
            try {
                    cadena = cadena.trim();
                    Integer.parseInt(cadena);
                    return true;
            } catch (NumberFormatException nfe){
                    return false;
            }
    }
    /**
     * Devuelve true si la cadena tiene formato valido para fecha, falso en otro caso
     * @param cadena fecha en formato cadena
     * @return 
     */
    public static boolean esFecha(String cadena){
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            //SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            Date fecha = formatter.parse(cadena);
            return true;
        }catch(ParseException e){
            System.out.println("fecha : " + cadena);
            return false;
        }
    }
    /**
     * Devuelve una fecha a partir de una cadena
     * @param fecha Fecha en cadena
     * @return 
     */
    public static Date getFecha(String fecha){
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            //SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            Date f1 = formatter.parse(fecha);
            return f1;
        }catch(ParseException e){
            return new Date();
        }
    }    
}
