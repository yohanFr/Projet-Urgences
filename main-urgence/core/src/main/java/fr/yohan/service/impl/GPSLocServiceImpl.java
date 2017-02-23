package fr.yohan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.IGPSLocDao;
import fr.yohan.entity.GPSLoc;
import fr.yohan.service.IGPSLocService;

@Transactional
@Service(value = "gpsLocService")
public class GPSLocServiceImpl implements IGPSLocService {

	@Autowired
	IGPSLocDao gpsLocDao;

	@Override
	public void save(GPSLoc gpsLoc) {
		gpsLocDao.save(gpsLoc);

	}

	@Override
	public void delete(GPSLoc gpsLoc) {
		gpsLocDao.delete(gpsLoc);
	}

	@Override
	public GPSLoc find(int gpsLocID) {
		return gpsLocDao.find(gpsLocID);
	}

	@Override
	public GPSLoc update(GPSLoc gpsLoc) {
		return gpsLocDao.update(gpsLoc);
	}

	
}
