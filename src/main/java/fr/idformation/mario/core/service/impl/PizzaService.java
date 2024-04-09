/**
 * 
 */
package fr.idformation.mario.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.idformation.mario.core.domain.Pizza;
import fr.idformation.mario.core.repository.IPizzaRepository;
import fr.idformation.mario.core.service.IPizzaService;

/**
 * 
 */
@Service
public final class PizzaService implements IPizzaService {

	@Autowired
	private IPizzaRepository pizRepo;
	
	@Override
	public List<Pizza> getAllPizzas() {
		return pizRepo.findAll();
	}

}
