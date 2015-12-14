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
@WebServlet(name = "GererAbonne", urlPatterns = {"/gererAbonne"})
public class GererAbonne extends HttpServlet {
    @EJB
    private UtilisateurDao userDao;
    @EJB
    private GetsAnnonceDao getsAnnonceDao;
    @EJB 
    private UtilisateurDao adminDao;
    @EJB
    private CommentaireDao commentaireDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Abonne isAdm = new Abonne();
        List<Abonne> abonnes = new ArrayList<Abonne>();
        Map<Abonne, List<AnnonceBien>> mapuserbien = new HashMap<Abonne, List<AnnonceBien>>();
        abonnes = userDao.getsAllUser(false);
            for(Abonne a:abonnes){
                List<AnnonceBien> biens = new ArrayList<AnnonceBien>();
                biens = getsAnnonceDao.trouvesAnno(a);
                mapuserbien.put(a,biens);
            }
            
            if(request.getSession().getAttribute("usersession")!=null){
            isAdm = (Abonne)request.getSession().getAttribute("usersession");
                if(isAdm.isAdmin()){
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
                        usev = getsAnnonceDao.getNbrAnnonceTypeAbonne(annonceTypeVente, isAdm);
                        usel = getsAnnonceDao.getNbrAnnonceTypeAbonne(annonceTypeLocation, isAdm);
                        usec = getsAnnonceDao.getNbrAnnonceTypeAbonne(annonceTypeColo, isAdm);
                        uselv = getsAnnonceDao.getNbrAnnonceTypeAbonne(annonceTypeLocVac, isAdm);
                        to = getsAnnonceDao.getNbrAnnonceAbonne(isAdm);
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

                    request.setAttribute("mapbienabonne", mapuserbien);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/gererabonne.jsp").forward(request, response);
                }else{
                    this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
                }
            }else{
                    this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
            }       
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
