package n7.fr.servlets;

import n7.fr.metier.Facade;
import n7.fr.metier.Panier;
import n7.fr.metier.Utilisateur;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ControllerPanier", urlPatterns = {"/ControllerPanier"})
public class ControllerPanier extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
	@EJB
    private Facade facade;

     /**
     
@see HttpServlet#HttpServlet()*/
  public ControllerPanier() {
      super();// TODO Auto-generated constructor stub}
  }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupération de l'utilisateur depuis la session
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");

        if(utilisateur != null) {
            // Ajout de l'utilisateur à la requête
            request.setAttribute("utilisateur", utilisateur);
            request.getRequestDispatcher("panier.jsp").forward(request, response);
        } else {
            // Si l'utilisateur n'est pas connecté, redirigez-le vers la page de connexion
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}