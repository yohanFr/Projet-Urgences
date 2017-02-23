package fr.yohan.service;

import fr.yohan.entity.Telephone;

public interface ITelephoneService {
	
	public void save(Telephone telephone);

	public void delete(Telephone telephone);

	public Telephone find(int telephoneID);

	public Telephone update(Telephone telephone);
	

}
