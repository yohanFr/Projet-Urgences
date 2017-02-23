package fr.yohan.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.yohan.dao.ICentreMedicalDao;
//import fr.yohan.dao.IFormationDao;
import fr.yohan.dao.IInfirmierDao;
import fr.yohan.dao.IMedecinDao;
import fr.yohan.dao.IPharmacieDao;
//import fr.yohan.dao.IThemeDao;
import fr.yohan.entity.Adresse;
import fr.yohan.entity.CentreMedical;
//import fr.yohan.entity.Formation;
import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Infirmier;
import fr.yohan.entity.Medecin;
import fr.yohan.entity.Pharmacie;
import fr.yohan.entity.Specialisation;
import fr.yohan.entity.Telephone;
//import fr.yohan.entity.Theme;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/test2-context.xml")
public class DaoTest {

	/*
	 * @Autowired IFormationDao formationDao;
	 * 
	 * @Autowired IThemeDao themeDao;
	 */

	@Autowired
	IMedecinDao medecinDao;

	@Autowired
	IInfirmierDao infirmierDao;

	@Autowired
	ICentreMedicalDao centreMedicalDao;

	@Autowired
	IPharmacieDao pharmacieDao;

	@Test
	public void test() {

		// Pharmacie
		Adresse pharmaAdresse = new Adresse("20", "Avenue Gabriel Péri", "91700", "Sainte-Geneviève-des-Bois",
				"France");
		GPSLoc pharmaGpsLoc = new GPSLoc(48.653125, 2.315808);
		Telephone pharmaTel = new Telephone("0169510169");

		Pharmacie pharma = new Pharmacie("Pharmacie de Paris");
		pharma.setAdresse(pharmaAdresse);
		pharma.setGpsLoc(pharmaGpsLoc);
		pharmaTel.setProfessionnel(pharma);
		List<Telephone> pharmaTels = new ArrayList<>(Arrays.asList(pharmaTel));
		pharma.setTelephones(pharmaTels);

		// Infirmier
		Adresse infirmierAdresse = new Adresse("29", "Rue Nungesser", "91700", "Sainte-Geneviève-des-Bois", "France");
		GPSLoc infirmierGpsLoc = new GPSLoc(48.648516, 2.339711);
		Telephone infirmierTel = new Telephone("0169511365");

		Infirmier infirmier = new Infirmier("Moumen", "Malika");
		infirmier.setAdresse(infirmierAdresse);
		infirmier.setGpsLoc(infirmierGpsLoc);
		infirmierTel.setProfessionnel(infirmier);
		List<Telephone> infirmierTels = new ArrayList<>(Arrays.asList(infirmierTel));
		infirmier.setTelephones(infirmierTels);

		// CentreMedical
		Specialisation centreSpec = new Specialisation("Chirurgie Orthopédique et Traumatologique");
		Specialisation centreSpec1 = new Specialisation("Chirurgie Plastique, Esthétique & Reconstructrice");
		Specialisation centreSpec2 = new Specialisation("Cardiologie");
//		List<Specialisation> specs = new ArrayList<>();
//		specs.add(centreSpec);
//		specs.add(centreSpec1);
//		specs.add(centreSpec2);
		List<Specialisation> specs = new ArrayList<Specialisation>(Arrays.asList(centreSpec,centreSpec1,centreSpec2));

		Telephone centreTel = new Telephone("0826306030");
		Adresse centreAdresse = new Adresse("67-71", "Route de Corbeil", "91160", "Longjumeau", "France");
		GPSLoc centreGpsLoc = new GPSLoc(48.689841, 2.302800);

		CentreMedical centre = new CentreMedical("Clinique", "Clinique de l'Yvette");
		centre.setAdresse(centreAdresse);
		centre.setGpsLoc(centreGpsLoc);
		centre.setSpecialisations(specs);
		centreTel.setProfessionnel(centre);
		centreSpec.setProfessionnel(centre);
		centreSpec1.setProfessionnel(centre);
		centreSpec2.setProfessionnel(centre);
		List<Telephone> centreTels = new ArrayList<>(Arrays.asList(centreTel));
		centre.setTelephones(centreTels);

		// Medecin
		Specialisation medecinspec = new Specialisation("Genéraliste");
		Adresse medecinAdresse = new Adresse("91", "rte Corbeil", "91390", "MORSANG SUR ORGE", "France");
		GPSLoc medecinGpsLoc = new GPSLoc(48.653067, 2.338470);
		Telephone medecinTel = new Telephone("0169514538");
		Telephone medecinTel2 = new Telephone("0606060606");
		List<Specialisation> specialisations = new ArrayList<Specialisation>(Arrays.asList(medecinspec));

		Medecin medecin = new Medecin("Dr", "Dupoisot", "Olivier");
		medecin.setAdresse(medecinAdresse);
		medecin.setGpsLoc(medecinGpsLoc);
		medecin.setSpecialisations(specialisations);
		medecinTel.setProfessionnel(medecin);
		medecinTel2.setProfessionnel(medecin);
		medecinspec.setProfessionnel(medecin);
		List<Telephone> medecinTels = new ArrayList<>(Arrays.asList(medecinTel, medecinTel2));
		medecin.setTelephones(medecinTels);

		medecinDao.update(medecin);
		pharmacieDao.update(pharma);
		infirmierDao.update(infirmier);
		centreMedicalDao.update(centre);

		// System.out.println(themeDao.getFormationByTheme(1).size());

	}

}
