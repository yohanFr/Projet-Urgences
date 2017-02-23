package fr.yohan.service;

import java.util.List;

import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Pharmacie;


public interface IPharmacieService {

	public void save(Pharmacie pharmacie);
	
	public void delete(Pharmacie pharmacie);
	
	public Pharmacie find(int pharmacieID);

	public Pharmacie update(Pharmacie pharmacie);
	
	public List<Pharmacie> getPharmacieByLoc(GPSLoc gpsLoc, int distance);
}
