package no.hvl.dat108;

import static no.hvl.dat108.UrlKart.LISTE_URL;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InnloggingServlet
 */
@WebServlet(name="InnloggingServlet", urlPatterns="/Oblig2.2/InnloggingServlet")
public class InnloggingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
        //response.setContentType("text/html; charset=ISO-8859-1");
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Login</title>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<form method=\"post\">");
        out.println("  <fieldset>");
        out.println("    <legend>Login</legend>");
        out.println("    <p>Brukernavn: <input type=\"text\" name=\"username\" /></p>");
        out.println("    <p>Passord   : <input type=\"password\" name=\"password\" /></p>");
        out.println("    <p><input type=\"submit\" value=\"Logg inn\" /></p>");
        out.println("  </fieldset>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Inn noe kode her i forbindelse med innlogging av bruker?
    	String username = request.getParameter("username");
    	
		final int MAX_INACTIVE_INTERVAL = Integer.parseInt(getInitParameter("inactiveInterval"));
		String userPass = request.getParameter("password");
		String password = getInitParameter("passwordet");
		
		
		if (!userPass.equals(password) || !Validering.isValidUsername(username)) {
			response.sendRedirect("/Oblig2.2/FeilpassordServlet");
		}else {
    		
    		//Innlogging:
    		HttpSession sesjon = request.getSession(false);
    		if (sesjon != null) {
    			sesjon.invalidate();
    		}    		
    		
    		sesjon = request.getSession(true);
    		sesjon.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);
    		sesjon.setAttribute("username", username);
    		sesjon.setAttribute("liste", new Handleliste());
    		
    		
    	    response.sendRedirect(LISTE_URL);
    	}
	}

}
