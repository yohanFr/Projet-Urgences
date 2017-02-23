package fr.yohan.dao;

import java.util.List;

import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Professionnel;


public interface IProfessionnelDao {

	public void save(Professionnel medecin);
	
	public void delete(Professionnel medecin);
	
	public Professionnel find(int medecinID);

	public Professionnel update(Professionnel medecin);
	
	public List<Professionnel> getAllProfessionnels();
	
	public List<Professionnel> getProfessionnelByLoc(GPSLoc gpsLocNE,GPSLoc gpsLocSW );
}
