package fr.yohan.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("MED")
public class Medecin  extends Professionnel {

//	@Id
//	@GeneratedValue
//	private int idMed;

	//private String userType;
	
	private String titre;

	private String nom;

	private String prenom;

	@Transient
	private boolean editable;

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

//	@OneToMany(orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER) // (mappedBy="telId",cascade=CascadeType.ALL)
//	List<Telephone> telephones;

	@OneToOne(cascade = CascadeType.ALL)
	private GPSLoc gpsLoc;

	@OneToOne(cascade = CascadeType.ALL)
	private Adresse adresse;

	public Medecin() {
		super();
	}

	public Medecin(String titre, String nom, String prenom) {
		super();
		this.titre = titre;
		this.nom = nom;
		this.prenom = prenom;
		//this.userType = this.getClass().getSimpleName();
	}

//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // (mappedBy="idSpec",cascade=CascadeType.ALL)
//	@JoinColumns({ @JoinColumn(name = "SPEC_ID", referencedColumnName = "idSpec"),
//			@JoinColumn(name = "USER_TYPE", referencedColumnName = "userType") })
//	List<Specialisation> specialisations;
//
//	public List<Specialisation> getSpecialisations() {
//		return specialisations;
//	}
//
//	public void setSpecialisations(List<Specialisation> specialisations) {
//		this.specialisations = specialisations;
//	}

//	public int getIdMed() {
//		return idMed;
//	}

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

//	public List<Telephone> getTelephones() {
//		return telephones;
//	}
//
//	public void setTelephones(List<Telephone> telephones) {
//		this.telephones = telephones;
//	}

	@Override
	public String toString() {
		return "Medecin [ titre=" + titre + ", nom=" + nom + ", prenom=" + prenom + ", telephones="
				+ telephones + ", gpsLoc=" + gpsLoc + ", adresse=" + adresse + ", specialisations=" + specialisations
				+ "]";
	}

}
