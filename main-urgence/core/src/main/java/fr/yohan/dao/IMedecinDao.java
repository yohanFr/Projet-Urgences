package fr.yohan.dao;

import java.util.List;

import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Medecin;
import fr.yohan.entity.Professionnel;


public interface IMedecinDao {

	public void save(Medecin medecin);
	
	public void delete(Medecin medecin);
	
	public Medecin find(int medecinID);

	public Medecin update(Medecin medecin);
	
	public List<Medecin> getAllMedecins();
	
	public List<Medecin> getMedecinByLoc(GPSLoc gpsLocNE,GPSLoc gpsLocSW );
}
