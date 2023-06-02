package n7.fr.servlets;


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import n7.fr.metier.Facade;

/**
 * Servlet implementation class ControllerRegister
 */
@WebServlet("/ControllerRegister")
public class ControllerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	Facade facade;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("operation");

        if (option != null) {
            switch (option) {
                case "Finish Registration":
                    performRegistration(request, response);
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
	
	
    private void performRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve registration details from the request
        String userMail = request.getParameter("userMail");
        String password = request.getParameter("passWord");
        String userFname = request.getParameter("userFname");
        String userLname = request.getParameter("userLname");

        // Validate the registration details
        if (userMail != null && !userMail.isEmpty() && password != null && !password.isEmpty() &&
                userFname != null && !userFname.isEmpty() && userLname != null && !userLname.isEmpty()) {
            // Perform registration operation
            // ...
        	if (facade.creerUtilisateur(userLname, userFname, userMail, password)==1) {        	
        		// Redirect to a success page after registration
        		response.sendRedirect("success.html");
        	} else {
        		response.sendRedirect("error.html");
        	}
        } else {
            // Invalid registration details
            response.sendRedirect("error.html");
        }
    }

}
