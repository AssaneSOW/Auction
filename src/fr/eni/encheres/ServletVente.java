package fr.eni.encheres;

import java.io.IOException;
//import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
//import java.nio.file.Paths;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.Part;

import fr.eni.encheres.bll.ArticlesManagerImpl;
import fr.eni.encheres.bll.CategorieManagerImpl;
import fr.eni.encheres.bll.ManagerFactory;
//import fr.eni.encheres.bll.RetraitManagerImpl;
import fr.eni.encheres.bo.Articles;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletVente
 */
@WebServlet("/vente")
@MultipartConfig
public class ServletVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session;
		try {
			session = request.getSession(false);
			if(session == null) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
				rd.forward(request, response);
			} else {
				session.getAttribute("userConnected");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/vente.jsp");
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
		Utilisateur vendeur;
		Utilisateur acheteur;
		ArticlesManagerImpl ami;
		String checkEnregistrer;
		String checkRetour;
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			vendeur = (Utilisateur) session.getAttribute("userConnected");
			acheteur = (Utilisateur) session.getAttribute("userConnected");
			ami = (ArticlesManagerImpl) ManagerFactory.getArticlesManager();
			checkEnregistrer = request.getParameter("btn-enregistrer");
			checkRetour = request.getParameter("btn-retour");
			if(checkEnregistrer!=null && checkEnregistrer.equals("enregistrer")) {
				if(request.getParameter("photo")!= null) {
					
//					String nomPhoto = request.getParameter("photo");
//					Part filePart = request.getPart(nomPhoto);
//					String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//					InputStream fileContent = filePart.getInputStream();
					
					
					
					LocalDateTime dateDebutEnchere = LocalDateTime.parse(request.getParameter("debutEnchere"));
					LocalDateTime dateFinEnchere = LocalDateTime.parse(request.getParameter("finEnchere"));
					if(dateDebutEnchere.isBefore(dateFinEnchere)) {
						int categorie;
						if(request.getParameter("categorie")!=null && request.getParameter("categorie").equals("Ameublement")) {
							categorie = 2;
						} else if (request.getParameter("categorie")!=null && request.getParameter("categorie").equals("Informatique")) {
							categorie = 3;
						} else if (request.getParameter("categorie")!=null && request.getParameter("categorie").equals("SportEtLoisirs")) {
							categorie = 4;
						} else if (request.getParameter("categorie")!=null && request.getParameter("categorie").equals("Vetements")) {
							categorie = 5;
						} else {
							categorie = 1;
						}
						CategorieManagerImpl cmi = (CategorieManagerImpl) ManagerFactory.getCategorieManager();
						Categorie cat = cmi.selectById(categorie);
						
						Articles article = new Articles(99, request.getParameter("article"),request.getParameter("description"), cat,
								dateDebutEnchere,dateFinEnchere, Integer.parseInt(request.getParameter("prix")), 
								request.getParameter("photo"), vendeur, acheteur);
						Retrait retrait = new Retrait(99,request.getParameter("rue"),
								Integer.parseInt(request.getParameter("cdp")),request.getParameter("ville"));
						ami.create(article, retrait);
						
//						RetraitManagerImpl rmi = (RetraitManagerImpl) ManagerFactory.getRetraitManager();
//						Retrait retrait = new Retrait(article.getIdArticle(),request.getParameter("rue"),
//								Integer.parseInt(request.getParameter("cdp")),request.getParameter("ville"));
//						rmi.create(retrait);
						
						PrintWriter out = response.getWriter();
						out.write("<script type=\"text/javascript\">");
						out.write("alert('Votre article a bien été mis en vente !');");
						out.write("location='accueil.jsp';");
						out.write("</script>");
						
						response.sendRedirect("accueil");
					} else {
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/vente.jsp");
						request.setAttribute("erreurDate", "La date du début doit être avant celle de la fin des enchères.");
						rd.forward(request, response);
					}
				} else if (checkRetour!=null && checkRetour.equals("retour")){
					response.sendRedirect("accueil");
				}
				}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
}
