/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.AnnonceBien;
import model.Commentaire;
/**
 *
 * @author abdo
 */
@Stateless
public class CommentaireDao {
    @PersistenceContext( unitName = "Immobilier-ejbPU" )
    private EntityManager em;
    public Commentaire addCommentaire(Commentaire c){
          em.persist(c);
        return c;
    }
    public List<Commentaire> getsAllComment(){
       List<Commentaire> l = new ArrayList<Commentaire>();
       Query req = em.createQuery("select c from Commentaire c");
       l=req.getResultList();
       return l;
    }
     public List<Commentaire> getsAllCommentBien(int idann){
       List<Commentaire> l = new ArrayList<Commentaire>();
       Query req = em.createQuery("select c from Commentaire c where c.bien.id=:x");
       req.setParameter("x", idann);
       l=req.getResultList();
       return l;
    }
    public Long getNbrCommentAnnonce(Long idann){
         Long n;
         Query req = em.createQuery("select COUNT(c) from Commentaire c where c.bien.id=:x");
         req.setParameter("x", idann);
         n=(Long)req.getSingleResult();
         return n;
     }
     public Long getCountComment(){
    Long n;
    Query req = em.createQuery("select COUNT(c) from Commentaire c");
    n=(Long) req.getSingleResult();
    return n ;
    }
    public int supCommentaire(AnnonceBien b){
    int n=0;
    Query req =em.createQuery("delete from Commentaire c where c.bien.id=:x");
    n = req.setParameter("x", b.getId()).executeUpdate();
    return n;
    }
    public int supUnCommentaire(Commentaire c){
    int n=0;
    Query req =em.createQuery("delete from Commentaire c where c.id=:x");
    n = req.setParameter("x", c.getId()).executeUpdate();
    return n;
    }
    
}
