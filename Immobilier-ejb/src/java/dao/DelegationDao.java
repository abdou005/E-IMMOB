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
import model.Delegation;
import model.Gov;

/**
 *
 * @author abdo
 */
@Stateless
public class DelegationDao {
    @PersistenceContext( unitName = "Immobilier-ejbPU" )
    private EntityManager em;
     public Delegation addDel(Delegation d){
        em.persist(d);
        return d;
    }
     public Delegation trvDel(Long id){
         Delegation delg= null;
     Query req = em.createQuery("select d from Delegation d where d.id=:x");
     req.setParameter("x", id);
     delg = (Delegation)req.getSingleResult();
     return delg;
     }
     public Delegation modif(Delegation d){
       return em.merge(d);
     }  
     public int supDelegAnno(Delegation d){
        int n;
        Query req = em.createQuery("delete from Delegation d where d.id=:x");
        n = req.setParameter("x", d.getId()).executeUpdate();
        return n;
    }
   
}
