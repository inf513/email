/*
 * dfffffffffffffffffffffffffffffffffff
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo06sa.emailweb.negocios;
import  com.grupo06sa.emailweb.modelos.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Cargo{

    public Cargo(){};
    
    public String validarCargo(Spcargo cargo){
        String data = "";
        if(cargo.getCodigo().length() > 3){
            data += "Codigo de cargo maximo 3 caracteres";
        }
        if(cargo.getDescripcion().length() > 50){
            data += "Codigo de cargo maximo 50 caracteres";
        }
        
        return data;
    }
    public Spcargo getParser(String data){
        Spcargo cargo = null;
        //[id, codigo, descripcion]
        data = data.replace("[", "");
        data = data.replace("]", "");
        String[] datos = data.split(",");        
        
        if(datos.length != 3) return cargo;
        
        if(FuncionesComunes.esNumero(datos[0])){
            cargo = new Spcargo();
            cargo.setPkcargo(Integer.valueOf(datos[0]));
            
            if(datos[1].length() > 0){
                cargo.setCodigo(datos[1]);
                
                if(datos[2].length()>0){
                    cargo.setDescripcion(datos[2]);
                }else{
                    cargo = null;
                }
            }else{
                cargo = null;
            }
        }else{
            cargo = null;
        }
        return cargo;
    }
    /**
     * adiciona un cargo en la base de datos
     * @param cargo Modelo de cargo
     * @return 
     */
    public boolean adicionar(Spcargo cargo){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.save(cargo);          
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [Cargo.adicionar]: " + cause.getMessage());
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
