package no.hvl.data108;

import static no.hvl.data108.UrlKart.FERDIG_URL;
import static no.hvl.data108.UrlKart.LOGIN_URL;
import static no.hvl.data108.UrlKart.SKJEMA_URL;
import static no.hvl.data108.UrlKart.BEKREFTELSE_URL;
import static no.hvl.data108.UrlKart.LISTE_URL;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/ListeServlet")
@WebServlet(name="ListeServlet", urlPatterns="/ListeServlet")
public class ListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);

        if (sesjon == null || sesjon.getAttribute("username") == null) {
            response.sendRedirect(LOGIN_URL + "?requiresLogin");
        } else {
        	request.setAttribute("LISTE_URL", LISTE_URL);
        	request.setAttribute("FERDIG_URL", FERDIG_URL);
            request.getRequestDispatcher("WEB-INF/deltagerliste_MAL.jsp")
            		.forward(request, response);
        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(FERDIG_URL);
	}

}
