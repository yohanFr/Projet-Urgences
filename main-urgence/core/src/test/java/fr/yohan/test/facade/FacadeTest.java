package fr.yohan.test.facade;

import java.util.List;

import fr.yohan.entity.Formation;
import fr.yohan.facade.Facade;
import fr.yohan.service.IFormationService;

public class FacadeTest {

	public static void main(String[] args) {
		IFormationService formService = Facade.getInstance().getFormationService();

		List<Formation> lf = formService.findAll();
		System.out.println(" ");

		for (Formation formation : lf) {
			System.out.println(formation);
		}
	}
}
