/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.CommentaireDao;
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
import model.Commentaire;

/**
 *
 * @author abdo
 */
@WebServlet(name = "SupCommentaire", urlPatterns = {"/supCommentaire"})
public class SupCommentaire extends HttpServlet {
    @EJB
    private CommentaireDao commentaireDao;
     private Commentaire comm = new Commentaire();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idc = request.getParameter("com");
        String idan = request.getParameter("bienid");

        comm.setId(Long.parseLong(idc));
        int m = 0;
        m=commentaireDao.supUnCommentaire(comm);
        if(m>0){
            System.out.println("commentaire suprimer");
        }else{
            System.out.println("pas de supprimmer");
        }
            List<Commentaire> list = new ArrayList<Commentaire>();
            list=commentaireDao.getsAllCommentBien(Integer.parseInt(idan));
            Long n;
            n=commentaireDao.getNbrCommentAnnonce(Long.parseLong(idan));
            System.out.println("nnnnnnnbre de commen = "+n);
            request.setAttribute("nbrcommentprofil", n);//nombre de commentaire pour une annonce de profil
            request.setAttribute("commbienprofil", list);//liste des commontaire pour le profil de user
        this.getServletContext().getRequestDispatcher("/annonce?ann="+Long.parseLong(idan)).forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
