package fr.yohan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Telephone {

	@Id
	@GeneratedValue
	private int idTel;

	@ManyToOne
	@JsonBackReference
	private Professionnel professionnel;
	
	private String numero;

	public Telephone() {
		super();
	}

	public Telephone(String numero) {
		super();
		this.numero = numero;

	}

	public String getNumero() {
		return numero;
	}

	public int getIdTel() {
		return idTel;
	}

	public void setIdTel(int idTel) {
		this.idTel = idTel;
	}

	public Professionnel getProfessionnel() {
		return professionnel;
	}

	public void setProfessionnel(Professionnel professionnel) {
		this.professionnel = professionnel;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "" + numero;
	}

}
