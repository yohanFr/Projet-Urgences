package fr.yohan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.IPharmacieDao;
import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Pharmacie;
import fr.yohan.gps.GPSTools;
import fr.yohan.service.IPharmacieService;

@Transactional
@Service(value = "pharmacieService")
public class PharmacieServiceImpl implements IPharmacieService {

	@Autowired
	IPharmacieDao pharmacieDao;

	@Override
	public void save(Pharmacie pharmacie) {
		pharmacieDao.save(pharmacie);

	}

	@Override
	public void delete(Pharmacie pharmacie) {
		pharmacieDao.delete(pharmacie);
	}

	@Override
	public Pharmacie find(int pharmacieID) {
		return pharmacieDao.find(pharmacieID);
	}

	@Override
	public Pharmacie update(Pharmacie pharmacie) {
		return pharmacieDao.update(pharmacie);
	}

	@Override
	public List<Pharmacie> getPharmacieByLoc(GPSLoc gpsLoc, int distance) {
		List<GPSLoc> searchSquare = GPSTools.getSearchSquareCoordForDistance(gpsLoc, distance);
		GPSLoc cornerNE = (GPSLoc)searchSquare.get(0);
		GPSLoc cornerSW = (GPSLoc)searchSquare.get(1);
		return pharmacieDao.getPharmacieByLoc(cornerNE,cornerSW);
	}

}
