/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo06sa.emailweb.negocios;

import com.grupo06sa.emailweb.modelos.Spgestion;
import com.grupo06sa.emailweb.modelos.Spordentrabajo;
import java.math.BigDecimal;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class OrdenTrabajo {
    
    public OrdenTrabajo(){}
    
    /**
     * valida la orden de trabajo
     * @param ot
     * @return 
     */
    public String validarOrdenTrabajo(Spordentrabajo ot){
        String data = "";
        if(ot.getCodigo().length() > 3){
            data += "Codigo de cargo maximo 3 caracteres ";
        }
        if(ot.getSpgestion() == null){
            data += "Gestion es necesaria ";
        }
        if(ot.getNombre().length() <= 0){
            data += "Nombre de orden de trabajo no valido";
        }
        if(ot.getSupervisor().length() <= 0){
            data += "Nombre de supervisor no valido";
        }        
        return data;
    }
    public Spordentrabajo getParser(String data){
        Spordentrabajo ot = null;
        //   int            int         str   str       str         int          char    str          
        //[pkordentrabajo, idgestion, codigo, nombre, supervisor, areaestimada, estado, data]
        data = data.replace("[", "");
        data = data.replace("]", "");
        String[] datos = data.split(",");
        
        if(datos.length != 8) return ot;
        
        if(FuncionesComunes.esNumero(datos[0])){
            ot = new Spordentrabajo();
            ot.setPkordentrabajo(Integer.valueOf(datos[0]));            
            if(FuncionesComunes.esNumero(datos[1])){
                Spgestion g = Gestion.consultarPorId(Integer.parseInt(datos[1]));
                ot.setSpgestion(g);
                if(datos[2].length()>0){ // codigo
                    ot.setCodigo(datos[2]);
                    if(datos[3].length()>0){ // nombre
                        ot.setNombre(datos[3]);
                        if(datos[4].length()>0){//supervisor
                            ot.setSupervisor(datos[4]);
                            if(FuncionesComunes.esNumero(datos[5])){
                                ot.setAreaestimada( new BigDecimal(datos[5]));
                                ot.setEstado('T');
                                ot.setData(ot.getCodigo()+"-"+g.getCodigo());
                            }
                        }
                    }
                }
            }
        }
        return ot;
    }
    /**
     * adiciona una orden de trabajo en la base de datos
     * @param cargo Modelo de trabajo
     * @return 
     */
    public boolean adicionar(Spordentrabajo ot){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.save(ot);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [OrdenTrabajo.adicionar]: " + cause.getMessage());
            return false;          
        }
    }
    /**
     * Actualiza un orden
     * @param cargo Los nuevos datos a modificar
     * @return 
     */
    public boolean actualizar(Spordentrabajo ot){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.update(ot);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [OrdenTrabajo.actualizar]: " + cause.getMessage());            
            return false;          

        }
    }
    /**
     * elimina una ordem de acuerdo a su identificador
     * @param id Identificador primario de cargo
     * @return True si se elimino correctamente , en otro caso falso
     */
    public boolean eliminar(int id){
        Spordentrabajo ot = null;
        try {
            ot = this.consultarPorId(id);
            if(ot !=null ){
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession();
                Transaction tx = session.beginTransaction();
                session.delete(ot);
                tx.commit();
                session.close();
                return true;
            }else{
                return false;
            }
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [OrdenTrabajo.eliminar]: " + cause.getMessage());            
            return false;
        }
    }
    /**
     * Obtiene un ot de la base de datos en base a su id
     * @param id Identificador primario de base de datos
     * @return Modelo de datos
     */
    public Spordentrabajo consultarPorId(int id){
        Spordentrabajo ot = null;
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            ot = (Spordentrabajo) session.get(Spordentrabajo.class, id);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            Throwable cause = e.getCause();            
            System.out.println("Error [OrdenTrabajo.consultarPorId]: " + cause.getMessage());            
        }
        return ot;
    }
}