package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Articles;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.DAOFactory;

public class ArticlesManagerImpl implements ElementsEncheresManager<Articles> {
	
	private static ArticlesManagerImpl instance = null;
	
	private ArticlesManagerImpl() {
		
	}

	public static ElementsEncheresManager<Articles> getInstance() {
		if(instance==null) {
			instance = new ArticlesManagerImpl();
		}
		return instance;
	}
	
	@Override
	public void create(Articles article) {
		DAOFactory.getArticlesDAO().create(article);
	}
	
	public void create(Articles article, Retrait retrait) {
		DAOFactory.getArticlesDAO().create(article, retrait);
	}
	
	@Override
	public Articles selectById(Integer id) {
		return (Articles) DAOFactory.getArticlesDAO().selectById(id);
	}
	
	@Override
	public List<Articles> selectAll(){
		return (List<Articles>) DAOFactory.getArticlesDAO().selectAll();
	}
	
	@Override
	public void update(Articles article) {
		DAOFactory.getArticlesDAO().update(article);
	}
	
	@Override
	public void delete(Integer id) {
		DAOFactory.getArticlesDAO().delete(id);
	}

	public List<Articles> selectByMot(String motCle) {
		return (List<Articles>) DAOFactory.getArticlesDAO().selectByMot(motCle);
	}
	
	
	
	
	
	
	
	

}
