package com.b2w.swepisodeb2w.service;

import java.util.List;

import com.b2w.swepisodeb2w.model.Planet;
import com.b2w.swepisodeb2w.utils.Message;

public interface PlanetValidationCRUDService {

	List<Message> validate(Planet planet);
}
