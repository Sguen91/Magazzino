package it.softwareInside.MagazzinoStore.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.softwareInside.MagazzinoStore.models.Item;

import it.softwareInside.MagazzinoStore.service.ItemService;

@RestController
public class ControllerRest {
	
	@Autowired
	ItemService itemService;

	@DeleteMapping("/delete")
	public Item delete(@RequestParam int id) {
		
		return itemService.deleteItem(id);
	}
	
	@PostMapping("/add")
	public boolean createItems(@RequestBody Item item) {
		
		return itemService.addItems(item);
	}
	
	@DeleteMapping("/deleteAll")
	public boolean deleteAll() {
		return itemService.deleteAllItems();
	}
	
	@PostMapping("/update")
	public boolean updateItems(@RequestBody Item item) {
		
		return itemService.update(item);
	}
	
	@GetMapping("/somma")
	public double getSum() {
		return itemService.calcolaValoreTotaleMagazzino();
	}
	
	
}
