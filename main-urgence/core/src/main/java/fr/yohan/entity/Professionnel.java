package fr.yohan.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Inheritance
@DiscriminatorColumn(name = "PRO_TYPE")
public abstract class Professionnel {

	@Id
	@GeneratedValue
	private int idPro;

	public int getIdPro() {
		return idPro;
	}

	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}

	@OneToMany(orphanRemoval = true, mappedBy = "professionnel", cascade = CascadeType.ALL, fetch = FetchType.EAGER) // (mappedBy="idTel",cascade=CascadeType.ALL)
	@JsonManagedReference
	List<Telephone> telephones;

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}

	@OneToMany(mappedBy = "professionnel", cascade = CascadeType.ALL, fetch = FetchType.EAGER) // (mappedBy="idSpec",cascade=CascadeType.ALL)
	@JsonManagedReference
	List<Specialisation> specialisations;

	public List<Specialisation> getSpecialisations() {
		return specialisations;
	}

	public void setSpecialisations(List<Specialisation> specialisations) {
		this.specialisations = specialisations;
	}

}
