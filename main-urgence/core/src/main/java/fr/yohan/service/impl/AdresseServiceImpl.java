package fr.yohan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.IAdresseDao;
import fr.yohan.entity.Adresse;
import fr.yohan.service.IAdresseService;

@Transactional
@Service(value = "adresseService")
public class AdresseServiceImpl implements IAdresseService {

	@Autowired
	IAdresseDao adresseDao;

	@Override
	public void save(Adresse adresse) {
		adresseDao.save(adresse);

	}

	@Override
	public void delete(Adresse adresse) {
		adresseDao.delete(adresse);
	}

	@Override
	public Adresse find(int adresseID) {
		return adresseDao.find(adresseID);
	}

	@Override
	public Adresse update(Adresse adresse) {
		return adresseDao.update(adresse);
	}

	
}
