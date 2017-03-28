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

import projet100h.services.InformationsService;





@WebServlet("/admin/AjoutCaroussel")
@MultipartConfig
public class AjoutCaroussel extends AbstractGenericServlet{

	private static final long serialVersionUID = -3032812618526895052L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		templateEngine.process("AjoutCaroussel", context, resp.getWriter());
	}
	
	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Part PhotoCaroussel = req.getPart("photo");
		
		
		
		InformationsService.getInstance().updateContact(Telephone1, Telephone2, Mail);
		
		resp.sendRedirect("AccueilBack");
	}*/
	
	

	
}
