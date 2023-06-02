package n7.fr.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import n7.fr.metier.*;
/**
 * Servlet implementation class ControlShowUSers
 */
@WebServlet("/ControlShowUSers")
public class ControlShowUSers extends HttpServlet {
	@EJB
	Facade facade;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlShowUSers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   /*String option = request.getParameter("option");

		   if (option != null) {
		      switch (option) {
		         case "showUsers":
		            List<Utilisateur> utilisateurs = facade.trouverTousLesUtilisateurs();
		            request.setAttribute("utilisateurs", utilisateurs);
		            request.getRequestDispatcher("showUsers.jsp").forward(request, response);
		            break;
		         case "showMaterials":
		            List<Materiel> materials = facade.trouverTousLesMateriels();
		            request.setAttribute("materials", materials);
		            request.getRequestDispatcher("showMat.jsp").forward(request, response);
		            break;
		         // Add more cases for other options as needed
		         default:
		            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid option");
		            break;
		      }
		   } else {
		      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Option parameter not provided");
		   }*/
	      List<Utilisateur> utilisateurs = facade.trouverTousLesUtilisateurs();
	      request.setAttribute("users", utilisateurs);
	      request.setAttribute("contextpath", request.getContextPath());
	      request.setAttribute("servletpath", request.getServletPath());
	      RequestDispatcher dispatcher = request.getRequestDispatcher("showUsers.jsp");
	      dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
