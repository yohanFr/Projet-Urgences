package fr.yohan.facade;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.yohan.service.ICentreMedicalService;
import fr.yohan.service.IFormationService;
import fr.yohan.service.IInfirmierService;
import fr.yohan.service.IMedecinService;
import fr.yohan.service.IPharmacieService;
import fr.yohan.service.ISpecialisationService;
import fr.yohan.service.ITelephoneService;
import fr.yohan.service.IThemeService;

public class Facade {
	
	private static Facade uniqueInstance;
	
	public static synchronized Facade getInstance(){
		if (uniqueInstance == null) {
			uniqueInstance = new Facade();
		}
		return uniqueInstance;
	}
	
	private ApplicationContext springContext;
	
	private IFormationService formationService ;
	private IThemeService themeService ;
	
	
	private IMedecinService medecinService ;
	private IInfirmierService infirmierService ;
	private IPharmacieService pharmacieService ;
	private ICentreMedicalService centreMedicalService ;
	private ISpecialisationService specialisationService ;
	private ITelephoneService telephoneService ;
	

	
	private Facade(){
		springContext=new ClassPathXmlApplicationContext("META-INF/test2-context.xml");
		
		themeService = springContext.getBean("themeService", IThemeService.class);
		formationService = springContext.getBean("formationService", IFormationService.class);

		medecinService = springContext.getBean("medecinService", IMedecinService.class);
		infirmierService = springContext.getBean("infirmierService", IInfirmierService.class);
		pharmacieService = springContext.getBean("pharmacieService", IPharmacieService.class);
		centreMedicalService = springContext.getBean("centreMedicalService", ICentreMedicalService.class);
		specialisationService = springContext.getBean("specialisationService", ISpecialisationService.class);
		telephoneService = springContext.getBean("telephoneService", ITelephoneService.class);

	}


	public IFormationService getFormationService() {
		return formationService;
	}


	public IThemeService getThemeService() {
		return themeService;
	}


	public IMedecinService getMedecinService() {
		return medecinService;
	}


	public IInfirmierService getInfirmierService() {
		return infirmierService;
	}


	public IPharmacieService getPharmacieService() {
		return pharmacieService;
	}


	public ICentreMedicalService getCentreMedicalService() {
		return centreMedicalService;
	}


	public ISpecialisationService getSpecialisationService() {
		return specialisationService;
	}
	
	public ITelephoneService getTelephoneService() {
		return telephoneService;
	}
	
	
}
