package fr.yohan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.ICentreMedicalDao;
import fr.yohan.entity.GPSLoc;
import fr.yohan.gps.GPSTools;
import fr.yohan.entity.CentreMedical;
import fr.yohan.service.ICentreMedicalService;

@Transactional
@Service(value = "centreMedicalService")
public class CentreMedicalServiceImpl implements ICentreMedicalService {

	@Autowired
	ICentreMedicalDao centreMedicalDao;

	@Override
	public void save(CentreMedical centreMedical) {
		centreMedicalDao.save(centreMedical);

	}

	@Override
	public void delete(CentreMedical centreMedical) {
		centreMedicalDao.delete(centreMedical);
	}

	@Override
	public CentreMedical find(int centreMedicalID) {
		return centreMedicalDao.find(centreMedicalID);
	}

	@Override
	public CentreMedical update(CentreMedical centreMedical) {
		return centreMedicalDao.update(centreMedical);
	}

	@Override
	public List<CentreMedical> getCentreMedicalByLoc(GPSLoc gpsLoc, int distance) {
		List<GPSLoc> searchSquare = GPSTools.getSearchSquareCoordForDistance(gpsLoc, distance);
		GPSLoc cornerNE = (GPSLoc)searchSquare.get(0);
		GPSLoc cornerSW = (GPSLoc)searchSquare.get(1);
		return centreMedicalDao.getCentreMedicalByLoc(cornerNE,cornerSW);
	}

}
