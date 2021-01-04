package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.dal.DAOFactory;

public class EncheresManagerImpl implements ElementsEncheresManager<Encheres> {
	
	private static EncheresManagerImpl instance = null;
	
	private EncheresManagerImpl() {
		
	}
	
	public static EncheresManagerImpl getInstance() {
		if(instance==null) {
			instance = new EncheresManagerImpl();
		}
		return instance;
	}
	
	@Override
	public void create(Encheres enchere) {
		DAOFactory.getEncheresDAO().create(enchere);
	}
	
	@Override
	public Encheres selectById(Integer id) {
		return (Encheres) DAOFactory.getEncheresDAO().selectById(id);
	}
	
	@Override
	public List<Encheres> selectAll(){
		return (List<Encheres>) DAOFactory.getEncheresDAO().selectAll();
	}
	
	@Override
	public void update(Encheres enchere) {
		DAOFactory.getEncheresDAO().update(enchere);
	}
	
	@Override
	public void delete(Integer id) {
		DAOFactory.getEncheresDAO().delete(id);
	}
	
	
	
	
	
	
	
	

}
