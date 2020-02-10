package com.b2w.swepisodeb2w.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b2w.swepisodeb2w.model.Planet;
import com.b2w.swepisodeb2w.service.PlanetCRUDService;
import com.b2w.swepisodeb2w.utils.LibraryFunctions;
import com.b2w.swepisodeb2w.utils.Message;

@RestController
@RequestMapping("/planets")
public class PlanetResource {
	
	@Autowired
	private PlanetCRUDService planetService;
	
	private List<Message> save(Planet planet) {
		planetService.createOrUpdate(planet);
		return planetService.getMessages();
		
	}
	
	@PostMapping()
	public ResponseEntity<List<Message>> create(@RequestBody Planet planet) {
		List<Message> messages = new ArrayList<Message>();
		try {
			messages = save(planet);
			if (LibraryFunctions.hasFatalError(messages)) {
				return ResponseEntity.badRequest().body(messages);
			} else {
				return ResponseEntity.ok(messages);
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(messages);
		}
	}
	
	@GetMapping(value = "/{id}")
    public Planet findById(@PathVariable Long id) {
		Optional<Planet> planet = planetService.findById(id);
		return planet.get();
    }
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		try {
			planetService.delete(id);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro na exclusão do registro:" + e.getMessage());
		}
		return ResponseEntity.ok("Exclusão realizada com sucesso!");
	}
	
	@GetMapping
    public Planet findByName(@RequestParam(required = true) String name) {
		return planetService.findByName(name);
    }
	
	@GetMapping(value = "/")
    public  List<Planet> findAll() {
		List<Planet> planets = planetService.findAll();
		return planets;
    }
    
}
