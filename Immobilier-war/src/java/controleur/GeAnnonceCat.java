/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author abdo
 */
@WebServlet(name = "GetAnnonceCat", urlPatterns = {"/getAnnonceCat"})
public class GeAnnonceCat extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetAppartement</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetAppartement at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
        String cat = request.getParameter("cat");        
        if(cat.equals("appr")){
            request.setAttribute("categorie", cat);
         }else if(cat.equals("appr")){
              request.setAttribute("categorie", cat);  
         }else if(cat.equals("vill")){
                request.setAttribute("categorie", cat);
         }else if(cat.equals("stu")){
                request.setAttribute("categorie", cat);
         }else if(cat.equals("tour")){
             request.setAttribute("categorie", cat);
         }else if(cat.equals("agric")){
             request.setAttribute("categorie", cat);
         }else if(cat.equals("trvill")){
             request.setAttribute("categorie", cat);
         }else if(cat.equals("inds")){
             request.setAttribute("categorie", cat);
         }else{
         //depot
             request.setAttribute("categorie", cat);
         }
    this.getServletContext().getRequestDispatcher("/WEB-INF/annoncecat.jsp").forward(request, response);
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
