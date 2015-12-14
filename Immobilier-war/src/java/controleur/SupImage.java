/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.ImageDao;
import java.io.File;
import java.io.IOException;
import javax.ejb.EJB;
import javax.mail.Folder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Image;

/**
 *
 * @author abdo
 */
@WebServlet(name = "SupImage", urlPatterns = {"/supImage"})
public class SupImage extends HttpServlet {
    @EJB
    private ImageDao imageDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idimg = request.getParameter("img");
        String idann = request.getParameter("an");
       // String filePath = getServletContext().getRealPath("/") + File.separator;
        String chemin = getServletContext().getRealPath("/").toString()+"\\MesImage";
        String filePath = "";
        System.out.println("chemin = "+chemin);
        Image img = new Image();
        Folder folder ;
        File file;
        if(request.getSession().getAttribute("usersession")!=null){
            if(idimg!=null){
                int n = 0;                
                img = imageDao.getImageId(Long.valueOf(idimg));
                System.out.println(img.getUrl()); 
                n=imageDao.supImg(Long.valueOf(idimg));
                filePath = chemin+"\\"+img.getUrl().replace("/", "\\").toString();
                System.out.println("filePath = "+filePath);
                        try {
                                file = new File(filePath);
                                System.out.println("file = "+file.getName());
                                file.delete();
                                    if(n>0){
                                    this.getServletContext().getRequestDispatcher("/annonceProfil?an="+Integer.valueOf(idann)).forward(request, response);
                                    }else{
                                    System.out.println("probleme EJB");
                                    }
                        } catch (Exception e) {
                                e.printStackTrace();
                                 System.out.print("cqnnot make dir");
                        }
                    
            }else{
                //this.getServletContext().getRequestDispatcher("/annonceProfil?an="+Integer.valueOf(idimg)).forward(request, response); 
                this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response); 
            }
        }else{

            this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response); 
        }
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
