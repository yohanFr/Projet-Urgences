package fr.yohan.service;

import fr.yohan.entity.Specialisation;

public interface ISpecialisationService {
	
	public void save(Specialisation specialisation);

	public void delete(Specialisation specialisation);

	public Specialisation find(int specialisationID);

	public Specialisation update(Specialisation specialisation);

}
