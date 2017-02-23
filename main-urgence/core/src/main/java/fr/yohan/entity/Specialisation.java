package fr.yohan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Specialisation {
	
	@Id
	@GeneratedValue
	private int idSpec;
	
	@ManyToOne
	@JsonBackReference
	private Professionnel professionnel;
	
	
	private String intitule;
	
	
	public Specialisation() {
		super();
	}

	public Specialisation(String intitule) {
		super();
		this.intitule = intitule;
	}

	public Professionnel getProfessionnel() {
		return professionnel;
	}

	public void setProfessionnel(Professionnel professionnel) {
		this.professionnel = professionnel;
	}

	
	public int getIdSpec() {
		return idSpec;
	}

	public void setIdSpec(int idSpec) {
		this.idSpec = idSpec;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	@Override
	public String toString() {
		return ""+intitule ;
	}

}
