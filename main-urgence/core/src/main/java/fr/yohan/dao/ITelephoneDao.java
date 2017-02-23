package fr.yohan.dao;

import fr.yohan.entity.Telephone;

public interface ITelephoneDao {
	
	public void save(Telephone telephone);

	public void delete(Telephone telephone);

	public Telephone find(int telephoneID);

	public Telephone update(Telephone telephone);
	

}
