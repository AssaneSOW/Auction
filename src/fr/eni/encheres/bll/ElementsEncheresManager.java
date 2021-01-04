package fr.eni.encheres.bll;

import java.util.List;

public interface ElementsEncheresManager<T> {
	
	public void create(T typeGenerique);
	
	public T selectById(Integer id);
	public List<T> selectAll();
	
	public void update(T typeGenerique);
	
	public void delete(Integer id);

}
