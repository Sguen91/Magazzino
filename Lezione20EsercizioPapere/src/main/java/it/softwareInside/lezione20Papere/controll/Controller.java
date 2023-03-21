package it.softwareInside.lezione20Papere.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.softwareInside.lezione20Papere.model.Papera;
import it.softwareInside.lezione20Papere.service.PapereService;

@RestController
public class Controller {
	
	@Autowired
	PapereService paperaService;
	@GetMapping("/papera")
	public Papera papera() {
		return paperaService.getPapera();
	}
}
