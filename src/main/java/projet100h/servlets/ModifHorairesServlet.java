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
import projet100h.services.InformationsService;




@WebServlet("/admin/ModifHoraires")
public class ModifHorairesServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3032812618526895052L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		templateEngine.process("ModifHoraires", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String DimancheLundi = req.getParameter("dimancheLundi");
		String MardiVendredi = req.getParameter("mardiVendredi");
		String Samedi = req.getParameter("samedi");
		String conge = req.getParameter("conge");
		
		
		
		
		InformationsService.getInstance().updateHoraires(DimancheLundi, MardiVendredi, Samedi,conge);
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("AccueilBack");
	}

	
}