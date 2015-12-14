/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.CommentaireDao;
import dao.GetsAnnonceDao;
import dao.ImageDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AnnonceBien;
import model.Commentaire;
import model.Image;

/**
 *
 * @author abdo
 */
@WebServlet(name = "AnnonceProfil", urlPatterns = {"/annonceProfil"})
public class AnnonceProfil extends HttpServlet {
    @EJB
    private GetsAnnonceDao getsAnnonce;
    @EJB
    private CommentaireDao commentaireDao;
    @EJB
    private ImageDao imageDao;
    private AnnonceBien trvA =  new AnnonceBien();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String idan = request.getParameter("an");///profil annonce                    
            trvA =(AnnonceBien)getsAnnonce.trvAnnonce(Long.parseLong(idan)); 
                List<Image> listeImage = new ArrayList<Image>();
                listeImage = imageDao.getsAllImageBien(trvA.getId());
                request.getSession().setAttribute("imagesprofil", listeImage); 
                request.getSession().setAttribute("bienprofil", trvA);
            //request.setAttribute("bienprofil", trvA);
            List<Commentaire> list = new ArrayList<Commentaire>();
            list=commentaireDao.getsAllCommentBien(Integer.parseInt(idan));
            Long n;
            n=commentaireDao.getNbrCommentAnnonce(Long.parseLong(idan));
            System.out.println("nnnnnnnbre de commen = "+n);
            request.setAttribute("nbrcommentprofil", n);//nombre de commentaire pour une annonce de profil
        request.setAttribute("commbienprofil", list);//liste de commetaire pour le profil d un annoce
        this.getServletContext().getRequestDispatcher("/WEB-INF/annonceprofil.jsp").forward(request, response);
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
