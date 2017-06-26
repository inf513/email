/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo06sa.emailweb.negocios;

/**
 * Analizador sintactico de tramas que llegan al servidor
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Parser {
    
    public Parser(){}
    
    public Respuesta analizarTrama(String trama){
        Respuesta respuesta = null;
        try {
            // cmd tabla       datos
            // ADD|CARGO|[DATA1, DATA2, DATA3, DATA4....]
            if(this.validarTrama(trama)){
                respuesta = this.ejecutarComando(this.getComando(trama), this.getTabla(trama), this.getData(trama));
            }else{
                respuesta = new Respuesta(COMANDO.MS_TRVAL, "parametros no coinciden");
            }
        } catch (Exception e) {
            System.out.println("[Parser.analizarTrama] " + e.getMessage());
        }
        return respuesta;
    }
    
    public Respuesta ejecutarComando(String comando, String tabla, String data){
        Respuesta respuesta = null;
        switch(comando){
            case COMANDO.CM_ADD:
                respuesta = this.ejecutarComandoADD(tabla, data);
                break;
            case COMANDO.CM_DEL:
                break;
            case COMANDO.CM_UPD:
                break;
            case COMANDO.CM_CON:
                break;
        }
     
        return respuesta;
    }
    /**
     * Ejecuta el comando Adicionar en la base de datos
     * @param tabla nombre de la tabla donde se ejecutara el comando
     * @param data datos que se ingresaran en la tabla
     * @return 
     */
    public Respuesta ejecutarComandoADD(String tabla, String data){
        Respuesta respuesta = null;
        switch(tabla){
            case COMANDO.TB_CARGO:
                respuesta = Negocio.adicionarCargo(data);
                break;
            case COMANDO.TB_GESTION:
                respuesta = Negocio.adicionarGestion(data);
                break;
            case COMANDO.TB_ORDEN:
                
                break;
            case COMANDO.TB_ACTIVIDAD:
                
                break;
        }
       return respuesta;
    }
    
    /**
     * Devuelve true si la trama esta formada correctamente
     * @param trama Cadena con los datos
     * @return boolean
     */
    public boolean validarTrama(String trama){
        // cmd tabla       datos
        // ADD|CARGO|[DATA1, DATA2, DATA3, DATA4....]
        String[] data = trama.split("|");
        return (data.length==3);
    }
    /**
     * Metodo que devuelve el comando de la trama
     * @param trama Es la cadena que contiene la trama
     * @return 
     */
    public String getComando(String trama){
        String[] data = trama.split("|");       
        return data[0];
    }
    /**
     * Metodo que devuelve la tabla donde se ejecutara el comando
     * @param trama
     * @return 
     */
    public String getTabla(String trama){
        String[] data = trama.split("|");       
        return data[1];
    }
    /**
     * Metodo que devuelve la data de la trama
     * @param trama 
     * @return 
     */
    public String getData(String trama){
        String[] data = trama.split("|");       
        return data[2];        
    }
    public static void main(String[] str){
    }
}
