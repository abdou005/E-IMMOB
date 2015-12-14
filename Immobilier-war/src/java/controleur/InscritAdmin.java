/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import static controleur.Inscription.VUE;
import dao.UtilisateurDao;
import java.io.IOException;
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
@WebServlet(name = "InscritAdmin", urlPatterns = {"/inscritAdmin"})
public class InscritAdmin extends HttpServlet {
    @EJB
    private UtilisateurDao userDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/loginadmin.jsp").forward(request, response);        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("lastName");
        String prenom = request.getParameter("firstName");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String type = request.getParameter("type");  
        Abonne abonne = new Abonne();
        Abonne res;
        String confirm = "";
        String erreur = "";
            try{
                abonne = userDao.trouverUser(email);
                erreur = " Existe avec  " + email;                   
                request.setAttribute("err", erreur);
                this.getServletContext().getRequestDispatcher("/WEB-INF/inscriptionadmin.jsp").forward(request, response);
            }catch(Exception e){
                abonne.setNom(nom); abonne.setPrenom(prenom); abonne.setEmail(email); abonne.setPass(pass); abonne.setAdmin(true);
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
                        confirm = "Ajout avec succe";
                        request.setAttribute("conf", confirm);
                        this.getServletContext().getRequestDispatcher("/WEB-INF/inscriptionadmin.jsp").forward(request, response);
            } 
    }
}
