package com.grupo06sa.emailweb.negocios;

import com.grupo06sa.emailweb.modelos.Spactividad;
import com.grupo06sa.emailweb.modelos.Spordentrabajo;
import java.util.List;
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
            data += "Codigo de actividad maximo 2 caracteres </br>";
        }
        if(actividad.getDescripcion().length() > 50){
            data += "Descripcion de actividad maximo 50 caracteres </br>";
        }        
        if(actividad.getSpordentrabajo() == null){
            data += "Orden de trabajo no valida </br>";
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
        
        if(FuncionesComunes.esNumero(datos[0].trim())){
            actividad = new Spactividad();
            actividad.setPkactividad(Integer.valueOf(datos[0]));            
            if(FuncionesComunes.esNumero(datos[1].trim())){
                Spordentrabajo ot = OrdenTrabajo.consultarPorId(Integer.valueOf(datos[1].trim()));
                actividad.setSpordentrabajo(ot);
                if(datos[2].length()>0){
                    actividad.setCodigo(datos[2]);
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
     * Actualiza una actividad
     * @param actividad Los nuevos datos a modificar
     * @return 
     */
    public boolean actualizar(Spactividad actividad){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.update(actividad);            
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [Actividad.actualizar]: " + cause.getMessage());            
            return false;
        }
    }
    /**
     * elimina una actividad de acuerdo a su identificador
     * @param id Identificador primario de actividad
     * @return True si se elimino correctamente , en otro caso falso
     */
    public boolean eliminar(int id){
        Spactividad actividad = null;
        try {
            actividad = Actividad.consultarPorId(id);
            if(actividad !=null ){
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession();
                Transaction tx = session.beginTransaction();
                session.delete(actividad);
                tx.commit();
                session.close();
                return true;
            }else{
                return false;
            }
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [Actividad.eliminar]: " + cause.getMessage());            
            return false;
        }
    }
    /**
     * Obtiene una actividad de la base de datos en base a su id
     * @param id Identificador primario de base de datos
     * @return Modelo de datos
     */
    public static Spactividad consultarPorId(int id){
        Spactividad actividad = null;
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            actividad = (Spactividad) session.get(Spactividad.class, id);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            Throwable cause = e.getCause();            
            System.out.println("Error [Actividad.consultarPorId]: " + cause.getMessage());
        }
        return actividad;
    }
    public static String getTabla(){
        return "ACTIVIDADES";
    }
    public static List<Spactividad> listar(){
        List<Spactividad> lista = null;
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            lista = (List<Spactividad>) session.createQuery("SELECT p FROM Spactividad p").list();
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [Actividad.listar]: " + cause.getMessage());
        }
        return lista;
    }
}