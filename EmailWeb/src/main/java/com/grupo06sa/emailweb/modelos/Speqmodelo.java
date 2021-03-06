package com.grupo06sa.emailweb.modelos;
// Generated 25-06-2017 07:52:36 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Speqmodelo generated by hbm2java
 */
public class Speqmodelo  implements java.io.Serializable {


     private int pkeqmodelo;
     private Speqtipo speqtipo;
     private String codigo;
     private String descripcion;
     private Set spequipos = new HashSet(0);

    public Speqmodelo() {
    }

	
    public Speqmodelo(int pkeqmodelo, Speqtipo speqtipo, String codigo) {
        this.pkeqmodelo = pkeqmodelo;
        this.speqtipo = speqtipo;
        this.codigo = codigo;
    }
    public Speqmodelo(int pkeqmodelo, Speqtipo speqtipo, String codigo, String descripcion, Set spequipos) {
       this.pkeqmodelo = pkeqmodelo;
       this.speqtipo = speqtipo;
       this.codigo = codigo;
       this.descripcion = descripcion;
       this.spequipos = spequipos;
    }
   
    public int getPkeqmodelo() {
        return this.pkeqmodelo;
    }
    
    public void setPkeqmodelo(int pkeqmodelo) {
        this.pkeqmodelo = pkeqmodelo;
    }
    public Speqtipo getSpeqtipo() {
        return this.speqtipo;
    }
    
    public void setSpeqtipo(Speqtipo speqtipo) {
        this.speqtipo = speqtipo;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getSpequipos() {
        return this.spequipos;
    }
    
    public void setSpequipos(Set spequipos) {
        this.spequipos = spequipos;
    }




}


