/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.GetsAnnonceDao;
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
import model.AnnonceBien;

/**
 *
 * @author abdo
 */
@WebServlet(name = "RechercheMC", urlPatterns = {"/rechercheMC"})
public class RechercheMC extends HttpServlet {
    @EJB
    private GetsAnnonceDao getsAnnonceDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);   
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String mc = request.getParameter("rechmc");
        System.out.println(mc+"---------------");
        List<AnnonceBien> list = new ArrayList<AnnonceBien>();
        list = getsAnnonceDao.chercheParMC(mc,true);
        for(AnnonceBien b:list){
        System.out.println(b.getClass().getName()+"*****pris="+b.getPrix());
        }      
    }
}
