/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.AdminDao;
import dao.UtilisateurDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Abonne;

/**
 *
 * @author abdo
 */
@WebServlet(name = "DesactiverAbonne", urlPatterns = {"/desactiverAbonne"})
public class DesactiverAbonne extends HttpServlet {
    @EJB
    private UtilisateurDao userDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String idab = request.getParameter("d");
        Abonne abonne = new Abonne();
        if(request.getSession().getAttribute("usersession")!=null){
            abonne = userDao.trvAbonneId(Long.valueOf(idab));
            abonne.setActive(false);
            Abonne trv;
            trv = userDao.modifPersonne(abonne);
            System.out.println(trv.isActive());
             String msg="Modifcation avec succe";
            request.setAttribute("confadmin", msg);
            this.getServletContext().getRequestDispatcher("/gererAbonne").forward(request, response);
        }else{
           this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
