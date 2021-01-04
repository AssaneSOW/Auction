package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Categorie;

public class CategorieDAOJdbcImpl implements CRUDRepository<Categorie> {
	
	private static CategorieDAOJdbcImpl instance = null;
	
	private CategorieDAOJdbcImpl() {
		
	}
	
	public static CategorieDAOJdbcImpl getInstance() {
		if(instance==null) {
			instance = new CategorieDAOJdbcImpl();
		}
		return instance;
	}
	

	@Override
	public void create(Categorie cat) {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("insert into Categories values(?)");
			pstmt.setString(1, cat.getLibelle());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Categorie selectById(Integer id) {
		Categorie cat = new Categorie();
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("select * from Categories where id_categorie=?");
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
				cat.setIdCat(rs.getInt("id_categorie"));
				cat.setLibelle(rs.getString("libelle"));
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cat;
	}

	@Override
	public List<Categorie> selectAll() {
		List<Categorie> categories = new ArrayList<>();
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("select * from Categories");
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Categorie cat = new Categorie();
				cat.setIdCat(rs.getInt("id_categorie"));
				cat.setLibelle(rs.getString("libelle"));
				
				categories.add(cat);
			}
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public void update(Categorie cat) {
		Connection cnx;
		try {
			cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement("update Categories set id_categorie=?,libelle=? where id_categorie=?");
			pstmt.setInt(1, cat.getIdCat());
			pstmt.setString(2, cat.getLibelle());
			
			
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
			
			PreparedStatement pstmt = cnx.prepareStatement("delete from Categories where id_categorie=?");
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
