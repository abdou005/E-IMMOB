/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.SauvgardeDao;
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
@WebServlet(name = "SupSauv", urlPatterns = {"/supSauv"})
public class SupSauv extends HttpServlet {
    @EJB
    private SauvgardeDao sauvDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idAnn = request.getParameter("s");
        if(request.getSession().getAttribute("usersession")!=null){
            int n =0;
            Abonne abonne = (Abonne)request.getSession().getAttribute("usersession");
            n=sauvDao.supSauvBienAbonne(Long.valueOf(idAnn), abonne.getCode());
            if(n>0){
                response.sendRedirect("profil");
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
