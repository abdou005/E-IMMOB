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
import model.Image;

/**
 *
 * @author abdo
 */
@Stateless
public class ImageDao {
    @PersistenceContext( unitName = "Immobilier-ejbPU" )
    private EntityManager em;
    public Image addImage(Image img){
        em.persist(img);
        return img;
    }
       public List<Image> getsAllImage(){
       List<Image> l = new ArrayList<Image>();
       Query req = em.createQuery("select i from Image i");
       l=req.getResultList();
       return l;
    }
     public List<Image> getsAllImageBien(Long idann){
       List<Image> l = new ArrayList<Image>();
       Query req = em.createQuery("select i from Image i where i.bien.id=:x");
       req.setParameter("x", idann);
       l=req.getResultList();
       return l;
    }
    public int supImage(AnnonceBien b){
    int n=0;
    Query req =em.createQuery("delete from Image i where i.bien.id=:x");
    n = req.setParameter("x", b.getId()).executeUpdate();
    return n;
    }
    public int supImg(Long idimg){
    int n = 0;
    Query req = em.createQuery("delete from Image i where i.id=:x");
    n = req.setParameter("x", idimg).executeUpdate();
    return n;
    }
    public Image getImageId(Long id){
        Image img = new Image();
        Query req = em.createQuery("select i from Image i where i.id=:x");
        req.setParameter("x", id);
        img =(Image) req.getSingleResult();
        return img;
    }
    
}
