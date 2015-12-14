/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.UtilisateurDao;
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
import model.Abonne;

/**
 *
 * @author abdo
 */
@WebServlet(name = "ActiveAdmin", urlPatterns = {"/activerAdmin"})
public class ActiveAdmin extends HttpServlet {
    @EJB
    private UtilisateurDao userDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String valide = request.getSession().getAttribute("mail").toString();
        String idAdmin = request.getParameter("ad");
        System.out.println(valide);
        if(valide==null ){           
            this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
        }else if(valide.equals("bouhlaliabdallah@gmail.com")){
            Abonne admin = new Abonne();
            Abonne res;
            admin = userDao.trvAbonneId(Long.valueOf(idAdmin));
            admin.setActive(true);
            res = userDao.modifPersonne(admin);
            List<Abonne> admins = new ArrayList<Abonne>();
            admins = userDao.getsAllUser(true);
            request.getSession().getServletContext().setAttribute("listadmin", admins);
            request.getSession().removeAttribute("mail");
            this.getServletContext().getRequestDispatcher("/WEB-INF/inscriptionadmin.jsp").forward(request, response);           
        }else{
            this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
}
