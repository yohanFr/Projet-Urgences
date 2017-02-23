package fr.yohan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.ISpecialisationDao;
import fr.yohan.entity.Specialisation;
import fr.yohan.service.ISpecialisationService;

@Transactional
@Service(value = "specialisationService")
public class SpecialisationServiceImpl implements ISpecialisationService {

	@Autowired
	ISpecialisationDao specialisationDao;

	@Override
	public void save(Specialisation specialisation) {
		specialisationDao.save(specialisation);

	}

	@Override
	public void delete(Specialisation specialisation) {
		specialisationDao.delete(specialisation);
	}

	@Override
	public Specialisation find(int specialisationID) {
		return specialisationDao.find(specialisationID);
	}

	@Override
	public Specialisation update(Specialisation specialisation) {
		return specialisationDao.update(specialisation);
	}

	
}
