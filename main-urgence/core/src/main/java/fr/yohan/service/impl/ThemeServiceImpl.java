package fr.yohan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.IThemeDao;
import fr.yohan.entity.Formation;
import fr.yohan.entity.Theme;
import fr.yohan.service.IThemeService;

@Transactional
@Service(value="themeService")
public class ThemeServiceImpl implements IThemeService{
	
	@Autowired
	IThemeDao themeDao;

	public void save(Theme entity) {
		themeDao.save(entity);

	}

	public void delete(Theme entity) {
		themeDao.delete(entity);

	}

	public Theme find(int entityID) {
		return themeDao.find(entityID);
	}

	public List<Theme> findAll() {
		return themeDao.findAll();
	}

	public Theme update(Theme entity) {
		return themeDao.update(entity);
	}


	public List<Formation> getFormationByTheme(int idTheme) {
		return themeDao.getFormationByTheme(idTheme);
	}
}
