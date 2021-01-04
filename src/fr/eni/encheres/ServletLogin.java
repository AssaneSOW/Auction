package fr.eni.encheres;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session;
		Utilisateur u;
		try {
			String pseudo = request.getParameter("pseudo");
			String mdp = request.getParameter("mdp");
			UtilisateurManagerImpl umi = (UtilisateurManagerImpl) ManagerFactory.getUtilisateurManager();
			u = umi.login(pseudo, mdp);
			if(u!=null) {
				//cookie doublon avec la méthode login qui récupère l'utilisateur
//				Cookie c = new Cookie("login",pseudo);
//				response.addCookie(c);
				session = request.getSession();
				session.setAttribute("userConnected", u);
				response.sendRedirect("accueil");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
				request.setAttribute("erreur", "Pseudo / mot de passe invalide..!");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
