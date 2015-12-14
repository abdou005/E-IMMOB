/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.GetsAnnonceDao;
import dao.SauvgardeDao;
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
import model.Sauvgarde;

/**
 *
 * @author abdo
 */
@WebServlet(name = "SauvgardeBien", urlPatterns = {"/sauvgardeBien"})
public class SauvgardeBien extends HttpServlet {
    @EJB
    private SauvgardeDao sauvgardeDao;
    @EJB
    private GetsAnnonceDao getsAnnonceDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idann = request.getParameter("ann");
        Abonne abonne = (Abonne)request.getSession().getAttribute("usersession");
        String msgerr = "";
        List<Sauvgarde> listSauv = new ArrayList<Sauvgarde>();
        listSauv = sauvgardeDao.trvSauvAbonne(abonne.getCode());
        List<AnnonceBien> listBienAbonne = new ArrayList<AnnonceBien>();
        listBienAbonne = getsAnnonceDao.trouvesAnno(abonne);
        List<AnnonceBien> listSauvBien = new ArrayList<AnnonceBien>();
        for(Sauvgarde s:listSauv){
            
            listSauvBien.add(getsAnnonceDao.trvAnnonce(s.getBien().getId()));
        }
        int i = 0;
        boolean trv = false;
            while(i<listBienAbonne.size() && trv==false){
                if(listBienAbonne.get(i).getId()==Long.parseLong(idann)){
                trv=true; 
                }
                i++;
            }
        boolean trvsauv = false;
        int j = 0;
            while(j<listSauvBien.size() && trvsauv==false ){
                if(listSauvBien.get(j).getId()==Long.parseLong(idann)){
                trvsauv=true; 
                }
                j++;
            }
        if(trv==true){
           System.out.println("mte3ek hedi ama ab9a"); 
            msgerr = "vous n'avez pas le droit de suavgarder votre annonce";
             request.setAttribute("msgsauv", msgerr);
           this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response); 
        }else if(trvsauv==true){
            System.out.println(" Ou msovgardia 3andek");
            msgerr = "deja sauvgarder";
            request.setAttribute("msgsauv", msgerr);
            this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
        }else{
            System.out.println("tanja7");
                  Sauvgarde sauv = new Sauvgarde();
                                           Sauvgarde sauvres = new Sauvgarde();
                                           sauv.setCode(abonne.getCode());
                                           sauv.setBien(getsAnnonceDao.trvAnnonce(Long.parseLong(idann)));
                                           sauvres = sauvgardeDao.sauvBien(sauv); 
                                           System.out.println("say tsauvgarda pa 1er annonce"+sauvres.getCode()+"***");                      
            this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
        }
 
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
