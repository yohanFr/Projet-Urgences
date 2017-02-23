package fr.yohan.test.gps;

import fr.yohan.entity.GPSLoc;
import fr.yohan.gps.GPSTools;

public class testGpsLoc {
	
	
	public static void main(String[] args) {
		final GPSLoc loc = new GPSLoc(48.653368, 2.359041);
		final int distance=15;
		System.out.println(GPSTools.getSearchSquareCoordForDistance(loc, distance));
	}
	
}
