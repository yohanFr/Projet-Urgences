package fr.yohan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.IMedecinDao;
import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Medecin;
import fr.yohan.entity.Professionnel;
import fr.yohan.gps.GPSTools;
import fr.yohan.service.IMedecinService;

@Transactional
@Service(value = "medecinService")
public class MedecinServiceImpl implements IMedecinService {

	@Autowired
	IMedecinDao medecinDao;

	@Override
	public void save(Medecin medecin) {
		medecinDao.save(medecin);

	}

	@Override
	public void delete(Medecin medecin) {
		medecinDao.delete(medecin);
	}

	@Override
	public Medecin find(int medecinID) {
		return medecinDao.find(medecinID);
	}

	@Override
	public Medecin update(Medecin medecin) {
		return medecinDao.update(medecin);
	}
	@Override
	public List<Medecin> getAllMedecins() {
//		List<Professionnel> pros = medecinDao.getAllMedecins();
//		List<Medecin> meds = new ArrayList<>();
//		for (Professionnel professionnel : pros) {
//			meds.add((Medecin) professionnel);
//		}
		return medecinDao.getAllMedecins();
	}
	
	@Override
	public List<Medecin> getMedecinsByLoc(GPSLoc gpsLoc, int distance) {
		List<GPSLoc> searchSquare = GPSTools.getSearchSquareCoordForDistance(gpsLoc, distance);
		GPSLoc cornerNE = (GPSLoc)searchSquare.get(0);
		GPSLoc cornerSW = (GPSLoc)searchSquare.get(1);
//		List<Professionnel> pros = medecinDao.getMedecinByLoc(cornerNE,cornerSW);
//		List<Medecin> meds = new ArrayList<>();
//		for (Professionnel professionnel : pros) {
//			meds.add((Medecin) professionnel);
//		}
		return medecinDao.getMedecinByLoc(cornerNE,cornerSW);
	}

}
