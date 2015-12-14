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
import model.Gov;
import model.Habitable;
import model.Studio;

/**
 *
 * @author abdo
 */
@Stateless
public class HabitableDao {    
    @PersistenceContext( unitName = "Immobilier-ejbPU" )
    private EntityManager em;
    public Studio addHabitable(Studio studio){
         em.persist(studio);
        return studio;
    }
    public Studio modifHabitable(Studio studio){
        
    return em.merge(studio);
    }
    public int supHabitable(Studio s){
        int n;
    Query req = em.createQuery("delete from AnnonceBien s where ann.id=:x");
     n = req.setParameter("x", s.getId()).executeUpdate();
        return n;
    }
    public List<Habitable> cherhceAnnonce(AnnonceType t, boolean actv, Double minprix, Double maxprix, int sprftomin, int sprftomax, Gov gov, int sprfhamin, int sprfhamax, int nbrpcmin, int nbrpcmax, boolean balc, boolean clim, boolean chauf){
    List<Habitable> list = new ArrayList<Habitable>();
    Query req = em.createQuery("select b from Habitable b where b.active=:act and b.type.typeAnnonce=:x and (b.prix >=:y and b.prix <=:z) and (b.superficieTotal>=:smin and b.superficieTotal<=:smax) and b.gov=:g and (b.superficieHabitable>=:hmin and b.superficieHabitable<=:hmax) and (b.nbrDePiece>=:pcmin and b.nbrDePiece<=:pcmax) and b.balcon=:blc and b.climatisation=:climat and b.chauffage=:chaufa");
    //Query req = em.createQuery("select b from AnnonceBien b where b.prix >=:y and b.prix <=:z");
    req.setParameter("x", t.getTypeAnnonce());
    req.setParameter("act", actv);
    req.setParameter("y", minprix);
    req.setParameter("z", maxprix);
    req.setParameter("smin", sprftomin);
    req.setParameter("smax", sprftomax);
    req.setParameter("g", gov);
    req.setParameter("hmin", sprfhamin);
    req.setParameter("hmax", sprfhamax);
    req.setParameter("pcmin", nbrpcmin);
    req.setParameter("pcmax", nbrpcmax);
    req.setParameter("blc", balc);
    req.setParameter("climat", clim);
    req.setParameter("chaufa", chauf);
    list = req.getResultList();
    return list;
    }
    
}
