/**
 * author Sylvie.
 */
package fr.idformation.mario;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import fr.idformation.mario.core.domain.Pizza;
import fr.idformation.mario.core.dto.PizzaDTO;
import fr.idformation.mario.core.dto.mapper.PizzaMapper;

/**
 * Tests for PizzaMapper.
 */
public class PizzaMapperTest {

	/** Test to convert null to dto. */
	@Test
    public void convertNullToDto() {
        // given
        Pizza pizza = null;

        // when
        PizzaDTO dto = PizzaMapper.pizzaToDto(pizza);

        // then
        assertThat(dto).isNull();
    }

	/** Test convert a pizza into a dto. */
	@Test
    public void convertPizzaToDto() {

		// given
        Pizza pizza = new Pizza();
        pizza.setId((short) 1);

        // when
        PizzaDTO dto = PizzaMapper.pizzaToDto(pizza);

        // then
        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(pizza.getId());

    }

	/** Test to convert a nullList to a dtoList. */
	@Test
    public void convertNullListToDtoList() {
        // given
        List<Pizza> pizzas = null;

        // when
        List<PizzaDTO> dtos = PizzaMapper.pizzasToDtos(pizzas);

        // then
        assertThat(dtos).isNull();
    }

	/** Test convert a pizzaList to a dtoList. */
	@Test
    public void convertPizzaListToDtoList() {
        // given
        List<Pizza> pizzas = new ArrayList<>();
        Pizza pizza = new Pizza();
        pizza.setId((short) 1);
        pizzas.add(pizza);

        // when
        List<PizzaDTO> dtos = PizzaMapper.pizzasToDtos(pizzas);

        // then
        assertThat(dtos).isNotNull();
        assertThat(dtos).hasSize(pizzas.size());
    }

    /** Test to call the default constructor. */
	@Test
    public void callDefaultConstructor() {
    	//given

    	//when
    	PizzaMapper pizzamapper = new PizzaMapper();

    	// then
    	assertThat(pizzamapper).isInstanceOf(PizzaMapper.class);
    }
}
