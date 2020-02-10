package com.b2w.swepisodeb2w.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.b2w.swepisodeb2w.model.Planet;

public interface PlanetRepository extends MongoRepository<Planet, Long> {
	
	Planet findByNameIgnoreCaseContainingOrderByNameDesc(String name);
}
