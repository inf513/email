/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo06sa.emailweb.negocios;

import com.grupo06sa.emailweb.modelos.Spactividad;
import com.grupo06sa.emailweb.modelos.Spcargo;
import com.grupo06sa.emailweb.modelos.Spgestion;
import com.grupo06sa.emailweb.modelos.Spordentrabajo;
import com.grupo06sa.emailweb.modelos.Sppoligono;

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
        OrdenTrabajo ot = new OrdenTrabajo();        

        Spordentrabajo modelo = ot.getParser(data);    
        if(modelo != null){
            String value = ot.validarOrdenTrabajo(modelo);
            if(value.length()<=0){
                if(ot.adicionar(modelo)){
                    respuesta = new Respuesta(COMANDO.MS_SUCCE, String.valueOf(modelo.getPkordentrabajo()));
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
     * Metodo que actualiza una orden de trabajo
     * @param data trama de entrada con los datos de la orden de trabajo
     * @return 
     */
    public static Respuesta actualizarOrdenTrabajo(String data){
        Respuesta respuesta = null;
        OrdenTrabajo ot = new OrdenTrabajo();        

        Spordentrabajo modelo = ot.getParser(data);
        if(modelo != null){
            String value = ot.validarOrdenTrabajo(modelo);
            if(value.length()<=0){
                if(ot.actualizar(modelo)){
                    respuesta = new Respuesta(COMANDO.MS_SUCCE, String.valueOf(modelo.getPkordentrabajo()));
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
     * Metodo que busca una orden de trabajo a partir de una id
     * @param data 
     * @return 
     */
    public static Respuesta consultarOrdenTrabajo(String data){
        Respuesta respuesta = null;
        //[1]
        data = data.replace("[", "");
        data = data.replace("]", "");
        if(FuncionesComunes.esNumero(data)){
            Spordentrabajo modelo = OrdenTrabajo.consultarPorId(Integer.parseInt(data));
            if(modelo != null){
                respuesta = new Respuesta(COMANDO.MS_SUCCE, modelo.toString());
            }else{
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "No se encontro Orden de Trabajo");
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "Es necesario un numero");
        }
        return respuesta;
    }
    
    /**
     * Metodo que elimina una orden de trabajo
     * @param data
     * @return 
     */
    public static Respuesta eliminarOrdenTrabajo(String data){
        Respuesta respuesta = null;
        OrdenTrabajo ot = new OrdenTrabajo();
        //[1]
        data = data.replace("[", "");
        data = data.replace("]", "");
        if(FuncionesComunes.esNumero(data)){
            if(ot.eliminar(Integer.parseInt(data))){
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "OT ELIMINADA CORRECTAMENTE");
            }else{
                respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ELIMINAR");
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "Es necesario un numero");
        }
        return respuesta;
    }
    /**
     * Metodo que adiciona una actividad a la base de datos
     * @param data trama de datos
     * @return 
     */
    public static Respuesta adicionarActividad(String data){
        Respuesta respuesta = null;
        Actividad actividad = new Actividad();

        Spactividad modelo = actividad.getParser(data);
        if(modelo != null){
            String value = actividad.validarActividad(modelo);
            if(value.length()<=0){
                if(actividad.adicionar(modelo)){
                    respuesta = new Respuesta(COMANDO.MS_SUCCE, String.valueOf(modelo.getPkactividad()));
                }
                else{
                    respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ADICIONAR ACTIVIDAD");
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
     * Metodo que elimina una actividad de la base de datos
     * @param data trama de datos
     * @return 
     */
    public static Respuesta eliminarActividad(String data){
        Respuesta respuesta = null;
        Actividad actividad = new Actividad();
        //[1]
        data = data.replace("[", "");
        data = data.replace("]", "");
        if(FuncionesComunes.esNumero(data)){
            if(actividad.eliminar(Integer.parseInt(data))){
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "ACTIVIDAD ELIMINADA CORRECTAMENTE");
            }else{
                respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ELIMINAR");
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "Es necesario un numero");
        }
        return respuesta;
    }
    /**
     * Metodo que actualiza una actividad en la base de datos
     * @param data trama de base de datos
     * @return 
     */
    public static Respuesta actualizarActividad(String data){
        Respuesta respuesta = null;
        Actividad actividad = new Actividad();

        Spactividad modelo = actividad.getParser(data);
        if(modelo != null){
            String value = actividad.validarActividad(modelo);
            if(value.length()<=0){
                if(actividad.actualizar(modelo)){
                    respuesta = new Respuesta(COMANDO.MS_SUCCE, String.valueOf(modelo.getPkactividad()));
                }
                else{
                    respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ACTUALIZAR ACTIVIDAD");
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
     * Metodo que obtiene una actividad a partir de su identificador
     * @param data trama de datos 
     * @return 
     */
    public static Respuesta consultarActividad(String data){
        Respuesta respuesta = null;
        //[1]
        data = data.replace("[", "");
        data = data.replace("]", "");
        if(FuncionesComunes.esNumero(data)){
            Spactividad modelo = Actividad.consultarPorId(Integer.parseInt(data));
            if(modelo != null){
                respuesta = new Respuesta(COMANDO.MS_SUCCE, modelo.toString());
            }else{
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "NO SE ENCONTRO ACTIVIDAD");
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ES NECESARIO UN NUMERO");
        }
        return respuesta;
    }
    /**
     * Metodo que adiciona un poligono a la base de datos
     * @param data trama de datos 
     * @return 
     */
    public static Respuesta adicionarPoligono(String data){
        Respuesta respuesta = null;
        Poligono poligono = new Poligono();

        Sppoligono modelo = poligono.getParser(data);
        if(modelo != null){
            String value = poligono.validarPoligono(modelo);
            if(value.length()<=0){
                if(poligono.adicionar(modelo)){
                    respuesta = new Respuesta(COMANDO.MS_SUCCE, String.valueOf(modelo.getPkpoligono()));
                }
                else{
                    respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ADICIONAR POLIGONO");
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
     * Metodo que elimina un poligono de la base de datos
     * @param data trama de datos
     * @return 
     */
    public static Respuesta eliminarPoligono(String data){
        Respuesta respuesta = null;
        Poligono poligono = new Poligono();
        //[1]
        data = data.replace("[", "");
        data = data.replace("]", "");
        if(FuncionesComunes.esNumero(data)){
            if(poligono.eliminar(Integer.parseInt(data))){
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "POLIGONO ELIMINADO CORRECTAMENTE");
            }else{
                respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ELIMINAR");
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "Es necesario un numero");
        }
        return respuesta;
    }
    /**
     * Metodo que actualiza una poligono en la base de datos
     * @param data trama de base de datos
     * @return 
     */
    public static Respuesta actualizarPoligono(String data){
        Respuesta respuesta = null;
        Poligono poligono = new Poligono();

        Sppoligono modelo = poligono.getParser(data);
        if(modelo != null){
            String value = poligono.validarPoligono(modelo);
            if(value.length()<=0){
                if(poligono.actualizar(modelo)){
                    respuesta = new Respuesta(COMANDO.MS_SUCCE, String.valueOf(modelo.getPkpoligono()));
                }
                else{
                    respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ACTUALIZAR POLIGONO");
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
     * Metodo que obtiene un poligono a partir de su identificador
     * @param data trama de datos 
     * @return 
     */
    public static Respuesta consultarPoligono(String data){
        Respuesta respuesta = null;
        //[1]
        data = data.replace("[", "");
        data = data.replace("]", "");
        if(FuncionesComunes.esNumero(data)){
            Sppoligono modelo = Poligono.consultarPorId(Integer.parseInt(data));
            if(modelo != null){
                respuesta = new Respuesta(COMANDO.MS_SUCCE, modelo.toString());
            }else{
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "NO SE ENCONTRO ACTIVIDAD");
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ES NECESARIO UN NUMERO");
        }
        return respuesta;
    }
}
