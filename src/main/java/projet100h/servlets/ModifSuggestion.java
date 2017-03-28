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
import projet100h.pojos.Suggestion;
import projet100h.services.InformationsService;
import projet100h.services.PrestationService;
import projet100h.services.SousCategorieService;
import projet100h.services.SuggestionService;




@WebServlet("/admin/ModifSuggestion")
public class ModifSuggestion extends AbstractGenericServlet{

	private static final long serialVersionUID = -3032812618526895052L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		
		
		List<Suggestion> listSug= SuggestionService.getInstance().listSuggestions();
		context.setVariable("suggestions", listSug);
		
		
		
				
		templateEngine.process("ModifSuggestion", context, resp.getWriter());
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Integer Idsuggestion =Integer.parseInt(req.getParameter("Idsuggestion"));
		String titre = req.getParameter("titre");
		String soustitre = req.getParameter("soustitre");
		String text = req.getParameter("text");
		
		
		
				
		
		SuggestionService.getInstance().updateSuggestions(Idsuggestion, titre, soustitre, text);
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("AccueilBack");
	}

	
}
