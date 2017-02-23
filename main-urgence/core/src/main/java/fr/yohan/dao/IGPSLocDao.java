package fr.yohan.dao;

import fr.yohan.entity.GPSLoc;

public interface IGPSLocDao {
	
	public void save(GPSLoc gpsLoc);

	public void delete(GPSLoc gpsLoc);

	public GPSLoc find(int gpsLocID);

	public GPSLoc update(GPSLoc gpsLoc);

}
