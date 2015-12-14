/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
import dao.AppartementDao;
import dao.DepotDao;
import dao.GetsAnnonceDao;
import dao.HabitableDao;
import dao.ImageDao;
import dao.TerainDao;
import dao.VillaDao;
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
import model.AnnonceType;
import model.Appartement;
import model.Depot;
import model.Gov;
import model.Habitable;
import model.Image;
import model.Studio;
import model.Terain;
import model.TypeAnnonce;
import model.TypeTerain;
import model.Villa;

/**
 *
 * @author abdo
 */
@WebServlet(name = "Recherche", urlPatterns = {"/recherche"})
public class Recherche extends HttpServlet {
    @EJB
    private GetsAnnonceDao getsAnnonceDao;
    @EJB
    private HabitableDao habitableDao;
    @EJB
    private AppartementDao appartementDao;
    @EJB
    private VillaDao villaDao;
    @EJB
    private TerainDao terainDao;
    @EJB
    private DepotDao depotDao;
    @EJB
    private ImageDao imageDao;
    private AnnonceType typeann = new AnnonceType();
    private AnnonceBien bien = new AnnonceBien();
    private Studio studio = new Studio();
    private Habitable habitable = new Habitable();
    private Appartement appartement = new Appartement();
    private Villa villa = new Villa();
    private  Gov gov;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Recherche</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Recherche at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        /*List<String> govs=new ArrayList<String>();
                        for(Gov g : Gov.values()){
                         //System.out.println(g);
                         govs.add(g.toString());
                        }
                         request.getSession().getServletContext().setAttribute("governorat", govs);*/
        //request.getSession().getServletContext().getAttribute("accueillist");
        this.getServletContext().getRequestDispatcher("/WEB-INF/recherche.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        //hidden
        String entity = request.getParameter("entity");
        //AnnonceBien
        String type = request.getParameter("type"); String minprix = request.getParameter("minprix"); String maxprix = request.getParameter("maxprix");
        String sprftomin = request.getParameter("sprftomin"); String sprftomax = request.getParameter("sprftomax");
        String country = request.getParameter("country"); 
        //habitable +studio
        String sprfhamin = request.getParameter("sprfhamin"); String sprfhamax = request.getParameter("sprfhamax");
        String nbrpcmin = request.getParameter("minnbpc"); String nbrpcmax = request.getParameter("maxnbpc");
        String balcon = request.getParameter("balcon"); String clim = request.getParameter("clim"); String chauf = request.getParameter("chauf");
        //appartement
        String numetgmin = request.getParameter("numetgmin"); String numetgmax = request.getParameter("numetgmax"); 
        String assen = request.getParameter("assenc"); String parking = request.getParameter("parking"); String sandic = request.getParameter("sandic");
        //Villa
        String nbretgmin = request.getParameter("nbretgmin"); String nbretgmax = request.getParameter("nbretgmax");
        String jardin = request.getParameter("jardin"); String garage = request.getParameter("garage"); String piscine = request.getParameter("piscine");
        //depot
        String sprfcouvmin = request.getParameter("sprfcovmin"); String sprfcouvmax = request.getParameter("sprfcovmax");
        //Terain
        String zonne = request.getParameter("zonne");
       // System.out.println(entity+"--"+type+""+minprix+""+maxprix+"-----"+sprftomin+"----"+sprftomax+"---"+country);
                    if(type.equals("vente")){
                    typeann.setTypeAnnonce(TypeAnnonce.VENTE);
                    }else if(type.equals("location")){
                    typeann.setTypeAnnonce(TypeAnnonce.LOCATION);
                    }else if(type.equals("colocation")){
                    typeann.setTypeAnnonce(TypeAnnonce.COLOCATION);
                    }else if(type.equals("locationvac")){
                    typeann.setTypeAnnonce(TypeAnnonce.LOCATIONVACANCES);
                    }
        //System.out.println(country); 
        Gov gl=null;
        List<Image> listeImage = new ArrayList<Image>();
       if(entity.equals("annonce")){
           List<AnnonceBien> list;
            System.out.println(entity);
             list=getsAnnonceDao.cherhceAnnonce(typeann,true,Double.parseDouble(minprix),Double.parseDouble(maxprix),Integer.parseInt(sprftomin),Integer.parseInt(sprftomax),gl.valueOf(country.toString()));                       
           Map<AnnonceBien, List<Image>> maplist = new HashMap<AnnonceBien, List<Image>>();
            for(AnnonceBien b:list){
            System.out.println(b.getDescription()+"bien+++++++++++++");
            listeImage = imageDao.getsAllImageBien(b.getId());
            maplist.put(b, listeImage);
            }
            request.getSession().getServletContext().setAttribute("accueillist",maplist);
        this.getServletContext().getRequestDispatcher("/WEB-INF/recherche.jsp").forward(request, response);
       }else if(entity.equals("studio")){ /////////////////habitable studio          
            System.out.println(entity);
                    boolean balc=false;
                    boolean climbol=false;
                    boolean chaufbol=false;
                    if(balcon.equals("oui")){
                        balc=true;
                    }
                    if(clim.equals("oui")){
                        climbol=true;
                    }
                    if(chauf.equals("oui")){
                        chaufbol=true;
                    }
                   List<Habitable> listhabitable; 
                   System.out.println(gl.valueOf(country.toString()));
                   listhabitable=habitableDao.cherhceAnnonce(typeann,true,Double.parseDouble(minprix),Double.parseDouble(maxprix),Integer.parseInt(sprftomin),Integer.parseInt(sprftomax),gl.valueOf(country.toString()),Integer.parseInt(sprfhamin),Integer.parseInt(sprfhamax),Integer.parseInt(nbrpcmin),Integer.parseInt(nbrpcmax),balc,climbol,chaufbol);                                 
                   Map<Habitable, List<Image>> maphabitable = new HashMap<Habitable, List<Image>>();     
                   for(Habitable b:listhabitable){
                        System.out.println(b.getDescription()+"habitable+ studio+++++++++++++");
                        listeImage = imageDao.getsAllImageBien(b.getId());
                        maphabitable.put(b, listeImage);
                        }
                        
        request.getSession().getServletContext().setAttribute("accueillist",maphabitable);
        this.getServletContext().getRequestDispatcher("/WEB-INF/recherche.jsp").forward(request, response);
       }else if(entity.equals("terrain")){
       System.out.println(entity);
            TypeTerain terainType;
            if(zonne.equals("villa")){
            terainType=TypeTerain.VILLA;
            }else if(zonne.equals("indist")){
            terainType=TypeTerain.INDUSTRIEL;
            }else if(zonne.equals("agricole")){
            terainType=TypeTerain.AGRICOLE;
            }else{
            terainType=TypeTerain.TOURISTIQUE;
            }
            List<Terain> listTerain; 
            listTerain=terainDao.cherhceAnnonce(typeann,true,Double.parseDouble(minprix),Double.parseDouble(maxprix),Integer.parseInt(sprftomin),Integer.parseInt(sprftomax),gl.valueOf(country.toString()),terainType);               
            Map<Terain, List<Image>> maplistterain = new HashMap<Terain, List<Image>>();
            for(Terain b:listTerain){
            System.out.println(b.getDescription()+"bien+++++++++++++");
            listeImage = imageDao.getsAllImageBien(b.getId());
            maplistterain.put(b, listeImage);
            }
            request.getSession().getServletContext().setAttribute("accueillist",maplistterain);
            this.getServletContext().getRequestDispatcher("/WEB-INF/recherche.jsp").forward(request, response);
       }else if(entity.equals("appartement")){ ///////////appartement
       System.out.println(entity);
                    boolean balc=false;
                    boolean climbol=false;
                    boolean chaufbol=false;
                    boolean assbol=false;
                    boolean parkbol=false;
                    boolean sandbol=false;
                    if(balcon.equals("oui")){
                        balc=true;
                    }
                    if(clim.equals("oui")){
                        climbol=true;
                    }
                    if(chauf.equals("oui")){
                        chaufbol=true;
                    }
                    if(assen.equals("oui")){
                        assbol=true;
                    }
                    if(parking.equals("oui")){
                        parkbol=true;
                    }
                    if(sandic.equals("oui")){
                        sandbol=true;
                    }
                   List<Appartement> listAppart=new ArrayList<Appartement>();
         System.out.println(country+"-----"+typeann.toString()+"----"+Double.parseDouble(minprix)+"--"+Double.parseDouble(maxprix)+"--"+Integer.parseInt(sprftomin)+"--"+Integer.parseInt(sprftomax)+"--"+gl.valueOf(country.toString())+"--"+Integer.parseInt(sprfhamin)+"--"+Integer.parseInt(sprfhamax)+"--"+Integer.parseInt(nbrpcmin)+"--"+Integer.parseInt(nbrpcmax)+"--"+balc+"--"+climbol+"--"+chaufbol+"--"+Integer.parseInt(numetgmin)+"--"+Integer.parseInt(numetgmax)+"--"+assbol+"--"+parkbol+"--"+sandbol);           
                    listAppart=appartementDao.cherhceAnnonce(typeann,true,Double.parseDouble(minprix),Double.parseDouble(maxprix),Integer.parseInt(sprftomin),Integer.parseInt(sprftomax),gl.valueOf(country.toString()),Integer.parseInt(sprfhamin),Integer.parseInt(sprfhamax),Integer.parseInt(nbrpcmin),Integer.parseInt(nbrpcmax),balc,climbol,chaufbol,Integer.parseInt(numetgmin),Integer.parseInt(numetgmax),assbol,parkbol,sandbol);                              
                    Map<Appartement, List<Image>> maplistappart = new HashMap<Appartement, List<Image>>();
                    for(Appartement b:listAppart){
                    System.out.println(b.getDescription()+"apartemnet+++++");
                    listeImage = imageDao.getsAllImageBien(b.getId());
                    maplistappart.put(b, listeImage);
                    }
            request.getSession().getServletContext().setAttribute("accueillist",maplistappart);
            this.getServletContext().getRequestDispatcher("/WEB-INF/recherche.jsp").forward(request, response);
       }else if(entity.equals("villa")){//////////////villa
                List<Villa> listvilla; 
            System.out.println(entity);
            boolean balc=false;
            boolean climbol=false;
            boolean chaufbol=false;
            boolean jardbol=false;
            boolean gargbol=false;
            boolean piscbol=false;
                if(balcon.equals("oui")){
                    balc=true;
                }
                if(clim.equals("oui")){
                    climbol=true;
                }
                if(chauf.equals("oui")){
                    chaufbol=true;
                }
                if(jardin.equals("oui")){
                    jardbol=true;
                }
                if(garage.equals("oui")){
                    gargbol=true;               
                }
                if(piscine.equals("oui")){
                    piscbol=true;
                }
            listvilla=villaDao.cherhceAnnonce(typeann,true,Double.parseDouble(minprix),Double.parseDouble(maxprix),Integer.parseInt(sprftomin),Integer.parseInt(sprftomax),gl.valueOf(country.toString()),Integer.parseInt(sprfhamin),Integer.parseInt(sprfhamax),Integer.parseInt(nbrpcmin),Integer.parseInt(nbrpcmax),balc,climbol,chaufbol,Integer.parseInt(nbretgmin),Integer.parseInt(nbretgmax),jardbol,gargbol,piscbol);                      
            Map<Villa, List<Image>> maplistvilla = new HashMap<Villa, List<Image>>();
            for(Villa b:listvilla){
            System.out.println(b.getDescription()+"villa+++++++");
             listeImage = imageDao.getsAllImageBien(b.getId());
              maplistvilla.put(b, listeImage);
            }
             request.getSession().getServletContext().setAttribute("accueillist",maplistvilla);
            this.getServletContext().getRequestDispatcher("/WEB-INF/recherche.jsp").forward(request, response);
       }else{
             System.out.println(entity);
                List<Depot> listDepot;
            System.out.println(entity);
            listDepot=depotDao.cherhceAnnonce(typeann,Double.parseDouble(minprix),Double.parseDouble(maxprix),Integer.parseInt(sprftomin),Integer.parseInt(sprftomax),gl.valueOf(country.toString()),Integer.parseInt(sprfcouvmin),Integer.parseInt(sprfcouvmax));       
            Map<Depot, List<Image>> maplistdepot = new HashMap<Depot, List<Image>>();
            for(Depot b:listDepot){
            System.out.println(b.getDescription()+"depot+++++++++");
            listeImage = imageDao.getsAllImageBien(b.getId());
            maplistdepot.put(b, listeImage);
            }                 
            request.getSession().getServletContext().setAttribute("accueillist",maplistdepot);
            this.getServletContext().getRequestDispatcher("/WEB-INF/recherche.jsp").forward(request, response);
        }
   }
}
