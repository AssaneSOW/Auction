package fr.eni.encheres.dal;


public abstract class DAOFactory {
	
	public static ArticlesDAOJdbcImpl getArticlesDAO() {
		return ArticlesDAOJdbcImpl.getInstance();
	}
	
	public static CategorieDAOJdbcImpl getCategorieDAO() {
		return CategorieDAOJdbcImpl.getInstance();
	}

	public static EncheresDAOJdbcImpl getEncheresDAO() {
		return EncheresDAOJdbcImpl.getInstance();
	}

	public static RetraitDAOJdbcImpl getRetraitDAO() {
		return RetraitDAOJdbcImpl.getInstance();
	}

	public static UtilisateurDAOJdbcImpl getUtilisateurDAO() {
		return UtilisateurDAOJdbcImpl.getInstance();
	}
	
	
}
