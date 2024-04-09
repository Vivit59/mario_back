/**
 *
 */
package fr.idformation.mario.core.service;

import java.util.List;

import fr.idformation.mario.core.domain.Pizza;

/**
 *
 */
public interface IPizzaService {

	/**
	 * method to get all pizzas.
	 * @return all the pizzas
	 */
	List<Pizza> getAllPizzas();

}
