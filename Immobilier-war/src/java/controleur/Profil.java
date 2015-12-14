/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.GetsAnnonceDao;
import dao.ImageDao;
import dao.SauvgardeDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Abonne;
import model.AnnonceBien;
import model.AnnonceType;
import model.Appartement;
import model.Depot;
import model.Habitable;
import model.Image;
import model.Sauvgarde;
import model.Terain;
import model.TypeAnnonce;
import model.Villa;

/**
 *
 * @author abdo
 */
@WebServlet(name = "Profil", urlPatterns = {"/profil"})
public class Profil extends HttpServlet {
    @EJB
    private GetsAnnonceDao getsAnnonce; 
    @EJB
    private GetsAnnonceDao getsAnnonceDao;
    @EJB
    private ImageDao imageDao;
    @EJB
    private SauvgardeDao sauvDao;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         
            Abonne a = (Abonne)request.getSession().getAttribute("usersession");
            List<AnnonceBien> l = new ArrayList<AnnonceBien>();
           
            l=getsAnnonce.trouvesAnnonce(a,true);
            Depot depot = new Depot();
            Terain terain = new Terain();
            Habitable habitable = new Habitable();//studio
            Appartement appartement = new Appartement();
            Villa villa = new Villa();
            
            for(AnnonceBien b:l){               
                System.out.println(b.getType()+"---"+b.getDeleg().getRegion()+"--"+b.getClass().getName()+"--"+b.getType().getTypeAnnonce()); 
                if(b.getClass().getName().equals("model.Villa")){
                    System.out.println(b.getClass().getName());
                }               
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Profil</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+a.getId()+"</h1>");
           // out.println("<h1>Servlet Profil at " + l.get(0).getDateAjout()+ "</h1>");
            out.println("<h1>Servlet Profil at </h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        if(request.getSession().getAttribute("usersession")!=null){
        Abonne a = (Abonne)request.getSession().getAttribute("usersession");
        AnnonceType annonceTypeVente = new AnnonceType();
        AnnonceType annonceTypeLocation = new AnnonceType();
        AnnonceType annonceTypeColo = new AnnonceType();
        AnnonceType annonceTypeLocVac = new AnnonceType();
        
        annonceTypeVente.setTypeAnnonce(TypeAnnonce.VENTE);
        annonceTypeLocation.setTypeAnnonce(TypeAnnonce.LOCATION);
        annonceTypeColo.setTypeAnnonce(TypeAnnonce.COLOCATION);
        annonceTypeLocVac.setTypeAnnonce(TypeAnnonce.LOCATIONVACANCES);
        Long usev,usel,usec,uselv,to;
                usev = getsAnnonce.getNbrAnnonceTypeAbonne(annonceTypeVente, a);
                usel = getsAnnonce.getNbrAnnonceTypeAbonne(annonceTypeLocation, a);
                usec = getsAnnonce.getNbrAnnonceTypeAbonne(annonceTypeColo, a);
                uselv = getsAnnonce.getNbrAnnonceTypeAbonne(annonceTypeLocVac, a);
                to = getsAnnonce.getNbrAnnonceAbonne(a);
                request.getSession().setAttribute("uservente", usev);
                request.getSession().setAttribute("userloc", usel);
                request.getSession().setAttribute("usercol", usec);
                request.getSession().setAttribute("userlocv", uselv);
                request.getSession().setAttribute("userto", to);
        
        List<AnnonceBien> listeActive = new ArrayList<AnnonceBien>();
        List<AnnonceBien> listeDesactive = new ArrayList<AnnonceBien>(); 
        listeActive=getsAnnonce.trouvesAnnonce(a,true);
        listeDesactive=getsAnnonce.trouvesAnnonce(a,false);
        Map<AnnonceBien, List<Image>> mapimgbienActive = new HashMap<AnnonceBien, List<Image>>();
        Map<AnnonceBien, List<Image>> mapimgbienDesactive = new HashMap<AnnonceBien, List<Image>>();
        for(AnnonceBien b:listeActive){
            List<Image> listeImage = new ArrayList<Image>();
            listeImage = imageDao.getsAllImageBien(b.getId());
                mapimgbienActive.put(b, listeImage);
        }
        for(AnnonceBien b:listeDesactive){
            List<Image> listeImage = new ArrayList<Image>();
            listeImage = imageDao.getsAllImageBien(b.getId());
                mapimgbienDesactive.put(b, listeImage);
        }
        List<Sauvgarde> listeSauv = new ArrayList<Sauvgarde>();
        listeSauv = sauvDao.trvSauvAbonne(a.getCode());
        
        List<AnnonceBien> listeSauvBien = new ArrayList<AnnonceBien>();
        Map<AnnonceBien, List<Image>> mapimgbienSauv = new HashMap<AnnonceBien, List<Image>>();
        if(listeSauv!=null){
            for(Sauvgarde s:listeSauv){
            System.out.println(s.getBien().getPrix());  
                listeSauvBien.add(getsAnnonceDao.trvAnnonce(s.getBien().getId()));
            }
        }
         for(AnnonceBien b:listeSauvBien){
            List<Image> listeImage = new ArrayList<Image>();
            listeImage = imageDao.getsAllImageBien(b.getId());
                mapimgbienSauv.put(b, listeImage);
        }
           /* for(AnnonceBien b:l){               
                    System.out.println(b.getType()+"---"+b.getDeleg().getRegion()+"-"+b.getDateModif()+"-"+b.getClass().getName()+"--"+b.getType().getTypeAnnonce()); 
                    if(b.getClass().getName().equals("model.Villa")){
                        System.out.println(b.getClass().getName());
                    }               
            }*/
        request.getSession().setAttribute("listannonceactive", mapimgbienActive);
        request.getSession().setAttribute("listannoncedesactive", mapimgbienDesactive);
        request.getSession().setAttribute("listannoncesauv", mapimgbienSauv);
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);
        }else{
        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
