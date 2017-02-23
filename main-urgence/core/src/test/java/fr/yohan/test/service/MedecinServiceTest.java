package fr.yohan.test.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Medecin;
import fr.yohan.service.IMedecinService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/test2-context.xml")
public class MedecinServiceTest {
	@Autowired
	IMedecinService medecinService;

	@Test
	public void test() {
		//Medecin medecin;
		List<Medecin> medecins;// =new Medecin("Java");
		// medecinService.save(medecin);
		//
		//medecin = medecinService.find(3);
		//System.out.println("----------" + medecin);

		//
		// medecin.setLabel("dsd");
		//
		// medecinService.update(medecin);
		GPSLoc loc = new GPSLoc(48.689841, 2.3028 );
		medecins = medecinService.getMedecinsByLoc(loc, 15);

		System.out.println("----------" + medecins);

		// System.out.println(medecinService.findAll().size());
		//
		// Assert.assertNotNull(medecin);
	}
}
