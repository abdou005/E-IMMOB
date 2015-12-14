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
import model.AnnonceType;
import model.Gov;
import model.Terain;
import model.TypeTerain;

/**
 *
 * @author abdo
 */
@Stateless
public class TerainDao {
    @PersistenceContext( unitName = "Immobilier-ejbPU" )
    private EntityManager em;
    
    public Terain addTerain(Terain terain){
         em.persist(terain);
        return terain;
    }
    public Terain modifTerain(Terain terain){
        
    return em.merge(terain);
    }
    public int supTerain(Terain t){
        int n;
    Query req = em.createQuery("delete from AnnonceBien t where ann.id=:x");
     n = req.setParameter("x", t.getId()).executeUpdate();
        return n;
    }
     public List<Terain> cherhceAnnonce(AnnonceType t, boolean actv,Double minprix, Double maxprix, int sprftomin, int sprftomax, Gov gov, TypeTerain tptrain){
    List<Terain> list = new ArrayList<Terain>();
    Query req = em.createQuery("select b from Terain b where b.active=:act and b.type.typeAnnonce=:x and (b.prix >=:y and b.prix <=:z) and (b.superficieTotal>=:smin and b.superficieTotal<=:smax) and b.gov=:g and b.terainType=:traintype");
    //Query req = em.createQuery("select b from AnnonceBien b where b.prix >=:y and b.prix <=:z");
    req.setParameter("x", t.getTypeAnnonce());
    req.setParameter("act", actv);
    req.setParameter("y", minprix);
    req.setParameter("z", maxprix);
    req.setParameter("smin", sprftomin);
    req.setParameter("smax", sprftomax);
    req.setParameter("g", gov);
    req.setParameter("traintype", tptrain);
    list = req.getResultList();
    return list;
    }
    
}
