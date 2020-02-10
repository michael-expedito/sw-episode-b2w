package com.b2w.swepisodeb2w.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.b2w.swepisodeb2w.model.Planet;
import com.b2w.swepisodeb2w.service.PlanetValidationCRUDService;
import com.b2w.swepisodeb2w.utils.Message;
import com.b2w.swepisodeb2w.utils.TypeMessage;

@Service
public class PlanetValidationCRUDServiceImpl implements PlanetValidationCRUDService {

	@Override
	public List<Message> validate(Planet planet) {
		List<Message> messages = new ArrayList<>();
		if (planet.getName() == null || planet.getName().equals("")) {
			messages.add(new Message("É obrigatório informar o nome do planeta", TypeMessage.error));
		}
		if (planet.getClimate() == null || planet.getClimate().equals("")) {
			messages.add(new Message("É obrigatório informar o clima do planeta", TypeMessage.error));
		}
		if (planet.getTerrain() == null || planet.getTerrain().equals("")) {
			messages.add(new Message("É obrigatório informar o terreno do planeta", TypeMessage.error));
		}
		return messages;
	}

}
