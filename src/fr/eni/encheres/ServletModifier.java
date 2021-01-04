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
 * Servlet implementation class ServletModifier
 */
@WebServlet("/modifier")
public class ServletModifier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifier.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			UtilisateurManagerImpl umi = (UtilisateurManagerImpl) ManagerFactory.getUtilisateurManager();
			String checkModifier = request.getParameter("btn-enregistrer");
			String checkAnnuler = request.getParameter("btn-annuler");
			if(checkModifier!=null && checkModifier.equals("enregistrer")) {
				if(umi.verifMdpBdd(request.getParameter("mdp"))!=null) {
					if(request.getParameter("nvMdp").equals(request.getParameter("confNvMdp"))) {
						if(umi.verifMdpBdd(request.getParameter("nvMdp"))==null) {
							if(umi.verifPseudoBdd(request.getParameter("pseudo"))==null) {
								if(umi.verifEmailBdd(request.getParameter("email"))==null) {
									if(pseudoOk(request.getParameter("pseudo"))) {
										String mdp = request.getParameter("nvMdp");
										Utilisateur utilisateur = new Utilisateur(Integer.parseInt(request.getParameter("id")),request.getParameter("pseudo"),request.getParameter("nom"),
												request.getParameter("prenom"),request.getParameter("email"),Integer.parseInt(request.getParameter("tel")),
												request.getParameter("rue"),Integer.parseInt(request.getParameter("cdp")),request.getParameter("ville"),
												mdp);
										umi.update(utilisateur);
										HttpSession session;
										String pseudo = request.getParameter("pseudo");
										mdp = request.getParameter("nvMdp");
										utilisateur = umi.login(pseudo, mdp);
										session = request.getSession();
										session.setAttribute("userConnected", utilisateur);
										response.sendRedirect("monProfil");
									} else {
										RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifier.jsp");
										request.setAttribute("erreurPseudo", "Le pseudo ne doit contenir que des chiffres et/ou lettres.");
										rd.forward(request, response);
									}
								} else {
									RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifier.jsp");
									request.setAttribute("erreurEmail", "Cet email existe déjà.");
									rd.forward(request, response);
								}
							} else {
								RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifier.jsp");
								request.setAttribute("erreurPseudoUnique", "Ce pseudo existe déjà.");
								rd.forward(request, response);
							}
						} else {
							RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifier.jsp");
							request.setAttribute("erreurMdpUnicite", "Le mot de passe existe déjà.");
							rd.forward(request, response);
						}
					} else {
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifier.jsp");
						request.setAttribute("erreurConfNvMdp", "La confirmation du nouveau mot de passe est invalide.");
						rd.forward(request, response);
					}
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifier.jsp");
					request.setAttribute("erreurConfAncienMdp", "Le mot de passe est invalide.");
					rd.forward(request, response);
				}
				
			} else if (checkAnnuler!=null && checkAnnuler.equals("annuler")){
				response.sendRedirect("monProfil");
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
