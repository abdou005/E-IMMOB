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
import model.Abonne;
import model.AnnonceBien;
import model.AnnonceType;
import model.Gov;


/**
 *
 * @author abdo
 */
@Stateless
public class GetsAnnonceDao {
    @PersistenceContext( unitName = "Immobilier-ejbPU" )
    private EntityManager em;
    
    public List<AnnonceBien> trouvesAnnonce(Abonne a, boolean actv ){
    List<AnnonceBien> list =new ArrayList<AnnonceBien>(); 
    Query req = em.createQuery("select b from AnnonceBien b where b.abonne.id=:x and b.active=:act");
    req.setParameter("x", a.getId());
    req.setParameter("act", actv);
    list=req.getResultList();
    return list;
    }
     public List<AnnonceBien> trouvesAnno(Abonne a){
    List<AnnonceBien> list =new ArrayList<AnnonceBien>(); 
    Query req = em.createQuery("select b from AnnonceBien b where b.abonne.id=:x");
    req.setParameter("x", a.getId());
    list=req.getResultList();
    return list;
    }
    public AnnonceBien trvAnnonce(Long id){
    AnnonceBien bien = null;
    Query req = em.createQuery("select b from AnnonceBien b where b.id=:x");
    req.setParameter("x", id);
    bien=(AnnonceBien)req.getSingleResult();
    return bien;
    }
    public List<AnnonceBien> getListSauvg(Abonne a){
    List<AnnonceBien> list = new ArrayList<AnnonceBien>();
    Query req = em.createQuery("select b from AnnonceBien b where b.abonne.id=:idab");
    req.setParameter("idab", a.getId());
    list = req.getResultList();
    return list;
    }
    public AnnonceBien modifAnnonce(AnnonceBien b){
    return em.merge(b);
    }
    public int supAnnonce(AnnonceBien b){
    int n=0;
    Query req =em.createQuery("delete from AnnonceBien b where b.id=:x");
    n = req.setParameter("x", b.getId()).executeUpdate();
    return n;
    }
    public int supAnnonceAbonne(Abonne a){
    int n=0;
    Query req =em.createQuery("delete from AnnonceBien b where b.abonne.id=:x");
    n = req.setParameter("x", a.getId()).executeUpdate();
    return n;
    }
    public Long getCountAnnonce(boolean actv){
    Long n;
    Query req = em.createQuery("select COUNT(b) from AnnonceBien b where b.active=:act");
    req.setParameter("act", actv);
    n=(Long) req.getSingleResult();
    return n ;
    }
    public List<AnnonceBien> trvAnnoncePage(int pageNumber, int pageSize, boolean actv){
    List<AnnonceBien> list = new ArrayList<AnnonceBien>();
    Query req = em.createQuery("select b from AnnonceBien b where b.active=:act ORDER BY b.id ASC");
    req.setParameter("act", actv);
    req.setFirstResult((pageNumber-1) * pageSize); 
    req.setMaxResults(pageSize);
    list = req.getResultList();
     return list;
    }
    public List<AnnonceBien> getAllAnnonce(boolean actv){
    List<AnnonceBien> list = new ArrayList<AnnonceBien>();
    Query req = em.createQuery("select b from AnnonceBien b where b.active=:act ORDER BY b.id ASC");
    req.setParameter("act", actv);
    list = req.getResultList();
    return list;
    }
    public List<AnnonceBien> cherhceAnnonce(AnnonceType t, boolean actv, Double minprix, Double maxprix, int sprftomin, int sprftomax, Gov gov){
    List<AnnonceBien> list = new ArrayList<AnnonceBien>();
    Query req = em.createQuery("select b from AnnonceBien b where b.active=:act and b.type.typeAnnonce=:x and (b.prix >=:y and b.prix <=:z) and (b.superficieTotal>=:smin and b.superficieTotal<=:smax) and b.gov=:g");
    //Query req = em.createQuery("select b from AnnonceBien b where b.prix >=:y and b.prix <=:z");
    req.setParameter("x", t.getTypeAnnonce());
    req.setParameter("act", actv);
    req.setParameter("y", minprix);
    req.setParameter("z", maxprix);
    req.setParameter("smin", sprftomin);
    req.setParameter("smax", sprftomax);
    req.setParameter("g", gov);
    list = req.getResultList();
    return list;
    }
    public List<AnnonceBien> chercheParMC(String mc, boolean actv){
        List<AnnonceBien> list = new ArrayList<AnnonceBien>();
        Query req = em.createQuery("select b from AnnonceBien b where b.active=:act and b.description like '%mc%' OR b.titre like '%mc%'");
         req.setParameter("act", actv);
        //req.setParameter("mot", mc); 
       // req.setParameter("mot", mc);'S%'
        list = req.getResultList();
        return list;
    }
    public Long getNbrAnnonceGov(Gov gov){
        Long n;
        Query req = em.createQuery("select COUNT(b) from AnnonceBien b where b.gov=:g");
        req.setParameter("g", gov);
        n = (Long)req.getSingleResult();
        return n;
    }
    public List<AnnonceBien> getAnnonceGov(Gov gov, boolean actv){
        List<AnnonceBien> list = new ArrayList<AnnonceBien>();
        Query req = em.createQuery("select b from AnnonceBien b where b.active=:act and b.gov=:g");
        req.setParameter("act", actv);
        req.setParameter("g", gov);
        list = req.getResultList();
        return list;
    }
    public List<AnnonceBien> getAnnonceType(AnnonceType t, boolean actv){
        List<AnnonceBien> list = new ArrayList<AnnonceBien>();
        Query req = em.createQuery("select b from AnnonceBien b where b.active=:act and b.type.typeAnnonce=:typ");
        req.setParameter("act", actv);
        req.setParameter("typ", t.getTypeAnnonce());
        list = req.getResultList();
        return list;
    }
    public List<AnnonceBien> getAnnonceTypeadmin(AnnonceType t){
        List<AnnonceBien> list = new ArrayList<AnnonceBien>();
        Query req = em.createQuery("select b from AnnonceBien b where  b.type.typeAnnonce=:typ");
        req.setParameter("typ", t.getTypeAnnonce());
        list = req.getResultList();
        return list;
    }
      public Long getNbrAnnonceType(AnnonceType t){
        Long n;
        Query req = em.createQuery("select COUNT(b) from AnnonceBien b where b.type.typeAnnonce=:typ");
        req.setParameter("typ", t.getTypeAnnonce());
        n = (Long)req.getSingleResult();
        return n;
         }
        public Long getNbrAnnonceTypeAbonne(AnnonceType t, Abonne a){
        Long n;
        Query req = em.createQuery("select COUNT(b) from AnnonceBien b where b.type.typeAnnonce=:typ and b.abonne.id=:ab");
        req.setParameter("typ", t.getTypeAnnonce());
        req.setParameter("ab", a.getId());
        n = (Long)req.getSingleResult();
        return n;
        }
        public Long getNbrAnnonceAbonne(Abonne a){
        Long n;
        Query req = em.createQuery("select COUNT(b) from AnnonceBien b where b.abonne.id=:ab");
        req.setParameter("ab", a.getId());
        n = (Long)req.getSingleResult();
        return n;
        }
    /*
    public AnnonceType trouveType(AnnonceBien b){
    AnnonceType type=null;
    Query req = em.createQuery("select t from AnnonceType t where t.id=:x");
    req.setParameter("x", b.getType().getId());
    type=(AnnonceType)req.getSingleResult();
    return type;
    }*/
}
