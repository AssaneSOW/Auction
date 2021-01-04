package fr.eni.encheres;

import java.io.IOException;
import java.util.regex.Pattern;

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
 * Servlet implementation class ServletCreation
 */
@WebServlet("/creation")
public class ServletCreation extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/creation.jsp");
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			UtilisateurManagerImpl umi = (UtilisateurManagerImpl) ManagerFactory.getUtilisateurManager();
			String checkCreer = request.getParameter("btn-creer");
			String checkAnnuler = request.getParameter("btn-annuler");
			if(checkCreer!=null && checkCreer.equals("creer")) {
				if(request.getParameter("mdp").equals(request.getParameter("confMdp"))) {
					if(umi.verifMdpBdd(request.getParameter("mdp"))==null) {
						if(umi.verifPseudoBdd(request.getParameter("pseudo"))==null) {
							if(umi.verifEmailBdd(request.getParameter("email"))==null) {
								if(pseudoOk(request.getParameter("pseudo"))) {
									Utilisateur utilisateur = new Utilisateur(request.getParameter("pseudo"),request.getParameter("nom"),
											request.getParameter("prenom"),request.getParameter("email"),Integer.parseInt(request.getParameter("tel")),
											request.getParameter("rue"),Integer.parseInt(request.getParameter("cdp")),request.getParameter("ville"),
											request.getParameter("mdp"));
									umi.create(utilisateur);
									HttpSession session;
									String pseudo = request.getParameter("pseudo");
									String mdp = request.getParameter("mdp");
									utilisateur = umi.login(pseudo, mdp);
									session = request.getSession();
									session.setAttribute("userConnected", utilisateur);
									response.sendRedirect("accueil");
								} else {
									RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/creation.jsp");
									request.setAttribute("erreurPseudo", "Le pseudo ne doit contenir que des chiffres et/ou lettres.");
									rd.forward(request, response);
								}
							} else {
								RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/creation.jsp");
								request.setAttribute("erreurEmail", "Cet email existe déjà.");
								rd.forward(request, response);
							}
						} else {
							RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/creation.jsp");
							request.setAttribute("erreurPseudoUnique", "Ce pseudo existe déjà.");
							rd.forward(request, response);
						}
					} else {
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/creation.jsp");
						request.setAttribute("erreurMdpUnicite", "Le mot de passe existe déjà.");
						rd.forward(request, response);
					}
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/creation.jsp");
					request.setAttribute("erreurMdpConf", "La confirmation du mot de passe est invalide.");
					rd.forward(request, response);
				} 
			} else if (checkAnnuler!=null && checkAnnuler.equals("annuler")){
				response.sendRedirect("login");
			}
		} catch (NumberFormatException | IOException | ServletException e) {
			e.printStackTrace();
		}
	}
	
	
	private boolean pseudoOk(String pseudo) {
		boolean ok = false;
		if(Pattern.matches("(\\w+)", pseudo)) {
			ok = true;
		} else {
			ok = false;
		}
		return ok;
	}
	
	
}
