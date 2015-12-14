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
import model.Sauvgarde;

/**
 *
 * @author abdo
 */
@Stateless
public class SauvgardeDao {
    @PersistenceContext( unitName = "Immobilier-ejbPU" )
    private EntityManager em;
    public Sauvgarde sauvBien(Sauvgarde sauv){
        em.persist(sauv);
        return sauv;
    }
    public Sauvgarde trvSauv(Long idann, String code)throws RuntimeException {
    Sauvgarde sauv = null;
    Query req = em.createQuery("select s from Sauvgarde s where s.bien.id=:x and s.code=:y");
    req.setParameter("x", idann);
    req.setParameter("y", code);
    sauv = (Sauvgarde)req.getSingleResult();
    return sauv;
    }
    public AnnonceBien trvSauvBien(Long idann)throws RuntimeException{
    AnnonceBien bien = null;
    Query req = em.createQuery("select b from AnnonceBien b where b.sauvs.bien.id=:x");
    req.setParameter("x", idann);
    bien = (AnnonceBien)req.getSingleResult();
    return bien;
    }
    public List<Sauvgarde> trvSauvAbonne(String codeabonne){
    List<Sauvgarde> sauvs = new ArrayList<Sauvgarde>(); ;
    Query req = em.createQuery("select s from Sauvgarde s where s.code=:x");
    req.setParameter("x", codeabonne);
    sauvs = req.getResultList();
    return sauvs;
    }
    public int supSauvBien(Long idbien){
    int n;
    Query req = em.createQuery("delete from Sauvgarde s where s.bien.id=:x");
    n = req.setParameter("x", idbien).executeUpdate();
    return n;
    }
    public int supSauvBienAbonne(Long idbien, String code){
    int n;
    Query req = em.createQuery("delete from Sauvgarde s where s.bien.id=:x and s.code=:y");
    req.setParameter("x", idbien);
    n = req.setParameter("y", code).executeUpdate();
    return n;
    }
    public int supSauvUser(String cdabonne){
    int n;
    Query req = em.createQuery("delete from Sauvgarde s where s.code=:x");
    n = req.setParameter("x", cdabonne).executeUpdate();
    return n;
    }
    
}
