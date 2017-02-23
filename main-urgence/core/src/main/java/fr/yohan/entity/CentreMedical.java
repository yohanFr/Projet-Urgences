package fr.yohan.entity;



import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.OneToOne;


@Entity
@DiscriminatorValue("CENTRE")
public class CentreMedical extends Professionnel {


	private String type;

	private String nom;

	@OneToOne(cascade=CascadeType.ALL)
	private GPSLoc gpsLoc;

	@OneToOne(cascade=CascadeType.ALL)
	private Adresse adresse;

	public CentreMedical() {
		super();
	}

	public CentreMedical(String type, String nom) {
		super();
		this.type = type;
		this.nom = nom;
	}


	public String getType() {
		return type;
	}

	public String getNom() {
		return nom;
	}

	public GPSLoc getGpsLoc() {
		return gpsLoc;
	}
	public Adresse getAdresse() {
		return adresse;
	}

	
	public void setType(String type) {
		this.type = type;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setGpsLoc(GPSLoc gpsLoc) {
		this.gpsLoc = gpsLoc;
	}



	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	
	@Override
	public String toString() {
		return "CentreMedical [type=" + type + ", nom=" + nom + "]";
	}

}
