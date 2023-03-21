package it.softwareInside.MagazzinoStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.softwareInside.MagazzinoStore.models.Item;
import it.softwareInside.MagazzinoStore.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;

	/*
	 * metodo per creare un nuovo item nel database
	 * prende come parametro un oggetto di tipo item,
	 * ritorna true se l'aggiunge e false se l'oggetto è null. 
	 */
	public boolean addItems(Item item) {	
		if(item == null)
			return false;
		
		try {
			
			itemRepository.save(item);
			
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	/*
	 * metodo per cancellare l'item.
	 * prende in ingresso l'id 
	 * 
	 * 
	 */
	public Item deleteItem(int id) {
		
		Item item = itemRepository.findById(id).get();
		
		try {
			itemRepository.deleteById(id);
			
			return item;
			
		} catch (Exception e) {
			return null;
		}		
	}
	
	public boolean deleteAllItems() {
		
		try {
			
			itemRepository.deleteAll();
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	/*
	 * metodo per modificare l'item creato 
	 * passando l'oggetto item come parametro
	 */
	public boolean update(Item item) {
		return addItems(item);
	}
	/*
	 * metodo per trovare un item dall'id
	 */
	public Item getItemById(int id) {
		try {
			return itemRepository.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Iterable<Item> getAllData(){
		return itemRepository.findAll();
	}
	/*
	 * metodo per sommare il costo di ogni item 
	 * usando un ciclo sfruttando il metodo .findAll
	 * 
	 */
	public double calcolaValoreTotaleMagazzino() {
		
		double sommaTotale=0;
		
		for ( Item item : itemRepository.findAll()) {
			sommaTotale+=item.getCosto();
		}
		return sommaTotale;
	}
	
	
	
	
}
