package n7.fr.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.persistence.criteria.Path;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import n7.fr.metier.Facade;
import n7.fr.metier.Materiel;
import java.util.*;
/**
 * Servlet implementation class ControllerAdmin
 */
@WebServlet("/ControllerAdmin")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ControllerAdmin extends HttpServlet {
	@EJB
	Facade facade;
	private static final long serialVersionUID = 1L;
	private final static String uploadPath = "/home/ouassel/eclipse-workspace/ProjetEcole/src/main/webapp/images";
	private final static String uploadPath2 = "../../../webapp/images";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> paths = facade.trouverTousLesMateriels().stream().map(Materiel::getImagePath).collect(Collectors.toList());
		request.setAttribute("paths", paths);
		request.getRequestDispatcher("showpathtest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operation = request.getParameter("operation");
        if (operation != null) {
            switch (operation) {
                case "ajouterMateriel":
                    performAjout(request, response);
                    break;
                case "ListerMatos":
                	performListerMatos(request, response);
                    break;
                default:
                    // Invalid option
                    response.sendRedirect("error.html");
                    break;
            }
        } else {
            // No option specified
            response.sendRedirect("error.html");
        }
	}

	
	private void performListerMatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String,List<Materiel>> allMatos = new HashMap<>();
		List<Materiel> mat = facade.trouverMaterielDisponible();
		for (int i = 0 ; i < Facade.totalTypeNumber ; i++) {
			allMatos.put(Facade.itemsAndType.get(i), facade.filtrerParType(mat,i));
		}
		request.getSession().setAttribute("allMatos",allMatos);
		response.sendRedirect("ListerMatos.jsp");
		
	}

	private void performAjout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String nomMat = request.getParameter("nom");
			String descMat = request.getParameter("description");
			String prixString = request.getParameter("prix");
			String typeMatos = request.getParameter("typemateriel");
			int type = getTypeFromString(typeMatos);
			float prix = Float.parseFloat(prixString);
			/* Traiter le chargement d'image */
			Part imagePart = request.getPart("image");
			String fileName = imagePart.getSubmittedFileName();
			String imagePath = uploadPath + File.separator + fileName;
	        File imageFile = new File(imagePath);
	        
	        // Check if the image file already exists
	        if (imageFile.exists()) {
	            // Delete the existing file
	            imageFile.delete();
	        }
	        
	        // Write the new image file
	        imagePart.write(imagePath);
	        
	        
			facade.creerMateriel(nomMat, descMat,type, prix,"./images"+File.separator+fileName, true);
			response.sendRedirect("adminhome.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.sendRedirect("error.html");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
		}
	}

	private static int getTypeFromString(String typeMatos) {
		int ret = -1;
		switch (typeMatos) {
		case "Ordinateur" :
			ret = 0;
			break;
		case "Telephone" : 
			ret = 1;
			break;
		case "Tablette" : 
			ret = 2;
			break;
		case "Television" : 
			ret = 3;
			break;
		case "Calculatrice":
			ret = 4;
			break;
		case "Camera":
			ret = 5;
			break;
		case "Imprimante":
			ret = 6;
			break;
		case "Accessoire":
			ret = 7;
		}
		return ret ;
	}
}
