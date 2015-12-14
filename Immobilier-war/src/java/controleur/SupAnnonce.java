/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.AnnonceTypeDao;
import dao.CommentaireDao;
import dao.DelegationDao;
import dao.GetsAnnonceDao;
import dao.ImageDao;
import dao.SauvgardeDao;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Abonne;
import model.AnnonceBien;

/**
 *
 * @author abdo
 */
@WebServlet(name = "SupAnnonce", urlPatterns = {"/supAnnonce"})
public class SupAnnonce extends HttpServlet {
    @EJB
    private GetsAnnonceDao getsAnnonceDao;   
    @EJB
    private CommentaireDao commentaireDao;
    @EJB
    private AnnonceTypeDao annonceTypeDao;
    @EJB
    private DelegationDao delegationDao;
    @EJB
    private ImageDao imageDao;
    @EJB
    private SauvgardeDao sauvDao;
        public static boolean deleteDir(File dir) {
            if (dir.isDirectory()) {
            String[] children = dir.list();
                for (int i = 0; i < children.length; i++){
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) 
                return false;	
                }
            }
            // The directory is now empty so delete it
            return dir.delete();
        }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           Abonne perso = null;
        if(request.getSession().getAttribute("usersession")!=null){
        perso = (Abonne)request.getSession().getAttribute("usersession");

        String idann = request.getParameter("s");
        System.out.println(Integer.parseInt(idann));
        AnnonceBien trvA;
        trvA=getsAnnonceDao.trvAnnonce(Long.parseLong(idann));
        System.out.println(trvA.getTitre());
        int n=0;
        int m=0;
        int d=0;
        int t=0;
        int i=0;
        int s=0;
        boolean res;
        m=commentaireDao.supCommentaire(trvA);
        i=imageDao.supImage(trvA);
                String chemin = getServletContext().getRealPath("/").toString()+"MesImage\\"+idann;
                System.out.println(chemin);
                                     try {
                                         
                                        File f = new File(chemin);
                                        System.out.println("file = "+f.getName());
                                        res = deleteDir(f);                                        
                                        //f.delete();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        System.out.print("cqnnot make dir");
                                    }                  
        s=sauvDao.supSauvBien(trvA.getId());
        n=getsAnnonceDao.supAnnonce(trvA);
        d=delegationDao.supDelegAnno(trvA.getDeleg());
        t=annonceTypeDao.supTypeAnno(trvA.getType());
        
        
        System.out.println("**** n = "+n+"*** m = "+m+"*** d = "+d+"**t = *"+t+"*** i = "+i+"***s = "+s+".");
            if(perso.isAdmin()){
                if(n>0){
                    String message="suprimer";
                    request.setAttribute("confsup", message);
                    this.getServletContext().getRequestDispatcher("/bordAdmin").forward(request, response);
                }
            }else{
                this.getServletContext().getRequestDispatcher("/profil").forward(request, response);
            }
    }else{
            this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);      
    }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }
}
