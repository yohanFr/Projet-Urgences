package fr.yohan.dao;

import java.util.List;

import fr.yohan.entity.Formation;
import fr.yohan.entity.Theme;

public interface IThemeDao {

	public void save(Theme entity);

	public void delete(Theme entity);

	public Theme find(int entityID);

	public List<Theme> findAll();

	public Theme update(Theme entity);
	
	public List<Formation> getFormationByTheme(int idTheme);

}

