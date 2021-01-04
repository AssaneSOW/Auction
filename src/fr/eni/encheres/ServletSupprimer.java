package fr.eni.encheres;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ManagerFactory;
import fr.eni.encheres.bll.UtilisateurManagerImpl;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletSupprimer
 */
@WebServlet("/supprimer")
public class ServletSupprimer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UtilisateurManagerImpl umi = (UtilisateurManagerImpl) ManagerFactory.getUtilisateurManager();
			HttpSession session = request.getSession();
			Utilisateur u = (Utilisateur) session.getAttribute("userConnected");
			umi.delete(u.getId());
			session.invalidate();
			response.sendRedirect("accueil");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
