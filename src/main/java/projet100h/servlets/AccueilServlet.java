package projet100h.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;


import projet100h.pojos.Suggestion;
import projet100h.services.InformationsService;

import projet100h.services.SuggestionService;



@WebServlet("/Accueil")
public class AccueilServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3032812618526895052L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("information", InformationsService.getInstance().getInformations(1));
		
		List<Suggestion> listSug= SuggestionService.getInstance().listSuggestions();
		context.setVariable("suggestions", listSug);
		
		templateEngine.process("Accueil", context, resp.getWriter());
	}

	
}

