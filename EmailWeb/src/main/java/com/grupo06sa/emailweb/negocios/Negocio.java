/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo06sa.emailweb.negocios;

import com.grupo06sa.emailweb.modelos.Spcargo;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Negocio {
    public static Respuesta adicionarCargo(String data){
        Respuesta respuesta = null;        
        Cargo cargo = new Cargo();
        Spcargo modelo = cargo.getParser(data);
        if(modelo != null){
            if(cargo.adicionar(modelo)){
                respuesta = new Respuesta(COMANDO.MS_SUCCE, String.valueOf(modelo.getPkcargo()));
            }
            else{
                respuesta = new Respuesta(COMANDO.MS_ERROR, "");
            }                
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "");
        }
        
        return respuesta;
    }
    public static Respuesta adicionarGestion(String data){
        return null;
    }
}
