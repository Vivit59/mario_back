/**
 * Sylvie.
 */
package fr.idformation.mario.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.idformation.mario.core.dto.PizzaDTO;
import fr.idformation.mario.core.dto.mapper.PizzaMapper;
import fr.idformation.mario.core.service.IPizzaService;

/**
 * a controller for the pizzas.
 */
@RestController
@RequestMapping("/pizza")
public class PizzaController {

	/** pizza service. */
	@Autowired
	private IPizzaService piz;

	/**
	 *
	 * @return all the pizzas
	 */
	@GetMapping("/")
	public List<PizzaDTO> getAll(){
		return PizzaMapper.pizzasToDtos(piz.getAllPizzas());
	}
}
