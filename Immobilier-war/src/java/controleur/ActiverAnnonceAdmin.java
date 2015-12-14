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
@WebServlet(name = "ActiverAnnonceAdmin", urlPatterns = {"/activerAnnonceAdmin"})
public class ActiverAnnonceAdmin extends HttpServlet {
    @EJB
    private GetsAnnonceDao getsAnnonceDao; 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idann = request.getParameter("d");
        System.out.println(idann);
        AnnonceBien trvA;
        if(request.getSession().getAttribute("usersession")!=null){
        trvA = getsAnnonceDao.trvAnnonce(Long.parseLong(idann));
        trvA.setActiveAdmin(true);
        AnnonceBien modif = getsAnnonceDao.modifAnnonce(trvA);
        System.out.println(modif.isActiveAdmin());
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
