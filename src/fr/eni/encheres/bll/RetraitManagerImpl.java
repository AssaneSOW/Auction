package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.DAOFactory;

public class RetraitManagerImpl implements ElementsEncheresManager<Retrait> {
	
	private static RetraitManagerImpl instance = null;
	
	private RetraitManagerImpl() {
		
	}
	
	public static RetraitManagerImpl getInstance() {
		if(instance==null) {
			instance = new RetraitManagerImpl();
		}
		return instance;
	}
	
	@Override
	public void create(Retrait retrait) {
		DAOFactory.getRetraitDAO().create(retrait);
	}
	
	@Override
	public Retrait selectById(Integer id) {
		return (Retrait) DAOFactory.getRetraitDAO().selectById(id);
	}
	
	@Override
	public List<Retrait> selectAll(){
		return (List<Retrait>) DAOFactory.getRetraitDAO().selectAll();
	}
	
	@Override
	public void update(Retrait retrait) {
		DAOFactory.getRetraitDAO().update(retrait);
	}
	
	@Override
	public void delete(Integer id) {
		DAOFactory.getRetraitDAO().delete(id);
	}
	
	
	
	
	
	
	
	

}
