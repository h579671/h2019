package no.hvl.data108;

import static no.hvl.data108.UrlKart.FERDIG_URL;
import static no.hvl.data108.UrlKart.LOGIN_URL;
import static no.hvl.data108.UrlKart.SKJEMA_URL;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/FerdigServlet")
@WebServlet(name="FerdigServlet", urlPatterns="/FerdigServlet")
public class FerdigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);

        if (sesjon == null || sesjon.getAttribute("username") == null) {
            response.sendRedirect(LOGIN_URL + "?requiresLogin");
        } else {
        	request.setAttribute("SKJEMA_URL", SKJEMA_URL);
        	request.setAttribute("FERDIG_URL", FERDIG_URL);
            request.getRequestDispatcher("WEB-INF/ferdig_MAL.jsp")
            		.forward(request, response);
        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(LOGIN_URL);
	}

}
