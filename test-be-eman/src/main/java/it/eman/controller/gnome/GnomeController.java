package it.eman.controller.gnome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import it.eman.dto.gnome.BrastlewarkListDto;
import it.eman.service.gnome.GnomeService;
import it.eman.utils.mapper.JsonObjMapper;

@RestController
@RequestMapping(value = "/gnome", produces = "application/json")
public class GnomeController {

	private static Logger logger = LoggerFactory.getLogger(GnomeController.class);

	@Autowired
	private GnomeService gnomeService;

	@Autowired
	private JsonObjMapper JsonObjMapper;

	@GetMapping
	public ModelAndView getGnomeList() {
		ModelAndView model = null;
		try {
			BrastlewarkListDto gnomeTown = gnomeService.getInitBrastlewark();
			model = new ModelAndView("gnome");
			model.addObject("gnomes", gnomeTown);
			return model; 

		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ModelAndView("error/403");
		}
	}
}
