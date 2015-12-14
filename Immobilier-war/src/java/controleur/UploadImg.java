/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.Part;
import dao.GetsAnnonceDao;
import dao.ImageDao;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AnnonceBien;
import model.Image;

/**
 *
 * @author abdo
 */
@WebServlet(name = "UploadImg", urlPatterns = {"/uploadImg"})
@MultipartConfig
public class UploadImg extends HttpServlet {
@EJB
private ImageDao imageDao;
@EJB
private GetsAnnonceDao getsAnnonceDao;
public static final String VUE = "/WEB-INF/upload.jsp";
private String fileSavePath;
    private static final String UPLOAD_DIRECTORY = "MesImage";

    public void init() {
        fileSavePath = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIRECTORY;
                                System.out.println(fileSavePath+ " ......");
                                if (!(new File(fileSavePath)).exists()) {
                                    (new File(fileSavePath)).mkdir();      
                                }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String id = request.getParameter("an");
        request.setAttribute("an", id);
        AnnonceBien trvA =  new AnnonceBien();
        trvA =(AnnonceBien)getsAnnonceDao.trvAnnonce(Long.parseLong(id)); 
        request.setAttribute("annonceimage", trvA);
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        /*Part k = (Part) request.getPart("txt");
        System.out.println(k.toString());*/
        String id = request.getSession().getAttribute("idan").toString();
        AnnonceBien bien = getsAnnonceDao.trvAnnonce(Long.parseLong(id));
        System.out.print("sadsdasd"); 
        //String desc = request.getParameter("desc");
                            System.out.println(id+"*****************");
        try {
			File dm =new File("//images//upload//"); 
			dm.mkdir();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
                         System.out.print("cqnnot make dir");
		}	
		   String resp = "";
	        int i = 1;
	        resp += "<br>Here is information about uploaded files.<br>";
	        try {
	            MultipartParser parser = new MultipartParser(request, 1024 * 1024 * 1024);  /* file limit size of 1GB*/
	            Part _part;
	            while ((_part = parser.readNextPart()) != null) {
	                if (_part.isFile()) {
	                    FilePart fPart = (FilePart) _part;  // get some info about the file
	                    String name = fPart.getFileName();
                                fileSavePath = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIRECTORY+("/")+id;
                                System.out.println(fileSavePath+ " ......");
                                if (!(new File(fileSavePath)).exists()) {
                                    (new File(fileSavePath)).mkdir();      
                                }
                                Image image = new Image();
                                image.setBien(bien); 
                                image.setUrl(id+"/"+name);
                                imageDao.addImage(image);
                                
                            System.out.println(name); 
	                    if (name != null) {
	                        long fileSize = fPart.writeTo(new File(fileSavePath));
	                        resp += i++ + ". " + fPart.getFilePath() + "[" + fileSize / 1024 + " KB]<br>";
	                    } else {
	                        resp = "<br>The user did not upload a file for this part.";
	                    }
	                }
	            }// end while 
	        } catch (java.io.IOException ioe) {
	            resp = ioe.getMessage();
                    System.out.print("erreur ulpoad");
	        }
	        //getServletContext().getRequestDispatcher("accueil").forward(request, response);
                response.sendRedirect("profil");
    }
    }