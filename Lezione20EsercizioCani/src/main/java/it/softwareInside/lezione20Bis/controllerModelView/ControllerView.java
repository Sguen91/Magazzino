package it.softwareInside.lezione20Bis.controllerModelView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import it.softwareInside.lezione20Bis.model.Cane;

@Controller
public class ControllerView {
	
	
	@GetMapping("/cane-Random")
	
	public ModelAndView getCane() {
		
		ModelAndView modelAndView = new ModelAndView("cane-Random");
		
		RestTemplate restTemplate = new RestTemplate();
		
		Cane risCane = restTemplate.getForObject("https://random.dog/woof.json", Cane.class);
		
		modelAndView.addObject("immagineCane", risCane.getUrl());
		
		return modelAndView;
	}
}
