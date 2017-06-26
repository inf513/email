/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo06sa.emailweb.negocios;

import com.grupo06sa.emailweb.modelos.Spordentrabajo;
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
     * adiciona un cargo en la base de datos
     * @param ot Modelo de orden de trabajo
     */
    public void adicionar(Spordentrabajo ot){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.save(ot);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println("Error [OrdenTrabajo.adicionar]: " + e.getMessage());
        }
    }
    /**
     * Actualiza una orden de trabajo
     * @param ot Los nuevos datos a modificar
     */
    public void actualizar(Spordentrabajo ot){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.update(ot);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println("Error [OrdenTrabajo.actualizar]: " + e.getMessage());
        }
    }
    /**
     * elimina un una orden de trabajo de acuerdo a su identificador
     * @param id Identificador primario de ot
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
            System.out.println("Error [OrdenTrabajo.eliminar]: " + e.getMessage());
            return false;
        }
    }
    /**
     * Obtiene una orden de trabajo de la base de datos en base a su id
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
            System.out.println("Error [OrdenTrabajo.consultarPorId]: " + e.getMessage());
        }
        return ot;
    }    
}
