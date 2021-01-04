package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements CRUDRepository<Utilisateur> {
	
	private static UtilisateurDAOJdbcImpl instance = null;
	
	private UtilisateurDAOJdbcImpl() {
		
	}
	
	public static UtilisateurDAOJdbcImpl getInstance() {
		if(instance==null) {
			instance = new UtilisateurDAOJdbcImpl();
		}
		return instance;
	}

	@Override
	public void create(Utilisateur utilisateur) {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("insert into Utilisateurs values(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setInt(5, utilisateur.getTel());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setInt(7, utilisateur.getCdp());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMdp());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setBoolean(11, utilisateur.getAdmin());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Utilisateur selectById(Integer id) {
		Utilisateur utilisateur = null;
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("select * from Utilisateurs where id_utilisateur=?");
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setId(rs.getInt("id_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTel(rs.getInt("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCdp(rs.getInt("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMdp(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdmin(rs.getBoolean("administrateur"));
			}
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	@Override
	public List<Utilisateur> selectAll() {
		List<Utilisateur> utilisateurs = new ArrayList<>();
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("select * from Utilisateurs");
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setId(rs.getInt("id_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTel(rs.getInt("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCdp(rs.getInt("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMdp(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdmin(rs.getBoolean("administrateur"));
				
				utilisateurs.add(utilisateur);
			}
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateurs;
	}

	@Override
	public void update(Utilisateur utilisateur) {
		Connection cnx;
		try {
			cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement("update Utilisateurs set pseudo=?,nom=?,"
					+ "prenom=?,email=?,telephone=?, rue=?,code_postal=?,ville=?,mot_de_passe=?,"
					+ "credit=?,administrateur=? where id_utilisateur=?");
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setInt(5, utilisateur.getTel());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setInt(7, utilisateur.getCdp());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMdp());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setBoolean(11, utilisateur.getAdmin());
			pstmt.setInt(12, utilisateur.getId());
			
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
			
			PreparedStatement pstmt = cnx.prepareStatement("delete from Utilisateurs where id_utilisateur=?");
			pstmt.setInt(1, id);
			
			int rows = pstmt.executeUpdate();
			System.out.println("Nombre de ligne(s) affectée(s) : "+rows);
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Utilisateur login(String pseudo, String mdp) {
		Utilisateur utilisateur = null;
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("select * from Utilisateurs where pseudo=? and mot_de_passe=?");
			pstmt.setString(1, pseudo);
			pstmt.setString(2, mdp);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setId(rs.getInt("id_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTel(rs.getInt("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCdp(rs.getInt("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMdp(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdmin(rs.getBoolean("administrateur"));
			}
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
	
	public Utilisateur verifEmailBdd(String email) {
		Utilisateur utilisateur = null;
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("select * from Utilisateurs where email=?");
			pstmt.setString(1, email);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setId(rs.getInt("id_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTel(rs.getInt("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCdp(rs.getInt("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMdp(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdmin(rs.getBoolean("administrateur"));
			}
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
	
	public Utilisateur verifPseudoBdd(String pseudo) {
		Utilisateur utilisateur = null;
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("select * from Utilisateurs where pseudo=?");
			pstmt.setString(1, pseudo);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setId(rs.getInt("id_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTel(rs.getInt("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCdp(rs.getInt("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMdp(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdmin(rs.getBoolean("administrateur"));
			}
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
	
	public Utilisateur verifMdpBdd(String mdp) {
		Utilisateur utilisateur = null;
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			
			PreparedStatement pstmt = cnx.prepareStatement("select * from Utilisateurs where mot_de_passe=?");
			pstmt.setString(1, mdp);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setId(rs.getInt("id_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTel(rs.getInt("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCdp(rs.getInt("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMdp(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdmin(rs.getBoolean("administrateur"));
			}
			
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

}
