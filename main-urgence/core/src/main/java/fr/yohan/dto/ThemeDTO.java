package fr.yohan.dto;

public class ThemeDTO {

	private int idTheme;

	private String label;

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

	@Override
	public String toString() {
		return "ThemeDTO [idTheme=" + idTheme + ", label=" + label + "]";
	}
	
}
