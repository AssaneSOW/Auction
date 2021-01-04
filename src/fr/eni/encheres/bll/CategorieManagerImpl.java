package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.DAOFactory;

public class CategorieManagerImpl implements ElementsEncheresManager<Categorie> {
	
	private static CategorieManagerImpl instance = null;
	
	private CategorieManagerImpl() {
		
	}
	
	public static CategorieManagerImpl getInstance() {
		if(instance==null) {
			instance = new CategorieManagerImpl();
		}
		return instance;
	}
	
	@Override
	public void create(Categorie cat) {
		DAOFactory.getCategorieDAO().create(cat);
	}
	
	@Override
	public Categorie selectById(Integer id) {
		return (Categorie) DAOFactory.getCategorieDAO().selectById(id);
	}
	
	@Override
	public List<Categorie> selectAll(){
		return (List<Categorie>) DAOFactory.getCategorieDAO().selectAll();
	}
	
	@Override
	public void update(Categorie cat) {
		DAOFactory.getCategorieDAO().update(cat);
	}
	
	@Override
	public void delete(Integer id) {
		DAOFactory.getCategorieDAO().delete(id);
	}
	
	
	
	
	
	
	
	

}
