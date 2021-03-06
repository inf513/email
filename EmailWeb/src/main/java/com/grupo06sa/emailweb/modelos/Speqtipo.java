package com.grupo06sa.emailweb.modelos;
// Generated 25-06-2017 07:52:36 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Speqtipo generated by hbm2java
 */
public class Speqtipo  implements java.io.Serializable {


     private int pkeqtipo;
     private String codigo;
     private String descripcion;
     private Set speqmodelos = new HashSet(0);
     private Set spequipos = new HashSet(0);

    public Speqtipo() {
    }

	
    public Speqtipo(int pkeqtipo, String codigo) {
        this.pkeqtipo = pkeqtipo;
        this.codigo = codigo;
    }
    public Speqtipo(int pkeqtipo, String codigo, String descripcion, Set speqmodelos, Set spequipos) {
       this.pkeqtipo = pkeqtipo;
       this.codigo = codigo;
       this.descripcion = descripcion;
       this.speqmodelos = speqmodelos;
       this.spequipos = spequipos;
    }
   
    public int getPkeqtipo() {
        return this.pkeqtipo;
    }
    
    public void setPkeqtipo(int pkeqtipo) {
        this.pkeqtipo = pkeqtipo;
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
    public Set getSpeqmodelos() {
        return this.speqmodelos;
    }
    
    public void setSpeqmodelos(Set speqmodelos) {
        this.speqmodelos = speqmodelos;
    }
    public Set getSpequipos() {
        return this.spequipos;
    }
    
    public void setSpequipos(Set spequipos) {
        this.spequipos = spequipos;
    }




}


