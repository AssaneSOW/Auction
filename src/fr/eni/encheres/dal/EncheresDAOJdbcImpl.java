package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Encheres;

public class EncheresDAOJdbcImpl implements CRUDRepository<Encheres> {
	
	private static EncheresDAOJdbcImpl instance = null;
	
	private EncheresDAOJdbcImpl() {
		
	}
	
	public static EncheresDAOJdbcImpl getInstance() {
		if(instance==null) {
			instance = new EncheresDAOJdbcImpl();
		}
		return instance;
	}

	@Override
	public void create(Encheres enchere) {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("insert into Encheres values(?,?,?)");
			pstmt.setInt(1, enchere.getIdArticle());
			pstmt.setDate(2, enchere.getDateEnchere());
			pstmt.setFloat(3, enchere.getMontantEnchere());
			
			
			pstmt.executeUpdate();
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Encheres selectById(Integer id) {
		Encheres enchere = new Encheres();
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("select * from Encheres where id_article=?");
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
				enchere.setIdArticle(rs.getInt("id_article"));
				enchere.setDateEnchere(rs.getDate("date_enchere"));
				enchere.setMontantEnchere(rs.getFloat("montant_enchere"));
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enchere;
	}

	@Override
	public List<Encheres> selectAll() {
		List<Encheres> encheres = new ArrayList<>();
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("select * from Encheres");
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Encheres enchere = new Encheres();
				enchere.setIdArticle(rs.getInt("id_article"));
				enchere.setDateEnchere(rs.getDate("date_enchere"));
				enchere.setMontantEnchere(rs.getFloat("montant_enchere"));
				
				encheres.add(enchere);
			}
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encheres;
	}

	@Override
	public void update(Encheres enchere) {
		Connection cnx;
		try {
			cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement("update Encheres set date_enchere=?,montant_enchere=? where id_article=?");
			pstmt.setDate(1, enchere.getDateEnchere());
			pstmt.setFloat(2, enchere.getMontantEnchere());
			pstmt.setInt(3, enchere.getIdArticle());
			
			
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
			
			PreparedStatement pstmt = cnx.prepareStatement("delete from Encheres where id_article=?");
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
