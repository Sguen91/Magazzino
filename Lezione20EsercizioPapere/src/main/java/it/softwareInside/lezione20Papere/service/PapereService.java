package it.softwareInside.lezione20Papere.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.softwareInside.lezione20Papere.model.Papera;

@Service
public class PapereService {

	public Papera getPapera() {
		
		RestTemplate restTemplate=new RestTemplate();
		
		Papera risPapera= restTemplate.getForObject("https://random-d.uk/api/v2/random", Papera.class);
		
		return risPapera;
	}
}
