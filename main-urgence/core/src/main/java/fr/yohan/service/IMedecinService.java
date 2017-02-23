package fr.yohan.service;


import java.util.List;

import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Medecin;


public interface IMedecinService {

	public void save(Medecin medecin);
	
	public void delete(Medecin medecin);
	
	public Medecin find(int medecinID);

	public Medecin update(Medecin medecin);
	
	public List<Medecin> getAllMedecins();
	
	public List<Medecin> getMedecinsByLoc(GPSLoc gpsLoc, int distance);
}
