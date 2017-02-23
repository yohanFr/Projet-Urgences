package fr.yohan.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import fr.yohan.entity.Theme;
import fr.yohan.facade.Facade;
import fr.yohan.service.IThemeService;


@ManagedBean(name="themeCtrl")
public class ThemeCtrl {

	
	IThemeService themeService = Facade.getInstance().getThemeService();
	
	public List<Theme> getAllTheme() {
		return themeService.findAll();
	}

}
