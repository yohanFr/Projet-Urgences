package fr.yohan.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import fr.yohan.entity.Formation;
import fr.yohan.facade.Facade;
import fr.yohan.service.IFormationService;

@ManagedBean(name="formCtrl")
public class FormationCtrl {


	IFormationService formService = Facade.getInstance().getFormationService();

	public List<Formation> getAllFormation() {
		return formService.findAll();
	}

	public List<Formation> getAllFormationByTheme() {
		return formService.findAll();
	}

}
