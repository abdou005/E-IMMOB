/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.CommentaireDao;
import dao.GetsAnnonceDao;
import dao.UtilisateurDao;
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
import model.TypeAnnonce;

/**
 *
 * @author abdo
 */
@WebServlet(name = "LoginAdmin", urlPatterns = {"/loginAdmin"})
public class LoginAdmin extends HttpServlet {
    @EJB 
    private UtilisateurDao adminDao;
    @EJB
    private GetsAnnonceDao getsAnnonceDao;
    @EJB
    private CommentaireDao commentaireDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           /*for (Object key : mapVente.keySet()) {
		System.out.println("Key : " + key.toString() + " Value : "
			+ mapVente.get(key));
                        }*/
        if(request.getSession().getAttribute("usersession")!=null){
           Abonne perso = (Abonne)request.getSession().getAttribute("usersession");
           if(perso.isAdmin()){
               List<AnnonceBien> listVente = new ArrayList<AnnonceBien>();
        List<AnnonceBien> listLocation = new ArrayList<AnnonceBien>();
        List<AnnonceBien> listColocation = new ArrayList<AnnonceBien>();
        List<AnnonceBien> listLocvac = new ArrayList<AnnonceBien>();
        AnnonceType annonceTypeVente = new AnnonceType();
        AnnonceType annonceTypeLocation = new AnnonceType();
        AnnonceType annonceTypeColo = new AnnonceType();
        AnnonceType annonceTypeLocVac = new AnnonceType();
        
        annonceTypeVente.setTypeAnnonce(TypeAnnonce.VENTE);
        annonceTypeLocation.setTypeAnnonce(TypeAnnonce.LOCATION);
        annonceTypeColo.setTypeAnnonce(TypeAnnonce.COLOCATION);
        annonceTypeLocVac.setTypeAnnonce(TypeAnnonce.LOCATIONVACANCES);
            
            Long v,l,c,lv;
            Long active, desac, biens, nbComm ,nbAbonne ;
        active  = getsAnnonceDao.getCountAnnonce(true);
        desac  = getsAnnonceDao.getCountAnnonce(false);
        biens = active + desac;
        System.out.println(biens);
        
        nbComm = commentaireDao.getCountComment();
        nbAbonne = adminDao.getCountAbonne(false);
        System.out.println(nbComm+" comm  abonne "+nbAbonne);
            v=getsAnnonceDao.getNbrAnnonceType(annonceTypeVente);
            l=getsAnnonceDao.getNbrAnnonceType(annonceTypeLocation);
            c=getsAnnonceDao.getNbrAnnonceType(annonceTypeColo);
            lv=getsAnnonceDao.getNbrAnnonceType(annonceTypeLocVac);
        
            listVente = getsAnnonceDao.getAnnonceTypeadmin(annonceTypeVente);
            listLocation = getsAnnonceDao.getAnnonceTypeadmin(annonceTypeLocation);
            listColocation = getsAnnonceDao.getAnnonceTypeadmin(annonceTypeColo);
            listLocvac = getsAnnonceDao.getAnnonceTypeadmin(annonceTypeLocVac);
             
            Map<AnnonceBien, Long> mapVente = new HashMap<AnnonceBien, Long>();
            
            Map<AnnonceBien, Long> mapLocation = new HashMap<AnnonceBien, Long>();
            
            Map<AnnonceBien, Long> mapColocation = new HashMap<AnnonceBien, Long>();
            
            Map<AnnonceBien, Long> mapLocVAC = new HashMap<AnnonceBien, Long>();

            for(AnnonceBien b:listVente){
              mapVente.put(b, commentaireDao.getNbrCommentAnnonce(b.getId()));
            }
            for(AnnonceBien b:listLocation){
              mapLocation.put(b, commentaireDao.getNbrCommentAnnonce(b.getId()));
            }
            for(AnnonceBien b:listColocation){
              mapColocation.put(b, commentaireDao.getNbrCommentAnnonce(b.getId()));
            }
            for(AnnonceBien b:listLocvac){
              mapLocVAC.put(b, commentaireDao.getNbrCommentAnnonce(b.getId()));
            }
            Long usev,usel,usec,uselv,to;
                        usev = getsAnnonceDao.getNbrAnnonceTypeAbonne(annonceTypeVente, perso);
                        usel = getsAnnonceDao.getNbrAnnonceTypeAbonne(annonceTypeLocation, perso);
                        usec = getsAnnonceDao.getNbrAnnonceTypeAbonne(annonceTypeColo, perso);
                        uselv = getsAnnonceDao.getNbrAnnonceTypeAbonne(annonceTypeLocVac, perso);
                        to = getsAnnonceDao.getNbrAnnonceAbonne(perso);
                            request.getSession().setAttribute("admcomm", nbComm);
                            request.getSession().setAttribute("admabonne", nbAbonne);
                            request.getSession().setAttribute("admannonce", biens);
                            
                            request.getSession().setAttribute("uservente", usev);
                            request.getSession().setAttribute("userloc", usel);
                            request.getSession().setAttribute("usercol", usec);
                            request.getSession().setAttribute("userlocv", uselv);
                            request.getSession().setAttribute("userto", to);
                            request.getSession().setAttribute("mapvente", mapVente);
                            request.getSession().setAttribute("nbrv", v);
                            request.getSession().setAttribute("maplocation", mapLocation);
                            request.getSession().setAttribute("nbrl", l);
                            request.getSession().setAttribute("mapcolocation", mapColocation);
                            request.getSession().setAttribute("nbrc", c);
                            request.getSession().setAttribute("maplocvac", mapLocVAC);
                            request.getSession().setAttribute("nbrlv", lv);

               this.getServletContext().getRequestDispatcher("/WEB-INF/bordadmin.jsp").forward(request, response); 
           }else{
               this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response); 
           }  
        }else{
            this.getServletContext().getRequestDispatcher("/WEB-INF/loginadmin.jsp").forward(request, response); 
        }                
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        List<AnnonceBien> listVente = new ArrayList<AnnonceBien>();
        List<AnnonceBien> listLocation = new ArrayList<AnnonceBien>();
        List<AnnonceBien> listColocation = new ArrayList<AnnonceBien>();
        List<AnnonceBien> listLocvac = new ArrayList<AnnonceBien>();
        AnnonceType annonceTypeVente = new AnnonceType();
        AnnonceType annonceTypeLocation = new AnnonceType();
        AnnonceType annonceTypeColo = new AnnonceType();
        AnnonceType annonceTypeLocVac = new AnnonceType();
        
        annonceTypeVente.setTypeAnnonce(TypeAnnonce.VENTE);
        annonceTypeLocation.setTypeAnnonce(TypeAnnonce.LOCATION);
        annonceTypeColo.setTypeAnnonce(TypeAnnonce.COLOCATION);
        annonceTypeLocVac.setTypeAnnonce(TypeAnnonce.LOCATIONVACANCES);
            
            Long v,l,c,lv;
            Long active, desac, biens, nbComm ,nbAbonne ;
        active  = getsAnnonceDao.getCountAnnonce(true);
        desac  = getsAnnonceDao.getCountAnnonce(false);
        biens = active + desac;
        System.out.println(biens);
        
        nbComm = commentaireDao.getCountComment();
        nbAbonne = adminDao.getCountAbonne(false);
        System.out.println(nbComm+" comm  abonne "+nbAbonne);
            v=getsAnnonceDao.getNbrAnnonceType(annonceTypeVente);
            l=getsAnnonceDao.getNbrAnnonceType(annonceTypeLocation);
            c=getsAnnonceDao.getNbrAnnonceType(annonceTypeColo);
            lv=getsAnnonceDao.getNbrAnnonceType(annonceTypeLocVac);
        
            listVente = getsAnnonceDao.getAnnonceTypeadmin(annonceTypeVente);
            listLocation = getsAnnonceDao.getAnnonceTypeadmin(annonceTypeLocation);
            listColocation = getsAnnonceDao.getAnnonceTypeadmin(annonceTypeColo);
            listLocvac = getsAnnonceDao.getAnnonceTypeadmin(annonceTypeLocVac);
             
            Map<AnnonceBien, Long> mapVente = new HashMap<AnnonceBien, Long>();
            
            Map<AnnonceBien, Long> mapLocation = new HashMap<AnnonceBien, Long>();
            
            Map<AnnonceBien, Long> mapColocation = new HashMap<AnnonceBien, Long>();
            
            Map<AnnonceBien, Long> mapLocVAC = new HashMap<AnnonceBien, Long>();

            for(AnnonceBien b:listVente){
              mapVente.put(b, commentaireDao.getNbrCommentAnnonce(b.getId()));
            }
            for(AnnonceBien b:listLocation){
              mapLocation.put(b, commentaireDao.getNbrCommentAnnonce(b.getId()));
            }
            for(AnnonceBien b:listColocation){
              mapColocation.put(b, commentaireDao.getNbrCommentAnnonce(b.getId()));
            }
            for(AnnonceBien b:listLocvac){
              mapLocVAC.put(b, commentaireDao.getNbrCommentAnnonce(b.getId()));
            }
            
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
            if(email.isEmpty() || pass.isEmpty()){
            System.out.println("pas de login");
            this.getServletContext().getRequestDispatcher("/WEB-INF/loginadmin.jsp").forward(request, response);
            }else{
                System.out.println("Login = "+email+"------"+pass);
                 Abonne perso = null;
                    try{
                    perso=adminDao.trouverUserMail(email, pass); 
                    if(perso.isActive()){
                        if(perso != null && perso.isAdmin()){
                            Long usev,usel,usec,uselv,to;
                        usev = getsAnnonceDao.getNbrAnnonceTypeAbonne(annonceTypeVente, perso);
                        usel = getsAnnonceDao.getNbrAnnonceTypeAbonne(annonceTypeLocation, perso);
                        usec = getsAnnonceDao.getNbrAnnonceTypeAbonne(annonceTypeColo, perso);
                        uselv = getsAnnonceDao.getNbrAnnonceTypeAbonne(annonceTypeLocVac, perso);
                        to = getsAnnonceDao.getNbrAnnonceAbonne(perso);
                            request.getSession().setAttribute("admcomm", nbComm);
                            request.getSession().setAttribute("admabonne", nbAbonne);
                            request.getSession().setAttribute("admannonce", biens);
                            
                            request.getSession().setAttribute("uservente", usev);
                            request.getSession().setAttribute("userloc", usel);
                            request.getSession().setAttribute("usercol", usec);
                            request.getSession().setAttribute("userlocv", uselv);
                            request.getSession().setAttribute("userto", to);
                            request.getSession().setAttribute("usersession", perso);
                            System.out.println("Verifier dans la base et Login = "+email+"------"+pass);
                            request.getSession().setAttribute("mapvente", mapVente);
                            request.getSession().setAttribute("nbrv", v);
                            request.getSession().setAttribute("maplocation", mapLocation);
                            request.getSession().setAttribute("nbrl", l);
                            request.getSession().setAttribute("mapcolocation", mapColocation);
                            request.getSession().setAttribute("nbrc", c);
                            request.getSession().setAttribute("maplocvac", mapLocVAC);
                            request.getSession().setAttribute("nbrlv", lv);

                        this.getServletContext().getRequestDispatcher("/WEB-INF/bordadmin.jsp").forward(request, response);
                        }else{
                        System.out.println("Vous n avez pas le droit d acceder car vous n ete pas admin");
                        this.getServletContext().getRequestDispatcher("/WEB-INF/loginadmin.jsp").forward(request, response);
                        }
                       }else{
                        String msg = "Votre compte est desactive par le super Admin du site";
                        request.setAttribute("inscritmsg", msg);
                        this.getServletContext().getRequestDispatcher("/WEB-INF/loginadmin.jsp").forward(request, response);
                        }
                    }catch(Exception e){
                        if(perso == null){
                            System.out.println("pas de login pass faux");
                        this.getServletContext().getRequestDispatcher("/WEB-INF/loginadmin.jsp").forward(request, response);
                        }
                    }
            }
    }
}
