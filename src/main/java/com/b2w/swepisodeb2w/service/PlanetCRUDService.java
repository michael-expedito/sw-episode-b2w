package com.b2w.swepisodeb2w.service;

import java.util.List;
import java.util.Optional;

import com.b2w.swepisodeb2w.model.Planet;
import com.b2w.swepisodeb2w.utils.Message;

public interface PlanetCRUDService {
	
	Planet findByName(String name);
	Planet createOrUpdate(Planet planet);
	Optional<Planet> findById(Long id) ;
	void delete(Long id);
	List<Planet> findAll();
	List<Message> getMessages();
}
