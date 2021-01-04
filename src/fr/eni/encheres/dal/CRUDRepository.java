package fr.eni.encheres.dal;

import java.util.List;

public interface CRUDRepository<T> {
	
	public void create(T typeGenerique);
	
	public T selectById(Integer id);
	public List<T> selectAll();
	
	public void update(T typeGenerique);
	
	public void delete(Integer id);
	

}
