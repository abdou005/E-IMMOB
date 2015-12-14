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
import model.AnnonceType;

/**
 *
 * @author abdo
 */
@Stateless
public class AnnonceTypeDao {
    @PersistenceContext( unitName = "Immobilier-ejbPU" )
    private EntityManager em;
     public AnnonceType addTypeAnno(AnnonceType anntype){
        em.persist(anntype);
        return anntype;
    }
    public int supTypeAnno(AnnonceType anntype){
        int n;
        Query req = em.createQuery("delete from AnnonceType t where t.id=:x");
        n = req.setParameter("x", anntype.getId()).executeUpdate();
        return n;
    }
}
