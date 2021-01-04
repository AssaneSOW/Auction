package fr.eni.encheres;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletMonProfil
 */
@WebServlet("/monProfil")
public class ServletMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session;
		try {
			session = request.getSession(false);
			if(session == null) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
				rd.forward(request, response);
			} else {
				Utilisateur u = (Utilisateur) session.getAttribute("userConnected");
				session.setAttribute("id", u.getId());
				session.setAttribute("pseudo", u.getPseudo());
				session.setAttribute("nom", u.getNom());
				session.setAttribute("prenom", u.getPrenom());
				session.setAttribute("email", u.getEmail());
				session.setAttribute("tel", u.getTel());
				session.setAttribute("rue", u.getRue());
				session.setAttribute("cdp", u.getCdp());
				session.setAttribute("ville", u.getVille());
				session.setAttribute("credit", u.getCredit());
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/monProfil.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
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
