package fr.yohan.dao;

import java.util.List;

import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.CentreMedical;


public interface ICentreMedicalDao {

	public void save(CentreMedical centreMedical);
	
	public void delete(CentreMedical centreMedical);
	
	public CentreMedical find(int centreMedicalID);

	public CentreMedical update(CentreMedical centreMedical);
	
	public List<CentreMedical> getCentreMedicalByLoc(GPSLoc gpsLocNE,GPSLoc gpsLocSW );
}
