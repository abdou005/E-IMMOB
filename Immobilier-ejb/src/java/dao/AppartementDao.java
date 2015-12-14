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
import model.Appartement;
import model.Gov;

/**
 *
 * @author abdo
 */
@Stateless
public class AppartementDao {
    @PersistenceContext( unitName = "Immobilier-ejbPU" )
    private EntityManager em;
      public Appartement addAppartement(Appartement appartement){
         em.persist(appartement);
        return appartement;
    }
    public Appartement modifAppartement(Appartement appartement){
        
    return em.merge(appartement);
    }
    public int supAppartement(Appartement a){
        int n;
    Query req = em.createQuery("delete from AnnonceBien a where ann.id=:x");
     n = req.setParameter("x", a.getId()).executeUpdate();
        return n;
    }
    public List<Appartement> cherhceAnnonce(AnnonceType t, boolean actv, Double minprix, Double maxprix, int sprftomin, int sprftomax, Gov gov, int sprfhamin, int sprfhamax, int nbrpcmin, int nbrpcmax, boolean balc, boolean clim, boolean chauf, int numetgmin, int numetgmax, boolean assenc, boolean parking, boolean sandic){
    List<Appartement> list = new ArrayList<Appartement>();
    Query req = em.createQuery("select b from Appartement b where b.active=:act and b.type.typeAnnonce=:x and (b.prix >=:y and b.prix <=:z) and (b.superficieTotal>=:smin and b.superficieTotal<=:smax) and  b.gov=:g and (b.superficieHabitable>=:hmin and b.superficieHabitable<=:hmax) and (b.nbrDePiece>=:pcmin and b.nbrDePiece<=:pcmax) and b.balcon=:blc and b.climatisation=:climat and b.chauffage=:chaufa and (b.numEtage>=:etgmin and b.numEtage<=:etgmax)and b.assenceur=:ass and b.parking=:park and b.sandic=:sand");
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
    req.setParameter("etgmin", numetgmin);
    req.setParameter("etgmax", numetgmax);
    req.setParameter("ass", assenc);
    req.setParameter("park", parking);
    req.setParameter("sand", sandic);                                                                                                                                                                                                                                                                                                                                                                                                                                                    
    list = req.getResultList();
    return list;
    }
}
