package projet100h.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;


import projet100h.pojos.Horaires;
import projet100h.pojos.Informations;
import projet100h.pojos.Prestation;
import projet100h.services.InformationsService;
import projet100h.services.PrestationService;




@WebServlet("/admin/AddPresta")
public class AddPresta extends AbstractGenericServlet{

	private static final long serialVersionUID = -3032812618526895052L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		templateEngine.process("AddPresta", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nom = req.getParameter("nom");
		String description = req.getParameter("description");
		String prix = req.getParameter("prix");
		Integer idsouscat = Integer.parseInt(req.getParameter("Idsouscat"));
		
		 Prestation nouvelPrestation = new Prestation(null, nom, description, prix, idsouscat);
	        PrestationService.getInstance().ajouterPrestation(nouvelPrestation);
	        
	        
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("PrestationBack");
	}

	
}
