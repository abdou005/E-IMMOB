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
@WebServlet(name = "LoginWebMaster", urlPatterns = {"/loginWebMaster"})
public class LoginWebMaster extends HttpServlet {
    @EJB
    private UtilisateurDao userDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/loginwebmaster.jsp").forward(request, response);
       
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        List<Abonne> admins = new ArrayList<Abonne>();
        if(email.equals("bouhlaliabdallah@gmail.com") && pass.equals("adminabdou141187")){
            admins = userDao.getsAllUser(true);
            request.getSession().getServletContext().setAttribute("listadmin", admins);
            this.getServletContext().getRequestDispatcher("/WEB-INF/inscriptionadmin.jsp").forward(request, response);
        }else{
            this.getServletContext().getRequestDispatcher("/WEB-INF/loginwebmaster.jsp").forward(request, response);
        }
 
    }
}
