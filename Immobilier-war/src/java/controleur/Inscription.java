/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

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
import model.Type;

/**
 *
 * @author abdo
 */
@WebServlet(name = "Inscription", urlPatterns = {"/inscription"})
public class Inscription extends HttpServlet {
    @EJB
    private UtilisateurDao userDao;
    public static final String VUE = "/WEB-INF/inscription.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Abonne res;
        String nom = request.getParameter("lastName");
        String prenom = request.getParameter("firstName");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String type = request.getParameter("type");  
        Abonne abonne = new Abonne();
        String confirm = "";
        String erreur = "";
            try{
                abonne = userDao.trouverUser(email);
                erreur = " Existe avec  " + email;                   
                request.setAttribute("err", erreur);
                this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
            }catch(Exception e){
                abonne.setNom(nom); abonne.setPrenom(prenom); abonne.setEmail(email); abonne.setPass(pass); abonne.setAdmin(false);
                abonne.setActive(true);
                        if(type.equals("PROMOTEUR")){
                            abonne.setAbonneType(Type.PROMOTEUR);
                        }else if(type.equals("PARTICULIER")){
                            abonne.setAbonneType(Type.PARTICULIER);
                        }else{
                            abonne.setAbonneType(Type.AGENCE_IMMOBILIER);
                        } 
                        abonne.setCode(userDao.genererCode(abonne));
                        res=userDao.addUser(abonne); 
                        request.getSession().setAttribute("usersession", res);                        
                        response.sendRedirect("profil");
            } 
    }
}
