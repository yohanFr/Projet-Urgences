package fr.yohan.dto;

import java.util.List;

import fr.yohan.entity.Adresse;
import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Telephone;

public class InfirmierDTO {

	private int idInf;
		
	private String  nom;
	
	private String prenom;
	
	List<Telephone> telephones;
	
	private GPSLoc gpsLoc;
	
	private Adresse adresse;

	public int getIdInf() {
		return idInf;
	}

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

	public void setIdInf(int idInf) {
		this.idInf = idInf;
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
	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}


	@Override
	public String toString() {
		return "Infirmier [idInf=" + idInf + ", nom=" + nom + ", prenom=" + prenom + ", gpsLoc=" + gpsLoc + ", adresse=" + adresse + "]";
	}
	
}
