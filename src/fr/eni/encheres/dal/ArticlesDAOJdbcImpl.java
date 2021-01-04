package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bll.ManagerFactory;
import fr.eni.encheres.bo.Articles;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
//import fr.eni.encheres.bo.Encheres;
//import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;

public class ArticlesDAOJdbcImpl implements CRUDRepository<Articles> {
	
	private static ArticlesDAOJdbcImpl instance = null;
	
	private ArticlesDAOJdbcImpl() {
		
	}
	
	public static ArticlesDAOJdbcImpl getInstance() {
		if(instance == null) {
			instance = new ArticlesDAOJdbcImpl();
		}
		return instance;
	}
	
	@Override
	public void create(Articles article) {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("insert into Articles values(?,?,?,?,?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setString(3, String.valueOf(article.getDateDebutEncheres()));
			pstmt.setString(4, String.valueOf(article.getDateFinEncheres()));
			pstmt.setInt(5, article.getPrixInitial());
			pstmt.setInt(6, article.getPrixVente());
			pstmt.setString(7, article.getImg());
			pstmt.setInt(8, article.getCat().getIdCat());
			pstmt.setBoolean(9, article.getVendu());
			pstmt.setInt(10, article.getVendeur().getId());
			pstmt.setInt(11, article.getAcheteur().getId());
			
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				article.setIdArticle((rs.getInt(1)));
			}
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void create(Articles article, Retrait retrait) {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("insert into Articles values(?,?,?,?,?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setString(3, String.valueOf(article.getDateDebutEncheres()));
			pstmt.setString(4, String.valueOf(article.getDateFinEncheres()));
			pstmt.setInt(5, article.getPrixInitial());
			pstmt.setInt(6, article.getPrixVente());
			pstmt.setString(7, article.getImg());
			pstmt.setInt(8, article.getCat().getIdCat());
			pstmt.setBoolean(9, article.getVendu());
			pstmt.setInt(10, article.getVendeur().getId());
			pstmt.setInt(11, article.getAcheteur().getId());
			
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				article.setIdArticle((rs.getInt(1)));
			}
			pstmt.close();
			
			pstmt = cnx.prepareStatement("insert into Retraits values(?,?,?,?)");
			pstmt.setInt(1, article.getIdArticle());
			pstmt.setString(2, retrait.getRue());
			pstmt.setInt(3, retrait.getCdp());
			pstmt.setString(4, retrait.getVille());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			cnx.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	@Override
	public Articles selectById(Integer id) {
		Articles article = new Articles();
		Categorie cat = new Categorie();
//		Encheres enchere = new Encheres();
//		Retrait retrait = new Retrait();
		Utilisateur acheteur = new Utilisateur();
		Utilisateur vendeur = new Utilisateur();
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("select * from Articles where id_article=?;");
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				article.setIdArticle(rs.getInt("id_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEncheres(LocalDateTime.parse(rs.getString("date_debut_encheres")));
				article.setDateFinEncheres(LocalDateTime.parse(rs.getString("date_fin_encheres")));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setImg(rs.getString("img"));
				cat = ManagerFactory.getCategorieManager().selectById(rs.getInt("id_categorie"));
				article.setCat(cat);
				article.setVendu(rs.getBoolean("vendu"));
				vendeur = ManagerFactory.getUtilisateurManager().selectById(rs.getInt("vendeur"));
				article.setVendeur(vendeur);
				acheteur = ManagerFactory.getUtilisateurManager().selectById(rs.getInt("acheteur"));
				article.setAcheteur(acheteur);
//				retrait = ManagerFactory.getRetraitManager().selectById(rs.getInt("id_article"));
//				article.setRetrait(retrait);
//				enchere = ManagerFactory.getEncheresManager().selectById(rs.getInt("id_article"));
//				article.setEnchere(enchere);
			}
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}
	
	public Articles selectByIdAcheteur(Integer id) {
		Articles article = new Articles();
		Categorie cat = new Categorie();
//		Encheres enchere = new Encheres();
//		Retrait retrait = new Retrait();
		Utilisateur acheteur = new Utilisateur();
		Utilisateur vendeur = new Utilisateur();
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("select * from Articles a"
					+ "inner join Retraits r on a.id_article = r.id_article"
					+ "inner join Categories c on a.id_categorie = c.id_categorie"
					+ "inner join Encheres e on a.id_article = e.id_article"
					+ "inner join Utilisateurs u on a.acheteur = u.id_utilisateur"
					+ "where a.id_article=?");
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				article.setIdArticle(rs.getInt("id_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEncheres(LocalDateTime.parse(rs.getString("date_debut_encheres")));
				article.setDateFinEncheres(LocalDateTime.parse(rs.getString("date_fin_encheres")));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setImg(rs.getString("img"));
				cat = ManagerFactory.getCategorieManager().selectById(rs.getInt("id_categorie"));
				article.setCat(cat);
				article.setVendu(rs.getBoolean("vendu"));
				vendeur = ManagerFactory.getUtilisateurManager().selectById(rs.getInt("vendeur"));
				article.setVendeur(vendeur);
				acheteur = ManagerFactory.getUtilisateurManager().selectById(rs.getInt("acheteur"));
				article.setAcheteur(acheteur);
//				retrait = ManagerFactory.getRetraitManager().selectById(rs.getInt("id_article"));
//				article.setRetrait(retrait);
//				enchere = ManagerFactory.getEncheresManager().selectById(rs.getInt("id_article"));
//				article.setEnchere(enchere);
			}
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public List<Articles> selectAll() {
		List<Articles> articles = new ArrayList<>();
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("select * from Articles");
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Articles article = new Articles();
				Categorie cat = new Categorie();
//				Encheres enchere = new Encheres();
//				Retrait retrait = new Retrait();
				Utilisateur acheteur = new Utilisateur();
				Utilisateur vendeur = new Utilisateur();
				article.setIdArticle(rs.getInt("id_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEncheres(LocalDateTime.parse(rs.getString("date_debut_encheres")));
				article.setDateFinEncheres(LocalDateTime.parse(rs.getString("date_fin_encheres")));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setImg(rs.getString("img"));
				cat = ManagerFactory.getCategorieManager().selectById(rs.getInt("id_categorie"));
				article.setCat(cat);
				article.setVendu(rs.getBoolean("vendu"));
				vendeur = ManagerFactory.getUtilisateurManager().selectById(rs.getInt("vendeur"));
				article.setVendeur(vendeur);
				acheteur = ManagerFactory.getUtilisateurManager().selectById(rs.getInt("acheteur"));
				article.setAcheteur(acheteur);
//				retrait = ManagerFactory.getRetraitManager().selectById(rs.getInt("id_article"));
//				article.setRetrait(retrait);
//				enchere = ManagerFactory.getEncheresManager().selectById(rs.getInt("id_article"));
//				article.setEnchere(enchere);
				
				articles.add(article);
			}
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}
	
	@Override
	public void update(Articles article) {
		Connection cnx;
		try {
			cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement("update Articles set nom_article=?,description=?,"
					+ "date_debut_encheres=?,date_fin_encheres=?,prix_initial=?, prix_vente=?,img=?,vendu=?,"
					+ "vendeur=?,acheteur=? where id_article=?");
			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setString(4, String.valueOf(article.getDateDebutEncheres()));
			pstmt.setString(5, String.valueOf(article.getDateFinEncheres()));
			pstmt.setInt(5, article.getPrixInitial());
			pstmt.setInt(6, article.getPrixVente());
			pstmt.setString(7, article.getImg());
			pstmt.setInt(8, article.getCat().getIdCat());
			pstmt.setBoolean(9, article.getVendu());
			pstmt.setInt(10, article.getVendeur().getId());
			pstmt.setInt(11, article.getAcheteur().getId());
			pstmt.setInt(12, article.getIdArticle());
			
			int rows = pstmt.executeUpdate();
			System.out.println("Nombre de ligne(s) affectée(s) : "+rows);
			
			pstmt.close();
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Integer id) {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("delete from Articles where id_article=?");
			pstmt.setInt(1, id);
			
			int rows = pstmt.executeUpdate();
			System.out.println("Nombre de ligne(s) affectée(s) : "+rows);
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<Articles> selectByMot(String motCle) {
		List<Articles> articles = new ArrayList<>();
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("select * from Articles where nom_article like %?%");
			pstmt.setString(1, motCle);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Articles article = new Articles();
				Categorie cat = new Categorie();
//				Encheres enchere = new Encheres();
//				Retrait retrait = new Retrait();
				Utilisateur acheteur = new Utilisateur();
				Utilisateur vendeur = new Utilisateur();
				article.setIdArticle(rs.getInt("id_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEncheres(LocalDateTime.parse(rs.getString("date_debut_encheres")));
				article.setDateFinEncheres(LocalDateTime.parse(rs.getString("date_fin_encheres")));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setImg(rs.getString("img"));
				cat = ManagerFactory.getCategorieManager().selectById(rs.getInt("id_categorie"));
				article.setCat(cat);
				article.setVendu(rs.getBoolean("vendu"));
				vendeur = ManagerFactory.getUtilisateurManager().selectById(rs.getInt("vendeur"));
				article.setVendeur(vendeur);
				acheteur = ManagerFactory.getUtilisateurManager().selectById(rs.getInt("acheteur"));
				article.setAcheteur(acheteur);
//				retrait = ManagerFactory.getRetraitManager().selectById(rs.getInt("id_article"));
//				article.setRetrait(retrait);
//				enchere = ManagerFactory.getEncheresManager().selectById(rs.getInt("id_article"));
//				article.setEnchere(enchere);
				
				articles.add(article);
			}
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}

}
