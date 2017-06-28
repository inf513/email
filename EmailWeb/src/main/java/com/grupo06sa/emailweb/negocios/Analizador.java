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
public class Analizador {
    private final static String separador = "\\|";
    public Analizador(){}
    
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
    
    private Respuesta ejecutarComando(String comando, String tabla, String data){
        Respuesta respuesta = null;
        switch(comando){
            case COMANDO.CM_ADD:
                respuesta = this.ejecutarComandoADD(tabla, data);
                break;
            case COMANDO.CM_DEL:
                respuesta = this.ejecutarComandoDEL(tabla, data);
                break;
            case COMANDO.CM_UPD:
                respuesta = this.ejecutarComandoUPD(tabla, data);
                break;
            case COMANDO.CM_CON:
                respuesta = this.ejecutarComandoCON(tabla, data);
                break;
            default:
                respuesta = new Respuesta(COMANDO.MS_COMAN, "");
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
    private Respuesta ejecutarComandoADD(String tabla, String data){
        Respuesta respuesta = null;
        switch(tabla){
            case COMANDO.TB_CARGO:
                respuesta = Negocio.adicionarCargo(data);
                break;
            case COMANDO.TB_GESTION:
                respuesta = Negocio.adicionarGestion(data);
                break;
            case COMANDO.TB_ORDEN:
                respuesta = Negocio.adicionarOrdenTrabajo(data);
                break;
            case COMANDO.TB_ACTIVIDAD:
                
                break;
            default:
                respuesta = new Respuesta(COMANDO.MS_TABLA,"");
                break;
        }
       return respuesta;
    }
    /**
     * Ejecuta el comando Eliminar en la base de datos
     * @param tabla nombre de la tabla donde se ejecutara el comando
     * @param data datos que se ingresaran en la tabla
     * @return 
     */
    private Respuesta ejecutarComandoDEL(String tabla, String data){
        Respuesta respuesta = null;
        switch(tabla){
            case COMANDO.TB_CARGO:
                respuesta = Negocio.eliminarCargo(data);
                break;
            case COMANDO.TB_GESTION:
                respuesta = Negocio.eliminarGestion(data);
                break;
            case COMANDO.TB_ORDEN:
                respuesta = Negocio.eliminarOrdenTrabajo(data);
                break;
            case COMANDO.TB_ACTIVIDAD:
                
                break;
            default:
                respuesta = new Respuesta(COMANDO.MS_TABLA,"Tabla no encontrada");
                break;
        }
       return respuesta;
    }
    /**
     * Metodo que ejecuta el comando actualizar
     * @param tabla
     * @param data
     * @return 
     */
    private Respuesta ejecutarComandoUPD(String tabla, String data){
        Respuesta respuesta = null;
        switch(tabla){
            case COMANDO.TB_CARGO:
                respuesta = Negocio.actualizarCargo(data);
                break;
            case COMANDO.TB_GESTION:                
                respuesta = Negocio.actualizarGestion(data);
                break;
            case COMANDO.TB_ORDEN:
                respuesta = Negocio.actualizarOrdenTrabajo(data);
                break;
            case COMANDO.TB_ACTIVIDAD:
                
                break;
            default:
                respuesta = new Respuesta(COMANDO.MS_TABLA,"Tabla no encontrada");
                break;
        }
       return respuesta;
    }
    /**
     * Metodo que realiza una consulta 
     * @param tabla nombre de la tabla
     * @param data valor del identificador
     * @return 
     */
    private Respuesta ejecutarComandoCON(String tabla, String data){
        Respuesta respuesta = null;
        switch(tabla){
            case COMANDO.TB_CARGO:
                respuesta = Negocio.consultarCargo(data);
                break;
            case COMANDO.TB_GESTION:
                respuesta = Negocio.consultarGestion(data);
                break;
            case COMANDO.TB_ORDEN:
                respuesta = Negocio.consultarOrdenTrabajo(data);
                break;
            case COMANDO.TB_ACTIVIDAD:
                
                break;
            default:
                respuesta = new Respuesta(COMANDO.MS_TABLA,"Tabla no encontrada");
                break;
        }
       return respuesta;
    }
    
    /**
     * Devuelve true si la trama esta formada correctamente
     * @param trama Cadena con los datos
     * @return boolean
     */
    private boolean validarTrama(String trama){
        // cmd tabla       datos
        // ADD|CARGO|[DATA1, DATA2, DATA3, DATA4....]
        String[] data = trama.split(separador);
        return (data.length==3);
    }
    /**
     * Metodo que devuelve el comando de la trama
     * @param trama Es la cadena que contiene la trama
     * @return 
     */
    private String getComando(String trama){
        String[] data = trama.split(separador);
        return data[0];
    }
    /**
     * Metodo que devuelve la tabla donde se ejecutara el comando
     * @param trama
     * @return 
     */
    private String getTabla(String trama){
        String[] data = trama.split(separador);
        return data[1];
    }
    /**
     * Metodo que devuelve la data de la trama
     * @param trama 
     * @return 
     */
    private String getData(String trama){
        String[] data = trama.split(separador);
        return data[2];        
    }
}
