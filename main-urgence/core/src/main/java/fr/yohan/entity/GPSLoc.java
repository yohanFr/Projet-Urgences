package fr.yohan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GPSLoc {

	@Id
	@GeneratedValue
	private int idLoc;
	
	private double longitude;
	
	private double latitude;

	public GPSLoc() {
		super();
	}

	public GPSLoc(double latitude,double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getIdLoc() {
		return idLoc;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "GPSLoc [idLoc=" + idLoc + ", latitude, longitude= " + latitude + ", " + longitude + "]";
	}

}
