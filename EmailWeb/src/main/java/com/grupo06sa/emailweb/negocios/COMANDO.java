/*
 * To change this license headggger, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo06sa.emailweb.negocios;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class COMANDO {
    public final static String CM_ADD = "ADD";
    public final static String CM_UPD = "UPD";
    public final static String CM_DEL = "DEL";
    public final static String CM_CON = "CON";// consultar
    
    public final static String TB_CARGO = "CARGO";
    public final static String TB_GESTION = "GESTION";
    public final static String TB_ORDEN = "ORDEN";
    public final static String TB_ACTIVIDAD = "ACTIVIDAD";
    
    /**
     * CUANDO LA TRANSACCION NO PUDO EJECUTARSE
     */
    public final static String MS_ERROR = "TRANSACCION NO EJECUTADA";
    /**
     * CUANDO LA TRANSACCION SE EJECUTO CORRECTAMENTE
     */
    public final static String MS_SUCCE = "TRANSACCION EJECUTADA CORRECTAMENTE";
    /**
     * CUANDO NO SE RECONOCE NINGUNA TRAMA
     */
    public final static String MS_TRVAL = "TRAMA NO VALIDA";
    /**
     * CUANDO LAS CREDENCIALES NO SON VALIDAS
     */
    public final static String MS_LOGIN = "USUARIO Y/O CONTRASEÑA NO VALIDOS";    
    /**
     * CUANDO LA TRAMA NO CUMPLE LAS VALIDACIONES CORRECTAMENTE
     */
    public final static String MS_VALID = "ERROR DE VALIDACION";
}
