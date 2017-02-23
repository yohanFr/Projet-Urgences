package fr.yohan.dao;

import fr.yohan.entity.Adresse;

public interface IAdresseDao {
	
	public void save(Adresse adresse);

	public void delete(Adresse adresse);

	public Adresse find(int adresseID);

	public Adresse update(Adresse adresse);
	

}
