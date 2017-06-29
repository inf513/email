package com.grupo06sa.emailweb.negocios;

import com.grupo06sa.emailweb.modelos.Spactividad;
import com.grupo06sa.emailweb.modelos.Spitemobra;
import com.grupo06sa.emailweb.modelos.Spordentrabajo;
import com.grupo06sa.emailweb.modelos.Sppoligono;
import java.math.BigDecimal;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class ItemObra {
    
    public ItemObra(){}
    
    /**
     * valida item obra
     * @param io modelo item de obra
     * @return 
     */
    public String validarItemObra(Spitemobra io){
        String data = "";
        if(io.getCodigo().length() > 6){
            data += "Codigo de Item obra maximo 6 caracteres ";
        }
        if(io.getDescripcion().length() > 50){
            data += "Descripcion maxima 50 caracteres ";
        }
        if(io.getSpactividad() == null){
            data += "Actividad no encontrada";
        }
        if(io.getSppoligono() == null){
            data += "Poligono no encontrado";
        }
        if(io.getSpordentrabajo() == null){
            data += "Orden de trabajo no encontrada";
        }
        return data;
    }
    /**
     * Metodo que valida la trama de entrada y devuelve el modelo
     * @param data la trama que se genera
     * @return 
     */
    public Spitemobra getParser(String data){
        Spitemobra io = null;        
        //ID_IO|IDordentrabajo|IDctividad|IDpoligono|descripcion|areatrab|rendimiento
        data = data.replace("[", "");
        data = data.replace("]", "");
        String[] datos = data.split(",");
        
        if(datos.length != 7) return io;
        
        if(FuncionesComunes.esNumero(datos[0])){
            io = new Spitemobra();
            io.setPkitemobra(Integer.valueOf(datos[0].trim()));
            if(FuncionesComunes.esNumero(datos[1])){
                Spordentrabajo o = OrdenTrabajo.consultarPorId(Integer.parseInt(datos[1].trim()));
                io.setSpordentrabajo(o);                
                if(FuncionesComunes.esNumero(datos[2].trim())){ // actividad
                    Spactividad actividad = Actividad.consultarPorId(Integer.parseInt(datos[2].trim()));
                    io.setSpactividad(actividad);
                    if(FuncionesComunes.esNumero(datos[3].trim())){ // poligono
                        Sppoligono poligono = Poligono.consultarPorId(Integer.parseInt(datos[3].trim()));
                        io.setSppoligono(poligono);
                        if(datos[4].length() > 0){ // descripcion
                            io.setCodigo(poligono.getCodigo().trim() + "-" + actividad.getCodigo().trim());
                            io.setDescripcion(datos[4]);
                            if(FuncionesComunes.esNumero(datos[5])){
                                io.setAreatrab(new BigDecimal(datos[5].trim()));
                                if(FuncionesComunes.esNumero(datos[6])){
                                    io.setRendimiento(new BigDecimal(datos[6].trim()));
                                }
                            }
                        }
                    }
                }
            }
        }
        return io;
    }
    /**
     * adiciona un item obra en la base de datos
     * @param io Modelo de trabajo
     * @return 
     */
    public boolean adicionar(Spitemobra io){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.save(io);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [ItemObra.adicionar]: " + cause.getMessage());
            return false;          
        }
    }
    /**
     * Actualiza un item obra
     * @param io Los nuevos datos a modificar
     * @return 
     */
    public boolean actualizar(Spitemobra io){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.update(io);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [ItemObra.actualizar]: " + cause.getMessage());            
            return false;          

        }
    }
    /**
     * Elimina un item obra de acuerdo a su identificador
     * @param id Identificador primario de cargo
     * @return True si se elimino correctamente , en otro caso falso
     */
    public boolean eliminar(int id){
        Spitemobra io = null;
        try {
            io = ItemObra.consultarPorId(id);
            if(io !=null ){
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession();
                Transaction tx = session.beginTransaction();
                session.delete(io);
                tx.commit();
                session.close();
                return true;
            }else{
                return false;
            }
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [ItemObra.eliminar]: " + cause.getMessage());
            return false;
        }
    }
    /**
     * Obtiene un item obra de la base de datos en base a su id
     * @param id Identificador primario de base de datos
     * @return Modelo de datos
     */
    public static Spitemobra consultarPorId(int id){
        Spitemobra io = null;
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            io = (Spitemobra) session.get(Spitemobra.class, id);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            Throwable cause = e.getCause();            
            System.out.println("Error [ItemObra.consultarPorId]: " + cause.getMessage());
        }
        return io;
    }    
}