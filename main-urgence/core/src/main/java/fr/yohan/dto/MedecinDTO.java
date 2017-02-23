package fr.yohan.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.yohan.entity.Adresse;
import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Specialisation;
import fr.yohan.entity.Telephone;

@JsonIgnoreProperties(value = { "editable" })
public class MedecinDTO {


	private int idMed;

	private String titre;

	private String nom;

	private String prenom;

	List<Telephone> telephones;

	private GPSLoc gpsLoc;

	private boolean editable;
	
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	private Adresse adresse;

	List<Specialisation> specialisations;

	public List<Specialisation> getSpecialisations() {
		return specialisations;
	}

	public void setSpecialisations(List<Specialisation> specialisations) {
		this.specialisations = specialisations;
	}

	
	public void setIdMed(int idMed) {
		this.idMed = idMed;
	}

	public int getIdMed() {
		return idMed;
	}

	public String getTitre() {
		return titre;
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

	public void setTitre(String titre) {
		this.titre = titre;
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
		return "Medecin [idMed=" + idMed + ", titre=" + titre + ", nom=" + nom + ", prenom=" + prenom + ", telephones="
				+ telephones + ", gpsLoc=" + gpsLoc + ", adresse=" + adresse + ", specialisations=" + specialisations
				+ "]";
	}

	
}
