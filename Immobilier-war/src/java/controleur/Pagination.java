/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.GetsAnnonceDao;
import dao.ImageDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AnnonceBien;
import model.Image;

/**
 *
 * @author abdo
 */
@WebServlet(name = "Pagination", urlPatterns = {"/pagination"})
public class Pagination extends HttpServlet {
    @EJB
    private GetsAnnonceDao getsAnnonceDao;
    @EJB
    private ImageDao imageDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String numpage = request.getParameter("p");
        List<AnnonceBien> l = new ArrayList<AnnonceBien>();
        l=getsAnnonceDao.trvAnnoncePage(Integer.parseInt(numpage),9,true);  
        Map<AnnonceBien, List<Image>> mapimgbien = new HashMap<AnnonceBien, List<Image>>();
        for(AnnonceBien b:l){
            List<Image> listeImage = new ArrayList<Image>();
            listeImage = imageDao.getsAllImageBien(b.getId());
            for(Image i:listeImage){
                mapimgbien.put(b, listeImage);
            System.out.println("liste image = "+i.getUrl()+"bien = "+b.getTitre());
            }
        }
        ServletContext context = request.getSession().getServletContext();
        context.setAttribute("accueillist", mapimgbien);
        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
