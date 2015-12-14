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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AnnonceBien;
import model.Gov;
import model.Image;
/**
 *
 * @author abdo
 */
@WebServlet(name = "GetAnnonceGov", urlPatterns = {"/getAnnonceGov"})
public class GetAnnonceGov extends HttpServlet {
    @EJB
    private GetsAnnonceDao getsAnnonceDao;
    @EJB
    private ImageDao imageDao;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetAnnonceGov</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetAnnonceGov at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String delg = request.getParameter("deleg");
        List<AnnonceBien> listBien = new ArrayList<AnnonceBien>();
        Map<AnnonceBien, List<Image>> mapbien = new HashMap<AnnonceBien, List<Image>>();
            for(Gov g : Gov.values()){
                if(delg.equals(g.toString())){
                    System.out.println("--------"+g);
                    request.getSession().getServletContext().setAttribute("deleg", g.toString());
                    listBien=getsAnnonceDao.getAnnonceGov(g,true);
                        for(AnnonceBien b:listBien){
                            List<Image> listeImage = new ArrayList<Image>();
                            listeImage = imageDao.getsAllImageBien(b.getId());
                            mapbien.put(b, listeImage);
                        }
                    
                    request.getSession().getServletContext().setAttribute("listbiengov", mapbien);
                }
                        
            }
        this.getServletContext().getRequestDispatcher("/WEB-INF/annoncegov.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
