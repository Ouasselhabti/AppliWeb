package n7.fr.servlets;

import n7.fr.metier.Facade;
import n7.fr.metier.Panier;
import n7.fr.metier.Utilisateur;
import n7.fr.metier.Materiel;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/checkout")
public class ControllerCheckout extends HttpServlet {
    @EJB
    private Facade facade;
	private static List<Integer> materielIds = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // On récupère l'utilisateur de la session
        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("user");

        if(utilisateur != null) {
                // Récupère la durée de l'emprunt de la requête
                //int dureeEmprunt = Integer.parseInt(req.getParameter("loanDuration"));
        		int dureeEmprunt = 1000;
                // Créer l'emprunt
        		materielIds.add(Integer.parseInt(request.getParameter("idmato")));
                facade.creerEmprunt(utilisateur.getId(), materielIds, dureeEmprunt);
                Object[] emprunt = {materielIds, dureeEmprunt};
                request.getSession().setAttribute("Emprunt", emprunt);
                request.getSession().setAttribute("facade",facade);
                // Vide le panier
                //facade.clearPanier(utilisateur.getId());
                
                // redirige vers la page de confirmation
                //resp.sendRedirect("mesLocations.jsp");
            }
        
        else {
            resp.sendRedirect("login.jsp");
        }
    }
}