package fr.yohan.managedbean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.yohan.entity.Telephone;
import fr.yohan.facade.Facade;
import fr.yohan.service.ITelephoneService;



@ManagedBean(name="telephoneCtrl")
@SessionScoped
public class TelephoneCtrl {

	
	ITelephoneService telephoneService = Facade.getInstance().getTelephoneService();
	
	public void delete(Telephone telephone) {
		telephoneService.delete(telephone);
	}
}
