/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.CommentaireDao;
import dao.GetsAnnonceDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Abonne;
import model.AnnonceBien;
import model.Commentaire;

/**
 *
 * @author abdo
 */
@WebServlet(name = "CommentAbonne", urlPatterns = {"/commentAbonne"})
public class CommentAbonne extends HttpServlet {
    @EJB
    private CommentaireDao commentaireDao;
    @EJB
    private GetsAnnonceDao getsAnnonceDao;
    private Commentaire comm = new Commentaire();   
    private AnnonceBien bien = new AnnonceBien();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CommentAbonne</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CommentAbonne at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String contenu = request.getParameter("message");
        String idan = request.getParameter("bienid");
        System.out.println(contenu+"---idann = "+idan);       
        if(request.getSession().getAttribute("usersession")!=null){ 
            Abonne abon;
            abon=(Abonne)request.getSession().getAttribute("usersession");
            comm.setAbonne(abon);
            bien = getsAnnonceDao.trvAnnonce(Long.parseLong(idan));
            comm.setBien(bien);
            comm.setEmail(abon.getEmail());
            comm.setNomuser(abon.getNom());
            comm.setContenu(contenu);
            comm.setDate(new Date());
            Commentaire rescomm;
            rescomm=commentaireDao.addCommentaire(comm);
            List<Commentaire> list = new ArrayList<Commentaire>();
            list=commentaireDao.getsAllCommentBien(Integer.parseInt(idan));
            Long n;
            n=commentaireDao.getNbrCommentAnnonce(Long.parseLong(idan));
            System.out.println("nnnnnnnbre de commen = "+n);
            request.setAttribute("nbrcomment", n);
            request.setAttribute("commbien", list);
            this.getServletContext().getRequestDispatcher("/WEB-INF/pageannonce.jsp").forward(request, response);          
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
