/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import static controleur.SupAnnonce.deleteDir;
import dao.AnnonceTypeDao;
import dao.CommentaireDao;
import dao.DelegationDao;
import dao.GetsAnnonceDao;
import dao.ImageDao;
import dao.SauvgardeDao;
import dao.UtilisateurDao;
import java.io.File;
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
import model.AnnonceBien;

/**
 *
 * @author abdo
 */
@WebServlet(name = "SupUser", urlPatterns = {"/supUser"})
public class SupUser extends HttpServlet {
    @EJB
    private UtilisateurDao userDao;
    @EJB
    private GetsAnnonceDao getsAnnonce; 
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
        String s = request.getParameter("s");
        Abonne admin;
        Abonne abonnesup = new Abonne();
                
        admin = (Abonne)request.getSession().getAttribute("usersession");
        if(admin.isAdmin() && request.getSession().getAttribute("usersession")!=null){
            abonnesup = userDao.trvAbonneId(Long.valueOf(s));
            List<AnnonceBien> l = new ArrayList<AnnonceBien>();           
        l=getsAnnonce.trouvesAnno(abonnesup);
            for(AnnonceBien b:l){               
                    System.out.println(b.getType()+"---"+b.getDeleg().getRegion()+"-"+b.getDateModif()+"-"+b.getClass().getName()+"--"+b.getType().getTypeAnnonce()); 
                               /* trvA=getsAnnonce.trvAnnonce(Long.parseLong(idann));
                    System.out.println(trvA.getTitre());*/
                    int m=0;
                    int d=0;
                    int t=0;
                    int i=0;
                    int sv=0;
                    m=commentaireDao.supCommentaire(b);
                    System.out.println("comm sup");
                    i=imageDao.supImage(b);
                    System.out.println("image sup");
                String chemin = getServletContext().getRealPath("/").toString()+"MesImage\\"+b.getId();
                System.out.println(chemin);
                 boolean res;
                                     try {
                                         
                                        File f = new File(chemin);
                                        System.out.println("file = "+f.getName());
                                        res = deleteDir(f);                                        
                                        //f.delete();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        System.out.print("cqnnot make dir");
                                    }
                    sv = sauvDao.supSauvBien(b.getId());
                    System.out.println("Sauv sup bien");
                     int n=0;
                    n=getsAnnonce.supAnnonce(b);
                     System.out.println("bien sup"); 
                    d=delegationDao.supDelegAnno(b.getDeleg());
                    System.out.println("deleg annonc sup");
                    t=annonceTypeDao.supTypeAnno(b.getType()); 
                    System.out.println("type annonce sup");                               
            }
            
          int sab = sauvDao.supSauvUser(abonnesup.getCode());
           System.out.println("Sauv sup abonne"+sab);
        int u = userDao.supPersonne(abonnesup);
        System.out.println("user sup");
        response.sendRedirect("gererAbonne");
            
        }else{
            this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
        } 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Abonne abonne;
        abonne = (Abonne)request.getSession().getAttribute("usersession");
        List<AnnonceBien> l = new ArrayList<AnnonceBien>();           
        l=getsAnnonce.trouvesAnno(abonne);
            for(AnnonceBien b:l){               
                    System.out.println(b.getType()+"---"+b.getDeleg().getRegion()+"-"+b.getDateModif()+"-"+b.getClass().getName()+"--"+b.getType().getTypeAnnonce()); 
                               /* trvA=getsAnnonce.trvAnnonce(Long.parseLong(idann));
                    System.out.println(trvA.getTitre());*/
                    int m=0;
                    int d=0;
                    int t=0;
                    int i=0;
                    int s=0;
                    m=commentaireDao.supCommentaire(b);
                    System.out.println("comm sup");
                    i=imageDao.supImage(b);
                    System.out.println("image sup");
                String chemin = getServletContext().getRealPath("/").toString()+"MesImage\\"+b.getId();
                System.out.println(chemin);
                 boolean res;
                                     try {
                                         
                                        File f = new File(chemin);
                                        System.out.println("file = "+f.getName());
                                        res = deleteDir(f);                                        
                                        //f.delete();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        System.out.print("cqnnot make dir");
                                    }
                    s = sauvDao.supSauvBien(b.getId());
                    System.out.println("Sauv sup bien");
                     int n=0;
                    n=getsAnnonce.supAnnonce(b);
                     System.out.println("bien sup"); 
                    d=delegationDao.supDelegAnno(b.getDeleg());
                    System.out.println("deleg annonc sup");
                    t=annonceTypeDao.supTypeAnno(b.getType()); 
                    System.out.println("type annonce sup");                               
            }
            
          int sab = sauvDao.supSauvUser(abonne.getCode());
           System.out.println("Sauv sup abonne"+sab);
        int u = userDao.supPersonne(abonne);
        System.out.println("user sup");
        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
    }
}
