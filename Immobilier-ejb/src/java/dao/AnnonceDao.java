/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.AnnonceBien;
/**
 *
 * @author abdo
 */
@Stateless
public class AnnonceDao {
    @PersistenceContext( unitName = "Immobilier-ejbPU" )
    private EntityManager em;
    public AnnonceBien addAnnonceBien(AnnonceBien annonceBien){
         em.persist(annonceBien);
        return annonceBien;
    }
    public AnnonceBien modifAnnonceBien(AnnonceBien annonceBien){
        
    return em.merge(annonceBien);
    }
    public int supAnnonceBien(AnnonceBien ann){
        int n;
    Query req = em.createQuery("delete from AnnonceBien ann where ann.id=:x");
     n = req.setParameter("x", ann.getId()).executeUpdate();
     return n;
    }
   /* public AnnonceBien trvAnnonceBien(AnnonceBien ann){
        AnnonceBien annb=null;
      Query req = em.createQuery("select ann from AnnonceBien ann where ann.=:x");
      req.setParameter("x", email);
      abonne = (Abonne) req.getSingleResult();
    
    }*/
}
