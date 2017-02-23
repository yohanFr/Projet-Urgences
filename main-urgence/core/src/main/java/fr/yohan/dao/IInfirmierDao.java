package fr.yohan.dao;

import java.util.List;

import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Infirmier;


public interface IInfirmierDao {

	public void save(Infirmier infirmier);
	
	public void delete(Infirmier infirmier);
	
	public Infirmier find(int infirmierID);

	public Infirmier update(Infirmier infirmier);
	
	public List<Infirmier> getInfirmierByLoc(GPSLoc gpsLocNE,GPSLoc gpsLocSW );
}
