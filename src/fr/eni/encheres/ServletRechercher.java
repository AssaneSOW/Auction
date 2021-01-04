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

/**
 * Servlet implementation class ServletRechercher
 */
@WebServlet("/rechercher")
public class ServletRechercher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			if(session == null) {
				ArticlesManagerImpl ami = (ArticlesManagerImpl) ManagerFactory.getArticlesManager();
				String motCle = request.getParameter("rechercher");
				if(motCle != null && motCle.length()>0) {
					request.setAttribute("articles", ami.selectByMot(motCle));
				} else {
					request.setAttribute("articles", ami.selectAll());
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
				rd.forward(request, response);
			} else {
				session.getAttribute("userConnected");
				
				
				
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
