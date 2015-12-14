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
import javax.servlet.http.HttpSession;
import model.AnnonceBien;
import model.Commentaire;
import model.Image;
/**
 *
 * @author abdo
 */
@WebServlet(name = "Annonce", urlPatterns = {"/annonce"})
public class Annonce extends HttpServlet {
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

        String idannpage = request.getParameter("ann");// page annonce
        trvA =(AnnonceBien)getsAnnonce.trvAnnonce(Long.parseLong(idannpage));
        //request.setAttribute("bien", trvA);  
              /*  HttpSession session = request.getSession();
                if(session.isNew()){
                    System.out.println("session new");
                int nb=trvA.getNbimpr();
                nb++;
                trvA.setNbimpr(nb);
                AnnonceBien bien = getsAnnonce.modifAnnonce(trvA);
                }else{
                    System.out.println("session pas new");
                }*/
        //request.getSession().setAttribute("nbvue", request);
        /*int nb=trvA.getNbimpr();
        nb=0;
        trvA.setNbimpr(nb);
        AnnonceBien bien = getsAnnonce.modifAnnonce(trvA);*/
                List<Image> listeImage = new ArrayList<Image>();
                listeImage = imageDao.getsAllImageBien(trvA.getId());
                request.getSession().getServletContext().setAttribute("images", listeImage);  
        request.getSession().getServletContext().setAttribute("bien", trvA); 
        List<Commentaire> list = new ArrayList<Commentaire>();
        list=commentaireDao.getsAllCommentBien(Integer.parseInt(idannpage));
        request.setAttribute("commbien", list);            
        Long n;
            n=commentaireDao.getNbrCommentAnnonce(Long.parseLong(idannpage));
            System.out.println("nnnnnnnbre de commen = "+n);
            request.setAttribute("nbrcomment", n);//nombre de commentaire pour une annonce de profil
        this.getServletContext().getRequestDispatcher("/WEB-INF/pageannonce.jsp").forward(request, response); 
            }    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

}
