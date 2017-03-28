package projet100h.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;



import projet100h.pojos.Suggestion;

import projet100h.services.SuggestionService;




@WebServlet("/admin/AddSuggestion")
@MultipartConfig
public class AddSuggestion extends AbstractGenericServlet{

	private static final long serialVersionUID = -3032812618526895052L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		templateEngine.process("AddSuggestion", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String titre = req.getParameter("titre");
		String soustitre = req.getParameter("soustitre");
		String text = req.getParameter("text");
		
		Part SuggestionImage = req.getPart("image");
		
		
		
		 Suggestion nouvelSuggestion = new Suggestion(null, titre, soustitre, text);
		// SuggestionService.getInstance().ajouterSuggestion(nouvelSuggestion, SuggestionImage);
	        
	        
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("AccueilBack");
	}

	
}

