package fr.yohan.dao;

import java.util.List;

import fr.yohan.entity.Formation;

public interface IFormationDao {
	
	public void save(Formation entity);

	public void delete(Formation entity);

	public Formation find(int entityID);

	public List<Formation> findAll();
	
	public Formation update(Formation entity);

}

