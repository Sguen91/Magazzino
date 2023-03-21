package it.softwareInside.lezione20Bis.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.softwareInside.lezione20Bis.model.Gatto;
import it.softwareInside.lezione20Bis.service.MeowService;

@RestController
public class Controller {

	@Autowired
	MeowService meowService;

	@GetMapping("/meow")
	public String showMeow() {

		return meowService.getMeow();
	}

	@GetMapping("/get-some-meow")
	public Gatto getSomeMeowByInput(@RequestParam("n") int numeroDiMeow) {

		return meowService.getSomeMeow(numeroDiMeow);
	}

	@GetMapping("/meow-by-lang")
	public Gatto getMeowByLanguage(@RequestParam("l") String linguaString, @RequestParam("c") int cont) {

		return meowService.getMeowByLanguage(linguaString, cont);
	}

}
