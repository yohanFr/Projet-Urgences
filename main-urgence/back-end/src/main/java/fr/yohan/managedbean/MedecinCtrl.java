package fr.yohan.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import fr.yohan.entity.Adresse;
import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Medecin;
import fr.yohan.entity.Specialisation;
import fr.yohan.entity.Telephone;
import fr.yohan.facade.Facade;
import fr.yohan.service.IMedecinService;

@ManagedBean(name = "medecinCtrl")
@SessionScoped
public class MedecinCtrl {

	IMedecinService medecinService = Facade.getInstance().getMedecinService();

	private boolean edition;

	private String action;

	private Medecin medecin;

	private List<Medecin> medecins;

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public void save(Medecin medecin) {
		medecinService.save(medecin);
	}

	public void delete(Medecin medecin) {
		medecinService.delete(medecin);
	}

	public Medecin find(int medecinID) {
		return medecinService.find(medecinID);
	}

	public Medecin update(Medecin medecin) {
		return medecinService.update(medecin);

	}

	public void editMedecin(Medecin medecin) {
		setEdition(true);
		medecin.setEditable(true);

	}

	public void deleteTelephone(Medecin med, Telephone telephone) {
		List<Telephone> tels = med.getTelephones();
		tels.remove(telephone);
		med.setTelephones(tels);
	}

	public void addSpecialisation(Medecin med) {
		System.out.println("addTelephone");
		List<Specialisation> specialisations = med.getSpecialisations();
		Specialisation newSpecialisation = new Specialisation();
		newSpecialisation.setProfessionnel(med);
		specialisations.add(newSpecialisation);
		med.setSpecialisations(specialisations);

	}

	public void deleteSpecialisation(Medecin med, Specialisation specialisation) {
		List<Specialisation> specialisations = med.getSpecialisations();
		specialisations.remove(specialisation);
		med.setSpecialisations(specialisations);
	}

	public void addTelephone(Medecin med) {
		System.out.println("addTelephone");
		List<Telephone> tels = med.getTelephones();
		Telephone newTel = new Telephone();
		newTel.setProfessionnel(med);
		tels.add(newTel);
		med.setTelephones(tels);

	}

	public boolean isEdition() {
		return edition;
	}

	public void setEdition(boolean edition) {
		if (edition)
			action = "edit";
		else
			action = null;
		this.edition = edition;

	}

	public String saveModif() {

		for (Medecin medecin : medecins) {
			if (medecin.isEditable()) {
				medecinService.update(medecin);
				medecin.setEditable(false);

			}
		}

		setEdition(false);
		return "index";
	}

	public void saveMedecin() {

		medecinService.update(medecin);

	}

	public void preAddMedecin(ActionEvent event) {
		System.out.println("preAddMedecin2");
		this.medecin = new Medecin();
		medecin.setAdresse(new Adresse());
		List<Specialisation> specialisations = new ArrayList<>();
		Specialisation spec =new Specialisation();
		spec.setProfessionnel(medecin);
		specialisations.add(spec);
		medecin.setSpecialisations(specialisations);
		List<Telephone> tels = new ArrayList<>();
		Telephone tel =new Telephone();
		tel.setProfessionnel(medecin);
		tels.add(tel);

		this.medecin.setTelephones(tels);

	}

	public String outToNewMedecin() {
		return "ajoutMedecin";
	}

	public String outToListAll() {
		System.out.println("outToListAll");
		return "index";
	}

	public List<Medecin> getAllMedecins() {
		if (action == null | medecins == null) {
			medecins = medecinService.getAllMedecins();
		}
		return medecins;

	}

	public List<Medecin> getMedecinsByLoc(GPSLoc gpsLoc, int distance) {
		return medecinService.getMedecinsByLoc(gpsLoc, distance);

	}

}
