package fr.yohan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.IInfirmierDao;
import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Infirmier;
import fr.yohan.gps.GPSTools;
import fr.yohan.service.IInfirmierService;

@Transactional
@Service(value = "infirmierService")
public class InfirmierServiceImpl implements IInfirmierService {

	@Autowired
	IInfirmierDao infirmierDao;

	@Override
	public void save(Infirmier infirmier) {
		infirmierDao.save(infirmier);

	}

	@Override
	public void delete(Infirmier infirmier) {
		infirmierDao.delete(infirmier);
	}

	@Override
	public Infirmier find(int infirmierID) {
		return infirmierDao.find(infirmierID);
	}

	@Override
	public Infirmier update(Infirmier infirmier) {
		return infirmierDao.update(infirmier);
	}

	@Override
	public List<Infirmier> getInfirmierByLoc(GPSLoc gpsLoc, int distance) {
		List<GPSLoc> searchSquare = GPSTools.getSearchSquareCoordForDistance(gpsLoc, distance);
		GPSLoc cornerNE = (GPSLoc)searchSquare.get(0);
		GPSLoc cornerSW = (GPSLoc)searchSquare.get(1);
		return infirmierDao.getInfirmierByLoc(cornerNE,cornerSW);
	}

}
