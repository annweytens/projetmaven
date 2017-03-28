package projet100h.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet100h.utils.MotDePasseUtils;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {

	private static final long serialVersionUID = -1488650966375438002L;

	private Map<String, String> utilisateursAutorises;
	
	@Override
	public void init() throws ServletException {
		utilisateursAutorises = new HashMap<>();
		utilisateursAutorises.put("Sylvie", "481d7d6c06fd481d7900c605f8c7a327c0a3c4277551f1f6:ab4123f47750be22d61aabdba20f6e828c2062e6ded86a02");
		

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Connexion</title>");
		out.println("</head>");
		out.println("<body>");
		String identifiantConnecte = (String) req.getSession().getAttribute("utilisateurConnecte");
		if (identifiantConnecte == null || "".equals(identifiantConnecte)) {
			out.println("<h1>Veuillez indiquer votre identifiant :</h1>");
			out.println("<form method=\"post\">");
			out.println("<input type=\"text\" name=\"identifiant\">");
			out.println("<input type=\"password\" name=\"motdepasse\">");
			out.println("<input type=\"submit\" value=\"Se connecter\">");
			out.println("</form>");
		} else {
			resp.sendRedirect("admin/AccueilBack");
		}
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String identifiantSaisi = request.getParameter("identifiant");
		String motDePasseSaisi = request.getParameter("motdepasse");
		try {
			if(utilisateursAutorises.containsKey(identifiantSaisi) && MotDePasseUtils.validerMotDePasse(motDePasseSaisi, utilisateursAutorises.get(identifiantSaisi))) {
				request.getSession().setAttribute("utilisateurConnecte", identifiantSaisi);
				
			}
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		} 
		response.sendRedirect("connexion");
	}

}
