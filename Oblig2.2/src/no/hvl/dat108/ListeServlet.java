package no.hvl.dat108;

import static no.hvl.dat108.UrlKart.LISTE_URL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(name="ListeServlet", urlPatterns="/ListeServlet")
public class ListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Inn noe kode her i forbindelse med autorisasjon?
				HttpSession sesjon = request.getSession(false);
				
				
				
				if (sesjon == null || sesjon.getAttribute("username") == null) {
					// Feilhåndtering
				} else {

					// Inn noe kode her i forbindelse med uthenting av sesjonsdata?
					String username = (String) sesjon.getAttribute("username");
					Handleliste liste = (Handleliste) sesjon.getAttribute("liste");
					
					response.setContentType("text/html; charset=ISO-8859-1");

					PrintWriter out = response.getWriter();

					//START 
					
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println(" <div id=\"myDIV\" class=\"header\"> ");
					out.println("  <h2>Handleliste</h2> ");
					
					out.println("<form action=\"" + LISTE_URL + "\" method=\"post\">");
					out.println("<fieldset>");
					out.println("  <input type=\"text\" name=\"myInput\" placeholder=\"Matvare...\">");
					out.println("    <p><input type=\"submit\" value=\"Legg til\" /></p>");
	
					out.println("</fieldset>");
					out.println("</form>");
					
					out.println("<form action=\"" + LISTE_URL + "\" method=\"post\">");
					out.println("<fieldset>");
					
					//Legg til hiddenparameter for å slette riktig
					
					for (ListeObjekt item : liste.getItems()) {
						out.println("<form action=\"ListeServlet\" method=\"post\">\n");
						out.println("<input type=\"hidden\" name=\"Slett\" value=\"" + item.getName() + "\" >\n");
						out.println("<p><input type=\"submit\" value=\"Slett\">" + " " + item.getName() + "</p>\n");
						out.println("</form>\n");
					}
					
					out.println("</fieldset>");
					out.println("</form>");
					
					out.println("</div>");
					out.println("<head>");
					out.println("</head>");
					out.println("<body>");
					
					
					
					
					
					out.println("</body>");
					out.println("</html>");
					
					//SLUTT
//					
					
				}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Inn noe kode her i forbindelse med autorisasjon?
				HttpSession sesjon = request.getSession(false);
				if (sesjon == null || sesjon.getAttribute("username") == null) {
					// Feilhåndtering
				} else {

					// Inn noe kode her i forbindelse med oppdatering av sesjonsdata?
					Handleliste liste = (Handleliste) sesjon.getAttribute("liste");
					//ListeObjekt objekt = (ListeObjekt) sesjon.getAttribute("myInput");
					//... opprette varer og lagre i handlevogn
					String itemname = request.getParameter("myInput");
					
					String itemslett = request.getParameter("Slett");
					
					if(itemslett != null && !itemslett.isEmpty()) 
						liste.deleteItem(itemslett);
					
					if(itemname != null && !itemname.isEmpty()) 
						liste.addItem(itemname);
					
					sesjon.setAttribute("liste", liste);
					
					response.sendRedirect(LISTE_URL);
				}
	}

}

