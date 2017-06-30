package com.grupo06sa.emailweb.negocios;

import com.grupo06sa.emailweb.modelos.Spordentrabajo;
import com.grupo06sa.emailweb.modelos.Sppoligono;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Poligono {

    public Poligono(){}
    
    /**
     * Valida si los campos del poligono cumplen los requisitos necesarios
     * @param poligono modelo a verificar
     * @return 
     */
    public String validarPoligono(Sppoligono poligono){
        String data = "";
        if(poligono.getCodigo().length() > 3){
            data += "Codigo de Poligono maximo 3 caracteres";
        }
        if(poligono.getDescripcion().length() > 50){
            data += "Descripcion de poligono maximo 50 caracteres";
        }
        if(poligono.getSpordentrabajo() == null){
            data += "Orden de trabajo no encontrada";
        }
        
        return data;
    }
    /**
     * Obtiene un modelo a partir de una trama
     * @param data trama de datos
     * @return 
     */
    public Sppoligono getParser(String data){
        Sppoligono poligono = null;
        //[id, codigo, descripcion]
        data = data.replace("[", "");
        data = data.replace("]", "");
        String[] datos = data.split(",");
        
        if(datos.length != 4) return poligono;
        
        if(FuncionesComunes.esNumero(datos[0].trim())){
            poligono = new Sppoligono();
            poligono.setPkpoligono(Integer.valueOf(datos[0]));
            if(FuncionesComunes.esNumero(datos[1].trim())){
                Spordentrabajo ot = OrdenTrabajo.consultarPorId(Integer.valueOf(datos[1].trim()));
                poligono.setSpordentrabajo(ot);
                if(datos[2].length()>0){
                    poligono.setCodigo(datos[2]);
                    if(datos[3].length()>0){
                        poligono.setDescripcion(datos[3]);
                    }
                }
            }
        }
        return poligono;
    }
    /**
     * adiciona un poligono a la base de datos
     * @param poligono Modelo de poligono
     * @return 
     */
    public boolean adicionar(Sppoligono poligono){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.save(poligono);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [Poligono.adicionar]: " + cause.getMessage());
            return false;
        }
    }
    /**
     * Actualiza una poligono
     * @param poligono Los nuevos datos a modificar
     * @return 
     */
    public boolean actualizar(Sppoligono poligono){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.update(poligono);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [Poligono.actualizar]: " + cause.getMessage());            
            return false;
        }
    }
    /**
     * elimina un poligono de acuerdo a su identificador
     * @param id Identificador primario del poligono
     * @return True si se elimino correctamente , en otro caso falso
     */
    public boolean eliminar(int id){
        Sppoligono poligono = null;
        try {
            poligono = Poligono.consultarPorId(id);
            if(poligono !=null ){
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession();
                Transaction tx = session.beginTransaction();
                session.delete(poligono);
                tx.commit();
                session.close();
                return true;
            }else{
                return false;
            }
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [Poligono.eliminar]: " + cause.getMessage());
            return false;
        }
    }
    /**
     * Obtiene un poligono de la base de datos en base a su id
     * @param id Identificador primario de base de datos
     * @return Modelo de datos
     */
    public static Sppoligono consultarPorId(int id){
        Sppoligono poligono = null;
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            poligono = (Sppoligono) session.get(Sppoligono.class, id);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            Throwable cause = e.getCause();            
            System.out.println("Error [Poligono.consultarPorId]: " + cause.getMessage());
        }
        return poligono;
    }
    public static String getTabla(){
        return "POLIGONOS";
    }
    public static List<Sppoligono> listar(){
        List<Sppoligono> poligonos = null;
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            poligonos = (List<Sppoligono>) session.createQuery("SELECT p FROM Sppoligono p").list();
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [Poligono.listar]: " + cause.getMessage());
        }
        return poligonos;
    }    
}
