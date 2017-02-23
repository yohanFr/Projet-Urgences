package fr.yohan.service;

import java.util.List;

import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.CentreMedical;


public interface ICentreMedicalService {

	public void save(CentreMedical centreMedical);
	
	public void delete(CentreMedical centreMedical);
	
	public CentreMedical find(int centreMedicalID);

	public CentreMedical update(CentreMedical centreMedical);
	
	public List<CentreMedical> getCentreMedicalByLoc(GPSLoc gpsLoc, int distance);
}
