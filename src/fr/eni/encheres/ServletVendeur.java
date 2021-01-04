package fr.eni.encheres;

import java.io.IOException;

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
 * Servlet implementation class ServletVendeur
 */
@WebServlet("/vendeur")
public class ServletVendeur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			Utilisateur u = (Utilisateur) session.getAttribute("userConnected");
			if(u == null) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
				rd.forward(request, response);
			} else {
				int id = Integer.parseInt(request.getParameter("articleId"));
				ArticlesManagerImpl ami = (ArticlesManagerImpl) ManagerFactory.getArticlesManager();
				Articles a = ami.selectById(id);
				session.setAttribute("nomArticle", a.getNomArticle());
				session.setAttribute("prixArticle", a.getPrixInitial());
				
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/article.jsp");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
