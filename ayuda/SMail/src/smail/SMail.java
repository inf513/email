/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smail;

/**
 *
 * @author limbert
 */
import siagro.datos.mapeo.SpimproductivaDAO;
import siagro.datos.mapeo.Spimproductiva;
public class SMail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Spimproductiva obj = new Spimproductiva("0002", "INGRESO DESDE JAVA");
        
        SpimproductivaDAO dao = new SpimproductivaDAO();
        dao.guardar(obj);
    }
    
}
