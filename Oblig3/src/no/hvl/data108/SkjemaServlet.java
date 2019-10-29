package no.hvl.data108;

import static no.hvl.data108.UrlKart.BEKREFTELSE_URL;
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


@WebServlet(name="SkjemaServlet", urlPatterns="/SkjemaServlet")
public class SkjemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession sesjon = request.getSession(false);

	        if (sesjon == null || sesjon.getAttribute("username") == null) {
	            response.sendRedirect(LOGIN_URL + "?requiresLogin");
	        } else {
	        	request.setAttribute("SKJEMA_URL", SKJEMA_URL);
	        	request.setAttribute("FERDIG_URL", FERDIG_URL);
	            request.getRequestDispatcher("WEB-INF/paameldingsskjema_MAL.jsp")
	            		.forward(request, response);
	        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		HttpSession sesjon = request.getSession(false);
		 
		 if (sesjon == null || sesjon.getAttribute("username") == null) {
	            response.sendRedirect(LOGIN_URL + "?requiresLogin");
	    } else {
		
		Person person = (Person) sesjon.getAttribute("person");
		PersonInfo personinfo = new PersonInfo();
		int teller = 0;
		if (request.getParameter("fornavn") != null) {
            personinfo.setFornavn(request.getParameter("fornavn"));
            teller ++;
        }
		
		if (request.getParameter("etternavn") != null) {
            personinfo.setEtternavn(request.getParameter("etternavn"));
            teller ++;
        }
		
		if (request.getParameter("mobil") != null) {
            personinfo.setMobilnr(request.getParameter("mobil"));
            teller ++;
        }
		
		if (request.getParameter("passord") != null) {
			if(request.getParameter("passord").equals(request.getParameter("passordRepetert"))){
				personinfo.setPassord(request.getParameter("passord"));
            	personinfo.setPassordto(request.getParameter("passordRepetert"));
            	teller ++;
			}
        }
		
		if (request.getParameter("kjonn") != null) {
			if(request.getParameter("kjonn").equals("mann")) {
            	personinfo.setKjonn("mann");
            	teller ++;
			}else {
				personinfo.setKjonn("kvinne");
				teller++;
			}
        }
		
		
		
		if(teller == 5) {
			person.addItem(personinfo);
		}
		}
		*/
		
		response.sendRedirect(BEKREFTELSE_URL);
	}

}
