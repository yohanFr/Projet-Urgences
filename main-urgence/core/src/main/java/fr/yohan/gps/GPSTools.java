package fr.yohan.gps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.yohan.entity.GPSLoc;

public class GPSTools {
	static final double distanceReference = 111.11;

	static public List<GPSLoc> getSearchSquareCoordForDistance(GPSLoc loc, int distance) {
		
		final double deltaLatitude = (distance / distanceReference) ;
		final double deltaLongitude = ((distance / Math.cos(Math.toRadians(loc.getLatitude()))) / distanceReference) ;

		final GPSLoc cornerNE = new GPSLoc(loc.getLatitude() + deltaLatitude, loc.getLongitude() + deltaLongitude);
		final GPSLoc cornerSW = new GPSLoc(loc.getLatitude() - deltaLatitude, loc.getLongitude() - deltaLongitude);
		
		return new ArrayList<GPSLoc>(Arrays.asList(cornerNE, cornerSW));
	}

}
