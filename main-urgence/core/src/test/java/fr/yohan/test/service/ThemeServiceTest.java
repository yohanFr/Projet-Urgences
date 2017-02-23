package fr.yohan.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import fr.yohan.entity.Theme;
import fr.yohan.service.IThemeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/test-context.xml")
public class ThemeServiceTest {

	@Autowired
	IThemeService themeService;

	@Test
	public void test() {
		
		Theme theme=new Theme("Java");
		themeService.save(theme); 
		
		theme = themeService.find(1);
		
		theme.setLabel("dsd");
		
		themeService.update(theme);
		
		theme = themeService.find(1);
		
		System.out.println(theme);
		
		System.out.println(themeService.findAll().size());
		
		Assert.assertNotNull(theme);
	}
}

