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
import model.AnnonceType;
import model.Depot;
import model.Gov;

/**
 *
 * @author abdo
 */
@Stateless
public class DepotDao {
    @PersistenceContext( unitName = "Immobilier-ejbPU" )
    private EntityManager em;
      public Depot addDepot(Depot depot){
         em.persist(depot);
        return depot;
    }
    public Depot modifDepot(Depot depot){
        
    return em.merge(depot);
    }
    public int supDepot(Depot d){
        int n;
    Query req = em.createQuery("delete from AnnonceBien d where ann.id=:x");
     n = req.setParameter("x", d.getId()).executeUpdate();
        return n;
    }
     public List<Depot> cherhceAnnonce(AnnonceType t,Double minprix, Double maxprix, int sprftomin, int sprftomax, Gov gov, int sprfcouvmin, int sprfcouvmax){
    List<Depot> list = new ArrayList<Depot>();
    Query req = em.createQuery("select b from Depot b where b.type.typeAnnonce=:x and (b.prix >=:y and b.prix <=:z) and (b.superficieTotal>=:smin and b.superficieTotal<=:smax) and b.gov=:g and (b.superficieCouvert>=:couvmin and b.superficieCouvert<=:couvmax)");
    req.setParameter("x", t.getTypeAnnonce());
    req.setParameter("y", minprix);
    req.setParameter("z", maxprix);
    req.setParameter("smin", sprftomin);
    req.setParameter("smax", sprftomax);
    req.setParameter("g", gov);
    req.setParameter("couvmin", sprfcouvmin);
    req.setParameter("couvmax", sprfcouvmax);
    list = req.getResultList();
    return list;
    }
    
}
