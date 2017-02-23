package fr.yohan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.ITelephoneDao;
import fr.yohan.entity.Telephone;
import fr.yohan.service.ITelephoneService;

@Transactional
@Service(value = "telephoneService")
public class TelephoneServiceImpl implements ITelephoneService {

	@Autowired
	ITelephoneDao telephoneDao;

	@Override
	public void save(Telephone telephone) {
		telephoneDao.save(telephone);

	}

	@Override
	public void delete(Telephone telephone) {
		telephoneDao.delete(telephone);
	}

	@Override
	public Telephone find(int telephoneID) {
		return telephoneDao.find(telephoneID);
	}

	@Override
	public Telephone update(Telephone telephone) {
		return telephoneDao.update(telephone);
	}

	
}
