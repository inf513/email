package siagro.datos.mapeo;
// Generated 01-10-2015 10:41:47 PM by Hibernate Tools 4.3.1



/**
 * Spimproductiva generated by hbm2java
 */
public class Spimproductiva  implements java.io.Serializable {


     private Integer pkImproductiva;
     private String codigo;
     private String descripcion;

    public Spimproductiva() {
    }

    public Spimproductiva(String codigo, String descripcion) {
       this.codigo = codigo;
       this.descripcion = descripcion;
    }
   
    public Integer getPkImproductiva() {
        return this.pkImproductiva;
    }
    
    public void setPkImproductiva(Integer pkImproductiva) {
        this.pkImproductiva = pkImproductiva;
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




}


