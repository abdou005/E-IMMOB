/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Abonne;
/**
 *
 * @author abdo
 */
@Stateless
public class UtilisateurDao {
    @PersistenceContext( unitName = "Immobilier-ejbPU" )
    private EntityManager em;
   
    public Abonne addUser(Abonne p){
        em.persist(p);
        return p;
    }
    
    public List<Abonne> getsAllUser(boolean isAdm){
        List<Abonne> abonnes = new ArrayList<Abonne>();
        Query req = em.createQuery("select p from Abonne p where p.admin=:x ORDER BY p.prenom ASC");
        req.setParameter("x", isAdm);
        abonnes = req.getResultList();
        return abonnes;
    }
    public Abonne trouverUser(String email){
       Abonne abonne=null;
      Query req = em.createQuery("select p from Personne p where p.email=:x");
      req.setParameter("x", email);
      abonne = (Abonne) req.getSingleResult();
      return abonne; 
    }
    public Abonne trvAbonneId(Long id){
        Abonne abonne = new Abonne();        
        Query req = em.createQuery("select a from Abonne a where a.id=:x");
        req.setParameter("x", id);
        abonne = (Abonne)req.getSingleResult();
        return abonne;
     }
     public Abonne trouverUserMail(String email, String psw) throws RuntimeException{

       Abonne abonne=null;
      Query req = em.createQuery("select p from Personne p where p.email=:x and p.pass=:y");
      req.setParameter("x", email);
      req.setParameter("y", psw);
      abonne = (Abonne) req.getSingleResult();
      //if (abonne==null) throw new RuntimeException("user introuvable");
      return abonne; 
    }
    public int supPersonne(Abonne a){
        int n;
        Query req = em.createQuery("delete from Personne p where p.id=:x");
        n = req.setParameter("x", a.getId()).executeUpdate();
        return n;
    }
    public Abonne modifPersonne(Abonne a){
        return em.merge(a);
    }
    public String genererCode(Abonne a){
        String code=null;      
        Random ran = new Random();
       int valeur = 10 + ran.nextInt(200 - 10);
       code = (a.getNom().substring(0, 2)+a.getPrenom().substring(0, 2)).toUpperCase()+valeur;
       return code;
    }
    public Long getCountAbonne(boolean isAdm){
    Long n;
    Query req = em.createQuery("select COUNT(a) from Abonne a where a.admin=:x");
    req.setParameter("x", isAdm);
    n=(Long) req.getSingleResult();
    return n ;
    }
}
