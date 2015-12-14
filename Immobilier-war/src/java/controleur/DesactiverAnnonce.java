/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.GetsAnnonceDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AnnonceBien;

/**
 *
 * @author abdo
 */
@WebServlet(name = "DesactiverAnnonce", urlPatterns = {"/desactiverAnnonce"})
public class DesactiverAnnonce extends HttpServlet {
    @EJB
    private GetsAnnonceDao getsAnnonceDao; 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idann = request.getParameter("d");
        if(request.getSession().getAttribute("usersession")!=null){
        System.out.println(idann);
        AnnonceBien trvA;
        trvA = getsAnnonceDao.trvAnnonce(Long.parseLong(idann));
        trvA.setActive(false);
        AnnonceBien modif = getsAnnonceDao.modifAnnonce(trvA);
        String message = "Modification succ";
        request.setAttribute("confmodif", message);
        response.sendRedirect("profil");
        //this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp");
        }else{
           //this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp");
         this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
