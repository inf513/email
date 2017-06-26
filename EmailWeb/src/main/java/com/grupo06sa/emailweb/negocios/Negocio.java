/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo06sa.emailweb.negocios;

import com.grupo06sa.emailweb.modelos.Spcargo;
import com.grupo06sa.emailweb.modelos.Spgestion;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Negocio {
    /**
     * Metodo que adiciona un cargo
     * @param data
     * @return 
     */
    public static Respuesta adicionarCargo(String data){
        Respuesta respuesta = null;        
        Cargo cargo = new Cargo();
        Spcargo modelo = cargo.getParser(data);
        if(modelo != null){
            String value = cargo.validarCargo(modelo);
            if(value.length()<=0){
                if(cargo.adicionar(modelo)){
                    respuesta = new Respuesta(COMANDO.MS_SUCCE, String.valueOf(modelo.getPkcargo()));
                }
                else{
                    respuesta = new Respuesta(COMANDO.MS_ERROR, "");
                }                                
            }else{
                respuesta = new Respuesta(COMANDO.MS_VALID, value);
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ATRIBUTOS DISTINTOS A TABLA");
        }
        
        return respuesta;
    }
    /**
     * Metodo que actualiza el cargo
     * @param data cadena con atributos
     * @return 
     */
    public static Respuesta actualizarCargo(String data){
        Respuesta respuesta = null;        
        Cargo cargo = new Cargo();
        Spcargo modelo = cargo.getParser(data);
        if(modelo != null){
            String value = cargo.validarCargo(modelo);
            if(value.length()<=0){
                if(cargo.actualizar(modelo)){
                    respuesta = new Respuesta(COMANDO.MS_SUCCE, String.valueOf(modelo.getPkcargo()));
                }
                else{
                    respuesta = new Respuesta(COMANDO.MS_ERROR, "");
                }                                
            }else{
                respuesta = new Respuesta(COMANDO.MS_VALID, value);
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ATRIBUTOS DISTINTOS A TABLA");
        }
        
        return respuesta;
    }
    
    /**
     * Metodo que actualiza la gestion
     * @param data cadena con atributos
     * @return 
     */
    public static Respuesta actualizarGestion(String data){
        Respuesta respuesta = null;        
        Gestion gestion = new Gestion();
        
        String res = gestion.validarFormatoFecha(data);
        if(res.length()<=0){
            Spgestion modelo = gestion.getParser(data);
            if(modelo != null){
                String value = gestion.validarGestion(modelo);
                if(value.length()<=0){
                    if(gestion.actualizar(modelo)){
                        respuesta = new Respuesta(COMANDO.MS_SUCCE, String.valueOf(modelo.getPkgestion()));
                    }
                    else{
                        respuesta = new Respuesta(COMANDO.MS_ERROR, "");
                    }                                
                }else{
                    respuesta = new Respuesta(COMANDO.MS_VALID, value);
                }
            }else{
                respuesta = new Respuesta(COMANDO.MS_VALID, "ATRIBUTOS DISTINTOS A TABLA");
            }            
        }else{
            respuesta = new Respuesta(COMANDO.MS_ERROR, res);
        }        
        return respuesta;
    }
    
    /**
     * Elimina un cargo y devuelve una respuesta
     * @param data cadena con los datos a eliminar
     * @return 
     */
    public static Respuesta eliminarCargo(String data){
        Respuesta respuesta = null;
        Cargo cargo = new Cargo();
        //[1]
        data = data.replace("[", "");
        data = data.replace("]", "");
        if(FuncionesComunes.esNumero(data)){
            if(cargo.eliminar(Integer.parseInt(data))){
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "");
            }else{
                respuesta = new Respuesta(COMANDO.MS_ERROR, "");
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "Es necesario un numero");
        }
        return respuesta;
    }
    
    /**
     * Elimina una gestion y devuelve una respuesta
     * @param data cadena con los datos a eliminar
     * @return 
     */
    public static Respuesta eliminarGestion(String data){
        Respuesta respuesta = null;
        Gestion gestion = new Gestion();
        //[1]
        data = data.replace("[", "");
        data = data.replace("]", "");
        if(FuncionesComunes.esNumero(data)){
            if(gestion.eliminar(Integer.parseInt(data))){
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "");
            }else{
                respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ELIMINAR");
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "Es necesario un numero");
        }
        return respuesta;
    }
    
    /**
     * Obtiene un cargo mediante la id cargo
     * @param data trama
     * @return 
     */
    public static Respuesta consultarCargo(String data){
        Respuesta respuesta = null;
        Cargo cargo = new Cargo();
        //[1]
        data = data.replace("[", "");
        data = data.replace("]", "");
        if(FuncionesComunes.esNumero(data)){                       
            Spcargo modelo = cargo.consultarPorId(Integer.parseInt(data));
            if(modelo != null){
                respuesta = new Respuesta(COMANDO.MS_SUCCE, modelo.toString());
            }else{
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "No se encontro cargo");
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "Es necesario un numero");
        }
        return respuesta;
    }    
    /**
     * Obtiene una gestion mediante la id cargo
     * @param data trama
     * @return 
     */
    public static Respuesta consultarGestion(String data){
        Respuesta respuesta = null;
        //[1]
        data = data.replace("[", "");
        data = data.replace("]", "");
        if(FuncionesComunes.esNumero(data)){                       
            Spgestion modelo = Gestion.consultarPorId(Integer.parseInt(data));
            if(modelo != null){
                respuesta = new Respuesta(COMANDO.MS_SUCCE, modelo.toString());
            }else{
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "No se encontro gestion");
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "Es necesario un numero");
        }
        return respuesta;
    }    
    
    /**
     * Adiciona una gestion al sistema
     * @param data trama de entrada
     * @return 
     */
    public static Respuesta adicionarGestion(String data){
        Respuesta respuesta = null;
        Gestion gestion = new Gestion();
        String res = gestion.validarFormatoFecha(data);
        if(res.length()<=0){
            Spgestion modelo = gestion.getParser(data);
            if(modelo != null){
                String value = gestion.validarGestion(modelo);
                if(value.length()<=0){
                    if(gestion.adicionar(modelo)){
                        respuesta = new Respuesta(COMANDO.MS_SUCCE, String.valueOf(modelo.getPkgestion()));
                    }
                    else{
                        respuesta = new Respuesta(COMANDO.MS_ERROR, "");
                    }                                
                }else{
                    respuesta = new Respuesta(COMANDO.MS_VALID, value);
                }
            }else{
                respuesta = new Respuesta(COMANDO.MS_VALID, "ATRIBUTOS DISTINTOS A TABLA");
            }        
        }else{
            respuesta = new Respuesta(COMANDO.MS_ERROR, res);
        }
        return respuesta;
    }
    /**
     * Adiciona una orden de tr
     * @param data
     * @return 
     */
    public static Respuesta adicionarOrdenTrabajo(String data){
        Respuesta respuesta = null;
        Gestion gestion = new Gestion();
        String res = gestion.validarFormatoFecha(data);
        if(res.length()<=0){
            Spgestion modelo = gestion.getParser(data);
            if(modelo != null){
                String value = gestion.validarGestion(modelo);
                if(value.length()<=0){
                    if(gestion.adicionar(modelo)){
                        respuesta = new Respuesta(COMANDO.MS_SUCCE, String.valueOf(modelo.getPkgestion()));
                    }
                    else{
                        respuesta = new Respuesta(COMANDO.MS_ERROR, "");
                    }                                
                }else{
                    respuesta = new Respuesta(COMANDO.MS_VALID, value);
                }
            }else{
                respuesta = new Respuesta(COMANDO.MS_VALID, "ATRIBUTOS DISTINTOS A TABLA");
            }        
        }else{
            respuesta = new Respuesta(COMANDO.MS_ERROR, res);
        }
        return respuesta;
    }
    
}
