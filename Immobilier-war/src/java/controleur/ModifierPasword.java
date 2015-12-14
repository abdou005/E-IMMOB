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

/**
 *
 * @author abdo
 */
@WebServlet(name = "ModifierPasword", urlPatterns = {"/modifierPasword"})
public class ModifierPasword extends HttpServlet {
    @EJB
    private UtilisateurDao userDao;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModifierPasword</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModifierPasword at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Abonne abonne = null;
        Abonne res = null;
        String ancien = request.getParameter("passwordannc");
        String nouv = request.getParameter("password");
        String nouvconf = request.getParameter("confirmPassword");
        String pswmsg="";
        
                //processRequest(request, response);
                abonne = (Abonne)request.getSession().getAttribute("usersession");
                if(abonne.getPass().equals(ancien)){
                    if(nouv.equals(nouvconf) && nouv.length()>=3){
                        System.out.println("on peut faire la modification");
                        abonne.setPass(nouv);
                        res = userDao.modifPersonne(abonne);
                        System.out.println(res.getPass());
                        pswmsg="succe";
                        request.setAttribute("confpswsuc", pswmsg); 
                    }else{
                        System.out.println("on peut pas !!!!! faire la modification");
                        pswmsg="Erreur confirmation psw";
                        request.setAttribute("confpswerr", pswmsg);
                    }
                }else{
                    System.out.println("on peut pas !!!!! faire la modification");
                    pswmsg="Erreur";
                    request.setAttribute("confpswerr", pswmsg);
                }
         
        
        
         this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);
     
    }
}
