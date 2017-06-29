/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo06sa.emailweb.negocios;

import com.grupo06sa.emailweb.modelos.Spcargo;
import com.grupo06sa.emailweb.modelos.Spordentrabajo;
import com.grupo06sa.emailweb.modelos.Sppersonal;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author gabriel
 */
public class Personal {
    
    public  Personal(){};
    public String validarPersonal(Sppersonal per){
     String data = "";
     
      
   
         if(per.getSpcargo()== null){
            data += "Codigo de personal necesario";
        }
        if(per.getSpordentrabajo()== null){
            data += "La orden de trabajo es necesario";
        }
        if(per.getFechaingreso()== null){
            data += "Fecha de ingresa es necesario";
        }
        if (per.getNombrecomp().length()<=0) {
            data += "NOmbre Copleto No valido";
        }
        
        if (per.getApellidos().length()<= 0) {
            data += "Apellido invalido";
        }
        
        if (per.getDireccion().length() <= 0) {
            data += "La direccion No es Valida";
            
        }
        
        if (per.getTelefono().length()>8) {
            data += "Numero de telefono maximo 8 numeros";
        }
        
        if (per.getEmail().length()>25) {
            data += "Email maximo 25 ";
        }
        
        if (per.getCi().length()>7) {
            data += "El ci maximo 7 ";
        }
        if (per.getFechanac()== null) {
            data = "Fecha de Nacimiento Necesaria";
        }
        
        return data;
       
     
     }
    
    public Sppersonal getParser(String data){
        Sppersonal per = null;
        //[id,idcargo,idordentrabajo,fechaingreso, nombrecomp,apellidos, direccion, telefono,email, ci,fechanac
        data = data.replace("[", "");
        data = data.replace("]", "");
        String[] datos = data.split(",");        
        
        if(datos.length != 11) return per;
        
        if(FuncionesComunes.esNumero(datos[0])){
            per = new Sppersonal();
            per.setPkpersonal(Integer.valueOf(datos[0]));
            
            if(FuncionesComunes.esNumero(datos[1].trim())){
                Spcargo carg= Cargo.consultarPorId(Integer.valueOf(datos[1].trim()));
                          
                per.setSpcargo(carg);
                
                
                if (FuncionesComunes.esNumero(datos[2].trim())) {
                    Spordentrabajo odt = OrdenTrabajo.consultarPorId(Integer.valueOf(datos[2].trim()));
                    //Spordentrabajo odt= OrdenTrabajo.consultarPorId(datos[2].trim());
                    per.setSpordentrabajo(odt);
                    if (FuncionesComunes.esFecha(datos[3].trim())) {
                        per.setFechaingreso(FuncionesComunes.getFecha(datos[3].trim()));
                        
                        per.setNombrecomp(datos[4]);
                        per.setApellidos(datos[5]);
                        per.setDireccion(datos[6]);
                        per.setTelefono(datos[7]);
                        per.setEmail(datos[8]);
                        if (FuncionesComunes.esFecha(datos[9].trim())) {
                            per.setFechanac(FuncionesComunes.getFecha(datos[9].trim()));
                            
                        }
                            
                        }
                    }
                    
                }
            }
        return per;
                  
    }
    
    public  boolean adicionar(Sppersonal per){
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.save(per);          
            tx.commit();
            session.close();
            return true;
            
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [personal.adicionar]: " + cause.getMessage());
            return false;
        }
    }
    
    
    public boolean actualizar(Sppersonal per){
    try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session;
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.update(per);
            tx.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [Persona.actualizar]: " + cause.getMessage());            
            return false;          

        }
    }
    
    public  boolean  eliminar(int i){
         Sppersonal pers = null;
        try {
            pers= Personal.consultarPer(i);
            if(pers != null){
                SessionFactory factory = HibernateUtil.getSessionFactory();
                Session session = factory.openSession();
                Transaction tx = session.beginTransaction();
                session.delete(pers);
                tx.commit();
                session.close();
                return true;
            }else{
                return false;
            }
            }                  
            catch (HibernateException e) {
            Throwable cause = e.getCause();
            System.out.println("Error [personal.eliminar]: " + cause.getMessage());            
            return false;
        }
    
    }
            
    public static Sppersonal consultarPer(int id){
        Sppersonal pers= null;
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            pers = (Sppersonal) session.get(Sppersonal.class,id);
                  
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            Throwable cause = e.getCause();            
            System.out.println("Error [personal.consultarPorId]: " + cause.getMessage()); 
        }
        return pers;
         
    }
   
    }
            
            
    
            
    
  
        
   