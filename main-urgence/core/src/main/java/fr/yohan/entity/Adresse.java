package fr.yohan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Adresse {
	
	@Id
	@GeneratedValue
	private int idAdresse;
	
	private String numero;
	
	private String voie;
	
	private String codePostal;
	
	private String ville;
	
	private String pays;

	public Adresse() {
		super();
	}

	public Adresse(String numero, String voie, String codePostal, String ville, String pays) {
		super();
		this.numero = numero;
		this.voie = voie;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}

	public int getIdAdresse() {
		return idAdresse;
	}

	public String getNumero() {
		return numero;
	}

	public String getVoie() {
		return voie;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public String getPays() {
		return pays;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return numero + " " + voie + " "+ codePostal + " " + ville + " " + pays ;
	}
	
	
}
