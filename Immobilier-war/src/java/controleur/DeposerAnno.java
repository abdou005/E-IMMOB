/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.AnnonceDao;
import dao.AnnonceTypeDao;
import dao.AppartementDao;
import dao.DelegationDao;
import dao.DepotDao;
import dao.HabitableDao;
import dao.TerainDao;
import dao.VillaDao;
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
import model.AnnonceType;
import model.Appartement;
import model.Delegation;
import model.Depot;
import model.Gov;
import model.Habitable;
import model.Studio;
import model.Terain;
import model.TypeAnnonce;
import model.TypeTerain;
import model.Villa;

/**
 *
 * @author abdo
 */
@WebServlet(name = "DeposerAnno", urlPatterns = {"/deposerAnno"})
public class DeposerAnno extends HttpServlet {
    @EJB
    private AnnonceDao annonceDao;
    @EJB
    private AnnonceTypeDao annonceTypeDao;
    @EJB
    private DelegationDao delegationDao;
    @EJB
    private HabitableDao habitableDao;  
    @EJB
    private AppartementDao appartementDao;
    @EJB
    private VillaDao villaDao;
    @EJB
    private DepotDao depotDao;
    @EJB
    private TerainDao terainDao;   
    private AnnonceType annonceType =new AnnonceType();
    private Delegation delegation= new Delegation();
    private Abonne abonne = new Abonne();
    private AnnonceBien annonceBien = new AnnonceBien();
    private Studio habitable = new Studio();
    private Appartement appart= new Appartement();
    private Villa villa = new Villa();
    private Terain terrain = new Terain();
    private Depot depot = new Depot();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> govs=new ArrayList<String>();
        List<String> types=new ArrayList<String>();
        String msg = "";
        for(TypeAnnonce type : TypeAnnonce.values()){
            //System.out.println(type);
            types.add(type.toString());
        }
        for(Gov g : Gov.values()){
         //System.out.println(g);
         govs.add(g.toString());
        }
        request.setAttribute("governorat", govs);
        request.setAttribute("typeann", types);
        if(request.getSession().getAttribute("usersession")!=null){
        this.getServletContext().getRequestDispatcher("/WEB-INF/deposer.jsp").forward(request, response);
        }else{
        msg = "Vous devez vous connecter pour déposer ou demander une annonce";
        request.setAttribute("deposermsg", msg);
       // response.sendRedirect("accueil");
        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //hidden
        String entity = request.getParameter("entity");        
        ///Annoncebien
        String typeann = request.getParameter("type"); String contry = request.getParameter("country"); String delg = request.getParameter("delegtion");
        String titre = request.getParameter("titre");  String prix = request.getParameter("prix"); String sprfto = request.getParameter("superficiertotal");
        String tbleu = request.getParameter("titrebleu"); String desc = request.getParameter("desc"); 
        String active = request.getParameter("active");
          System.out.println("---"+active);
          boolean act=false;
            if(active==null){
            System.out.println("ferga");
            }else{
                act=true;
            System.out.println("say maoujouda--"+active);
            }
        ///Annoncebien Depot
        String sprcou = request.getParameter("superficiercouvert");  String annconstdepot = request.getParameter("anneeconstdepot");
        ///Annoncebien Terain
        String zonne = request.getParameter("zonne");        
        ///Annoncebien Habitable Studio
        String sprfha = request.getParameter("superficierhabitable"); String annconst = request.getParameter("annconst");
        String nbrpc = request.getParameter("nbrpiece"); String nbrsa = request.getParameter("nbrsalon"); String nbrch = request.getParameter("nbrchambre");
        String nbrslb = request.getParameter("nbrsalbain"); String wc = request.getParameter("wc"); String nbrcui = request.getParameter("nbrcuisine");
        String balcon = request.getParameter("balc"); String clim = request.getParameter("clim"); String chauf = request.getParameter("chauf");             
        ///Annoncebien Habitable Appartement
        String numetage = request.getParameter("numetage"); String assen = request.getParameter("assenceur");
        String park = request.getParameter("parking"); String sand = request.getParameter("sandik");        
        ///Annoncebien Habitable Villa
        String nbretage = request.getParameter("nbretage"); String jardin = request.getParameter("jardin");
        String garage = request.getParameter("garage"); String piscine = request.getParameter("piscine");      
        AnnonceType t; Delegation d; 
        AnnonceBien bien; Habitable h; Appartement ap; Villa vil; Depot dep; Terain tr;
        System.out.println("type d annonce : "+typeann);                
                if(typeann.equals("COLOCATION")){
                    annonceType.setTypeAnnonce(TypeAnnonce.COLOCATION);
                }else if(typeann.equals("LOCATION")){
                    annonceType.setTypeAnnonce(TypeAnnonce.LOCATION);
                }else if(typeann.equals("VENTE")){
                    annonceType.setTypeAnnonce(TypeAnnonce.VENTE);
                }else{
                    annonceType.setTypeAnnonce(TypeAnnonce.LOCATIONVACANCES);
                }
               
                //System.out.println(gl.valueOf(contry.toString()));

        abonne=(Abonne)request.getSession().getAttribute("usersession"); 
        Gov gl=null;
        if(entity.equals("annonce")){
            t = annonceTypeDao.addTypeAnno(annonceType);
            delegation.setRegion(delg);       
            d =delegationDao.addDel(delegation);
            System.out.println("type entity : "+entity);           
            System.out.println("++ "+abonne.toString()+""+abonne.getCode()+""+abonne.getEmail()); 
            annonceBien.setDateAjout(new Date());
            annonceBien.setDateModif(new Date());
            annonceBien.setPrix(Double.valueOf(prix));
            annonceBien.setTitre(titre);
            annonceBien.setDescription(desc);
            annonceBien.setActive(act);
            annonceBien.setActiveAdmin(true);
                    if(tbleu.equals("oui")){
                    annonceBien.setTitreBleau(true);
                    }else{
                    annonceBien.setTitreBleau(false);
                    }
            annonceBien.setSuperficieTotal(Integer.parseInt(sprfto));
            annonceBien.setAbonne(abonne);
            annonceBien.setDeleg(d);        
            annonceBien.setType(t);
            annonceBien.setGov(gl.valueOf(contry.toString()));
            bien = annonceDao.addAnnonceBien(annonceBien);               
            System.out.println(bien.toString());     
            response.sendRedirect("profil"); 
        }else if(entity.equals("studio")){
            t = annonceTypeDao.addTypeAnno(annonceType);
            delegation.setRegion(delg);       
            d =delegationDao.addDel(delegation);
           System.out.println("type entity : "+entity);           
            System.out.println("++ "+abonne.toString()+""+abonne.getCode()+""+abonne.getEmail()); 
            habitable.setDateAjout(new Date());
            habitable.setDateModif(new Date());
            habitable.setPrix(Double.parseDouble(prix));
            habitable.setTitre(titre);
            habitable.setDescription(desc);
            habitable.setActive(act);
            habitable.setActiveAdmin(true);
                    if(tbleu.equals("oui")){
                    habitable.setTitreBleau(true);
                    }else{
                    habitable.setTitreBleau(false);
                    }
            habitable.setSuperficieTotal(Integer.parseInt(sprfto));
            habitable.setAbonne(abonne);
            habitable.setDeleg(d);        
            habitable.setType(t);
            habitable.setGov(gl.valueOf(contry.toString()));                        
            habitable.setSuperficieHabitable(Integer.parseInt(sprfha));
            habitable.setAnneeConstruction(Integer.parseInt(annconst));
            habitable.setNbrDePiece(Integer.parseInt(nbrpc));
            habitable.setSalon(Integer.parseInt(nbrsa));
            habitable.setChambre(Integer.parseInt(nbrch));
            habitable.setSalleDeBain(Integer.parseInt(nbrslb));
            habitable.setCuisine(Integer.parseInt(nbrcui));
            habitable.setWc(Integer.parseInt(wc));
                if(balcon.equals("oui")){
                habitable.setBalcon(true);
                }else{
                habitable.setBalcon(false);
                } 
                if(clim.equals("oui")){
                    habitable.setClimatisation(true);
                }else{
                    habitable.setClimatisation(false);
                }
                if(chauf.equals("oui")){
                    habitable.setChauffage(true);
                }else{
                    habitable.setChauffage(false);
                }           
            h = habitableDao.addHabitable(habitable);
            System.out.println(h.toString());  
         System.out.println(abonne.toString()); 
         response.sendRedirect("profil");
        }else if(entity.equals("appartement")){
            t = annonceTypeDao.addTypeAnno(annonceType);
            delegation.setRegion(delg);       
            d =delegationDao.addDel(delegation);
         System.out.println("type entity : "+entity);           
            System.out.println("++ "+abonne.toString()+""+abonne.getCode()+""+abonne.getEmail()); 
            appart.setDateAjout(new Date());
            appart.setDateModif(new Date());
            appart.setPrix(Double.valueOf(prix));
            appart.setTitre(titre);
            appart.setDescription(desc);
            appart.setActive(act);
            appart.setActiveAdmin(true);
                    if(tbleu.equals("oui")){
                    appart.setTitreBleau(true);
                    }else{
                    appart.setTitreBleau(false);
                    }
            appart.setSuperficieTotal(Integer.parseInt(sprfto));
            appart.setAbonne(abonne);
            appart.setDeleg(d);        
            appart.setType(t);
            appart.setGov(gl.valueOf(contry.toString()));                      
            appart.setSuperficieHabitable(Integer.parseInt(sprfha));
            appart.setAnneeConstruction(Integer.parseInt(annconst));
            appart.setNbrDePiece(Integer.parseInt(nbrpc));
            appart.setSalon(Integer.parseInt(nbrsa));
            appart.setChambre(Integer.parseInt(nbrch));
            appart.setSalleDeBain(Integer.parseInt(nbrslb));
            appart.setCuisine(Integer.parseInt(nbrcui));
            appart.setWc(Integer.parseInt(wc));
                 if(balcon.equals("oui")){
                appart.setBalcon(true);
                }else{
                appart.setBalcon(false);
                } 
                if(clim.equals("oui")){
                    appart.setClimatisation(true);
                }else{
                    appart.setClimatisation(false);
                }
                if(chauf.equals("oui")){
                    appart.setChauffage(true);
                }else{
                    appart.setChauffage(false);
                } 
             appart.setNumEtage(Integer.parseInt(numetage));
                if(assen.equals("oui")){
                    appart.setAssenceur(true);
                }else{
                    appart.setAssenceur(false);
                }
                if(park.equals("oui")){
                    appart.setParking(true);
                }else{
                    appart.setParking(false);
                }
                if(sand.equals("oui")){
                    appart.setSandic(true);
                }else{
                    appart.setSandic(false);
                }
             
            ap = appartementDao.addAppartement(appart);
            System.out.println(ap.toString());  
            response.sendRedirect("profil");
        }else if(entity.equals("villa")){
            t = annonceTypeDao.addTypeAnno(annonceType);
            delegation.setRegion(delg);       
            d =delegationDao.addDel(delegation);
            System.out.println("type entity : "+entity);           
            System.out.println("++ "+abonne.toString()+""+abonne.getCode()+""+abonne.getEmail()); 
            villa.setDateAjout(new Date());
            villa.setDateModif(new Date());
            villa.setPrix(Double.parseDouble(prix));
            villa.setTitre(titre);
            villa.setDescription(desc);
            villa.setActive(act);
            villa.setActiveAdmin(true);
                    if(tbleu.equals("oui")){
                    villa.setTitreBleau(true);
                    }else{
                    villa.setTitreBleau(false);
                    }
            villa.setSuperficieTotal(Integer.parseInt(sprfto));
            villa.setAbonne(abonne);
            villa.setDeleg(d);        
            villa.setType(t);
            villa.setGov(gl.valueOf(contry.toString()));                
            villa.setSuperficieHabitable(Integer.parseInt(sprfha));
            villa.setAnneeConstruction(Integer.parseInt(annconst));
            villa.setNbrDePiece(Integer.parseInt(nbrpc));
            villa.setSalon(Integer.parseInt(nbrsa));
            villa.setChambre(Integer.parseInt(nbrch));
            villa.setSalleDeBain(Integer.parseInt(nbrslb));
            villa.setCuisine(Integer.parseInt(nbrcui));
            villa.setWc(Integer.parseInt(wc));
                if(balcon.equals("oui")){
                villa.setBalcon(true);
                }else{
                villa.setBalcon(false);
                } 
                if(clim.equals("oui")){
                    villa.setClimatisation(true);
                }else{
                    villa.setClimatisation(false);
                }
                if(chauf.equals("oui")){
                    villa.setChauffage(true);
                }else{
                    villa.setChauffage(false);
                } 
            villa.setNbrEtage(Integer.parseInt(nbretage));
                if(jardin.equals("oui")){
                villa.setJardin(true);
                }else{
                villa.setJardin(false);
                }
                if(garage.equals("oui")){
                villa.setGarage(true);
                }else{
                villa.setGarage(false);
                }
                if(piscine.equals("oui")){
                villa.setPiscine(true);
                }else{
                villa.setPiscine(false);
                }
            vil = villaDao.addVilla(villa);
            System.out.println(vil.toString());  
         System.out.println(abonne.toString());  
         response.sendRedirect("profil");
        }else if(entity.equals("depot")){
            t = annonceTypeDao.addTypeAnno(annonceType);
            delegation.setRegion(delg);       
            d =delegationDao.addDel(delegation);
             System.out.println("type entity : "+entity);           
            System.out.println("++ "+abonne.toString()+""+abonne.getCode()+""+abonne.getEmail()); 
            depot.setDateAjout(new Date());
            depot.setDateModif(new Date());
            depot.setPrix(Double.parseDouble(prix));
            depot.setDescription(desc);
            depot.setTitre(titre);
            depot.setActive(act);
            depot.setActiveAdmin(true);
                    if(tbleu.equals("oui")){
                    depot.setTitreBleau(true);
                    }else{
                    depot.setTitreBleau(false);
                    }
            depot.setSuperficieTotal(Integer.parseInt(sprfto));
            depot.setAbonne(abonne);
            depot.setDeleg(d);        
            depot.setType(t);
            depot.setGov(gl.valueOf(contry.toString()));                       
            depot.setAnneeConstruction(Integer.parseInt(annconstdepot));
            depot.setSuperficieCouvert(Integer.parseInt(sprcou));
            dep = depotDao.addDepot(depot);
            System.out.println(dep.toString()); 
            response.sendRedirect("profil");
        }else if(entity.equals("terrain")){
            t = annonceTypeDao.addTypeAnno(annonceType);
            delegation.setRegion(delg);       
            d =delegationDao.addDel(delegation);
         System.out.println("type entity : "+entity);           
            System.out.println("++ "+abonne.toString()+""+abonne.getCode()+""+abonne.getEmail()); 
            terrain.setDateAjout(new Date());
            terrain.setDateModif(new Date());
            terrain.setPrix(Double.parseDouble(prix));
            terrain.setDescription(desc);
            terrain.setTitre(titre);
            terrain.setActive(act);
            terrain.setActiveAdmin(true);
                    if(tbleu.equals("oui")){
                    terrain.setTitreBleau(true);
                    }else{
                    terrain.setTitreBleau(false);
                    }
            terrain.setSuperficieTotal(Integer.parseInt(sprfto));
            terrain.setAbonne(abonne);
            terrain.setDeleg(d);        
            terrain.setType(t);
            terrain.setGov(gl.valueOf(contry.toString()));                
                    if(zonne.equals("villa")){
                    terrain.setTerainType(TypeTerain.VILLA);
                    }else if(zonne.equals("indist")){
                    terrain.setTerainType(TypeTerain.INDUSTRIEL);
                    }else if(zonne.equals("agricole")){
                    terrain.setTerainType(TypeTerain.AGRICOLE);
                    }else{
                    terrain.setTerainType(TypeTerain.TOURISTIQUE);                    
                    }
            tr=terainDao.addTerain(terrain);
            System.out.println("++ "+tr.toString()+"---"+tr.getTerainType());
            response.sendRedirect("profil");
        }else{
             response.sendRedirect("profil");     
        }      
    }
}
