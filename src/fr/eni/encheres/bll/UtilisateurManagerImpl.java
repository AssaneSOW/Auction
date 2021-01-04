package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;

public class UtilisateurManagerImpl implements ElementsEncheresManager<Utilisateur> {
	
	private static UtilisateurManagerImpl instance = null;
	
	private UtilisateurManagerImpl() {
		
	}
	
	public static UtilisateurManagerImpl getInstance() {
		if(instance==null) {
			instance = new UtilisateurManagerImpl();
		}
		return instance;
	}
	
	@Override
	public void create(Utilisateur utilisateur) {
		DAOFactory.getUtilisateurDAO().create(utilisateur);
	}
	
	@Override
	public Utilisateur selectById(Integer id) {
		return (Utilisateur) DAOFactory.getUtilisateurDAO().selectById(id);
	}
	
	@Override
	public List<Utilisateur> selectAll(){
		return (List<Utilisateur>) DAOFactory.getUtilisateurDAO().selectAll();
	}
	
	@Override
	public void update(Utilisateur utilisateur) {
		DAOFactory.getUtilisateurDAO().update(utilisateur);
	}
	
	@Override
	public void delete(Integer id) {
		DAOFactory.getUtilisateurDAO().delete(id);
	}
	
	public Utilisateur login(String pseudo, String mdp) {
		return DAOFactory.getUtilisateurDAO().login(pseudo, mdp);
	}
	
	public Utilisateur verifEmailBdd(String email) {
		return DAOFactory.getUtilisateurDAO().verifEmailBdd(email);
	}
	
	public Utilisateur verifPseudoBdd(String pseudo) {
		return DAOFactory.getUtilisateurDAO().verifPseudoBdd(pseudo);
	}
	
	public Utilisateur verifMdpBdd(String mdp) {
		return DAOFactory.getUtilisateurDAO().verifMdpBdd(mdp);
	}
	
	
}
