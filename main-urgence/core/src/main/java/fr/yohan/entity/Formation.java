package fr.yohan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Formation {

	@Id
	@GeneratedValue
	private int idForm;

	private String titre;

	private int duree;

	private float prix;

	private String audience;

	private String objectif;

	private String outils;

	private String plan;
	
	@ManyToOne
	private Theme theme;
	
	public Formation() {
		
	}
	

	public Formation(String titre, int duree, float prix, String audience,
			String objectif, String outils, String plan) {

		this.titre = titre;
		this.duree = duree;
		this.prix = prix;
		this.audience = audience;
		this.objectif = objectif;
		this.outils = outils;
		this.plan = plan;
	}

	public int getIdForm() {
		return idForm;
	}

	public String getTitre() {
		return titre;
	}

	public int getDuree() {
		return duree;
	}

	public float getPrix() {
		return prix;
	}

	public String getAudience() {
		return audience;
	}

	public String getObjectif() {
		return objectif;
	}

	public String getOutils() {
		return outils;
	}

	public String getPlan() {
		return plan;
	}

	public Theme getTheme() {
		return theme;
	}


	public void setTheme(Theme theme) {
		this.theme = theme;
	}


	public void setIdForm(int idForm) {
		this.idForm = idForm;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public void setAudience(String audience) {
		this.audience = audience;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public void setOutils(String outils) {
		this.outils = outils;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "Formation [idForm=" + idForm + ", titre=" + titre + ", duree="
				+ duree + ", prix=" + prix + ", audience=" + audience
				+ ", objectif=" + objectif + ", outils=" + outils + ", plan="
				+ plan + "]";
	}

}
