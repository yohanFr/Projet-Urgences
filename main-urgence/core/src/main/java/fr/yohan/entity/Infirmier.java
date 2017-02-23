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
@DiscriminatorValue("INF")
public class Infirmier  extends Professionnel {

//	@Id
//	@GeneratedValue
//	private int idInf;
//
	private String nom;

	private String prenom;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // (mappedBy="idTel",cascade=CascadeType.ALL)
//	List<Telephone> telephones;

	@OneToOne(cascade = CascadeType.ALL)
	private GPSLoc gpsLoc;

	@OneToOne(cascade = CascadeType.ALL)
	private Adresse adresse;

	public Infirmier() {
		super();
	}

	public Infirmier(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

//	public int getIdInf() {
//		return idInf;
//	}
//
	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
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

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
		return "Infirmier [ nom=" + nom + ", prenom=" + prenom + ", gpsLoc=" + gpsLoc + ", adresse="
				+ adresse + "]";
	}

}
