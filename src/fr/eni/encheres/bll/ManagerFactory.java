package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Articles;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;

/**
 * @author Assane
 * classe abstraite qui ne fait qu'instancier
 */

public abstract class ManagerFactory {
	
	public static ElementsEncheresManager<Articles> getArticlesManager() {
		return ArticlesManagerImpl.getInstance();
	}
	
	public static ElementsEncheresManager<Categorie> getCategorieManager() {
		return CategorieManagerImpl.getInstance();
	}
	
	public static ElementsEncheresManager<Encheres> getEncheresManager() {
		return EncheresManagerImpl.getInstance();
	}
	
	public static ElementsEncheresManager<Retrait> getRetraitManager() {
		return RetraitManagerImpl.getInstance();
	}
	
	public static ElementsEncheresManager<Utilisateur> getUtilisateurManager() {
		return UtilisateurManagerImpl.getInstance();
	}

}
