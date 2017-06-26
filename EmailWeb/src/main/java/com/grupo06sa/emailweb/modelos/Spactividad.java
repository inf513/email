package com.grupo06sa.emailweb.modelos;
// Generated 25-06-2017 07:52:36 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Spactividad generated by hbm2java
 */
public class Spactividad  implements java.io.Serializable {


     private int pkactividad;
     private Spordentrabajo spordentrabajo;
     private String codigo;
     private String descripcion;
     private Set spitemobras = new HashSet(0);

    public Spactividad() {
    }

	
    public Spactividad(int pkactividad, Spordentrabajo spordentrabajo, String codigo) {
        this.pkactividad = pkactividad;
        this.spordentrabajo = spordentrabajo;
        this.codigo = codigo;
    }
    public Spactividad(int pkactividad, Spordentrabajo spordentrabajo, String codigo, String descripcion, Set spitemobras) {
       this.pkactividad = pkactividad;
       this.spordentrabajo = spordentrabajo;
       this.codigo = codigo;
       this.descripcion = descripcion;
       this.spitemobras = spitemobras;
    }
   
    public int getPkactividad() {
        return this.pkactividad;
    }
    
    public void setPkactividad(int pkactividad) {
        this.pkactividad = pkactividad;
    }
    public Spordentrabajo getSpordentrabajo() {
        return this.spordentrabajo;
    }
    
    public void setSpordentrabajo(Spordentrabajo spordentrabajo) {
        this.spordentrabajo = spordentrabajo;
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
    public Set getSpitemobras() {
        return this.spitemobras;
    }
    
    public void setSpitemobras(Set spitemobras) {
        this.spitemobras = spitemobras;
    }




}

