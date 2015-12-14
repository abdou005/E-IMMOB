/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.GetsAnnonceDao;
import dao.ImageDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AnnonceBien;
import model.Appartement;
import model.Depot;
import model.Gov;
import model.Image;
import model.Studio;
import model.Terain;
import model.TypeTerain;
import model.Villa;

/**
 *
 * @author abdo
 */
@WebServlet(name = "Accueil", urlPatterns = {"/accueil"})
public class Accueil extends HttpServlet {
    @EJB
    private GetsAnnonceDao getsAnnonceDao;
    @EJB
    private ImageDao imageDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long n;
        n=getsAnnonceDao.getCountAnnonce(true);
        
        System.out.println("nombre d annonce = "+n);
            if((n % 9)==0){
               System.out.println("nombre de pagge = "+(n/9));
               request.getSession().getServletContext().setAttribute("nbpage", (n/9));
            }else{
               System.out.println("nombre de pagge = "+(n/9+1));
               request.getSession().getServletContext().setAttribute("nbpage", (n/9+1));
            }
        List<AnnonceBien> l = new ArrayList<AnnonceBien>();
        l=getsAnnonceDao.trvAnnoncePage(1,9,true);
        Map<AnnonceBien, List<Image>> mapimgbien = new HashMap<AnnonceBien, List<Image>>();
        for(AnnonceBien b:l){
            List<Image> listeImage = new ArrayList<Image>();
            listeImage = imageDao.getsAllImageBien(b.getId());
                mapimgbien.put(b, listeImage);
        }
        for (Object key : mapimgbien.keySet()) {
		System.out.println("Key : " + key.toString() + " Value : "
			+ mapimgbien.get(key));
                        }
        ServletContext context = request.getSession().getServletContext();
        context.setAttribute("accueillist", mapimgbien);
        Map<Gov, Long> map = new HashMap<Gov, Long>();
                        for(Gov g : Gov.values()){
                        map.put(g, getsAnnonceDao.getNbrAnnonceGov(g));             
                        }
        request.getSession().getServletContext().setAttribute("govannoncemap", map);
        List<String> govs=new ArrayList<String>();
                       for(Gov g : Gov.values()){
                         govs.add(g.toString());
                        }
        request.getSession().getServletContext().setAttribute("governorat", govs);
        
     List<AnnonceBien> listBien = new ArrayList<AnnonceBien>();
     
     Map<Appartement, List<Image>> listapprt = new HashMap<Appartement, List<Image>>();
     
     Map<Studio, List<Image>> liststudio = new HashMap<Studio, List<Image>>();
     
     Map<Villa, List<Image>> listvill = new HashMap<Villa, List<Image>>();
   
     Map<Depot, List<Image>> listdepot = new HashMap<Depot, List<Image>>();
   
     List<Terain> listterain = new ArrayList<Terain>();
   
     Map<Terain, List<Image>> listteraintourist = new HashMap<Terain, List<Image>>();
     
     Map<Terain, List<Image>> listterainindust = new HashMap<Terain, List<Image>>();
     
     Map<Terain, List<Image>> listterainagrico = new HashMap<Terain, List<Image>>();
    
     Map<Terain, List<Image>> listterainvilla = new HashMap<Terain, List<Image>>();
     Map<AnnonceBien, List<Image>> listbiendemande = new HashMap<AnnonceBien, List<Image>>();
        listBien = getsAnnonceDao.getAllAnnonce(true); 
        System.out.println("*************debut***********");
        int i = 0;
       for(AnnonceBien b:listBien)
       {    
           List<Image> listeImage = new ArrayList<Image>();
           listeImage = imageDao.getsAllImageBien(b.getId());
           
           System.out.println(b.getClass().getName());
           System.out.println("************************");
           if(b.getClass().getName().equals("model.AnnonceBien")){
               listbiendemande.put((AnnonceBien) b, listeImage);
               System.out.println(AnnonceBien.class.getName()+"**"+i++);
           }  
           System.out.println("************************");
           if(b.getClass().getName().equals("model.Appartement")){
               listapprt.put((Appartement) b, listeImage);
               System.out.println(AnnonceBien.class.getName());
           }
           if(b.getClass().getName().equals("model.Villa")){
               
               listvill.put((Villa) b, listeImage);
               System.out.println(AnnonceBien.class.getName());
           }
           if(b.getClass().getName().equals("model.Studio")){
               liststudio.put((Studio) b, listeImage);
               System.out.println(AnnonceBien.class.getName());
           }
           if(b.getClass().getName().equals("model.Depot")){
               listdepot.put((Depot) b, listeImage);
               System.out.println(AnnonceBien.class.getName());
           }
           if(b.getClass().getName().equals("model.Terain")){
               listterain.add((Terain) b);
               //listterain.put((Terain) b, listeImage);
               System.out.println(AnnonceBien.class.getName());
           }
       }
            /*for(Appartement app:listapprt)
            {
                System.out.println(app.toString()+"----"+app.getTitre()+"---num etage"+app.getNumEtage());
            }*/
            for(Terain t:listterain)
            {
                List<Image> listeImage = new ArrayList<Image>();
                listeImage = imageDao.getsAllImageBien(t.getId());
                if(t.getTerainType().equals(TypeTerain.AGRICOLE)){
                listterainagrico.put(t, listeImage);
                }
                if(t.getTerainType().equals(TypeTerain.INDUSTRIEL)){
                listterainindust.put(t, listeImage);
                }
                if(t.getTerainType().equals(TypeTerain.TOURISTIQUE)){
                listteraintourist.put(t, listeImage);
                }
                if(t.getTerainType().equals(TypeTerain.VILLA)){
                listterainvilla.put(t, listeImage);
                }
            }
       System.out.println("appartement = "+listapprt.size());
       System.out.println("Villa = "+listvill.size());
       System.out.println("Studio = "+liststudio.size());
       System.out.println("DAEPOT = "+listdepot.size());
       System.out.println("TerainTotal = "+listterain.size());
       System.out.println("Terain indistruel = "+listterainindust.size());
       System.out.println("Terain touristique= "+listteraintourist.size());
       System.out.println("Terain agricole= "+listterainagrico.size());
       System.out.println("Terain villa= "+listterainvilla.size()); 
    
       request.getSession().getServletContext().setAttribute("appsize", listapprt.size());
       request.getSession().getServletContext().setAttribute("vilsize", listvill.size());
       request.getSession().getServletContext().setAttribute("stusize", liststudio.size());
       request.getSession().getServletContext().setAttribute("depsize", listdepot.size());
       request.getSession().getServletContext().setAttribute("tersize", listterain.size());
       request.getSession().getServletContext().setAttribute("terindssize", listterainindust.size());
       request.getSession().getServletContext().setAttribute("tertoursize", listteraintourist.size());
       request.getSession().getServletContext().setAttribute("teragrisize", listterainagrico.size());
       request.getSession().getServletContext().setAttribute("tervilsize", listterainvilla.size());
       //liste de bien demande
       request.getSession().getServletContext().setAttribute("listbiendemande", listbiendemande);   
       //listes des annonce par categorie
       request.getSession().getServletContext().setAttribute("app", listapprt);
       request.getSession().getServletContext().setAttribute("vil", listvill);
       request.getSession().getServletContext().setAttribute("stu", liststudio);
       request.getSession().getServletContext().setAttribute("dep", listdepot);
       request.getSession().getServletContext().setAttribute("ter", listterain);
       request.getSession().getServletContext().setAttribute("terinds", listterainindust);
       request.getSession().getServletContext().setAttribute("tertour", listteraintourist);
       request.getSession().getServletContext().setAttribute("teragri", listterainagrico);
       request.getSession().getServletContext().setAttribute("tervil", listterainvilla);
        for (Object key : listapprt.keySet()) {
		System.out.println("Key : " + key.toString() + " Value : "
			+ listapprt.get(key));
                        }
        System.out.println("************************"+i);
        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);   
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
