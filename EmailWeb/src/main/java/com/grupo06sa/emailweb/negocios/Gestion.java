/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo06sa.emailweb.negocios;

import java.text.SimpleDateFormat;
import com.grupo06sa.emailweb.modelos.Spgestion;
import java.text.ParseException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Gestion {

    public Gestion(){
        
    }
    public String validarGestion(Spgestion gestion){
        String data = "";
        if(gestion.getCodigo().length() > 2){
            data += "Codigo de cargo maximo 2 caracteres";
        }
        
        return data;
    }
    public Spgestion getParser(String data){
        Spgestion gestion = null;
        //[id, codigo, descripcion]
        data = data.replace("[", "");
        data = data.replace("]", "");
        String[] datos = data.split(",");
        
        if(datos.length != 3) return gestion;
        // id, codigo, fechaini, fechafin, estado
        if(FuncionesComunes.esNumero(datos[0])){
            gestion = new Spgestion();
            gestion.setPkgestion(Integer.valueOf(datos[0]));
            
            if(datos[1].length() > 0){
                gestion.setCodigo(datos[1]);
                
                if(datos[2].length() > 0){                    
                    try{
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");
                        gestion.setFechaini(formatter.parse(datos[2]));
                        if(datos[3].length() > 0){
                            gestion.setFechaini(formatter.parse(datos[3]));
                            gestion.setEstado('T');
                        }else{
                            gestion = null;
                        }
                    }catch(ParseException e){
                        System.out.println("error [Gestion.getParser]" + e.getMessage() );
                        gestion = null;
                    }
                }else{
                    gestion = null;
                }
            }else{
                gestion = null;
            }
        }else{
            gestion = null;
        }
        return gestion;
    }
    /**
     * adiciona una gestion en la base de datos
     * @param gestion  Modelo de gestion
     * @return 
     */
    public boolean adicionar(Spgestion gestion){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.save(gestion);          
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [gestion.adicionar]: " + cause.getMessage());
            return false;          
        }
    }
    /**
     * Actualiza una gestion
     * @param gestion Los nuevos datos a modificar
     * @return 
     */
    public boolean actualizar(Spgestion gestion){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.update(gestion);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [gestion.actualizar]: " + cause.getMessage());            
            return false;          

        }
    }
    /**
     * elimina un gestion de acuerdo a su identificador
     * @param id Identificador primario de cargo
     * @return True si se elimino correctamente, en otro caso falso
     */
    public boolean eliminar(int id){
        Spgestion gestion = null;
        try {
            gestion = Gestion.consultarPorId(id);
            if(gestion !=null ){
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession();
                Transaction tx = session.beginTransaction();
                session.delete(gestion);
                tx.commit();
                session.close();
                return true;
            }else{
                return false;
            }
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [Gestion.eliminar]: " + cause.getMessage());            
            return false;
        }
    }
    /**
     * Obtiene una gestion de la base de datos en base a su id
     * @param id Identificador primario de base de datos
     * @return Modelo de datos
     */
    public static Spgestion consultarPorId(int id){
        Spgestion gestion = null;
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            gestion = (Spgestion) session.get(Spgestion.class, id);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            Throwable cause = e.getCause();            
            System.out.println("Error [Gestion.consultarPorId]: " + cause.getMessage());            
        }
        return gestion;
    }
    
}
