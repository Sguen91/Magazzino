package it.softwareInside.lezione20Bis.service;

import java.util.ArrayList;

import org.springframework.web.client.RestTemplate;

import it.softwareInside.lezione20Bis.model.Gatto;




@org.springframework.stereotype.Service
public class MeowService {

	public String getMeow() {

		RestTemplate restTemplate = new RestTemplate();

		Gatto ris = restTemplate.getForObject("https://meowfacts.herokuapp.com/", Gatto.class);

		return ris.getData().get(0);
	}

	public ArrayList<String> createMeow(int numeroMeow) {

		ArrayList<String> risArrayList = new ArrayList<>();

		for (int i = 0; i < numeroMeow; i++) {
			risArrayList.add(getMeow());
		}

		return risArrayList;
	}

	// curl https://meowfacts.herokuapp.com/?lang=ukr&count=3

	public Gatto getMeowByLanguage(String lang, int contMeow) {

		try {

			String uString = "https://meowfacts.herokuapp.com/?lang=" + lang + "&count=" + contMeow;
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForObject(uString, Gatto.class);

		} catch (Exception e) {
			return null;
		}

	}

	// https://meowfacts.herokuapp.com/?count=3

	public Gatto getSomeMeow(int numeroMeow) {

		RestTemplate restTemplate = new RestTemplate();

		String urlString = "https://meowfacts.herokuapp.com/?count=" + numeroMeow;

		Gatto ris = restTemplate.getForObject(urlString, Gatto.class);

		return ris;

	}
}