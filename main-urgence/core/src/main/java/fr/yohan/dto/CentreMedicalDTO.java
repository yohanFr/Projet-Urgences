package fr.yohan.dto;

import java.util.List;

import fr.yohan.entity.Adresse;
import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Specialisation;
import fr.yohan.entity.Telephone;

public class CentreMedicalDTO {
	private int idCentre;

	private String type;

	private String nom;

	private GPSLoc gpsLoc;

	List<Telephone> telephones;

	private Adresse adresse;

	List<Specialisation> specialisations;

	public List<Specialisation> getSpecialisations() {
		return specialisations;
	}

	public void setSpecialisations(List<Specialisation> specialisations) {
		this.specialisations = specialisations;
	}

	public void setIdCentre(int idCentre) {
		this.idCentre = idCentre;
	}

	public int getIdCentre() {
		return idCentre;
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

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
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
		return "CentreMedical [idCentre=" + idCentre + ", type=" + type + ", nom=" + nom + "]";
	}


}
