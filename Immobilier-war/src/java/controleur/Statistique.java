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
import model.AnnonceType;
import model.TypeAnnonce;

/**
 *
 * @author abdo
 */
@WebServlet(name = "Statistique", urlPatterns = {"/statistique"})
public class Statistique extends HttpServlet {
    @EJB
    private  GetsAnnonceDao getsAnnonceDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long active, desac, biens;
        Long vent ;
        Long loc ;
        Long colo ;
        Long locvac ;
        active  = getsAnnonceDao.getCountAnnonce(true);
        desac  = getsAnnonceDao.getCountAnnonce(false);
        biens = active + desac;
        System.out.println(biens);
        
        AnnonceType type = new AnnonceType();
        type.setTypeAnnonce(TypeAnnonce.VENTE);
        vent = getsAnnonceDao.getNbrAnnonceType(type);
        System.out.println(vent);
         
        type.setTypeAnnonce(TypeAnnonce.LOCATION);
        loc = getsAnnonceDao.getNbrAnnonceType(type);
        System.out.println(loc);
         
        type.setTypeAnnonce(TypeAnnonce.COLOCATION);
        colo = getsAnnonceDao.getNbrAnnonceType(type);
        System.out.println(colo);
        
        type.setTypeAnnonce(TypeAnnonce.LOCATIONVACANCES);
        locvac = getsAnnonceDao.getNbrAnnonceType(type);
        System.out.println(locvac);
        
        request.setAttribute("vente", vent);
        request.setAttribute("loc", loc);
        request.setAttribute("coloc", colo);
        request.setAttribute("locvac", locvac);
        this.getServletContext().getRequestDispatcher("/WEB-INF/statistique.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }

}
