package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HilseServlet
 */
@WebServlet("/HilseServlet")
public class HilseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void init() throws ServletException {
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				 Date naa = new Date();
				 String dato = DateFormat.getDateInstance(DateFormat.LONG).format(naa);
				 response.setContentType("text/html; charset=ISO-8859-1");
				 String navn = request.getParameter("navn");
				 String serverinfo = getServletContext().getServerInfo();
				 
				 if(navn == null)
				 {
					 navn = "Halvor";
				 }
				 
				 PrintWriter out = response.getWriter();
				 out.println("<!DOCTYPE html>");
				 out.println("<html>");
				 out.println("<head>");
				 out.println("<meta charset=\"ISO-8859-1\">");
				 out.println("<title>Lab1_Hilseapplikasjon</title>");
				 out.println("</head>");
				 out.println("<body>");
				 out.println("<h1>Velkommen " + navn  + "</h1>");
				 out.println("<p>Denne siden ble produsert " + dato + ", info om serveren:  " + serverinfo + "</p>");
				 out.println("</body>");
				 out.println("</html>");
	}
}

