/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo06sa.emailweb.negocios;

import com.grupo06sa.emailweb.modelos.Spcargo;
import com.grupo06sa.emailweb.modelos.Spgestion;
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
     /**
     * adiciona una gestion en la base de datos
     * @param gestion Modelo de gestion
     */
    public void adicionar(Spcargo gestion){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.save(gestion);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println("Error [Gestion.adicionar]: " + e.getMessage());
        }
    }
    /**
     * Actualiza una gestion
     * @param gestion Los nuevos datos a modificar
     */
    public void actualizar(Spgestion gestion){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.update(gestion);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println("Error [Gestion.actualizar]: " + e.getMessage());
        }
    }
    /**
     * elimina una gestion de acuerdo a su identificador
     * @param id Identificador primario de gestion
     * @return True si se elimino correctamente , en otro caso falso
     */
    public boolean eliminar(int id){
        Spgestion gestion = null;
        try {
            gestion = this.consultarPorId(id);
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
            System.out.println("Error [Gestion.eliminar]: " + e.getMessage());
            return false;
        }
    }
    /**
     * Obtiene una gestion de la base de datos en base a su id
     * @param id Identificador primario de base de datos
     * @return Modelo de datos
     */
    public Spgestion consultarPorId(int id){
        Spgestion gestion = null;
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            gestion = (Spgestion) session.get(Spgestion.class, id);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println("Error [Gestion.consultarPorId]: " + e.getMessage());
        }
        return gestion;
    }
}
