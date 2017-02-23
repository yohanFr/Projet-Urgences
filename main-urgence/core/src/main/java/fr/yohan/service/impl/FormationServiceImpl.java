package fr.yohan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.IFormationDao;
import fr.yohan.entity.Formation;
import fr.yohan.service.IFormationService;

@Transactional
@Service(value="formationService")
public class FormationServiceImpl implements IFormationService {
	
	@Autowired
	IFormationDao formationDao;

	public void save(Formation entity) {
		formationDao.save(entity);

	}

	public void delete(Formation entity) {
		formationDao.delete(entity);

	}

	public Formation find(int entityID) {
		return formationDao.find(entityID);
	}

	public List<Formation> findAll() {
		return formationDao.findAll();
	}

	public Formation update(Formation entity) {

		return formationDao.update(entity);
	}

}
