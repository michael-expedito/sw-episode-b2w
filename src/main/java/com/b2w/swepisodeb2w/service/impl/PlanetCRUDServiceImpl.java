package com.b2w.swepisodeb2w.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.b2w.swepisodeb2w.model.Planet;
import com.b2w.swepisodeb2w.repository.PlanetRepository;
import com.b2w.swepisodeb2w.service.PlanetCRUDService;
import com.b2w.swepisodeb2w.service.PlanetValidationCRUDService;
import com.b2w.swepisodeb2w.service.SequenceGeneratorService;
import com.b2w.swepisodeb2w.utils.LibraryFunctions;
import com.b2w.swepisodeb2w.utils.Message;

@Service
public class PlanetCRUDServiceImpl implements PlanetCRUDService {

	@Autowired
	private PlanetRepository planetRepository;
	@Autowired
	private SequenceGeneratorService sequenceGenerator;
	@Autowired
	private PlanetValidationCRUDService planetValidationCRUDService;

	List<Message> messages;

	public Planet findByName(String name) {
		return this.planetRepository.findByNameIgnoreCaseContainingOrderByNameDesc(name);
	}

	public Planet createOrUpdate(Planet planet) {
		messages = this.planetValidationCRUDService.validate(planet);
		if (!LibraryFunctions.hasFatalError(messages)) { 
		if (planet.getId() == null 
				|| planet.getId() < 1) {
			planet.setId(sequenceGenerator.generateSequence(Planet.SEQUENCE_NAME));
        }
			return this.planetRepository.save(planet);
		} else {
			return null;
		}
	}

	public Optional<Planet> findById(Long id) {
		return this.planetRepository.findById(id);
	}

	public void delete(Long id) {
		this.planetRepository.deleteById(id);
	}

	public List<Planet> findAll() {
		return this.planetRepository.findAll(Sort.by("name"));
	}

	@Override
	public List<Message> getMessages() {
		return messages;
	}
}
