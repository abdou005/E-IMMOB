/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.GetsAnnonceDao;
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
import model.AnnonceType;
import model.TypeAnnonce;

/**
 *
 * @author abdo
 */
@WebServlet(name = "ConnexionUser", urlPatterns = {"/connexionUser"})
public class ConnexionUser extends HttpServlet {
    @EJB
    private UtilisateurDao userDao;
    @EJB
    private GetsAnnonceDao getsAnnonceDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Abonne abonne = null;
        String msg = "";
        String email = request.getParameter("email");
            try{
            abonne=userDao.trouverUserMail(email, request.getParameter("password")); 
                if(abonne != null){
                    if(abonne.isActive()){
                    request.getSession().setAttribute("usersession", abonne);
                    //request.getRequestDispatcher("/profil").forward(request, response); 
                    response.sendRedirect("profil");
                    }else{
                        msg = "Votre compte est desactive par l'administrateur du site";
                        request.setAttribute("inscritmsg", msg);
                        this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
                    }
                }
            }catch(Exception e){
                if(abonne == null){
                msg = "Adresse Email ou Mot de passe incorecte.";
                request.setAttribute("inscritmsg", msg);
                this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
                }
            }  
}
}
