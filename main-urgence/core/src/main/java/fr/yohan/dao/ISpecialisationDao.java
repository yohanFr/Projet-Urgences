package fr.yohan.dao;

import fr.yohan.entity.Specialisation;

public interface ISpecialisationDao {
	
	public void save(Specialisation specialisation);

	public void delete(Specialisation specialisation);

	public Specialisation find(int specialisationID);

	public Specialisation update(Specialisation specialisation);

}
