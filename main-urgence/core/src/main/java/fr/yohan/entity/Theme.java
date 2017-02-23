package fr.yohan.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Theme {

	@Id
	@GeneratedValue
	private int idTheme;

	private String label;
	
	@OneToMany(mappedBy="theme",cascade=CascadeType.ALL)
	List<Formation> formations;

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public int getIdTheme() {
		return idTheme;
	}

	public String getLabel() {
		return label;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Theme(String label) {
		this();
		this.label = label;
	}

	public Theme() {

	}

	@Override
	public String toString() {
		return "Theme [idTheme=" + idTheme + ", label=" + label + "]";
	}
}
