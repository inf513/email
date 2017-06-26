/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siagro.datos.mapeo;

/**
 *
 * @author limbert
 */
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
public class SpimproductivaDAO {
    private Session session;
    private Transaction trans;
    
    public SpimproductivaDAO(){
        
    }
    
    private void beginTransaction() throws HibernateException {
       session =  HibernateUtil.getSessionFactory().openSession();
       trans = session.beginTransaction();
    }
    private void commintTransaction() throws HibernateException{
        trans.commit();
    }
    private void rollbackTransaction(HibernateException he) throws HibernateException{
        trans.rollback();
        throw new HibernateException("Error en capa de datos", he);
    }
    
    public long guardar( Spimproductiva improductiva ){
        long id = 0 ;
       try{
           beginTransaction();
           //id = (Long) session.save(improductiva);
           session.save(improductiva);
           commintTransaction();
       }catch(HibernateException he){
           rollbackTransaction(he);
           throw he;
       }finally{
           session.close();
       }
       
       return id;
    }
    
}
