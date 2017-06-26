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
    
    /**
     * adiciona un cargo en la base de datos
     * @param cargo Modelo de cargo
     */
    public void adicionar(Spcargo cargo){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.save(cargo);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println("erorrrr:");
            System.out.println("erro : " + e.getMessage());
        }
    }
    /**
     * Actualiza un cargo
     * @param cargo Los nuevos datos a modificar
     */
    public void actualizar(Spcargo cargo){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.update(cargo);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println("erorrrr:");
            System.out.println("erro : " + e.getMessage());
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
            System.out.println("error eliminar :" + e.getMessage());
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
            System.out.println("error consultar :" + e.getMessage());
        }
        return cargo;
    }
    
    public static void main(String str[]){
        Cargo o = new Cargo();
        System.out.println("estado :" + String.valueOf(o.eliminar(5)));
        System.exit(0);
    }
}
