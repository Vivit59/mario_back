/**
 *
 */
package fr.idformation.mario.core.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.idformation.mario.core.domain.Pizza;
import fr.idformation.mario.core.dto.PizzaDTO;

/**
 * the mapper of the pizza.
 */
public class PizzaMapper {

	/**
	 * Create a pizzaDTO from a pizza.
	 * @param pizza
	 * @return a pizza turned into its sibling pizzaDTO
	 */
	public static PizzaDTO pizzaToDto(final Pizza pizza) {
		PizzaDTO dto = null;
		if (pizza != null) {
			dto = new PizzaDTO();

			dto.setId(pizza.getId());
			dto.setName(pizza.getName());
			dto.setDescription(pizza.getDescription());
			dto.setImage(pizza.getImage());
			dto.setPrice(pizza.getPrice());
		}
		return dto;
	}

	/**
	 * Create a list of PizzaDTO from a list of pizzas.
	 * @param pizzas a list of pizzas
	 * @return a list of pizzas turned into its sibling list of pizzaDTOs
	 */
	public static List<PizzaDTO> pizzasToDtos (final List<Pizza> pizzas){
		List<PizzaDTO> dtos = null;

		if(pizzas != null) {
			dtos = new ArrayList<PizzaDTO>();
			for (Pizza pizza:pizzas) {
				dtos.add(pizzaToDto(pizza));
			}
		}
		return dtos;
	}

	/**
	 * Create a pizza from a PizzaDTO.
	 * @param dto the dto used as a source
	 * @return a pizza filled with datas from dto
	 */
	public static Pizza dtoToEntity(final PizzaDTO dto) {
		Pizza entity = null;

		if (dto != null) {
			entity = new Pizza();
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			entity.setDescription(dto.getDescription());
			entity.setImage(dto.getImage());
			entity.setPrice(dto.getPrice());
		}
		return entity;
	}
}
