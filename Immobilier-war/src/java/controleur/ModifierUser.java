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
@WebServlet(name = "ModifierUser", urlPatterns = {"/modifierUser"})
public class ModifierUser extends HttpServlet {
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
            out.println("<title>Servlet ModifierUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModifierUser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
    } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String type = request.getParameter("type"); 
        String ville = request.getParameter("country");
        String cp = request.getParameter("postalCode"); 
        String tel1 = request.getParameter("senderPhone");
        String tel2 = request.getParameter("phone");
        String adresse = request.getParameter("senderAddress");
            Abonne abonne;
            Abonne res;
            abonne = (Abonne)request.getSession().getAttribute("usersession");
            if(type.equals("PROMOTEUR")){
                        abonne.setAbonneType(Type.PROMOTEUR);
                    }else if(type.equals("PARTICULIER")){
                        abonne.setAbonneType(Type.PARTICULIER);
                    }else{
                        abonne.setAbonneType(Type.AGENCE_IMMOBILIER);
                    } 
       abonne.setCodePostal(Integer.parseInt(cp));
       abonne.setVille(ville); abonne.setTel1(tel1); abonne.setTel2(tel2); abonne.setAdresse(adresse);  
       res = userDao.modifPersonne(abonne);
        //abonne=userDao.trouverUserMail(request.getParameter("email"), request.getParameter("password"));
       String modifuser="succe";
       request.setAttribute("confmodifprofil", modifuser);
       request.getSession().setAttribute("usersession",res);      
      this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);         
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
