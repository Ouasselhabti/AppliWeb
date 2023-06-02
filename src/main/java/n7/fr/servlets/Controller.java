package n7.fr.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import n7.fr.metier.Facade;
import n7.fr.metier.Utilisateur;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	@EJB
	Facade facade;
	private static final long serialVersionUID = 1L;
	private static final String code = "zakariaelpulga";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.invalidate();*/
		//response.sendRedirect("login.html");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("operation");

        if (option != null) {
            switch (option) {
                case "login":
                    performLogin(request, response);
                    break;
                case "register":
                	redirectToRegister(response);
                    break;
                case "loginAdmin":
                	redirectAdmin(request, response);
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
	// des methodes privées chacune respensable a une tache (registration , login ....) 
    private void performLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve username and password from the request
        String userMail = request.getParameter("userMail");
        String password = request.getParameter("passWord");
        
        // Validate the username and password
        if (userMail != null && !userMail.isEmpty() && password != null && !password.isEmpty()) {
            // Perform login operation
            // ...
        	 if(facade.checkLoginInfo(userMail,password)) {
        		 // Redirect to a success page after login
        		 HttpSession session = request.getSession();
        		 session.setAttribute("user",facade.getUserParMail(userMail));
        		 response.sendRedirect("home.jsp");        		 
        	 } else {
        		 response.sendRedirect("error.html");
        	 }
        } else {
            // Invalid username or password
            response.sendRedirect("error.html");
            
        }
    }
    

    private void redirectToRegister(HttpServletResponse response) throws IOException {
        // Set the appropriate response parameters to redirect to the register.html page
        response.sendRedirect("register.html");
    }
    
	private void redirectAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String codeFourni = request.getParameter("codesecret");
		if(codeFourni.equals(code)) {
			response.sendRedirect("adminhome.jsp");
		} else {
			response.sendRedirect("error.html");
		}
	}

}

