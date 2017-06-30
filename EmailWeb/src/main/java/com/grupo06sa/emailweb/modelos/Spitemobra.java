package com.grupo06sa.emailweb.modelos;
// Generated 25-06-2017 07:52:36 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Spitemobra generated by hbm2java
 */
public class Spitemobra  implements java.io.Serializable {


     private int pkitemobra;
     private Spactividad spactividad;
     private Spordentrabajo spordentrabajo;
     private Sppoligono sppoligono;
     private String codigo;
     private String descripcion;
     private BigDecimal areatrab;
     private BigDecimal rendimiento;
     private Set spdetproductivas = new HashSet(0);

    public Spitemobra() {
    }

	
    public Spitemobra(int pkitemobra, Spactividad spactividad, Spordentrabajo spordentrabajo, Sppoligono sppoligono, String codigo) {
        this.pkitemobra = pkitemobra;
        this.spactividad = spactividad;
        this.spordentrabajo = spordentrabajo;
        this.sppoligono = sppoligono;
        this.codigo = codigo;
    }
    public Spitemobra(int pkitemobra, Spactividad spactividad, Spordentrabajo spordentrabajo, Sppoligono sppoligono, String codigo, String descripcion, BigDecimal areatrab, BigDecimal rendimiento, Set spdetproductivas) {
       this.pkitemobra = pkitemobra;
       this.spactividad = spactividad;
       this.spordentrabajo = spordentrabajo;
       this.sppoligono = sppoligono;
       this.codigo = codigo;
       this.descripcion = descripcion;
       this.areatrab = areatrab;
       this.rendimiento = rendimiento;
       this.spdetproductivas = spdetproductivas;
    }
   
    public int getPkitemobra() {
        return this.pkitemobra;
    }
    
    public void setPkitemobra(int pkitemobra) {
        this.pkitemobra = pkitemobra;
    }
    public Spactividad getSpactividad() {
        return this.spactividad;
    }
    
    public void setSpactividad(Spactividad spactividad) {
        this.spactividad = spactividad;
    }
    public Spordentrabajo getSpordentrabajo() {
        return this.spordentrabajo;
    }
    
    public void setSpordentrabajo(Spordentrabajo spordentrabajo) {
        this.spordentrabajo = spordentrabajo;
    }
    public Sppoligono getSppoligono() {
        return this.sppoligono;
    }
    
    public void setSppoligono(Sppoligono sppoligono) {
        this.sppoligono = sppoligono;
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
    public BigDecimal getAreatrab() {
        return this.areatrab;
    }
    
    public void setAreatrab(BigDecimal areatrab) {
        this.areatrab = areatrab;
    }
    public BigDecimal getRendimiento() {
        return this.rendimiento;
    }
    
    public void setRendimiento(BigDecimal rendimiento) {
        this.rendimiento = rendimiento;
    }
    public Set getSpdetproductivas() {
        return this.spdetproductivas;
    }
    
    public void setSpdetproductivas(Set spdetproductivas) {
        this.spdetproductivas = spdetproductivas;
    }
    
    @Override
    public String toString(){
        return "[id : " + this.getPkitemobra() + ", codigo : " + this.getCodigo() + ", descripcion : " + this.getDescripcion() + "]";
    }
}