package fr.yohan.service;

import fr.yohan.entity.GPSLoc;

public interface IGPSLocService {
	
	public void save(GPSLoc gpsLoc);

	public void delete(GPSLoc gpsLoc);

	public GPSLoc find(int gpsLocID);

	public GPSLoc update(GPSLoc gpsLoc);

}
