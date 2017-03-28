package projet100h.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet100h.services.SuggestionService;


@WebServlet("/SuggestionImage")
public class SuggestionImageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer ImageSuggestion = Integer.parseInt(req.getParameter("image"));
		Path picturePath = SuggestionService.getInstance().getPicturePath(ImageSuggestion);
		
		Files.copy(picturePath, resp.getOutputStream());
	}

}
