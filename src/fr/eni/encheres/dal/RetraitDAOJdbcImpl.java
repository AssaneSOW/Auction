package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Retrait;

public class RetraitDAOJdbcImpl implements CRUDRepository<Retrait> {
	
	private static RetraitDAOJdbcImpl instance = null;
	
	private RetraitDAOJdbcImpl() {
		
	}
	
	public static RetraitDAOJdbcImpl getInstance() {
		if(instance==null) {
			instance = new RetraitDAOJdbcImpl();
		}
		return instance;
	}

	@Override
	public void create(Retrait retrait) {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("insert into Retraits values(?,?,?,?)");
			
			pstmt.setInt(1, retrait.getArticleId());
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
	public Retrait selectById(Integer id) {
		Retrait retrait = new Retrait();
//		Articles article = new Articles();
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("select * from Retraits"
					+ "inner join Articles a on a.id_article = r.id_article"
					+ "where id_article=?");
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
//				article = ManagerFactory.getArticlesManager().selectById(rs.getInt("id_article"));
//				retrait.setArticle(article);
				retrait.setArticleId(rs.getInt("id_article"));
				retrait.setRue(rs.getString("rue"));
				retrait.setCdp(rs.getInt("code_postal"));
				retrait.setVille(rs.getString("ville"));
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retrait;
	}

	@Override
	public List<Retrait> selectAll() {
		List<Retrait> retraits = new ArrayList<>();
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("select * from Retraits"
					+ "inner join Articles a on a.id_article = r.id_article where id_article=?");
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Retrait retrait = new Retrait();
//				Articles article = new Articles();
//				article = ManagerFactory.getArticlesManager().selectById(rs.getInt("id_article"));
//				retrait.setArticle(article);
				retrait.setArticleId(rs.getInt("id_article"));
				retrait.setRue(rs.getString("rue"));
				retrait.setCdp(rs.getInt("code_postal"));
				retrait.setVille(rs.getString("ville"));
				
				retraits.add(retrait);
			}
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retraits;
	}

	@Override
	public void update(Retrait retrait) {
		Connection cnx;
		try {
			cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement("update Retraits set rue=?,code_postal=?,ville=? where id_article=?");
			pstmt.setString(1, retrait.getRue());
			pstmt.setInt(2, retrait.getCdp());
			pstmt.setString(3, retrait.getVille());
			pstmt.setInt(1, retrait.getArticleId());
			
			
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
			
			PreparedStatement pstmt = cnx.prepareStatement("delete from Retraits where id_article=?");
			pstmt.setInt(1, id);
			
			int rows = pstmt.executeUpdate();
			System.out.println("Nombre de ligne(s) affectée(s) : "+rows);
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
