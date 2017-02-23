package fr.yohan.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("PHARMA")
public class Pharmacie  extends Professionnel {

//	@Id
//	@GeneratedValue
//	private int idPharma;

	// private String userType;

	private String nom;

	@OneToOne(cascade = CascadeType.ALL)
	private GPSLoc gpsLoc;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // (mappedBy="idTel",cascade=CascadeType.ALL)
//	List<Telephone> telephones;

	@OneToOne(cascade = CascadeType.ALL)
	private Adresse adresse;

	public Pharmacie() {
		super();
	}

	public Pharmacie(String nom) {
		super();
		this.nom = nom;
	}

//	public int getIdPharma() {
//		return idPharma;
//	}

	public String getNom() {
		return nom;
	}

	public GPSLoc getGpsLoc() {
		return gpsLoc;
	}

	public Adresse getAdresse() {
		return adresse;
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

//	public List<Telephone> getTelephones() {
//		return telephones;
//	}
//
//	public void setTelephones(List<Telephone> telephones) {
//		this.telephones = telephones;
//	}

	@Override
	public String toString() {
		return "Pharmacie [ nom=" + nom + "]";
	}

}
