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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AnnonceBien;
import model.AnnonceType;
import model.Appartement;
import model.Depot;
import model.Image;
import model.Studio;
import model.Terain;
import model.TypeAnnonce;
import model.Villa;

/**
 *
 * @author abdo
 */
@WebServlet(name = "AnnonceTypelist", urlPatterns = {"/annonceType"})
public class AnnonceTypelist extends HttpServlet {
    @EJB
    private GetsAnnonceDao getsAnnonceDao;
     @EJB
    private ImageDao imageDao;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AnnonceType</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AnnonceType at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<AnnonceBien> listtype = new ArrayList<AnnonceBien>();
        Map<AnnonceBien, List<Image>> maptype = new HashMap<AnnonceBien, List<Image>>();
        /////liste entity
        Map<Studio, List<Image>> listStudio = new HashMap<Studio, List<Image>>();
        
        Map<Appartement, List<Image>> listAppartement = new HashMap<Appartement, List<Image>>();
       
        Map<Villa, List<Image>> listVilla = new HashMap<Villa, List<Image>>();
       
        Map<Depot, List<Image>> listDepot = new HashMap<Depot, List<Image>>();
       
        Map<Terain, List<Image>> listTerain = new HashMap<Terain, List<Image>>();
        //processRequest(request, response);
        String typ = request.getParameter("typ");
        String entity = request.getParameter("mod");
        AnnonceType annonceType = new AnnonceType();
        for(TypeAnnonce t : TypeAnnonce.values()){
            if(typ.equals(t.toString())){
            System.out.println(t); 
            annonceType.setTypeAnnonce(t);
            listtype = getsAnnonceDao.getAnnonceType(annonceType,true);
            request.setAttribute("type", typ);
                            for(AnnonceBien b:listtype){
                                //System.out.println(b.getDeleg().getRegion());
                                List<Image> listeImage = new ArrayList<Image>();
                                listeImage = imageDao.getsAllImageBien(b.getId());
                                maptype.put(b, listeImage);
                                if(b.getClass().getName().equals("model.Appartement")){
                                    System.out.println("cayyy l9ineh appartement = "+b.getClass().getName());  
                                    listAppartement.put((Appartement) b, listeImage);
                                }
                                if(b.getClass().getName().equals("model.Villa")){
                                    System.out.println("cayyy l9ineh villa = "+b.getClass().getName());
                                    listVilla.put((Villa) b, listeImage);
                                }
                                if(b.getClass().getName().equals("model.Studio")){
                                    System.out.println("cayyy l9ineh studio = "+b.getClass().getName());
                                    listStudio.put((Studio) b, listeImage);
                                }
                                if(b.getClass().getName().equals("model.Depot")){
                                    System.out.println("cayyy l9ineh depot = "+b.getClass().getName());
                                    listDepot.put((Depot) b, listeImage);
                                }
                                if(b.getClass().getName().equals("model.Terain")){
                                    System.out.println("cayyy l9ineh Terain = "+b.getClass().getName());
                                    listTerain.put((Terain) b, listeImage);
                                }
                            }
            }
        }
            if(entity.isEmpty()){
            request.setAttribute("listetype", maptype);
            }
        request.setAttribute("entit", entity);
            if(!(entity.isEmpty()))  { 
                if(entity.equals("Appartement")){  
                  request.setAttribute("listapp", listAppartement);
                }
                if(entity.equals("Villa")){  
                    request.setAttribute("listvil", listVilla);
                }
                if(entity.equals("Studio")){  
                    request.setAttribute("liststu", listStudio);
                }
                if(entity.equals("Depot")){  
                    request.setAttribute("listdep", listDepot);
                }
                if(entity.equals("Terain")){  
                    request.setAttribute("listter", listTerain);
                }
                
            }
        this.getServletContext().getRequestDispatcher("/WEB-INF/annoncetype.jsp").forward(request, response);
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
