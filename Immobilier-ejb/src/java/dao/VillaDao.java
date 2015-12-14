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
import model.Studio;
import model.Villa;

/**
 *
 * @author abdo
 */
@Stateless
public class VillaDao {
    @PersistenceContext( unitName = "Immobilier-ejbPU" )
    private EntityManager em;
     public Villa addVilla(Villa villa){
         em.persist(villa);
        return villa;
    }
    public Villa modifVilla(Villa villa){
        
    return em.merge(villa);
    }
    public int supVilla(Villa v){
        int n;
    Query req = em.createQuery("delete from AnnonceBien v where ann.id=:x");
     n = req.setParameter("x", v.getId()).executeUpdate();
        return n;
    }
    public List<Villa> cherhceAnnonce(AnnonceType t, boolean actv, Double minprix, Double maxprix, int sprftomin, int sprftomax, Gov gov, int sprfhamin, int sprfhamax, int nbrpcmin, int nbrpcmax, boolean balc, boolean clim, boolean chauf, int nbretgmin, int nbretgmax, boolean jardin, boolean garage, boolean piscine){
    List<Villa> list = new ArrayList<Villa>();
    Query req = em.createQuery("select b from Villa b where b.active=:act and b.type.typeAnnonce=:x and (b.prix >=:y and b.prix <=:z) and (b.superficieTotal>=:smin and b.superficieTotal<=:smax) and b.gov=:g and (b.superficieHabitable>=:hmin and b.superficieHabitable<=:hmax) and (b.nbrDePiece>=:pcmin and b.nbrDePiece<=:pcmax) and b.balcon=:blc and b.climatisation=:climat and b.chauffage=:chaufa and (b.nbrEtage>=:nbretgmin and b.nbrEtage<=:nbretgmax) and b.jardin=:jard and b.Garage=:garg and b.piscine=:pisc");
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
    //req.setParameter("nbretg", nbretage);
    req.setParameter("nbretgmin", nbretgmin);
    req.setParameter("nbretgmax", nbretgmax);
    req.setParameter("jard", jardin);
    req.setParameter("garg", garage);
    req.setParameter("pisc", piscine);
    list = req.getResultList();
    return list;
    }
    
}
