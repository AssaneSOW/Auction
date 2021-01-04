package fr.eni.encheres;

import java.io.IOException;
//import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticlesManagerImpl;
import fr.eni.encheres.bll.ManagerFactory;

import fr.eni.encheres.bo.Articles;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet("/accueil")
public class ServletAccueil extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession(false);
			Utilisateur u = (Utilisateur) session.getAttribute("userConnected");
			if(u == null) {
				
				//session n'est jamais nulle donc attribuer un nom d'attribut différent
				//currentUser par ex == null c'est qu'il n'est pas co
				//une fois qu'il est co on lui fait les setAttribute();
				
				ArticlesManagerImpl ami = (ArticlesManagerImpl) ManagerFactory.getArticlesManager();
				Articles test = ami.selectById(21);
				request.setAttribute("articleId", test.getIdArticle());
				request.setAttribute("articleNom", test.getNomArticle());
				request.setAttribute("prix", test.getPrixInitial());
				request.setAttribute("dateFinEnchere", test.getDateFinEncheres());
				request.setAttribute("vendeur", test.getVendeur().getNom());
//				List<Articles> articles = ami.selectAll();
//				for (Articles a : articles) {
//					request.setAttribute("photo", a.getImg());
//					request.setAttribute("articleNom", a.getNomArticle());
//					request.setAttribute("prix", a.getPrixInitial());
//					request.setAttribute("dateFinEnchere", a.getDateFinEncheres());
//					request.setAttribute("vendeur", a.getVendeur());
//				}
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
				rd.forward(request, response);
			} else {
				ArticlesManagerImpl ami = (ArticlesManagerImpl) ManagerFactory.getArticlesManager();
				Articles test = ami.selectById(21);
				request.setAttribute("articleId", test.getIdArticle());
				request.setAttribute("articleNom", test.getNomArticle());
				request.setAttribute("prix", test.getPrixInitial());
				request.setAttribute("dateFinEnchere", test.getDateFinEncheres());
				request.setAttribute("vendeur", test.getVendeur().getNom());
				
//					List<Articles> articles = ManagerFactory.getArticlesManager().selectAll();
//					for (Articles a : articles) {
//						session.setAttribute("articleNom", a.getNomArticle());
//						session.setAttribute("prix", a.getPrixInitial());
//						session.setAttribute("dateFinEnchere", a.getDateFinEncheres());
//						session.setAttribute("vendeur", a.getVendeur());
//					}
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
				rd.forward(request, response);
			}
		} catch (ServletException e) {
			e.printStackTrace();
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
