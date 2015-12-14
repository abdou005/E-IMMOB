/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Abonne;
import model.Personne;

/**
 *
 * @author abdo
 */
@Stateless
public class AdminDao {
    @PersistenceContext( unitName = "Immobilier-ejbPU" )
    private EntityManager em;
    
   /* public int supAbonne(Abonne abonne){
     int n;
        Query req = em.createQuery("delete from Personne p where p.id=:x");
        n = req.setParameter("x", abonne.getId()).executeUpdate();
        return n;
    }
   public Personne addAdmin(Personne p){
        em.persist(p);
        return p;
    }
    public String genererCode(Personne p){
       String code=null;      
       Random ran = new Random();
       int valeur = 10 + ran.nextInt(200 - 10);
       code = (p.getNom().substring(0, 2)+p.getPrenom().substring(0, 2)).toUpperCase()+valeur;
       return code;
    }
     public Personne trouverAdminMail(String email, String psw) throws RuntimeException{

      Personne perso=null;
      Query req = em.createQuery("select p from Personne p where p.email=:x and p.pass=:y");
      req.setParameter("x", email);
      req.setParameter("y", psw);
      perso = (Personne) req.getSingleResult();
      //if (abonne==null) throw new RuntimeException("user introuvable");
      return perso; 
    }
     public Personne modifPersonne(Personne p){
        return em.merge(p);
    }
*/
}
