package projet100h.servlets;

import java.io.IOException;
import java.util.List;

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
import projet100h.pojos.SousCategorie;
import projet100h.services.InformationsService;
import projet100h.services.PrestationService;
import projet100h.services.SousCategorieService;




@WebServlet("/admin/SupprimerPresta")
public class SupprimerPresta extends AbstractGenericServlet{

	private static final long serialVersionUID = -3032812618526895052L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		
		
		List<Prestation> listPrest= PrestationService.getInstance().listPrestation();
		context.setVariable("prestations", listPrest);
		
		
		
		
		
		templateEngine.process("SupprimerPresta", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Integer IdPresta = Integer.parseInt(req.getParameter("IdPresta"));
		
		
		
				
		
		PrestationService.getInstance().supprimerPrestation(IdPresta);
		
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("PrestationBack");
	}

	
}
