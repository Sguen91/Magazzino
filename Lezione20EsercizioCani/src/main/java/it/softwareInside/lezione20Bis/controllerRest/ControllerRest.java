package it.softwareInside.lezione20Bis.controllerRest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import it.softwareInside.lezione20Bis.model.Cane;

@RestController
public class ControllerRest {

	@GetMapping("/cane")
	public Cane getCaneRandom() {
		
		RestTemplate restTemplate = new RestTemplate();
		Cane risCane = restTemplate.getForObject("https://random.dog/woof.json", Cane.class);
		
		System.out.println(risCane);
		
		return risCane;
	}
	
}
