/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo06sa.emailweb.negocios;

import com.grupo06sa.emailweb.modelos.Spactividad;
import com.grupo06sa.emailweb.modelos.Spcargo;
import com.grupo06sa.emailweb.modelos.Spordentrabajo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Actividad {
    
    public Actividad(){}
    
    /**
     * Valida si los campos de la actividad cumplen los requisitos necesarios
     * @param actividad modelo a verificar
     * @return 
     */
    public String validarActividad(Spactividad actividad){
        String data = "";
        if(actividad.getCodigo().length() > 2){
            data += "Codigo de actividad maximo 2 caracteres";
        }
        if(actividad.getDescripcion().length() > 50){
            data += "Descripcion de actividad maximo 50 caracteres";
        }        
        return data;
    }
    /**
     * Obtiene un modelo a partir de una trama
     * @param data trama de datos
     * @return 
     */
    public Spactividad getParser(String data){
        Spactividad actividad = null;
        //[id, codigo, descripcion]
        data = data.replace("[", "");
        data = data.replace("]", "");
        String[] datos = data.split(",");
        
        if(datos.length != 4) return actividad;
        
        if(FuncionesComunes.esNumero(datos[0])){
            actividad = new Spactividad();
            actividad.setPkactividad(Integer.valueOf(datos[0]));            
            if(FuncionesComunes.esNumero(datos[1])){
                Spordentrabajo ot = OrdenTrabajo.consultarPorId(Integer.valueOf(datos[1]));
                actividad.setSpordentrabajo(ot);                
                if(datos[2].length()>0){
                    actividad.setCodigo(datos[2]);
                }else{
                    if(datos[3].length()>0){
                        actividad.setDescripcion(datos[3]);
                    }                    
                }
            }
        }
        return actividad;
    }
    /**
     * adiciona una actividad a la base de datos
     * @param actividad Modelo de actividad
     * @return 
     */
    public boolean adicionar(Spactividad actividad){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.save(actividad);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [Actividad.adicionar]: " + cause.getMessage());
            return false;
        }
    }
    /**
     * Actualiza un cargo
     * @param cargo Los nuevos datos a modificar
     * @return 
     */
    public boolean actualizar(Spcargo cargo){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.update(cargo);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [Cargo.actualizar]: " + cause.getMessage());            
            return false;          

        }
    }
    /**
     * elimina un cargo de acuerdo a su identificador
     * @param id Identificador primario de cargo
     * @return True si se elimino correctamente , en otro caso falso
     */
    public boolean eliminar(int id){
        Spcargo cargo = null;
        try {
            cargo = this.consultarPorId(id);
            if(cargo !=null ){
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession();
                Transaction tx = session.beginTransaction();
                session.delete(cargo);
                tx.commit();
                session.close();
                return true;
            }else{
                return false;
            }
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [Cargo.eliminar]: " + cause.getMessage());            
            return false;
        }
    }
    /**
     * Obtiene un cargo de la base de datos en base a su id
     * @param id Identificador primario de base de datos
     * @return Modelo de datos
     */
    public Spcargo consultarPorId(int id){
        Spcargo cargo = null;
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            cargo = (Spcargo) session.get(Spcargo.class, id);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            Throwable cause = e.getCause();            
            System.out.println("Error [Cargo.consultarPorId]: " + cause.getMessage());            
        }
        return cargo;
    }

}
