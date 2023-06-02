package n7.fr.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import n7.fr.metier.Facade;
import n7.fr.metier.Materiel;
import n7.fr.metier.Utilisateur;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	@EJB
	Facade facade;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choix = request.getParameter("choix");

		List<Materiel> matos = facade.trouverMaterielDisponible();
		   if (choix != null) {
		      switch (choix) {
		         case "Ordinateurs":
		            List<Materiel> ordinateurs = facade.filtrerParType(matos, 0);
		            request.setAttribute("matos", ordinateurs);
		            request.getRequestDispatcher("ordinateur.jsp").forward(request, response);
		            break;
		         case "Telephone":
			        List<Materiel> telephones = facade.filtrerParType(matos, 1);
			        request.setAttribute("matos", telephones);
		            request.getRequestDispatcher("ordinateur.jsp").forward(request, response);
		            break;
		         case "Tablette":
				    List<Materiel> tablettes = facade.filtrerParType(matos, 2);
				    request.setAttribute("matos", tablettes);
		            request.getRequestDispatcher("ordinateur.jsp").forward(request, response);
		            break;
		         case "Tele":
					List<Materiel> televisions = facade.filtrerParType(matos, 3);
					request.setAttribute("matos", televisions);
		            request.getRequestDispatcher("ordinateur.jsp").forward(request, response);
		            break;
		         case "Console":
		        	List<Materiel> consoles = facade.filtrerParType(matos, 4);
		        	request.setAttribute("matos", consoles);
		            request.getRequestDispatcher("ordinateur.jsp").forward(request, response);
		            break;
		         case "Camera":
			        List<Materiel> cameras = facade.filtrerParType(matos, 5);
			        request.setAttribute("matos", cameras);
		            request.getRequestDispatcher("ordinateur.jsp").forward(request, response);
		            break;
		         case "Imprimante":
				    List<Materiel> imprimantes = facade.filtrerParType(matos, 6);
				    request.setAttribute("matos", imprimantes);
		            request.getRequestDispatcher("ordinateur.jsp").forward(request, response);
		            break;
		         case "Accessoire":
		            // Retrieve accessoire data from the facade and forward to the corresponding JSP
		            break;
		         default:
		            response.sendRedirect("error.html");
		            break;
		      }
		   } else {
		      response.sendRedirect("error.html");
		   }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
