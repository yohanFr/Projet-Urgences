package fr.yohan.service;

import java.util.List;

import fr.yohan.entity.Theme;

public interface IThemeService {
	
	public void save(Theme entity);

	public void delete(Theme entity);

	public Theme find(int entityID);

	public List<Theme> findAll();

	public Theme update(Theme entity);

}
