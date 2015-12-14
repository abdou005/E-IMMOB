/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.CommentaireDao;
import dao.DelegationDao;
import dao.GetsAnnonceDao;
import dao.ImageDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AnnonceBien;
import model.Commentaire;
import model.Delegation;
import model.Gov;
import model.Image;

/**
 *
 * @author abdo
 */
@WebServlet(name = "ModifierAnnonce", urlPatterns = {"/modifierAnnonce"})
public class ModifierAnnonce extends HttpServlet {
    @EJB
    private GetsAnnonceDao getsAnnonce;
    @EJB
    private DelegationDao delgDao;
    @EJB
    private CommentaireDao commentaireDao;
    @EJB
    private ImageDao imageDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("usersession")!=null){
             AnnonceBien trvA=null; 
        String idannpage = request.getParameter("an");
        trvA =(AnnonceBien)getsAnnonce.trvAnnonce(Long.parseLong(idannpage));
        request.setAttribute("bien", trvA); 
        this.getServletContext().getRequestDispatcher("/WEB-INF/modifierannonce.jsp").forward(request, response);      
        }else{
           this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);  
        }   
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titre = request.getParameter("titre"); String prix = request.getParameter("prix"); String sprfto = request.getParameter("superficiertotal");
        String country = request.getParameter("country"); String delg = request.getParameter("delegtion"); String titreb = request.getParameter("titrebleu");
        String desc = request.getParameter("desc"); String idan = request.getParameter("idan");
        System.out.println(titre+""+idan);
        Gov gl=null;
        AnnonceBien trvA;
        trvA = getsAnnonce.trvAnnonce(Long.parseLong(idan));
        System.out.println(trvA.getGov()+"----"+trvA.getTitre()+"---"+trvA.getDeleg().getId());
        Delegation trvdelg;
        Long id=trvA.getDeleg().getId();
        trvdelg=(Delegation) delgDao.trvDel(id);
        trvdelg.setRegion(delg);
        Delegation modifDelg;
        modifDelg = (Delegation) delgDao.modif(trvdelg);
        System.out.println(trvdelg.getRegion()+"--------reg");
        trvA.setTitre(titre);  trvA.setPrix(Double.parseDouble(prix)); trvA.setSuperficieTotal(Integer.parseInt(sprfto));  
        trvA.setGov(gl.valueOf(country.toString()));
        trvA.setDeleg(modifDelg); 
                     if(titreb.equals("oui")){
                    trvA.setTitreBleau(true);
                    }else{
                    trvA.setTitreBleau(false);
                    }
      trvA.setDescription(desc); trvA.setDateModif(new Date());       
      AnnonceBien modifA;
      modifA = (AnnonceBien) getsAnnonce.modifAnnonce(trvA);
      ////trouv annonce
             List<Image> listeImage = new ArrayList<Image>();
                listeImage = imageDao.getsAllImageBien(trvA.getId());
                request.setAttribute("imagesprofil", listeImage); 
            request.getSession().setAttribute("bienprofil", trvA);
            List<Commentaire> list = new ArrayList<Commentaire>();
            list=commentaireDao.getsAllCommentBien(Integer.parseInt(idan));
            request.setAttribute("commbienprofil", list);
      System.out.println("+++++nodifAnn "+modifA.getDeleg().getRegion()+"--------"+modifA.getTitre());
      String message = "Modification succ";
      request.setAttribute("confmodif", message);
      this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);
    }
}
