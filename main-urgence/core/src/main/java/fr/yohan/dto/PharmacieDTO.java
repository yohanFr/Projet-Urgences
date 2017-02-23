package fr.yohan.dto;

import java.util.List;

import fr.yohan.entity.Adresse;
import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Telephone;


public class PharmacieDTO {
	

	private int idPharma;
	
	private String  nom;

	private GPSLoc gpsLoc;


	List<Telephone> telephones;
	
	private Adresse adresse;

	public PharmacieDTO() {
		super();
	}

	public PharmacieDTO(String nom) {
		super();
		this.nom = nom;
	}

	public void setIdPharma(int idPharma) {
		this.idPharma = idPharma;
	}

	public int getIdPharma() {
		return idPharma;
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

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setGpsLoc(GPSLoc gpsLoc) {
		this.gpsLoc = gpsLoc;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}

	@Override
	public String toString() {
		return "Pharmacie [idPharma=" + idPharma + ", nom=" + nom + "]";
	}

}
