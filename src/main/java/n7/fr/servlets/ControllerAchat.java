package n7.fr.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import n7.fr.metier.Facade;
import n7.fr.metier.Materiel;
import n7.fr.metier.Panier;
import n7.fr.metier.Utilisateur;

/**
 * Servlet implementation class ControllerAchat
 */
@WebServlet("/ControllerAchat")
public class ControllerAchat extends HttpServlet {
	@EJB
	Facade facade;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAchat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int matoId = Integer.parseInt(request.getParameter("mato-id"));
		String option = request.getParameter("achat-op");
		switch (option) {
		case "Reserver" : 
			Materiel matoConcerne = facade.trouverMaterielParId(matoId);
			request.getSession().setAttribute("mato", matoConcerne);
			response.sendRedirect("checkout.jsp");
			break;
		default:
            // Invalid option
            response.sendRedirect("error.html");
            break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String actionAchat = request.getParameter("achat-op");
		int matoId = Integer.parseInt(request.getParameter("mato-id"));
		if (actionAchat != null) {
			// Recupérer la session liée à l'utilisateur
			HttpSession session = request.getSession();
			Utilisateur user = (Utilisateur)session.getAttribute("user");
			facade.ajouterArticlePanier(user.getId(),matoId);
            switch (actionAchat) {
                case "ajouter-panier":
            		//Récuperer le panier de la session ou le creer s'il il n ya pas          		
                	request.getRequestDispatcher("ordinateur.jsp").forward(request, response);
                    break;
                case "reserver":
                	//response.sendRedirect("checkout.jsp");
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

}
