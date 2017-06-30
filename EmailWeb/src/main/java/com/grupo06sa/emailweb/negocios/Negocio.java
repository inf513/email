/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo06sa.emailweb.negocios;

import com.grupo06sa.emailweb.modelos.Spactividad;
import com.grupo06sa.emailweb.modelos.Spcargo;
import com.grupo06sa.emailweb.modelos.Spgestion;
import com.grupo06sa.emailweb.modelos.Spitemobra;
import com.grupo06sa.emailweb.modelos.Spordentrabajo;
import com.grupo06sa.emailweb.modelos.Sppoligono;
import java.util.List;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Negocio {
    
    
    public static Respuesta listarCargo(){
        Respuesta respuesta = new Respuesta("INI", "","");
        List<Spcargo> cargos = Cargo.listar();
        
        if(cargos.size() > 0 ){
            respuesta = new Respuesta(COMANDO.MS_LST, HtmlFormat.getFormatoCargo(cargos), Cargo.getTabla());
        }else{            
            respuesta.setCode(COMANDO.MS_SUCCE);
            respuesta.setNombreTabla(Cargo.getTabla());
            respuesta.setDescripcion("NO SE ENCONTRARON CARGOS A LISTAR");
        }        
        return respuesta;
    }
    public static Respuesta listarActividad(){
        Respuesta respuesta = new Respuesta("INI", "","");
        List<Spactividad> lista = Actividad.listar();
        
        if(lista.size() > 0 ){
            respuesta = new Respuesta(COMANDO.MS_LST, HtmlFormat.getFormatoActividad(lista), Actividad.getTabla());
        }else{            
            respuesta.setCode(COMANDO.MS_SUCCE);
            respuesta.setNombreTabla(Actividad.getTabla());
            respuesta.setDescripcion("NO SE ENCONTRARON ACTIVIDADES A LISTAR");
        }        
        return respuesta;
    }

    public static Respuesta listarGestion(){
        Respuesta respuesta = new Respuesta("INI", "","");
        List<Spgestion> lista = Gestion.listar();
        
        if(lista.size() > 0 ){
            respuesta = new Respuesta(COMANDO.MS_LST, HtmlFormat.getFormatoGestion(lista), Gestion.getTabla());
        }else{            
            respuesta.setCode(COMANDO.MS_SUCCE);
            respuesta.setNombreTabla(Gestion.getTabla());
            respuesta.setDescripcion("NO SE ENCONTRARON GESTIONES A LISTAR");
        }        
        return respuesta;
    }
    public static Respuesta listarPoligono(){
        Respuesta respuesta = new Respuesta("INI", "","");
        List<Sppoligono> lista = Poligono.listar();
        
        if(lista.size() > 0 ){
            respuesta = new Respuesta(COMANDO.MS_LST, HtmlFormat.getFormatoPoligono(lista), Poligono.getTabla());
        }else{            
            respuesta.setCode(COMANDO.MS_SUCCE);
            respuesta.setNombreTabla(Poligono.getTabla());
            respuesta.setDescripcion("NO SE ENCONTRARON POLIGONOS A LISTAR");
        }        
        return respuesta;
    }

    public static Respuesta listarItemObra(){
        Respuesta respuesta = new Respuesta("INI", "","");
        List<Spitemobra> lista = ItemObra.listar();
        
        if(lista.size() > 0 ){
            respuesta = new Respuesta(COMANDO.MS_LST, HtmlFormat.getFormatoItemObra(lista), ItemObra.getTabla());
        }else{            
            respuesta.setCode(COMANDO.MS_SUCCE);
            respuesta.setNombreTabla(ItemObra.getTabla());
            respuesta.setDescripcion("NO SE ENCONTRARON ITEM OBRAS A LISTAR");
        }        
        return respuesta;
    }
    public static Respuesta listarOrdenTrabajo(){
        Respuesta respuesta = new Respuesta("INI", "","");
        List<Spordentrabajo> lista = OrdenTrabajo.listar();
        
        if(lista.size() > 0 ){
            respuesta = new Respuesta(COMANDO.MS_LST, HtmlFormat.getFormatoOrdenTrabajo(lista), OrdenTrabajo.getTabla());
        }else{            
            respuesta.setCode(COMANDO.MS_SUCCE);
            respuesta.setNombreTabla(OrdenTrabajo.getTabla());
            respuesta.setDescripcion("NO SE ENCONTRARON ORDENES DE TRABAJO A LISTAR");
        }        
        return respuesta;
    }
    
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
                    respuesta = new Respuesta(COMANDO.MS_SUCCE, "CARGO ADICIONADO CORRECTAMENTE", Cargo.getTabla());
                }else{
                    respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ADICIONAR CARGO", Cargo.getTabla());
                }                                
            }else{
                respuesta = new Respuesta(COMANDO.MS_VALID, value, Cargo.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ATRIBUTOS DISTINTOS A TABLA", Cargo.getTabla());
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
                    respuesta = new Respuesta(COMANDO.MS_SUCCE, "CARGO MODIFICADO CORRECTAMENTE", Cargo.getTabla());
                }
                else{
                    respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO MODIFICAR CARGO", Cargo.getTabla());
                }                                
            }else{
                respuesta = new Respuesta(COMANDO.MS_VALID, value, "");
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ATRIBUTOS DISTINTOS A TABLA", Cargo.getTabla());
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
                        respuesta = new Respuesta(COMANDO.MS_SUCCE, "GESTION MODIFICADA CORRECTAMENTE", Gestion.getTabla());
                    }
                    else{
                        respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO MODIFICAR GESTION", Gestion.getTabla());
                    }                                
                }else{
                    respuesta = new Respuesta(COMANDO.MS_VALID, value, Gestion.getTabla());
                }
            }else{
                respuesta = new Respuesta(COMANDO.MS_VALID, "ATRIBUTOS DISTINTOS A TABLA", Gestion.getTabla());
            }            
        }else{
            respuesta = new Respuesta(COMANDO.MS_ERROR, res, Gestion.getTabla());
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
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "CARGO ELIMINADO CORRECTAMENTE", Cargo.getTabla());
            }else{
                respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ELIMINAR CARGO", Cargo.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ES NECESARIO UN NUMERO", Cargo.getTabla());
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
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "GESTION ELIMINADA CORRECTAMENTE", Gestion.getTabla());
            }else{
                respuesta = new Respuesta(COMANDO.MS_ERROR, "GESTION NO PUDO SER ELIMINADA", Gestion.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ES NECESARIO UN NUMERO", Gestion.getTabla());
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
        //[1]
        data = data.replace("[", "");
        data = data.replace("]", "");
        if(FuncionesComunes.esNumero(data)){                       
            Spcargo modelo = Cargo.consultarPorId(Integer.parseInt(data));
            if(modelo != null){                
                respuesta = new Respuesta(COMANDO.MS_SUCCE, modelo.toString(), Cargo.getTabla());
            }else{
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "CARGO NO ENCONTRADO", Cargo.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ES NECESARIO UN NUMERO", Cargo.getTabla());
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
                respuesta = new Respuesta(COMANDO.MS_SUCCE, modelo.toString(), Gestion.getTabla());
            }else{
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "GESTION NO PUDO SER ENCONTRADA", Gestion.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ES NECESARIO UN NUMERO", Gestion.getTabla());
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
                        respuesta = new Respuesta(COMANDO.MS_SUCCE, "GESTION ADICIONADA CORRECTAMENTE", Gestion.getTabla());
                    }
                    else{
                        respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ADICIONAR GESTION", Gestion.getTabla());
                    }                                
                }else{
                    respuesta = new Respuesta(COMANDO.MS_VALID, value, Gestion.getTabla());
                }
            }else{
                respuesta = new Respuesta(COMANDO.MS_VALID, "ATRIBUTOS DISTINTOS A TABLA", Gestion.getTabla());
            }        
        }else{
            respuesta = new Respuesta(COMANDO.MS_ERROR, res, Gestion.getTabla());
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
                modelo.setData(modelo.getCodigo()+"-"+modelo.getSpgestion().getCodigo());
                if(ot.adicionar(modelo)){
                    respuesta = new Respuesta(COMANDO.MS_SUCCE, "ORDEN DE TRABAJO ADICIONADA CORRECTAMENTE", OrdenTrabajo.getTabla());
                }
                else{
                    respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ADICIONAR ORDEN DE TRABAJO", OrdenTrabajo.getTabla());
                }                                
            }else{
                respuesta = new Respuesta(COMANDO.MS_VALID, value, OrdenTrabajo.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ATRIBUTOS DISTINTOS A TABLA", OrdenTrabajo.getTabla());
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
                modelo.setData(modelo.getCodigo()+"-"+modelo.getSpgestion().getCodigo());
                if(ot.actualizar(modelo)){
                    respuesta = new Respuesta(COMANDO.MS_SUCCE, "ORDEN DE TRABAJO MODIFICADA CORRECTAMENTE", OrdenTrabajo.getTabla());
                }
                else{
                    respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO MODIFICAR ORDEN DE TRABAJO", OrdenTrabajo.getTabla());
                }                                
            }else{
                respuesta = new Respuesta(COMANDO.MS_VALID, value, OrdenTrabajo.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ATRIBUTOS DISTINTOS A TABLA", OrdenTrabajo.getTabla());
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
                respuesta = new Respuesta(COMANDO.MS_SUCCE, modelo.toString(), OrdenTrabajo.getTabla());
            }else{
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "NO SE PUDO ENCONTRAR ORDEN DE TRABAJO", OrdenTrabajo.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ES NECESARIO UN NUMERO", OrdenTrabajo.getTabla());
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
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "ORDEN DE TRABAJO ELIMINADA CORRECTAMENTE", OrdenTrabajo.getTabla());
            }else{
                respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ELIMINAR ORDEN DE TRABAJO", OrdenTrabajo.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ES NECESARIO UN NUMERO", OrdenTrabajo.getTabla());
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
                    respuesta = new Respuesta(COMANDO.MS_SUCCE, "ACTIVIDAD ADICIONADA CORRECTAMENTE", Actividad.getTabla());
                }
                else{
                    respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ADICIONAR ACTIVIDAD", Actividad.getTabla());
                }                                
            }else{
                respuesta = new Respuesta(COMANDO.MS_VALID, value, Actividad.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ATRIBUTOS DISTINTOS A TABLA", Actividad.getTabla());
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
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "ACTIVIDAD ELIMINADA CORRECTAMENTE", Actividad.getTabla());
            }else{
                respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ELIMINAR ACTIVIDAD", Actividad.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ES NECESARIO UN NUMERO", Actividad.getTabla());
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
                    respuesta = new Respuesta(COMANDO.MS_SUCCE, "ACTIVIDAD MODIFICADA CORRECTAMENTE", Actividad.getTabla());
                }
                else{
                    respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ACTUALIZAR ACTIVIDAD", Actividad.getTabla());
                }                                
            }else{
                respuesta = new Respuesta(COMANDO.MS_VALID, value, Actividad.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ATRIBUTOS DISTINTOS A TABLA", Actividad.getTabla());
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
                respuesta = new Respuesta(COMANDO.MS_SUCCE, modelo.toString(), Actividad.getTabla());
            }else{
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "NO SE ENCONTRO ACTIVIDAD", Actividad.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ES NECESARIO UN NUMERO", Actividad.getTabla());
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
                    respuesta = new Respuesta(COMANDO.MS_SUCCE, "POLIGONO ADICIONADO CORRECTAMENTE", Poligono.getTabla());
                }
                else{
                    respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ADICIONAR POLIGONO", Poligono.getTabla());
                }                                
            }else{
                respuesta = new Respuesta(COMANDO.MS_VALID, value, Poligono.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ATRIBUTOS DISTINTOS A TABLA", Poligono.getTabla());
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
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "POLIGONO ELIMINADO CORRECTAMENTE", Poligono.getTabla());
            }else{
                respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ELIMINAR POLIGONO", Poligono.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ES NECESARIO UN NUMERO", Poligono.getTabla());
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
                    respuesta = new Respuesta(COMANDO.MS_SUCCE, "POLIGONO MODIFICADO CORRECTAMENTE", Poligono.getTabla());
                }
                else{
                    respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ACTUALIZAR POLIGONO", Poligono.getTabla());
                }                                
            }else{
                respuesta = new Respuesta(COMANDO.MS_VALID, value, Poligono.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ATRIBUTOS DISTINTOS A TABLA", Poligono.getTabla());
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
                respuesta = new Respuesta(COMANDO.MS_SUCCE, modelo.toString(), Poligono.getTabla());
            }else{
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "NO SE ENCONTRO POLIGONO", Poligono.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ES NECESARIO UN NUMERO", Poligono.getTabla());
        }
        return respuesta;
    }
    /**
     * Adiciona un item obra
     * @param data item obra como trama
     * @return 
     */
    public static Respuesta adicionarItemObra(String data){
        Respuesta respuesta = null;
        ItemObra io = new ItemObra();

        Spitemobra modelo = io.getParser(data);
        if(modelo != null){
            String value = io.validarItemObra(modelo);
            if(value.length()<=0){                
                modelo.setCodigo(modelo.getSppoligono().getCodigo().trim() + "-" + modelo.getSpactividad().getCodigo().trim());
                if(io.adicionar(modelo)){
                    respuesta = new Respuesta(COMANDO.MS_SUCCE, "ITEM OBRA ADICIONADO CORRECTAMENTE", ItemObra.getTabla());
                }
                else{
                    respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ADICIONAR ITEM OBRA", ItemObra.getTabla());
                }                                
            }else{
                respuesta = new Respuesta(COMANDO.MS_VALID, value, ItemObra.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ATRIBUTOS DISTINTOS A TABLA", ItemObra.getTabla());
        }
        
        return respuesta;
    }
    /**
     * Metodo que actualiza un Item obra
     * @param data trama de entrada con los datos de item obra
     * @return 
     */
    public static Respuesta actualizarItemObra(String data){
        Respuesta respuesta = null;
        ItemObra io = new ItemObra();

        Spitemobra modelo = io.getParser(data);
        if(modelo != null){
            String value = io.validarItemObra(modelo);
            if(value.length()<=0){
                modelo.setCodigo(modelo.getSppoligono().getCodigo().trim() + "-" + modelo.getSpactividad().getCodigo().trim());
                if(io.actualizar(modelo)){
                    respuesta = new Respuesta(COMANDO.MS_SUCCE, "ITEM OBRA MODIFICADO CORRECTAMENTE", ItemObra.getTabla());
                }
                else{
                    respuesta = new Respuesta(COMANDO.MS_ERROR, "NO SE PUDO ACTUALIZAR ITEM OBRA", ItemObra.getTabla());
                }                                
            }else{
                respuesta = new Respuesta(COMANDO.MS_VALID, value, ItemObra.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ATRIBUTOS DISTINTOS A TABLA", ItemObra.getTabla());
        }
        
        return respuesta;
    }
    /**
     * Metodo que busca una Item obra a partir de una id
     * @param data  trama de item obra
     * @return 
     */
    public static Respuesta consultarItemObra(String data){
        Respuesta respuesta = null;
        //[1]
        data = data.replace("[", "");
        data = data.replace("]", "");
        if(FuncionesComunes.esNumero(data)){
            Spitemobra modelo = ItemObra.consultarPorId(Integer.parseInt(data));
            if(modelo != null){
                respuesta = new Respuesta(COMANDO.MS_SUCCE, modelo.toString(), ItemObra.getTabla());
            }else{
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "NO SE ENCONTRO ITEM OBRA", ItemObra.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ES NECESARIO UN NUMERO", ItemObra.getTabla());
        }
        return respuesta;
    }
    
    /**
     * Metodo que elimina un item obra
     * @param data trama de datos 
     * @return 
     */
    public static Respuesta eliminarItemObra(String data){
        Respuesta respuesta = null;
        ItemObra io = new ItemObra();
        //[1]
        data = data.replace("[", "");
        data = data.replace("]", "");
        if(FuncionesComunes.esNumero(data)){
            if(io.eliminar(Integer.parseInt(data))){
                respuesta = new Respuesta(COMANDO.MS_SUCCE, "ITEM OBRA ELIMINADA CORRECTAMENTE", ItemObra.getTabla());
            }else{
                respuesta = new Respuesta(COMANDO.MS_ERROR, "ITEM OBRA NO SE PUDO ELIMINAR", ItemObra.getTabla());
            }
        }else{
            respuesta = new Respuesta(COMANDO.MS_VALID, "ES NECESARIO UN NUMERO", ItemObra.getTabla());
        }
        return respuesta;
    }    
}